import java.util.*;

class Solution {
    private static final int MAX_TIME = 1000 + 500 * 1000;
    public int solution(int[][] param1) {
        List<Job> jobs = new ArrayList<>();
        for (int[] job : param1) jobs.add(new Job(job[0], job[1]));
        Collections.sort(jobs, (job1, job2) -> job1.reqTime - job2.reqTime);
        
        Queue<Job> Q = new LinkedList<>(jobs);
        PriorityQueue<Job> pq = new PriorityQueue<>();
        addPQ(Q, pq, Q.peek().reqTime);
              
        Job currentJob = pq.poll();
        int totalWaitTime = 0;
        
        for (int time = currentJob.reqTime; time <= MAX_TIME; time++) {
            addPQ(Q, pq, time);
            
            if (currentJob == null) {
                if (!pq.isEmpty()) currentJob = pq.poll();
                else continue;
            }
            
            if (currentJob.isFinish()) {
                totalWaitTime += (time - currentJob.reqTime);
                if(pq.isEmpty()) {
                    currentJob = null;
                    continue;
                }
                currentJob = pq.poll();
            }
            
            currentJob.progressTime++;
        }
        
        return totalWaitTime / jobs.size();
    }
    
    //파라미터의 reqTime와 요청시간이 같은 Job을 큐에서 꺼내서 PQ에 삽입.
    void addPQ(Queue<Job> Q, PriorityQueue<Job> pq, int reqTime) {
        while(!Q.isEmpty() && reqTime == Q.peek().reqTime) {
            pq.add(Q.poll());
        }
    }
}

class Job implements Comparable<Job> {
    int reqTime;
    int needTime;
    int progressTime;
    
    public Job(int reqTime, int needTime) {
        this.reqTime = reqTime;
        this.needTime = needTime;
    }
    
    @Override
    public int compareTo(Job o) {
        return this.needTime - o.needTime;
    }

    public boolean isFinish() {
        return needTime - progressTime == 0;
    }
}

