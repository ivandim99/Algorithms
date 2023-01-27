package NetworkFlow;

import java.util.ArrayList;
import java.util.List;

public class ProjectSelection {

    /**
     * You should implement this method
     *
     * @param projects List of projects, you can ignore list.get(0)
     * @return A set of feasible projects that yield the maximum possible profit.
     */
    public static int maximumProjects(List<Project> projects) {
        List<Node> nodes = new ArrayList<>();
        // Add nodes for each project
        int n = projects.size();
        for (Project project : projects) {
            nodes.add(new Node(project.getId()));
        }
        // Add source and sink
        Node source = new Node(-1, 0);
        Node sink = new Node(-2, 0);
        nodes.add(source);
        nodes.add(sink);
        // TODO

        int C = 0;
        for(Project project : projects) {
            int profit = project.getRevenue() - project.getCost();
            if(profit > 0) {
                source.addEdge(nodes.get(project.getId() - 1), profit);
                C += profit;
            }
            else
                nodes.get(project.getId() - 1).addEdge(sink,-profit);
        }


        for(Project project : projects) {
            List<Integer> reqs = project.getRequirements();
            for(int req : reqs) {
                nodes.get(project.getId() - 1).addEdge(nodes.get(req - 1),C + 1);
            }
        }

        // TODO Add projects and their prerequisites to the NF graph

        Graph g = new Graph(nodes, source, sink);
        // TODO Calculate max profit

        // TODO

        return C - MaxFlow.maximizeFlow(g);
    }

}
