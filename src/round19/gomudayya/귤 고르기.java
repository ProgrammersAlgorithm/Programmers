import java.util.*;

class Solution {
    
    Map<Integer, Integer> map = new HashMap<>(); 
    public int solution(int k, int[] tangerine) {
        for (int i = 0; i < tangerine.length; i++) {
            map.merge(tangerine[i], 1, (v1, v2) -> v1+v2);
        }
        
        List<Map.Entry<Integer, Integer>> entryList = new ArrayList<>(map.entrySet());
        Collections.sort(entryList, (e1, e2) -> e2.getValue() - e1.getValue());

        Set<Integer> set = new HashSet<>();
        int nowIdx = 0;
        for (int i = 0; i < k; i++) {
            int nowSize = entryList.get(nowIdx).getKey();
            map.merge(nowSize, 1, (v1, v2) -> v1-v2);
            set.add(nowSize);
            if (map.get(nowSize) == 0) {
                nowIdx++;
            }
        }
        
        
        return set.size();
    }
}
