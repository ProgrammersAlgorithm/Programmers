class Solution {
    
    private static int MODULAR = 1_000_000_007;
    int [][] D;
    int [][] ch;
    public int solution(int C, int R, int[][] puddles) {
        D = new int [R+1][C+1];
        ch = new int [R+1][C+1];
        
        for (int[] puddle : puddles) {
            int r = puddle[1];
            int c = puddle[0];
            ch[r][c] = -1;
        }
        
        D[1][1] = 1;
        for (int r = 1; r <= R; r++) {
            for (int c = 1; c <= C; c++) {
                if (r == 1 && c == 1) continue;
                if (ch[r][c] == -1) continue; // 웅덩이이면 무시
                //위쪽 + 왼쪽
                int up = D[r-1][c];
                int left = D[r][c-1];
                
                if (ch[r-1][c] == -1) up = 0; // 위쪽이 웅덩이이면 0취급
                if (ch[r][c-1] == -1) left = 0; // 왼쪽이 웅덩이이면 0취급
                
                D[r][c] = (up + left) % MODULAR;
            }
        }
        
        
        return D[R][C];
    }
}