import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class OneLineInput {
    public static void main(String ...args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[] arr;
        arr = (Arrays.stream(br.readLine().trim().split(" ")).mapToInt(Integer::parseInt).toArray());
        System.out.println("arr.toString() = " + Arrays.toString(arr));
    }
}
