import java.util.*;

class Solution {

    int answer = 0;
    char[] open = {'(', '[', '{'};
    char[] close = {')', ']', '}'};
    Map<Character, Integer> map = new HashMap<>();
    public int solution(String s) {
        for (int i = 0; i < 3; i++) {
            map.put(open[i], i);
            map.put(close[i], i);
        }

        StringBuilder sb = new StringBuilder(s);
        for (int i = 0; i < s.length(); i++) {
            sb.append(sb.charAt(0));
            sb.delete(0, 1);
            
            if (isValid(sb.toString())) {
                answer++;
            }
        }
        
        return answer;
    }
    
    boolean isValid(String s) {
        Stack<Character> stack = new Stack();
        
        for (char c : s.toCharArray()) {
            if (c == '(' || c == '[' || c == '{') {
                stack.add(c);
            } else {
                if (stack.isEmpty()) return false;
                if (map.get(stack.peek()) != map.get(c)) return false;
                stack.pop();
            }
        }
        return stack.isEmpty();
    }
}
