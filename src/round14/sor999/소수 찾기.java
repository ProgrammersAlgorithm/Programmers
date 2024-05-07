/*
알고리즘: 완전탐색 - 백트래킹
문제: 소수 찾기

 */
import java.util.*;

class Solution {

    Set<Integer> numSet = new HashSet<>();
    public static int[] arr;
    String[] numArr;
    boolean[] visit;

    public int solution(String numbers) {
        int answer = 0;

        //1. 배열에 나눠 담기.
        numArr = numbers.split("");
        int n = numArr.length;
        arr = new int[n];
        visit = new boolean[n];

        //2. 모든 조합의 숫자 만들기 - 백트래킹
        for (int i = 1; i <= numArr.length; i++) {
            dfs(0, i);
        }

        //3. 나누기 연산으로 소수 찾기
        for (int val : numSet) {
            if (val <= 1) continue;
            boolean isPrime = true;
            for (int i = 2; i * i <= val; i++) {
                if (val % i == 0) {
                    isPrime = false;
                    break;
                }
            }
            if (isPrime) {
                answer++;
            }
        }
        return answer;
    }

    public void dfs(int depth, int len) {
        if (depth == len) {
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < len; i++) {
                sb.append(arr[i]);
            }
            numSet.add(Integer.parseInt(sb.toString()));
            return;
        }

        for (int i = 0; i < numArr.length; i++) {
            if (!visit[i]) {
                visit[i] = true;
                arr[depth] = Integer.parseInt(numArr[i]);
                dfs(depth + 1, len);
                visit[i] = false;
            }
        }
    }
}