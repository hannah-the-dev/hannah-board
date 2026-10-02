# 게시글 화면 테스트 리포트 v1

## 결과

**통과** — 2026-10-01

저장 완료 상태와 `PostResponse` 기반 게시글 상세 UI를 검증했다.

## 검증 결과

- 모바일·데스크톱 레이아웃: 통과
- 저장 완료 안내 표시: 통과
- title, content, hits, createdAt 표시: 통과
- 본문 줄바꿈 및 긴 문장 처리: 통과
- 게시판 돌아가기 링크: 통과
- 햄버거 메뉴 및 `Esc` 닫기: 통과
- 라벤더 테마 및 흰색 배경: 통과

## 스크린샷

- [모바일](screenshots/post-v1/post-mobile.png)
- [데스크톱](screenshots/post-v1/post-desktop.png)
- [메뉴 열림](screenshots/post-v1/post-mobile-menu.png)

실행 결과: `POST_UI_TEST_PASS`
