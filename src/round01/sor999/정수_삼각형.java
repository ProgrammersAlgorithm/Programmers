package round01.sor999;

/*
유형: dp
문제: 여러 경로의 최댓값
단서: 위상정렬 꼴, 최댓값
아이디어: 1. 클래스 Node 만들어서 nX,nY,maxCnt만들고 돌리기
            7
            3 8
            8 1 0
            ...
            아래나 밑의 오른쪽 대각선으로 감
        2. dp 배열
            밑 기준에서 보면 위나 왼쪽 대각선에서 옴
            dp[i][j] = Math.max(dp[i-1][j],dp[i-1][j-1]) + triangle[i-1][j-1]; // dp는 0인덱스 안쓰니까

알고리즘:
    //1. 입력
    int len = triangle.length
    dp[len+1][len+1]
    //2. dp
    for(int i =1; i<=len; i++){
        for(int j=1; j<=i; j++){
            dp[i][j] = Math.max(dp[i-1][j],dp[i-1][j-1]) + triangle[i-1][j-1]; // dp는 0인덱스 안쓰니까
        }
    }

     for(int i =1; i<=len; i++){
        answer = Math.max(answer, dp[len][j]);
    }

    //3. 출력
    answer
시간복잡도:O(triangle.length^2)
레퍼런스:
효율화:
    -리팩터링
    -구상 속도 개선
주의:  dp[i][j] = Math.max(dp[i-1][j],dp[i-1][j-1]) + triangle[i-1][j-1];에서 dp는 len+1로 더 크게 잡았으므로 triangle에 대해서 인덱스-1씩 처리해줘야
시간:
보완: 구현
 */
class 정수_삼각형 {
    public int solution(int[][] triangle) {
        int answer = 0;
        //1. 입력
        int len = triangle.length;
        int [][] dp = new int [len+1][len+1];

        //2. 점화식
        for(int i =1; i<=len; i++){
            for(int j=1; j<=i; j++){
                dp[i][j] = Math.max(dp[i-1][j],dp[i-1][j-1]) + triangle[i-1][j-1]; // dp는 0인덱스 안쓰니까
            }
        }

        for(int i =1; i<=len; i++){
            answer = Math.max(answer, dp[len][i]);
        }

        //3. 출력
        return answer;
    }
}