package SWEA.Test.P5658;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class Main {
    static int T, N, K;
    public static void main(String[] args) throws IOException {
        System.setIn(new FileInputStream("C:\\Users\\SSAFY\\IdeaProjects\\algorithm_java\\src\\SWEA\\Test\\P5658\\input.txt"));
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        T = Integer.parseInt(bf.readLine());
        for (int test_case = 1; test_case <= T ; test_case++) {
            StringTokenizer st = new StringTokenizer(bf.readLine());
            N = Integer.parseInt(st.nextToken());
            K = Integer.parseInt(st.nextToken());

            char[] num1 = bf.readLine().toCharArray();
            long[] num2 = new long[N];
            for (int i = 0; i < N; i++) {
                num2[i] = Integer.parseInt(num1[i]+"",16);
            }
            ArrayList<Long> list = new ArrayList<>();
            int start = 0;
            int NK = N/4;

            while(start<NK){
                int i=start;
                int cnt = 1;
                long sum = (long)Math.pow(16,N/4-cnt)*num2[i++];
                //long sum = (long)Math.pow(10,N/4-cnt)*num2[i++];
                while(true){
                    System.out.println(i);
                    if(cnt==N/4){
                        if(!list.contains(sum)){
                            list.add(sum);
                        }
                        sum = 0;
                        cnt = 0;
                        if(i==start){
                            break;
                        }
                    }
                    sum += (long)Math.pow(16,N/4-cnt-1)*num2[i++];
                    //sum += (long)Math.pow(10,N/4-cnt-1)*num2[i++];
                    if(i==N){
                        i=0;
                    }
                    cnt++;
                }
                start++;
            }
            Collections.sort(list,Collections.reverseOrder());
            System.out.println(list.toString());
            System.out.println("#"+test_case+" "+list.get(K-1));
        }
    }
}
