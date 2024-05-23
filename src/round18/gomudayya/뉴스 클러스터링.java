import java.util.*;

class Solution {
    
    Map<String, Integer> map = new HashMap<>();
    public int solution(String str1, String str2) {
        List<String> A = parse(str1);
        List<String> B = parse(str2);
        if (A.size() == 0 && B.size() == 0) return 65536;
        
        for (String word : A) {
            map.merge(word, 1, (v1, v2) -> v1 + v2);
        }
        
        int intersection = 0;
        for (String word : B) {
            if (!map.containsKey(word) || map.get(word) <= 0) continue;
            map.merge(word, 1, (v1, v2) -> v1 - v2);
            intersection++;
        }
        
        int union = A.size() + B.size() - intersection;
        double resemble = (double) intersection / (double) union;
        resemble*=65536;
        
        return (int) resemble;
    }
    
    List<String> parse(String s) {
        List<String> ret = new ArrayList<>();
        for (int i = 0; i < s.length()-1; i++) {
            char c1 = s.charAt(i);
            char c2 = s.charAt(i+1);
            if (!Character.isAlphabetic(c1) || !Character.isAlphabetic(c2)) continue;
            c1 = Character.toUpperCase(c1);
            c2 = Character.toUpperCase(c2);
            
            ret.add(String.valueOf(c1) + String.valueOf(c2));
        }
        
        return ret;
    }
}
