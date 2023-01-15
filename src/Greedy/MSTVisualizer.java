package Greedy;
import java.awt.Graphics;
import javax.swing.JFrame;

public class MSTVisualizer extends JFrame {
    // MST data
    private int[] parent;
    private int[][] graph;
    private int numVertices;

    public MSTVisualizer(int[] parent, int[][] graph, int numVertices) {
        this.parent = parent;
        this.graph = graph;
        this.numVertices = numVertices;
    }

    // draw the MST
    public void draw() {
        setSize(600, 600);
        setVisible(true);
    }

    // draw the edges of the MST
    public void paint(Graphics g) {
        for (int i = 1; i < numVertices; i++) {
            int x1 = getX(i);
            int y1 = getY(i);
            int x2 = getX(parent[i]);
            int y2 = getY(parent[i]);
            g.drawLine(x1, y1, x2, y2);
        }
    }

    // helper function to convert vertex number to x-coordinate
    private int getX(int vertex) {
        return (int)(getWidth() * (graph[vertex][0] / (double) numVertices));
    }

    // helper function to convert vertex number to y-coordinate
    private int getY(int vertex) {
        return (int)(getHeight() * (graph[vertex][1] / (double) numVertices));
    }

    public static void main(String[] args) {
        // example data for a minimum spanning tree on a 4x4 grid
        int[] parent = {-1, 0, 0, 1, 2};
        int[][] graph = {
                {-1, -1, -1, -1},
                {0, 0, 2, 2},
                {0, 0, 2, 2},
                {1, 1, 3, 3},
                {2, 2, 4, 4}
        };
        int numVertices = 5;

        MSTVisualizer visualizer = new MSTVisualizer(parent, graph, numVertices);
        visualizer.draw();
    }
}
