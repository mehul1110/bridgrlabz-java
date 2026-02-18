package treesandgraphs.graphs;

import java.util.*;

/**
 * BFS Traversal of a Graph
 * Problem Statement:
 * Given an undirected graph, perform Breadth First Search (BFS) starting from a
 * given node.
 * Input:
 * - Number of vertices (V)
 * - Edge list (Adjacency List)
 * - Starting node
 * Output: BFS traversal order
 * Concepts Tested: Queue, Graph traversal
 */
public class BFSTraversal {

    /**
     * Performs BFS traversal on an undirected graph.
     *
     * @param V         The number of vertices.
     * @param adj       The adjacency list representing the graph.
     * @param startNode The starting node for BFS.
     * @return A list of integers representing the BFS traversal order.
     */
    public static List<Integer> bfs(int V, List<List<Integer>> adj, int startNode) {
        List<Integer> bfsOrder = new ArrayList<>();
        boolean[] visited = new boolean[V];
        Queue<Integer> queue = new LinkedList<>();

        // Start BFS from the given startNode
        visited[startNode] = true;
        queue.add(startNode);

        while (!queue.isEmpty()) {
            int node = queue.poll();
            bfsOrder.add(node);

            // Visit all unvisited neighbors
            for (int neighbor : adj.get(node)) {
                if (!visited[neighbor]) {
                    visited[neighbor] = true;
                    queue.add(neighbor);
                }
            }
        }
        return bfsOrder;
    }

    public static void main(String[] args) {
        int V = 5;
        List<List<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < V; i++) {
            adj.add(new ArrayList<>());
        }

        // Add edges: 0-1, 0-2, 0-3, 2-4
        adj.get(0).add(1);
        adj.get(1).add(0);
        adj.get(0).add(2);
        adj.get(2).add(0);
        adj.get(0).add(3);
        adj.get(3).add(0);
        adj.get(2).add(4);
        adj.get(4).add(2);

        System.out.println("BFS Traversal starting from 0: " + bfs(V, adj, 0));
        // Expected: [0, 1, 2, 3, 4] (Order of 1, 2, 3 depends on insertion order)
    }
}
