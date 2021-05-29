 public class Prim {

    private List<Vertex> graph;

}

public void run() {
    if (graph.size() > 0) {
        graph.get(0).setVisited(true);
    }
    while (isDisconnected()) {
        Edge nextMinimum = new Edge(Integer.MAX_VALUE);
        Vertex nextVertex = graph.get(0);
        for (Vertex vertex : graph) {
            if (vertex.isVisited()) {
                Pair<Vertex, Edge> candidate = vertex.nextMinimum();
                if (candidate.getValue().getWeight() < nextMinimum.getWeight()) {
                    nextMinimum = candidate.getValue();
                    nextVertex = candidate.getKey();
                }
            }
        }
        nextMinimum.setIncluded(true);
        nextVertex.setVisited(true);
    }
}
We start by setting the first element of the List<Vertex> graph as visited. The first element can be any of the vertices depending on the order they've been added to the list in the first place. isDisconnected() returns true if there is any Vertex not visited so far:


freestar
private boolean isDisconnected() {
    for (Vertex vertex : graph) {
        if (!vertex.isVisited()) {
            return true;
        }
    }
    return false;
}
While the minimum spanning tree isDisconnected(), we loop over the already visited vertices and find the Edge with the minimum weight as a candidate for nextVertex:

public Pair<Vertex, Edge> nextMinimum() {
    Edge nextMinimum = new Edge(Integer.MAX_VALUE);
    Vertex nextVertex = this;
    Iterator<Map.Entry<Vertex,Edge>> it = edges.entrySet()
        .iterator();
    while (it.hasNext()) {
        Map.Entry<Vertex,Edge> pair = it.next();
        if (!pair.getKey().isVisited()) {
            if (!pair.getValue().isIncluded()) {
                if (pair.getValue().getWeight() < nextMinimum.getWeight()) {
                    nextMinimum = pair.getValue();
                    nextVertex = pair.getKey();
                }
            }
        }
    }
    return new Pair<>(nextVertex, nextMinimum);
}