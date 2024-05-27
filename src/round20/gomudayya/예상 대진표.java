class Solution {
    public int solution(int n, int a, int b) {
        int answer = getMax(n);
        int partition = n/2;
        while(true) {
            boolean left = a <= partition && b <= partition;
            boolean right = a > partition && b > partition;
            if (!left && !right) {
                break;
            }
            n /= 2;
            if (left) partition -= n/2;
            if (right) partition += n/2;
            answer--;
        }
    
        return answer;
    }
    
    int getMax(int n) {
        int tmp = 1;
        for (int i = 1; i <= 20; i++) {
            tmp *= 2;
            if (tmp == n) return i;
        }
        throw new IllegalArgumentException();
    }
}
