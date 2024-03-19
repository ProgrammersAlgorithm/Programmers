public class Solution {
    public int[] solution(int brown, int yellow) {
        int[] answer = new int[2];
        
        int S = brown + yellow; // 전체 면적

        // 너비가 큰 순서대로 탐색합니다.
        for (int width = S - 1; width > 0; width--) {
            if (S % width != 0) continue; // 나누어 떨어지지 않을 때 넘어가기

            int height = S / width;
            int y = (width - 2) * (height - 2); // 노란 카펫의 면적
            int b = S - y; // 갈색 카펫의 면적

            // 정답을 찾았을 때
            if (y == yellow && b == brown) {
                answer[0] = width;
                answer[1] = height;
                break;
            }
        }
        
        return answer;
    }
}
