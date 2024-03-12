//타겟넘버
static class Solution {
    static int target;
    static int answer = 0;
    public int solution(int[] numbers, int target) {
        this.target = target;

        dfs(numbers, 0, 0, 0);

        return answer;
    }

    static void dfs(int[] numbers, int sum, int length, int cursor) {
        if (length == numbers.length) {
            if (sum == target) answer++;
            return;
        }

        dfs(numbers, sum + numbers[cursor], length + 1, cursor + 1);
        dfs(numbers, sum - numbers[cursor], length + 1, cursor + 1);
    }
}
