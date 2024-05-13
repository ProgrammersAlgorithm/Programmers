import java.util.*;

class Solution {
    
    Map<String, Integer> map = new HashMap<>();
    String[] arr = new String[1001];
    int idx = 27;
    List<Integer> answer = new ArrayList<>();
    
    public int[] solution(String msg) {
        for (int i = 0; i < 26; i++) {
            map.put(String.valueOf((char) ('A' + i)), i+1);
            arr[i+1] = String.valueOf((char) ('A' + i));
        }
        
        for (int i = 0; i < msg.length(); ) {
            StringBuilder sb = new StringBuilder();
            for (int j = i; j < msg.length(); j++) {
                sb.append(msg.charAt(j));
                if (map.containsKey(sb.toString())) {
                    if (j == msg.length()-1) {
                        answer.add(map.get(sb.toString()));
                        i = msg.length();
                        break;
                    }
                    continue;
                }
                
                //사전에 기록, answer에 이전 범위의 문자열의 인덱스를 삽입
                map.put(sb.toString(), idx);
                arr[idx] = sb.toString();
                idx++;

                String str = sb.substring(0, sb.length()-1);
                answer.add(map.get(str));
                
                i = j;
                break;
            }
        }
        
        return answer.stream().mapToInt(n -> n).toArray();
    }
}
