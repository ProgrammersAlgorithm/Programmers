import java.util.*;

class Solution {
    int answer = 0;
    int[] ch = new int[8];
    Set<Integer> set = new HashSet<>();
    public int solution(String numbers) {
        for (int i = 1; i <= 7 && i <= numbers.length(); i++) {
            perm(numbers, i, new StringBuilder());
        }
        
        return answer;
    }

    void perm(String numbers, int len, StringBuilder result) {
        if (result.length() == len) {
            int n = Integer.parseInt(result.toString());
            if (set.contains(n)) return;
            if (isPrime(n)) {
                answer++;
                set.add(n);
            }
            return;
        }
        
        for (int i = 0; i < numbers.length(); i++) {
            if (ch[i] == 1) continue;
            
            result.append(numbers.charAt(i));
            ch[i] = 1;
            perm(numbers, len, result);
            ch[i] = 0;
            result.delete(result.length()-1, result.length());
        }
    }
    
    boolean isPrime(int num) {
        if (num == 0 || num == 1) return false;
        for (int i = 2; i*i <= num; i++) {
            if (num % i == 0) {
                return false;
            }
        }
        return true;
    }
}
