import java.util.*;

class Solution {
    public int solution(int[] arr) {
        for (int h = arr.length; h >= 0; h--) {
            int count = 0;
            for (int j = 0; j < arr.length; j++) {
                if (arr[j] >= h) count++;
            }
            if (count >= h) return h;
        }
        throw new IllegalArgumentException();
    }
}
