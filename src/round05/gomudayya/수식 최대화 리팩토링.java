import java.util.*;

class Solution {
    
    long answer = -1;
    String[] operCase = {"+-*", "+*-", "-+*", "-*+", "*-+", "*+-"};
    
    public long solution(String expression) {
        Queue<String> parsed = parseExpression(expression);
        
        for (String opers : operCase) {
            Queue<String> tmp = new LinkedList<>(parsed);
            for (int i = 0; i < 3; i++) {
                tmp = calculate(tmp, String.valueOf(opers.charAt(i)));
            }
            
            long num = Long.parseLong(tmp.poll());
            answer = Math.max(Math.abs(num), answer);
        }
        
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
        
    Queue<String> calculate(Queue<String> exp, String oper) {
        Queue<String> ret = new LinkedList<>();
        
        String leftNum = exp.poll();
        
        while (!exp.isEmpty()) {
            String poll = exp.poll();
            
            if (!poll.equals(oper)) { //oper와 다른경우 leftNum과 연산자를 넣어주고, leftNum값 갱신
                ret.add(leftNum);
                ret.add(poll);
                leftNum = exp.poll();
                continue;
            }
            
            // oper와 같은경우는 오른쪽값을 큐에서 추가로 꺼내서 계산하고, 결과값이 leftNum이 됨.
            String rightNum = exp.poll();
            long result = compute(Long.parseLong(leftNum), Long.parseLong(rightNum), oper); 
            leftNum = String.valueOf(result);
        }
        
        ret.add(leftNum); // 마지막에 남은 leftNum을 추가. 빼먹으면 안됨
        return ret;
    }
    
    long compute(long n1, long n2, String oper) {
        if (oper.equals("+")) return n1+n2;
        if (oper.equals("-")) return n1-n2;
        if (oper.equals("*")) return n1*n2;
        throw new IllegalArgumentException("잘못된 연산자");
    }
}
