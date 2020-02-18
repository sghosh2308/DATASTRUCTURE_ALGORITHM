//Converting a sorted array into BST with least Height
public class BSTfromSortedArray {
    static class Node
    {
        int val;
        Node right;
        Node left;
        Node(int val)
        {   this.val=val;
            this.right=null;
            this.left=null;
        }
    }
    public static void inorderTraversal(Node root)
    {   if(root==null)
            return;
        inorderTraversal(root.left);
        System.out.print(root.val);
        inorderTraversal(root.right);
    }
    public static Node createBST(int[] arr)
    {
            return createMinimalBST(arr, 0 , arr.length -1);
    }
    private static Node createMinimalBST(int arr[],int start,int end)
    {
        if(end<start)
        {
            return null;
        }
        int mid=(start+end)/2;
        Node n=new Node(arr[mid]);
        n.right=createMinimalBST(arr,mid+1,end);
        n.left=createMinimalBST(arr,start,mid-1);
        return n;
    }
    public static void main(String ...x)
    {
        int[] arr={1,2,3,4,5,6,7};
        Node root=createBST(arr);
        inorderTraversal(root);
    }


}
