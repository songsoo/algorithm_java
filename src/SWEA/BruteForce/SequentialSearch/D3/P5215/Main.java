package SWEA.BruteForce.SequentialSearch.D3.P5215;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int N, L, result;
    static int[][] grad;
    public static void main(String[] args) throws Exception{

        System.setIn(new FileInputStream("E:\\SSAFY9\\intelliJ_workspace\\algorithm_java\\src\\SWEA\\BruteForce\\SequentialSearch\\D3\\P5215\\input.txt"));
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(bf.readLine());

        for (int test_case = 1; test_case <= T; test_case++) {

            StringTokenizer st = new StringTokenizer(bf.readLine());

            N = Integer.parseInt(st.nextToken());
            L = Integer.parseInt(st.nextToken());
            grad = new int[N][2];
            result = 0;

            for (int i = 0; i < N; i++) {
                st = new StringTokenizer(bf.readLine());
                grad[i][0] = Integer.parseInt(st.nextToken());
                grad[i][1] = Integer.parseInt(st.nextToken());
            }

            goNext(0,0,0);
            System.out.println("#"+test_case+" "+result);

        }
    }

    public static void goNext(int taste, int cal,int cur){
        if(cur==N){
            if(cal<=L){
                result = Math.max(result,taste);
            }
            return;
        }

        goNext(taste + grad[cur][0],cal+grad[cur][1],cur+1);
        goNext(taste,cal,cur+1);

    }
}
