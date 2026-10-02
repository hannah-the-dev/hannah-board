# 인덱스 화면 테스트 시나리오 v1

## 대상

- 경로: `/`
- 화면: `src/main/resources/static/index.html`
- 범위: 반응형 레이아웃, 바로가기, 햄버거 메뉴

## 시나리오

| ID | 시나리오 | 기대 결과 |
| --- | --- | --- |
| IDX-01 | 모바일 폭에서 `/` 접속 | 콘텐츠가 한 열로 보이고 가로 스크롤이 없다. |
| IDX-02 | 데스크톱 폭에서 `/` 접속 | 바로가기 카드 3개가 한 행에 배치된다. |
| IDX-03 | 회원가입 카드 선택 | `/signup`으로 이동한다. |
| IDX-04 | 로그인 카드 선택 | `/login`으로 이동한다. |
| IDX-05 | 게시판 카드 선택 | `/board/list`로 이동한다. |
| IDX-06 | 햄버거 버튼 선택 | 좌측 메뉴와 오버레이가 열리고 `aria-expanded=true`가 된다. |
| IDX-07 | 오버레이 또는 `Esc` 선택 | 좌측 메뉴가 닫히고 `aria-expanded=false`가 된다. |
| IDX-08 | 키보드로 주요 링크 접근 | 포커스 표시가 있고 링크를 실행할 수 있다. |

## 테스트 환경

- 모바일: 390 x 844
- 데스크톱: 1440 x 900
- 브라우저: Chromium 기반 브라우저
- 검증물: 각 viewport 스크린샷 및 시나리오 결과

## 실행 결과

테스트 실행 후 아래 표에 결과를 기록하고, 스크린샷은 `docs/tests/screenshots/index-v1/`에 저장한다.

| ID | 결과 | 비고 |
| --- | --- | --- |
| IDX-01 | 통과 | 모바일 390 x 844, 가로 스크롤 없음 |
| IDX-02 | 통과 | 데스크톱 1440 x 900, 카드 3열 배치 |
| IDX-03 | 통과 | `/signup` 링크 확인 |
| IDX-04 | 통과 | `/login` 링크 확인 |
| IDX-05 | 통과 | `/board/list` 링크 확인 |
| IDX-06 | 통과 | 메뉴 클래스 및 `aria-expanded` 확인 |
| IDX-07 | 통과 | `Esc` 닫기 확인 |
| IDX-08 | 통과 | 포커스 가능한 링크 구조 확인 |

상세 결과: [index-screen-test-report-v1.md](index-screen-test-report-v1.md)

테마 변경 재검증: [index-screen-test-report-v2.md](index-screen-test-report-v2.md)

흰색 배경 재검증: [index-screen-test-report-v3.md](index-screen-test-report-v3.md)

라벤더 테마 재검증: [index-screen-test-report-v4.md](index-screen-test-report-v4.md)
