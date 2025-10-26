package example;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class MockitoGraphTest {


    @Test
    void readGraphTest() throws IOException {
        IGraphReader graphReader = Mockito.mock(IGraphReader.class);
        IGraphWriter graphWriter = Mockito.mock(IGraphWriter.class);

        Mockito.when(graphReader.loadEdgeList(Mockito.any())).thenAnswer(_ -> {
            List<Edge> list = new ArrayList<>();
            list.add(new Edge(1, 2, true));
            list.add(new Edge(2, 4, true));
            list.add(new Edge(4, 3, true));
            list.add(new Edge(3, 1, true));
            return list;
        });
        Graph graph = new Graph(graphReader, graphWriter);
        graph.readFromFile(new StringReader(""));
        graph.writeToFile(new StringWriter());
        Assertions.assertEquals(4, graph.incidenceMatrix.length);
    }

    @Test
    void isConnected() throws IOException {
        IGraphReader graphReader = Mockito.mock(IGraphReader.class);
        IGraphWriter graphWriter = Mockito.mock(IGraphWriter.class);

        Mockito.when(graphReader.loadEdgeList(Mockito.any())).thenAnswer(_ -> {
            List<Edge> list = new ArrayList<>();
            list.add(new Edge(1, 2, true));
            list.add(new Edge(2, 4, true));
            list.add(new Edge(4, 3, true));
            list.add(new Edge(3, 1, true));
            return list;
        });
        Graph graph = new Graph(graphReader, graphWriter);
        graph.readFromFile(new StringReader(""));
        Assertions.assertTrue(graph.isConnected());
    }

    @Test
    void isNotConnected() throws IOException {
        IGraphReader graphReader = Mockito.mock(IGraphReader.class);
        IGraphWriter graphWriter = Mockito.mock(IGraphWriter.class);

        Mockito.when(graphReader.loadEdgeList(Mockito.any())).thenAnswer(_ -> {
            List<Edge> list = new ArrayList<>();
            list.add(new Edge(1, 2, true));
            list.add(new Edge(2, 4, true));
            list.add(new Edge(4, 3, true));
            list.add(new Edge(1, 3, true));
            return list;
        });
        Graph graph = new Graph(graphReader, graphWriter);
        graph.readFromFile(new StringReader(""));
        Assertions.assertFalse(graph.isConnected());
    }

}
