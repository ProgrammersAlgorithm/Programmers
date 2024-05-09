/*
유형: 해쉬
문제: 게임을 할 때 가장 먼저 중복되는 (단어 인덱스 +1), 반복 cnt 구하기
    - 겹치는 단어 x
    - 마지막 글자가 다음 첫 글자
알고리즘:
//1. for문 돌면서 set에 넣기
//2. 이미 set에 값이 있을 때까지
//3. 만약 전 단어의 끝자리와 후 단어의 첫자리가 다름
//4. 답은 size%n+1, size/n+1

*/

import java.util.*;
class Solution {
    public int[] solution(int n, String[] words) {
        Set<String> set = new HashSet<>();
        //1. for문 돌면서 set에 넣기
        set.add(words[0]);
        for(int i=1; i<words.length; i++){
            String before = words[i-1];
            String after = words[i];


            //2. 이미 set에 값이 있을 때까지
            if(set.contains(words[i])){
                return new int [] {set.size()%n+1, set.size()/n+1};
            }

            //3. 만약 전 단어의 끝자리와 후 단어의 첫자리가 다름
            if(before.charAt(before.length()-1)!= after.charAt(0)){
                //4. 답은 size%n+1, size/n+1
                return new int [] {set.size()%n+1, set.size()/n+1};
            }

            set.add(words[i]);

        }
        return new int [] {0, 0};
    }
}