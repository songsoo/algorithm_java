package Test;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.StringTokenizer;

public class Main {
    static int N, K;
    static int[][] map;
    static int[][] nodeLoc;
    static ArrayList<node> nodeList;
    static ArrayList<Integer>[] nodeStackList;
    static int[] moveX= {0,0,0,-1,1}, moveY={0,1,-1,0,0};
    static int[] changeDir = {0,2,1,4,3};
    public static void main(String[] args) throws Exception{

        System.setIn(new FileInputStream("D:\\IntelliJ_Repository\\src\\Test\\input.txt"));
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        nodeStackList = new ArrayList[K];
        map = new int[N][N];
        nodeLoc = new int[N][N];
        // 0은 흰색, 1은 빨간색, 2는 파란색
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(bf.readLine());
            for (int j = 0; j < N; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
            Arrays.fill(nodeLoc[i], -1);
        }
        for (int i = 0; i < K; i++) {
            nodeStackList[i] = new ArrayList<>();
        }

        nodeList = new ArrayList();
        boolean flag = false;
        // 행, 열, 방향
        // 방향은 오(1), 왼(2), 위(3), 아래(4)
        for(int i=0; i<K; i++){
            st = new StringTokenizer(bf.readLine());
            int x = Integer.parseInt(st.nextToken())-1;
            int y = Integer.parseInt(st.nextToken())-1;
            int dir = Integer.parseInt(st.nextToken());
            nodeList.add(new node(x, y, dir, i));
            nodeStackList[i].add(i);
            if(nodeLoc[x][y]!=-1){
                add(i, nodeLoc[x][y]);
                if(nodeStackList[nodeLoc[x][y]].size()>=4){
                    flag = true;
                    break;
                }
            }else{
                nodeLoc[x][y] = i;
            }

        }

        int cnt = 0;
        loop:
        while(!flag && ++cnt<1000){

            // 노드마다 반복
            for(node cur : nodeList){
                // 탑의 바텀일 경우에만 실행
                if(cur.isBottom){
                    int nextX = cur.x + moveX[cur.dir];
                    int nextY = cur.y + moveY[cur.dir];

                    // 갈 수 없거나 파란색이면 방향전환
                    if(!check(nextX, nextY) || map[nextX][nextY]==2){
                        cur.dir = changeDir[cur.dir];
                        nextX = cur.x + moveX[cur.dir];
                        nextY = cur.y + moveY[cur.dir];
                    }

                    // 그 다음에 또 파란색이면 멈춤
                    if(!check(nextX, nextY) || map[nextX][nextY]==2){
                        // 다음 위치로 이동하지 않으니 다음 위치를 현재 위치로 다시 옮김
                        nextX = cur.x;
                        nextY = cur.y;
                    }
                    // 빨간색이면 뒤집고 기존에 있던 것들 위에 추가, 4이상이면 종료
                    else if(map[nextX][nextY]==1){
                        int a = flip(cur.idx, nextX, nextY);
                        move(a, nextX, nextY);
                    }
                    // 기존에 있던 것들 위에 추가, 4이상이면 종료
                    else if(map[nextX][nextY]==0){
                        move(cur.idx, nextX, nextY);
                    }

                    if(nodeStackList[nodeLoc[nextX][nextY]].size()>=4){
                        break loop;
                    }


                }
                //print();
            }
        }
        if(cnt>=1000){
            cnt = -1;
        }

        System.out.println(cnt);


    }
    public static void print(){
        for (int i = 0; i < N; i++) {
            System.out.println(Arrays.toString(nodeLoc[i]));
        }
        System.out.println(nodeList.toString());
        System.out.println("--------------------");
    }
    public static boolean check(int x, int y){
        return x>=0 && x<N && y>=0 && y<N;
    }
    // 이동 시 from의 노드들은 isBottom을 모두 false처리
    public static void add(int from, int to){
        // 박혀있는 노드에 굴러온 노드의 스택들 전부 끼워넣기
        for(int cur : nodeStackList[from]){
            node fromNode = nodeList.get(cur);
            fromNode.isBottom = false;
            nodeStackList[to].add(fromNode.idx);
        }
        nodeStackList[from] = new ArrayList<>();
    }

    public static int flip(int idx, int x, int y){
        // 아래 노드와 윗 노드 가져오기
        node fromNode = nodeList.get(idx);
        node toNode = nodeList.get(nodeStackList[idx].get(nodeStackList[idx].size()-1));
        // 바닥 조건 변경
        fromNode.isBottom = false;
        toNode.isBottom = true;
        // 모든 노드 리스트에 대해서 리스트 번호 이동
        for(int i = nodeStackList[idx].size()-1 ; i>=0 ; i--){
            nodeStackList[toNode.idx].add(nodeStackList[idx].remove(i));
        }
        return toNode.idx;
    }
    public static void move(int idx, int x, int y){
        // 이동하려고 하는 노드
        node curNode = nodeList.get(idx);
        // 이전 위치는 -1로 변경
        nodeLoc[curNode.x][curNode.y] = -1;
        // 비어있으면
        if(nodeLoc[x][y] == -1){
            nodeLoc[x][y] = idx;
            curNode.x = x;
            curNode.y = y;
        }
        //다른게 있으면
        else{
            add(idx, nodeLoc[x][y]);
        }
    }

}
class node{
    int x;
    int y;
    int dir;
    int idx;
    boolean isBottom = true;

    public node(int x, int y, int dir, int idx) {
        this.x = x;
        this.y = y;
        this.dir = dir;
        this.idx = idx;
    }

    @Override
    public String toString() {
        return "node{" +
                "x=" + x +
                ", y=" + y +
                ", idx=" + idx +
                ", isBottom=" + isBottom +
                '}';
    }
}
