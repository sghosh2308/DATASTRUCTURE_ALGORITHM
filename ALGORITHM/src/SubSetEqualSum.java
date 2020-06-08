import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class SubSetEqualSum
{   public static boolean findsubset(int start,int[] arr,boolean[] seen,int process_sum,int targetsum,int k)
    {
        if(k==1)
        {
            return true;
        }
        if(process_sum==targetsum)
        {
            return findsubset(0,arr,seen,0,targetsum,k-1);
        }
        for(int i=start;i<arr.length;i++)
        {
            if(!seen[i])
            {
                seen[i]=true;
                if(findsubset(i+1,arr,seen,process_sum+arr[i],targetsum,k))
                {
                    //System.out.println("ith Index "+i+" Process Sum "+process_sum);
                    return true;
                }
                seen[i]=false;
            }
        }
        return false;
    }
    public static void ifpossible(int[] arr,int k)
    {
        int sum=0;
        for(int x:arr)
        {
            sum+=x;
        }
        if(k!=0 && sum%k==0)
        {
            if(findsubset(0,arr,new boolean[arr.length],0,sum/k,k))
            {
                System.out.println("Partitioning Possible");
            }
            else
                {
                    System.out.println("Partitioning isn't possible");
                }
        }
        else
            {
                System.out.println("Partitioning isn't possible");
            }
    }
    public static void main(String[] args)throws IOException
    {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        int[] arr= Arrays.stream(br.readLine().trim().split(" ")).mapToInt(Integer::parseInt).toArray();
        int k=Integer.parseInt(br.readLine());
        ifpossible(arr,k);
    }
}
