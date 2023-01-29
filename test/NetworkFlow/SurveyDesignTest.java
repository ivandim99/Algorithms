package NetworkFlow;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.HashSet;
import java.util.Set;

class SurveyDesignTest {

    @Test()
    public void noSolution() {
        int n = 2;
        int k = 3;
        Set<Connection> connections = new HashSet<>();
        // Person 1 isn't able to review product 3
        // Person 2 isn't able to review products 2, 3
        connections.add(new Connection(1, 3));
        connections.add(new Connection(2, 2));
        connections.add(new Connection(2, 3));
        Range[] persons = new Range[n + 1];
        // Person 1 and 2 want at least 1 products, and max 1 product
        persons[1] = persons[2] = new Range(1, 1);
        Range[] products = new Range[k + 1];
        // 1 person is needed for each product
        products[1] = products[2] = products[3] = new Range(1, 1);
        Assertions.assertFalse(SurveyDesign.isReviewPossible(n, k, connections, persons, products));
    }

    @Test()
    public void exampleOnePersonOneCandy() {
        int n = 1;
        int k = 1;
        Set<Connection> connections = new HashSet<>();
        Range[] persons = new Range[n + 1];
        persons[1] = new Range(1, 1);
        Range[] customers = new Range[k + 1];
        customers[1] = new Range(1, 1);
        Assertions.assertTrue(SurveyDesign.isReviewPossible(n, k, connections, persons, customers));
    }

    @Test()
    public void simpleExample() {
        int n = 3;
        int k = 3;
        Set<Connection> connections = new HashSet<>();
        // Person 1 doesn't like product 3
        // Person 2 doesn't like product 1
        // Person 3 doesn't like products 1, 2
        connections.add(new Connection(1, 3));
        connections.add(new Connection(2, 1));
        connections.add(new Connection(3, 1));
        connections.add(new Connection(3, 2));
        Range[] persons = new Range[n + 1];
        persons[1] = new Range(1, 2);
        persons[2] = new Range(1, 2);
        persons[3] = new Range(1, 1);
        Range[] customers = new Range[n + 1];
        customers[1] = new Range(1, 4);
        customers[2] = new Range(2, 3);
        customers[3] = new Range(2, 3);
        Assertions.assertTrue(SurveyDesign.isReviewPossible(n, k, connections, persons, customers));
    }

}