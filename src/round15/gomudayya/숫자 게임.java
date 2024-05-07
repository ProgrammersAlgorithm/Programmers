import java.util.*;

class Solution {
    public int solution(int[] A, int[] B) {
        Arrays.sort(A);
        Arrays.sort(B);
        
        int answer = 0;
        int indexB = 0;
        for (int i = 0; i <A.length; i++) {
            while(B[indexB] <= A[i]) {
                indexB++;
                if (indexB >= B.length) break;
            }
            if(indexB >= B.length) break;
            answer++;
            indexB++;
            if(indexB >= B.length) break;
        }
        
        return answer;
   }
}
