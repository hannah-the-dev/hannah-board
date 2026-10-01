# 회원가입 화면 테스트 시나리오 v1

## 시나리오

| ID | 시나리오 | 기대 결과 |
| --- | --- | --- |
| SIGNUP-01 | 모바일 폭에서 `/signup` 접속 | 한 열 폼이며 가로 스크롤이 없다. |
| SIGNUP-02 | 데스크톱 폭에서 `/signup` 접속 | 폼이 중앙에 배치된다. |
| SIGNUP-03 | 아이디 변경 | 가입 버튼이 비활성화되고 중복 확인 안내가 보인다. |
| SIGNUP-04 | 빈 아이디로 중복 확인 | 경고 메시지가 표시된다. |
| SIGNUP-05 | 사용 가능한 아이디 중복 확인 | 가입 버튼이 활성화된다. |
| SIGNUP-06 | 폼 설정 확인 | `POST /signup`, `username`, `password` 필드를 사용한다. |
| SIGNUP-07 | 햄버거 메뉴 열기·닫기 | 메뉴와 오버레이가 동작하고 `Esc`로 닫힌다. |

상세 결과: [signup-screen-test-report-v1.md](signup-screen-test-report-v1.md)
