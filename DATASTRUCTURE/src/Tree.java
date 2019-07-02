public class Tree {
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
    public void insert(int data){
        Node generate_node=new Node(data);
        if(this.root==null){
            this.root=generate_node;
        }
        else{

        }

    }


}
