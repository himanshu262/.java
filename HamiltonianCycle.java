class HamiltonianCycle
{
    final int V = 5;
    int path[];
  
    boolean isSafe(int v, int graph[][], int path[], int pos)
    {
       
        if (graph[path[pos - 1]][v] == 0)
            return false;
  
        for (int i = 0; i < pos; i++)
            if (path[i] == v)
                return false;
  
        return true;
    }
  
 
    boolean hamCycleUtil(int graph[][], int path[], int pos)
    {
        
        if (pos == V)
        {
            
            if (graph[path[pos - 1]][path[0]] == 1)
                return true;
            else
                return false;
        }
  
      
        for (int v = 1; v < V; v++)
        {
           
            if (isSafe(v, graph, path, pos))
            {
                path[pos] = v;
  
               
                if (hamCycleUtil(graph, path, pos + 1) == true)
                    return true;
  
                path[pos] = -1;
            }
        }
