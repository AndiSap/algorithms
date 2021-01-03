package greedy;

import java.util.*;

public class TaskScheduling {

    public int[] schedule(int[] start, int[] finish) {
        PriorityQueue<Task> tasks = new PriorityQueue<>((o1, o2) -> { // sort elements
            if(o1.start == o2.start)
                return 0;
            else if(o1.start < o2.start)
                return -1;
            else
                return 1;
        });

        for(int i = 0; i < start.length; i++) {
            tasks.add(new Task(i + 1, start[i], finish[i]));
        }

        ArrayList<Task> scheduled = new ArrayList<>();
        int currentFinish = 0;
//        int lastStart = -1;

        for(int i = 0; i < start.length; i++) {
            Task currentElement = tasks.poll();
            if (currentElement == null) continue;
            if(currentElement.start >= currentFinish /*&& currentElement.start > lastStart*/) { // take element
                currentFinish = currentElement.finish;
//                lastStart = currentElement.start;
                scheduled.add(currentElement);
            }
        }

        int[] solution = new int[scheduled.size()];
        for(int i = 0; i < scheduled.size(); i++)
            solution[i] = scheduled.get(i).id;

        return solution;
    }

    public int[] scheduleWithDeadlines(int[] deadline, int[] profit) {
        PriorityQueue<Dtask> tasks = new PriorityQueue<Dtask>(new Comparator<Dtask>() {
            @Override
            public int compare(Dtask o1, Dtask o2) {
                if(o1.deadline == o2.deadline) {
                    if(o1.profit == o2.profit)
                        return 0;
                    else if(o1.profit < o2.profit)
                        return 1;
                    else return -1;
                }
                else if (o1.deadline > o2.deadline)
                    return -1;
                else
                    return 1;
            }
        });
        for(int i = 0; i < deadline.length; i++)
            tasks.add(new Dtask(i + 1, deadline[i], profit[i]));

        int[] scheduled = new int[tasks.peek().deadline];
        PriorityQueue<Dtask> notUsed = new PriorityQueue<>((o1, o2) -> {
            if(o1.profit == o2.profit)
                return 0;
            if(o1.profit < o2.profit)
                return -1;
            else
                return 1;
        });

        int totalProfit = 0;

        int deadLineCurrent = tasks.peek().deadline;
        for(int i = 0; i < deadline.length; i++) {
            Dtask currentElement = tasks.peek();
            Dtask maxProfit = notUsed.peek();
            if(currentElement == null) continue;

            if(maxProfit != null && maxProfit.deadline != currentElement.deadline) {
                currentElement = notUsed.poll();
            }

            if(deadLineCurrent >= currentElement.deadline && deadLineCurrent > 0) {
                tasks.poll();
                scheduled[deadLineCurrent - 1] = currentElement.id;
                totalProfit += currentElement.profit;
            }
            else
                notUsed.add(currentElement);

            deadLineCurrent--;
        }

//        int[] solution = new int[scheduled.size()];
//        for(int i = 0; i < scheduled.size(); i++)
//            solution[i] = scheduled.get(i).id;

        System.out.println("TaskScheduling: total profit of: " + totalProfit);
        return scheduled;
    }

    public class Task {
        public int id;
        public int start;
        public int finish;

        public Task(int id, int start, int finish) {
            this.id = id;
            this.start = start;
            this.finish = finish;
        }
    }

    public class Dtask {
        public int id;
        public int deadline;
        public int profit;

        public Dtask(int id, int deadline, int profit) {
            this.id = id;
            this.deadline = deadline;
            this.profit = profit;
        }
    }
}

