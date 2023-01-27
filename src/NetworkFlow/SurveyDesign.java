package NetworkFlow;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class SurveyDesign {

    /**
     * You should implement this method
     *
     * @param n the number of frequent users
     * @param k the number of candy to be reviewed
     * @param connections a set of connections (x, y) representing that person x doesn't like candy
     *     y.
     * @param customersRange list of min-max range for customers (minimum and maximum number of
     *     products that a customer i can review, 1<=i<=n)
     * @param productsRange list of min-max range for products (minimum and maximum number of
     *     customers that need to review product j , 1<=j<=k)
     * @return true, if the testing event is successfully in reviewing all the candy, false
     *     otherwise.
     */
    public static boolean isReviewPossible(
            int n,
            int k,
            Set<Connection> connections,
            Range[] customersRange,
            Range[] productsRange) {
        List<Node> nodes = new ArrayList<>();
        Node source = new Node(-1, 0);
        Node sink = new Node(-2, 0);
        nodes.add(source);
        nodes.add(sink);
        Node[] customers = new Node[n + 1];
        Node[] products = new Node[k + 1];
        // Create customer and product nodes
        for (int i = 1; i <= n; i++) customers[i] = new Node(i);
        for (int i = 1; i <= k; i++) products[i] = new Node(i);
        // TODO Add customers and products to the NF graph



        Graph g = new Graph(nodes, source, sink);
        return g.hasCirculation();
    }

}
