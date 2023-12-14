package BOJ.BruteForce.SequentialSearch.G5.P1107;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static int N,M,min;
    static boolean broken[];
    public static void main(String[] args) throws Exception {

        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(bf.readLine());
        M = Integer.parseInt(bf.readLine());

        broken = new boolean[10];
        min = Integer.MAX_VALUE;

        StringTokenizer st = new StringTokenizer("");
        if(M>0){
             st = new StringTokenizer(bf.readLine());
        }

        for (int i = 0; i < M; i++) {
            int brokenNum = Integer.parseInt(st.nextToken());
            broken[brokenNum] = true;
        }


        min = Math.abs(N-100);

        for (int i = 0; i < 10; i++) {
            if(!broken[i]){
                goNext(1,i);
            }
        }

        System.out.println(min);

    }

    public static void goNext(int index, int cur){
        min = Math.min(min, index+Math.abs(cur-N));
        if(index>6){
            return;
        }
        for (int i = 0; i < 10; i++) {
            if(!broken[i]){
                goNext(index+1, cur*10+i);
            }
        }
    }
}
