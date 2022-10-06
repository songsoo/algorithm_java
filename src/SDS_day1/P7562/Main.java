package SDS_day1.P7562;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Main {
    static int C,i;
    static int[] start,end;
    static int[] moveX = {1,2,2,1,-1,-2,-2,-1};
    static int[] moveY = {2,1,1,2,-2,-1,-1,-2};
    static boolean visited[][];

    static LinkedList<int[]> queue;

    public static void main(String[] args) throws Exception{
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());

        C = Integer.parseInt(st.nextToken());

        for (int j = 0; j < C; j++) {

            start = new int[2];
            end = new int[2];

            st = new StringTokenizer(bf.readLine());
            i = Integer.parseInt(st.nextToken());

            st = new StringTokenizer(bf.readLine());
            start[0] = Integer.parseInt(st.nextToken());
            start[1] = Integer.parseInt(st.nextToken());

            st = new StringTokenizer(bf.readLine());
            end[0] = Integer.parseInt(st.nextToken());
            end[1] = Integer.parseInt(st.nextToken());

            System.out.println(C + " " + i + " " + start[0]+" "+start[1] + " " + end[0]+" " + end[1]);

            visited = new boolean[i][];
            queue = new LinkedList<int[]>();
            for(int k=0;k<i;k++){
                visited[k] = new boolean[i];
            }


            queue.add(start);

            while(!queue.isEmpty()){
                int[] a = queue.poll();
                bfs(a[0],a[1],0);
            }

        }

    }


    public static void bfs(int x, int y,int result){
        if(!visited[x][y]){
            visited[x][y] = true;
            if(x==end[0] && y == end[1]){
                System.out.println(result);
                return;
            }

            for(int j=0;j<8;j++){
                int nextX = x + moveX[j];
                int nextY = y + moveY[j];
                if(nextX>=0 && nextX<i && nextY>=0 && nextY<i){
                    int[] next = {nextX,nextY,++result};
                    queue.add(next);
                }
            }
        }
    }
}
