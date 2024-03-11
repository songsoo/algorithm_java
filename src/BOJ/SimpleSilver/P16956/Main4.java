package BOJ.SimpleSilver.P16956;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main4 {
    static int R,C;
    static char[][] map;
    static int[] moveX = {-1,0,1,0}, moveY={0,-1,0,1};
    public static void main(String[] args) throws Exception{
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());

        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());

        map = new char[R][C];

        for (int i = 0; i < R; i++) {
            map[i] = bf.readLine().toCharArray();
        }

        boolean flag = true;

        loop:
        for (int i = 0; i < R; i++) {
            for (int j = 0; j < C; j++) {
                if(map[i][j] == 'S'){
                    for (int k = 0; k < 4; k++) {
                        int nextX = i + moveX[k];
                        int nextY = j + moveY[k];

                        if(check(nextX, nextY)){
                            if(map[nextX][nextY] == 'W'){
                                flag = false;
                                break loop;
                            }
                            if(map[nextX][nextY]=='.'){
                                map[nextX][nextY] = 'D';
                            }
                        }
                    }
                }
            }
        }

        System.out.println(flag?1:0);
        if(flag){
            for (int i = 0; i < R; i++) {
                for (int j = 0; j < C; j++) {
                    System.out.print(map[i][j]);
                }
                System.out.println();
            }
        }
    }

    public static boolean check(int x, int y){
        return x>=0 && x<R && y>=0 && y<C;
    }
}
