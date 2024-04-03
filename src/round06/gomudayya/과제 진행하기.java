import java.util.*;

class Solution {
    
    List<String> answer = new ArrayList<>();
    
    public String[] solution(String[][] plans) {
        PriorityQueue<Work> pq = new PriorityQueue<>();
        Stack<Work> stack = new Stack();
        
        for (String[] plan : plans) {
            pq.add(Work.of(plan[0], plan[1], plan[2]));
        }
        
        //simulate
        while(!pq.isEmpty()) {
            Work now = pq.poll();
            Work next = pq.isEmpty() ? Work.MAX_TIME_WORK() : pq.peek();
            
            //남는 시간이 있을 떄
            if (now.getEndTime() < next.time) {
                answer.add(now.name);
                
                int remainTime = next.time - (now.getEndTime());
                processStopWork(stack, remainTime);
            }

            //시간이 알맞게 끝날 때
            else if (now.getEndTime() == next.time) {
                answer.add(now.name);
            }   
            
            //시간이 부족해 과제를 하다가 멈춰야할 경우
            else if (now.getEndTime() > next.time) {
                int workTime = next.time - now.time;
                now.playTime -= workTime;
                
                stack.add(now);
            }
            
        }
        
        return parseToArray(answer);
    }
    
    String[] parseToArray(List<String> answer) {
        String[] ret = new String[answer.size()];
        for (int i = 0; i < answer.size(); i++) {
            ret[i] = answer.get(i);
        }
        return ret;
    }
    
    void processStopWork(Stack<Work> stack, int remainTime) {
        while(remainTime > 0 && !stack.isEmpty()) {
            Work stopWork = stack.pop();
            
            if (remainTime < stopWork.playTime) {
                stopWork.playTime -= remainTime;
                stack.add(stopWork);
                return;
            }
            
            if (remainTime == stopWork.playTime) { // 이 조건을 빼먹어서 테케 6, 9, 18이 통과하지 못함.
                answer.add(stopWork.name);
                return;
            }

            answer.add(stopWork.name);
            remainTime -= stopWork.playTime;
        }
    }
}

class Work implements Comparable<Work> {
    String name;
    int time;
    int playTime;

    private Work(String name, int time, int playTime) {
        this.name = name;
        this.time = time;
        this.playTime = playTime;
    }
    
    public static Work of(String name, String sTime, String sPlayTime) {
        int hour = Integer.parseInt(sTime.substring(0, 2));
        int minute = Integer.parseInt(sTime.substring(3));;
        
        int time = 60 * hour + minute;
        int playTime = Integer.parseInt(sPlayTime);
        
        return new Work(name, time, playTime);
    }
    
    public static Work MAX_TIME_WORK() {
        return new Work("MAX_TIME_WORK", Integer.MAX_VALUE, 0);
    }
    
    @Override
    public int compareTo(Work o) {
        return this.time - o.time;
    }
    
    @Override
    public String toString() {
        return String.format("%s, %d, %d", name, time, playTime);
    }
    
    public int getEndTime() {
        return time + playTime;
    }
}