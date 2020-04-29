public class MagicIndex
{
    static int magicFast(int[] arr)
    {
        return magicFast(arr,0,arr.length-1);
    }
    static int magicFast(int[] arr, int startIndex, int endIndex)
    {
        if(endIndex < startIndex)
            return -1;
        int midIndex=(startIndex+endIndex)/2;
        int midVal=arr[midIndex];
        if(midVal==midIndex)
            return midIndex;
        int leftIndex=Math.min(midIndex-1,midVal);
        int left=magicFast(arr,startIndex,leftIndex);
        if(left>=0)
            return left;
        int rightIndex=Math.max(midIndex+1,midVal);
        int right=magicFast(arr,rightIndex,endIndex);
        return right;
    }
    public static void main(String args[])
    {
        int[] arr=new int[]{-10,-5,2,2,2,3,4,7,9,12,13};
        System.out.println(magicFast(arr));
    }
}
