import java.util.*;

class Solution {
    
    Set<String> set = new HashSet<>();
    
    public boolean solution(String[] phone_book) {
        set.addAll(Arrays.asList(phone_book));
        
        for (String now : phone_book) {
            for (int i = 0; i < now.length(); i++) {
                if (set.contains(now.substring(0,i))) {
                    return false;
                }
            }
        }
        return true;
    }
}
