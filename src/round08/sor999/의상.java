/*
유형: Hash
문제: 다른 옷의 조합 개수 구하기
단서:
알고리즘:
//1. map만들기
//2. map에 의상 있으면 get, +1
//3. map에 의상 없으면 put, +1
시간복잡도: O(clothes.length)
*/
import java.util.*;
class Solution {
    public int solution(String[][] clothes) {
        //1. map만들기
        Map<String, Integer> map = new HashMap<>();
        for(String [] val: clothes){
            String kind = val[1];

            if(!map.containsKey(kind)){
                //3. map에 의상 없으면 put, +1
                map.put(kind, 1);
            }else{
                //2. map에 의상 있으면 get, +1
                map.put(kind, map.get(kind)+1);
            }
        }
        int answer = 1;

        for(int temp : map.values()){
            answer *= temp+1;
        }
        return answer -1;
    }
}