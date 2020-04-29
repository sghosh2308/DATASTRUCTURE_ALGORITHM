import java.util.ArrayList;

public class PermuteStringwithDistinctChar {
    public static ArrayList<String> getperms(String str) {
        if (str.length() == 0)
            return null;
        ArrayList<String> result = new ArrayList<String>();
        getperms("", str, result);
        return result;
    }

    public static void getperms(String prefix, String remainder, ArrayList<String> result)
    {
        if(remainder.length()==0) {
            result.add(prefix);
            //System.out.println("Remainder Length   "+prefix);
        }
        int len=remainder.length();
        for(int i=0;i<len;i++)
        {
            String pre=remainder.substring(0,i);
            String suf=remainder.substring(i+1,len);
            //System.out.println("pre "+pre+" suf  "+suf+"  prefix "+prefix);
            char c=remainder.charAt(i);
            getperms(prefix+c,pre+suf,result);
        }
    }
    public static void main(String args[])
    {
        ArrayList<String> result=getperms("abc");
        result.stream().map(x->x+" ").forEach(System.out::print);

    }
}
