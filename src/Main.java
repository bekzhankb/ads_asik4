public class Main {

    public static void main(String[] args) {

        Graph graph = new Graph();

        // add vertices
        for (int i = 0; i < 10; i++) {
            graph.addVertex(new Vertex(i));
        }

        // add weighted edges
        graph.addEdge(0, 1, 4);
        graph.addEdge(0, 2, 2);
        graph.addEdge(1, 3, 5);
        graph.addEdge(1, 4, 1);
        graph.addEdge(2, 5, 3);
        graph.addEdge(3, 6, 2);
        graph.addEdge(4, 7, 7);
        graph.addEdge(5, 8, 6);
        graph.addEdge(6, 9, 1);

        System.out.println("GRAPH:");

        graph.printGraph();

        System.out.println();

        // traversals
        Experiment experiment = new Experiment();
        experiment.runTraversals(graph);

        // dijkstra
        graph.dijkstra(0);

        // performance tests
        experiment.runMultipleTests();
        experiment.printResults();
    }
}