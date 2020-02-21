import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.TreeMap;

public class VerticalTraversalBST
{
    private void getHeight(Treenode root, HashMap<Integer, ArrayList<Integer>> horizontal_distance,int m)
    {
        if(root==null)
            return;
        if(horizontal_distance.containsKey(m))
        {
            horizontal_distance.get(m).add(root.val);
        }
        else
            {
               horizontal_distance.put(m, new ArrayList<Integer>(Arrays.asList(root.val)));
            }
        getHeight(root.left,horizontal_distance,m-1);
        getHeight(root.right,horizontal_distance,m+1);
    }
    public void traverseVertically(Treenode root)
    {
        HashMap<Integer,ArrayList<Integer>> horizontal_distance=new HashMap<Integer,ArrayList<Integer>>();
        getHeight(root,horizontal_distance,0);
        TreeMap<Integer,ArrayList<Integer>> sortedorder= new TreeMap<Integer,ArrayList<Integer>>(horizontal_distance);
        System.out.println("");
        for(int x:sortedorder.keySet())
        {
            for(int y:sortedorder.get(x))
            {
                System.out.print(y+" ");
            }
            System.out.println("");
        }
    }

}
