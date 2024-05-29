import java.util.*;

class Solution {
    public int[] solution(int n, long left, long right) {
        List<Integer> answer = new ArrayList<>();
        for (long i = left; i <= right; i++) {
            long r = i / n;
            long c = i % n;
            
            int max = (int) Math.max(r, c);
            answer.add(max+1);
        }
        return answer.stream().mapToInt(i -> i).toArray();
    }
}
