public class BinarySearchTree {
    Node root;
    class Node{
        int data;
        Node left;
        Node right;
        Node(int data){
            this.data=data;
            this.left=null;
            this.right=null;
        }

    }

    private Node addNode(Node current,int data){
        if(current==null)
            return new Node(data);

        if(data>current.data){
         current.right=addNode(current.right,data) ;
        }
        else if(data<current.data){
            current.left=addNode(current.left,data);
        }
        else{
            return current;
        }
        return current;
    }
    /*This is the function that add nodes to the binary search tree*/
    public void insert(int data){
        this.root=addNode(this.root,data);
    }
    private Node print(Node current) {
        if (current == null) {
            return null;
        } else {

            print(current.left);
            System.out.print(current.data+", ");
            print(current.right);
        }
        return null;
    }
    /*This Function print the node of tree in LDR way*/
    public void display(){
        print(this.root);
        System.out.println("\b\b");
    }

    public static void main(String args[]){
        BinarySearchTree b=new BinarySearchTree();
        b.insert(2);
        b.insert(3);
        b.insert(1);
        b.display();
    }
}
