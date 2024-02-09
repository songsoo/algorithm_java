package BOJ.BruteForce.BFS.Gold.P1938;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;

public class P1938 {
    static int n;
    static int[] moveX= {-1,0,1,0}, moveY= {0,-1,0,1};
    static char[][] arr;
    static int sx,sy,ex,ey;
    static boolean estand,sstand;
    static boolean[][] visitedT, visitedF;
    public static void main(String[] args) throws Exception {

        System.setIn(new FileInputStream("C:\\Users\\SSAFY\\IdeaProjects\\algorithm_java\\src\\Test\\input.txt"));
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(bf.readLine());
        arr = new char[n][n];
        visitedT = new boolean[n][n];
        visitedF = new boolean[n][n];
        int scnt = 0, ecnt=0;

        for (int i = 0; i < n; i++) {
            arr[i] = bf.readLine().toCharArray();
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if(arr[i][j]=='B'&&++scnt==2) {
                    sx=i;
                    sy=j;
                    if(check(i+1,j) && arr[i+1][j]=='B') {
                        sstand=true;
                    }else if(check(i,j+1) && arr[i][j+1]=='B') {
                        sstand=false;
                    }
                }
                else if(arr[i][j]=='E'&&++ecnt==2) {
                    ex=i;
                    ey=j;
                    if(check(i+1,j) && arr[i+1][j]=='E') {
                        estand=true;
                    }else if(check(i,j+1) &&arr[i][j+1]=='E') {
                        estand=false;
                    }
                }
            }
        }
        bfs(new stick(sstand,sx,sy,0));

    }

    // 기둥을 도착지점으로 이동하는 bfs 함수
    // 주어진 조건에 따라 기둥을 이동하며 도착지점까지 이동하며
    // 기둥을 조작한 count를 출력한다 (도착할 수 없다면 0을 출력한다.)
    public static void bfs(stick a) {

        Queue<stick> queue = new ArrayDeque<>();
        queue.add(a);
        int cnt=0;
        while(!queue.isEmpty()) {

            stick cur = queue.poll();
            System.out.println(cur.x+" "+cur.y+" "+cur.isStand+" "+cur.cnt);

            if(cur.x == ex && cur.y == ey && cur.isStand==estand) {
                cnt = cur.cnt;
                break;
            }

            for (int i = 0; i < 4; i++) {
                int nextX = cur.x+moveX[i];
                int nextY = cur.y+moveY[i];

                if(check2(nextX,nextY,cur.isStand) && isMovable(nextX,nextY,cur.isStand)) {
                    if (cur.isStand && !visitedT[nextX][nextY]) {
                        visitedT[nextX][nextY] = true;
                        queue.add(new stick(cur.isStand, nextX, nextY, cur.cnt + 1));
                    } else if (!cur.isStand && !visitedF[nextX][nextY]) {
                        visitedF[nextX][nextY] = true;
                        queue.add(new stick(cur.isStand, nextX, nextY, cur.cnt + 1));
                    }
                }
            }

            if(check2(cur.x,cur.y,!cur.isStand)&&isRotatable(cur.x,cur.y)) {
                if(cur.isStand && !visitedF[cur.x][cur.y]) {
                    visitedF[cur.x][cur.y] = true;
                    queue.add(new stick(false,cur.x,cur.y,cur.cnt+1));
                }else if(!cur.isStand && !visitedT[cur.x][cur.y]) {
                    visitedT[cur.x][cur.y] = true;
                    queue.add(new stick(true,cur.x,cur.y,cur.cnt+1));
                }
            }

        }


        System.out.println(cnt);

    }

    // 주어진 x,y위치를 기준으로 3*3 배열에 1이 있는지 확인하는 메서드
    public static boolean isRotatable(int x, int y) {
        for (int i = -1; i < 2; i++) {
            if(x+i<0 || x+i>=n) {
                break;
            }
            for (int j = -1; j < 2; j++) {
                if(y+j<0 || y+j>=n) {
                    break;
                }
                if(arr[x+i][y+j]=='1') {
                    return false;
                }
            }
        }
        return true;
    }

    // 주어진 x,y위치와 기둥의 방향에 따라 기둥의 위치에 '1'이 있는지 확인하는 메서드
    public static boolean isMovable(int x, int y, boolean stand) {

        if(stand) {
            if(arr[x-1][y]!='1' && arr[x][y]!='1' && arr[x+1][y]!='1') {
                return true;
            }
        }else {
            if(arr[x][y-1]!='1' && arr[x][y]!='1' && arr[x][y+1]!='1') {
                return true;
            }
        }
        return false;
    }

    // 주어진 x,y가 배열의 범위를 벗어나는지 확인하는 메서드
    public static boolean check(int x, int y) {
        if(x>=0 && x<n && y>=0 && y<n) {
            return true;
        }
        return false;
    }

    // 주어진 x,y,기둥 방향에 따라 기둥이 범위를 벗어나는지 확인하는 메서드
    public static boolean check2(int x, int y, boolean stand) {
        if(stand) {
            if(x>=1 && x<n-1 && y>=0 && y<n && arr[x][y]!='1' && arr[x-1][y]!='1' && arr[x+1][y]!='1') {
                return true;
            }
        }else {
            if(x>=0 && x<n && y>=1 && y<n-1 && arr[x][y]!='1' && arr[x][y-1]!='1' && arr[x][y+1]!='1') {
                return true;
            }
        }
        return false;
    }


}
// 기둥의 정보를 저장하는 클래스
// 기둥의 방향, x y 좌표, 기둥 이동 count를 저장한다.
class stick{

    boolean isStand;
    int x;
    int y;
    int cnt;

    public stick(boolean isStand, int x, int y, int cnt) {
        super();
        this.isStand = isStand;
        this.x = x;
        this.y = y;
        this.cnt = cnt;
    }



}