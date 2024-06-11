import java.util.*;

class Solution {
    
    int[] dr = {-1, 0, 1, 0};
    int[] dc = {0, 1, 0, -1};
    
    Map<Integer, Integer> map = new HashMap<>(); // <id, 넓이>
    int id = 2;
    int answer = 0;
    
    public int solution(int[][] land) {
        for (int r = 0; r < land.length; r++) {
            for (int c = 0; c < land[0].length; c++) {
                if (land[r][c] == 1) {
                    int area = bfs(r, c, land);
                    map.put(id++, area);
                }
            }
        }
        
        for (int c = 0; c < land[0].length; c++) {
            Set<Integer> set = new HashSet<>();
            for (int r = 0; r < land.length; r++) {
                if (land[r][c] != 0) set.add(land[r][c]);
            }
            
            int colSum = set.stream().map(id -> map.get(id)).mapToInt(Integer::intValue).sum();
            answer = Math.max(colSum, answer);
        }
        return answer;
    }
    
    int bfs(int startR, int startC, int[][] land) {
        int area = 0;
        Queue<Point> Q = new LinkedList<>();
        
        Q.add(new Point(startR, startC));
        land[startR][startC] = id;
        area++;
        while(!Q.isEmpty()) {
            Point p = Q.poll();
            
            for (int i = 0; i < 4; i++) {
                int nr = p.r + dr[i];
                int nc = p.c + dc[i];
                
                if (!(nr >= 0 && nc >= 0 && nr < land.length && nc < land[0].length)) continue;
                if (land[nr][nc] == 1) {
                    Q.add(new Point(nr, nc));
                    land[nr][nc] = id;
                    area++;
                }
            }
        }
        return area;
    }
}

class Point {
    int r;
    int c;
    
    public Point(int r, int c) {
        this.r = r;
        this.c = c;
    }
}
