/*
문제: 한 번호가 다른 번호의 접두어인 경우 체크
    -중복x
단서: 중복X -> 맵 키
알고리즘:
//1. numMap 만들기, 전처리

//2. 각각의 string 0~끝길이 만큼 잘라서 검색
틀린이유: 효율성 통과 못함
주의: key 말고 value 검색하면 효율성 통과 못함
*/
import java.util.*;
class Solution {

    public boolean solution(String[] phone_book) {

            //시도1
//         // 각각의 string 0~끝길이 만큼 잘라서 검색
//         for (int i = 0; i < phone_book.length; i++) {
//             for (int j = 0; j < phone_book.length; j++) {
//                 if(i==j) continue;
//                 if(phone_book[i].length() <= phone_book[j].length()){
//                     if(phone_book[i].equals(phone_book[j].substring(0, phone_book[i].length())))
//                         return false;
//                 }
//             }
//         }
//         return true;


        //시도2 - 답봄

        //1. numMap 만들기, 전처리
        Map<String,String> numMap = new HashMap<>();
        for(int i =0; i< phone_book.length; i++){
            numMap.put(phone_book[i], "0");
        }

        //2. 각각의 string 0~끝길이 만큼 잘라서 검색
        for (int i = 0; i < phone_book.length; i++) {
            for (int j = 0; j < phone_book[i].length(); j++) {
                if(numMap.containsKey(phone_book[i].substring(0,j))) return false;
            }
        }

        return true;
    }
}