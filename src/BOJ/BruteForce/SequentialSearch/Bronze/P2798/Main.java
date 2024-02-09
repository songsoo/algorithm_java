package BOJ.BruteForce.SequentialSearch.Bronze.P2798;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static int N,M;
    static int[] cards;
    static int result = Integer.MAX_VALUE;
    public static void main(String[] args) throws Exception{

        System.setIn(new FileInputStream("D:\\IntelliJ\\algorithm_java\\src\\BOJ\\B2\\P2798\\input.txt"));

        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        cards = new int[N];

        st = new StringTokenizer(bf.readLine());
        for (int i = 0; i < N; i++) {
            cards[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(cards);
        System.out.println(Arrays.toString(cards));
        comb(-1,0,0);

        System.out.println(result);

        for (int i = 0; i < N-2; i++) {
            for (int j = i+1;  j< N-1; j++) {
                for (int k = j+1; k < N; k++) {

                }
            }
        }

    }

    public static void comb(int idx, int cnt, int sum){

        if(sum>Math.abs(result-M)+M){
            return;
        }
        if(3==cnt){
            result = Math.abs(sum-M)>Math.abs(result-M)?result : sum;
        }

        for (int i = idx+1; i < N; i++) {
            comb(i,cnt+1,sum+cards[i]);
        }
    }
}
