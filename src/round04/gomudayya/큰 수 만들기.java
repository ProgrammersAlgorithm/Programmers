import java.util.*;

class Solution {
    int N;
    
    public String solution(String number, int k) {
        N = number.length();
        StringBuilder sb = new StringBuilder(number);
        for (int i = 0; i < N-1 && k != 0; i++) {
            if (sb.charAt(i) < sb.charAt(i+1)) {
                sb.delete(i, i+1);
                k--;
                N--;
                i-=2; 
                if (i <-1) i = -1;
            }
        }
        
        if (k!=0) {  // 더 잘라야하는게 k개 남았을 때
            sb.delete(sb.length() - k, sb.length());
            return sb.toString();
        }
        return sb.toString();
    }
}
