public class Job implements Comparable{
    int jobid;
    int deadline;
    int profit;
    Job(int jobid,int deadline,int profit){
        this.jobid=jobid;
        this.deadline=deadline;
        this.profit=profit;
    }
    @Override
    public int compareTo(Object o){
        int compare=((Job)o).profit;
        return compare-this.profit;
    }


}

