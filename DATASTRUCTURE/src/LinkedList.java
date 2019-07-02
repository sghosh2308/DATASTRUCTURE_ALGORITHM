public class LinkedList {
    Node Head;

    static class Node{
        int data;
        Node next;
         Node(int data,Node next){
             this.data=data;
             this.next=next;
         }
         Node(int data){
             this(data,null);
         }
    }

    public void append(int data){
        Node generate_node=new Node(data);
        if(this.Head==null){
            this.Head=generate_node;
        }
        else{
            Node traverse=this.Head;
            while(traverse.next!=null) traverse = traverse.next;
            traverse.next=generate_node;
        }
    }
    public void print(){
        Node traverse=this.Head;
        StringBuilder data=new StringBuilder();
        while(traverse!=null){
            data.append(traverse.data).append(", ");
            traverse=traverse.next;
        }
        System.out.println(data);
    }
    public static void main(String args[]){
        LinkedList list=new LinkedList();
        list.append(1);
        list.append(2);
        list.print();
    }
}
