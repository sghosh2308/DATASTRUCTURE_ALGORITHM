import java.util.PriorityQueue;

public class MinimizeArraytoOneElement
{
    public static int minimize(int arr[])
    {
        if(arr.length==0)
        {
            return -1;
        }
        PriorityQueue<Integer> p=new PriorityQueue<>();
        int cost=0;
        for(int x:arr)
        {
            p.add(x);
        }

        while(p.size()>1)
        {
            int first=p.poll();
            int second=p.poll();
            cost += (first + second);
            p.add(first+second);

        }
        return cost;
    }
    public static void main(String ...x)
    {
        int[] arr=new int[]{1,2,3};
        int min=minimize(arr);
        System.out.println("Minimum value "+min);
    }
}
