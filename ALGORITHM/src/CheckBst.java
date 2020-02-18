public class CheckBst
{
    Integer Last=null;
    boolean checkBST(Treenode root)
    {
        if(root==null)
            return true;
        if(!checkBST(root.left))
            return false;
        if(Last!=null && root.val<=Last)
            return false;
        Last=root.val;
        if(!checkBST(root.right))
            return false;
        return true;
    }
}
