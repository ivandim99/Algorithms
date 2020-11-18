package Greedy;

import java.util.ArrayList;
import java.util.Collections;
import java.util.PriorityQueue;


public class optimal_workstations {

    public static /**
     * @param n number of researchers
     * @param m number of minutes after which workstations lock themselves
     * @param start start times of jobs 1 through n. NB: you should ignore start[0]
     * @param duration duration of jobs 1 through n. NB: you should ignore duration[0]
     * @return the number of unlocks that can be saved.
     */
    int solve(int n, int m, int[] start, int[] duration) {
        int unlocks_saved = 0;

        ArrayList<Job> jobs = new ArrayList<>();

        for(int i = 1;i <= n;i++) {
            jobs.add(new Job(start[i],duration[i]));
        }

        Collections.sort(jobs);
        PriorityQueue<Machine> machines = new PriorityQueue<>();

        for(Job job : jobs) {
            while(!machines.isEmpty()) {
                //in this case the machine wont be available we go to add a new one
                if(machines.peek().available > job.s) {
                    break;
                }

                Machine mach = machines.poll();
                //if tha machine is not yet locked we add a saved unlock
                if(mach.locked >= job.s) {
                    unlocks_saved++;
                    break;
                }
            }
            //we make a new machine if we have gone through our whole queue and all are busy or if thats our first job
            machines.add(new Machine(job.s + job.d,job.s + job.d + m));
        }

        return unlocks_saved;
    }


    private static class Job implements Comparable<Job> {
        int s,d;

        public Job(int start,int duration) {
            this.s = start;
            this.d = duration;
        }

        public int compareTo(Job i) {
            return Integer.compare(s, i.s);
        }
    }

    private static class Machine implements Comparable<Machine> {

        public int available;

        public int locked;

        public Machine(int available, int locked) {
            this.available = available;
            this.locked = locked;
        }

        @Override
        public int compareTo(Machine i) {
            return Integer.compare(locked, i.locked);
        }
    }
    public static void main(String[] args){
        int n = 5;
        int m = 10;

        int[] start = {0,2,1,17,3,15};
        int[] duration = {0,6,2,7,9,6};

        int k = solve(n,m,start,duration);
        System.out.println(k);
    }
}
