package example;

import java.io.IOException;
import java.io.Reader;
import java.io.Writer;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Graph {

    public int[][] incidenceMatrix;
    private final IGraphReader iGraphReader;
    private final IGraphWriter iGraphWriter;

    public Graph(IGraphReader iGraphReader, IGraphWriter iGraphWriter) {
        this.iGraphReader = iGraphReader;
        this.iGraphWriter = iGraphWriter;
    }

    public void readFromFile(Reader reader) throws IOException {
        List<Edge> edges = iGraphReader.loadEdgeList(reader);
        convertFromListEdgeToIncidenceMatrix(edges);
    }

    private void convertFromListEdgeToIncidenceMatrix(List<Edge> edges) {
        int maxTop = Integer.MIN_VALUE;
        for (Edge edge: edges) {
            if(edge.getFrom() > maxTop) maxTop = edge.getFrom();
            if(edge.getTo() > maxTop) maxTop = edge.getTo();
        }
        incidenceMatrix = new int[maxTop][edges.size()];
        for(int i = 0; i < edges.size(); i++) {
            Edge currentEdge = edges.get(i);
            for(int j = 0; j < maxTop; j++) {
                if(j + 1 == currentEdge.getFrom()) {
                    incidenceMatrix[j][i] = currentEdge.isDirected() ? -1 : 1;
                    continue;
                }
                if(j + 1 == currentEdge.getTo()) {
                    incidenceMatrix[j][i] = 1;
                }
            }
        }
    }

    public void writeToFile(Writer writer) throws IOException {
        iGraphWriter.saveIncidenceMatrix(writer, incidenceMatrix);
    }

    public boolean isConnected() {
        for(int i = 0; i < this.incidenceMatrix.length; i++) {
            LinkedList<Integer> queue = new LinkedList<>();
            queue.add(i);
            boolean[] res = isTopConnected(this, new ArrayList<Integer>(), queue);
            for(boolean visit: res) {
                if(!visit) return false;
            }
        }
        return true;
    }

    private static boolean[] isTopConnected(Graph graph, List<Integer> visited, Queue<Integer> connected) {
        if(connected.isEmpty()) {
            boolean[] res = new boolean[graph.incidenceMatrix.length];
            for(int visit: visited) {
                res[visit] = true;
            }
            return res;
        }

        int top = connected.poll();

        for(int i = 0; i < graph.incidenceMatrix[0].length; i++) {
            if(graph.incidenceMatrix[top][i] != 0) {
                for(int j = 0; j < graph.incidenceMatrix.length; j++) {
                    if(top != j && graph.incidenceMatrix[j][i] == 1) {
                        connected.add(j);
                        break;
                    }
                }
            }
        }

        visited.add(top);
        while (visited.contains(connected.peek())) connected.poll();
        return isTopConnected(graph, visited, connected);
    }
}
