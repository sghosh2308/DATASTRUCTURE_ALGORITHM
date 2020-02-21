/*Implementing Lee Algorithm to find the path from a source to destination in Binary Graph*/
import java.util.LinkedList;
import java.util.Queue;

public class LeeAlgorithm
{   int ROW,COLUMN;
    int matrix[][];
    boolean visited[][];
    int[] row_movement=new int[]{-1,0,0,1};
    int[] column_movement=new int[]{0,-1,1,0};
    Point source,destination;
    public LeeAlgorithm(int matrix[][],int x1,int y1,int x2,int y2)
    {
        this.ROW=matrix.length;

        this.COLUMN=matrix[0].length;
        this.matrix=matrix;
        this.visited=new boolean[this.ROW][this.COLUMN];
        this.source=new Point(y1,x1);
        this.destination=new Point(y2,x2);
        for(int i=0;i<this.matrix.length;i++)
        {
            for(int j=0;j<this.matrix[0].length;j++)
            {
                if((i==source.row_no)&&(j==source.column_no))
                {
                    System.out.print("s ");
                }
                else if((i==destination.row_no)&&(j==destination.column_no))
                {
                    System.out.print("d ");
                }
                else
                    {
                        System.out.print(this.matrix[i][j]+" ");
                    }
            }
            System.out.println();
        }

    }
    static class Point
    {
        int row_no;
        int column_no;

        public Point(int row_no,int column_no)
        {
            this.row_no=row_no;
            this.column_no=column_no;
        }
    }
    static class TravelPoint
    {
        Point p;
        int weight;
        public TravelPoint(Point p,int weight)
        {
            this.p=p;
            this.weight=weight;
        }
    }
    private boolean isvalid(int row,int column)
    {
        boolean b = (row >= 0) && (row < this.ROW) && (column >=0) && (column < this.COLUMN);
        return b;
    }
    public void startVisiting()
    {
        if(this.matrix[this.source.row_no][this.source.column_no]!=1)
            {
                System.out.println("Path Cannot be found Source isn't reachable");
                return;
            }
        if(this.matrix[this.destination.row_no][this.destination.column_no]!=1)
        {
            System.out.println("Path Cannot be found Destination isn't reachable");
            return;
        }
        Queue<TravelPoint> q=new LinkedList<>();
        this.visited[this.source.row_no][this.source.column_no]=true;
        q.add(new TravelPoint(source,0));
        while(!q.isEmpty())
        {
            TravelPoint current=q.poll();
            Point p=current.p;
            if((p.row_no==this.destination.row_no)&&(p.column_no==this.destination.column_no))
            {
                System.out.println("Path Found   "+current.weight);
                return;
            }
                for(int i=0;i<4;i++)
                {
                    int row=p.row_no+this.row_movement[i];
                    int col=p.column_no+this.column_movement[i];
                    if((isvalid(row,col))&&(!this.visited[row][col])&&(this.matrix[row][col]==1))
                    {
                        this.visited[row][col]=true;
                        q.add(new TravelPoint((new Point(row,col)),current.weight+1));
                    }
                }
            }
            System.out.println("Path cannot be devised");
            return;
        }
        public static void main(String ...x)
        {
            int mat[][]=new int[][]{{1,0,1,1,1,1,0,1,1,1},
                                    {1,0,1,0,1,1,1,0,1,1},
                                    {1,1,1,0,1,1,0,1,0,1},
                                    {0,0,0,0,1,0,0,0,0,1},
                                    {1,1,1,0,1,1,1,0,1,0},
                                    {1,0,1,1,1,1,0,1,0,0},
                                    {1,0,0,0,0,0,0,0,0,1},
                                    {1,0,1,1,1,1,0,1,1,1},
                                    {1,1,0,0,0,0,1,0,0,1}};
            LeeAlgorithm l=new LeeAlgorithm(mat,0,0,4,5);
            l.startVisiting();
        }

    }


