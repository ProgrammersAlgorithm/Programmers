import java.util.*;

public class 괄호_회전하기 {
	public int solution(String s) {
		int answer = 0;

        for (int i = 0; i < s.length(); i++) {
            Stack<String> stack = new Stack<>();
            
            int count = i;

            for (int j = 0; j < s.length(); j++) {
                if (count >= s.length()) {
                    count = 0;
                }

                if ((s.charAt(count) == (')') || s.charAt(count) == ('}') || s.charAt(count) == (']')) && !stack.isEmpty()) {
                        if (stack.peek().equals("(") && s.charAt(count) == (')')) {
                            stack.pop();
                        } else if (stack.peek().equals("{") && s.charAt(count) == ('}')) {
                            stack.pop();
                        } else if (stack.peek().equals("[") && s.charAt(count) == (']')) {
                            stack.pop();
                        }
                } else {
                    stack.add(String.valueOf(s.charAt(count)));
                }

                count++;
            }

            if (stack.isEmpty()) {
                answer++;
            }

        }

        return answer;
	}
}
