import java.util.*;
// 1. yellow의 약수를 탐색

// 2. yellow의 약수에 맞게 brown이 알맞은 값인지 검증
class Solution {
    public int[] solution(int brown, int yellow) {
        for (int y = 1; y <= yellow; y++) {
            if (yellow % y == 0) {                   // x : 가로 , y : 세로
                int x = yellow / y;
                
                if(validateBrown(x, y, brown)) {
                    return new int[]{x+2, y+2};
                };
            }
        }
        
        return null;
    }
    
    private boolean validateBrown(int x, int y, int brown) {
        int edgeLength = (x + 2) * 2 + (y + 2) * 2 - 4;
        return edgeLength == brown;
    }
}
