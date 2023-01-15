package Greedy;

import java.util.ArrayList;
import java.util.Collections;

public class cyclingToCopenhagen {

    public ArrayList<String> cycling(int[] campsites, String[] names, int maxD) {
        ArrayList<CampSite> sites = new ArrayList<>();
        for(int i=0; i<campsites.length; i++) {
            sites.add(new CampSite(campsites[i],names[i]));
        }
        Collections.sort(sites);
        int stops = 0;
        ArrayList<String> stopNames = new ArrayList<>();
        int currdistance = sites.get(0).distance;
        for(int i = 1;i < sites.size() - 1;i++) {
            if(currdistance > maxD) {
                stops++;
                stopNames.add(sites.get(i-1).name);
                currdistance = 0;
            }
            currdistance += sites.get(i).distance - sites.get(i - 1).distance;
        }
        return stopNames;
    }

    public class CampSite implements Comparable<CampSite> {
        int distance;
        String name;

        public CampSite(int distance, String name) {
            this.distance = distance;
            this.name = name;
        }

        @Override
        public int compareTo(CampSite o) {
            return Integer.compare(distance, o.distance);
        }
    }

}
