import java.util.*;

//정수삼각형
static class Solution {
    static int N;
    public int solution(int[][] triangle) {
        N = triangle.length;

        int [][] dp = new int[N][N];

        dp[0][0] = triangle[0][0];
        for (int r = 1; r < N; r++) {
            for (int c = 0; c <= r; c++) {
                if (c == 0) {
                    dp[r][c] = dp[r-1][0] + triangle[r][c];
                }
                else if (c == r) {
                    dp[r][c] = dp[r-1][c-1] + triangle[r][c];
                }
                else {
                    dp[r][c] = Math.max(dp[r-1][c-1], dp[r-1][c]) + triangle[r][c];
                }
            }
        }

        return Arrays.stream(dp[N-1]).max().getAsInt();
    }
}
