/*
알고리즘: 해시

 */
import java.util.*;
class Solution {
    public int[] solution(String[] genres, int[] plays) {
        int[] answer = {};
        Map<String, Integer> genreNum = new HashMap<>();
        Map<Integer, int [] > map = new HashMap<>();

        /*
        1. 장르 재생 횟수
        2. 노래 재생 횟수
        3. 고유 번호
        */
        int n = plays.length;
        //1. 장르 재생 횟수 구하기

        for(int i =0; i < n; i++){
            if(genreNum.containsKey(genres[i]))
            {

                genreNum.put(genres[i], genreNum.get(genres[i]) + plays[i]);

            }else{

                genreNum.put(genres[i],plays[i]);
            }

        }
        //2. 노래 재생 횟수 세팅
        for(int i=0; i< n; i++){
            map.put(i, new int[]{genreNum.get(genres[i]), plays[i]});
        }


        //3. 정렬
        return map.keySet().stream()
                .mapToInt(Integer::intValue)
                .toArray();
    }
}