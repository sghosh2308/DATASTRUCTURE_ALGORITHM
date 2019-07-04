/*Love You Mom
* */

import java.util.NoSuchElementException;

public class LinkedList {
    Node Head;
    int length=0;// Count the length of the linked list

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

    /*This function add next node this it always append at the end of the list and is using Varages concept this one or
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
            this.length++;
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
        this.length--;
    }
    /*This function finds the element and then deletes it and if no such elemnt is found it generates no such exception*/

    public void FindandDelete(int data){
        if(Head.data==data){
           this.Head=this.Head.next;
        }
        else {
            Node traverse = this.Head;
            while (traverse.next != null) {
                if (traverse.next.data == data) {
                    traverse.next = traverse.next.next;
                    return null;
                }
            }
        }
        throws new NoSuchElementException();

    }


   /* This function is overloaded if nothing is mentioned it will delete complete list and if position is mentioned
   particular node will be deleted*/

    public void delete(){
        this.Head=null;
        this.length=0;
    }
    public void delete(int a) {
        Node traverse = this.Head;
        if (a == 1) {
            this.Head=traverse.next;
            this.length--;

        } else {
            for (int i = 1; i <= a - 1 && traverse != null; i++) {
                traverse = traverse.next;
            }
            traverse.next = traverse.next.next;
            this.length--;
        }

    }


    /*This function will insert node at particular position within the Range of the list*/
    public void insert(int data, int pos){
        if(pos>this.length) throw  new IndexOutOfBoundsException();
            Node traverse=this.Head;
            if(pos==1){
                this.Head=new Node(data,traverse.next);
                this.length++;
            }
            else {
                for (int i = 1; i <= pos - 1; i++) {
                    traverse = traverse.next;
                }
                traverse.next = new Node(data, traverse.next);
            }
        }



    }

