import java.util.*;

class Solution {
    
    Map<Integer, List<History>> map = new HashMap<>(); // 차 번호, 요금
    
    static int defaultTime;
    static int defaultFee;
    static int timeUnit;
    static int feeUnit;
    
    public int[] solution(int[] fees, String[] records) {
        defaultTime = fees[0] ;
        defaultFee = fees[1];
        timeUnit = fees[2];
        feeUnit = fees[3];

        // 자동차 번호 별 요금내역 정리
        for (String record : records) {
            String[] each = record.split(" ");
            
            int carNumber = Integer.parseInt(each[1]);
            
            int hour = Integer.parseInt(each[0].substring(0, 2));
            int minute = Integer.parseInt(each[0].substring(3));
            
            boolean isIn = true;
            if (each[2].equals("OUT")) isIn = false;
            
            List<History> histories = map.getOrDefault(carNumber, new ArrayList<>());
            
            histories.add(new History(hour, minute, isIn));
            map.put(carNumber, histories);
        }

        List<Integer> carNums = convertAndSort(map.keySet());

        int size = carNums.size();
        int[] answers = new int[size];
        
        for (int i = 0; i < size; i++) {
            List<History> histories = map.get(carNums.get(i));
            
            int fee = calculateTotalFee(histories);
            
            answers[i] = fee;
        }
        
        return answers;
    }
    
    private List<Integer> convertAndSort(Set<Integer> tmp) {
        List<Integer> ret = new ArrayList<>();

        for (int n : tmp) ret.add(n);
        
        Collections.sort(ret);
        return ret;
    }
    
    private int calculateTotalFee(List<History> histories) {      
        int consumeTime = 0;
        int idx = histories.size() - 1;
        
        History lastHistory = histories.get(idx);
        
        if (lastHistory.isIn) {
            consumeTime += (60*23 + 59) - (lastHistory.hour * 60 + lastHistory.minute);
            idx--;
        }
        
        //나머지 계산
        for(int i = idx; i > 0; i -= 2) {
            History outHistory = histories.get(i);
            History inHistory = histories.get(i-1);
            
            consumeTime += outHistory.getTotalMinute() - inHistory.getTotalMinute();
        }
        
        return calculateFee(consumeTime);
    }
    
    private int calculateFee(int minute) {
        int fee = defaultFee;
        
        if (minute <= defaultTime) return fee;
        
        int multiply = (minute-defaultTime) / timeUnit;
        
        if ((minute-defaultTime) % timeUnit != 0) {
            multiply += 1; // 나누어떨어지지 않으면 올림
        }
        
        fee += feeUnit * multiply;
        
        return fee;
    }
}

class History {
    int hour;
    int minute;
    boolean isIn;
    
    public History(int hour, int minute, boolean isIn) {
        this.hour = hour;
        this.minute = minute;
        this.isIn = isIn;
    }
    
    public String toString() {
        return String.format("hour : %d, minute : %d, isIn : %b", hour, minute, isIn);
    }
    
    public int getTotalMinute() {
        return 60 * hour + minute;
    }
}
