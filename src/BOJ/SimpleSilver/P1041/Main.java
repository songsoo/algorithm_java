package BOJ.SimpleSilver.P1041;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static long N;
    static int arr[];
    static int[] notMeet = {5, 4, 3, 2, 1 ,0};
    public static void main(String[] args) throws Exception{
        System.setIn(new FileInputStream("D:\\IntelliJ\\algo\\src\\Test\\input.txt"));
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        N = Long.parseLong(bf.readLine());
        // N이 1일 때
        // 전부
        // N이 2이상일 때
        // 상단의 모서리 : 3면 , 4개
        // 상단의 옆면 : 2면 , (N-2) * 4
        // 상단의 윗면 : 1면 , (N-2) ^ 2
        // 하단의 옆면 : 2면 , (N-1) * 4
        // 하단의 중간 : 1면 , (N-2) * (N-1) * 4 = 4*N^2 - 12N + 8
        // 3면 : 4
        // 2면 : (2N-3) * 4
        // 1면 : 5 * N^2 - 16N + 12

        StringTokenizer st = new StringTokenizer(bf.readLine());
        arr = new int[6];
        for (int i = 0; i < 6; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        if(N==1){
            int max = arr[0];
            int sum = arr[0];
            for (int i = 1; i < 6; i++) {
                sum += arr[i];
                max = Math.max(max, arr[i]);
            }
            System.out.println(sum - max);
        }else{
            // 2면의 최소
            long min3 = Long.MAX_VALUE;
            long min2 = Long.MAX_VALUE;
            long min = Long.MAX_VALUE;
            for (int i = 0; i < 6; i++) {
                int num1 = arr[i];
                min = Math.min(min, num1);
                for (int j = i+1; j < 6; j++) {
                    if(notMeet[i]==j)continue;
                    int num2 = num1 + arr[j];
                    min2 = Math.min(min2, num2);
                    for (int k = j+1; k < 6; k++) {
                        if(notMeet[i]==k || notMeet[j]==k)continue;
                        int num3 = num2 + arr[k];
                        min3 = Math.min(min3, num3);
                    }
                }
            }

            long coe3 = 4l;
            long coe2 = (2l*N-3l) * 4l;
            long coe1 = 5*(long)Math.pow(N,2) - 16l*N +12l;
            long result = coe3*min3 + coe2 * min2 + coe1 * min;
            System.out.println(result);
        }

    }
}
