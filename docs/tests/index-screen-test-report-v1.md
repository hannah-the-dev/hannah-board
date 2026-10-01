# 인덱스 화면 테스트 리포트 v1

## 결과

**통과** — 2026-09-30

브라우저 자동화로 모바일·데스크톱 화면과 햄버거 메뉴 동작을 검증했다.

## 환경

- Chromium: Playwright bundled Chromium
- 모바일 viewport: 390 x 844
- 데스크톱 viewport: 1440 x 900
- 대상: `http://127.0.0.1:4173/`에서 정적 인덱스 화면 제공

## 검증 항목

| 항목 | 결과 |
| --- | --- |
| 모바일 단일 열 레이아웃 | 통과 |
| 데스크톱 카드 3열 레이아웃 | 통과 |
| 회원가입·로그인·게시판 링크 | 통과 |
| 가로 스크롤 없음 | 통과 |
| 햄버거 메뉴 열기 | 통과 |
| 오버레이 표시 | 통과 |
| `Esc`로 메뉴 닫기 | 통과 |
| 키보드 접근 가능한 링크 구조 | 통과 |

## 스크린샷

- [모바일](screenshots/index-v1/index-mobile.png)
- [데스크톱](screenshots/index-v1/index-desktop.png)
- [모바일 메뉴 열림](screenshots/index-v1/index-mobile-menu.png)

## 실행 명령

```text
node docs/tests/run-index-screen-test.mjs
```

실행 결과: `INDEX_UI_TEST_PASS`
