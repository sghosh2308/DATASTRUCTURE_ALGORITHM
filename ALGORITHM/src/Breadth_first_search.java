import java.util.LinkedList;
import java.util.Queue;

public class Breadth_first_search extends Graph {
    int color[];
    int distance[];
    Node descendent[];
    Breadth_first_search(int v, int e) {
        super(v, e);
        color=new int[v];
        distance=new int[v];
        descendent=new Node[v];
        for(int i=0;i<v;i++){
            color[i]=0;
            distance[i]=Integer.MAX_VALUE;
            descendent[i]=null;
        }
    }
    public void search(int d){
        color[d]=1;
        distance[d]=0;
        Queue<Node> q=new LinkedList<>();
        q.add(list[d]);
        while(!q.isEmpty()){
            Node curr=q.poll();

            while(curr!=null){
                if (color[curr.data]==0){
                    color[curr.data]=1;
                    distance[curr.data]=distance[d]+1;
                    descendent[curr.data]=curr;
                    q.add(curr);
                }
                color[d]=3;
                curr=curr.next;

            }
        }



    }



    public static void  main(String args[]){
       Breadth_first_search g=new Breadth_first_search(5,5);
       g.addedge(1,2);
       g.addedge(1,4);
       g.addedge(3,4);
       g.addedge(3,2);
       g.addedge(2,4);
       g.print();
       g.search(3);
        for(int i=1;i<=4;i++){
            System.out.print(g.color[i]+"  ");
        }
        System.out.println();
        System.out.println("DISTANCE");
        for(int i=1;i<=4;i++){
            System.out.print(g.distance[i]+"  ");
        }
    }
}
