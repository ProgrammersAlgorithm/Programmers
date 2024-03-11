/*
유형: 백트래킹
문제: 특정 숫자들을 이용해 특정 수를 만드는 방법의 수 출력
    - +, - 연산
    - 모든 수를 다 써야함
    - 순서 바꾸기 불가
단서: 2가지 경우 선택(재귀적), 항상 같은 깊이까지
아이디어: -일 경우 +일 경우 모두 해보면 될듯
    만약 target == 현재 숫자 합 -> cnt++


알고리즘:
    //1. 입력
    numbers: 사용 가능한 숫자
    target: 목표 숫자
    answer
    //2. dfs
        dfs(sum ,depth)
            if depth == 5면 그만
                if(sum == target)
                    answer = Math.max(answer, sum )
                return
            -1을 곱해서 계산하기
            dfs(-1*numbers[depth],depth+1)
            dfs(1*numbers[depth],depth+1)


시간복잡도:
레퍼런스:
효율화:
    -리팩터링: -1과 1에 * 연산을 해줬는데 안 해줘도 됨
    -구상 속도 개선
주의:
시간:
보완: 구현
 */

class 타겟_넘버 {

    private static int answer = 0;
    private static int cnt =0;
    public int solution(int[] numbers, int target) {

        //2. dfs
        dfs(numbers, target, 0,0);
        return answer;
    }

    public static void dfs(int[] numbers, int target, int sum, int depth){
        if(depth == numbers.length){
            if(sum == target){
                answer++;
            }
            return;
        }
        dfs(numbers, target, sum+ -1*numbers[depth],depth+1);
        dfs(numbers, target, sum+ 1*numbers[depth],depth+1);
    }
}