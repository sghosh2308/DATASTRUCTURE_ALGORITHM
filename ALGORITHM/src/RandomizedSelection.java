import java.util.Random;

public class RandomizedSelection {
    private int arr[];
    public RandomizedSelection(int arr[]){
        this.arr=arr;
    }
    private int partition(int low, int high)
    {
        int ran=(new Random()).nextInt(high-low) + low;
        System.out.println("Random "+ran+" LOW "+low+" High "+high);
        int temp=arr[ran];
        arr[ran]=arr[high];
        arr[high]=temp;

        int i=low;
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

        arr[high] = arr[i];
        arr[i] = temp;
        display();
        return i;
    }



    private void select(int low,int high,int k){
       if(low<high){

            int index=partition(low,high);


           System.out.println();
            if(index-low==k){
                System.out.println(arr[index]);

            }
            else if(index-low>k){
                select(low,index-1,k);

            }
            else{
                select(index+1,high,k-index+low);
            }
        }

    }
    public void display(){
        StringBuilder s=new StringBuilder();
        for(int i:this.arr){
            s.append(i).append(", ");
        }
        System.out.println(s);
    }

    public void find(int i_th){
        select(0,arr.length-1,i_th);
    }
    public static void main(String args[]){
        RandomizedSelection r=new RandomizedSelection(new int[]{2,10,1,4,7,3,9,5,6,8});
        r.find(7);
    }
}
