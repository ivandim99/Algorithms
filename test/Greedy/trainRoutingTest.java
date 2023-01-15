//package Greedy;
//
//import org.junit.jupiter.api.Assertions;
//import org.junit.jupiter.api.Test;
//
//import java.util.HashSet;
//import java.util.Set;
//
//class trainRoutingTest {
//
//    @Test
//    public void example() {
//        int n = 5;
//        int m = 6;
//        Set<Edge> edges = new HashSet<>();
//        edges.add(new Edge(1, 2));
//        edges.add(new Edge(3, 2));
//        edges.add(new Edge(1, 3));
//        edges.add(new Edge(4, 5));
//        edges.add(new Edge(2, 4));
//        edges.add(new Edge(5, 3));
//        Assertions.assertTrue(trainRouting.isThereACycle(n, m, edges));
//    }
//
//    @Test
//    public void exampleRememberItIsDirected() {
//        int n = 4;
//        int m = 5;
//        Set<Edge> edges = new HashSet<>();
//        edges.add(new Edge(1, 2));
//        edges.add(new Edge(1, 3));
//        edges.add(new Edge(2, 4));
//        edges.add(new Edge(3, 4));
//        edges.add(new Edge(2, 3));
//        Assertions.assertFalse(trainRouting.isThereACycle(n, m, edges));
//    }
//
//}