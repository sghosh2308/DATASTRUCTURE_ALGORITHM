import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;

public class JobSequence{
    public static void printschedule(ArrayList<Job> j){
        int result[]=new int[j.size()];
        boolean slot[]=new boolean[j.size()];
        for (int i=0; i<slot.length; i++)
            slot[i] = false;
        for(int i=0;i<j.size();i++){
            for(int x=Math.min(j.size(),j.get(i).deadline)-1;x>=0;x--){
                if(slot[x]==false){
                    result[x]=i;
                    slot[x]=true;
                    break;
                }
            }
        }
        for(int i=0;i<j.size();i++){
            if(slot[i]){
                System.out.print(j.get(i).jobid+" ");
            }
        }

    }
    public static void main(String ...x)throws IOException
    {
        BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Enter the Number of Jobs");
        int i=Integer.parseInt(br.readLine());
        ArrayList<Job> j=new ArrayList<Job>();
        while(i-->0){
            System.out.println("Enter the  job id, deadline and profit with unispace");
            String input=br.readLine();
            String st[]=input.split(" ");
            j.add(new Job(Integer.parseInt(st[0]),Integer.parseInt(st[1]),Integer.parseInt(st[2])));
        }
        Collections.sort(j);
        for(Job e:j){
            System.out.println(e.jobid+"  "+e.deadline+" "+e.profit);
        }
        JobSequence.printschedule(j);

    }

}
