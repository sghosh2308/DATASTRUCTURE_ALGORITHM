import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class LongestCommonSequence {

public static void main(String... args)throws IOException {
    BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
    String s1=br.readLine();
    String s2=br.readLine();
    int m=s1.length();
    int n=s2.length();
    int lcs[][]=new int[m+1][n+1];
    for(int i=1;i<=m;i++){
        for(int j=1;j<=n;j++){
            if(s1.charAt(i-1)==s2.charAt(j-1)){
                lcs[i][j]=lcs[i-1][j-1]+1;
            }
            else{
                lcs[i][j]=Math.max(lcs[i-1][j],lcs[i][j-1]);
            }
        }
    }
    for(int x[]:lcs){
        for(int a:x){
            System.out.print(a+" ");
        }
        System.out.println();
    }



}
}
