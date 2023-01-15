package Greedy;

import java.util.ArrayList;
import java.util.Collections;

public class planningBikeRepairs {

    public static int fixMyBikesPlease(int n, int[] starttimes, int[] durations) {

        ArrayList<Interval> intervals = new ArrayList<>();
        for(int i = 1; i <= n; i++) {
            intervals.add(new Interval(starttimes[i],durations[i]));
        }

        Collections.sort(intervals);

        int mostworkers = 0;
        for(int i = 1; i < intervals.size(); i++) {
            int currworkers = 1;
            for(int j = 0; j < i; j++) {
                int somePreviousStart = intervals.get(j).start;
                int somePreviousDuration = intervals.get(j).duration;
                int currStart = intervals.get(i).start;
                int currDuration = intervals.get(i).duration;
                if( somePreviousStart + somePreviousDuration > currStart) {
                    currworkers++;
                }
                if(mostworkers < currworkers) {
                    mostworkers = currworkers;
                }
            }
        }

        return mostworkers;
    }

    public static class Interval implements Comparable<Interval> {

        int start,duration;

        public Interval(int start,int duration) {
            this.start = start;
            this.duration = duration;
        }

        @Override
        public int compareTo(Interval o) {
            return this.start - o.start;
        }
    }

    }
