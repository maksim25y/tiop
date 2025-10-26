import java.io.BufferedReader;
import java.io.IOException;
import java.io.Reader;
import java.io.Writer;
import java.util.ArrayList;
import java.util.List;

public class GraphReaderWriterHtml implements IGraphReader, IGraphWriter {

    @Override
    public List<Edge> loadEdgeList(Reader reader) throws IOException {
        List<Edge> res = new ArrayList<>();
        BufferedReader bufferedReader = new BufferedReader(reader);
        String line;

        while ((line = bufferedReader.readLine()) != null) {
            if(!line.contains("h2")) continue;

            line = line.substring(line.indexOf('>') + 1, line.lastIndexOf('<'));
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
        writer.append("<html><head></head><body>").append(System.lineSeparator());
        for(int[] row: incidenceMatrix) {
            writer.append("<h2>");
            for (int i = 0; i < row.length; i++) {
                writer.append(String.valueOf(row[i]));
                if (i < row.length - 1) {
                    writer.append(' ');
                }
            }
            writer.append("</h2>");
            writer.append(System.lineSeparator());
        }
        writer.append("</body></html>");
        writer.append(System.lineSeparator());
    }
}
