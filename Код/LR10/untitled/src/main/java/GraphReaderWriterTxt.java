import java.io.BufferedReader;
import java.io.IOException;
import java.io.Reader;
import java.io.Writer;
import java.util.ArrayList;
import java.util.List;

public class GraphReaderWriterTxt implements IGraphWriter, IGraphReader {

    @Override
    public List<Edge> loadEdgeList(Reader reader) throws IOException {
        List<Edge> res = new ArrayList<>();
        BufferedReader bufferedReader = new BufferedReader(reader);
        String line;

        while ((line = bufferedReader.readLine()) != null) {
            String[] items = line.split(" ");

            Edge currentEdge = new Edge();
            currentEdge.setFrom(Integer.parseInt(items[0]));
            currentEdge.setTo(Integer.parseInt(items[1]));
            currentEdge.setDirected(Boolean.parseBoolean(items[2]));

            res.add(currentEdge);
        }
        return res;
    }

    @Override
    public void saveIncidenceMatrix(Writer writer, int[][] incidenceMatrix) throws IOException {
        for(int[] row: incidenceMatrix) {
            for (int i = 0; i < row.length; i++) {
                writer.append(String.format("%2d", row[i]));
                if (i < row.length - 1) {
                    writer.append(' ');
                }
            }
            writer.append(System.lineSeparator());
        }
    }
}
