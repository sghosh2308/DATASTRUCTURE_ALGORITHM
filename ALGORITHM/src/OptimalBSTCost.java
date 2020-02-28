import java.util.HashMap;

public class OptimalBSTCost
{

    public static void createHashTable(Treenode root,HashMap<Treenode,Integer> map)
    {
        if(root==null)
        {
            return;
        }
        if(map.containsKey(root)) {
            map.replace(root,map.get(root)+1);
        } else
            map.put(root,0);
        createHashTable(root.left,map);
        createHashTable(root.right,map);
    }
    public static void getoptimisedcost(HashMap<Treenode,Integer> map) {
        int f = 0;
        int[] frequency = new int[map.size()];
        for (Treenode t : map.keySet()) {
            frequency[f++] = map.get(t);
        }
        int[][] cost = new int[map.size() + 1][map.size() + 1];
        for (int i = 0; i <= f; i++)
            cost[i][i] = frequency[i];
        for (int L = 2; L <= f; L++) {
            for (int i = 0; i <= f - L + 1; i++) {
                int j = i + L - 1;
                cost[i][j] = Integer.MAX_VALUE;
                for (int r = i; r <= j; r++) {
                    int c = ((r > i) ? cost[i][r - 1] : 0)
                            + ((r < j) ? cost[r + 1][j] : 0) + sum(frequency, i, j);
                    if (c < cost[i][j])
                        cost[i][j] = c;
                }
            }
        }
    }
    public static int sum(int arr[],int i,int j)
    { int sum=0;
        for(int s=i;s<=j;s++)
            sum+=arr[s];
        return sum;
    }

    public static void main(String args[])
    {   Treenode root=new Treenode(2);
        HashMap<Treenode,Integer> map=new HashMap<Treenode,Integer>();
        createHashTable(root,map);
        getoptimisedcost(map);
    }
}