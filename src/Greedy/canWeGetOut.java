//package Greedy;
//
//import java.util.*;
//
//class Node {
//
//    List<node> outgoingEdges;
//
//    boolean marked;
//
//    public Node() {
//        this.outgoingEdges = new ArrayList<>();
//        this.marked = false;
//    }
//}
//
//public class canWeGetOut {
//
//    /**
//     * @param nodes the nodes in the graph
//     * @param s the starting node
//     * @param t the final node
//     * @return true iff there is a path from the start node to the final node
//     */
//    public static boolean solve(Set<node> nodes, node s, node t) {
//        Queue<node> q = new LinkedList<>();
//        q.add(s);
//        s.marked = true;
//        while(!q.isEmpty()) {
//            node node = q.remove();
//            if(node == t) {
//                return true;
//            }
//            else {
//                for(Greedy.node to : node.outgoingEdges) {
//                    if(!to.marked) {
//                        q.add(to);
//                        to.marked = true;
//                    }
//                }
//            }
//        }
//        return false;
//    }
//}
