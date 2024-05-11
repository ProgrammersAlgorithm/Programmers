/*
유형: 그리디
알고리즘:
//1. a, b 정렬
//2. j<n반복.  a[i] < b[j]면 score++, i++, j++
//3. a[i] == b[j] 면 j++
//4. else 면 j++

예시:
1 3 5 7
2 3 6 8
*/

import java.util.*;
class Solution {
    public int solution(int[] A, int[] B) {
        int score = 0;
        int n = A.length;

        //1. a, b 정렬
        Arrays.sort(A);
        Arrays.sort(B);

        int i=0;
        int j=0;
        while(j < n){
            //2. 반복.  a[i] < b[j]면 score++, i++, j++
            if(A[i]<B[j]){
                score++;
                i++;
                j++;
            }
            else{//3. else j++
                j++;
            }
        }
        return score;
    }
}