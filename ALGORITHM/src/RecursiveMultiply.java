public class RecursiveMultiply
{
    static int midProduct(int a, int b)
    {
        int bigger=a>b?a:b;
        int smaller=a>b?b:a;
        return midProducthelper(smaller,bigger);
    }
    static int midProducthelper(int smaller,int bigger)
    {
        if(smaller==0)
            return 0;
        else if(smaller==1)
            return bigger;
        int s=smaller>>1;
        int halfproduct=midProducthelper(s,bigger);
        if((smaller%2)==0)
        {
            return halfproduct+halfproduct;
        }
        else
            return halfproduct+halfproduct+bigger;
    }
    public static void main(String args[])
    {
        System.out.println(midProduct(2,4));
    }
}
