package BOJ.Implement.G5.P16927;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int[][] arr;
    static int N,M,R,cur,next;
    static StringBuilder sb;
    static int[] moveX= {1,0,-1,0}, moveY= {0,1,0,-1};

    public static void main(String[] args) throws Exception{
        System.setIn(new FileInputStream("E:\\SSAFY9\\intelliJ_workspace\\algorithm_java\\src\\BOJ\\Implement\\S1\\P16926\\input.txt"));
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        R = Integer.parseInt(st.nextToken());

        arr = new int[N][M];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(bf.readLine());
            for (int j = 0; j < M; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        rotateArr();

        sb  = new StringBuilder();

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                sb.append(arr[i][j]+" ");
            }
            sb.append("\n");
        }

        System.out.println(sb.toString());
    }

    public static void rotateArr(){
        int numOfLayer = (Math.min(N,M)+1)/2;
        for (int j = 0; j < numOfLayer; j++) {
            int n = 2*(N-j*2) + 2*(M-j*2) -4;
            for (int i = 0; i < R%n; i++) {
                goOneLayer(0+j,0+j,j);
            }
        }

    }

    public static void goOneLayer(int x, int y, int index){

        int ver = 0;
        int nextX = x + moveX[ver];
        int nextY = y + moveY[ver];

        cur = arr[x][y];

        for (int i = 0; i < (2*(M-index*2))+(2*(N-index*2))-3; i++) {

            next = arr[nextX][nextY];
            arr[nextX][nextY] = cur;
            cur = next;

            x = nextX;
            y = nextY;

            nextX = x + moveX[ver];
            nextY = y + moveY[ver];

            if (nextX >= N-index || nextX < 0+index || nextY >= M-index || nextY < 0+index) {
                ver = (ver + 1) % 4;
                nextX = x + moveX[ver];
                nextY = y + moveY[ver];
            }

        }
    }
}