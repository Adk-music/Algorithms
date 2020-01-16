package geekbrains.lessons.homeworkseven;

public class Main {

    public static void main(String[] args) {

        Graph graph = new Graph(10);
        graph.addEdge(0,1);
        graph.addEdge(0,4);
        graph.addEdge(0,2);
        graph.addEdge(4,5);
        graph.addEdge(4,8);
        graph.addEdge(5,6);
        graph.addEdge(5,8);
        graph.addEdge(6,2);
        graph.addEdge(9,3);

      //  System.out.println(graph.getAdjList(1));

        DepthFirstPaths dfp = new DepthFirstPaths(graph,5);
        System.out.println(dfp.hasPathTo(0));
        System.out.println(dfp.hasPathTo(7));
        System.out.println(dfp.pathTo(2));

        BreadthFirstPath bfp = new BreadthFirstPath(graph,5);
        System.out.println(bfp.hasPathTo(0));
        System.out.println(bfp.hasPathTo(7));
        System.out.println(bfp.pathTo(2));
    }
}
