import java.util.HashMap;
import java.util.Map;

public class DisjointSets {
    private Map<Long,Node> map=new HashMap<>();
    class Node{
        long data;
        Node parent;
        int rank;
        Node(long data){
            this.data=data;
            this.rank=0;
            this.parent=this;
        }
    }
    public void makeSet(long data){
        Node node=new Node(data);
        map.put(data,node);
    }
    private Node findSet(Node node){
        Node parent=node.parent;
        if(parent==node){
            return node;
        }
        node.parent=findSet(node.parent);
        return node.parent;// compressing path and finding parent at same time
    }
    //For checking whether the data is actually present in the set
    public long findSet(long data){
        return findSet(map.get(data)).data;
    }
    public boolean union(long d1,long d2){
        Node n1=map.get(d1);
        Node n2=map.get(d2);

        Node parent1=findSet(n1);
        Node parent2=findSet(n2);

        if(parent1.data==parent2.data){
            return false;
        }
        if(parent1.rank>=parent2.rank){
            parent1.rank=parent1.rank==parent2.rank?parent1.rank+1:parent1.rank;
            parent2.parent=parent1;
        }
        else{
            parent1.parent=parent2;
        }
        return true;
    }
}

