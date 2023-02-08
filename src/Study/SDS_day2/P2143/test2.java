package Study.SDS_day2.P2143;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class test2 {

    public static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws IOException{
        System.setIn(new FileInputStream("src/SDS.SDS_day2/P2143/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        int[] A = new int[1000];
        int[] B = new int[1000];

        int x1 = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i = 0; i < x1; i++){
            A[i] = Integer.parseInt(st.nextToken());
        }
        int x2 = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < x2; i++){
            B[i] = Integer.parseInt(st.nextToken());
        }
        HashMap<Integer, Integer> mapA = new HashMap<>(1000000);
        for(int i = 0; i < x1; i++){
            int sum = 0;
            for(int j = i; j < x1; j++){
                sum += A[j];
                Integer x = mapA.get(sum);
                if(x == null) mapA.put(sum, 1);
                else mapA.replace(sum, x + 1);
            }
        }

        long cnt = 0;
        for(int i = 0; i < x2; i++){
            int sum = 0;
            for(int j = i; j < x2; j++){
                sum += B[j];
                int ret = t - sum;
                Integer x = mapA.get(ret);
                if (x != null) {
                    cnt += x;
                }
            }
        }

        System.out.println(cnt);
    }
}