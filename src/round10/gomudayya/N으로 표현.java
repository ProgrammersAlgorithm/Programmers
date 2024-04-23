import java.util.*;

class Solution {
    //DP[N]  = (a+b = N) 인 모든 (a,b)에서 D[a]에 +-*/ D[b]  
    List<Set<Integer>> DP = new ArrayList<>();
    public int solution(int N, int number) {
        if(number == N) return 1;
        
        for (int i = 0; i <= 8; i++) DP.add(new HashSet<>());
        DP.get(1).add(N);
        
            
        for (int i = 2; i <= 8; i++) { // N이 i개만큼 있을 때
            Set<Integer> nowSet = DP.get(i);
            
            for (int j = 1; j < i; j++) {
                Set<Integer> set1 = DP.get(j);
                Set<Integer> set2 = DP.get(i-j);
                merge(set1, set2, nowSet);
            }
            nowSet.add(getConcatNumber(N, i));
            if (nowSet.contains(number)) return i;
        }
        
        return -1;
    }
    
    int getConcatNumber(int N, int count) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < count; i++) sb.append(N);
        return Integer.parseInt(sb.toString());
    }
    
    void merge(Set<Integer> set1, Set<Integer> set2, Set<Integer> merged) {
        for (int n1 : set1) {
            for (int n2 : set2) {
                merged.add(n1+n2); 
                merged.add(n1*n2);
                merged.add(n1-n2);
                if (n2 != 0) merged.add(n1/n2);
            }
        }
    }    
}
