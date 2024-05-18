/*
1. 오더에서 조합을 추출해야함. course에 따라서. 조합추출할 때 정렬 필수.

2. 그리고 해당 조합이 뽑힌 횟수를 보관해야함. (map 사용)

3. 가장 많이 뽑힌 조합을 선별함.

   이때, 뽑힌 횟수가 2보다 작으면 배제.
   
   가장 많이 뽑힌 조합이 여러개면 모두 포함. 
*/
import java.util.*;
import java.util.stream.*;

class Solution {
    
    Map<Integer, Map<String, Integer>> map = new HashMap<>(); //<조합된 갯수>,Map<조합형태, 뽑힌횟수>
    List<String> answer = new ArrayList<>();
    public String[] solution(String[] orders, int[] course) {
        for (String order : orders) {
            for (int combSize : course) {
                if (order.length() >= combSize) {
                    comb(order, 0, "", combSize);
                } 
            }
        }
        
        for (Map<String, Integer> innerMap: map.values()) {
            int max = innerMap.values().stream().mapToInt(n->n).max().getAsInt();
            if (max < 2) continue;
            
            for (String key : innerMap.keySet()) {
                if (innerMap.get(key) == max ) answer.add(key);
            }
        }        
        Collections.sort(answer);
        return answer.toArray(new String[0]);
    }
    
    void comb(String order, int idx, String comb, int combSize) {
        if (comb.length() == combSize) {
            comb = sort(comb);
            
            Map<String, Integer> innerMap = map.getOrDefault(comb.length(), new HashMap<>());
            innerMap.merge(comb, 1, (v1, v2) -> v1 + v2);
            map.put(comb.length(), innerMap);
            return;
        }
        
        
        for (int i = idx; i < order.length(); i++) {
            comb(order, i+1, comb+order.charAt(i), combSize);
        }
    }
    
    String sort(String comb) {
        StringBuilder sb = new StringBuilder();
        char[] chArr = comb.toCharArray();
        Arrays.sort(chArr);
        for (char c : chArr) {
            sb.append(c);
        }
        
        return sb.toString();
    }
}
