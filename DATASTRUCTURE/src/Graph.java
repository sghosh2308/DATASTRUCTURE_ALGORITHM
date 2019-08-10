public class Graph {
    /*Trying to implement graph using the concept of Adjacency List*/
    Node list[];
    private int vertex,edge,counter=0;
    class Node{
        int data;
        Node next;

        Node(int data){
            this.data=data;
            this.next=next;
        }
        Node(){

    }

        private void addNext(int data) {
            if(this==null){
                this.data=data;
                this.next=null;
            }
            else{ Node n=this;
                while(n.next!=null){
                    n=n.next;
                }
                n.next=new Node(data);
            }
        }
    }
    Graph(int v,int e) {
        this.vertex = v;
        this.edge = e;
        list = new Node[v];
        for (int i = 0; i < vertex; i++) {
            list[i] = new Node();
        }
    }

        public void addvertex(int from,int to) {
            if (this.counter < edge){
                this.list[from].addNext(to);
                counter++;
            }
            else{
                System.out.println("NO MORE EDGES CAN'T BE ADDED");
            }

        }

        public void print(){
            for(int i=0;i<this.vertex;i++){
                System.out.print(i+" -->");
                Node curr=list[i];
                while(curr!=null){
                    System.out.print(curr.data+", ");
                    curr=curr.next;
                }
                System.out.print("\b");
                System.out.println();
            }
        }

    public static void main(String args[]){
        Graph g=new Graph(4,5);
        g.addvertex(1,3);
        g.addvertex(1,1);
        g.addvertex(3,2);
        g.print();
    }

}
