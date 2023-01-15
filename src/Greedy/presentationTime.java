package Greedy;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

public class presentationTime {

    /**
     * You should implement this method.
     *
     * @param n              the number of students
     * @param presenterNames the names of the presenters p_1 through p_n. Note you should only use entries presenterNames[1] up to and including presenterNames[n].
     * @param startTimes     the start times of the presentations s_1 through s_n. Note you should only use entries startTimes[1] up to and including startTimes[n].
     * @param endTimes       the end times of the presentations e_1 through e_n. Note you should only use entries endTimes[1] up to and including endTimes[n].
     * @return the largest possible set of presenters whose presentation we can attend.
     */
    public static Set<String> whatPresentations(int n, String[] presenterNames, int[] startTimes, int[] endTimes) {
        ArrayList<Presentation> presentations = new ArrayList<>();
        for(int i = 1; i <= n; i++) {
            presentations.add(new Presentation(presenterNames[i],startTimes[i],endTimes[i]));
        }
        Collections.sort(presentations);

        Set<String> ret = new HashSet<>();
        ret.add(presentations.get(0).presenterName);
        int currEnd = presentations.get(0).end;
        for(int i = 1; i < n;i++) {
            if(currEnd <= presentations.get(i).start) {
                ret.add(presentations.get(i).presenterName);
                currEnd = presentations.get(i).end;
            }
        }
        return ret;
    }

    static class Presentation implements Comparable<Presentation> {
        String presenterName;
        int start,end;

        public Presentation(String presenterName,int start,int end) {
            this.presenterName = presenterName;
            this.start = start;
            this.end = end;
        }

        @Override
        public int compareTo(Presentation o) {
            return this.end - o.end;
        }
    }

}
