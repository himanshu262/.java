package Greedy;
import java.util.*;
public class BreadthFirstSearch
{
    public static void main(String[]args)
    {
         ArrayList<ArrayList <Integer>>arr= new ArrayList<ArrayList <Integer>>(5);
         for(int i=0;i<5;i++)
         {
             arr.add(new ArrayList<Integer>());
         }
         addVertex(arr,0,1);
         addVertex(arr,0,2);
         addVertex(arr,1,3);
         addVertex(arr,1,2);
         addVertex(arr,2,4);
         addVertex(arr,2,3);
         addVertex(arr,3,4);
         System.out.print("BFS -> ");
         bfs(arr,4,0);
         
     }
     public static void addVertex(ArrayList<ArrayList <Integer>>arr,int x,int y)
     {
         arr.get(x).add(y);
         arr.get(y).add(x);
     }
     public static void bfs(ArrayList<ArrayList <Integer>> arr,int v ,int s)
     {
         boolean visited[] =new boolean[v+1];
         Queue <Integer> q=new LinkedList<>();
         visited[s]=true;
         q.add(s);
         while(q.isEmpty()==false)
         {
             int u =q.poll();
             System.out.print(u + " ");
             for(int i:arr.get(u))
             {
             if(visited[i]==false)
             { 
                 visited[i]=true;
                 q.add(i);
             }
             }
          }
      }
}