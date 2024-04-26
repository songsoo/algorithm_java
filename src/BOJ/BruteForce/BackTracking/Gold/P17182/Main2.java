package BOJ.BruteForce.BackTracking.Gold.P17182;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.*;

public class Main2 {

    static int N, K;
    static int[][] arr;
    static int[][] dp;
    public static void main(String[] args) throws Exception{

        System.setIn(new FileInputStream("D:\\IntelliJ_Repository\\src\\Test\\input.txt"));
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());

        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        dp = new int[1<<N][N];
        arr = new int[N][N];

        for (int i = 0; i < 1<<N; i++) {
            Arrays.fill(dp[i], Integer.MAX_VALUE);
        }

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(bf.readLine());
            for (int j = 0; j < N; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }

        }

        Queue<route> queue = new LinkedList<>();
        dp[1<<K][K] = 0;
        int min = Integer.MAX_VALUE;
        queue.add(new route(K, 0 , 1<<K));
        while(!queue.isEmpty()){
            route cur = queue.poll();
            // 최종 목적지일 경우
            if(cur.visited == ((1<<N)-1)){
                min = Math.min(min, cur.length);
            }
            // 최종 목적지가 아닐 경우
            else{
                // 다음 행선지를 모두 확인해서 방문 기록 대비 해당 위치의 dp값이 더 작으면 간다.
                for (int i = 0; i < N; i++) {
                    int nextVisit = (cur.visited | 1<<i);
                    int nextLength = cur.length + arr[cur.cur][i];
                    if(dp[nextVisit][i] > nextLength){
                        dp[nextVisit][i] = nextLength;
                        queue.add(new route(i, nextLength, nextVisit));
                    }
                }

            }
        }
        System.out.println(min);

    }

}
class route{
    int cur;
    int length;
    int visited;

    public route(int cur, int length, int visited) {
        this.cur = cur;
        this.length = length;
        this.visited = visited;
    }


}
