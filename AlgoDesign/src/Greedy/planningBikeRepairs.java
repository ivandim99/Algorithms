package Greedy;

import java.io .*;
import java.util .*;

public class planningBikeRepairs {
    static class Solution {

        // Implement the solve method to return the answer to the problem posed by the inputstream.
        public static String run(InputStream in) {
            return new Solution().solve(in);
        }

        public String solve(InputStream in) {
            Scanner sc = new Scanner(in);

            int n = sc.nextInt();

            Interval[] inters = new Interval[n];
            for (int i = 0; i < n; i++) {
                Interval inter = new Interval(sc.nextInt(), sc.nextInt());
                inters[i] = inter;
            }
            Arrays.sort(inters);
            int depth = 0;

            for (int i = 1; i < n; i++) {
                int overlap = 1;
                for (int j = 0; j < i; j++) {
                    if (inters[j].s + inters[j].l > inters[i].s) {
                        overlap++;
                    }
                }
                // System.out.println(overlap + " and " + i);
                if (depth < overlap) {
                    depth = overlap;
                }
            }
            return Integer.toString(depth);
        }

        private class Interval implements Comparable<Interval> {
            int s, l;

            public Interval(int start, int length) {
                this.s = start;
                this.l = length;
            }

            public int compareTo(Interval i) {
                return this.s - i.s;
            }

            public String toString(Interval i) {
                return "Interval" + s + ", " + l;
            }
        }
    }


}
