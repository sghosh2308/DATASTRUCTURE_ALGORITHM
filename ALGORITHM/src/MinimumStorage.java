import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;

public class MinimumStorage {
    public static int minimiumFilesCompress(int[] a, int[] b, int M)
    {
        int count=0;
        if(Arrays.stream(b).sum()>M)
        {
            return -1;
        }
        else
        {
            int sum=Arrays.stream(a).sum();
            ArrayList<Integer> arr=new ArrayList<>();
            for(int i=0;i<a.length;i++)
            {

                if(a[i]-b[i]>0)
                arr.add(a[i]-b[i]);
            }
            arr.sort(Comparator.reverseOrder());
            for(int i=0;i<arr.size();i++)
            {
                if(sum>M)
                {
                    sum-=arr.get(i);
                    count++;
                }
                else
                {
                    return count;
                }
            }
        }
        return -1;
    }
    public static void main(String ...agrs)throws IOException
    {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        int[] N =Arrays.stream(br.readLine().trim().split(" ")).mapToInt(Integer::parseInt).toArray();
        int[] a =Arrays.stream(br.readLine().trim().split(" ")).mapToInt(Integer::parseInt).toArray();
        int[] b =Arrays.stream(br.readLine().trim().split(" ")).mapToInt(Integer::parseInt).toArray();
        System.out.println(minimiumFilesCompress(a,b,N[1]));
    }
}
