package Test;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static int k, n, lock;
    static int[] start,middle, end;
    static char[] middleChar;
    static char[][] raddle;
    public static void main(String[] args) throws Exception{

        System.setIn(new FileInputStream("D:\\IntelliJ_Repository\\src\\Test\\input.txt"));
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        k = Integer.parseInt(bf.readLine());
        n = Integer.parseInt(bf.readLine());
        start = new int[k+2];
        middle = new int[k+2];
        middleChar = new char [k+2];
        end = new int [k+2];
        lock = 0;

        char[] startChar = (" "+bf.readLine()+" ").toCharArray();
        for (int i = 1; i <= k; i++) {
            start[i] = i-1;
            end[i] = startChar[i]-'A';
        }

        raddle = new char[n][k+3];
        for (int i = 0; i < 5; i++) {
            raddle[i] = ("*"+bf.readLine()+"*").toCharArray();
            if(raddle[i][1]=='?'){
                lock = i;
            }
        }

        for (int i = 1; i <= k; i++) {
            int nextLoc = goDown(0,i, lock);
            middle[nextLoc] = i-1;
        }

        for (int i = 1; i < k; i++) {
            // start[i] : 현재 알파벳
            // end[goDown()]
            if(middle[i] == end[goDown(lock+1, i, n)]){
                raddle[lock][i] = '*';
            }else{
                raddle[lock][i] = '-';
                raddle[lock][i+1] = '*';
                i++;
            }
        }

        StringBuilder sb = new StringBuilder();

        boolean flag = true;
        for (int i = 1; i <= k; i++) {
            if((i-1) != end[goDown(0, i, n)]){
                flag = false;
                break;
            }
        }

        if(flag){
            for (int i = 1; i < k; i++) {
                sb.append(raddle[lock][i]);
            }
        }else{
            for (int i = 1; i < k; i++) {
                sb.append('x');
            }
        }

        System.out.println(sb.toString());


    }
    public static int goDown(int x, int y, int end){
        if(x==end){
            return y;
        }
        if(raddle[x][y-1]=='-'){
            return goDown(x+1,y-1, end);
        }else if(raddle[x][y]=='-'){
            return goDown(x+1, y+1, end);
        }else{
            return goDown(x+1, y, end);
        }
    }
}
