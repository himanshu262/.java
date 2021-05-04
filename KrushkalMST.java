import java.util.ArrayList;
import java.util.Comparator;
import java.util.PriorityQueue;

public class KrushkalMST {
    static class Edge {
        int s;
        int d;
        int w;

        public Edge(int s, int d, int w) {
            this.s = s;
            this.d = d;
            this.w = w;
        }
    }

    static class Graph {
        int vertices;
        ArrayList<Edge> allEdges = new ArrayList<>();

        Graph(int vertices) {
            this.vertices = vertices;
        }

        public void addEgde(int s, int d, int w) {
            Edge edge = new Edge(s, d, w);
            allEdges.add(edge); 
        }
        
        public void kruskalMST(){
            PriorityQueue<Edge> pq = new PriorityQueue<>(allEdges.size(), Comparator.comparingInt(o -> o.w));

            
            for (int i = 0; i <allEdges.size() ; i++) {
                pq.add(allEdges.get(i));
            }

     
            int [] parent = new int[vertices];

    
            makeSet(parent);

            ArrayList<Edge> mst = new ArrayList<>();

          
            int index = 0;
            while(index<vertices-1){
                Edge edge = pq.remove();
           
                int x_set = find(parent, edge.s);
                int y_set = find(parent, edge.d);

                if(x_set==y_set){
            
                }else {
             
                    mst.add(edge);
                    index++;
                    union(parent,x_set,y_set);
                }
            }
     
            System.out.println("Minimum Spanning Tree: ");
            printGraph(mst);
        }

        public void makeSet(int [] parent){
    
            for (int i = 0; i <vertices ; i++) {
                parent[i] = i;
            }
        }

        public int find(int [] parent, int vertex){
        
            if(parent[vertex]!=vertex)
                return find(parent, parent[vertex]);;
            return vertex;
        }

        public void union(int [] parent, int x, int y){
            int x_set_parent = find(parent, x);
            int y_set_parent = find(parent, y);
          
            parent[y_set_parent] = x_set_parent;
        }

        public void printGraph(ArrayList<Edge> edgeList){
            for (int i = 0; i <edgeList.size() ; i++) {
                Edge edge = edgeList.get(i);
                System.out.println("Edge-" + i + " s: " + edge.s +
                        " d: " + edge.d +
                        " w: " + edge.w);
            }
        }
    }
    public static void main(String[] args) {
            int vertices = 6;
            Graph graph = new Graph(vertices);
            graph.addEgde(0, 1, 4);
            graph.addEgde(0, 2, 3);
            graph.addEgde(1, 2, 1);
            graph.addEgde(1, 3, 2);
            graph.addEgde(2, 3, 4);
            graph.addEgde(3, 4, 2);
            graph.addEgde(4, 5, 6);
            graph.kruskalMST();
    }
}