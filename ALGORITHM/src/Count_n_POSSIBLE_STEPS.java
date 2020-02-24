import java.util.Arrays;

public class Count_n_POSSIBLE_STEPS
{
    public static int countnways(int n)
    {
        int[] memo=new int[n+1];
        Arrays.fill(memo,-1);
        return countnways(n,memo);
    }
    private static int countnways(int n,int[] memo)
    {
        if(n<0)
            return 0;
        else if(n==0)
            return 1;
        else if(memo[n]>-1)
            return memo[n];
        else
            memo[n]=countnways(n-1,memo)+countnways(n-2,memo)+countnways(n-3,memo);
        return memo[n];
    }
    public static void main(String args[])
    {
        int answer=countnways(37);
        System.out.println(answer);
    }
}
