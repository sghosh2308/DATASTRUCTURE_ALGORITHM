import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Periodicity
{
    private static void compressString(String s)
    {
        int[] z=StringAlgorithms.z_algorithm(s);
        for(int i=0;i<z.length;i++)
        {
            if(i+z[i]==s.length())
            {
                System.out.println(s.substring(0,i).length());
                break;
            }
        }
    }
    public static void main(String args[])throws IOException
    {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        String s=br.readLine();
        compressString(s);
    }
}
