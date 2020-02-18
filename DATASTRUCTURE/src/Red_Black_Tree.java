class Node {

    int data;
    Node left;
    Node right;
    int color;

     Node(int data) {
        this(data, null, null);
    }

     Node(int data, Node left, Node right) {
        this.data = data;
        this.left = left;
        this.right = right;
        this.color = 1;
    }

}

public class Red_Black_Tree {
    private Node current, parent, grand, great, header;
    private static Node nullnode;
    final int red=0,black=1;
    static{
        nullnode=new Node(0);
        nullnode.right=nullnode;
        nullnode.left=nullnode;
    }

       /*Forms the actual note of the tree*/

    Red_Black_Tree(){
        header = new Node(Integer.MIN_VALUE);
        header.left = nullnode;
        header.right = nullnode;

    }

    public void insert(int data){
        this.current=this.parent=this.grand=this.great=this.header;
        nullnode.data=data;
        while(current.data!=data) {
            great = grand;
            grand=parent;
            parent = current;
            current = data < current.data ? current.left : current.right;
            if (current.left.color == red && current.right.color == red) {
                this.reorient(data);
            }
        }
        if(current!=nullnode)
            return;
        current=new Node(data,nullnode,nullnode);
        if(data<parent.data)
        {
            parent.left=current;
        }
        else
        {
            parent.right=current;
        }

        this.reorient(data);
        }

        private void reorient(int data)
        {
            current.color=red;
            current.left.color=black;
            current.right.color=black;
            if(parent.color==red)
            {
                grand.color=red;
                if(data<grand.data!=data<parent.data)
                {
                    parent=rotate(data,grand);

                }
                current=rotate(data,great);
                current.color=black;


            }
            header.right.color=black;
        }

        private Node rotate(int data,Node parent)
        {
            if(data<parent.data){
                return parent.left=data<parent.left.data?rotateleft(parent.left):rotateright(parent.left);
            }
            else
            {
                return parent.right=data<parent.right.data?rotateleft(parent.right):rotateright(parent.right);
            }
        }
        private Node rotateright(Node flag)
        {
            Node n_flag=flag.right;
            flag.right=n_flag.left;
            n_flag.left=flag;
            return n_flag;
        }
        private Node rotateleft(Node flag)
        {
            Node n_flag=flag.left;
            flag.left=n_flag.right;
            n_flag.right=flag;
            return n_flag;
        }
    public void inorder()

    {

        inorder(header.right);
        System.out.println();
    }

    private void inorder(Node r)
    {
        if (r != nullnode)

        {
            inorder(r.left);
            char c = 'B';
            if (r.color == 0)
                c = 'R';
            System.out.print(r.data +""+c+" ");
            inorder(r.right);

        }

    }

    public boolean search(int data){
        return search(header.right,data);
    }
    private boolean search(Node r,int data)
    {   boolean found=false;
        while (r!=nullnode && !found) {
            int rval=r.data;
            if(data< rval)
            {
                r=r.left;
            }
            else if(data>rval)
            {
                r=r.right;
            }
            else
            {
                found=true;
                break;
            }


        }

    return found;
    }
    public static void main(String ...args)
    {
        Red_Black_Tree rb=new Red_Black_Tree();
        rb.insert(3);rb.inorder();
        rb.insert(100);rb.inorder();
        rb.insert(4);rb.inorder();
        rb.insert(-1);rb.inorder();
        rb.insert(50);rb.inorder();
        rb.insert(40);rb.inorder();
        rb.insert(34);rb.inorder();
        System.out.println(rb.search(22));


    }
    }

