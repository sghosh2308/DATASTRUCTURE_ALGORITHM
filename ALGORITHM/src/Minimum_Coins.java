import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Minimum_Coins
{
    public static void main(String ...args)throws IOException
    {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        int values[]= Arrays.stream(br.readLine().trim().split(" ")).mapToInt(Integer::parseInt).toArray();
        int sum=Integer.parseInt(br.readLine());
        int[] count=new int[sum+1];
        Arrays.fill(count,Integer.MAX_VALUE);
        count[0]=0;
        for(int i=1;i<=sum;i++)
        {
            for(int j=0;j<values.length;j++)
            {
                if(values[j]<=i && count[i-values[j]]+1<count[i])
                {
                    count[i]=count[i-values[j]]+1;
                }
            }

        }
        System.out.println(Arrays.toString(count));
    }
}
