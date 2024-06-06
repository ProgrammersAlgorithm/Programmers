/*
유형: dfs
문제: 단어 변환하는데 최소 횟수
알고리즘:
// 1. i번째 글자가 같고 다른 글자는 모두 다른 것 찾기, 방문 표시, 현재 글자로 채택
// 2. target == words 때까지 cnt++
시간복잡도: O(begin.length()^2*words.length)

*/

import java.util.*;
class Solution {
    private static boolean [] visit;
    private static int n;
    private static int wordLen;
    private static String[] str;
    private static int answer=0;
    public int solution(String begin, String target, String[] words) {
        visit = new boolean[words.length];
        n = words.length;
        wordLen = begin.length(); //단어의 길이는 모두 같음
        str = words;
        dfs(begin,target, 0);
        return answer;
    }

    public void dfs(String cur,String target, int cnt){
        // 2. target == words 때까지 cnt++
        if(target.equals(cur)){
            answer = cnt;
            return;
        }

        for(int i=0; i< n; i++){
            if(!visit[i]){
                // 1. i번째 글자가 같고 다른 글자는 모두 다른 것 찾기, 방문 표시, 현재 글자로 채택
                int temp = 0;
                for(int j=0; j< wordLen; j++){
                    if (cur.charAt(j) != str[i].charAt(j)) {
                        temp++;
                    }
                }
                if(temp != 1) continue;
                visit[i] = true;
                dfs(str[i], target, cnt+1);
                visit[i] = false;
            }
        }
    }
}
