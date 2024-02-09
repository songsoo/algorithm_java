package BOJ.BruteForce.BackTracking.Gold.P15686;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {

    static int N,M,min,C;
    static boolean[] visited;
    static int[][] arr;
    static ArrayList<int[]> chichen, home;
    public static void main(String[] args) throws Exception{
        System.setIn(new FileInputStream("E:\\SSAFY9\\intelliJ_workspace\\algorithm_java\\src\\BOJ\\BruteForce\\BackTracking\\G5\\P15686\\input.txt"));
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        C = 0;
        min = Integer.MAX_VALUE;
        arr = new int[N][N];
        home = new ArrayList<>();
        chichen = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(bf.readLine());
            for (int j = 0; j < N; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
                if(arr[i][j]==2){
                    C++;
                    chichen.add(new int[]{i,j});
                }else if(arr[i][j]==1){
                    home.add(new int[]{i,j});
                }
            }
        }
        visited = new boolean[C];

        comb(0,0);

        System.out.println(min);
    }


    public static void comb(int cnt, int start){
        if(cnt==M){
            int cur = 0;
            for (int i = 0; i < home.size(); i++) {
                cur += getDist(i);
            }
            min = Math.min(min,cur);
        }
        for (int i = start; i < C; i++) {
            visited[i]=true;
            comb(cnt+1,i+1);
            visited[i]=false;
        }
    }
    public static int getDist(int cnt){

        int[] cur = home.get(cnt);
        int x = cur[0];
        int y = cur[1];

        int min=Integer.MAX_VALUE;

        for(int i=0;i<chichen.size();i++){
            int[] chk = chichen.get(i);
            if(!visited[i])continue;
            int dist = Math.abs(x-chk[0])+Math.abs(y-chk[1]);
            min = Math.min(min,dist);
        }
        return min;
    }
}
