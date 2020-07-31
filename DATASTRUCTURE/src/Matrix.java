import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class Matrix {

    public static int[] returnprime(int n)
    {
        int[] prime =new int[n];
        prime[0]=2;
        int i=3,c,index=1;
        for(int count=2;count<=n;i++)
        {
            for(c=2;c<i;c++)
            {
                if(i%c == 0)
                    break;
            }
            if(c==i)
            {
                prime[index]=i;
                index++;
                count++;
            }
        }
        return prime;
    }
    public static int[] generatesequence(int n)
    {
        int[] sequence =new int[n];
        sequence[0]=3;
        sequence[1]=4;
        for(int i=2;i<n;i++)
        {
            sequence[i]=sequence[i-1]+sequence[i-2]-1;
        }
        return sequence;
    }
//    public static boolean uniquedigit(int n)
//    {
//        String s=String.valueOf(n);
//        int checker=0;
//        for(int i=0;i<s.length();i++)
//        {
//            int bitAtIndex=s.charAt(i)-47;
//
//            if ((checker & (1 << bitAtIndex)) > 0)
//                return false;
//
//            checker = checker | (1 << bitAtIndex);
//        }
//        return true;
//    }

    public static void main(String[] args)throws IOException
    {
     BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
     int n=Integer.parseInt(br.readLine());
     int[][] matrix=new int[n][n];
     matrix[0][0]=1;
     int[] prime =returnprime(n);
     int[] sequence =generatesequence(n);
     for(int i=1;i<n;i++)
     {
         matrix[i][0]=matrix[i-1][0]+prime[i-1];
     }
//        for(int i=0;i<n;i++)
//        {
//            for(int j=0;j<n;j++)
//            {
//                System.out.print(matrix[i][j]+" ");
//            }
//            System.out.println();
//        }
     for(int i=0;i<n;i++)
     {
         for(int j=1;j<n;j++)
         {
             matrix[i][j]=matrix[i][j-1]+sequence[j-1];
         }
     }
//     for(int i=0;i<n;i++)
//     {
//         for(int j=0;j<n;j++)
//         {
//             System.out.print(matrix[i][j]+" ");
//         }
//         System.out.println();
//     }
      ArrayList<Integer> list=new ArrayList<>();
     for(int i=0;i<n;i++)
     {
         for(int j=0;j<n;j++)
         {
           if(i==0 || i==n-1 || Math.abs(i-j)==0 || i+j==20)
           {
               list.add(matrix[i][j]);
           }
         }
     }
        Collections.sort(list, Collections.reverseOrder());
     System.out.println(Arrays.asList(list));



    }



}