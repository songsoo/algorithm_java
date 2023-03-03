package Test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static char[][] map;
    static int N,M;
    static int[] moveX = {-1,0,1,0}, moveY = {0,-1,0,1};
    static int[] LocR, LocB;
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        for (int i = 0; i < N; i++) {
            map[i] = bf.readLine().toCharArray();
            for (int j = 0; j < M; j++) {
                if(map[i][j]=='R'){
                    LocR = new int[]{i,j};
                }
               else if(map[i][j]=='B'){
                    LocR = new int[]{i,j};
                }
            }
        }

    }
}
