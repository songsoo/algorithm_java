package SDS.SDS_day1.P3055;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

class queueInf{

    char state;
    int row;
    int col;

    queueInf(){
    }

    queueInf(char state, int row, int col){
        this.state = state;
        this.row=row;
        this.col=col;
    }

    public void setValue(char state, int row, int col) {
        this.state = state;
        this.row=row;
        this.col=col;
    }

    public char getState() {
        return state;
    }
    public int getRow() {
        return row;
    }
    public int getCol() {
        return col;
    }
}

public class test {

    static int R, C,result;
    static char map[][];
    static int mapCount[][];
    static int dx[] = {0,0,-1,1};
    static int dy[] = {-1,1,0,0};
    static boolean canSurvive;



    public static void showMap() {
        for(int i=0;i<R;i++) {
            for(int j=0;j<C;j++) {
                System.out.print(map[i][j]);
            }
            System.out.println();
        }
    }

    public static void main(String[] args) throws IOException {
        // TODO Auto-generated method stub

        System.setIn(new FileInputStream("src/SDS.SDS_day1/P3055/input.txt"));

        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        String Line = bf.readLine();
        StringTokenizer st = new StringTokenizer(Line, " ");

        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        result = Integer.MAX_VALUE;

        map = new char[R][C];
        mapCount = new int[R][C];
        Queue<queueInf> queue = new LinkedList<>();
        queueInf water,runner;

        runner = new queueInf();

        for (int i = 0; i < R; i++) {
            Line = bf.readLine();
            st = new StringTokenizer(Line, "");
            String token = st.nextToken();
            for (int j = 0; j < C; j++) {
                map[i][j] = token.charAt(j);
                mapCount[i][j] = 0;
                if(token.charAt(j)=='*'){
                    water = new queueInf();
                    water.setValue('*', i, j);
                    queue.add(water);
                }else if(token.charAt(j)=='S'){
                    runner.setValue('S', i, j);
                }
            }
        }




        queue.add(runner);

        while(!queue.isEmpty()) {

            queueInf temp = queue.poll();
            int row = temp.getRow();
            int col = temp.getCol();
            char state = temp.getState();

            if(state=='*') {
                for(int i=0;i<4;i++) {
                    if(row+dx[i]>=0&&row+dx[i]<R&&col+dy[i]>=0&&col+dy[i]<C) {
                        if(map[row+dx[i]][col+dy[i]]!='X'&&map[row+dx[i]][col+dy[i]]!='D'&&map[row+dx[i]][col+dy[i]]!='*') {
                            map[row+dx[i]][col+dy[i]] = '*';
                            queueInf newInf = new queueInf('*',row+dx[i],col+dy[i]);
                            queue.add(newInf);
                        }
                    }
                }
            }else if (state=='S') {
                for(int i=0;i<4;i++) {
                    if(row+dx[i]>=0&&row+dx[i]<R&&col+dy[i]>=0&&col+dy[i]<C) {
                        if(map[row+dx[i]][col+dy[i]]=='D') {
                            canSurvive = true;
                            result = Math.min(result, mapCount[row][col]+1);
                        }
                        if (map[row + dx[i]][col + dy[i]] == '.') {
                            //새로운 곳으로 이동
                            map[row+dx[i]][col+dy[i]] = 'S';

                            mapCount[row+dx[i]][col+dy[i]] = mapCount[row][col]+1;

                            queueInf newInf = new queueInf('S',row+dx[i],col+dy[i]);
                            queue.add(newInf);
                        }
                    }
                }
            }
        }

        if(canSurvive) {
            System.out.println(result);
        }else {
            System.out.println("KAKTUS");
        }

    }

}
