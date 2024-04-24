import java.util.*;

class Edge implements Comparable<Edge> {
    int src, dest, weight;

    public Edge(int src, int dest, int weight) {
        this.src = src;
        this.dest = dest;
        this.weight = weight;
    }

    @Override
    public int compareTo(Edge compareEdge) {
        return this.weight - compareEdge.weight;
    }
}

class Subset {
    int parent, rank;
}

class Graph {
    int vertices;
    LinkedList<Edge>[] adjacencylist;
    ArrayList<Edge> edges;

    Graph(int vertices) {
        this.vertices = vertices;
        adjacencylist = new LinkedList[vertices];
        edges = new ArrayList<>();
        for (int i = 0; i < vertices; i++) {
            adjacencylist[i] = new LinkedList<>();
        }
    }

    void addEdge(int src, int dest, int weight) {
        Edge edge = new Edge(src, dest, weight);
        adjacencylist[src].add(edge);
        edges.add(edge); // For Kruskal's use
    }

    // Kruskal's algorithm
    ArrayList<Edge> kruskalMST() {
        PriorityQueue<Edge> pq = new PriorityQueue<>(edges.size(), Comparator.comparingInt(o -> o.weight));
        pq.addAll(edges);

        Subset[] subsets = new Subset[vertices];
        for (int i = 0; i < vertices; ++i) {
            subsets[i] = new Subset();
            subsets[i].parent = i;
            subsets[i].rank = 0;
        }

        ArrayList<Edge> result = new ArrayList<>();
        while (result.size() < vertices - 1) {
            Edge edge = pq.remove();
            int x = find(subsets, edge.src);
            int y = find(subsets, edge.dest);

            if (x != y) {
                result.add(edge);
                union(subsets, x, y);
            }
        }
        return result;
    }

    // Prim's algorithm
    ArrayList<Edge> primMST() {
        boolean[] mstSet = new boolean[vertices];
        Edge[] resultSet = new Edge[vertices];
        int[] key = new int[vertices];

        for (int i = 0; i < vertices; i++) {
            key[i] = Integer.MAX_VALUE;
        }

        key[0] = 0;
        resultSet[0] = new Edge(-1, 0, 0);

        for (int i = 0; i < vertices - 1; i++) {
            int minIndex = -1;
            int minKey = Integer.MAX_VALUE;
            for (int v = 0; v < vertices; v++) {
                if (!mstSet[v] && key[v] < minKey) {
                    minKey = key[v];
                    minIndex = v;
                }
            }

            int u = minIndex;
            mstSet[u] = true;

            for (Edge neighbor : adjacencylist[u]) {
                if (!mstSet[neighbor.dest] && neighbor.weight < key[neighbor.dest]) {
                    resultSet[neighbor.dest] = neighbor;
                    key[neighbor.dest] = neighbor.weight;
                }
            }
        }

        ArrayList<Edge> result = new ArrayList<>();
        for (int v = 1; v < vertices; v++) {
            result.add(resultSet[v]);
        }
        return result;
    }

    // A utility function to find set of an element i (uses path compression)
    int find(Subset subsets[], int i) {
        if (subsets[i].parent != i)
            subsets[i].parent = find(subsets, subsets[i].parent);
        return subsets[i].parent;
    }

    // A function that does union of two sets of x and y (uses union by rank)
    void union(Subset subsets[], int x, int y) {
        int xroot = find(subsets, x);
        int yroot = find(subsets, y);

        if (subsets[xroot].rank < subsets[yroot].rank)
            subsets[xroot].parent = yroot;
        else if (subsets[xroot].rank > subsets[yroot].rank)
            subsets[yroot].parent = xroot;
        else {
            subsets[yroot].parent = xroot;
            subsets[xroot].rank++;
        }
    }
}

public class Lab9_Graphs {
    public static void main(String[] args) {
        int vertices = 8;
        Graph graph = new Graph(vertices);
        graph.addEdge(0, 1, 4); // A-B
        graph.addEdge(0, 2, 3); // A-C
        graph.addEdge(0, 6, 6); // A-G
        graph.addEdge(1, 2, 3); // B-C
        graph.addEdge(1, 3, 3); // B-D
        graph.addEdge(2, 3, 6); // C-D
        graph.addEdge(2, 4, 5); // C-E
        graph.addEdge(3, 4, 3); // D-E
        graph.addEdge(3, 5, 6); // D-F
        graph.addEdge(4, 5, 3); // E-F
        graph.addEdge(4, 6, 4); // E-G
        graph.addEdge(5, 7, 2); // F-H
        graph.addEdge(6, 7, 7); // G-H

        ArrayList<Edge> primMST = graph.primMST();
        ArrayList<Edge> kruskalMST = graph.kruskalMST();

        System.out.println("Prim's MST:");
        for (Edge edge : primMST) {
            System.out.println((char)('A' + edge.src) + " - " + (char)('A' + edge.dest) + ": " + edge.weight);
        }

        System.out.println("Kruskal's MST:");
        for (Edge edge : kruskalMST) {
            System.out.println((char)('A' + edge.src) + " - " + (char)('A' + edge.dest) + ": " + edge.weight);
        }
    }
}
