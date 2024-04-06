/*
유형: dp
문제: 경로의 최단 거리 개수 구하기
단서: 최솟값
알고리즘:
//1. dp 초기식, 점화식 - 각 경로마다 항상 나누기 적용, 웅덩이 -1처리
// 1-1 위만 웅덩이: 위 그대로
// 1-2 왼쪽만 웅덩이: 왼 그대로
// 1-3 왼+위 웅덩이: 위+왼

//2. dp 최종 값 출력

시간복잡도: O(n*m)
틀린이유: 그림 안 그려서 헷갈림
주의: 효율성 검증 통화하려면 분기 잘 나눠줘야. 점화식 1개로 퉁치면 안됨
*/
import java.util.*;
class Solution{
    public int solution(int m, int n, int[][] puddles) {
        final int DIV = 1000000007;
        int dp [][] = new int[n+1][m+1];
        //1. dp 초기식, 점화식
        dp[1][0] = 1; // 초기식
        for(int i=0; i< puddles.length; i++){
            dp[puddles[i][1]][puddles[i][0]] = -1;
        }
        for(int i=1; i<=n; i++){
            for(int j=1; j<=m ; j++){
                if(dp[i][j] == -1){// 웅덩이면 넘어가기
                    dp[i][j] = 0;
                    continue;
                }

                if(dp[i-1][j] != 0 &&dp[i][j-1] !=0){
                    dp[i][j] = (dp[i][j-1]+dp[i-1][j])%DIV;
                }else if(dp[i-1][j] != 0){
                    dp[i][j] = dp[i-1][j]%DIV;
                }else if(dp[i][j-1] !=0){
                    dp[i][j] = dp[i][j-1]%DIV;
                }
            }
        }
        //2. dp 최종 값 출력
        return dp[n][m];
    }
}