package Test;


import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static int N, K;
    static ArrayList<int[]> dots;
    static int[][][] dist;
    static final int INF = 10000001;
    public static void main(String[] args) throws Exception{

        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        dots = new ArrayList<>();
        dist = new int[N][N][K];

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                Arrays.fill(dist[i][j], INF);
            }
        }

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(bf.readLine());
            dots.add(new int[]{ Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())});;
        }
        for (int i = 0; i < N; i++) {
            for (int j = i+1; j < N+K; j++) {
                if(j>=N){
                    break;
                }
                dist[i][j][K] = getDist(i, j);
            }
        }

        System.out.println(dfs(0, K));

    }

    public static int getDist(int i, int j){
        if(j>=N){
            return INF;
        }
        int[] dotOne = dots.get(i);
        int[] dotTwo = dots.get(j);
        return Math.abs(dotOne[0]-dotTwo[0])+ Math.abs(dotOne[1]-dotTwo[1]);
    }

    // cnt : 남은 스킵 횟수
    public static int dfs(int cur, int cnt){
        if(cur>N){
            return INF;
        }
        if(cur == N){
            return 0;
        }
        int min = INF;
        // 사용할 수 있는 스킵만큼만 사용
        for (int i = 0; i < cnt; i++) {
            // 사용할 수 있는 스킵보다 더 많이 쓰면
            int next = cur + i + 1;
            if(next>=N){
                break;
            }
            int one = dist[cur][next][cnt];
            int two = INF;
            // 아직 방문하지 않았다면
            if(dist[next][N-1][cnt]>=INF){
                two = dfs(next, cnt-i);
                //dist[next][N-1] = two;
            }else{
                //two = dist[next][N-1];
            }
            min = Math.min(min, one + two);
        }
        return min;
    }
}
