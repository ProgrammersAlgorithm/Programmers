class Solution {
    
    static int[][] D;
    public int solution(int n, int[] tops) {
        D = new int[2][n];
        
        D[0][0] = 1;
        D[1][0] = tops[0] == 1? 3 : 2;
        for (int i = 1; i < n; i++) {
            D[0][i] = (D[0][i-1] + D[1][i-1]) % 10007;
            D[1][i] = tops[i] == 1 ? 
                D[0][i-1] * 2 + D[1][i-1] * 3 : D[0][i-1] * 1 + D[1][i-1] * 2;

            D[1][i] %= 10007;
        }
        
        return (D[0][n-1] + D[1][n-1]) % 10007 ;
    }
}
