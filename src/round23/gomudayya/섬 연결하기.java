import java.util.*;

class Solution {
    
    int[] unf;
    int answer = 0;
    public int solution(int n, int[][] costs) {
        Arrays.sort(costs, (c1, c2) -> c1[2] - c2[2]);
        unf = new int[n];
        for (int i = 0; i < n; i++) unf[i] = i; // idx와 value값이 같으면 루트노드로 간주. value를 타고가면 루트노드를 찾을 수 있다.
        
        for (int[] cost : costs) {
            if (find(cost[0]) == find(cost[1])) continue; // 같은 루트노드를 가짐. (같은 집합)
            
            union(cost[0], cost[1]);
            answer += cost[2];
        }
        return answer;
    }
    
    int find(int idx) { // 루트노드를 찾는 메서드
        if (idx == unf[idx]) return unf[idx];
        return unf[idx] = find(unf[idx]);
    }
    
    void union(int a, int b) {
        int fa = find(a);
        int fb = find(b);
        if (fa != fb) unf[fa] = fb;
    }
}
