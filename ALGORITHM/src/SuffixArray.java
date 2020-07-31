import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class SuffixArray
{
    static class Pair<FIRST,SECOND>
    {
        FIRST first;
        SECOND second;
        Pair(FIRST first,SECOND second)
        {
            this.first=first;
            this.second=second;
        }

        @Override
        public String toString() {
            return "Pair{" +
                    "first=" + first +
                    ", second=" + second +
                    '}';
        }
    }
    public static void main(String[] args)
    {
        Scanner sc=new Scanner(System.in);
        String s=sc.nextLine();
        s+="$";
        int n=s.length();

        int[] p=new int[n];
        int[] c=new int[n];

        {
            ArrayList<Pair<Character,Integer>> a=new ArrayList<>(n);
            for(int i=0;i<n;i++)
            {
                a.add(new Pair<>(s.charAt(i), i));
            }

            a.sort((x, y) -> (x.first >= y.first) ? 1 : -1);

            for(int i=0;i<n;i++)
            {
                p[i]=a.get(i).second;
            }

            c[p[0]]=0;

            for(int i=1;i<n;i++)
            {
                c[p[i]]=(a.get(i).first==a.get(i-1).first)?c[p[i-1]]:c[p[i-1]]+1;
            }

        }
        int k=0;
        while((1<<k)<n)
        {
            List<Pair<Pair<Integer,Integer>,Integer>> b= new ArrayList<>(n);
            for (int i=0;i<n;i++)
            {
                b.add(i, new Pair<>(new Pair<>(c[i], c[(i + (1 << k)) % n]), i));
            }
            b.sort((x1, y1) -> (x1.first.first > y1.first.first ? 1 : ((x1.first.first.equals(y1.first.first)) && (x1.first.second > y1.first.second)) ? 1 : -1));
            for(int i=0;i<n;i++)
            {
                p[i]=b.get(i).second;
            }

            c[p[0]]=0;
            for(int i=1;i<n;i++)
            {
                c[p[i]]=(b.get(i).first.first.equals(b.get(i - 1).first.first) && b.get(i).first.second.equals(b.get(i - 1).first.second))?c[p[i-1]]:c[p[i-1]]+1;
            }
            k++;
        }
        for(int i=0;i<n;i++)
        {
            System.out.println(p[i]+" "+s.substring(p[i]));
        }

    }

}
