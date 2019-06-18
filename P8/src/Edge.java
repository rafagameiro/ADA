public class Edge {

    private int startNode;
    private int endNode;
    private int cost;

    public Edge(int startNode, int endNode, int cost) {
        this.startNode = startNode;
        this.endNode = endNode;
        this.cost = cost;
    }

    public int getStartNode() {
        return startNode;
    }

    public int getEndNode() {
        return endNode;
    }

    public int getCost() {
        return cost;
    }
}
