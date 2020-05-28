import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class RotatedSortedArray
{

        public int search(int[] nums, int target)
        {
            return search(nums,0,nums.length-1,target);
        }
        private int search(int[] nums,int left,int right,int target)
        {
            if(right<left)
                return -1;
            int mid=(left+right)/2;
            if(nums[mid]==target)
                return mid;
            if(nums[left]<nums[mid])
            {
                if(target>=nums[left]&& target<nums[mid])
                    return search(nums,left,mid-1,target);
                else
                    return search(nums,mid+1,right,target);
            }
            else if(nums[mid]<nums[left])
            {
                if(target>nums[mid]&&target<=nums[right])
                {
                    return search(nums,mid+1,right,target);
                }
                else
                {
                    return search(nums,left,mid-1,target);
                }
            }else if(nums[mid]==nums[left])
            {
                if(nums[mid]!=nums[right])
                {
                    return search(nums,mid+1,right,target);
                }
                else
                {
                    int result=search(nums,left,mid-1,target);
                    if(result==-1)
                        search(nums,mid+1,right,target);
                    else
                        return result;
                }
            }
            return -1;
        }
        public static void main(String ...args)throws IOException
        {
            BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
            System.out.println("Insert The Target");
            int t=Integer.parseInt(br.readLine());
            System.out.println("Insert The Elements");
            int[] arr= Arrays.stream(br.readLine().trim().split(" ")).mapToInt(Integer::parseInt).toArray();
            RotatedSortedArray rsa=new RotatedSortedArray();
            System.out.println(rsa.search(arr,t));
        }

}
