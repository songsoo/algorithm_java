package BOJ.BruteForce.DFS.Gold.P15683;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {
    static int N,M,result;
    static int[][] arr;
    static int[][] visited;
    static ArrayList<CCTV> cctv;
    static int[] dr ={1,0,-1,0},dc={0,1,0,-1};
    static int[][][] cctyTypes={
            // 0: 우 1: 하
            {{0}},
            {{0},{1},{2},{3}},
            {{0,2},{1,3}},
            {{0,1},{1,2},{2,3},{3,0}},
            {{3,0,1},{0,1,2},{1,2,3},{2,3,0}},
            {{0,1,2,3}}
    };
    public static void main(String[] args) throws Exception{
        System.setIn(new FileInputStream("E:\\SSAFY9\\intelliJ_workspace\\algorithm_java\\src\\BOJ\\BruteForce\\DFS\\G4\\P15683\\input.txt"));
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        result = N*M;
        visited = new int[N][M];
        cctv = new ArrayList<>();
        arr = new int[N][M];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(bf.readLine());
            for (int j = 0; j < M; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
                if(arr[i][j]>=1 && arr[i][j]<=5){
                    visited[i][j]++;
                    cctv.add(new CCTV(i,j,arr[i][j]));
                }else if(arr[i][j]==6){
                    result--;
                }
            }
        }

        goNext(0);
        System.out.println(result);

    }

    public static void goNext(int cnt){
        if(cnt==cctv.size()){
            int total = 0;
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < M; j++) {
                    if(visited[i][j]==0 && arr[i][j]!=6){
                        total++;
                    }
                }
            }
            result = Math.min(result,total);
            return;
        }
        CCTV cur = cctv.get(cnt);

        for (int i = 0; i < cctyTypes[cur.type].length; i++) {
            for (int j = 0; j < cctyTypes[cur.type][i].length; j++) {
                Go(cur.x,cur.y,cctyTypes[cur.type][i][j]);
            }
            goNext(cnt+1);
            for (int j = 0; j < cctyTypes[cur.type][i].length; j++) {
                Back(cur.x,cur.y,cctyTypes[cur.type][i][j]);
            }
        }

    }
    public static void Go(int r, int c, int d){
        while(true){
            int nr = r+dr[d];
            int nc = c+dc[d];
            if(!check(nr,nc))break;
            if(arr[nr][nc]==0)visited[nr][nc]++;
            r = nr;
            c = nc;
        }
    }
    public static void Back(int r, int c, int d){
        while(true){
            int nr = r+dr[d];
            int nc = c+dc[d];
            if(!check(nr,nc))break;
            if(arr[nr][nc]==0)visited[nr][nc]--;
            r = nr;
            c = nc;
        }
    }

    public static boolean check(int x, int y){
        if(x>=0 && x<N && y>=0 && y<M && arr[x][y]!=6){
            return true;
        }
        return false;
    }

    static class CCTV{
        int x;
        int y;
        int type;
        CCTV(int x, int y, int type){
            this.x = x;
            this.y = y;
            this.type = type;
        }
    }
}