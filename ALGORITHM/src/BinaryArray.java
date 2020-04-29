public class BinaryArray
{
    public static int findMaxLength(int[] nums)
    {
        if(nums.length==0)
            return 0;
        if(nums.length==1)
            return 0;
        int countzero=0;
        int countone=0;
        for(int i=0;i<nums.length;i++)
        {
            if (nums[i] == 1) {
                countone++;
            } else {
                countzero++;
            }
        }
        if(countone==nums.length ||countzero==nums.length)
            {
                return 0;
            }

        return (countone>countzero?countzero:countone)*2;
    }
    public static void main(String args[])
    {
        int[] nums=new int[]{0,0,0};
        int row=findMaxLength(nums);
        System.out.println(row);

    }
}
