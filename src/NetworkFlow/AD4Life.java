package NetworkFlow;

import java.util.ArrayList;
import java.util.List;

public class AD4Life {

    /**
     * You should implement this method
     *
     * @param n the number of books
     * @param m the number of libraries
     * @param z the number of authors
     * @param a the author of a book 1 <= i < = n (ignore a[0]), represented as an integer between 1
     *     and z (inclusive)
     * @param b the number of copies we have of a book 1 <= i <= n (ignore b[0])
     * @param c the maximum number of books a library 1 <= j <= m can hold (ignore c[0])
     * @return true iff AD4LIFE can redistribute all the books
     */
    public static boolean canWeRedistribute(int n, int m, int z, int[] a, int[] b, int[] c) {
        List<Node> nodes = new ArrayList<>();
        Node source = new Node(-1,0);
        Node sink = new Node(-2,0);
        nodes.add(source);
        nodes.add(sink);

        Node[] librarys = new Node[m+1];
        Node[][] libAuth = new Node[m+1][z+1];
        Node[] books = new Node[n+1];

        for(int i = 1; i <= m; i++) {
            Node lib = new Node(i,0);
            librarys[i] = lib;
            source.addEdge(librarys[i],0,c[i]);
        }

        for(int i = 1; i <= n; i++) {
            Node book = new Node(i,0);
            books[i] = book;
            source.addEdge(books[i],0,b[i]);
        }

        for(int i = 1; i <= m; i++) {
            for(int j = 1; j <= z; j++) {
                Node lAuth = new Node(i, 0);
                libAuth[i][j] = lAuth;
                source.addEdge(libAuth[i][j], 3,Integer.MAX_VALUE / 2);
            }
        }

        for (int i = 1; i <= n; i++) {
            books[i] = new Node(i, 0);
            nodes.add(books[i]);
            books[i].addEdge(sink, 0, b[i]);
            for (int j = 1; j <= z; j++) {
                books[i].addEdge(libAuth[a[i]][j], 0, 1);
            }
        }

        Graph g = new Graph(nodes,source,sink);

        return MaxFlow.maximizeFlow(g) == n;
    }

}
