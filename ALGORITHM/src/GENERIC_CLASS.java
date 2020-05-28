import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class GENERIC_CLASS {
    static <T> void genericDisplay (T element)
    {
        System.out.println(element.getClass().getName() +
                " = " + element);
    }

    static<T> void getList(List<T> element)
    {
        System.out.println(element.get(0).getClass().getName());
    }
    public static void main(String[] args)
    {
        // Calling generic method with Integer argument
        genericDisplay(11);

        // Calling generic method with String argument
        genericDisplay("CHIRAG");

        // Calling generic method with double argument
        genericDisplay(1.0);

        List<String> s=new ArrayList<>(Arrays.asList("Hello","HI"));
        getList(s);
        List<Integer> i=new ArrayList<>(Arrays.asList(1,2));
        getList(i);
    }
}
