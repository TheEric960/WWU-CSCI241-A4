package graph;

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
public class ShortestPaths {
    // stores auxiliary data associated with each node for the shortest
    // paths computation:
    private HashMap<Node,PathData> paths;

    /** Compute the shortest path to all nodes from origin using Dijkstra's
     * algorithm. Fill in the paths field, which associates each Node with its
     * PathData record, storing total distance from the source, and the
     * backpointer to the previous node on the shortest path.
     * Precondition: origin is a node in the Graph.*/
    public void compute(Node origin) {
        paths = new HashMap<Node,PathData>();

        // TODO 1: implement Dijkstra's algorithm to fill paths with
        // shortest-path data for each Node reachable from origin.

    }


    /** Compute a BFS and fill in the hops and bfsPrev fields of the PathData
     * for each explorable node from origin. Pre: compute has been called with
     * origin so each node already has a PathData object in the paths.*/
    public void computeBFS(Node origin) {
    
    }

    /** Returns the length of the shortest path from the origin to destination.
     * If no path exists, return Double.POSITIVE_INFINITY.
     * Precondition: destination is a node in the graph, and compute(origin)
     * has been called. */
    public double shortestPathLength(Node destination) {
        // TODO 2 - implement this method to fetch the shortest path length
        // from the paths data computed by Dijkstra's algorithm.
        return Double.POSITIVE_INFINITY;
    }

    /** Returns the number of hops on the shortest path from the origin to destination.
     * If no path exists, return -1.
     * Precondition: destination is a node in the graph, and compute(origin)
     * has been called. */
    public int shortestHopsLength(Node destination) {
        // TODO 3 - implement this method to fetch the shortest path length
        // from the paths data computed by the computeBFS() method.
        return -1;
    }


    /** Returns a LinkedList of the nodes along the shortest path from origin
     * to destination. If no path to it exists, return null.
     * Precondition: destination is a node in the graph, and compute(origin)
     * has been called. */
    public LinkedList<Node> shortestPath(Node destination) {
        // TODO 4 - implement this method to reconstruct sequence of Nodes
        // along the shortest path from the origin to destination using the
        // paths data computed by Dijkstra's algorithm.
        LinkedList<Node> path = new LinkedList<Node>();
        return path;
    }

    /** Returns a LinkedList of the nodes along the shortest path from origin
     * to destination. If no path to it exists, return null.
     * Precondition: destination is a node in the graph, and compute(origin)
     * has been called. */
    public LinkedList<Node> shortestHops(Node destination) {
        // TODO 5 - implement this method to reconstruct sequence of Nodes
        // along the shortest hops path from the origin to destination using the
        // paths data computed by the computerBFS() method.
      LinkedList<Node> path = new LinkedList<Node>();
      return path;
    }


    /** Inner class representing data used by Dijkstra's algorithm in the
     * process of computing shortest paths from a given source node. */
    class PathData {
        double distance; // distance of the shortest path from source
        Node previous; // previous node in the path from the source
        int hops;
        Node bfsPrev;

        /** constructor: initialize distance and previous node */
        public PathData(double dist, Node prev) {
            distance = dist;
            previous = prev;
            hops = -1;
        }
    }


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

      Node orig = graph.getNode(origCode);
      ShortestPaths sp = new ShortestPaths();
      sp.compute(orig);
      sp.computeBFS(orig);

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
