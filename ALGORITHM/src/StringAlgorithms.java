public class StringAlgorithms
{
    public static int[] manachers(String s)
    {
        char[] preprocessed_string=new char[2*s.length()+3];
        int[] palindrome=new int[preprocessed_string.length];
        preprocessed_string[0]='$';
        preprocessed_string[1]='|';
        preprocessed_string[preprocessed_string.length-1]='@';
        int target=2;
        for(char c:s.toCharArray())
        {
            preprocessed_string[target++]=c;
            preprocessed_string[target++]='|';
        }
        for(int i = 1, centre = 0, right = 0, mirror_image; i<preprocessed_string.length-1; i++)
        {
            mirror_image=2*centre-i;
            if(right>i)
            {
                palindrome[i]=Math.min(right-i,palindrome[mirror_image]);
            }
            while(preprocessed_string[i+(1+palindrome[i])]==preprocessed_string[i-(1+palindrome[i])])
            {
                palindrome[i]++;
               // System.out.println(Arrays.toString(palindrome)+"   COUNT WHILE "+i);
            }
            if(i>right)
            {
                centre=i;
                right=i+palindrome[i];
            }
            //System.out.println(Arrays.toString(palindrome)+"   COUNT "+i);
        }
       // System.out.println(Arrays.toString(palindrome));
        return palindrome;
    }
    public static int[] z_algorithm(String s)
    {
        int[] z=new int[s.length()];
        for(int i=1,l=0,r=0;i<s.length();i++)
        {
            if(r>=i)
            {
                z[i]=Math.min(r-i+1,z[i-l]);
            }
            while(i+z[i]<s.length() && s.charAt(z[i])==s.charAt(i+z[i]))
            {
                ++z[i];
         //       System.out.println(Arrays.toString(z)+"   COUNT WHILE LOOP "+i);
            }
            if(i+z[i]-1>r)
            {
                l=i;
                r = (i + z[i]) - 1;
            }
           // System.out.println(Arrays.toString(z)+"   COUNT"+i);
        }
        //System.out.println(Arrays.toString(z));
        return z;
    }
    public static void main(String[] args)
    {
        manachers("aaaa");
        z_algorithm("aaaa");
    }
}
