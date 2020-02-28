import java.util.ArrayList;
import java.util.HashMap;

/*Imagine  a robot sitting on the upper-left corner of the grid with r rows and c columns. The robot can only move in two
 direction right and down but certain cell are off limits. Find an algorithm that can make robot take steps to move from
 top left to bottom-right*/
public class RobotGrid
{   static class Point
    {
        int row_no;
        int col_no;
        public Point(int row_no,int col_no)
        {
            this.row_no=row_no;
            this.col_no=col_no;
        }
    }
    static ArrayList<Point>  get_path(boolean[][] maze)
    {
        if(maze.length==0 || maze[0].length==0)
            return null;
        ArrayList<Point> path =new ArrayList<Point>();
        HashMap<Point,Boolean> travelled=new HashMap<Point,Boolean>();
        int lastrow=maze.length-1;
        int lastcol=maze[0].length-1;
        if(get_path(maze,lastrow,lastcol,path,travelled))
        {
            return path;
        }
        return null;
    }
    static boolean get_path(boolean[][] maze,int lastrow,int lastcol,ArrayList<Point> path,HashMap<Point,Boolean> travelled)
    {
        if(lastrow<0 || lastcol<0 || !(maze[lastrow][lastcol]))
        {
            return false;
        }
        Point p=new Point(lastrow,lastcol);
        if(travelled.containsKey(p))
        {
            return travelled.get(p);
        }
        boolean isorigin=(lastrow==0) && (lastcol==0);
        boolean success=false;
        if(isorigin || get_path(maze,lastrow,lastcol-1,path,travelled) || get_path(maze,lastrow-1,lastcol,path,travelled))
        {
            path.add(p);
            success=true;
        }
        travelled.put(p,success);
        return success;
    }
    public static void main(String ...args)
    {
        boolean [][] maze=new boolean[][]   {{true,true,false,false},
                                            {true,true,false,false},
                                            {false,true,true,false},
                                            {true,true,true,true}};
        ArrayList<Point> path=get_path(maze);
        for(Point p:path)
        {
            System.out.println(p.row_no+"     "+p.col_no);
        }
    }
}
