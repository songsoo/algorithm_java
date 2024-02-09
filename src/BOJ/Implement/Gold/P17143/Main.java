package BOJ.Implement.Gold.P17143;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Main {
    static int R, C , M;
    static int[][] arr;
    static HashMap<Integer, shark> sharks;
    // 1이 위, 2는 아래, 3은 오른, 4는 왼쪽
    static int[] moveX = {0,-1,1,0,0}, moveY= {0,0,0,1,-1};
    public static void main(String[] args) throws IOException {
        System.setIn(new FileInputStream("C:\\Users\\SSAFY\\IdeaProjects\\algorithm_java\\src\\BOJ\\Implement\\G1\\P17143\\input.txt"));
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());

        sharks = new HashMap<>();
        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        arr = new int[R][C];
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(bf.readLine());
            int r = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            r--;
            c--;
            int s = Integer.parseInt(st.nextToken());
            int d = Integer.parseInt(st.nextToken());
            int z = Integer.parseInt(st.nextToken());

            if((r==0 && d==1) || (r==R-1 && d==2)  ||(c==0 &&d==4)|| (c==C-1&&d==3)){
                d = switchSharkDirection(d);
            }

            if(d==1 || d==2){
                s = s%((R-1)*2);
            }else if(d==3 || d==4){
                s = s%((C-1)*2);
            }
            arr[r][c] = z;
            sharks.put(z, new shark(r, c, s, d, z));
        }
        int human = -1;
        int result = 0;
        while(human<C-1){
            //인간 이동시키고
            human++;
            //상어 낚고
            result += gotcha(human);
            //상어 이동시키고
            for (shark cur : sharks.values()){
                if(cur.isDead){
                    continue;
                }
                // 원래 위치 지우고
                arr[cur.x][cur.y] = 0;
                // 상어 이동 시키고
                moveShark(cur.size);
            }

            for (shark cur : sharks.values()){
                if(cur.isDead){
                    continue;
                }
                // 겹치면 크기 비교해서 삭제하고
                if(arr[cur.x][cur.y] > cur.size){
                    //sharks.remove(cur.size);
                    cur.isDead=true;
                }else if(arr[cur.x][cur.y]==0){
                    arr[cur.x][cur.y] = cur.size;
                }else{
                    //System.out.println(arr[cur.x][cur.y]+" "+cur.size);
                    sharks.get(arr[cur.x][cur.y]).isDead = true;
                    //sharks.remove(arr[cur.x][cur.y]);
                    arr[cur.x][cur.y] = cur.size;
                }
            }
        }
        System.out.println(result);

    }
    public static void moveShark(int size){
        shark cur = sharks.get(size);
        int x = cur.x;
        int y = cur.y;

        for (int i = 0; i < cur.speed; i++) {
            x += moveX[cur.direction];
            y += moveY[cur.direction];
            if(((x==0 || x==R-1) && cur.direction<3) ||((y==0 || y==C-1)&&cur.direction>2)){
                cur.direction = switchSharkDirection(cur.direction);
            }
        }
        cur.x = x;
        cur.y = y;
    }
    public static int switchSharkDirection(int i){
        switch (i){
            case 1:
                return 2;
            case 2:
                return 1;
            case 3:
                return 4;
            case 4:
                return 3;
        }
        return 0;
    }
    public static int gotcha(int human){
        int size = 0;
        for (int i = 0; i < R; i++) {
            if(arr[i][human]!=0){
                sharks.remove(arr[i][human]);
                size = arr[i][human];
                arr[i][human] = 0;
                return size;
            }
        }
        return size;
    }
}
class shark{
    int x;
    int y;
    int size;
    int speed;
    int direction;
    boolean isDead=false;
    shark(int x, int y, int speed, int direction, int size){
        this.x = x;
        this.y = y;
        this.speed = speed;
        this.direction = direction;
        this.size = size;
    }
}
