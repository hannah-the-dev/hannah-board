import http from 'node:http';
import fs from 'node:fs';
import path from 'node:path';
import { chromium } from 'file:///C:/Users/NB-26062423/AppData/Local/Temp/hannah-board-ui-test/node_modules/playwright/index.mjs';

const root = path.resolve('src/main/resources/static');
const screenshotDir = path.resolve('docs/tests/screenshots/myinfo-v1');
fs.mkdirSync(screenshotDir, { recursive: true });
const server = http.createServer((request, response) => {
    const requestPath = request.url === '/' ? '/myinfo.html' : request.url;
    const filePath = path.resolve(root, `.${requestPath}`);
    if (!filePath.startsWith(root)) return response.writeHead(403).end();
    fs.readFile(filePath, (error, data) => {
        if (error) return response.writeHead(404).end();
        response.writeHead(200, { 'Content-Type': filePath.endsWith('.css') ? 'text/css; charset=utf-8' : 'text/html; charset=utf-8' });
        response.end(data);
    });
});
const browser = await chromium.launch({ headless: true });
await new Promise(resolve => server.listen(4176, '127.0.0.1', resolve));

try {
    for (const viewport of [{ name: 'mobile', width: 390, height: 844 }, { name: 'desktop', width: 1440, height: 900 }]) {
        const page = await browser.newPage({ viewport: { width: viewport.width, height: viewport.height } });
        await page.goto('http://127.0.0.1:4176/', { waitUntil: 'networkidle' });
        await page.screenshot({ path: path.join(screenshotDir, `myinfo-${viewport.name}.png`), fullPage: true });
        if (await page.evaluate(() => document.documentElement.scrollWidth > window.innerWidth)) throw new Error(`${viewport.name} has horizontal overflow`);
        for (const text of ['1', 'hannah', 'USER', 'NORMAL', '2026-10-01 09:00:00']) {
            if (!(await page.locator('.profile-card').getByText(text, { exact: true }).count())) throw new Error(`missing UserResponse value: ${text}`);
        }
        if ((await page.locator('body').textContent()).toLowerCase().includes('password')) throw new Error('password should not be displayed');
        if (await page.locator('.text-link').getAttribute('href') !== '/board/list') throw new Error('board link mismatch');
        if (viewport.name === 'mobile') {
            await page.locator('.menu-button').click();
            await page.waitForTimeout(220);
            await page.screenshot({ path: path.join(screenshotDir, 'myinfo-mobile-menu.png') });
            if (await page.locator('.menu-button').getAttribute('aria-expanded') !== 'true') throw new Error('menu did not open');
            await page.keyboard.press('Escape');
            if (await page.locator('.menu-button').getAttribute('aria-expanded') !== 'false') throw new Error('menu did not close');
        }
        await page.close();
    }
    console.log('MYINFO_UI_TEST_PASS');
} finally {
    await browser.close();
    server.close();
}
