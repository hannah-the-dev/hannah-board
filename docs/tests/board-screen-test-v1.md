# 게시판 화면 테스트 시나리오 v1

| ID | 시나리오 | 기대 결과 |
| --- | --- | --- |
| BOARD-01 | 모바일 폭에서 게시판 접속 | 게시글이 세로 카드로 표시되고 가로 스크롤이 없다. |
| BOARD-02 | 데스크톱 폭에서 게시판 접속 | 목록이 넓고 읽기 쉬운 형태로 표시된다. |
| BOARD-03 | 게시글 카드 확인 | id, title, hits, createdAt이 표시된다. |
| BOARD-04 | 글쓰기 버튼 확인 | `/post/write`로 연결된다. |
| BOARD-05 | 게시글 선택 확인 | `/post/{id}`로 연결된다. |
| BOARD-06 | 페이지네이션 확인 | 페이지 이동 링크와 현재 페이지가 표시된다. |
| BOARD-07 | 햄버거 메뉴 열기·닫기 | 메뉴와 오버레이가 동작하고 `Esc`로 닫힌다. |

상세 결과: [board-screen-test-report-v1.md](board-screen-test-report-v1.md)
