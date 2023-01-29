package NetworkFlow;

import java.util.ArrayList;

public class MedicineDistribution {

    /**
     * You should implement this method
     *
     * @param n the number of doctors
     * @param m the number of shipments
     * @param k the number of vaccine types
     * @param a the number of shipments a doctor can process from index _1_ to _n_. You should
     *     ignore a[0].
     * @param t the type of a shipment from index _1_ to _m_. You should ignore t[0]. A type is
     *     denoted with an integer 1 <= t[j] <= k.
     * @param c the compatibility of doctors and shipments. Doctor 1 <= i <= n can do shipment 1 <=
     *     j <= m iff c[i][j] = true. You should ignore c[0][x] and c[x][0].
     * @return true iff we can use all the shipments of vaccines, remembering that doctors can do at
     *     most 2 shipments of the same type.
     */
    public static boolean needAMedic(int n, int m, int k, int[] a, int[] t, boolean[][] c) {
        ArrayList<Node> nodes = new ArrayList<>();
        Node source = new Node(-1,0);
        Node sink = new Node(-2,0);
        nodes.add(source);
        nodes.add(sink);

        Node[] doctors = new Node[n+1];
        Node[] shipments = new Node[m+1];
        Node[][] docToType = new Node[n+1][k+1];

        for(int i = 1; i <= n; i++) {
            Node doctor = new Node(i,0);
            doctors[i] = doctor;
            nodes.add(doctors[i]);
            source.addEdge(doctors[i],0,a[i]);
        }

        for(int i = 1; i <= m; i++) {
            Node shipment = new Node(i,0);
            shipments[i] = shipment;
            nodes.add(shipments[i]);
            shipments[i].addEdge(sink,0,1);
        }

        for(int i = 1; i <= n; i++) {
           for(int j = 1; j <= k; j++) {
               Node node = new Node(i+j,0);
               docToType[i][j] = node;
               nodes.add(docToType[i][j]);
               doctors[i].addEdge(docToType[i][j], 0, 2);
           }
        }

        for(int i = 1; i <= n; i++) {
            for(int j = 1; j <= m; j++) {
                docToType[i][t[j]].addEdge(shipments[j], 0, 1);
            }
        }

        Graph g = new Graph(nodes,source,sink);

        return MaxFlow.maximizeFlow(g) == m;
    }

}
