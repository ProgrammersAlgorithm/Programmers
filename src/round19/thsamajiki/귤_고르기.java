import java.util.*;

public class 귤_고르기 {
    public int solution(int k, int[] tangerines) {
        int sum = 0; // 고를 귤의 개수
        int count = 0; // 최솟값 카운트
        
        HashMap<Integer, Integer> map = new HashMap<>();
		
        for(int tangerine : tangerines) {
            map.put(tangerine, map.getOrDefault(tangerine, 0) + 1);
        }
      
        ArrayList<Integer> valueList = new ArrayList<>(map.values());
      
        Collections.sort(valueList, Collections.reverseOrder());
      
        for (int value : valueList) {
            if (sum + value >= k) {
                count++;
                break;
            } else {
                sum += value;
                count++;
            }
        }
      
        return count;
    }
}
