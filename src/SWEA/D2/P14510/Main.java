package SWEA.D2.P14510;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception{
        System.setIn(new FileInputStream("E:\\SSAFY9\\intelliJ_workspace\\algorithm_java\\src\\SWEA\\D2\\P14510\\input.txt"));
        BufferedReader bf = new BufferedReader(new InputStreamReader((System.in)));

        int T;
        T=Integer.parseInt(bf.readLine());

        for(int test_case = 1; test_case <= T; test_case++)
        {
            int N = Integer.parseInt(bf.readLine());
            int[] tree = new int[N];
            int result = 0;
            int max = 0;
            int odd = 0;
            int even = 0;
            PriorityQueue<Integer> pqOdd = new PriorityQueue<>();
            PriorityQueue<Integer> pqEven = new PriorityQueue<>();
            StringTokenizer st = new StringTokenizer(bf.readLine());
            for (int i = 0; i < N; i++) {
                tree[i] = Integer.parseInt(st.nextToken());
                max = Math.max(max,tree[i]);
            }
            for (int i = 0; i < N; i++) {
                int diff = max-tree[i];
                even += diff/2;
                odd += diff%2;
            }

            //even과 odd의 개수를 동등하게 맞춰준다.
            // odd가 더 많은 경우는 고려하지 않고 odd가 더 많다.
            while(even>odd+1){
                even-=1;
                odd+=2;
            }

            if(odd>even){
                result = odd*2-1;
            }else if(odd<=even){
                result = even*2;
            }

            System.out.println(test_case+" "+result);
        }
    }
}
