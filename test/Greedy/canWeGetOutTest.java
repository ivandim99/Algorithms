//package Greedy;
//
//import org.junit.jupiter.api.Assertions;
//import org.junit.jupiter.api.Test;
//
//import java.util.HashSet;
//import java.util.Set;
//
//class canWeGetOutTest {
//    @Test
//    public void example() {
//        int n = 7;
//        node[] nodesArr = new node[n + 1];
//        Set<node> nodes = new HashSet<>();
//        for (int i = 1; i <= n; i++) {
//            nodesArr[i] = new Node();
//            nodes.add(nodesArr[i]);
//        }
//        node s = nodesArr[1];
//        node t = nodesArr[5];
//        nodesArr[1].outgoingEdges.add(nodesArr[2]);
//        nodesArr[2].outgoingEdges.add(nodesArr[3]);
//        nodesArr[3].outgoingEdges.add(nodesArr[4]);
//        nodesArr[4].outgoingEdges.add(nodesArr[5]);
//        nodesArr[2].outgoingEdges.add(nodesArr[6]);
//        nodesArr[6].outgoingEdges.add(nodesArr[7]);
//        nodesArr[7].outgoingEdges.add(nodesArr[4]);
//        Assertions.assertTrue(canWeGetOut.solve(nodes, s, t));
//    }
//}