import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;

public class Sliding_window_maximum
{
    public static void main(String ...args)throws IOException
    {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        int[] array = Arrays.stream(br.readLine().trim().split(" ")).mapToInt(Integer::parseInt).toArray();
        int b= Integer.parseInt(br.readLine());
        if(b>array.length)
        {
            int max=Integer.MIN_VALUE;
            for(int i:array)
            {
                if(max<i)
                {
                    max=i;
                }
            }
            System.out.println(max);
        }
        else
        {
            PriorityQueue<Integer> pq=new PriorityQueue<>((a,c)->c>a?1:-1);
            List<Integer> result=new ArrayList<>();
            for(int i=0;i<array.length;i++)
            {
                pq.add(array[i]);
                if((i+1)%b==0)
                {
                    result.add(pq.peek());
                }

            }

        }
    }
}
