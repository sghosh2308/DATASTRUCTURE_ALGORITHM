import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class ZigZagSequence
{
    public static void main(String ...args)throws IOException
    {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        int values[]= Arrays.stream(br.readLine().trim().split(" ")).mapToInt(Integer::parseInt).toArray();
        if(values.length<2)
        {
            System.out.println(values.length);
        }
        int preffdiv=values[1]-values[0];
        int count=preffdiv!=0?2:0;
        for(int i=2;i<values.length;i++)
        {
            int diff=values[i]-values[i-1];
            if((diff>0 && preffdiv<=0)||(diff<0 && preffdiv>=0))
            {
                count++;
                preffdiv=diff;
            }
        }
        System.out.println(count);
    }
}
