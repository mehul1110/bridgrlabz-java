package treesandgraphs.graphs;

import java.util.*;

/**
 * DFS Traversal of a Graph
 * Problem Statement:
 * Given a graph, perform Depth First Search (DFS) traversal starting from a
 * given node.
 * Input:
 * - Number of vertices (V)
 * - Edge list (Adjacency List)
 * - Starting node
 * Output: DFS traversal order
 * Concepts Tested: Recursion/Stack, Graph traversal
 */
public class DFSTraversal {

    /**
     * Performs DFS traversal on a graph.
     *
     * @param V         The number of vertices.
     * @param adj       The adjacency list representing the graph.
     * @param startNode The starting node for DFS.
     * @return A list of integers representing the DFS traversal order.
     */
    public static List<Integer> dfs(int V, List<List<Integer>> adj, int startNode) {
        List<Integer> dfsOrder = new ArrayList<>();
        boolean[] visited = new boolean[V];
        dfsRecursive(startNode, adj, visited, dfsOrder);
        return dfsOrder;
    }

    /**
     * Recursive helper for DFS traversal.
     */
    private static void dfsRecursive(int u, List<List<Integer>> adj, boolean[] visited, List<Integer> dfsOrder) {
        visited[u] = true;
        dfsOrder.add(u);

        for (int neighbor : adj.get(u)) {
            if (!visited[neighbor]) {
                dfsRecursive(neighbor, adj, visited, dfsOrder);
            }
        }
    }

    public static void main(String[] args) {
        int V = 5;
        List<List<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < V; i++) {
            adj.add(new ArrayList<>());
        }

        // Add edges: 0-1, 0-2, 2-3, 3-4
        adj.get(0).add(1);
        adj.get(1).add(0);
        adj.get(0).add(2);
        adj.get(2).add(0);
        adj.get(2).add(3);
        adj.get(3).add(2);
        adj.get(3).add(4);
        adj.get(4).add(3);

        System.out.println("DFS Traversal starting from 0: " + dfs(V, adj, 0));
        // Possible Output: [0, 1, 2, 3, 4] or [0, 2, 3, 4, 1] depending on neighbor
        // order
    }
}
