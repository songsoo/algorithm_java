package Test;


import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Test {

    static int n=5;
    static boolean[][] arr;
    static int[] arr2;
    public static void main(String[] args) {

        arr = new boolean[n][n];
        arr2 = new int[3];
        dfs(0);
    }

    static void dfs(int wallCnt){
        if(wallCnt == 3){
            for (int i = 0; i < wallCnt; i++) {
                System.out.print(arr2[i]+" ");
            }
            System.out.println();
            return;
        }
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if(!arr[i][j]){
                    arr[i][j] = true;
                    arr2[wallCnt] = i*10+j;
                    dfs(wallCnt+1);
                    arr[i][j] = false;
                }
            }
        }
    }

}