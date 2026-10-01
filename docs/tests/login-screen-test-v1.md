# 로그인 화면 테스트 시나리오 v1

## 대상

- 경로: `/login`
- 화면: `src/main/resources/static/login.html`
- 범위: 반응형 폼, 입력 필드, 링크, 햄버거 메뉴

## 시나리오

| ID | 시나리오 | 기대 결과 |
| --- | --- | --- |
| LOGIN-01 | 모바일 폭에서 `/login` 접속 | 폼이 한 열로 보이고 가로 스크롤이 없다. |
| LOGIN-02 | 데스크톱 폭에서 `/login` 접속 | 폼이 읽기 쉬운 최대 폭으로 중앙 정렬된다. |
| LOGIN-03 | 아이디 입력 요소 확인 | `username`, `required`, `autocomplete=username`을 사용한다. |
| LOGIN-04 | 비밀번호 입력 요소 확인 | `password`, `required`, `autocomplete=current-password`를 사용한다. |
| LOGIN-05 | 로그인 폼 확인 | `POST /login`으로 전송하도록 구성된다. |
| LOGIN-06 | 회원가입 링크 선택 대상 확인 | `/signup`으로 연결된다. |
| LOGIN-07 | 햄버거 버튼 선택 | 좌측 메뉴와 오버레이가 열리고 `aria-expanded=true`가 된다. |
| LOGIN-08 | `Esc` 입력 | 좌측 메뉴가 닫히고 `aria-expanded=false`가 된다. |

## 테스트 환경

- 모바일: 390 x 844
- 데스크톱: 1440 x 900
- 브라우저: Chromium 기반 브라우저
- 검증물: 각 viewport 스크린샷 및 시나리오 결과

## 실행 결과

상세 결과: [login-screen-test-report-v1.md](login-screen-test-report-v1.md)

테마 변경 재검증: [login-screen-test-report-v2.md](login-screen-test-report-v2.md)

흰색 배경 재검증: [login-screen-test-report-v3.md](login-screen-test-report-v3.md)

라벤더 테마 재검증: [login-screen-test-report-v4.md](login-screen-test-report-v4.md)
