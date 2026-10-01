import http from 'node:http';
import fs from 'node:fs';
import path from 'node:path';
import { chromium } from 'file:///C:/Users/NB-26062423/AppData/Local/Temp/hannah-board-ui-test/node_modules/playwright/index.mjs';

const root = path.resolve('src/main/resources/static');
const screenshotDir = path.resolve('docs/tests/screenshots/index-v1');
fs.mkdirSync(screenshotDir, { recursive: true });

const server = http.createServer((request, response) => {
    const requestPath = request.url === '/' ? '/index.html' : request.url;
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

const listen = () => new Promise(resolve => server.listen(4173, '127.0.0.1', resolve));

const browser = await chromium.launch({ headless: true });
await listen();

try {
    for (const viewport of [
        { name: 'mobile', width: 390, height: 844 },
        { name: 'desktop', width: 1440, height: 900 }
    ]) {
        const page = await browser.newPage({ viewport: { width: viewport.width, height: viewport.height } });
        await page.goto('http://127.0.0.1:4173/', { waitUntil: 'networkidle' });
        await page.screenshot({ path: path.join(screenshotDir, `index-${viewport.name}.png`), fullPage: true });

        const links = await page.locator('.shortcut-card').evaluateAll(elements => elements.map(element => element.getAttribute('href')));
        if (links.join(',') !== '/signup,/login,/board/list') throw new Error(`shortcut links mismatch: ${links}`);
        if (await page.evaluate(() => document.documentElement.scrollWidth > window.innerWidth)) throw new Error(`${viewport.name} has horizontal overflow`);

        if (viewport.name === 'mobile') {
            await page.locator('.menu-button').click();
            if (await page.locator('.menu-button').getAttribute('aria-expanded') !== 'true') throw new Error('menu did not open');
            await page.waitForTimeout(220);
            await page.screenshot({ path: path.join(screenshotDir, 'index-mobile-menu.png') });
            await page.keyboard.press('Escape');
            if (await page.locator('.menu-button').getAttribute('aria-expanded') !== 'false') throw new Error('menu did not close with Escape');
        }
        await page.close();
    }
    console.log('INDEX_UI_TEST_PASS');
} finally {
    await browser.close();
    server.close();
}
