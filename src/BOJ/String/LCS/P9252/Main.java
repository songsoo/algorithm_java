package BOJ.String.LCS.P9252;

import java.io.FileInputStream;
import java.util.Scanner;

public class Main {
    static int arr[][];
    static char[] a, b;
    public static void main(String[] args) throws Exception{


        System.setIn(new FileInputStream("D:\\IntelliJ\\algo\\src\\Test\\input.txt"));

        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        a = str.toCharArray();
        str = sc.nextLine();
        b = str.toCharArray();
        arr = new int[a.length+1][b.length+1];

        getLCS();
    }

    public static void getLCS(){
        for (int i = 0; i < a.length; i++) {
            for (int j = 0; j < b.length; j++) {
                if(a[i]==b[j]){
                    arr[i+1][j+1] = arr[i][j]+1;
                }else{
                    //i,j = i-1,j or i,j-1
                    arr[i+1][j+1] = Math.max(arr[i+1][j],arr[i][j+1]);
                }
            }
        }
        int i = a.length;
        int j = b.length;

        StringBuilder sb = new StringBuilder();

        while(arr[i][j]>0){
            if(arr[i-1][j]==arr[i][j]){
                i--;
            }else if(arr[i][j-1]==arr[i][j]){
                j--;
            }else{
                sb.append(a[i-1]);
                i--;
                j--;
            }
        }
        sb.reverse();

        System.out.println(arr[a.length][b.length]+"\n"+sb.toString());
    }
}
