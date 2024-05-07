import java.util.*;

class Solution {
    
    Set<String> set = new HashSet<>();
    
    public int[] solution(int n, String[] words) {
        set.add(words[0]);
        for (int i = 1; i < words.length; i++) {
            if (set.contains(words[i]) || !speakEndCharacter(words[i-1], words[i])) {
                int turn = i+1;
                int personNum = turn % n == 0 ? n : turn % n;
                int personTurn = turn % n == 0 ? turn / n : turn / n + 1;
                return new int[]{personNum, personTurn};
            } else {
                set.add(words[i]);
            }
        }
        
        return new int[]{0, 0};
    }
    
    boolean speakEndCharacter(String previousWord, String nowWord) {
        return previousWord.charAt(previousWord.length()-1) == nowWord.charAt(0);
    }
}
