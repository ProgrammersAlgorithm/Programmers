/*
유형: 
문제: 특정 색의 격자 개수로 카펫 크기(가로, 세로) 출력 
    - 가로 >= 세로
단서:
아이디어:
    1. 일단 옐로우를 먼저 배열
        - 어떤 수식?
        1개 -> 4면 +4
        2개 -> 4면 + 4면 -2 + 4
        3개 
        4개 -> 4면*4 -2*4 + 4
        6개 -> 4*6 -2*4 -3*4 + 4
        
        만약 0 을 배열했는데 직사각형일 경우
            - 직사각형? : 
        
    2. 노란색+갈색 한다음 두 수의 곱으로 나누기
       2+ 10 = 12
       1 12
       2 6
       3 4
       노란색은 1*2
       -> 1+2 * 2+2 = 3 * 4
       
       24 +24 = 48
       1 48
       2 24
       3 16
       4 12
       6 8
       ...
       노란색 24 = 1*24 = 2*12 = 3*8 = 4*6 ...
       4+2 * 6 +2  -> 맞아 떨어는 게 있음. ok
        
알고리즘:
    //1. 갈색 + 옐로우 두 수의 곱으로 표현
    
    //2. 엘로우 두 수 곱 표현
    
    //3. 엘로우 세로+2*가로+2 한게 있으면 답
    
    //4. 답은 큰 것 먼저 
    
    
시간복잡도: O((brown+yellow)*yellow)
레퍼런스:
효율화:
    -리팩토링: (전체 - 옐로우)로 즉시 구하는 게 더 나음.
    -구상 속도 개선
주의:
시간:
보완: 구현
 */
import java.util.*;
class Solution {
    public int[] solution(int brown, int yellow) {
        int[] answer = {};
        
        //1. 갈색 + 옐로우 두 수의 곱으로 표현
        int allLen = brown + yellow;
        List<int []> allMul = new ArrayList<>();
        
        for(int i=1; i<= allLen/2 ;i++){
            if(allLen%i == 0){
                allMul.add(new int [] {allLen/i,i});
            }
        }
        
        //2. 엘로우 두 수 곱 표현
        List<int []> yellowMul = new ArrayList<>();
        
        if(yellow == 1){//yellow 1일 때 예외 처리
            yellowMul.add(new int [] {yellow,1});
        }
        
        for(int i=1; i<= yellow/2 ;i++){ 
            if(yellow%i == 0){
                yellowMul.add(new int [] {yellow/i,i});
            }
        }

        //3. 엘로우 세로+2*가로+2 한게 있으면 답
        
        for(int [] i : allMul){
            for(int [] j: yellowMul){
                if(i[0] == j[0] + 2 && i[1] == j[1] +2){
                     //4. 답은 큰 것 먼저 
                    answer= i;
                    return answer;
                }      
            }
        } 
        
        return answer;
    }
}