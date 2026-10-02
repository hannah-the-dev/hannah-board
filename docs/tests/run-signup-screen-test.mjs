import http from 'node:http';
import fs from 'node:fs';
import path from 'node:path';
import { chromium } from 'file:///C:/Users/NB-26062423/AppData/Local/Temp/hannah-board-ui-test/node_modules/playwright/index.mjs';

const root = path.resolve('src/main/resources/static');
const screenshotDir = path.resolve('docs/tests/screenshots/signup-v1');
fs.mkdirSync(screenshotDir, { recursive: true });
const server = http.createServer((request, response) => {
    const requestPath = request.url === '/' ? '/signup.html' : request.url;
    const filePath = path.resolve(root, `.${requestPath}`);
    if (!filePath.startsWith(root)) return response.writeHead(403).end();
    fs.readFile(filePath, (error, data) => {
        if (error) return response.writeHead(404).end();
        response.writeHead(200, { 'Content-Type': filePath.endsWith('.css') ? 'text/css; charset=utf-8' : 'text/html; charset=utf-8' });
        response.end(data);
    });
});
const browser = await chromium.launch({ headless: true });
await new Promise(resolve => server.listen(4175, '127.0.0.1', resolve));

try {
    for (const viewport of [{ name: 'mobile', width: 390, height: 844 }, { name: 'desktop', width: 1440, height: 900 }]) {
        const page = await browser.newPage({ viewport: { width: viewport.width, height: viewport.height } });
        await page.route('**/check-username*', route => route.fulfill({ status: 200, contentType: 'application/json', body: 'false' }));
        await page.goto('http://127.0.0.1:4175/', { waitUntil: 'networkidle' });
        await page.screenshot({ path: path.join(screenshotDir, `signup-${viewport.name}.png`), fullPage: true });
        if (await page.evaluate(() => document.documentElement.scrollWidth > window.innerWidth)) throw new Error(`${viewport.name} has horizontal overflow`);
        if (await page.locator('form').getAttribute('action') !== '/signup') throw new Error('signup action mismatch');
        if (await page.locator('form').getAttribute('method') !== 'post') throw new Error('signup method mismatch');
        if (!(await page.locator('#signupButton').isDisabled())) throw new Error('signup button should start disabled');
        await page.locator('#username').fill('hannah');
        if (!(await page.locator('#signupButton').isDisabled())) throw new Error('signup button should reset after input');
        await page.locator('#checkUsernameButton').click();
        await page.waitForFunction(() => document.querySelector('#usernameMessage').textContent === '사용 가능한 아이디입니다.');
        if (await page.locator('#signupButton').isDisabled()) throw new Error('available username did not enable signup');
        if (await page.locator('#usernameMessage').textContent() !== '사용 가능한 아이디입니다.') throw new Error('username success message mismatch');
        if (viewport.name === 'mobile') {
            await page.locator('.menu-button').click();
            await page.waitForTimeout(220);
            await page.screenshot({ path: path.join(screenshotDir, 'signup-mobile-menu.png') });
            if (await page.locator('.menu-button').getAttribute('aria-expanded') !== 'true') throw new Error('menu did not open');
            await page.keyboard.press('Escape');
            if (await page.locator('.menu-button').getAttribute('aria-expanded') !== 'false') throw new Error('menu did not close');
        }
        await page.close();
    }
    console.log('SIGNUP_UI_TEST_PASS');
} finally {
    await browser.close();
    server.close();
}
