package BOJ.Implement.G4.P17406;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int[][] arr;
    static int N,M,R,cur,next;
    static int[][] rotLoc;
    static StringBuilder sb;
    static int[] moveX= {0,1,0,-1}, moveY= {1,0,-1,0};

    public static void main(String[] args) throws Exception{
        System.setIn(new FileInputStream("E:\\SSAFY9\\intelliJ_workspace\\algorithm_java\\src\\BOJ\\Implement\\G4\\P17406\\input.txt"));
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(bf.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        R = Integer.parseInt(st.nextToken());
        sb = new StringBuilder();
        arr = new int[N][M];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(bf.readLine());
            for (int j = 0; j < M; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        rotLoc = new int[R][3];
        for (int i = 0; i < R; i++) {
            st = new StringTokenizer(bf.readLine());
            rotLoc[i][0] = Integer.parseInt(st.nextToken());
            rotLoc[i][1] = Integer.parseInt(st.nextToken());
            rotLoc[i][2] = Integer.parseInt(st.nextToken());
        }

        rotateArr();



        int max = 0;
        for (int i = 0; i < N; i++) {
            int result=0;
            for (int j = 0; j < M; j++) {
                result+=arr[i][j];
            }
            max = Math.max(max,result);
        }

        System.out.println(sb.toString());
        System.out.println(max);


    }

    public static void rotateArr(){
        for (int k = 0; k < R; k++) {
            int numOfLayer = rotLoc[k][2];

            for (int j = 0; j < numOfLayer; j++) {
                int n  = 8 * (rotLoc[k][2]-j);
                int startX = rotLoc[k][0]-rotLoc[k][2]-1+j;
                int startY = rotLoc[k][1]-rotLoc[k][2]-1+j;
                int endX = rotLoc[k][0]+rotLoc[k][2];
                int endY = rotLoc[k][1]+rotLoc[k][2]-1;

                //System.out.println(startX+" "+endX+" "+startY+" "+endY+" "+n+"\n");
                goOneLayer(startX,startY,j,endX,endY, n);
            }
            printArr();
        }


    }

    public static void goOneLayer(int x, int y, int index,int M, int N, int count){

        int startX = x;
        int startY = y;
        int ver = 0;
        int nextX = x + moveX[ver];
        int nextY = y + moveY[ver];

        cur = arr[x][y];
        for (int i = 0; i < count+1; i++) {
            next = arr[nextX][nextY];
            arr[nextX][nextY] = cur;
            cur = next;

            x = nextX;
            y = nextY;

            nextX = x + moveX[ver];
            nextY = y + moveY[ver];

            if (nextX >= N-index || nextX < startX+index || nextY >= M-index || nextY < startY+index) {
                //System.out.println("here"+nextY + " "+(M-index)+" "+(startY+index));
                //System.out.println("here"+nextX + " "+(N-index)+" "+(startX+index));

                ver = (ver + 1) % 4;
                nextX = x + moveX[ver];
                nextY = y + moveY[ver];
            }
            //System.out.println(x+" "+y+" "+nextX+" "+nextY);

        }
    }

    public static void printArr(){
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                System.out.print(arr[i][j]+" ");
            }
            System.out.println();
        }
        System.out.println();
    }
}