import java.time.Duration;
import java.time.Instant;
import java.util.Arrays;

public class Sort {
    int swapnum;

    public void insertionsort(int arr[]) {
        swapnum = 0;
        int n = arr.length;
        for (int i = 1; i < n; ++i) {
            int key = arr[i];
            int j = i - 1;


            while (j >= 0 && arr[j] > key) {
                arr[j + 1] = arr[j];
                j = j - 1;
                swapnum++;
            }
            arr[j + 1] = key;
        }
    }

    private void merge(int[] arr, int l, int m, int r) {
        int n1 = m - l + 1;
        int n2 = r - m;
        int L[] = new int[n1];
        int R[] = new int[n2];
        for (int i = 0; i < n1; ++i)
            L[i] = arr[l + i];
        for (int j = 0; j < n2; ++j)
            R[j] = arr[m + 1 + j];
        int i = 0, j = 0;
        int k = l;
        while (i < n1 && j < n2) {
            if (L[i] <= R[j]) {
                arr[k] = L[i];
                i++;
            } else {
                arr[k] = R[j];
                j++;
            }
            k++;
        }


        while (i < n1) {
            arr[k] = L[i];
            i++;
            k++;
        }

        while (j < n2) {
            arr[k] = R[j];
            j++;
            k++;
        }
        swapnum += i + j;
    }

    public void mergesort(int arr[], int l, int r) {
        if (l < r) {
            int m = (l + r) / 2;
            mergesort(arr, l, m);
            mergesort(arr, m + 1, r);
            merge(arr, l, m, r);
        }
    }

    private int getMax(int arr[], int n) {
        int mx = arr[0];
        for (int i = 1; i < n; i++)
            if (arr[i] > mx)
                mx = arr[i];
        return mx;
    }

    private void countSort(int arr[], int n, int exp) {
        int output[] = new int[n]; // output array
        int i;
        int[] count = new int[10];
        Arrays.fill(count,0);

        for (i = 0; i < n; i++)
            count[ (arr[i]/exp)%10 ]++;


        for (i = 1; i < 10; i++)
            count[i] += count[i - 1];

        for (i = n - 1; i >= 0; i--)
        { swapnum++;
            output[count[ (arr[i]/exp)%10 ] - 1] = arr[i];
            count[ (arr[i]/exp)%10 ]--;
        }

        for (i = 0; i < n; i++)
            arr[i] = output[i];
    }

    public void radixsort(int arr[], int n)
    {

        int m = getMax(arr, n);


        for (int exp = 1; m/exp > 0; exp *= 10)
            countSort(arr, n, exp);
    }

    public static void main(String... args) {

        Sort sort = new Sort();

        int array[][] = {
                {625, 1775, 1969, 1420, 581, 450, 1009, 1102, 1755, 1705, 990, 1873, 644, 209, 410, 1061, 260,
                        1291, 1622, 550, 214, 1554, 871, 613, 1941, 1195, 1862, 1598, 623, 449, 1448,
                        586, 1749, 839, 1159, 103, 1617, 101, 895, 1478, 388, 157, 55, 1589, 305, 1536, 1106, 1947, 1931, 1523,
                        1474, 1428, 1435, 521, 1355, 1880, 1739, 1327, 794, 1727},
                {1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,18,19,20,21,22,23,24,25,26,27,28,29,30,31,32,33,34,
                        35,36,37,38,39,40,41,42,43,44,45,46,47,48,49,50,51,52,53,54,55,56,57,58,59,60},
                {60,59,58,57,56,55,54,53,52,51,50,49,48,47,46,45,44,43,42,41,40,39,38,37,36,35,34,33,32,31,30,29,28,27,26,25,24,23,22,21,20,19,18,17,16,15,14,13,12,11,10,9,8,7,6,5,4,3,2,1}};
        StringBuilder result = new StringBuilder();
        Instant start,end;

        result.append("INSERTION SORT\n");
        for (int a[] : array) {
            result.append(a.length);
            result.append("   ");
            start=Instant.now();
            sort.insertionsort(a);
            end=Instant.now();
            long timeElapsed = Duration.between(start, end).toNanos();

            result.append(sort.swapnum);
            result.append("       ");
            result.append(timeElapsed);
            result.append("\n");
        }
        System.out.println(result);
        result=null;
        result=new StringBuilder();
        result.append("MERGE SORT\n");
        for (int a[] : array) {
            result.append(a.length + " ");
            sort.swapnum = 0;
            start=Instant.now();
            sort.mergesort(a, 0, a.length-1);
            end=Instant.now();
            long timeElapsed = Duration.between(start, end).toNanos();
            result.append(sort.swapnum);
            result.append("       ");
            result.append(timeElapsed);
            result.append("\n");
        }
        System.out.println(result);
        result=null;
        result=new StringBuilder();
        result.append("RADIX SORT\n");
        for (int a[] : array) {
            result.append(a.length + " ");
            sort.swapnum = 0;
            start=Instant.now();
            sort.radixsort(a, a.length-1);
            end=Instant.now();
            long timeElapsed = Duration.between(start, end).toNanos();
            result.append(sort.swapnum);
            result.append("       ");
            result.append(timeElapsed);
            result.append("\n");
        }
        System.out.println(result);
    }
}









