import java.util.LinkedList;
import java.util.Queue;

public class InvertBits
{
    int ROW,COLUMN;
    int matrix[][];
    boolean visited[][];
    int[] row_movement=new int[]{-1,0,0,1};
    int[] column_movement=new int[]{0,-1,1,0};
    InvertBits.Point source;


    public InvertBits(int matrix[][],int x1,int y1,int x2,int y2)
    {
        this.ROW=matrix.length;

        this.COLUMN=matrix[0].length;
        this.matrix=matrix;
        this.visited=new boolean[this.ROW][this.COLUMN];
        this.source=new InvertBits.Point(y1,x1);

        for(int i=0;i<this.matrix.length;i++)
        {
            for(int j=0;j<this.matrix[0].length;j++)
            {
                if((i==source.row_no)&&(j==source.column_no))
                {
                    System.out.print("s ");
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

    private boolean isvalid(int row,int column)
    {
        boolean b = (row >= 0) && (row < this.ROW) && (column >=0) && (column < this.COLUMN);
        return b;
    }
    public void startVisiting()
    {
        if(this.matrix[this.source.row_no][this.source.column_no]!=1)
        {
            System.out.println("Seed isn't recheable");
            return;
        }
        int count=0;
        Queue<InvertBits.Point> q=new LinkedList<InvertBits.Point>();
        this.visited[this.source.row_no][this.source.column_no]=true;
        q.add(source);
        while(!q.isEmpty())
        {
            Point current=q.poll();
            for(int i=0;i<4;i++)
            {
                int row=current.row_no+this.row_movement[i];
                int col=current.column_no+this.column_movement[i];
                if((isvalid(row,col)&&(!this.visited[row][col]))&&((this.matrix[row][col]==1)))
                {
                    this.visited[row][col]=true;
                    this.matrix[row][col]=0;
                    q.add(new  InvertBits.Point(row, col));

                }


            }
        }
        return;
    }
    public static void main(String ...x)
    {
        int mat[][]=new int[][]{
                {1,0,1,1,1,1,0,1,1,1},
                {1,0,1,0,1,1,1,0,1,1},
                {1,1,1,0,1,1,0,1,0,1},
                {0,0,0,0,1,0,0,0,0,1},
                {1,1,1,0,1,1,1,0,1,0},
                {1,0,1,1,1,1,0,1,0,0},
                {1,0,0,0,0,0,0,0,0,1},
                {1,0,1,1,1,1,0,1,1,1},
                {1,1,0,0,0,0,1,0,0,1}};

        InvertBits l=new InvertBits(mat,0,1,mat[0].length-1,mat.length-1);
        l.startVisiting();
        System.out.println("INVERTED BITS ");
        for(int[] s:mat)
        {
            for(int a:s)
            {
                System.out.print(a+" ");
            }
            System.out.println();
        }
    }
}
