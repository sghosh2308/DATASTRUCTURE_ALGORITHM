public class KthElementBST {
    Integer count=0;
    public void kthSmallestBST(Treenode root,int k)
    {
        if(root==null)
            return;
        kthSmallestBST(root.left,k);
        count++;
        if(k==count)
        {
            System.out.println(root.val);
            return;
        }

        kthSmallestBST(root.right,k);
    }
    Integer count1=0;
    public void kthLargestBST(Treenode root,int k)
    {
        if(root==null)
            return;
        kthLargestBST(root.right,k);
        count1++;
        if(k==count1)
        {
            System.out.println(root.val);
        }
        kthLargestBST(root.left,k);
    }
}
