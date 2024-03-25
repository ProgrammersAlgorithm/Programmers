import java.util.*;

class Solution {
    public int solution(int[] scoville, int K) {
        Queue<Integer> pq = new PriorityQueue<>();
        
        for (int n : scoville) {
            pq.add(n);
        }
        
        int answer = 0;
        while(true) {
            if(pq.peek() >= K) break;
            if(pq.size() < 2) return -1;
            int n1 = pq.poll(); // 가장 맵지 않은
            int n2 = pq.poll(); // 두번째로 맵지 않은
            
            pq.add(n1 + n2 * 2);
            answer++;
        } 
        
        return answer;
    }
}
