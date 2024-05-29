import java.util.*;

class Solution {
    int[] dr = {-1, 0, 1, 0};
    int[] dc = {0, 1, 0, -1};
    int[][] map;
    int R;
    int C;
    List<Integer> answer = new ArrayList<>();
    public int[] solution(String[] maps)  {
        R = maps.length;
        C = maps[0].length();
        map = new int[R][C];
        for (int r = 0; r < R; r++) {
            for (int c = 0; c < C; c++) {
                int val = maps[r].charAt(c);
                
                if (val == 'X') map[r][c] = -1;
                else map[r][c] = val-'0';
            }
        }
        
        for (int r = 0; r < R; r++) {
            for (int c = 0; c < C; c++) {
                if (map[r][c] != -1) {
                    answer.add(dfs(r, c));
                } 
            }
        }
        if (answer.isEmpty()) answer.add(-1);
        
        Collections.sort(answer);
        return answer.stream().mapToInt(n -> n).toArray();
    }
    
    int dfs(int r, int c) {
        int count = map[r][c];
        map[r][c] = -1;
        
        for (int i = 0; i < 4; i++) {
            int nr = r + dr[i];
            int nc = c + dc[i];
            
            if (nr < R && nc < C && nr >= 0 && nc >= 0 && map[nr][nc] != -1) {
                count += dfs(nr, nc);
            }
        }
        
        return count;
    }
}
