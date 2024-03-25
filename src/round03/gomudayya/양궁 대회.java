import java.util.*;

class Solution {
    int N;
    int[] apc = new int[11];
    int[] lion = new int[11];
    
    int maxDiff = -1;
    int[] answer = new int[11];
    Queue<int[]> pq;
    public int[] solution(int n, int[] info) {
        N = n;
        apc = info.clone();
        
        //가장 낮은 점수를 더 많이 맞힌 경우를 return
        pq = new PriorityQueue<>((o1, o2) -> {
            for (int i = 10; i >= 0; i--) {
                if (o1[i] != o2[i]) return o2[i] - o1[i];
            }
            return 0;
        });
        
        dfs(0, 0);
        
        if (maxDiff <= 0) 
            return new int[]{-1};
        
        return pq.poll();
    }
    
    void dfs(int cursor, int count) {
        if (count == N) {
            int diff = getDifference(apc, lion);
            
            if (diff > maxDiff) {
                maxDiff = diff;
                
                pq.clear();
                pq.add(lion.clone());
            }
            
            if (diff == maxDiff) {
                pq.add(lion.clone());
            }
            return;
        }
        
        for (int i = cursor; i < 11; i++) {
            lion[i] += 1;
            dfs(i, count+1);
            lion[i] -= 1;
        }
    }
    
    int getDifference(int[] apc, int[] lion) {
        int apcScore = 0;
        int lionScore = 0;
        
        for (int i = 0; i < 11; i++) {
            if (apc[i] == 0 && lion[i] == 0) continue;
            if (apc[i] >= lion[i]) 
                apcScore += (10 - i);
            else
                lionScore += (10 - i);
        }
        
        return lionScore - apcScore;
    }
}
