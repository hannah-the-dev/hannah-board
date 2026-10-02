# 게시글 화면 테스트 시나리오 v1

| ID | 시나리오 | 기대 결과 |
| --- | --- | --- |
| POST-01 | 모바일 폭에서 게시글 접속 | 제목·본문이 화면 안에 표시되고 가로 스크롤이 없다. |
| POST-02 | 게시글 데이터 확인 | id, title, content, hits, createdAt이 표시된다. |
| POST-03 | 저장 완료 상태 확인 | 저장 완료 안내가 표시된다. |
| POST-04 | 본문 줄바꿈 확인 | 본문 줄바꿈이 보존된다. |
| POST-05 | 게시판 돌아가기 확인 | `/board/list`로 연결된다. |
| POST-06 | 햄버거 메뉴 열기·닫기 | 메뉴와 오버레이가 동작하고 `Esc`로 닫힌다. |

상세 결과: [post-screen-test-report-v1.md](post-screen-test-report-v1.md)
