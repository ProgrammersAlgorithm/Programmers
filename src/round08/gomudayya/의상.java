import java.util.*;

class Solution {
    
    Map<String, Integer> map = new HashMap<>();
    public int solution(String[][] clothes) {
        for (String[] cloth : clothes) {
            map.merge(cloth[1], 1, Integer::sum);
        }
        
        int answer = 1;
        for (int n : map.values()) {
            answer *= (n+1);
        }
        
        return answer-1;
    }
}
