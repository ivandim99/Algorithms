package Greedy;

import java.util.ArrayList;
import java.util.Collections;
import java.util.PriorityQueue;

public class assigningWorkstations {

    /**
     * @param n number of researchers
     * @param m number of minutes after which workstations lock themselves
     * @param start start times of jobs 1 through n. NB: you should ignore start[0]
     * @param duration duration of jobs 1 through n. NB: you should ignore duration[0]
     * @return the number of unlocks that can be saved.
     */
    public static int solve(int n, int m, int[] start, int[] duration) {
        ArrayList<Work> works = new ArrayList<>();

        for(int i = 1;i <= n;i++) {
            works.add(new Work(start[i],duration[i]));
        }

        Collections.sort(works);

        int unlocksSaved = 0;
        PriorityQueue<Machine> machines = new PriorityQueue<>();

        for(Work w : works) {
            while (!machines.isEmpty()) {
                if(machines.peek().available > w.start) {
                    break;
                }

                Machine first = machines.poll();
                if(first.locked >= w.start) {
                    unlocksSaved++;
                    break;
                }
            }
            machines.add(new Machine(w.start + w.duration,w.start + w.duration + m));
        }
        return unlocksSaved;
    }


    public static class Machine implements Comparable<Machine> {
        int available,locked;

        public Machine(int available,int locked) {
            this.available = available;
            this.locked = locked;
        }

        @Override
        public int compareTo(Machine o) {
            return this.available - o.available;
        }
    }

    public static class Work implements Comparable<Work> {
        int start,duration;

        public Work(int start, int duration) {
            this.start = start;
            this.duration = duration;
        }

        public int compareTo(Work other) {
            return this.start - other.start;
        }
    }

}
