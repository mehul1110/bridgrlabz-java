package treesandgraphs.graphs;

import java.util.*;

/**
 * Shortest Path in Weighted Graph (Dijkstra’s Algorithm)
 * Problem Statement:
 * Given a weighted graph and a source node, find the shortest distance from the
 * source
 * to all other nodes.
 * Constraints:
 * - Graph may contain cycles
 * - All edge weights are positive
 * Concepts Tested: Priority Queue, Greedy algorithms, Graph optimization
 */
public class DijkstraAlgorithm {

    // Helper class to represent a weighted edge
    static class Edge {
        int dest;
        int weight;

        public Edge(int dest, int weight) {
            this.dest = dest;
            this.weight = weight;
        }
    }

    // Helper class to represent a node in Priority Queue
    static class PQNode implements Comparable<PQNode> {
        int vertex;
        int distance;

        public PQNode(int vertex, int distance) {
            this.vertex = vertex;
            this.distance = distance;
        }

        @Override
        public int compareTo(PQNode other) {
            // Sort by distance (ascending)
            return Integer.compare(this.distance, other.distance);
        }
    }

    /**
     * Implements Dijkstra's Algorithm to find shortest paths from a source node in
     * a weighted graph.
     *
     * @param V      The number of vertices.
     * @param adj    The adjacency list (where each node has a list of weighted
     *               edges).
     * @param source The source node.
     * @return An array of shortest distances from the source to all other nodes.
     */
    public static int[] findShortestPath(int V, List<List<Edge>> adj, int source) {
        // Priority Queue to store nodes with their current shortest distance
        PriorityQueue<PQNode> pq = new PriorityQueue<>();

        // Array to store shortest distances, initialized to Infinity
        int[] dist = new int[V];
        Arrays.fill(dist, Integer.MAX_VALUE);

        // Distance to source is 0
        dist[source] = 0;
        pq.add(new PQNode(source, 0));

        while (!pq.isEmpty()) {
            PQNode current = pq.poll();
            int u = current.vertex;
            int d = current.distance;

            // If current distance is greater than already found shortest, skip
            if (d > dist[u]) {
                continue;
            }

            // Iterate through all adjacent vertices
            for (Edge edge : adj.get(u)) {
                int v = edge.dest;
                int weight = edge.weight;

                // Relaxation step: If a shorter path to v is found through u
                if (dist[u] != Integer.MAX_VALUE && dist[u] + weight < dist[v]) {
                    dist[v] = dist[u] + weight;
                    pq.add(new PQNode(v, dist[v]));
                }
            }
        }
        return dist;
    }

    public static void main(String[] args) {
        int V = 5;
        List<List<Edge>> adj = new ArrayList<>();
        for (int i = 0; i < V; i++) {
            adj.add(new ArrayList<>());
        }

        // Add weighted edges for a graph:
        // 0 -> 1 (weight 2)
        // 0 -> 2 (weight 4)
        // 1 -> 2 (weight 1)
        // 1 -> 3 (weight 7)
        // 2 -> 4 (weight 3)
        // 3 -> 4 (weight 1)

        // Add edges:
        adj.get(0).add(new Edge(1, 2));
        adj.get(0).add(new Edge(2, 4));
        adj.get(1).add(new Edge(2, 1));
        adj.get(1).add(new Edge(3, 7));
        adj.get(2).add(new Edge(4, 3));
        adj.get(3).add(new Edge(4, 1));

        // Adding reverse edges for undirected graph:
        adj.get(1).add(new Edge(0, 2));
        adj.get(2).add(new Edge(0, 4));
        adj.get(2).add(new Edge(1, 1));
        adj.get(3).add(new Edge(1, 7));
        adj.get(4).add(new Edge(2, 3));
        adj.get(4).add(new Edge(3, 1));

        int source = 0;
        int[] distances = findShortestPath(V, adj, source);

        System.out.println("Shortest distances from node " + source + ":");
        for (int i = 0; i < V; i++) {
            System.out.println("To " + i + ": " + distances[i]);
        }
    }
}
