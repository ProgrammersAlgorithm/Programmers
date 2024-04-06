import java.util.*;

class Solution {
    long answer = -1;
    public long solution(String expression) {
        Queue<String> parsed = parseExpression(expression);
        
        updateAnswer(multiply(minus(plus(parsed))));
        updateAnswer(minus(multiply(plus(parsed))));

        updateAnswer(multiply(plus(minus(parsed))));
        updateAnswer(plus(multiply(minus(parsed))));

        updateAnswer(plus(minus(multiply(parsed))));
        updateAnswer(minus(plus(multiply(parsed))));
        
        return answer;
    }
    
    Queue<String> parseExpression(String exp) {
        Queue<String> Q = new LinkedList<>();
        int prev = 0;
        for (int i = 0; i < exp.length(); i++) {
            char c = exp.charAt(i);
            
            if (c == '-' || c == '+' || c == '*') {
                Q.add(exp.substring(prev, i));
                Q.add(String.valueOf(c));
                prev = i+1;
            }
        }
        
        Q.add(exp.substring(prev,exp.length()));
        return Q;
    }
    
    void updateAnswer(Queue<String> Q) {
        long num = Long.parseLong(Q.poll());
        
        answer = Math.max(Math.abs(num), answer);
    }
    
    Queue<String> plus(Queue<String> expression) {
        Queue<String> exp = new LinkedList<>(expression); // 복사
        Queue<String> ret = new LinkedList<>();

        String leftNum = exp.poll();
        
        while (!exp.isEmpty()) {
            String poll = exp.poll();
            
            if (!poll.equals("+")) {
                ret.add(leftNum);
                ret.add(poll);
                leftNum = exp.poll();
                continue;
            }
            
            String rightNum = exp.poll();
            long sum = Long.parseLong(leftNum) + Long.parseLong(rightNum);
            leftNum = String.valueOf(sum);
        }
        
        ret.add(leftNum);
        return ret;
    }
    
    Queue<String> minus(Queue<String> expression) {
        Queue<String> exp = new LinkedList<>(expression); // 복사
        Queue<String> ret = new LinkedList<>();

        String leftNum = exp.poll();
        
        while (!exp.isEmpty()) {
            String poll = exp.poll();
            
            if (!poll.equals("-")) {
                ret.add(leftNum);
                ret.add(poll);
                leftNum = exp.poll();
                continue;
            }
            
            String rightNum = exp.poll();
            long sum = Long.parseLong(leftNum) - Long.parseLong(rightNum);
            leftNum = String.valueOf(sum);
        }
        
        ret.add(leftNum);
        return ret;
    }
        
    Queue<String> multiply(Queue<String> expression) {
        Queue<String> exp = new LinkedList<>(expression); // 복사
        Queue<String> ret = new LinkedList<>();

        String leftNum = exp.poll();
        
        while (!exp.isEmpty()) {
            String poll = exp.poll();
            
            if (!poll.equals("*")) {
                ret.add(leftNum);
                ret.add(poll);
                leftNum = exp.poll();
                continue;
            }
            
            String rightNum = exp.poll();
            long sum = Long.parseLong(leftNum) * Long.parseLong(rightNum);
            leftNum = String.valueOf(sum);
        }
        
        ret.add(leftNum);
        return ret;
    }
}
