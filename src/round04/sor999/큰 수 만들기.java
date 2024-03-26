/*
유형: 그리디
문제: 조합의 최댓값
단서: 100만이 넘는 자리수 -> 백트래킹 불가. 다른 방법으로 가야
알고리즘:
//1. 숫자 분할해 int형으로
//2. len - k개 뽑기 조합 - 백트래킹
//3. 가장 큰수 갱신
틀린이유: 최대 100만이 자리수인 것 제대로 생각 안함. 백트래킹 인줄
 */

import java.util.*;
class Solution {
    int maxNum = 0;
    int [] intNum;
    int [] arr;
    boolean [] visit;
    public String solution(String number, int k) {

        //1. 숫자 분할해 int형으로
        String [] parseNum = number.split("");
        intNum = new int [parseNum.length];
        arr = new int [parseNum.length-k];
        visit = new boolean [parseNum.length];

        for(int i=0; i< parseNum.length; i++){
            intNum[i] = Integer.parseInt(parseNum[i]);
        }

        //2. len - k개 뽑기 조합 - 백트래킹

        dfs(0, 0, parseNum.length-k);

        return String.valueOf(maxNum);
    }


    public void dfs(int at, int depth, int len){
        if(depth == len){
            //3. 가장 큰수 갱신
            StringBuilder sb = new StringBuilder();
            for(int var : arr){
                sb.append(var);
            }
            int temp = Integer.parseInt(sb.toString());
            if(maxNum < temp){
                maxNum = temp;
            }
            return;
        }
        for(int i=at; i<intNum.length ; i++){
            if(!visit[i]){
                visit[i] = true;
                arr[depth] = intNum[i];
                dfs(i + 1, depth + 1, len);
                visit[i] = false;
            }
        }

    }
}