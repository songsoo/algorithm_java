package SWEA.D3.P1873;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;


class Solution
{
    static char[][] map;
    static int H,W, moveMax, tankDirection;
    static char[] moveCont;
    static ArrayList<Character> direction, commandDirection;
    static int[] moveX={-1,1,0,0,0},moveY={0,0,-1,1,0}, tankPosition;
    public static void main(String args[]) throws Exception {
        System.setIn(new FileInputStream("E:\\SSAFY9\\intelliJ_workspace\\algorithm_java\\src\\SWEA\\D3\\P1873\\input.txt"));
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(bf.readLine());
        for(int test_case = 1; test_case <= T; test_case++)
        {
            direction = new ArrayList<>();
            direction.add('^');
            direction.add('v');
            direction.add('<');
            direction.add('>');
            commandDirection = new ArrayList<>();
            commandDirection.add('U');
            commandDirection.add('D');
            commandDirection.add('L');
            commandDirection.add('R');
            commandDirection.add('S');
            tankPosition = new int[2];
            StringTokenizer st  = new StringTokenizer(bf.readLine());
            H = Integer.parseInt(st.nextToken());
            W = Integer.parseInt(st.nextToken());
            map = new char[H][W];
            for (int i = 0; i < H; i++) {
                map[i] = bf.readLine().toCharArray();
                for (int j = 0; j < W; j++) {
                    if(direction.contains(map[i][j])){
                        tankPosition[0] = i;
                        tankPosition[1] = j;
                        tankDirection = direction.indexOf(map[i][j]);
                    }
                }
            }

            int moveMax = Integer.parseInt(bf.readLine());
            moveCont = new char[moveMax];
            moveCont = bf.readLine().toCharArray();

            for (int i = 0; i < moveMax; i++) {
                controlTank(moveCont[i]);
            }

            System.out.print("#"+test_case+" ");
            showMap();

        }
    }
    public static void controlTank(char command){

        if(command=='U'||command=='D'||command=='L'||command=='R'){
            tankDirection = commandDirection.indexOf(command);
            map[tankPosition[0]][tankPosition[1]] = direction.get(commandDirection.indexOf(command));
            moveTank();
        }
        if(command=='S'){
            shootTank();
        }
    }
    public static void moveTank(){
        int nextX = tankPosition[0] + moveX[tankDirection];
        int nextY = tankPosition[1] + moveY[tankDirection];
        if(nextX>=0&&nextX<H&&nextY>=0&&nextY<W){
            if(map[nextX][nextY]=='.'){
                map[nextX][nextY] = map[tankPosition[0]][tankPosition[1]];
                map[tankPosition[0]][tankPosition[1]] = '.';
                tankPosition[0] = nextX;
                tankPosition[1] = nextY;
            }
        }
    }
    public static void shootTank(){
        int nextX = tankPosition[0] + moveX[tankDirection];
        int nextY = tankPosition[1] + moveY[tankDirection];

        while(nextX>=0&&nextX<H&&nextY>=0&&nextY<W){
            if(map[nextX][nextY]=='*'){
                map[nextX][nextY]='.';
                break;
            }else if(map[nextX][nextY]=='#'){
                break;
            }
            nextX += moveX[tankDirection];
            nextY += moveY[tankDirection];
        }
    }

    public static void showMap(){
        for (int i = 0; i < H; i++) {
            for (int j = 0; j < W; j++) {
                System.out.print(map[i][j]);
            }
            System.out.println("");
        }
    }
}