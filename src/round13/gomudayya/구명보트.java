import java.util.*;

class Solution {
    int[] weight = new int[241];
    public int solution(int[] people, int limit) {
        for (int p : people) {
            weight[p] += 1; 
        }
        
        int answer = 0;
        for (int i = 0; i <= 240; i++) {
            if (weight[i] == 0) continue;
            while(weight[i] != 0) {
                weight[i]--;
                for (int j = limit - i; j >= i ;j--) {
                    if (weight[j] == 0) continue;
                    weight[j]--;
                    break;
                }
                answer++;
            }
        }
        
        return answer;
    }
}
