import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class PermutateString
{
    public static List<String> getperms(String str)
    {
        List<String> result=new ArrayList<>();
        HashMap<Character,Integer> map=buildMap(str);
        getperms("",map,str.length(),result);
        return result;
    }

    private static void getperms(String s, HashMap<Character, Integer> map, int length, List<String> result) {
        if(length==0)
        {
            result.add(s);
            return;
        }
        for(Character c:map.keySet())
        {
            int count=map.get(c);
            if(count>0)
            {
                map.put(c,count-1);
                getperms(s+c,map,length-1,result);
                map.put(c,count);
            }
        }
    }

    private static HashMap<Character,Integer> buildMap(String str)
    {
        HashMap<Character,Integer> map=new HashMap<>();
        for(char c:str.toCharArray())
        {
            if(map.containsKey(c))
            {
                map.put(c,map.get(c)+1);
            }
            else
            {
                map.put(c, 1);
            }
        }
        return map;
    }
    public static void main(String agr[])
    {
        List<String> permutation=getperms("aaaaa");
        permutation.stream().map(x -> x + " ").forEach(System.out::println);
    }
}
