import java.util.*;

public class Solution {
    public int solution(int n) {
        if (n==1) return 1;
        int fuel = 1;
        while(true) {
            if (n % 2 == 0) {
                n/=2;
            } else {
                n--;
                fuel++;
            }
            if (n==1) break;
        }
        return fuel;
    }
}
