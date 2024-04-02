package round06.thsamajiki;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;
import java.util.stream.Collectors;

class Task {
    String name;
    int startTime;
    int playTime;

    public Task(String name, String startTime, String playTime) {
        this.name = name;
        this.startTime = timeToMinute(startTime);
        this.playTime = Integer.parseInt(playTime);
    }

    public int timeToMinute(String start) {
        String[] arr = start.split(":");
        int h = Integer.parseInt(arr[0]) * 60;
        int m = Integer.parseInt(arr[1]);

        return h + m;
    }
}

public class 과제_진행하기 {
    public static void recursivePop(Stack<Task> stack, Task newTask, int curTime, List<String> answer) {
        if (stack.isEmpty()) return;

        Task curTask = stack.peek();
        if (curTime + curTask.playTime <= newTask.startTime){
            answer.add(stack.pop().name);

            recursivePop(stack, newTask, curTime + curTask.playTime, answer);
        } else {
            curTask.playTime -= newTask.startTime - curTime;
        }
    }

    public static String[] solution(String[][] plans) {
        List<Task> taskList = Arrays.stream(plans)
                .map(plan -> new Task(plan[0], plan[1], plan[2]))
                .collect(Collectors.toList());

        taskList.sort((o1, o2) -> {
            return o1.startTime - o2.startTime;
        });

        Stack<Task> stack = new Stack<>();
        List<String> answer = new ArrayList<>();

        int curTime = -1;

        for (int i = 0; i < taskList.size(); i++) {
            if (stack.isEmpty()) {
                stack.push(taskList.get(i));
                continue;
            }

            Task curTask = stack.peek();
            Task newTask = taskList.get(i);

            curTime = curTask.startTime;

            if (curTime + curTask.playTime <= newTask.startTime) {
                recursivePop(stack, newTask, curTime, answer);
            } else {
                curTask.playTime -= newTask.startTime - curTime;
            }

            stack.push(newTask);
        }

        while (!stack.isEmpty()) {
            answer.add(stack.pop().name);
        }

        return answer.toArray(new String[0]);
    }
}
