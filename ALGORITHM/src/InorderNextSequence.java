//Print the next val in any inorder traversal for a given current val
public class InorderNextSequence
{
    private Treenode inorderNext(Treenode root)
    {
        if(root==null)
        {
            return null;
        }
        if(root.right!=null)
        {
            returnleftChild(root.right);
        }
        else
        {
            Treenode current=root;
            Treenode ances=current.parent;
            while(ances!=null && ances.left!=current)
            {
                current=ances;
                ances=ances.parent;
            }
            return ances;
        }
        return null;
    }
    private Treenode returnleftChild(Treenode root)
    {
        if(root==null)
        {
            return null;
        }
        while(root.left!=null)
        {
            root=root.left;
        }
        return root;
    }
}
