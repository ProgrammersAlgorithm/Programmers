/*
유형: 우선순위 큐
문제: 작은 두 값들 계속 더해서 연산 횟수 출력
단서: 계속적인 정렬
알고리즘:
//1. 큐에 넣기
//2. 2개씩 꺼내서 연산후 다시 삽입
//3. q.size() == 1 일 때 예외처리
틀린이유: q.size() == 1 일 때 무한 루프 눈치 못챔
 */

import java.util.*;
class Solution {
    int cnt =0;
    PriorityQueue<Integer> q  = new PriorityQueue<>();

    public int solution(int[] scoville, int K) {
        int answer = -1;

        for(int val : scoville){
            q.offer(val);
        }

        while(!q.isEmpty()){
            if(q.peek() >= K){
                answer = cnt;
                break;
            }else if(q.size() == 1){
                break;
            }

            if(q.size() >=2){
                q.offer(q.poll() + q.poll()*2);
                cnt++;
            }

        }
        return answer;
    }

}