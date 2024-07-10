package BOJ.Graph.ShortestPath.FloydWarshall.P1613;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main2 {
    static int n, k;
    static boolean dist[][];
    static ArrayList<Integer> arr[];
    public static void main(String[] args) throws Exception{

        System.setIn(new FileInputStream("D:\\IntelliJ_Repository\\src\\Test\\input.txt"));
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());
        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());
        int MAX = 10000;
        dist = new boolean[n+1][n+1];
        arr = new ArrayList[n+1];

        for (int i = 0; i < n+1; i++) {
            arr[i] = new ArrayList<>();
            Arrays.fill(dist[i], false);
            dist[i][i] = true;
        }

        for (int i = 0; i < k; i++) {
            st = new StringTokenizer(bf.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            dist[a][b] = true;
        }

        for (int k = 1; k < n+1; k++) {
            for (int i = 1; i < n+1; i++) {
                if(i==k){
                    continue;
                }
                for (int j = 1; j < n+1; j++) {
                    if(i==k || j==k){
                        continue;
                    }
                    if(!dist[i][j] && dist[i][k] && dist[k][j]){
                        dist[i][j] = true;
                    }
                }
            }
        }

        int s = Integer.parseInt(bf.readLine());
        for (int i = 0; i < s; i++) {
            st = new StringTokenizer(bf.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            if(!dist[a][b] && !dist[b][a]){
                System.out.println(0);
            }else if(dist[a][b]){
                System.out.println(-1);
            }else{
                System.out.println(1);
            }
        }


    }

}
