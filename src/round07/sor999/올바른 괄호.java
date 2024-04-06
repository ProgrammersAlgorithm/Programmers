/*
유형: 스택
문제: 괄호가 알맞게 닫히면 true, 아니면 false
단서: 괄호 문제
알고리즘:
//1. ( 이면 push
//2. ) 이면 pop
//3. 비어있는데 )면 false
시간복잡도: O(s.length())

*/
import java.util.*;
class Solution {
    boolean solution(String s) {
        Stack<Character> stack = new Stack<>();

        for(int i=0; i< s.length(); i++){
            if(s.charAt(i) == '('){
                stack.push('(');
            }
            else{
                if(stack.empty()){
                    return false;
                }else{
                    stack.pop();
                }
            }
        }

        if(!stack.empty()){
            return false;
        }else{
            return true;
        }
    }
}