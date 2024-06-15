import java.util.*;

class Solution {
    public int[] solution(String s) {
        s = s.substring(1, s.length()-1);

        List<int[]> parsed = new ArrayList<>();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '{') {
                sb = new StringBuilder();
                continue;
            }
            if (s.charAt(i) == '}') {
                String[] split = sb.toString().split(",");
                int[] element = Arrays.stream(split)
                    .mapToInt(strNum -> Integer.parseInt(strNum))
                    .toArray();
                
                parsed.add(element);
                continue;
            }
            sb.append(s.charAt(i));
        }
   
        Collections.sort(parsed, (a, b) -> a.length - b.length);
        
        List<Integer> answer = new ArrayList<>();
        Set<Integer> ch = new HashSet<>(); // 숫자 중복 체크        
        for (int[] arr : parsed) {
            for (int n : arr) {
                if (ch.contains(n)) continue;
                answer.add(n);
                ch.add(n);
            }
        }

        return answer.stream().mapToInt(n -> n).toArray();
    }
}
