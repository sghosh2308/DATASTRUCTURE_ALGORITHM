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

      /*This function prints the linked list
    * */


    public void print(){
        if(this.Head==null) return;
        Node traverse=this.Head;
        StringBuilder data=new StringBuilder();
        while(traverse!=null){
            data.append(traverse.data).append(", ");
            traverse=traverse.next;
        }
        System.out.println(data);
    }

      /*This function deletes at the end of the node */

    public void deleteatend(){
        Node traverse=this.Head;
        while(traverse.next.next!=null){
            traverse=traverse.next;
        }
        traverse.next=null;
    }

   /* This function is overloaded if nothing is mentioned it will delete complete list and if position is mentioned
   particular node will be deleted*/

    public void delete(){
        this.Head=null;
    }
    public void delete(int a){
        Node traverse=this.Head;
        for(int i=1;i<=a-1 && traverse!=null;i++){
            traverse=traverse.next;
        }
        traverse.next=traverse.next.next;
    }
    



    public static void main(String args[]){
        LinkedList list=new LinkedList();
        list.append(1,2,3,4,4,5,0,6,6,4);
        list.print();
        list.deleteatend();
        list.delete(4);
        list.print();
        list.delete();
        list.print();

    }
}
