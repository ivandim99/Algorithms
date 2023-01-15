package Greedy;

import java.util.*;

public class silverTongueInc {

    /**
     * You should implement this method.
     *
     * @param n the number of opportunities.
     * @param s an array of size n+1, containing the names of the opportunities. You should ignore
     *     s[0]. (You may assume these to be unique, though we only use this assumption to check
     *     your answers, not in creating our reference solution).
     * @param d an array of size n+1, containing the durations of the opportunities in d[1] through
     *     d[n], you should ignore d[0].
     * @param r an array of size n+1, containing the revenue of the opportunities in r[1] through
     *     r[n], you should ignore r[0].
     * @param c an array of size n+1, containing the costs of the opportunities in c[1] through
     *     c[n], you should ignore c[0].
     * @return A schedule in the form of a hashmap: key = name of the opportunity, value = start
     *     time of the opportunity. If an opportunity should not be taken, make sure the key does
     *     not appear in the hashmap. For an example, see the public test.
     */
    public static Map<String, Integer> schedule(int n, String[] s, int[] d, int[] r, int[] c) {
        Map<String,Integer> ret = new HashMap<>();
        ArrayList<Opportunity> opportunities = new ArrayList<>();

        for(int i = 1; i <= n;i++) {
            opportunities.add(new Opportunity(s[i],d[i],r[i],c[i]));
        }
        Collections.sort(opportunities);

         int currTime = 0;
        for(int i = 0;i < n;i++) {
            if(opportunities.get(i).isWorth()) {
                ret.put(opportunities.get(i).name,currTime);
                currTime += opportunities.get(i).duration;
            }
        }
        return ret;
    }

    public static class Opportunity implements Comparable<Opportunity> {
        String name;
        int duration,revenue,cost;

        public Opportunity(String name,int duration,int revenue,int cost) {
            this.name = name;
            this.revenue = revenue;
            this.duration = duration;
            this.cost = cost;
        }

        public boolean isWorth() {
            return (this.revenue - this.cost) > 0;
        }

        @Override
        public int compareTo(Opportunity o) {
            return - (this.revenue - this.cost) / this.duration - (o.revenue - o.cost) / o.duration;
        }
    }

}
