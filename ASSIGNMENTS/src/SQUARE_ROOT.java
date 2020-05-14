import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.text.DecimalFormat;

/*   Algorithm for finding square root
        1. Set r to the mean of 1 and a.
        2. While r^2 is not a good enough approximation to a, repeat:
        3.1. Set r to the mean of r and a/r.
        4. Terminate with answer r.
*/
public class SQUARE_ROOT {
    public static void main(String args[])throws IOException{
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        System.out.println("ENTER THE NUMBER TO CALCULATE NUMBER");
        final float approx= (float) 10e-7;
        float array[]=new float[]{256};

        for(float a:array) {
            float root = (a + 1) / 2;
            int counter = 0;

            while ((root * root - a) > approx) {
                root = (root + (a / root)) / 2;
                counter++;
            }

            System.out.println("THE ROOT IS " + (new DecimalFormat("#.00").format(root)) + " THE LOOP RUN FOR " + counter);
        }






    }
}
