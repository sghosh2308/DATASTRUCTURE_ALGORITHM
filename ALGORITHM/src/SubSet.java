public class SubSet
{
    public static boolean subsetsum(int[] arr, int target)
    {
        boolean[][] table=new boolean[target+1][arr.length+1];

        for(int i=0;i<=arr.length;i++)
        {
            table[0][i]=true;
        }

        for(int i=1;i<=target;i++)
        {
            table[i][0]=false;
        }

        for(int i=1;i<=target;i++)
        {
            for(int j=1;j<=arr.length;j++)
            {
                table[i][j]=table[i][j-1];
                if(i>=arr[j-1])
                {
                    table[i][j]=table[i][j]||table[i-arr[j-1]][j];
                }
            }
            
        }
        return table[target][arr.length];
    }
    public static void main(String args[])
    {

        //CAll the function
        System.out.println(subsetsum(new int[]{3, 34, 4, 12, 5, 2},9));
    }

}

