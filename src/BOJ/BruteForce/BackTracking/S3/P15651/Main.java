package BOJ.BruteForce.BackTracking.S3.P15651;


import java.util.Scanner;

public class Main {
    static int N,M;
    static int[] arr;
    static StringBuilder sb;
    public static void main(String[] args) {
        sb = new StringBuilder();
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        M = sc.nextInt();
        arr = new int[M];
        goNext(0);
        System.out.println(sb.toString());
    }
    public static void goNext(int index){
        if(index==M){
            for(int a : arr){
                sb.append(a+" ");
            }
            sb.append("\n");
            return;
        }
        for (int i = 1; i <= N; i++) {
                arr[index]=i;
                goNext(index+1);
            }
        }
    }
