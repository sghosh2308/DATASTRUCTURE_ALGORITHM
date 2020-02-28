import java.util.ArrayList;

public class SUMBRUTEFORCE
{
    public static ArrayList<ArrayList<Integer>> docheck(int arr[],int target)
    {
        if(arr.length==0)
            return null;
        int sum=0;
        ArrayList<ArrayList<Integer>> result=new ArrayList<ArrayList<Integer>>();
        for(int i=0;i<Math.pow(2,arr.length);i++)
        {  ArrayList<Integer> partial_result=new ArrayList<Integer>();
            sum=0;
            for(int j=0;j<arr.length;j++)
            {
                if(((1 << j) & i) > 0)
                {
                    sum+=arr[j];
                    partial_result.add(arr[j]);
                }
            }
            if(sum==target)
            {
                result.add(partial_result);
            }

        }
        return result;
    }
    public static void main(String args[])
    {
        int arr[]=new int[]{1,2,3,4,5};
        ArrayList<ArrayList<Integer>> result= docheck(arr,5);
        if(result==null)
        {
            System.out.println("Target cannot be achieved");
        }
        for(ArrayList<Integer> a:result)
        {
            for(int x:a)
            {
                System.out.print(x+" ");
            }
            System.out.println("");
        }
    }
}
