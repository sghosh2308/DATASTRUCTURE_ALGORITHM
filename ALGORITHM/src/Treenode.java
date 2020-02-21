public class Treenode
{
    int val;
    Treenode left;
    Treenode right;
    Treenode parent;
    Treenode(int val,Treenode parent)
    {
        this.val=val;
        this.left=null;
        this.right=null;
        this.parent=parent;
    }
    Treenode(int val)
    {
        this(val,null);
    }
}
