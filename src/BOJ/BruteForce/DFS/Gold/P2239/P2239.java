package BOJ.BruteForce.DFS.Gold.P2239;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class P2239 {
    static char[][] map;
    public static void main(String[] args) throws Exception{

        BufferedReader bf= new BufferedReader(new InputStreamReader(System.in));
        map = new char[9][9];
        for (int i = 0; i < 9; i++) {
            map[i] = bf.readLine().toCharArray();
        }
        int s=0,e=0;
        loop:
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                if(map[i][j]=='0'){
                    s= i;
                    e = j;
                    break loop;
                }
            }
        }
        dfs(s,e);
    }

    public static void printArr(){
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                sb.append(map[i][j]+" ");
            }
            sb.append("\n");
        }
        System.out.println(sb.toString());
    }

    public static void checkBox(int i, int j, boolean[] impossible){
        i = i - i % 3;
        j = j - j % 3;
        for (int k = 0; k < 3; k++) {
            for (int l = 0; l < 3; l++) {
                impossible[map[i+k][j+l]-'0'] = true;
            }
        }
    }
    public static void checkRow(int i , boolean[] impossible){
        for (int j = 0; j < 9; j++) {
            impossible[map[i][j]-'0'] = true;
        }
    }
    public static void checkCol(int j , boolean[] impossible){
        for (int i = 0; i < 9; i++) {
            impossible[map[i][j]-'0'] = true;
        }
    }

    public static void dfs(int i, int j){

        if(i==9 && j==0){
            printArr();
            System.exit(0);
        }
        int nextJ = (j+1)%9;
        int nextI= i+(j+1)/9;

        while(nextJ<9 && nextI<9 && map[nextI][nextJ]!='0'){
            nextI = nextI+(nextJ+1)/9;
            nextJ = (nextJ+1)%9;
        }

        boolean[] impossible = new boolean[10];
        impossible[0] = true;
        checkBox(i, j, impossible);
        checkRow(i, impossible);
        checkCol(j, impossible);
        for (int k = 1; k < 10; k++) {
            if (!impossible[k]) {
                map[i][j] = (char) (k + '0');
                dfs(nextI, nextJ);
            }
        }
        map[i][j] = '0';
    }
}
