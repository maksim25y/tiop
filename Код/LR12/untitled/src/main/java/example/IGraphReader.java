package example;

import java.io.IOException;
import java.io.Reader;
import java.util.List;

public interface IGraphReader {

    List<Edge> loadEdgeList(Reader reader) throws IOException;

}


