public class Longtest_string {
        public static int longestPalindrome(String s) {
            int global=Integer.MIN_VALUE;
            for(int i=0;i<s.length();i++)
            {
                int index1=expand(s,i,i);
                int index2=expand(s,i,i+1);
                int index=Math.max(index1,index2);
                if(global<index)
                {
                    global=index;
                }
            }
            return global;
        }

        public static int expand(String s,int left,int right)
        {
            while(left>=0 && right<s.length() && s.charAt(left)==s.charAt(right))
            {
                left--;
                right++;
            }
            return right-left-1;
        }
        public static void main(String ...args)
        {
            String s=new String("abab");
            System.out.println(longestPalindrome(s));
        }
    }
