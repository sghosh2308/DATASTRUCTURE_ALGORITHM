public class RandomizedSelection {
    private int arr[];
    public RandomizedSelection(int arr[]){
        this.arr=arr;
    }
    private int partition(int low, int high)
    {
        int temp=arr[high];

        int i=low-1;
        for (int j = low; j < high; j++)
        {

            if (arr[j] <= temp)
            {
                i++;
                int temp1 = arr[i];
                arr[i] = arr[j];
                arr[j] = temp1;
            }
        }

        arr[high] = arr[i+1];
        arr[i+1] = temp;
        display();
        return i;
    }
    private void select(int low,int high,int k){
       if(low<high)
       {

            int index=partition(low,high);


           System.out.println();
            if(index-low==k)
            {
                System.out.println(arr[index]);

            }
            else if(index-low>k)
            {
                select(low,index-1,k);

            }
            else
            {
                select(index+1,high,k-index+low-1);
            }
        }

    }
    public void display(){
        StringBuilder s=new StringBuilder();
        for(int i:this.arr)
        {
            s.append(i).append(", ");
        }
        System.out.println(s);
    }

    public void find(int i_th)
    {

        select(0,arr.length-1,i_th-1);
    }
    public static void main(String args[]){
        RandomizedSelection r=new RandomizedSelection(new int[]{2,10,1,4,7,3,9,5,6,8});
        r.find(2);
    }
}
