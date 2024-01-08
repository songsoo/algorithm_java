package BOJ.SimpleSilver.P1027;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static int arr[];
    static int count[];
    static int N;
    public static void main(String[] args) throws Exception{
        System.setIn(new FileInputStream("D:\\IntelliJ\\algo\\src\\Test\\input.txt"));

        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(bf.readLine());
        arr = new int[N];
        count = new int[N];
        StringTokenizer st = new StringTokenizer(bf.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        int max = 0;
        for (int i = 0; i < N-1; i++) {
            // 기울기가 무조건 커야지 보인다.
            double maxIncli = (arr[i+1]-arr[i]);
            count[i+1]++;
            count[i]++;
            for (int j = i+2; j < N; j++) {
                double curIncli = (arr[j]-arr[i]) / (double)(j-i);
                if(maxIncli < curIncli){
                    count[j]++;
                    count[i]++;
                    maxIncli = curIncli;
                }
                System.out.println(i+","+j+","+curIncli+ Arrays.toString(count));
            }
            max = Math.max(max,count[i]);
        }
        max = Math.max(max,count[N-1]);
        System.out.println(max);
    }
}
