//package ADS.DataStructures.prep;
//
//import ADS.DataStructures.SinglyLists.SinglyLinkedList;
//
//
//public class MyQueue extends SinglyLinkedList<String> {
//
//    SinglyLinkedList<String> list = new SinglyLinkedList<>();
//
//    public int size() {
//        return list.size();
//    }
//
//    public boolean isEmpty() {
//        return size() == 0;
//    }
//
//    public void enqueue(String a) {
//        list.addFirst(a);
//    }
//
//
//    public static void main(String[] args) {
//        MyQueue queue = new MyQueue();
//        queue.enqueue("asd");
//        queue.enqueue("adf");
//        queue.enqueue("sad");
//        queue.enqueue("qw");
//        ADS.DataStructures.SinglyLists.Node node = queue.head;
//        for(int i = 0;i < queue.size() - 1;i++) {
//            System.out.println(node.toString());
//            node = node.getNext();
//        }
//    }
//}
//
//
