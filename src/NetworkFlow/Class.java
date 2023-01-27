package NetworkFlow;

import java.util.*;

public class Class {
}

class Range {

    int min, max;

    public Range(int min, int max) {
        this.min = min;
        this.max = max;
    }
}

class Match {

    int x;

    int y;

    public Match(int x, int y) {
        this.x = x;
        this.y = y;
    }

    @Override
    public String toString() {
        return x + " - " + y;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Match match = (Match) o;
        return x == match.x && y == match.y;
    }

    @Override
    public int hashCode() {
        return Objects.hash(x, y);
    }
}

class Location {

    private int x, y;

    public Location(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int distance(Location other) {
        return (int)
                Math.sqrt(
                        (this.x - other.x) * (this.x - other.x)
                                + (this.y - other.y) * (this.y - other.y));
    }
}

class Project {

    private int id;

    private int cost;

    private int revenue;

    private List<Integer> requirements;

    public Project(int revenue, int cost) {
        this.revenue = revenue;
        this.cost = cost;
        this.requirements = new ArrayList<>();
    }

    public Project(int id, int revenue, int cost) {
        this(revenue, cost);
        this.id = id;
    }

    public void addRequirement(int requirement) {
        requirements.add(requirement);
    }

    public void addRequirements(List<Integer> requirements) {
        this.requirements.addAll(requirements);
    }

    public int getId() {
        return id;
    }

    public int getCost() {
        return cost;
    }

    public int getRevenue() {
        return revenue;
    }

    public List<Integer> getRequirements() {
        return requirements;
    }

    @Override
    public String toString() {
        return "Project{"
                + "id="
                + id
                + ", cost="
                + cost
                + ", revenue="
                + revenue
                + ", requirements="
                + requirements
                + '}'
                + "\n";
    }
}

class Connection {

    int x;

    int y;

    public Connection(int x, int y) {
        this.x = x;
        this.y = y;
    }
}

class Graph {

    private List<Node> nodes;

    private Node source;

    private Node sink;

    public Graph(List<Node> nodes) {
        this.nodes = nodes;
        this.source = null;
        this.sink = null;
    }

    public Graph(List<Node> nodes, Node source, Node sink) {
        this.nodes = nodes;
        this.source = source;
        this.sink = sink;
    }

    public Node getSink() {
        return sink;
    }

    public Node getSource() {
        return source;
    }

    public List<Node> getNodes() {
        return nodes;
    }

    public boolean equals(Object other) {
        if (other instanceof Graph) {
            Graph that = (Graph) other;
            return this.nodes.equals(that.nodes);
        }
        return false;
    }

    public boolean hasCirculation() {
        this.removeLowerBounds();
        int D = this.removeSupplyDemand();
        int x = MaxFlow.maximizeFlow(this);
        return x == D;
    }

    private void removeLowerBounds() {
        for (Node n : this.getNodes()) {
            for (Edge e : n.edges) {
                if (e.lower > 0) {
                    e.capacity -= e.lower;
                    e.backwards.capacity -= e.lower;
                    e.backwards.flow -= e.lower;
                    e.from.d += e.lower;
                    e.to.d -= e.lower;
                    e.lower = 0;
                }
            }
        }
    }

    private int removeSupplyDemand() {
        int Dplus = 0, Dmin = 0;
        int maxId = 0;
        for (Node n : this.getNodes()) {
            maxId = Math.max(n.id, maxId);
        }
        Node newSource = new Node(maxId + 1, 0);
        Node newSink = new Node(maxId + 2, 0);
        for (Node n : this.getNodes()) {
            if (n.d < 0) {
                newSource.addEdge(n, 0, -n.d);
                Dmin -= n.d;
            } else if (n.d > 0) {
                n.addEdge(newSink, 0, n.d);
                Dplus += n.d;
            }
            n.d = 0;
        }
        if (Dmin != Dplus) {
            throw new IllegalArgumentException("Demand and supply are not equal!");
        }
        this.nodes.add(newSource);
        this.nodes.add(newSink);
        this.source = newSource;
        this.sink = newSink;
        return Dplus;
    }
}

class Node {

    protected int id;

    protected int d;

    protected Collection<Edge> edges;

    /**
     * Create a new node
     *
     * @param id: Id for the node.
     */
    public Node(int id) {
        this(id, 0);
    }

    /**
     * Create a new node
     *
     * @param id: Id for the node.
     * @param d: demand for the node. Remember that supply is represented as a negative demand.
     */
    public Node(int id, int d) {
        this.id = id;
        this.d = d;
        this.edges = new ArrayList<Edge>();
    }

    public void addEdge(Node destination, int capacity) {
        this.addEdge(destination, 0, capacity);
    }

    public void addEdge(Node to, int lower, int upper) {
        Edge e = new Edge(lower, upper, this, to);
        edges.add(e);
        to.getEdges().add(e.getBackwards());
    }

    public Collection<Edge> getEdges() {
        return edges;
    }

    public int getId() {
        return id;
    }

    public boolean equals(Object other) {
        if (other instanceof Node) {
            Node that = (Node) other;
            if (id == that.getId()) return edges.equals(that.getEdges());
        }
        return false;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(this.getId());
        sb.append(" ");
        sb.append(this.getEdges().size());
        sb.append(":");
        for (Edge e : this.getEdges()) {
            sb.append("(");
            sb.append(e.from.getId());
            sb.append(" --[");
            sb.append(e.lower);
            sb.append(',');
            sb.append(e.capacity);
            sb.append("]-> ");
            sb.append(e.to.getId());
            sb.append(")");
        }
        return sb.toString();
    }
}

class Edge {

    protected int lower;

    protected int capacity;

    protected int flow;

    protected Node from;

    protected Node to;

    protected Edge backwards;

    private Edge(Edge e) {
        this.lower = 0;
        this.flow = e.getCapacity();
        this.capacity = e.getCapacity();
        this.from = e.getTo();
        this.to = e.getFrom();
        this.backwards = e;
    }

    protected Edge(int lower, int capacity, Node from, Node to) {
        this.lower = lower;
        this.capacity = capacity;
        this.from = from;
        this.to = to;
        this.flow = 0;
        this.backwards = new Edge(this);
    }

    public void augmentFlow(int add) {
        assert (flow + add <= capacity);
        flow += add;
        backwards.setFlow(getResidual());
    }

    public Edge getBackwards() {
        return backwards;
    }

    public int getCapacity() {
        return capacity;
    }

    public int getFlow() {
        return flow;
    }

    public Node getFrom() {
        return from;
    }

    public int getResidual() {
        return capacity - flow;
    }

    public Node getTo() {
        return to;
    }

    private void setFlow(int f) {
        assert (f <= capacity);
        this.flow = f;
    }

    public boolean equals(Object other) {
        if (other instanceof Edge) {
            Edge that = (Edge) other;
            return this.capacity == that.capacity
                    && this.flow == that.flow
                    && this.from.getId() == that.getFrom().getId()
                    && this.to.getId() == that.getTo().getId();
        }
        return false;
    }
}

class MaxFlow {

    private static List<Edge> findPath(Graph g, Node start, Node end) {
        Map<Node, Edge> mapPath = new HashMap<Node, Edge>();
        Queue<Node> sQueue = new LinkedList<Node>();
        Node currentNode = start;
        sQueue.add(currentNode);
        while (!sQueue.isEmpty() && currentNode != end) {
            currentNode = sQueue.remove();
            for (Edge e : currentNode.getEdges()) {
                Node to = e.getTo();
                if (to != start && mapPath.get(to) == null && e.getResidual() > 0) {
                    sQueue.add(e.getTo());
                    mapPath.put(to, e);
                }
            }
        }
        if (sQueue.isEmpty() && currentNode != end) return null;
        LinkedList<Edge> path = new LinkedList<Edge>();
        Node current = end;
        while (mapPath.get(current) != null) {
            Edge e = mapPath.get(current);
            path.addFirst(e);
            current = e.getFrom();
        }
        return path;
    }

    public static int maximizeFlow(Graph g) {
        int f = 0;
        Node sink = g.getSink();
        Node source = g.getSource();
        List<Edge> path;
        while ((path = findPath(g, source, sink)) != null) {
            int r = Integer.MAX_VALUE;
            for (Edge e : path) {
                r = Math.min(r, e.getResidual());
            }
            for (Edge e : path) {
                e.augmentFlow(r);
            }
            f += r;
        }
        return f;
    }
}