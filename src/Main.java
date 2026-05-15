public class Main {
    public static void main(String[] args) {
        Graph graph = new Graph();

        // small graph
        for (int i = 0; i < 10; i++) {
            graph.addVertex(new Vertex(i));
        }

        graph.addEdge(0, 1);
        graph.addEdge(0, 2);
        graph.addEdge(1, 3);
        graph.addEdge(1, 4);
        graph.addEdge(2, 5);
        graph.addEdge(3, 6);
        graph.addEdge(4, 7);
        graph.addEdge(5, 8);
        graph.addEdge(6, 9);

        System.out.println("GRAPH:");

        graph.printGraph();

        System.out.println();

        Experiment experiment = new Experiment();

        experiment.runTraversals(graph);

        experiment.runMultipleTests();

        experiment.printResults();
    }
}