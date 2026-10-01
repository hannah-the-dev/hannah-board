# 글쓰기 화면 테스트 시나리오 v1

| ID | 시나리오 | 기대 결과 |
| --- | --- | --- |
| WRITE-01 | 모바일 폭에서 글쓰기 접속 | 폼이 세로로 배치되고 가로 스크롤이 없다. |
| WRITE-02 | 데스크톱 폭에서 글쓰기 접속 | 폼 카드가 중앙에 배치된다. |
| WRITE-03 | 입력 필드 확인 | title, content만 제공되고 hits 필드는 없다. |
| WRITE-04 | 폼 설정 확인 | `POST /post/save`로 전송된다. |
| WRITE-05 | 필수 입력 확인 | 제목·내용이 required로 설정된다. |
| WRITE-06 | 취소 링크 확인 | `/board/list`로 연결된다. |
| WRITE-07 | 햄버거 메뉴 열기·닫기 | 메뉴와 오버레이가 동작하고 `Esc`로 닫힌다. |

상세 결과: [write-screen-test-report-v1.md](write-screen-test-report-v1.md)
