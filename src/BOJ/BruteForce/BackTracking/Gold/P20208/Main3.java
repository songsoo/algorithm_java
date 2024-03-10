package BOJ.BruteForce.BackTracking.Gold.P20208;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main3 {
    static int N, M, H, milkCnt, max;
    static boolean[] visited;
    static int[][] loc, dist;


    public static void main(String[] args) throws Exception{

        System.setIn(new FileInputStream("D:\\IntelliJ\\algo\\src\\Test\\input.txt"));
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        H = Integer.parseInt(st.nextToken());

        loc = new int[11][2];
        dist = new int[11][11];
        max = 0;
        milkCnt = 1;

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(bf.readLine());
            for (int j = 0; j < N; j++) {
                int cur = Integer.parseInt(st.nextToken());
                if(cur==2){
                    loc[milkCnt][0] = i;
                    loc[milkCnt][1] = j;
                    milkCnt++;
                }else if(cur==1){
                    loc[0][0] = i;
                    loc[0][1] = j;
                }
            }
        }

        for (int i = 0; i < milkCnt; i++) {
            for (int j = i+1; j < milkCnt; j++) {
                int distance = Math.abs(loc[i][0]-loc[j][0])+ Math.abs(loc[i][1]-loc[j][1]);
                dist[i][j] = distance;
                dist[j][i] = distance;
            }
        }
        visited = new boolean[11];
        dfs(0, 0, M);
        System.out.println(max-1);

    }

    public static void dfs(int index,int vilNum, int health){
        // 집으로 돌아왔을 때
        if(vilNum == 0 && visited[0]){
            max = Math.max(max, index);
            return;
        }
        for (int i = 0; i < milkCnt; i++) {
            // 아직 방문 안했고 갈 수 있다면
            if(!visited[i] && health-dist[vilNum][i] >= 0){
                visited[i] = true;
                dfs(index+1,i, (health-dist[vilNum][i]+H));
                visited[i] = false;
            }
        }
    }
}
