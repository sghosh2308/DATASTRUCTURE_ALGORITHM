import java.io.*;
import java.util.LinkedList;
import java.util.Queue;

public class Breadth_first_search extends Graph {
    private int color[];
    private int distance[];
    private int descendent[];
    private Breadth_first_search(int v, int e) {
        super(v, e);
        color=new int[v];
        distance=new int[v];
        descendent=new int[v];
        for(int i=0;i<v;i++){
            color[i]=0;
            distance[i]=Integer.MAX_VALUE;
            descendent[i]=0;
        }
    }
    private void search(int d){
        Queue<Integer> descendent=new LinkedList<>();
        color[d]=1;
        distance[d]=0;
        int index=d;
        descendent.add(d);
        Queue<Node> q=new LinkedList<>();
        q.add(list[d]);

        //System.out.println("SETTING QUEUE WITH "+d);
        while(!q.isEmpty()){
            Node curr=q.poll();
            int i= Integer.valueOf(descendent.poll());
           //System.out.println("RUNNING QUEUE WITH "+curr.data);
            while(curr!=null){
               // System.out.println("RUNING WHILE WITH CURR FOR "+curr.data);
                if (color[curr.data]==0){
                    color[curr.data]=1;
                    distance[curr.data]=distance[d]+1;
                    this.descendent[curr.data]=i;
                   // System.out.println("STTING DESCENDANT WITH VALUE "+i);
                    //System.out.println("");
                    q.add(list[curr.data]);
                    descendent.add(curr.data);
                }

                color[d]=3;
                curr=curr.next;
               // System.out.println("CHNAGING CURR TO NEXT VAL"+curr.data);

            }
        }



    }
    private void print_path(int s,int d){
        if (d==s){
            System.out.print(s);
        }
        else if(descendent[d]==0){
            System.out.println("THERE IS NO PATH");
            return;
        }
        else{
            print_path(s,descendent[d]);
                System.out.print(d);
            }
        System.out.print("->");
        }





    public static void  main(String ...x)throws IOException{
       Breadth_first_search g=new Breadth_first_search(11,20);
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        g.addedge(1,5);
        g.addedge(1,6);
        g.addedge(1,2);
        g.addedge(1,4);
        g.addedge(1,7);
        g.addedge(2,3);
        g.addedge(2,4);
        g.addedge(3,4);
        g.addedge(3,2);
        g.addedge(4,5);
        g.addedge(5,6);
        g.addedge(7,6);
        g.addedge(8,7);
        g.addedge(8,1);
        g.addedge(8,2);
        g.addedge(9,8);
        g.addedge(9,2);
        g.addedge(9,10);
        g.addedge(10,2);
        g.addedge(10,3);
        g.print();
        System.out.println("ENETR THE SOURCE");
        int s=Integer.parseInt(br.readLine());
        g.search(s);
       System.out.println("");
        g.print_path(9,6);
    }
}
