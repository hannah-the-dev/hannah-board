# 로그인 화면 테스트 리포트 v1

## 결과

**통과** — 2026-09-30

Chromium으로 모바일·데스크톱 화면과 로그인 폼 구조 및 햄버거 메뉴를 검증했다.

## 환경

- Chromium: Playwright bundled Chromium
- 모바일 viewport: 390 x 844
- 데스크톱 viewport: 1440 x 900
- 대상: `http://127.0.0.1:4174/`에서 정적 로그인 화면 제공

## 검증 항목

| 항목 | 결과 |
| --- | --- |
| 모바일 단일 열 레이아웃 | 통과 |
| 데스크톱 중앙 폼 레이아웃 | 통과 |
| `username` 필드 및 자동완성 | 통과 |
| `password` 필드 및 자동완성 | 통과 |
| `POST /login` 폼 설정 | 통과 |
| 회원가입 링크 | 통과 |
| 가로 스크롤 없음 | 통과 |
| 햄버거 메뉴 열기 및 오버레이 | 통과 |
| `Esc`로 메뉴 닫기 | 통과 |

## 스크린샷

- [모바일](screenshots/login-v1/login-mobile.png)
- [데스크톱](screenshots/login-v1/login-desktop.png)
- [모바일 메뉴 열림](screenshots/login-v1/login-mobile-menu.png)

## 실행 명령

```text
node docs/tests/run-login-screen-test.mjs
```

실행 결과: `LOGIN_UI_TEST_PASS`
