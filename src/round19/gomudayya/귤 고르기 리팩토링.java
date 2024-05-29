import java.util.*;

class Solution {
    
    Map<Integer, Integer> map = new HashMap<>(); 
    public int solution(int k, int[] tangerine) {
        for (int i = 0; i < tangerine.length; i++) {
            map.merge(tangerine[i], 1, (v1, v2) -> v1+v2);
        }
        
        List<Integer> list = new ArrayList<>(map.keySet());
        Collections.sort(list, (n1, n2) -> map.get(n2)-map.get(n1));

        int answer = 0;
        for (int size : list) {
            k -= map.get(size);
            answer++;
            if (k <= 0) break;
        }
                
        return answer;
    }
}
