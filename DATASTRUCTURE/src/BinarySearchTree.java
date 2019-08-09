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

    private Node print(Node current) {
        if (current == null) {
            return null;
        } else {

            print(current.left);
            System.out.print(current.data + ", ");
            print(current.right);
        }
        return null;
    }

    /*This Function print the node of tree in LDR way*/

    public void display() {
        print(this.root);
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

}

