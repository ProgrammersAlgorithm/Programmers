import java.util.*;

class Solution {
    public int[] solution(String[] gems) {
        int[] answer = {0, 100_001};
        long totalNumber = Arrays.stream(gems)
            .distinct()
            .count();
        
        Map<String, Integer> map = new HashMap<>(); 
        int start = 0;
        for (int i = 0; i < gems.length; i++) {
            map.merge(gems[i], 1, (v1, v2) -> v1 + v2);
            
            if (map.size() == totalNumber) {
                start = calculateStart(start, gems, map);
                if (i - start < answer[1] - answer[0]) {
                    answer[0] = start+1;
                    answer[1] = i+1;
                }
                
                map.remove(gems[start]);
                start++;
            }
        }
        
        return answer;
    }
    
    int calculateStart(int start, String[] gems, Map<String, Integer> map) {
        while (true) {
            String name = gems[start++];
            if (map.get(name) == 1) {
                break;
            }
            map.merge(name, 1, (v1, v2) -> v1-v2);
        }
        
        return start-1;
    }
}
