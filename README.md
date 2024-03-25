# 프로그래머스 알고리즘 스터디

## 회차별 학습 내용
|회차|문제 목록|출제자|
|------|---|---|
|1회차|[Lv2. 타겟 넘버](https://school.programmers.co.kr/learn/courses/30/lessons/43165)<br>[Lv3. 정수 삼각형](https://school.programmers.co.kr/learn/courses/30/lessons/43105)|히데짱|
|2회차|[Lv2. 카펫](https://school.programmers.co.kr/learn/courses/30/lessons/42842)<br>[Lv3. 산 모양 타일링](https://school.programmers.co.kr/learn/courses/30/lessons/258705) |박현제|
|3회차|[Lv2. 양궁대회](https://school.programmers.co.kr/learn/courses/30/lessons/92342)<br>[Lv2. 주차 요금 계산](https://school.programmers.co.kr/learn/courses/30/lessons/92341)|박건우|
|4회차|[Lv2. 큰 수 만들기](https://school.programmers.co.kr/learn/courses/30/lessons/42883)<br>[Lv2. 더 맵게](https://school.programmers.co.kr/learn/courses/30/lessons/42626)|히데짱|
<br><br>

## 진행 방식
매주 최소 4 ~ 5문제씩 문제를 푸는 것을 목표로 합니다.<br>
난이도는 골고루 섞어서 (주로 Level 2 ~ 3, 도전하고 싶으면 Level 4도 가능)<br>
이때 어려운 문제가 있으면 2개로, 그렇지 않으면 3개를 푸는 것으로 합니다. <br><br>
풀이한 문제에 대한 정리는 자유 (개인 블로그, 노션, 마크다운 등)<br>
매주 화, 토요일 22시에 게더타운에서 이번 회차 문제에 대한 풀이를 진행합니다.<br>
모임 시간 전까지 이 레포로 PR을 보내야 정상 제출로 간주합니다.<br>

발표자는 자신의 풀이 과정(+시간 복잡도 등)에 관하여 설명합니다.<br><br><br>

## 문제 선정
해당 회차 담당자가 최소 2 ~ 3문제를 선정하여 README.md에 올립니다.<br>
순서: 히데짱 → 박현제 → 박건우<br><br>


### 문제 유형
- 완전탐색(DFS/BFS/백트래킹)
- 다이나믹 프로그래밍(동적계획법)
- 그래프
- 그리디
- 이분 탐색
- 구현, 시뮬레이션
- 스택, 큐, 우선순위 큐, 힙

<br><br>

## 폴더링 & PR 작성 규칙
기본적으로 자신의 이름으로 branch를 따서 진행합니다.<br>
해당 회차 폴더(예: round0x) 아래에 자신의 이름으로 폴더를 생성합니다.<br>
그 폴더 안에 이번 회차에 풀이한 문제들을 넣고 자신의 branch로 push한 다음, main 브랜치로 PR을 보냅니다.<br>
파일 이름은 다음과 같이 작성해주세요.<br><br>

회차 폴더 이름(패키지명)은 round0x 로 작성해주세요.<br>
ex) round01

문제 이름.java<br>
ex) 타겟_넘버.java<br><br>

PR을 머지할 때 깔끔한 처리를 위해 Squash Merge를 하고,<br>
PR 제목은 [해당 회차] 문제 이름 - 작성자 로 작성해주세요.<br>
ex) [1회차] 타겟 넘버 - 박현제<br><br>

PR 내용은 문제 풀이 방법과 푸는데 걸린 시간 등을 기재하기<br><br><br>

## 커밋 메시지 컨벤션
[상태] 문제 이름 - 풀이한 사람 이름<br>
[Success] : 풀이 성공<br>
[Failed] : 풀이 실패 (코드 작성한 것은 올리기)<br><br>

ex) [Success] 정수 삼각형 - 히데짱<br>
ex) [Failed] 타겟 넘버 - 박건우
