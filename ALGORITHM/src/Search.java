import java.io.IOException;
import java.time.Duration;
import java.time.Instant;

public class Search {
    public static long binary(int array[], int value) {
        int high = array.length, low = 0, mid = (low + high) / 2;
        Instant start, end;
        start = Instant.now();
        while (low <= high) {
            if (array[mid] == value) {
                break;
            } else if (array[mid] > value) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
            mid = (low + high) / 2;
        }
        end = Instant.now();
        long timeElapsed = Duration.between(start, end).toNanos();
        return timeElapsed;
    }

    public static long linear(int array[], int value) {
        Instant start, end;
        start = Instant.now();
        for (int a:array) {
            if (a == value) {
                break;
            }
        }
        end = Instant.now();
        long timeElapsed = Duration.between(start, end).toNanos();
        return timeElapsed;
    }

    public static void main(String args[]) {
       // FOR LINEAR SEARCH
        int array[][] = {{625, 658, 1731, 1487, 100, 1165, 1350, 981, 1229, 1876,},
                {625, 658, 1731, 1487, 100, 1165, 1350, 981, 1229, 1876,85, 363, 1681, 32, 170, 1288, 850, 1863, 1800, 1512},
                {625, 658, 1731, 1487, 100, 1165, 1350, 981, 1229, 1876, 85, 363, 1681, 32,
                        170, 1288, 850, 1863, 1800, 1512, 168, 1924, 1273, 1745, 1729, 1622, 2, 6, 322, 1599},{625, 658, 1731, 1487, 100, 1165, 1350, 981, 1229, 1876, 85, 363, 1681, 32, 170, 1288, 850, 1863, 1800,
                1512, 168, 1924, 1273, 1745, 1729, 1622, 2, 6, 322, 1599, 395, 1521, 1128, 1994, 1869, 1115, 1336,
                387, 873, 1510},
                {625, 658, 1731, 1487, 100, 1165, 1350, 981, 1229, 1876, 85, 363, 1681, 32, 170, 1288, 850, 1863, 1800,
                        1512, 168, 1924, 1273, 1745, 1729, 1622, 2, 6, 322, 1599, 395, 1521, 1128, 1994, 1869, 1115, 1336,
                        387, 873, 1510, 1124, 583, 706, 129, 1579, 24,
                        1982, 1449, 180,1727},
                {625, 1775, 1969, 1420, 581, 450, 1009, 1102, 1755, 1705, 990, 1873, 644, 209, 410, 1061, 260,
                1291, 1622, 550, 214, 1554, 871, 613, 1941, 1195, 1862, 1598, 623, 449, 1448,
                586, 1749, 839, 1159, 103, 1617, 101, 895, 1478, 388, 157, 55, 1589, 305, 1536, 1106, 1947, 1931, 1523,
                1474, 1428, 1435, 521, 1355, 1880, 1739, 1327, 794, 1727}
                };
        StringBuilder s = new StringBuilder();
        Search.linear(new int[]{2,1},2);
        s.append("LINEAR SEARCH\n");
        s.append("'N'  BEST CASE   AVERAGE CASE  WORST CASE\n");
        Search.linear(new int[]{0,1,3,4,5,6,2},2);
        for (int a[] : array) {
            s.append(a.length);
            s.append("    ");
            s.append(Search.linear(a,a[0]));
            s.append("        ");
            s.append(Search.linear(a,a[a.length/2]));
            s.append("        ");
            s.append(Search.linear(a,-1));
            s.append("\n");

        }
        System.out.println(s);
        array=new int[][]{{1,2,3,4,5,6,7,8,9,10},
                {1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,18,19,20},
                {1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,18,19,20,21,22,23,24,25,26,27,28,29,30},
                {1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,18,19,20,21,22,23,24,25,26,27,28,29,30,31,32,33,
                        34,35,36,37,38,39,40},
                {1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,18,19,20,21,22,23,24,25,26,27,28,29,30,31,32,33,
                        34,35,36,37,38,39,40,41,42,43,44,45,46,47,48,49,50},
                {1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,18,19,20,21,22,23,24,25,26,27,28,29,30,31,32,33,34,
                35,36,37,38,39,40,41,42,43,44,45,46,47,48,49,50,51,52,53,54,55,56,57,58,59,60}};

        StringBuilder result = new StringBuilder();
        Search.binary(new int[]{1,2,3,4,5},3);
        result.append("BINARY SEARCH\n");
        result.append("'N'   BEST CASE   AVERAGE CASE  WORST CASE\n");
        Search.binary(new int[]{0,1,3,4,5,6},2);
        for (int a[] : array) {
            result.append(a.length);
            result.append("    ");
            result.append(Search.binary(a,a[a.length/2]));
            result.append("       ");
            result.append(Search.binary(a,a[a.length/2-2]));
            result.append("          ");
            result.append(Search.binary(a,-1));
            result.append("\n");

        }
        System.out.println(result);
    }
}





