import http from 'node:http';
import fs from 'node:fs';
import path from 'node:path';
import { chromium } from 'file:///C:/Users/NB-26062423/AppData/Local/Temp/hannah-board-ui-test/node_modules/playwright/index.mjs';

const root = path.resolve('src/main/resources/static');
const screenshotDir = path.resolve('docs/tests/screenshots/login-v1');
fs.mkdirSync(screenshotDir, { recursive: true });

const server = http.createServer((request, response) => {
    const requestPath = request.url === '/' ? '/login.html' : request.url;
    const filePath = path.resolve(root, `.${requestPath}`);
    if (!filePath.startsWith(root)) {
        response.writeHead(403);
        response.end();
        return;
    }
    fs.readFile(filePath, (error, data) => {
        if (error) {
            response.writeHead(404);
            response.end();
            return;
        }
        const contentType = filePath.endsWith('.css') ? 'text/css; charset=utf-8' : 'text/html; charset=utf-8';
        response.writeHead(200, { 'Content-Type': contentType });
        response.end(data);
    });
});

const listen = () => new Promise(resolve => server.listen(4174, '127.0.0.1', resolve));
const browser = await chromium.launch({ headless: true });
await listen();

try {
    for (const viewport of [
        { name: 'mobile', width: 390, height: 844 },
        { name: 'desktop', width: 1440, height: 900 }
    ]) {
        const page = await browser.newPage({ viewport: { width: viewport.width, height: viewport.height } });
        await page.goto('http://127.0.0.1:4174/', { waitUntil: 'networkidle' });
        await page.screenshot({ path: path.join(screenshotDir, `login-${viewport.name}.png`), fullPage: true });

        if (await page.evaluate(() => document.documentElement.scrollWidth > window.innerWidth)) throw new Error(`${viewport.name} has horizontal overflow`);
        if (await page.locator('form').getAttribute('action') !== '/login') throw new Error('login action mismatch');
        if (await page.locator('form').getAttribute('method') !== 'post') throw new Error('login method mismatch');
        for (const selector of ['#username', '#password']) {
            if (!(await page.locator(selector).getAttribute('required')) === '') throw new Error(`${selector} is not required`);
        }
        if (await page.locator('#username').getAttribute('autocomplete') !== 'username') throw new Error('username autocomplete mismatch');
        if (await page.locator('#password').getAttribute('autocomplete') !== 'current-password') throw new Error('password autocomplete mismatch');
        if (await page.locator('.form-footer a').getAttribute('href') !== '/signup') throw new Error('signup link mismatch');

        if (viewport.name === 'mobile') {
            await page.locator('.menu-button').click();
            await page.waitForTimeout(220);
            if (await page.locator('.menu-button').getAttribute('aria-expanded') !== 'true') throw new Error('menu did not open');
            await page.screenshot({ path: path.join(screenshotDir, 'login-mobile-menu.png') });
            await page.keyboard.press('Escape');
            if (await page.locator('.menu-button').getAttribute('aria-expanded') !== 'false') throw new Error('menu did not close with Escape');
        }
        await page.close();
    }
    console.log('LOGIN_UI_TEST_PASS');
} finally {
    await browser.close();
    server.close();
}
