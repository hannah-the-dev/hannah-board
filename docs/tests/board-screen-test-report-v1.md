# 게시판 화면 테스트 리포트 v1

## 결과

**통과** — 2026-10-01

`PostResponse` 기반 게시글 목록과 반응형 게시판 UI를 검증했다.

## 검증 결과

- 모바일 카드 목록 및 가로 스크롤 없음: 통과
- 데스크톱 목록 레이아웃: 통과
- id, title, hits, createdAt 표시: 통과
- 글쓰기 링크 `/post/write`: 통과
- 게시글 링크 `/post/{id}`: 통과
- 페이지네이션: 통과
- 햄버거 메뉴 및 `Esc` 닫기: 통과
- 라벤더 테마 및 흰색 배경: 통과

## 스크린샷

- [모바일](screenshots/board-v1/board-mobile.png)
- [데스크톱](screenshots/board-v1/board-desktop.png)
- [메뉴 열림](screenshots/board-v1/board-mobile-menu.png)

실행 결과: `BOARD_UI_TEST_PASS`
