package example;

import java.io.IOException;
import java.io.Writer;

public interface IGraphWriter {
    void saveIncidenceMatrix(Writer writer, int[][] incidenceMatrix) throws IOException;
}
