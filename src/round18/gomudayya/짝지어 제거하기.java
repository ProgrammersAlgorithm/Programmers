import java.util.*;

class Solution
{
    private static int ADD_SIZE = 10;
    public int solution(String s) {
        if (s.length()==1) return 0;
        int left = 0;
        int right = s.length() <= ADD_SIZE ? s.length() : ADD_SIZE;
        StringBuilder sb = new StringBuilder(s.substring(0, right));
        
        int idx = 0;
        while(true) {
            for (int i = idx; i < sb.length()-1;) {
                if (i == -1) i++;
                if (sb.charAt(i) != sb.charAt(i+1)) {
                    i++;
                } else {
                    sb.delete(i, i+2);
                    i--;
                    if (i < 0) i = 0;
                }                
            }
            idx = sb.length()-1;
            
            if (right == s.length()) break;
            
            left = right;
            right = left+ADD_SIZE;
            if (right > s.length()) right = s.length();
            
            sb.append(s.substring(left, right));
        }
        
        if (sb.length() == 0) return 1;
        else return 0;
    }
}
