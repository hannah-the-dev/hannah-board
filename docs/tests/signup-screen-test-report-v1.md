# 회원가입 화면 테스트 리포트 v1

## 결과

**통과** — 2026-10-01

회원가입 폼, 아이디 중복 확인 상태, 반응형 레이아웃과 메뉴를 검증했다.

## 검증 결과

- 모바일·데스크톱 레이아웃: 통과
- `POST /signup` 폼 설정: 통과
- 아이디 변경 시 가입 버튼 초기화: 통과
- 사용 가능한 아이디 응답 시 가입 버튼 활성화: 통과
- 중복 확인 결과 메시지: 통과
- 가로 스크롤 없음: 통과
- 햄버거 메뉴 및 `Esc` 닫기: 통과
- 라벤더 테마 및 흰색 배경: 통과

## 스크린샷

- [모바일](screenshots/signup-v1/signup-mobile.png)
- [데스크톱](screenshots/signup-v1/signup-desktop.png)
- [메뉴 열림](screenshots/signup-v1/signup-mobile-menu.png)

실행 결과: `SIGNUP_UI_TEST_PASS`
