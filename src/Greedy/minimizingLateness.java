package Greedy;

import java.util.ArrayList;
import java.util.Collections;

public class minimizingLateness {

    /**
     * @param n the number of jobs
     * @param t the times of jobs 1 through n, NB: you should ignore t[0]
     * @param d the deadlines of the jobs 1 through n. NB: you should ignore deadlines[0]
     * @return the minimised maximum lateness L.
     */
    public static int solve(int n, int[] t, int[] d) {

        ArrayList<Job> jobs = new ArrayList<>();
        for(int i = 1;i <= n; i++) {
            System.out.println(t[i]);
            System.out.println(d[i]);

            jobs.add(new Job(t[i],d[i]));
        }

        Collections.sort(jobs);

        int lateness = Integer.MIN_VALUE;
        int currTime = 0;
        for(int j = 0; j < jobs.size(); j++) {
            int currLateness = currTime + jobs.get(j).t - jobs.get(j).d;
            if(lateness < currLateness) lateness = currLateness;
            currTime += jobs.get(j).t;
        }

        return lateness;
    }

    public static class Job implements Comparable<Job> {

        int t,d;

        public Job(int t, int d) {
            this.t = t;
            this.d = d;
        }

        public int compareTo(Job other) {
            return Integer.compare(this.d,other.d);
        }
    }
}
