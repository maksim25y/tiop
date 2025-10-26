package example;

import java.util.Objects;

public class Edge {

    private int from;
    private int to;
    private boolean directed; // true = направленный, false = ненаправленный

    public int getFrom() {
        return from;
    }

    public void setFrom(int from) {
        this.from = from;
    }

    public int getTo() {
        return to;
    }

    public void setTo(int to) {
        this.to = to;
    }

    public boolean isDirected() {
        return directed;
    }

    public void setDirected(boolean directed) {
        this.directed = directed;
    }

    public Edge(int from, int to, boolean directed) {
        this.from = from;
        this.to = to;
        this.directed = directed;
    }

    public Edge() {
    }

    @Override
    public boolean equals(Object object) {
        if (this == object) return true;
        if (object == null || getClass() != object.getClass()) return false;
        Edge edge = (Edge) object;
        return from == edge.from && to == edge.to && directed == edge.directed;
    }
}
