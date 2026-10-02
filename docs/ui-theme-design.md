# Hannah Board UI 테마 설계

## 방향

기존의 강한 파란색 대신 부드러운 라벤더 계열을 기본 색상으로 사용한다. 페이지 배경은 흰색으로 유지하고, 주요 버튼과 상호작용 상태에는 라벤더 계열을 사용한다.

## 색상 토큰

```css
--lavender-grey: #8e9aaf;
--thistle: #cbc0d3;
--soft-blush: #efd3d7;
--lavender-veil: #feeafa;
--lavender: #dee2ff;
--warning: #780000;
```

## 적용 기준

- 페이지 배경: 흰색 (`#ffffff`)
- 카드·폼 표면: 흰색
- 테두리: `thistle`
- 주요 버튼: `lavender`
- 버튼 호버·포커스 강조: `soft-blush`, `thistle`
- 메뉴 활성·호버 배경: `lavender-veil`
- 보조 강조 색상: `lavender-grey`
- 오류·경고 문구: `warning` (`#780000`)
- 본문 텍스트: 짙은 중성색을 유지해 가독성을 확보한다.

## 범위

이번 변경은 공통 CSS 토큰과 현재 구현된 인덱스·로그인 화면에 적용한다. 화면 구조, 폼 동작, 백엔드 코드는 변경하지 않는다.
