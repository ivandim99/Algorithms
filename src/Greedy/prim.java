//package Greedy;
//
//import java.util.ArrayList;
//import java.util.List;
//import java.util.PriorityQueue;
//
//public class PrimsAlgorithm {
//    // Adjacency list representation of the graph
//    private List<List<Edge>> adjacencyList;
//
//    // Priority queue to keep track of the cheapest edge
//    // that connects a vertex in the existing tree to
//    // a vertex not in the existing tree
//    private PriorityQueue<Edge> queue;
//
//    // Array to keep track of which vertices are in the tree
//    private boolean[] inTree;
//
//    // Minimum spanning tree represented as a list of edges
//    private List<Edge> mst;
//
//    // Number of vertices in the graph
//    private int numVertices;
//
//    public PrimsAlgorithm(int numVertices) {
//        this.numVertices = numVertices;
//        adjacencyList = new ArrayList<>(numVertices);
//        for (int i = 0; i < numVertices; i++) {
//            adjacencyList.add(new ArrayList<>());
//        }
//        queue = new PriorityQueue<>();
//        inTree = new boolean[numVertices];
//        mst = new ArrayList<>();
//    }
//
//    // Adds a weighted edge to the graph
//    public void addEdge(int start, int end, int weight) {
//        adjacencyList.get(start
//
