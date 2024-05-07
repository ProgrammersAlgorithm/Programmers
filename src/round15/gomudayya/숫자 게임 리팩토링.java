import java.util.*;

class Solution {
    public int solution(int[] A, int[] B) {
        Arrays.sort(A);
        Arrays.sort(B);
        
        int answer = 0;
        int indexB = 0;
        for (int i = 0; i <A.length; i++) {
            for (int j = indexB; j < B.length; j++) {
                if (A[i] < B[j]) {
                    indexB = j + 1;
                    answer++;
                    break;
                }
            }
        }
        
        return answer;
   }
}
