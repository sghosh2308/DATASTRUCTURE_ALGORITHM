/* Changing a Binary tree into BST with changing the structure of the tree*/

import java.util.ArrayList;
import java.util.Collections;
public class ConBinaryToBst
{   static int count=0;
    private void inorderTraversal(Treenode root)
    {
        if(root==null)
        {
            return;
        }
        inorderTraversal(root.left);
        System.out.print(root.val+"   ");
        inorderTraversal(root.right);
    }
    private void generateArray(Treenode root,ArrayList<Integer> value)
    {
        if(root==null)
        {
            return;
        }
        generateArray(root.left,value);
        value.add(root.val);
        generateArray(root.right,value);
    }
    public void transform(Treenode root,ArrayList<Integer> value)
    {
        if(root==null)
            return;
        transform(root.left,value);
        root.val=value.get(count++);
        transform(root.right,value);
    }
    public  Treenode convert(Treenode root)
    {
        ArrayList<Integer> value_stream=new ArrayList<Integer>();
        generateArray(root,value_stream);
        Collections.sort(value_stream);
        transform(root,value_stream);
        return root;
    }
    public static void main(String ...arg)
    {
        Treenode root=new Treenode(1);
        root.left=new Treenode(2);
        root.left.left=new Treenode(4);
        root.right=new Treenode(3);
        root.right.right=new Treenode(5);
        ConBinaryToBst c=new ConBinaryToBst();
        c.inorderTraversal(root);
        System.out.println(" ");
        root=c.convert(root);
        c.inorderTraversal(root);
    }

}
