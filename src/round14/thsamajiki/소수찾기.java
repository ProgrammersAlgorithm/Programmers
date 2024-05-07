public class Solution {
    public int solution(int n) {
        int answer = 0;
      	
        for(int i = 2; i <= n; i++) {
            boolean num = true;
          
            for(int j = 2; j <= Math.sqrt(i); j++) {
                if(i % j == 0) {
                    num = false;
                    break;
                }
            }
			
            if(num == true) {
                answer++;
            }
        }

        return answer;
    }
}
