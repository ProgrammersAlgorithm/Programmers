class 양궁대회 {
    static private int[] lionInfo = new int[11]; // 점수차가 최대일때 라이언이 쏜 화살 배열
    static private int[] answer = { -1 };
    static private int max = Integer.MIN_VALUE; // 최대값

    public int[] solution(int n, int[] info) {
        dfs(0, n, info);

        if(max == -1) {
            answer = new int[1];
            answer[0] = -1;
        }

        return answer;
    }

    public static void dfs(int L, int n, int[] info) {
        if(L == n) {
            int diff = scoreDiff(info);

            if(max <= diff) {
                max = diff;
                answer = lionInfo.clone();
            }

            return;
        }
        
        for(int i = 0; i < info.length && lionInfo[i] <= info[i]; i++) {
            lionInfo[i] += 1;
            dfs(L + 1, n, info);
            lionInfo[i] -= 1;
        }
    }

    public static int scoreDiff(int[] info) {
        int apeachScore = 0;
        int lionScore = 0;

        for(int i = 0; i < lionInfo.length; i++) {
            if(info[i] == 0 && lionInfo[i] == 0) continue;
            if(info[i] >= lionInfo[i]) apeachScore += (10 - i);
            else lionScore += (10 - i);
        }

        int diff = lionScore - apeachScore;

        if(diff <= 0) {
            return -1;
        }

        return diff;
    }
}
