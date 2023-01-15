package Greedy;

import java.util.*;

public class TaskMaster {

    /**
     * You should implement this method.
     *
     * @param n the number of tasks available
     * @param taskNames the names of the tasks d_1 through d_n. Note you should only use entries
     *     taskNames[1] up to and including taskNames[n].
     * @param startTimes the start times of the tasks s_1 through s_n. Note you should only use
     *     entries startTimes[1] up to and including startTimes[n].
     * @return the names of a largest possible set of tasks you can complete.
     */
    public static Set<String> winningTheTrophy(int n, String[] taskNames, int[] startTimes) {

        Set<String> ret = new HashSet<>();
        ArrayList<Task> tasks = new ArrayList<>();

        for(int i = 1; i <= n;i++) {
            tasks.add(new Task(taskNames[i],startTimes[i]));
        }
        Collections.sort(tasks);

        int currEnd = tasks.get(0).start + 5;
        ret.add(tasks.get(0).name);
        for(int i = 1;i < n;i++) {
            if(tasks.get(i).start >= currEnd) {
                ret.add(tasks.get(i).name);
                currEnd = tasks.get(i).start + 5;
            }
        }
        return ret;
    }

    public static class Task implements Comparable<Task> {

        String name;
        int start;

        public Task(String name,int start) {
            this.name = name;
            this.start = start;
        }

        @Override
        public int compareTo(Task o) {
            return this.start - o.start;
        }
    }

}
