/*
유형: bfs
문제: 모든 경로의 최단 거리 구하기
단서: 여러 경로의 최단거리
알고리즘:
//1. 큐 선언
//2. bfs
//3. dist[n-1][m-1] return
시간복잡도: O(n*m)
*/
import java.util.*;
class Solution {
    public int solution(int[][] maps) {
        //1. 큐 선언
        Queue<int[]> q = new LinkedList<>();
        int n = maps.length;
        int m = maps[0].length;
        int [][] dist = new int [n][m];
        int [] dx = {-1,1,0,0};
        int [] dy = {0,0,-1,1};

        //2. bfs
        q.offer(new int[]{0,0});
        maps[0][0] = 0;
        dist[0][0] = 1;
        while(!q.isEmpty()){
            int [] cur = q.poll();
            int cx = cur[0];
            int cy = cur[1];

            for(int i=0; i<4; i++){
                int nx = cx + dx[i];
                int ny = cy + dy[i];
                if(nx>=n || nx<0 || ny>=m || ny<0) continue;
                if(maps[nx][ny] == 1){
                    dist[nx][ny] = dist[cx][cy] + 1;
                    maps[nx][ny] = 0;
                    q.offer(new int[]{nx, ny});
                }
            }
        }

        //3. dist[n-1][m-1] return
        return dist[n-1][m-1] == 0 ? -1 : dist[n-1][m-1];
    }
}