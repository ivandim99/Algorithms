package DynamicProgramming;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class intervalPredecessor {


    public static int[] solve(int n, int[] s, int[] f, int[] v) {
        Pair[] startTimes = new Pair[n];
        Pair[] endTimes = new Pair[n];
        for (int i = 1; i <= n; i++) {
            startTimes[i - 1] = new Pair(i, s[i]);
            endTimes[i - 1] = new Pair(i, f[i]);
        }
        Arrays.sort(startTimes);
        Arrays.sort(endTimes);
        int j = 0;
        int[] p = new int[n + 1];
        for (int i = 0; i < n; i++) {
            if (endTimes[j].time > startTimes[i].time) {
                // current interval has no predecessor
                p[startTimes[i].index] = 0;
            } else {
                for (; j < n - 1; j++) {
                    // loop until we find the biggest endtime smaller than the starttime
                    if (endTimes[j + 1].time > startTimes[i].time) {
                        break;
                    }
                }
                p[startTimes[i].index] = endTimes[j].index;
            }
        }
        return p;
    }

    private static class Pair implements Comparable<Pair> {

        int index;

        int time;

        public Pair(int index, int time) {
            this.index = index;
            this.time = time;
        }

        @Override
        public int compareTo(Pair other) {
            int result = Integer.compare(this.time, other.time);
            return result == 0 ? Integer.compare(this.index, other.index) : result;
        }
    }
}
