package SWEA.Test.P5656;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Solution {
    static int[][] arrs, arrCopy;
    static int[] moveX = {-1,0,1,0}, moveY = {0,-1,0,1};
    static int T , N , W, H, totalBrick, maxCount, test_Case;
    public static void main(String[] args) throws IOException {
        System.setIn(new FileInputStream("C:\\Users\\SSAFY\\IdeaProjects\\algorithm_java\\src\\SWEA\\Test\\P5656\\input.txt"));
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        T = Integer.parseInt(bf.readLine());
        StringBuilder sb = new StringBuilder();
        for (test_Case = 1; test_Case <= T; test_Case++) {
            StringTokenizer st = new StringTokenizer(bf.readLine());

            N = Integer.parseInt(st.nextToken());
            W = Integer.parseInt(st.nextToken());
            H = Integer.parseInt(st.nextToken());
            totalBrick = 0;
            maxCount = 0;
            arrs = new int[H][W];

            for (int i = H-1; i >= 0; i--) {
                st = new StringTokenizer(bf.readLine());
                for (int j = 0; j < W; j++) {
                    int value = Integer.parseInt(st.nextToken());
                        arrs[i][j] = value;
                        if(arrs[i][j]>=1){
                            totalBrick++;
                        }
                }
            }
            goNext(0,copyArray(arrs),0);
            sb.append("#").append(test_Case).append(" ").append(totalBrick-maxCount).append("\n");
        }
        System.out.println(sb.toString());
    }
    public static int[][] copyArray(int[][] arrOrigin){
        int[][] copyArr = new int[H][W];
        for (int i = 0; i < H; i++) {
            copyArr[i] = Arrays.copyOf(arrOrigin[i],W);
        }
        return copyArr;
    }
    public static boolean goNext(int index, int[][] arrOrigin, int value){
        if(value == totalBrick){
            maxCount = totalBrick;
            return true;
        }
        if(index == N){
            if(value>maxCount){
                maxCount = value;
            }
            return false;
        }

        for (int j = 0; j < W; j++) {
            arrCopy = copyArray(arrOrigin);
            int cur = dropBomb(j);
            pullDown();
            if(goNext(index+1, arrCopy, value + cur)){
                return true;
            }
        }
        return false;
    }

    public static int dropBomb(int j){
        for (int i = H-1; i >=0 ; i--) {
            if(arrCopy[i][j]>0){
                return boom(i,j);
            }
        }
        return 0;
    }
    public static int boom(int i, int j){
        int power = arrCopy[i][j];
        int count;
        if( arrCopy[i][j] == -1){
            return 0;
        }else {
            count = 1;
            arrCopy[i][j] = -1;
        }

        for (int k = 0; k < 4; k++) {
            int nextX = i + moveX[k];
            int nextY = j + moveY[k];
            int index = 1;
            while(check(nextX, nextY) && index<power){
                if(arrCopy[nextX][nextY]==1){
                    arrCopy[nextX][nextY] = -1;
                    count++;
                }else if(arrCopy[nextX][nextY]>1){
                    count += boom(nextX, nextY);
                }
                nextX = nextX + moveX[k];
                nextY = nextY + moveY[k];
                index++;
            }
        }
        return count;
    }
    public static boolean check(int x, int y){
        if(x>=0 && x< H && y >= 0 && y<W){
            return true;
        }
        return false;
    }

    public static void pullDown(){
        for (int j = 0; j < W; j++) {
            int count = 0;
            for (int i = 0; i < H; i++) {
                if(arrCopy[i][j]==0){
                    break;
                }
                if(arrCopy[i][j]!=-1){
                    arrCopy[count++][j] = arrCopy[i][j];
                }
            }
            for (int i = count; i < H; i++) {
                arrCopy[i][j] = 0;
            }
        }
    }

}
