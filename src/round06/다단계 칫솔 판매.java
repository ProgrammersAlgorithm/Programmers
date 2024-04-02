import java.util.*;

class Solution {
    
    private final static int PRICE = 100;
    
    Map<String, String> ref = new HashMap<>();
    Map<String, Integer> idMap = new HashMap<>();
    
    int[] answer;
    public int[] solution(String[] enroll, String[] referral, String[] seller, int[] amount) {
        answer = new int[enroll.length];
        
        for (int i = 0; i < enroll.length; i++) {
            ref.put(enroll[i], referral[i]);
            idMap.put(enroll[i], i);
        }
        
        for (int i = 0; i < seller.length; i++) {
            calculate(seller[i], amount[i] * PRICE);
        }

        return answer;
    }
    
    void calculate(String name, int profit) {
        if (profit == 0) return;
        if (name.equals("-")) return;
        
        int referralProfit = profit / 10;
        int pureProfit = profit - referralProfit;
        
        answer[idMap.get(name)] += pureProfit;
        
        calculate(ref.get(name), referralProfit);
    }
}