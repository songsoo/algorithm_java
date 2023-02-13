package BOJ.BruteForce.BackTracking.S3.P15650;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    static int N,M;
    static ArrayList<Integer> arr;
    static StringBuilder sb;
    public static void main(String[] args) {
        sb = new StringBuilder();
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        M = sc.nextInt();
        arr = new ArrayList();
        goNext(0,1);
        System.out.println(sb.toString());
    }
    public static void goNext(int index,int start){
        if(index==M){
            for(int a : arr){
                sb.append(a+" ");
            }
            sb.append("\n");
            return;
        }
        for (int i = start; i <= N; i++) {
            arr.add(new Integer(i));
            goNext(index+1,i+1);
            arr.remove(new Integer(i));
        }
    }
}
