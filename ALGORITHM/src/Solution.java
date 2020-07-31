import java.util.ArrayList;
import java.util.Scanner;

public class Solution {
        public static void main(String[] args) throws Exception {
            /* Enter your code here. Read input from STDIN. Print output to STDOUT */
            Scanner sc=new Scanner(System.in);
            int t=sc.nextInt();

            int operation=sc.nextInt();
            int index=sc.nextInt();
            ArrayList<Integer> array=new ArrayList<Integer>();
             for(int i=0;i<t;i++)
             {
                 array.add(sc.nextInt());
             }
            while(operation>0)
            {
                for(int i=0;i<array.size()-1;i+=1)
                {
                    int res=array.get(i)^array.get(i+1);
                    array.remove(i);
                    array.add(i,res);

                }
                array.remove(array.size()-1);
                System.out.println(array.toString());
                operation--;
            }
            System.out.println(array.get(index));
        }
    }

