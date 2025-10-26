package example;

import java.io.FileReader;
import java.io.FileWriter;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        Graph graph = new Graph(new GraphReaderWriterHtml(), new GraphReaderWriterTxt());
        try(FileReader reader = new FileReader("../file.html"); FileWriter writer = new FileWriter("../file.txt")) {
            graph.readFromFile(reader);
            System.out.println(Arrays.deepToString(graph.incidenceMatrix));
            graph.writeToFile(writer);
            System.out.println(graph.isConnected());
        } catch (Exception e) {
            System.out.println(e.getMessage());
            e.printStackTrace();
        }
        Math.abs(1);
    }
}
