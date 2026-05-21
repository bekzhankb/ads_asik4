import java.util.*;

public class Graph {

    private Map<Integer, List<Edge>> adjacencyList;

    public Graph() {
        adjacencyList = new HashMap<>();
    }

    // add vertex
    public void addVertex(Vertex v) {
        adjacencyList.putIfAbsent(v.getId(), new ArrayList<>());
    }

    // add weighted edge
    public void addEdge(int from, int to, int weight) {

        adjacencyList.get(from)
                .add(new Edge(from, to, weight));

        adjacencyList.get(to)
                .add(new Edge(to, from, weight));
    }

    // print graph
    public void printGraph() {

        for (int vertex : adjacencyList.keySet()) {
            System.out.print(vertex + ": ");

            for (Edge edge : adjacencyList.get(vertex)) {

                System.out.print(
                        edge.getDestination()
                                + "("
                                + edge.getWeight()
                                + ") "
                );
            }
            System.out.println();
        }
    }

    // BFS
    public void bfs(int start) {

        Set<Integer> visited = new HashSet<>();
        Queue<Integer> queue = new LinkedList<>();

        visited.add(start);
        queue.add(start);

        System.out.print("BFS: ");

        while (!queue.isEmpty()) {

            int current = queue.poll();
            System.out.print(current + " ");

            for (Edge edge : adjacencyList.get(current)) {
                int neighbor = edge.getDestination();

                if (!visited.contains(neighbor)) {
                    visited.add(neighbor);
                    queue.add(neighbor);
                }
            }
        }
        System.out.println();
    }

    // DFS
    public void dfs(int start) {

        Set<Integer> visited = new HashSet<>();
        System.out.print("DFS: ");

        dfsHelper(start, visited);
        System.out.println();
    }

    private void dfsHelper(int current, Set<Integer> visited) {

        visited.add(current);
        System.out.print(current + " ");

        for (Edge edge : adjacencyList.get(current)) {

            int neighbor = edge.getDestination();
            if (!visited.contains(neighbor)) {
                dfsHelper(neighbor, visited);
            }
        }
    }

    // Dijkstra
    public void dijkstra(int start) {

        int size = adjacencyList.size();

        int[] distance = new int[size];
        boolean[] visited = new boolean[size];
        for (int i = 0; i < size; i++) {
            distance[i] = Integer.MAX_VALUE;
        }

        distance[start] = 0;

        for (int i = 0; i < size - 1; i++) {
            int current = getMinDistanceVertex(distance, visited);
            visited[current] = true;

            for (Edge edge : adjacencyList.get(current)) {

                int neighbor = edge.getDestination();
                int weight = edge.getWeight();

                if (!visited[neighbor]
                        && distance[current] != Integer.MAX_VALUE
                        && distance[current] + weight < distance[neighbor]) {

                    distance[neighbor] = distance[current] + weight;
                }
            }
        }

        System.out.println("\nDijkstra Shortest Paths:");

        for (int i = 0; i < size; i++) {
            System.out.println(
                    start + " -> " + i + " = " + distance[i]
            );
        }
    }

    private int getMinDistanceVertex(int[] distance,
                                     boolean[] visited) {

        int min = Integer.MAX_VALUE;
        int minIndex = -1;

        for (int i = 0; i < distance.length; i++) {

            if (!visited[i] && distance[i] < min) {

                min = distance[i];
                minIndex = i;
            }
        }

        return minIndex;
    }
}