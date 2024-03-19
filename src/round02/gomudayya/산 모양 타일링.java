class Solution {
    
    static int[][] dp;
    public int solution(int n, int[] tops) {
        dp = new int[3][n];
        
        //초깃값 셋팅
        dp[0][0] = 3;
        
        if (tops[0] == 1) dp[1][0] = 4;
        else dp[1][0] = dp[0][0];
        
        if (dp[1][0] == 4) dp[2][0] = 3;
        else dp[2][0] = 2;
        
        for (int i = 1; i < n; i++) {
            //dp[0][i]
            dp[0][i] = (dp[1][i-1] * 2 + dp[2][i-1]) % 10007;
            
            //dp[1][i]
            if (tops[i] == 0) dp[1][i] = dp[0][i];
            else {
                dp[1][i] = (dp[1][i-1] + dp[0][i]) % 10007;
            }
            
            //dp[2][i]
            // dp[2][i] = dp[1][i] - dp[1][i-1]; //얘가 %연산때문에 음수가 되면 안됨.
            if (tops[i] == 0) {
                dp[2][i] = (dp[1][i-1] * 2 + dp[2][i-1] - dp[1][i-1]) % 10007;
            } else {
                dp[2][i] = (dp[1][i-1] + dp[0][i] - dp[1][i-1]) % 10007;
            }
        }
        
        return dp[1][n-1];
    }
    
    static void print(int[][] arr) {
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[0].length; j++) {
                System.out.print(arr[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println();
    }
}
