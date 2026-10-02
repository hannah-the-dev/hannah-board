# 내 정보 화면 테스트 시나리오 v1

| ID | 시나리오 | 기대 결과 |
| --- | --- | --- |
| MYINFO-01 | 모바일 폭에서 내 정보 접속 | 사용자 정보가 1열로 표시되고 가로 스크롤이 없다. |
| MYINFO-02 | 데스크톱 폭에서 내 정보 접속 | 정보 카드가 중앙에 배치된다. |
| MYINFO-03 | `UserResponse` 필드 확인 | id, username, role, status, createdAt이 표시된다. |
| MYINFO-04 | 민감정보 확인 | 비밀번호가 화면에 표시되지 않는다. |
| MYINFO-05 | 게시판 링크 선택 대상 확인 | `/board/list`로 연결된다. |
| MYINFO-06 | 햄버거 메뉴 열기·닫기 | 메뉴와 오버레이가 동작하고 `Esc`로 닫힌다. |

상세 결과: [myinfo-screen-test-report-v1.md](myinfo-screen-test-report-v1.md)
