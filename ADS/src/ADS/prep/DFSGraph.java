//package ADS.DataStructures.prep;
//
//import java.util.*;
//
///**
// * Implements a Depth first traversal of the Graph, starting at contructor vertex v. It
// * should return nodes at most once. If there is a choice between multiple next nodes,
// * always pick the lowest id node.
// */
//class GraphIterator implements Iterator<Vertex> {
//    private Graph g;
//    private Vertex v;
//    private Stack<Vertex> stack;
//    private Set<Vertex> colored;
//    private int graphSize;
//
//    public GraphIterator(Graph g, Vertex v) {
//        this.g = g;
//        graphSize = g.getAllVertices().size();
//        stack = new Stack<Vertex>();
//        colored = new TreeSet<Vertex>();
//        stack.push(v);
//    }
//
//    @Override
//    public boolean hasNext() {
//        return (!stack.isEmpty()) && (colored.size() != graphSize);
//    }
//
//    @Override
//    public Vertex next() {
//        Vertex ret = stack.pop();
//        ArrayList<Vertex> neighbours = (ArrayList<Vertex>) g.getNeighbours(ret);
//        colored.add(ret);
//        for(int i = neighbours.size() - 1;i >= 0;i--) {
//            if(!colored.contains(neighbours.get(i))) stack.push(neighbours.get(i));
//        }
//        return ret;
//    }
//
//}
//
