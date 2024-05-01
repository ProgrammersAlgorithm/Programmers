import java.util.*;

class Solution {
    Deque<String> dq = new ArrayDeque();
    public int solution(int cacheSize, String[] cities) {
        int answer = 0;
        if (cacheSize == 0) {
            return 5 * cities.length;
        }
        
        for (int i = 0; i < cities.length; i++) {
            cities[i] = cities[i].toUpperCase();
            
            if (dq.contains(cities[i])) {
                answer +=1;
                dq.remove(cities[i]);
                dq.addFirst(cities[i]);
            } else {
                answer +=5;
                if (dq.size() < cacheSize) {
                    dq.addFirst(cities[i]);
                } else {
                    dq.pollLast();
                    dq.addFirst(cities[i]);
                }
            }
        }
        
        
        return answer;
    }
}
