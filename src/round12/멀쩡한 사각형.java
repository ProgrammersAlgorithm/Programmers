import java.util.*;

class Solution {
    public long solution(int w, int h) {
        long total = (long) w * (long) h;
        int a = Math.max(w, h);
        int b = Math.min(w, h); 
        
        long minus = 0;
        int tmp = 0;
        for (int i = 1; i <= a; i++) {
            tmp += b;
            minus++;
            if (tmp % a == 0) {
                tmp = 0;
            }
            else if (tmp / a == 1 ) {
                tmp -= a;
                minus++;
            }
        }
        
        return total - minus;
    }
}
