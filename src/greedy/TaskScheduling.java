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

    /**
     * Task scheduling in O(nlogn)
     */
    public int[] scheduleWithDeadlines(int[] deadline, int[] profit) {
        ArrayList<Dtask> tasks = new ArrayList<>();
        for(int i = 0; i < deadline.length; i++)
            tasks.add(new Dtask(i + 1, deadline[i], profit[i]));

        Collections.sort(tasks, new Comparator<Dtask>() {
            @Override
            public int compare(Dtask o1, Dtask o2) {
                if(o1.profit == o2.profit) {
                    return o2.deadline - o1.deadline;
                }
                else
                    return o2.profit - o1.profit;
            }
        });

        int[] scheduled = new int[deadline.length];
        TreeSet<Integer> slots = new TreeSet<>();
        for(int i = 0; i < deadline.length; i++)
            slots.add(i);

        int totalProfit = 0;

        for(int i = 0; i < deadline.length; i++) {
            Dtask currentElement = tasks.get(i);
            Integer toBeInserted = slots.floor(currentElement.deadline - 1); // get slot less or equal to current deadline

            if (toBeInserted != null) {
                slots.remove(toBeInserted);
                scheduled[toBeInserted] = currentElement.id;
                totalProfit += currentElement.profit;
            }
        }

        System.out.println("TaskScheduling: total profit of: " + totalProfit);
        return scheduled;
    }

    /**
     * Task scheduling in O(n*n)
     */
    public int[] scheduleWithTime(int[] deadlines, int[] profit) {
        ArrayList<Dtask> tasks = new ArrayList<>();
        for(int i = 0; i < deadlines.length; i++)
            tasks.add(new Dtask(i + 1, deadlines[i], profit[i]));

        Collections.sort(tasks, (o1, o2) -> o2.profit - o1.profit);

        int[] solution = new int[deadlines.length];
        int totalProfit = 0;

        for(int i = deadlines.length; i > 0; i--) {
            for(int j = 0; j < tasks.size(); j++) {
                if(tasks.get(j).deadline >= i) {
                    solution[i - 1] = tasks.get(j).id;
                    totalProfit += tasks.get(j).profit;
                    tasks.remove(j);
                    break;
                }
            }
        }

        System.out.println("Task scheduling total Profit: " + totalProfit);
        return solution;
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

