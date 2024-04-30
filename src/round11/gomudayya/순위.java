import java.util.*;

class Solution {
    Map<Integer, List<Integer>> win = new HashMap<>();
    Map<Integer, List<Integer>> lose = new HashMap<>();
    
    Map<Integer, Set<Integer>> winAllMemory = new HashMap<>();
    Map<Integer, Set<Integer>> loseAllMemory = new HashMap<>();
    
    public int solution(int n, int[][] results) {
        for (int i = 1; i <= n; i++) {
            win.put(i, new ArrayList<>());
            lose.put(i, new ArrayList<>());
        }
        
        for (int[] result : results) {
            List<Integer> winList = win.get(result[0]);
            winList.add(result[1]);
            win.put(result[0], winList);
            
            List<Integer> loseList = lose.get(result[1]);
            loseList.add(result[0]);
            lose.put(result[1], loseList);
        }

        int answer = 0;
        for (int player = 1; player<= n; player++) {
            Set<Integer> winAll = findWinAll(player);
            Set<Integer> loseAll = findLoseAll(player);
            
            if (winAll.size() + loseAll.size() == n-1) {
                answer++;
            }
        }
        
        return answer;
    }
    
    Set<Integer> findWinAll(int player) {      
        Set<Integer> set = new HashSet<>();
        List<Integer> winList = win.get(player);
        
        for (int n : winList) {
            set.add(n);
            
            if (winAllMemory.containsKey(n)) {
                set.addAll(winAllMemory.get(n));
            }
            else {
                set.addAll(findWinAll(n));
            }
        }
        
        winAllMemory.put(player, set);
        return set;
    }
    
    Set<Integer> findLoseAll(int player) {
        Set<Integer> set = new HashSet<>();
        List<Integer> loseList = lose.get(player);
        
        for (int n : loseList) {
            set.add(n);
            
            if (loseAllMemory.containsKey(n)) {
                set.addAll(loseAllMemory.get(n));
            }
            else {
                set.addAll(findLoseAll(n));
            }
        }
        
        loseAllMemory.put(player, set);
        return set;
    }
}
