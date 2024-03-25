/*
유형: 구현, HashMap
문제: 주차 요금 출력 
    - IN: 들어온 차
    - OUT: 나간 차
    - IN 있고 OUT 없으면 23:59에 OUT 
    - 차가 두번 입차 가능 
단서: 키에 대응되는 값
아이디어: 차량 번호가 key 시간과 요금을 각각 value로 하는 맵 2개를 만들자
알고리즘:
//1. 시간, 요금 맵에 파싱 
//2. 시간을 분으로 치환
//3. 주차 요금 계산 
시간복잡도:
레퍼런스: https://rovictory.tistory.com/128

*/
import java.util.*;
class Solution {
    static Map<String, Integer> parseMap = new TreeMap<>();
    static Map<String, String> map = new HashMap<>(); // 출입 시간
    public int[] solution(int[] fees, String[] records) {


        for (int i = 0; i < records.length; i++) {
            String[] info = records[i].split(" ");
            // 입차라면
            if (info[2].equals("IN")) {
                map.put(info[1], info[0]);
                // 출차라면 입차시간, 출차시간, 차량번호를 parse에 넘김
            } else {
                parse(map.get(info[1]), info[0], info[1]);
                map.remove(info[1]);
            }
        }

        // map에 남아있는 차량이 있다면
        if (!map.isEmpty()) {
            for (String s : map.keySet()) {
                parse(map.get(s), "23:59", s);
            }
        }
        cul(fees);

        List<Integer> list = new ArrayList<>();
        for (String key : parseMap.keySet()) {
            list.add(parseMap.get(key));
        }

        int[] answer = new int[list.size()];
        for (int i = 0; i < list.size(); i++) {
            answer[i] = list.get(i);
        }

        return answer;
    }

    static void parse(String in, String out, String carNum) { // 총 주차 시간
        // 출차 시간을 분 단위로 변환
        String[] outTemp = out.split(":");
        int outMin = Integer.parseInt(outTemp[0]) * 60 + Integer.parseInt(outTemp[1]);
        // 입차 시간을 분 단위로 변환
        String[] inTemp = in.split(":");
        int inMin = Integer.parseInt(inTemp[0]) * 60 + Integer.parseInt(inTemp[1]);
        int dif = outMin - inMin;
        parseMap.put(carNum, parseMap.getOrDefault(carNum, 0) + dif);
    }

    // 주차 요금을 계산
    static void cul(int[] fees) {
        for (String key : parseMap.keySet()) {
            if (parseMap.get(key) < fees[0]) {
                parseMap.put(key, fees[1]);
            } else {
                double addTime = parseMap.get(key) - fees[0];
                addTime = Math.ceil(addTime / fees[2]);
                int result = (int) (addTime * fees[3] + fees[1]);
                parseMap.put(key, result);
            }
        }
    }
}