
public class Graph {
    /*Trying to implement graph using the concept of Adjacency List*/
    Node list[];
    protected int vertex,edge,counter=0;
    class Node{
        int data;
        Node next;
        Node(int data){
            this.data=data;
            this.next=next;
        }

        private void addNext(int data) {
             Node n=this;
                while(n.next!=null){
                    n=n.next;
                }
                n.next=new Node(data);
            }
        }

    Graph(int v,int e) {
        this.vertex = v;
        this.edge = e;
        list = new Node[v];
        }


        public void addedge(int from,int to) {
            if (this.counter < edge) {
                if (this.list[from] == null) {
                    list[from] = new Node(to);
                } else {
                    this.list[from].addNext(to);

                }
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

    }


