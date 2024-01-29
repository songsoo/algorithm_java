package BOJ.BinarySearch.P17124;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class P17124 {
    static int[] A,B;
    static int N,M;
    public static void main(String[] args) throws Exception{
        System.setIn(new FileInputStream("D:\\IntelliJ\\algo\\src\\Test\\input.txt"));
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(bf.readLine());

        for (int test_case = 0; test_case < T; test_case++) {
            StringTokenizer st = new StringTokenizer(bf.readLine());
            N = Integer.parseInt(st.nextToken());
            M = Integer.parseInt(st.nextToken());
            A = new int[N];
            B = new int[M];

            st = new StringTokenizer(bf.readLine());
            for (int i = 0; i < N; i++) {
                A[i] = Integer.parseInt(st.nextToken());
            }
            st = new StringTokenizer(bf.readLine());
            for (int i = 0; i < M; i++) {
                B[i] = Integer.parseInt(st.nextToken());
            }

            Arrays.sort(A);
            Arrays.sort(B);

            long sum = 0;
            for (int i = 0; i < N; i++) {
                int left_index = 0;
                int index = Arrays.binarySearch(B,A[i]);

                if(index<0){
                    index = -(index+1);
                }
                if(index>=M){
                    index--;
                }

                if(index>0){
                    left_index = index-1;
                }

                if(Math.abs(A[i]-B[index])<Math.abs(A[i]-B[left_index])){
                    sum += B[index];
                }else{
                    sum += B[left_index];
                }
            }
            System.out.println(sum);
        }
    }

}