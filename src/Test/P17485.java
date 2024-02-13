package Test;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class P17485 {
    static int map[][], cnt[][], N, M, min;
    public static void main(String[] args) throws Exception{

        System.setIn(new FileInputStream("D:\\IntelliJ\\algo\\src\\Test\\input.txt"));
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        
        map = new int[N+2][M];
        cnt = new int[N+2][M];

        for (int i = 1; i < N+1; i++) {
            st = new StringTokenizer(bf.readLine());
            for (int j = 0; j < M; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        for (int i = 1; i < N+2; i++) {
            Arrays.fill(cnt[i], 100001);
        }
        for (int i = 0; i < 4; i++) {
            dfs(0, 4, -1);
        }

        System.out.println(min);
    }
    
    public static void dfs(int r, int c, int dir){
        print();
        if(r==N+1){
            min = Integer.MAX_VALUE;
            for (int i = 0; i < 4; i++) {
                System.out.println(cnt[r][i]);
                min = Math.min(min, cnt[r][i]);
            }
            return;
        }
        for (int i = 0; i < M; i++) {
            for (int j = -1; j < 2; j++) {
                if(i+j<0 || i+j>=M){
                    continue;
                }
                //int c = i+j;
                cnt[r+1][c] = Math.min(cnt[r+1][c], cnt[r][i]+map[r+1][c]);
            }
        }
        //dfs(r+1);
    }

    public static void print(){
        for (int i = 0; i < N+2; i++) {
            for (int j = 0; j < M; j++) {
                System.out.print(cnt[i][j]+" ");
            }
            System.out.println();
        }
        System.out.println("-------------");
    }
}
