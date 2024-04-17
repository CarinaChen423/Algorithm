import java.util.*;
public class Lab8_DFS {
    private Map<Integer, List<Integer>> adjList;

    public Lab8_DFS() {
        adjList = new HashMap<>();
    }

    // Add edge to the graph
    public void addEdge(int v, int w) {
        adjList.computeIfAbsent(v, x -> new ArrayList<>()).add(w);
        adjList.computeIfAbsent(w, x -> new ArrayList<>()).add(v);
    }

    // DFS algorithm
    public void DFS(int v) {
        boolean[] visited = new boolean[adjList.size() + 1];
        DFSUtil(v, visited);
    }

    // Recursive helper method for DFS
    private void DFSUtil(int v, boolean[] visited) {
        // Mark the current node as visited and print it
        visited[v] = true;
        System.out.print(v + " ");

        // Recur for all the vertices adjacent to this vertex
        for (int adj : adjList.getOrDefault(v, Collections.emptyList())) {
            if (!visited[adj]) {
                DFSUtil(adj, visited);
            }
        }
    }

    public static void main(String[] args) {
        Lab8_DFS g = new Lab8_DFS();

        // Adding edges based on the given graph
        g.addEdge(1, 2);
        g.addEdge(1, 5);
        g.addEdge(1, 9);
        g.addEdge(1, 10);
        g.addEdge(2, 3);
        g.addEdge(2, 4);
        g.addEdge(3, 4);
        g.addEdge(5, 6);
        g.addEdge(5, 7);
        g.addEdge(7, 8);

        // Starting DFS from node 1
        System.out.println("Depth-First Search starting from node 1:");
        g.DFS(1);
    }
}
