package round18.sor999;
/*
유형: 스택

알고리즘: 스택
//1.if (s.peek() == cur) pop
//2.else push
//3.is empty -> 0 : 1
*/
import java.util.*;

class Solution
{
    public int solution(String s){
        
        Stack<Character> stack = new Stack<>();

        for(int i =0; i<s.length();i++){
            //4. 예외처리 - 스택이 비어있을 경우 
            if(stack.isEmpty()){
                stack.push(s.charAt(i));
                continue;
            }
            
            if(stack.peek() == s.charAt(i)){//1.if (s.peek() == cur) pop
                stack.pop();
                continue;
            }
            //2.else push
            stack.push(s.charAt(i));            
        }
       //3.is empty -> 0 : 1
        
        return stack.isEmpty()? 1: 0;
    }
}
