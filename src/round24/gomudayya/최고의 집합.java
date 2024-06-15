import java.util.*;

class Solution {
    
    int[] nonExist = new int[]{-1};
    public int[] solution(int n, int s) {
        if (n > s) return nonExist;

        int[] arr = new int[n];
        int divide = s/n;
        int rest = s%n;

        for (int i = 0; i < n; i++) {
            arr[i] = divide;
        }
        
        for (int i = 0; i < rest; i++) {
            arr[n-1-i] += 1;
        }
   
        return arr;
    }
}
