import java.util.*;

class Solution {
    
    Map<Integer, Integer> out = new TreeMap<>(); // 출차 시간을 기록
    Map<Integer, Integer> total = new TreeMap<>(); // 누적 시간을 기록
    
    static int defaultTime;
    static int defaultFee;
    static int timeUnit;
    static int feeUnit;
    
    private static final int END_TIME = 23 * 60 + 59;
    
    public int[] solution(int[] fees, String[] records) {
        defaultTime = fees[0] ;
        defaultFee = fees[1];
        timeUnit = fees[2];
        feeUnit = fees[3];

        for (int i = records.length-1; i >= 0; i--) { // 예외케이스 처리를 위해 거꾸로 순회
            String[] record = records[i].split(" ");

            int carNumber = Integer.parseInt(record[1]);
            
            int hour = Integer.parseInt(record[0].substring(0, 2));
            int minute = Integer.parseInt(record[0].substring(3));
            int converted = 60 * hour + minute;
            
            if (record[2].equals("IN")) {
                if (!out.containsKey(carNumber)) { // 입차인데 출차기록이 없으면 
                    total.put(carNumber, END_TIME - converted); // 23시59분 - 입차 시간을 빼기.
                } else { // 출차시간 - 입차시간을 해서 누적시간을 기록
                    int outTime = out.get(carNumber);
                    int consumeTime = outTime - converted;
                    total.merge(carNumber, consumeTime, Integer::sum);
                    // total.merge(carNumber, consumeTime, (n1, n2) -> n1 + n2);
                    // total.put(carNumber, total.getOrDefault(carNumber, 0) + consumeTime);
                }
            } 
            else out.put(carNumber, converted); // 출차일때는 map에 기록만.
        }
        
        int[] answers = new int[total.size()];
        int cursor = 0;
        for (int totalTime : total.values()) {
            int fee = calculateFee(totalTime);
            answers[cursor++] = fee;
        }

        return answers;
    }

    private int calculateFee(int minute) {
        if (minute <= defaultTime) return defaultFee;
        
        int multiply = (minute-defaultTime) / timeUnit;
        if ((minute-defaultTime) % timeUnit != 0) multiply++; // 나누어떨어지지 않으면 올림
        
        return defaultFee + feeUnit * multiply;
    }
}
