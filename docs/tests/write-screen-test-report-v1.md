# 글쓰기 화면 테스트 리포트 v1

## 결과

**통과** — 2026-10-01

제목·내용 입력 폼과 저장 흐름의 UI 구조를 검증했다.

## 검증 결과

- 모바일·데스크톱 레이아웃: 통과
- `POST /post/save` 폼 설정: 통과
- 제목·내용 필수 입력: 통과
- 조회수 입력 필드 미노출: 통과
- 게시판 취소 링크: 통과
- 햄버거 메뉴 및 `Esc` 닫기: 통과
- 라벤더 테마 및 흰색 배경: 통과

## 스크린샷

- [모바일](screenshots/write-v1/write-mobile.png)
- [데스크톱](screenshots/write-v1/write-desktop.png)
- [메뉴 열림](screenshots/write-v1/write-mobile-menu.png)

실행 결과: `WRITE_UI_TEST_PASS`
