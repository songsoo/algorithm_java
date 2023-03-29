package SWEA.D4.P8382;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Solution {
    static boolean[][][] visited;
    static int[] start, end;
    static int[] moveX={-1,0,1,0}, moveY={0,-1,0,1};
    public static void main(String[] args) throws Exception{
        System.setIn(new FileInputStream("E:\\SooHyeon\\intelliJWorkSpace\\algorithm_java\\src\\Test\\Input.txt"));
        BufferedReader bf= new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(bf.readLine());

        for (int test_case = 1; test_case <= T; test_case++) {
            visited = new boolean[201][201][2];
            StringTokenizer st = new StringTokenizer(bf.readLine());
            start = new int[]{Integer.parseInt(st.nextToken())+100, Integer.parseInt(st.nextToken())+100};
            end = new int[]{Integer.parseInt(st.nextToken())+100, Integer.parseInt(st.nextToken())+100};

            System.out.print("#"+test_case+" ");
            bfs(start, end);
        }
    }

    public static void bfs(int[] start, int[] end){

        Queue<move> queue = new LinkedList<>();
        queue.add(new move(start[0],start[1],0,1));
        queue.add(new move(start[0],start[1],1,1));
        visited[start[0]][start[1]][0] = true;
        visited[start[0]][start[1]][1] = true;

        //dir가 짝수면 x, 홀수면 y움직임
        loop:
        while(!queue.isEmpty()){
            //뽑아서 visited 확인하고
            move cur = queue.poll();
            if(cur.x == end[0] && cur.y==end[1]){
                System.out.println(cur.count-1);
                break loop;
            }
            for (int i = ((cur.dir+1)%2); i < 4; i+=2) {
                int nextX = cur.x+moveX[i];
                int nextY = cur.y+moveY[i];
                if(check(nextX, nextY, i%2)){
                    if(nextX == end[0] && nextY==end[1]){
                        System.out.println(cur.count);
                        break loop;
                    }
                    visited[nextX][nextY][i%2] = true;
                    queue.add(new move(nextX, nextY, i%2, cur.count+1));
                }
            }
        }
    }

    // 짝수면 x, 홀수면 y움직임인데 반대로 움직이는거 적용
    public static boolean check(int x, int y, int dir){
        if(x>=0 && x<201 && y>=0 && y<201 && !visited[x][y][dir]){
            return true;
        }
        return false;
    }
}
class move{
    int x;
    int y;
    int dir;
    int count;

    public move(int x, int y, int dir, int count) {
        this.x = x;
        this.y = y;
        this.dir = dir;
        this.count = count;
    }
}