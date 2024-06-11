import java.util.*;

class Solution {
    
    int[] dr = {-1, 0, 1, 0};
    int[] dc = {0, 1, 0, -1};
    
    Map<Integer, Integer> map = new HashMap<>(); // <id, 넓이>
    int id = 2;
    int answer = 0;
    
    public int solution(int[][] land) {
        for (int c = 0; c < land[0].length; c++) {
            for (int r = 0; r < land.length; r++) {
                if (land[r][c] == 1) {
                    int area = dfs(r, c, land);
                    map.put(id++, area);
                }
            }
        }
        
        for (int c = 0; c < land[0].length; c++) {
            Set<Integer> set = new HashSet<>();
            for (int r = 0; r < land.length; r++) {
                if (land[r][c] >= 2) set.add(land[r][c]);
            }
            
            int colSum = set.stream()
                .map(id -> map.getOrDefault(id, 0))
                .mapToInt(Integer::intValue)
                .sum();
            answer = Math.max(colSum, answer);
        }
        return answer;
    }
    
    int dfs(int r, int c, int[][] land) {
        land[r][c] = id;
        
        int count = 1;
        for (int i = 0; i < 4; i++) {
            int nr = r + dr[i];
            int nc = c + dc[i];
            
            if (!(nr >= 0 && nc >= 0 && nr < land.length && nc < land[0].length)) continue;
            if (land[nr][nc] == 1) {
                count += dfs(nr, nc, land);
            }
        }
        
        return count;
    }
}
