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
    /*This function add next node this it always append at the end of the list and is useing vargues concept this one or
    many node can be created at once
    * */



    public void append(int... data){
        for(int node_data :data) {
            Node generate_node = new Node(node_data);
            if (this.Head == null) {
                this.Head = generate_node;
            } else {
                Node traverse = this.Head;
                while (traverse.next != null) traverse = traverse.next;
                traverse.next = generate_node;
            }
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
    public void delete(){
        Node traverse=this.Head;
        while(traverse.next.next!=null){
            traverse=traverse.next;
        }
        traverse.next=null;
    }
    public static void main(String args[]){
        LinkedList list=new LinkedList();
        list.append(1,2,3,4,4,5,0,6,6,4);

    }
}
