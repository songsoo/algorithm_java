package BOJ.Graph.ShortestPath.FloydWarshall.P1238;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    static int N,M,X;
    static long map[][];
    public static void main(String[] args) throws Exception{

        System.setIn(new FileInputStream("D:\\IntelliJ\\algo\\src\\Test\\input.txt"));

        BufferedReader bf= new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        X = Integer.parseInt(st.nextToken());

        map = new long[N+1][N+1];

        for (int i = 0; i < N+1; i++) {
            Arrays.fill(map[i],1000000);
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(bf.readLine());
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            long length = Long.parseLong(st.nextToken());
            map[from][to] = length;
        }
        for (int k = 1; k < N+1; k++) {
            for (int i = 1; i < N+1; i++) {
                for (int j = 1; j < N+1; j++) {
                    if(i==j || j==k) continue;
                    map[i][j] = Math.min(map[i][j], map[i][k]+map[k][j]);
                }
            }
        }



        long max = 0;
        for (int i = 1; i < N+1; i++) {
            if(i==X)continue;
            max = Math.max(max, map[i][X]+map[X][i]);
        }

        System.out.println(max);

    }
}
