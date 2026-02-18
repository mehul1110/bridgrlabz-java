package treesandgraphs.graphs;

import java.util.*;

/**
 * Number of Connected Components
 * Problem Statement:
 * Given an undirected graph, find the number of connected components.
 * Concepts Tested: DFS/BFS, Visited array
 */
public class ConnectedComponents {

    /**
     * Counts the number of connected components in an undirected graph.
     * Uses DFS to explore each component completely.
     *
     * @param V   The number of vertices.
     * @param adj The adjacency list representing the graph.
     * @return The number of connected components.
     */
    public static int countComponents(int V, List<List<Integer>> adj) {
        boolean[] visited = new boolean[V];
        int count = 0;
        for (int i = 0; i < V; i++) {
            if (!visited[i]) {
                // Start DFS from this unvisited node to cover its entire component
                dfs(i, adj, visited);
                count++;
            }
        }
        return count;
    }

    /**
     * Recursive helper DFS to visit all reachable nodes in a component.
     */
    private static void dfs(int u, List<List<Integer>> adj, boolean[] visited) {
        visited[u] = true;
        for (int neighbor : adj.get(u)) {
            if (!visited[neighbor]) {
                dfs(neighbor, adj, visited);
            }
        }
    }

    public static void main(String[] args) {
        int V = 6;
        List<List<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < V; i++) {
            adj.add(new ArrayList<>());
        }

        // Add edges:
        // Component 1: 0-1
        adj.get(0).add(1);
        adj.get(1).add(0);
        // Component 2: 2-3
        adj.get(2).add(3);
        adj.get(3).add(2);
        // Component 3: 4-5
        adj.get(4).add(5);
        adj.get(5).add(4);

        System.out.println("Connected Components: " + countComponents(V, adj)); // Expected: 3
    }
}
