package geekbrains.lessons.homeworkseven;

import java.util.LinkedList;

public class BreadthFirstPath {
    private boolean[] marked;
    private int[] edgeTo;
    private int source;

    public BreadthFirstPath(Graph g, int source) {
        this.source = source;
        marked = new boolean[g.getVertexCount()];
        edgeTo = new int[g.getVertexCount()];
        bfs(g,source);
    }

    private void bfs(Graph g, int source){
        LinkedList<Integer> queue = new LinkedList<>();
        queue.addLast(source);
        marked[source] = true;

        while (!queue.isEmpty()){
            int vertex = queue.removeFirst();
            for (int w: g.getAdjList(vertex)) {
                if(!marked[w]){
                    marked[w] = true;
                    edgeTo[w] = vertex;  //отметили что посещено
                    queue.addLast(w); //добавили в очередь
                }

            }
        }

    }

    public boolean hasPathTo(int dist) {
        return marked[dist];
    }
    public LinkedList<Integer> pathTo(int dist){ //путь из вершины s в v.
        if(!hasPathTo(dist)){
            return null;
        }
        LinkedList<Integer> stack = new LinkedList<>();
        int vertex = dist;
        while (vertex != source){
            stack.push(vertex);
            vertex = edgeTo[vertex];
        }
        return stack;
    }
}
