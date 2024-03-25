/*
유형: 백트래킹, dfs
문졔: 라이언이 최대 점수차로 우승하기 위한 과녁 점수 출력
    - 무조건 지거나 비기면 -1
단서: 공통점을 발견할 수 없으므로 전부 탐색해야 하는데 경우의 수가 너무 많으니 백트래킹으로. '여러 경로의 최대 값' = dfs
아이디어: 1. dfs - 깊이 n일때 끊기
알고리즘:
    1.dfs
      if(depth==n)
            점수 차를 구하기
            maxScore < 점수차 -> 갱신

    2.score
    3.예외처리
        라이언 무조건 못이길 시
시간복잡도:
레퍼런스: https://record-developer.tistory.com/124
*/
import java.util.*;
class Solution {
    static int maxScore = -1;//최대값
    static int[] ans = {-1};
    static int[] temp = new int[11];// 최대 점수차인 라이언의 과녁점수
    public int[] solution(int n, int[] info) {
        dfs(n,info,0);
        if(maxScore==-1) {//라이언이 어피치를 못 이길떄
            ans = new int[1];
            ans[0]=-1;
        }

        return ans;
    }

    public static void dfs(int n, int [] info, int depth){
        if(depth == n){ //모든 화살을 맞혔다면


            int difference = score(info); //모든 점수의 차이 구하기
            if(maxScore<=difference){ //차이가 원래 max보다 크거나 같으면 !주의! 가장 낮은 점수를 가장 많이 맞힌 경우를 선택해야 하므로 '=' 이 들어감
                maxScore = difference; // 최댓값 갱신
                ans = temp.clone(); //임시 화살 배열 가져옴
            }
            return;
        }

        for(int i= 0; i < info.length; i++){ // 작은 것부터
            if(temp[i] > info[i]) break; //라이언 화살이 더 많은 경우 바로 종료
            temp[i]++;
            dfs(n, info, depth+1);
            temp[i]--;
        }

    }

    public static int score(int[] info){
        int a=0; //어피치 화살수 총 합
        int l=0; //라이언 화살수 총 합
        for(int i=0; i<info.length; i++){
            if(info[i]==0 && temp[i]==0) continue;// 라이언 어피치 모두 0개 맞췄을 때 패쓰
            int score = 10-i;
            if(info[i] >= temp[i]){
                a += score;
            }else{
                l += score;
            }
        }
        int difference = l - a; //모든 화살수
        return (difference>0) ? difference : -1; // 모든 화살 수 차이 리턴

    }
}