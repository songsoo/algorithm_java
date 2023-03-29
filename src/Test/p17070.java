package Test;

import jdk.internal.util.xml.impl.Input;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class p17070 {
    static int T;
    static int map[][];
    static int[][] checkX={{1},{1,1,0},{0}}, checkY={{0},{0,1,1},{1}};
    static int[] moveX={1,1,0}, moveY={0,1,1};
    public static void main(String[] args) throws Exception {
        System.setIn(new FileInputStream("E:\\SooHyeon\\intelliJWorkSpace\\algorithm_java\\src\\Test\\input.txt"));
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        T = Integer.parseInt(bf.readLine());
        map = new int[T][T];
        for (int i = 0; i < T; i++) {
            StringTokenizer st = new StringTokenizer(bf.readLine());
            for (int j = 0; j < T; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        bfs();

    }

    public static void bfs(){
        Queue<movePipe> queue = new LinkedList<>();
        queue.add(new movePipe(0,0,0));
        while(!queue.isEmpty()){
            movePipe cur = queue.poll();

            if(cur.x == T-1 && cur.y==T-1){
                System.out.println(cur.count);
                break;
            }
            loop:
            for (int i = 0; i < 3; i++) {
                for (int j = 0; j < checkX[i].length; j++) {
                    int nextX = cur.x + checkX[i][j];
                    int nextY = cur.x + checkY[i][j];
                    if(nextX<0 || nextX >=T || nextY<0 || nextY>=T || map[nextX][nextY]==1){
                        continue loop;
                    }
                }
                queue.add(new movePipe(cur.x+moveX[i],cur.y+moveY[i],cur.count+1));
            }

        }
    }
}
class movePipe{
    int x;
    int y;
    int count;

    public movePipe(int x, int y, int count) {
        this.x = x;
        this.y = y;
        this.count = count;
    }
}
