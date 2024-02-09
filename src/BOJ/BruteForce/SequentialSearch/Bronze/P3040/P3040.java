package BOJ.BruteForce.SequentialSearch.Bronze.P3040;

import java.util.Scanner;

public class P3040 {
    static int[] hats;
    static boolean[] visited;
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        hats = new int[9];
        visited = new boolean[9];
        for (int i = 0; i < 9; i++) {
            hats[i] = sc.nextInt();
        }

        comb(0,0,0);

    }
    public static void comb(int cnt,int start, int sum){
        if(cnt==7){
            if(sum==100){
                for (int i = 0; i < 9; i++) {
                    if(visited[i]){
                        System.out.println(hats[i]);
                    }
                }
            }
            return;
        }
        for (int i = start; i < 9; i++) {
            visited[i] = true;
            comb(cnt+1,i+1,sum+hats[i]);
            visited[i] = false;
        }
    }
}
