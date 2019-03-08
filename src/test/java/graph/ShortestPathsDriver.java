package graph;

import heap.Heap;
import java.util.Map;
import java.util.HashMap;
import java.util.LinkedList;
import java.io.FileNotFoundException;

/** Provides an implementation of Dijkstra's single-source shortest paths
 * algorithm.
 * Sample usage:
 *   Graph g = // create your graph
 *   ShortestPaths sp = new ShortestPaths();
 *   Node a = g.getNode("A");
 *   sp.compute(a);
 *   Node b = g.getNode("B");
 *   LinkedList<Node> abPath = sp.getShortestPath(b);
 *   double abPathLength = sp.getShortestPathLength(b);
 *   */
public class ShortestPathsDriver {
    // stores auxiliary data associated with each node for the shortest
    // paths computation:

    /** Static helper method to open and parse a file containing graph
     * information. Can parse either a basic file or a DB1B CSV file with
     * flight data. See GraphParser, BasicParser, and DB1BParser for more.*/
    protected static Graph parseGraph(String fileType, String fileName) throws
        FileNotFoundException {
        // create an appropriate parser for the given file type
        GraphParser parser;
        if (fileType.equals("basic")) {
            parser = new BasicParser();
        } else if (fileType.equals("db1b")) {
            parser = new DB1BParser();
        } else {
            throw new IllegalArgumentException(
                    "Unsupported file type: " + fileType);
        }

        // open the given file
        parser.open(fileName);

        // parse the file and return the graph
        return parser.parse();
    }

    public static void main(String[] args) {
      // read command line args
      String fileType = args[0];
      String fileName = args[1];
      String origCode = args[2];

      String destCode = null;
      if (args.length == 4) {
          destCode = args[3];
      }

      // parse a graph with the given type and filename
      Graph graph;
      try {
          graph = parseGraph(fileType, fileName);
      } catch (FileNotFoundException e) {
          System.out.println("Could not open file " + fileName);
          return;
      }
      graph.report();


      // TODO 4: create a ShortestPaths object, use it to compute shortest
      // paths data from the origin node given by origCode.
      Node orig = graph.getNode(origCode);
      ShortestPaths sp = new ShortestPaths();
      sp.compute(orig);
      sp.computeBFS(orig);

      // TODO 5:
      // If destCode was not given, print each reachable node followed by the
      // length of the shortest path to it from the origin.
      if (destCode == null) {
        System.out.println("Shortest paths from " + origCode);
        for (Node n : sp.paths.keySet()) {
          System.out.println(n + ": " + sp.shortestPathLength(n));
        }
        System.out.println();
        for (Node n : sp.paths.keySet()) {
          System.out.println(n + ": " + sp.shortestHopsLength(n));
        }
      } else {
      // TODO 6:
      // If destCode was given, print the nodes in the path from
      // origCode to destCode, followed by the total path length
      // If no path exists, print a message saying so.
        Node dest = graph.getNode(destCode);
        LinkedList<Node> path = sp.shortestPath(dest);
        if (path == null) {
          System.out.println("No path from " + origCode + " to " + destCode);
          return;
        }
        for (Node n : path) {
          System.out.print(n.getId() + " ");
        }
        System.out.println(sp.shortestPathLength(dest));


        LinkedList<Node> bfspath = sp.shortestHops(dest);
        if (path == null) {
          System.out.println("No path from " + origCode + " to " + destCode);
          return;
        }
        for (Node n : bfspath) {
          System.out.print(n.getId() + " ");
        }
        System.out.println(sp.shortestHopsLength(dest));
      }
    }
}
