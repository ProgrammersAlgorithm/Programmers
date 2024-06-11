import java.util.*;

class Solution {
    
    Set<String> visited = new HashSet<>();
    
    public int solution(String begin, String target, String[] words) {
        return search(begin, target, words);
    }
    
    int search(String begin, String target, String[] words) {
        Queue<String> Q = new LinkedList<>();
        
        int step = 0;
        Q.add(begin);
        visited.add(begin);
        while(!Q.isEmpty()) {
            int size = Q.size();
            for (int i = 0; i < size; i++) {
                String poll = Q.poll();
                if (poll.equals(target)) {
                    return step;
                }
                
                for (String word : words) {
                    if (moveable(poll, word) && !visited.contains(word)) {
                        visited.add(word);
                        Q.add(word);
                    }
                }
            }
            step++;
        }
        
        return 0;
    }
        
    boolean moveable(String str1, String str2) { //서로 다른 알파벳이 두개이상이면 return false;
        int count = 0;
        for (int i = 0; i < str1.length(); i++) {
            if (str1.charAt(i) != str2.charAt(i)) count++;
            if (count == 2) return false;
        }
        return true;
    }
}
