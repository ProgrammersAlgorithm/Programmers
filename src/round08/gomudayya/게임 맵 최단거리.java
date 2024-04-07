import java.util.*;

class Solution {
    
    private static final int[] dr = {-1, 0, 1, 0};
    private static final int[] dc = {0, 1, 0, -1};
    
    static int R;
    static int C;
    public int solution(int[][] maps) {
        R = maps.length;
        C = maps[0].length;
        int [][] ch = new int[R][C];
        
        Queue<Point> Q = new LinkedList<>();
        Q.add(new Point(0, 0));
        maps[0][0] = 1;
        
        //bfs
        int distance = 1;
        while(!Q.isEmpty()) {
            int loop = Q.size();
            for (int i = 0; i < loop; i++) {
                Point p = Q.poll();
                if(p.r == R-1 && p.c == C-1) return distance;
                for (int j = 0; j < 4; j++) {
                    int nr = p.r + dr[j];
                    int nc = p.c + dc[j];
                    
                    if (nr >= 0 && nc >= 0 && nr < R && nc < C && maps[nr][nc] == 1) {
                        maps[nr][nc] = 0;
                        Q.add(new Point(nr, nc));
                    }
                }
            }
            distance++;
        }
        
        return -1;
    }
}

class Point {
    int r;
    int c;
    
    public Point(int r, int c) {
        this.r = r;
        this.c = c;
    }
    
    public String toString() {
        return String.format("r : %d, c : %d \n", r, c);
    }
}
