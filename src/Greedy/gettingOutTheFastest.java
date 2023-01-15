package Greedy;

import java.util.*;

public class gettingOutTheFastest {

    class Node {

        List<Edge> outgoingEdges;

        int id;

        boolean marked;

        public Node(int id) {
            this.outgoingEdges = new ArrayList<>();
            this.marked = false;
            this.id = id;
        }
    }

    public static class Edge {

        int from, to, weight;

        public Edge(int from, int to, int weight) {
            this.from = from;
            this.to = to;
            this.weight = weight;
        }
    }


    /**
     * @param n the number of nodes
     * @param m the number of edges
     * @param s the starting vertex (1 <= s <= n)
     * @param t the ending vertex (1 <= t <= n)
     * @param edges the set of edges of the graph, with endpoints labelled between 1 and n
     *     inclusive.
     * @return the time required to get out, or -1 if it is not possible to get out.
     */
    public int getMeOuttaHere(int n, int m, int s, int t, Set<Edge> edges) {
        Map<Integer,Node> nodes = new HashMap<>();
        for(int i = 1;i <= n;i++) {
            nodes.put(i,new Node(i));
        }
        for(Edge edge : edges) {
            nodes.get(edge.from).outgoingEdges.add(edge);
        }
        return solve(s,t,nodes);
    }

    static int solve(int s,int t,Map<Integer,Node> nodes) {
        boolean[] visited = new boolean[nodes.size() + 1];
        int[] distances = new int[nodes.size() + 1];

        for(int i = 0; i < nodes.size() + 1; i++) {
            distances[i] = Integer.MAX_VALUE;
        }

        PriorityQueue<Tuple> queue = new PriorityQueue<>();
        queue.add(new Tuple(s,0));
        distances[s] = 0;

        while(!queue.isEmpty()) {
            Tuple curr = queue.poll();
            if(visited[curr.id]) {
                continue;
            }
            visited[curr.id] = true;
            if(curr.id == t) {
                return distances[curr.id];
            }

            for(Edge edge : nodes.get(curr.id).outgoingEdges) {
                int newDistance = distances[curr.id] + edge.weight;
                newDistance += nodes.get(curr.id).outgoingEdges.size();
                int neighbour = edge.to;

                if(!visited[neighbour] && newDistance < distances[neighbour]) {
                    Tuple newTuple = new Tuple(neighbour,newDistance);
                    distances[neighbour] = newTuple.cost;
                    queue.add(newTuple);
                }
            }
        }
        return visited[t] ? distances[t] :-1;
    }

    static class Tuple implements Comparable<Tuple> {
        int id,cost;

        public Tuple(int id,int cost) {
            this.id = id;
            this.cost = cost;
        }

        @Override
        public int compareTo(Tuple o) {
            return this.cost - o.cost;
        }
    }

}
