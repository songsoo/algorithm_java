package BOJ.Implement.Gold.P17780;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {
    // N : 맵 크기, K : 말 개수
    static int N, K;
    static int[] moveX= {0,0,0,-1,1}, moveY={0,1,-1,0,0};
    static int[] changeDir = {0,2,1,4,3};
    static int[][] map;
    static ArrayList<node>[][] nodeLoc;
    static node[] nodeInfo;

    public static void main(String[] args) throws Exception {

        System.setIn(new FileInputStream("D:\\IntelliJ_Repository\\src\\Test\\input.txt"));
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        map = new int[N][N];
        nodeLoc = new ArrayList[N][N];
        nodeInfo = new node[K+1];

        // 0: 흰 1: 빨 2: 파
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(bf.readLine());
            for (int j = 0; j < N; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                nodeLoc[i][j] = new ArrayList<node>();
            }
        }

        // 1 : 우, 2: 좌, 3: 상, 4: 하
        for (int i = 1; i < K+1; i++) {
            st = new StringTokenizer(bf.readLine());
            int x = Integer.parseInt(st.nextToken())-1;
            int y = Integer.parseInt(st.nextToken())-1;
            int dir = Integer.parseInt(st.nextToken());
            node cur = new node(x, y, dir, i);
            nodeInfo[i] = cur;
            nodeLoc[x][y].add(cur);
        }

        int turn = 1;
        loop:
        while(turn < 1000){
            // 각 노드번호마다 돌면서
            //System.out.println("turn "+turn+"---------------------------");
            for (int i = 1; i < K+1; i++) {
                //System.out.println(i+"번째 노드");
                // nodeInfo의 x,y를 파악해서 0번째가 cur이 맞는지 확인 후
                // 0번째가 아니면 아무것도 하지 않고
                // 0번째라면 이동한다.
                // 이동하려는 곳이 파란색이면
                    // 방향 전환하고
                // 전환한 곳이 또 파란색이면 이동 취소
                // 전환한 곳이 빨간색이면 현재의 것을 옮길 때 순서 변경 후 이동
                // 이동할 때 위에 있는 모든 식구들 다 같이 이동한다.
                node curNode = nodeInfo[i];
                int x = curNode.x;
                int y = curNode.y;
                int nextX = x + moveX[curNode.dir];
                int nextY = y + moveY[curNode.dir];
                //System.out.println("현재 위치: "+x+","+y+" 이동할 위치: "+nextX+","+nextY);
                if(nodeLoc[x][y].get(0).idx==i){
                    // 다음 노드가 파란색이면 이동할 방향 변경
                    boolean blueFlag = false;
                    if(!check(nextX,nextY) || map[nextX][nextY]==2){
                        blueFlag = true;
                        curNode.dir = changeDir[curNode.dir];
                        nextX = x + moveX[curNode.dir];
                        nextY = y + moveY[curNode.dir];
                        //System.out.println("파랑 도달! 이동할 위치: "+nextX+","+nextY);

                    }

                    if(!check(nextX,nextY) || map[nextX][nextY]==2){
                        //System.out.println("파랑 재 도달");
                    }
                    else if(map[nextX][nextY]==1){
                        //System.out.println("빨강 도달");
                        for(int j=nodeLoc[x][y].size()-1; j>=0; j--){
                            node nextNode = nodeLoc[x][y].get(j);
                            nextNode.x = nextX;
                            nextNode.y = nextY;
                            nodeLoc[nextX][nextY].add(nextNode);
                        }
                        nodeLoc[x][y] = new ArrayList<node>();
                    }
                    else if(map[nextX][nextY]==0){
                        //System.out.println("하양 도달");
                        for (node nextNode : nodeLoc[x][y]){
                            nextNode.x = nextX;
                            nextNode.y = nextY;
                            nodeLoc[nextX][nextY].add(nextNode);
                        }
                        nodeLoc[x][y] = new ArrayList<node>();
                    }
                }
                if(check(nextX,nextY)){
                    //System.out.println("변경 위치: "+nodeLoc[nextX][nextY]);
                }

                if(check(nextX,nextY) && nodeLoc[nextX][nextY].size()>=4){
                    break loop;
                }
            }
            turn++;
        }
        System.out.println(turn>=1000?-1:turn);

    }
    public static boolean check(int x, int y){
        return x>=0 && x<N && y>=0 && y<N;
    }
}
class node{
    int x;
    int y;
    int dir;
    int idx;


    public node(int x, int y, int dir, int idx) {
        this.x = x;
        this.y = y;
        this.idx = idx;
        this.dir = dir;
    }

    @Override
    public String toString() {
        return this.idx+"노드 ("+this.x+","+this.y+")";
    }
}
