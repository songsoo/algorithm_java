package Test;


import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Test {

    static int count = 0;
    public static void main(String[] args) {
        int[][] a = {{1,2},{3,4}};
        for (int i = 0; i < 2; i++) {
            for (int j = 0; j < 2; j++) {
                System.out.print(a[i][j]+" ");
            }
            System.out.println();
        }

        go(a);

        for (int i = 0; i < 2; i++) {
            for (int j = 0; j < 2; j++) {
                System.out.print(a[i][j]+" ");
            }
            System.out.println();
        }
    }

    public static void go(int[][] b){
        b[0][0] = 0;
    }


}