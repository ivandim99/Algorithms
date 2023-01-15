package Greedy;

import java.util.*;
import java.util.stream.Collectors;

public class ExperimentTime {

    /**
     * You should implement this method.
     *
     * @param n the number of experiments
     * @param t the time required to run an experiment t_1 through t_n. Note you should only use entries t[1] up to and including t[n].
     * @param f the fine per hour for an experiment f_1 through f_n. Note you should only use entries f[1] up to and including f[n].
     * @return the smallest fine for running all n experiments.
     */
    public static int prioritisingExperiments(int n, int[] t, int[] f) {
        ArrayList<Experiment> experiments = new ArrayList<>();
        for(int i = 1; i <= n;i++) {
            experiments.add(new Experiment(t[i],f[i]));
        }

        Collections.sort(experiments);

        int currTime = 0;
        int res = 0;
        for(int i = 0;i < n ; i++) {
            currTime += experiments.get(i).time;
            res += currTime * experiments.get(i).fine;
        }
        return res;
    }

    public static class Experiment implements Comparable<Experiment> {

        int time,fine;

        public Experiment(int time,int fine) {
            this.time = time;
            this.fine = fine;
        }

        @Override
        public int compareTo(Experiment o) {
            double ratio1 = this.fine / (double) this.time;
            double ratio2 = o.fine / (double) o.time;
            return Double.compare(ratio1, ratio2);
        }
    }



}
