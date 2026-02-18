package treesandgraphs.graphs;

import java.util.*;

/**
 * Detect Cycle in an Undirected Graph
 * Problem Statement:
 * Given an undirected graph, check whether the graph contains a cycle.
 * Approach Hint: Use DFS with parent tracking or Union-Find
 * Concepts Tested: Graph traversal, Cycle detection
 */
public class DetectCycle {

    /**
     * Checks if an undirected graph contains a cycle.
     * Uses DFS with parent tracking.
     *
     * @param V   The number of vertices.
     * @param adj The adjacency list representing the graph.
     * @return True if a cycle exists, false otherwise.
     */
    public static boolean isCyclic(int V, List<List<Integer>> adj) {
        boolean[] visited = new boolean[V];
        // Handle disconnected graphs by checking all components
        for (int i = 0; i < V; i++) {
            if (!visited[i]) {
                if (dfsCheckCycle(i, -1, adj, visited)) {
                    return true;
                }
            }
        }
        return false;
    }

    /**
     * Helper DFS function to detect cycles.
     * If we encounter a visited node that is not the parent, a cycle exists.
     *
     * @param node    The current node.
     * @param parent  The parent node of the current node in the traversal.
     * @param adj     The adjacency list.
     * @param visited Visited array.
     * @return True if a cycle is detected.
     */
    private static boolean dfsCheckCycle(int node, int parent, List<List<Integer>> adj, boolean[] visited) {
        visited[node] = true;

        for (int neighbor : adj.get(node)) {
            if (!visited[neighbor]) {
                if (dfsCheckCycle(neighbor, node, adj, visited)) {
                    return true;
                }
            } else if (neighbor != parent) {
                // If visited and not parent, cycle detected
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        int V = 5;
        List<List<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < V; i++) {
            adj.add(new ArrayList<>());
        }

        // Add edges: 0-1, 1-2, 2-3, 3-4 (Acyclic)
        adj.get(0).add(1);
        adj.get(1).add(0);
        adj.get(1).add(2);
        adj.get(2).add(1);
        adj.get(2).add(3);
        adj.get(3).add(2);
        adj.get(3).add(4);
        adj.get(4).add(3);

        System.out.println("Is Cyclic (Line Graph): " + isCyclic(V, adj)); // Expected: false

        // Add edge 4-1 to create cycle: 1-2-3-4-1
        adj.get(4).add(1);
        adj.get(1).add(4);

        System.out.println("Is Cyclic (With Cycle): " + isCyclic(V, adj)); // Expected: true
    }
}
