import java.util.Arrays;

public class LongestSubsequence
{
    public static int commonsubseuence(int arr[])
    {
        if(arr.length==0)
            return -1;
        int count[]=new int[arr.length];
        Arrays.fill(count,1);
        for(int i=1;i<arr.length;i++)
        {
            for(int j=i;j>=0;j--)
            {
                if(arr[i]>arr[j]) {

                   System.out.println(i+"     "+j);
                    count[i] = Math.max(count[i], count[j] + 1);
                }
            }
        }
        int maxcount=Integer.MIN_VALUE;
        for(int y:count)
        {
            if(maxcount<y)
                maxcount=y;
        }
        return maxcount;
    }
    public static void main(String ...a)
    {
        int arr[]=new int[]{7,6,-2,9,8,0,10,-1,15,-9};
        System.out.println(commonsubseuence(arr));
    }
}
