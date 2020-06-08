import java.util.LinkedList;
import java.util.Queue;

public class BinarySearchTree {
    Node root;

    class Node {
        int data;
        Node left;
        Node right;

        Node(int data) {
            this.data = data;
            this.left = null;
            this.right = null;
        }

    }

    private Node addNode(Node current, int data) {
        if (current == null)
            return new Node(data);

        if (data > current.data) {
            current.right = addNode(current.right, data);
        } else if (data < current.data) {
            current.left = addNode(current.left, data);
        } else {
            return current;
        }
        return current;
    }
    /*This is the function that add nodes to the binary search tree*/


    public void insert(int... data) {
        for (int x : data) {
            this.root = addNode(this.root, x);
        }
    }

    /*This method is called by the Display as i am using a recursion based algorithm so i need to call
     * and return the value which i didn't want the user how i am doing so i mentioned it as private*/
    /*This Function print the node of tree in LDR way*/

    public void display() {
        System.out.println("THIS IS INORDER");
        inorder(this.root);
        System.out.println("\nTHIS IS PREORDER");
        preorder(this.root);
        System.out.println("\nTHIS IS POSTORDER");
        postorder(this.root);
        System.out.println("\n THIS IS LEVEL ORDER TRAVERSAL");
        levelordertraversal(this.root);
        System.out.println("\b\b");
    }


    private int FindMin(Node current) {
        if (current.left == null) {
            return current.data;
        }
        return FindMin(current.left);
    }

    private Node deletenode(Node current, int data) {
        if (current == null) {
            return current;
        } else if (data < current.data) {
            current.left = deletenode(current.left, data);
        } else if (data > current.data) {
            current.right = deletenode(current.right, data);
        } else {
            if (current.left == null && current.right == null) {
                return null;
            } else if (current.left == null) {
                return current.right;
            } else if (current.right == null) {
                return current.left;
            } else {
                Node minimum = new Node(FindMin(current.right));
                current.data = minimum.data;
                current.right = deletenode(current.right, minimum.data);
            }

        }

        return current;
    }

    //Deletion Function which accept the data that need to be removed. It uses the same recursive concept
    //with replacing from the right in condition where the deletion node contains two child.

    public void delete(int... data) {
        for (int x : data) {
            this.root = deletenode(this.root, x);
        }
    }

    private Node postorder(Node current) {
        if (current == null) {
            return null;
        } else {
            postorder(current.left);
            postorder(current.right);
            System.out.print(current.data + ", ");
        }
        return null;
    }

    private Node preorder(Node current) {
        if (current == null) {
            return null;
        } else {
            System.out.print(current.data + ", ");
            preorder(current.left);
            preorder(current.right);
        }
        return null;
    }

    private Node inorder(Node current) {
        if (current == null) {
            return null;
        } else {

            inorder(current.left);
            System.out.print(current.data + ", ");
            inorder(current.right);
        }
        return null;
    }
    private void levelordertraversal(Node current){
        Queue<Node> q=new LinkedList<>();
        q.add(current);
        while(!q.isEmpty()){
            Node n=q.poll();
            System.out.print(n.data+", ");
            if(n.left!=null){
                q.add(n.left);
            }
            if(n.right!=null){
                q.add(n.right);
            }
        }
    }



    public static void main(String args[]) {
        BinarySearchTree b = new BinarySearchTree();
        b.insert(new int[]{23, 45, 1, 26, 89, 70, 36, 78, 98, 22, 19, 3, 100, 120, 34});
        b.display();

    }
}

  