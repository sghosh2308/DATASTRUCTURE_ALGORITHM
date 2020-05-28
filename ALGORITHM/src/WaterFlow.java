import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;

public class WaterFlow {
    static class Cluster
    {
        String Name;
        int consumption;
        int capacity;
        int remaining;
        Cluster(String data[])
        {
            this.Name=data[0];
            this.consumption=Integer.parseInt(data[1]);
            this.capacity=Integer.parseInt(data[2]);
            this.remaining=capacity;
        }
    }
    public static void main(String args[])throws IOException
    {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        int days=Integer.parseInt(br.readLine());
        int cluster_count=Integer.parseInt(br.readLine());
        HashMap<String,Cluster> cluster=new HashMap<String,Cluster>();
        for(int i=0;i<cluster_count;i++)
        {
            String data[]=br.readLine().trim().split(" ");
            cluster.put(data[0],new Cluster(data));
        }
        int connection=Integer.parseInt(br.readLine());
        ArrayList<String[]> conn=new ArrayList<>();
        for(int i=0;i<connection;i++)
        {
            String[] c=br.readLine().trim().split("_");
            conn.add(c);
        }
        int totalwatersend=0;
        for(int i=0;i<days;i++)
        {
            for(String c:cluster.keySet())
            {
                Cluster clus=cluster.get(c);
                if(i==0){
                totalwatersend+=clus.capacity;
                }
                clus.remaining-=clus.consumption;
                if(clus.remaining==0){
                    totalwatersend+=clus.capacity;
                    clus.remaining=clus.capacity;
                }
            }
        }
        System.out.println(totalwatersend);
    }
}
