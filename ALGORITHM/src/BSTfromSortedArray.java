//Converting a sorted array into BST with least Height
public class BSTfromSortedArray {
    public static Treenode createBST(int[] arr)
    {
            return createMinimalBST(arr, 0 , arr.length -1);
    }
    private static Treenode createMinimalBST(int arr[],int start,int end)
    {
        if(end<start)
        {
            return null;
        }
        int mid=(start+end)/2;
        Treenode n=new Treenode(arr[mid]);
        n.right=createMinimalBST(arr,mid+1,end);
        n.left=createMinimalBST(arr,start,mid-1);
        return n;
    }
    public static void main(String ...x)
    {
        int[] arr={1,2,3,4,5,6,7};
        Treenode root=createBST(arr);
        KthElementBST k=new KthElementBST();
        k.kthSmallestBST(root,3);
        k.kthLargestBST(root,1);
        VerticalTraversalBST vt=new VerticalTraversalBST();
        vt.traverseVertically(root);
    }
}
