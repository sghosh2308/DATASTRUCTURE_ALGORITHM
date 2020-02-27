import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;

public class BridgeElements
{
    boolean[] visited;
    static class Graph
    {
        int vertex;
        int edge_count;
        LinkedList<Integer>[] adjlist;
        LinkedList[] edges;
        public Graph(int vertex, int edge_count) {
            this.vertex = vertex;
            this.edge_count = edge_count;
            adjlist = new LinkedList[vertex];
            edges=new LinkedList[edge_count];
            for (int i = 0; i <vertex; i++)
            {
                adjlist[i] = new LinkedList<>();
            }
            for(int i=0;i<edge_count;i++)
            {
                edges[i]=new LinkedList<>();
            }
        }
        public void addEdge(int src, int dest,int i)
        {
            this.adjlist[src].add(dest);
            this.adjlist[dest].add(src);
            edges[i].add(src);
            edges[i].add(dest);
        }
    }
    public void dfs(Graph graph,int i)
    {
        visited[i]=true;
        for(int x:graph.adjlist[i])
        {
            if(!visited[x])
                dfs(graph,x);
        }
    }
    private int visit(Graph graph)
    {
        int connected=0;
        visited=new boolean[graph.vertex];
        Arrays.fill(visited,false);
        for(int i=0;i<visited.length;i++)
        {
            if(!visited[i])
            {
                connected++;
                dfs(graph,i);
            }
        }
        return connected;
    }
    public ArrayList<ArrayList<Integer>> getBridges(Graph graph)
    {   int initial_count=visit(graph);
        ArrayList<ArrayList<Integer>> result=new ArrayList<>();
        for(LinkedList<Integer> x:graph.edges)
        {
            int v1=x.get(0);
            int v2=x.get(1);
            graph.adjlist[v1].remove((Integer)v2);
            graph.adjlist[v2].remove((Integer)v1);
            if(visit(graph)>initial_count)
            {
                result.add(new ArrayList<>(Arrays.asList(v1,v2)));
            }
            graph.adjlist[v1].add(v2);
            graph.adjlist[v2].add(v1);
        }
        return result;
    }
    public static void main(String ...args)throws IOException
    {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Enter Number OF vertex And Edges");
        BridgeElements b=new BridgeElements();
        int v=Integer.parseInt(br.readLine());
        int e=Integer.parseInt(br.readLine());
        Graph graph=new Graph(v,e);
        for(int i=0;i<e;i++)
        {
            System.out.println("ENTER SOURCE");
            int src=Integer.parseInt(br.readLine());
            System.out.println("ENTER DESTINATION");
            int dest=Integer.parseInt(br.readLine());
            graph.addEdge(src,dest,i);
        }
        int i=0;
        for(LinkedList<Integer> l:graph.adjlist)
        {  System.out.print(i);
            for(int x:l)
            {
                System.out.print("->"+x);
            }
            System.out.println("\n");
            i++;
        }
        ArrayList<ArrayList<Integer>> result=b.getBridges(graph);
        if(result.isEmpty())
        {
            System.out.println("NO SUCH BRIDGE EDGES FOUND");
        }
        else
            {
                System.out.println("Bridge Edges");
                for(ArrayList<Integer> x:result)
                {
                    for(int a:x)
                    {
                        System.out.print(a+"-----");
                    }
                    System.out.print("\b\b\b\b\b\n");
                }
            }
    }
}