package Test;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.StringTokenizer;

public class Main {
    static int R,C;
    static char[][] map;
    static int[] moveX= {0,1,1,1,0,0,0,-1,-1,-1}, moveY={0,-1,0,1,-1,0,1,-1,0,1};
    static ArrayList<Node> crazy;
    static Node player;
    public static void main(String[] args) throws Exception{

        System.setIn(new FileInputStream("D:\\IntelliJ_Repository\\src\\Test\\input.txt"));
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(bf.readLine());

        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());

        map = new char[R][C];
        crazy = new ArrayList<>();
        char idx='0';
        for (int i = 0; i < R; i++) {
            map[i] = bf.readLine().toCharArray();
            for (int j = 0; j < C; j++) {
                if(map[i][j]=='I'){
                    player = new Node(i, j);
                }else if(map[i][j]=='R'){
                    crazy.add(new Node(i, j));
                    map[i][j] = idx++;
                }
            }
        }

        char[] order = bf.readLine().toCharArray();
        boolean flag = true;
        int i = 0;
        loop:
        for (i = 0; i < order.length;) {
            char[][] nextMap = new char[R][C];
            for (int j = 0; j < R; j++) {
                Arrays.fill(nextMap[j],'.');
            }
            // 종수 움직임
            if(!move(order[i++]-'0')){
                flag = false;
                break;
            }
            nextMap[player.x][player.y] = 'I';
            // 미친 아두이노 종수와 가까운 방향으로 이동
            ArrayList<Integer> deleteList = new ArrayList<>();
            ArrayList<int[]> deleteLoc = new ArrayList<>();
            for(int j=0; j<crazy.size(); j++){
                Node cur = crazy.get(j);
                int xDiff = player.x - cur.x;
                int yDiff = player.y - cur.y;
                int nextX = cur.x + (xDiff>0?1:xDiff==0?0:-1);
                int nextY = cur.y + (yDiff>0?1:yDiff==0?0:-1);
                // 플레이어에게 도달하면 종료
                if(player.x == nextX && player.y==nextY){
                    flag = false;
                    break loop;
                }else if(nextMap[nextX][nextY]=='D'){
                    deleteList.add(j);
                }
                // 아두이노끼리 도달하면 삭제 리스트에 추가
                else if(nextMap[nextX][nextY]!='.'){
                    deleteList.add(j);
                    deleteList.add(nextMap[nextX][nextY]-'0');
                    deleteLoc.add(new int[]{nextX, nextY});
                    nextMap[nextX][nextY] = 'D';
                }else{
                    nextMap[nextX][nextY] = (char)('0'+j);
                    cur.x = nextX;
                    cur.y = nextY;
                }
            }
            // 삭제할 놈들 다 삭제하고
            Collections.sort(deleteList, Collections.reverseOrder());
            for (int cur : deleteList) {
                crazy.remove(cur);
            }
            for(int[] cur : deleteLoc){
                nextMap[cur[0]][cur[1]] = '.';
            }
            for (int j = 0; j < R; j++) {
                map[j] = Arrays.copyOf(nextMap[j],C);
            }
        }
        // 활동 종료 후
        if(flag){
            for (int j = 0; j < R; j++) {
                for (int k = 0; k < C; k++) {
                    System.out.print((map[j][k]=='I'||map[j][k]=='.')?map[j][k]:'R');
                }
                System.out.println();
            }
        }else{
            System.out.println("kraj "+i);
        }

    }
    public static void print(){
        for (int i = 0; i < R; i++) {
            for (int j = 0; j < C; j++) {
                System.out.print(map[i][j]);
            }
            System.out.println();
        }
        System.out.println(crazy.toString());
    }
    public static boolean move(int i){
        int nextX = player.x + moveX[i];
        int nextY = player.y + moveY[i];
        if(map[nextX][nextY]!='.' && i!=5){
            return false;
        }else{
            player.x = nextX;
            player.y = nextY;
            return true;
        }
    }
}
class Node{
    int x;
    int y;
    public Node(int x, int y) {
        this.x = x;
        this.y = y;
    }
}
