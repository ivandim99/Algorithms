package NetworkFlow;

import java.util.ArrayList;
import java.util.List;

public class HospitalAssignment {

    /**
     * Checks if all patients can be assigned to the hospital given the constraints.
     * @param n                 The number of patients
     * @param k                 The number of hospitals
     * @param patients          List of patient locations
     * @param hospitals         List of hospital locations
     * @param preferredDistance Preferred distance within which a patient can be assigned to a hospital.
     * @return True iff all patients can be assigned to at least one hospital within the preferred distance
     */
    public static boolean isAssignmentPossible(int n, int k, List<Location> patients, List<Location> hospitals, int preferredDistance) {
        List<Node> nodes = new ArrayList<>();
        Node source = new Node(-1, 0);
        Node sink = new Node(-2, 0);
        nodes.add(source);
        nodes.add(sink);
        // Create nodes for patients and hospitals
        Node[] patientNodes = new Node[n];
        Node[] hospitalNodes = new Node[k];
        // TODO Create the graph

        for(int i = 0; i < k; i++) {
            hospitalNodes[i] = new Node(i);
            nodes.add(hospitalNodes[i]);
            source.addEdge(hospitalNodes[i],(int) Math.ceil( n / k));
        }

        for(int i = 0; i < n; i++) {
            patientNodes[i] = new Node(i);
            nodes.add(patientNodes[i]);
            patientNodes[i].addEdge(sink,1);
        }

        for(int i = 0; i < k; i++) {
            for(int j = 0; j < n; j++) {
                int dist = patients.get(j).distance(hospitals.get(i));
                if(dist <= preferredDistance) {
                    hospitalNodes[i].addEdge(patientNodes[j],1);
                }
            }
        }

        Graph g = new Graph(nodes, source, sink);
        int maxFlow = MaxFlow.maximizeFlow(g);
        // @Remove return feasibility
        // checks if all patients were assigned (alternatively can be done with hospitals)
        return maxFlow == n;
    }

}
