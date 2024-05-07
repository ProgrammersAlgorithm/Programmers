import java.util.*;

class Solution {
    public int solution(int[][] data, int col, int row_begin, int row_end) {
        Arrays.sort(data, (d1,d2) -> d1[col-1] - d2[col-1] == 0 ? d2[0]-d1[0] : d1[col-1] - d2[col-1]);
        
        int answer = 0;        
        for (int i = row_begin-1; i <= row_end-1; i++) {
            int S_i = 0;
            for (int j = 0; j < data[0].length; j++) {
                S_i += data[i][j] % (i+1);
            }
            if (answer == 0) answer = S_i;
            else answer = answer ^ S_i;
        }
        
        return answer;
    }
}
