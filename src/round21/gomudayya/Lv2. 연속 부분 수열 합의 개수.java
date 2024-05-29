```java
import java.util.*;

class Solution {

    Set<Integer> answer = new HashSet<>();
    public int solution(int[] elements) {
        for (int i = 0; i < elements.length; i++) {
            int sum = 0;
            for (int j = 0; j < elements.length; j++) {
                sum += elements[(i+j) % elements.length];
                answer.add(sum);
            }
        }
        
        return answer.size();
    }
}
```
