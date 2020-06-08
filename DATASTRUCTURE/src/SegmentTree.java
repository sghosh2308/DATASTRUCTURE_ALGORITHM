import java.util.Arrays;
import java.util.List;

public class SegmentTree<T extends Number>
{
    int length;
    List<T> Maxarray;
    List<T> Minarray;
    List<T> Sumarray;
     SegmentTree(T[] arr)
    {

        this.length=2*arr.length-1;
        Maxarray= create(length);
        max_build(arr,0,0,arr.length-1);
        Minarray= create(length);
        min_build(arr,0,0,arr.length-1);
        Sumarray= create(length);
        sum_build(arr,0,0,arr.length-1);
    }
    @SuppressWarnings("unchecked")
    private  <T>List<T> create(int size) {
        return (List<T>)Arrays.asList(new Object[size]);
    }
////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//////////////////////////////////////////////////SUM QUERY/////////////////////////////////////////////////////////////
////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
private T add(T t, T t1)
{
    /*If one of them has value don't return null*/
    if (t == null || t1 == null) {
        if(t !=null)
            return t;
        if(t1 !=null)
            return t1;
        return null;

    }
    if (t instanceof Double) {
        return (T) new Double(t.doubleValue() + t1.doubleValue());
    } else if (t instanceof Integer) {
        return (T)new Integer(t.intValue() + t1.intValue());
    } else {
        throw new IllegalArgumentException("Type " + t.getClass() + " is not supported by Segement Tree Operation");
    }
}
private void sum_build(T[] arr,int v,int tl,int tr)
{
        if(tl==tr)
        {
            Sumarray.set(v,arr[tl]);
        }
        else
        {
            int tm=(tl+tr)/2;
            sum_build(arr,v+1,tl,tm);
            sum_build(arr,v+2*(tm-tl+1),tm+1,tr);
            Sumarray.set(v,add(Sumarray.get(v+1),Sumarray.get(v+2*(tm-tl+1))));
        }
    }
private T rangesum(int v,int l,int r,int tl,int tr)
    {
        if(l>r)
            return null;
        if(tl==l && tr==r)
        {
            return Sumarray.get(v);
        }
        int tm=(tl+tr)/2;
        return add(rangesum(v+1,l,Math.min(r,tm),tl,tm),rangesum(v+2*(tm-tl+1),Math.max(l, tm+1),r,tm+1,tr));
    }
public T sumQuery(int l,int r)
    {
        return rangesum(0,l,r,0,(length-1)/2);
    }
////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//////////////////////////////////////////////////MAX QUERY/////////////////////////////////////////////////////////////
////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
private T max(T t, T t1)
{
    /*If one of them has value don't return null*/
    if (t == null || t1 == null) {
        if(t !=null)
            return t;
        if(t1 !=null)
            return t1;
        return null;

    }
    if (t instanceof Double) {
        return (T) new Double(Math.max(t.doubleValue() , t1.doubleValue()));
    } else if (t instanceof Integer) {
        return (T)new Integer(Math.max(t.intValue() , t1.intValue()));
    } else {
        throw new IllegalArgumentException("Type " + t.getClass() + " is not supported by Segement Tree Operation");
    }
}
private void max_build(T[] arr,int v,int tl,int tr)
{
        if(tl==tr)
        {
            Maxarray.set(v,arr[tl]);
        }
        else
        {
            int tm=(tl+tr)/2;
            max_build(arr,v+1,tl,tm);
            max_build(arr,v+2*(tm-tl+1),tm+1,tr);
            Maxarray.set(v,max(Maxarray.get(v+1),Maxarray.get(v+2*(tm-tl+1))));
        }
    }
private T rangemax(int v,int l,int r,int tl,int tr)
    {
        if(l>r)
            return null;
        if(tl==l && tr==r)
        {
            return Maxarray.get(v);
        }
        int tm=(tl+tr)/2;
        return max(rangemax(v+1,l,Math.min(r,tm),tl,tm),rangemax(v+2*(tm-tl+1),Math.max(l, tm+1),r,tm+1,tr));
    }
    public T maxQuery(int l,int r)
    {
        return rangemax(0,l,r,0,(length-1)/2);
    }
////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//////////////////////////////////////////////////MIN QUERY/////////////////////////////////////////////////////////////
////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
private T min(T t, T t1)
{
        /*If one of them has value don't return null*/
        if (t == null || t1 == null) {
            if(t !=null)
                return t;
            if(t1 !=null)
                return t1;
            return null;

        }
        if (t instanceof Double) {
            return (T) new Double(Math.min(t.doubleValue() , t1.doubleValue()));
        } else if (t instanceof Integer) {
            return (T)new Integer(Math.min(t.intValue() , t1.intValue()));
        } else {
            throw new IllegalArgumentException("Type " + t.getClass() + " is not supported by Segement Tree Operation");
        }
    }
private void min_build(T[] arr,int v,int tl,int tr)
{
        if(tl==tr)
        {
        Minarray.set(v,arr[tl]);
        }
        else
        {
        int tm=(tl+tr)/2;
        min_build(arr,v+1,tl,tm);
        min_build(arr,v+2*(tm-tl+1),tm+1,tr);
        Minarray.set(v,min(Minarray.get(v+1),Minarray.get(v+2*(tm-tl+1))));
        }
}
    private T rangemin(int v,int l,int r,int tl,int tr)
    {
        if(l>r)
            return null;
        if(tl==l && tr==r)
        {
            return Minarray.get(v);
        }
        int tm=(tl+tr)/2;
        return min(rangemin(v+1,l,Math.min(r,tm),tl,tm),rangemin(v+2*(tm-tl+1),Math.max(l, tm+1),r,tm+1,tr));
    }
    public T minQuery(int l,int r)
    {
        return rangemin(0,l,r,0,(length-1)/2);
    }



    public static void main(String args[])
    {
        SegmentTree<Double> st=new SegmentTree<Double>(new Double[]{1.0,2.5,3.0});
        System.out.println(st.Maxarray.toString());
        System.out.println(st.Minarray.toString());
        System.out.println(st.Sumarray.toString());
        System.out.println(st.minQuery(0,1));
        System.out.println(st.maxQuery(0,1));
        System.out.println(st.sumQuery(0,1));


    }
}
