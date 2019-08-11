import java.util.Arrays;

public class Depth_first_search extends Graph {
    private int color[], time, start[], descendent[], end[];

    private Depth_first_search(int v, int e) {
        super(v, e);
        color = new int[v];
        time = 0;
        start = new int[v];
        end = new int[v];
        descendent = new int[v];
        for (int i = 0; i < v; i++) {
            color[i] = 0;
            descendent[i] = 0;

        }
    }

    public void dfs() {
        for (int i = 1; i < this.vertex; i++) {
            if (color[i] == 0) {
                dfs_visit(i);
            }
        }
    }

    private void dfs_visit(int source) {
        time += 1;

        start[source] = time;
        color[source] = 1;
        Node adjacent = list[source];

        while (adjacent != null) {
            if (color[adjacent.data] == 0) {
                descendent[adjacent.data] = source;
                dfs_visit(adjacent.data);
            }
            adjacent = adjacent.next;
        }
        color[source] = 2;
        time += 1;
        end[source] = time;
    }

    public static void main(String args[]) {
        Depth_first_search g = new Depth_first_search(5, 5);
        g.addedge(1, 2);
        g.addedge(2, 3);
        g.addedge(3, 4);
        g.addedge(4, 2);
        g.addedge(3, 1);
        g.print();
        g.dfs();

        Arrays.stream(g.color).mapToObj(x -> x + " ").forEach(System.out::print);
        System.out.println("\n");
        Arrays.stream(g.start).mapToObj(x -> x + " ").forEach(System.out::print);
        System.out.println("\n");
        Arrays.stream(g.end).mapToObj(x -> x + " ").forEach(System.out::print);
        System.out.println("\n");
        Arrays.stream(g.descendent).mapToObj(x -> x + " ").forEach(System.out::print);
    }
}
