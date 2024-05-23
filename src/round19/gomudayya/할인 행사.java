import java.util.*;

class Solution {
    
    Map<String, Integer> map = new HashMap<>();
    int answer = 0;
    public int solution(String[] want, int[] number, String[] discount) {
        for (int i = 0; i < want.length; i++) {
            map.merge(want[i], number[i], (v1,v2) -> v1+v2);
        }
        
        for (int i = 0; i <= discount.length-10; i++) {
            Map<String, Integer> cMap = new HashMap<>(map);
            for (int j = i; j < i+10; j++) {
                if (!cMap.containsKey(discount[j])) break;
                cMap.merge(discount[j], 1, (v1, v2) -> v1-v2);
            }
            if(cMap.values().stream().allMatch(n -> n == 0)) {
                answer++;;
            }
        }
        
        return answer;
    }
}
