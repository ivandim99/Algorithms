package DynamicProgramming;

public class independentSetGraph {

    /*
     * Note that entry node[0] should be avoided, as nodes are labelled node[1] through node[n].
     */
    public static int weight(int n, int[] nodes) {
        // The memory array. mem[i] represents the optimal solution when considering the first i
        // nodes.
        int[] mem = new int[n + 1];
        // This represents the case where we have no nodes left.
        mem[0] = 0;
        // If we have only node left, might as well use it.
        mem[1] = nodes[1];
        // Now it is up to you, to fill the rest of the memory
        for (int i = 2; i <= n; i++) {
            //the best for the current mem is either the one before or the neighbour of that with the current node.
            mem[i] = Math.max(mem[i - 1],mem[i - 2] + nodes[i]);
        }
        // The optimal solution is when we consider all n nodes.
        return mem[n];
    }

}
