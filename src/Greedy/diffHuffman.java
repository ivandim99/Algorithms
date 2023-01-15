//package Greedy;
//
//import java.util.PriorityQueue;
//
//public class diffHuffman {
//    /**
//     * You should implement this method.
//     *
//     * @param node A Node in the Huffman encoding tree
//     * @return the encoded string representing the character in this node.
//     */
//    public static String encode(Node node) {
//        String ret = "";
//        Node root = node;
//        while(node.parent != null) {
//            if(node.getParent().getLeftChild() == node) {
//                ret = "0" + ret;
//            }
//            else {
//                ret = "1" + ret;
//            }
//            node = node.parent;
//        }
//        return ret;
//    }
//
//    /**
//     * You should implement this method.
//     *
//     * @param n           the number of characters that need to be encoded.
//     * @param characters  The characters c_1 through c_n. Note you should use only characters[1] up to and including characters[n]!
//     * @param frequencies The frequencies f_1 through f_n. Note you should use only frequencies[1] up to and including frequencies[n]!
//     * @return The rootnode of an optimal Huffman tree that represents the encoding of the characters given.
//     */
//    public static Node buildHuffman(int n, char[] characters, double[] frequencies) {
//        // Create a priority queue to store the nodes of the Huffman tree
//        PriorityQueue<Node> queue = new PriorityQueue<>(new NodeComperator());
//
//// Create a leaf node for each character and add it to the priority queue
//        for (int i = 1; i <= n; i++)
//        {
//            Node leaf = new Node(characters[i], frequencies[i]);
//            queue.add(leaf);
//        }
//
//// While the priority queue has more than one node
//        while (queue.size() > 1)
//        {
//            // Remove the three nodes with the lowest priority from the priority queue
//            Node first = queue.poll();
//            Node second = queue.poll();
//            Node third = queue.poll();
//
//            // Create a new internal node with these three nodes as its children
//            Node internal = new Node(first, second, third);
//
//            // Add the new internal node to the priority queue
//            queue.add(internal);
//        }
//
//// When the priority queue has only one node, return it as the root node of the Huffman tree
//        return queue.poll();
//    }
//}