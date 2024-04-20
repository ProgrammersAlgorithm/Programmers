import java.util.*;

class Solution {
    public int solution(int[] order) {
        int answer = 0;

        Stack<Integer> stack = new Stack<>(); // 보조 컨테이너
        int mainContainer = 1;
        
        for (int i = 0; i < order.length; i++) {
            int next = order[i];

            if(mainContainer > next) { // 보조컨테이너 확인
                if (!checkStack(stack, next)) break;
                else {
                    answer++;
                }
            }
            else if(mainContainer == next) {
                mainContainer++;
                answer++;
            }
            else if (mainContainer < next) { // 메인 컨테이너에서 next를 빼내야 함.
                for (int j = mainContainer; j < next; j++) {
                    stack.push(j);
                }
                mainContainer = next+1;
                answer++;
            } 
        }
        
        return answer;
    }
    
    boolean checkStack(Stack<Integer> stack, int next) {
        if (stack.isEmpty()) return false;
        if (stack.peek() == next) {
            stack.pop();
            return true;
        }
        return false;
    }
}
