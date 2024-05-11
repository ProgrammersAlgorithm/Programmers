import java.util.*;

public class 영어_끝말잇기 {
    public int[] solution(int n, String[] words) {
        int[] answer = new int[2];

        List<String> list = new ArrayList<>();
        list.add(words[0]);

        for(int i = 1; i < words.length; i++) {
            if(list.contains(words[i]) || checkSame(list.get(list.size() - 1), words[i])) {
                answer[0] = i % n + 1;
                answer[1] = i / n + 1;
                break;
            }
          
            list.add(words[i]);
        }

        return answer;
    }

    public boolean checkSame(String word1, String word2) {
        if(word1.charAt(word1.length() - 1) == word2.charAt(0)) {
            return false;
        }
      
        return true;
    }
}
