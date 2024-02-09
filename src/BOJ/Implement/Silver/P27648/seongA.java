package BOJ.Implement.Silver.P27648;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class seongA {
    static int N, M, K;
    static int[][] arr;
    static boolean visited[][];
    static boolean isFinished = false;
    static int[] moveX = {1,0}, moveY={0,1};
    public static void main(String[] args) throws Exception{

        System.setIn(new FileInputStream("D:\\IntelliJ\\algorithm_java\\src\\Test\\input2.txt"));
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        arr = new int[N][M];
        StringBuilder sb = new StringBuilder();
        if(N+M-1 > K){
            sb.append("NO");
        }else {
            System.out.println("YES");
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < M; j++) {
                    sb.append((i+j+1)).append(" ");
                }
                sb.append("\n");
            }
        }
        System.out.println(sb.toString());
    }
}
