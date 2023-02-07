package BOJ.S3.P15649;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    static int N,M;
    static ArrayList<Integer> arr;
    static StringBuilder sb;
    static boolean[] visited;
    public static void main(String[] args) {
        sb = new StringBuilder();
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        M = sc.nextInt();
        arr = new ArrayList();
        visited = new boolean[N+1];
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
            if(!visited[i]){
                visited[i] = true;
                arr.add(new Integer(i));
                goNext(index+1);
                arr.remove(new Integer(i));
                visited[i] = false;
            }
        }
    }
}
