package SWEA.D2.P1974;


import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {

    static int[][] sudoku;
    static int T;
    public static void main(String[] args) throws Exception{

        System.setIn(new FileInputStream("src/javaGo/input.txt"));

        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        T = Integer.parseInt(bf.readLine());

        for (int i = 0; i < T; i++) {


            sudoku = new int[9][];

            for (int j = 0; j < 9; j++) {

                sudoku[j] = new int[9];
                st = new StringTokenizer(bf.readLine());

                for (int j2 = 0; j2 < 9; j2++) {
                    sudoku[j][j2] = Integer.parseInt(st.nextToken());
                }
            }

            System.out.println(checkSudoku()?("#"+(i+1)+" 1"):("#"+(i+1)+" 0"));



        }


    }

    public static boolean checkSudoku() {
        for (int i = 0; i < 9; i++) {
            if(!checkSudokuRow(i)||!checkSudokuCol(i)||!checkSudokuMini(i%3,i/3)) {
                return false;
            }
        }
        return true;
    }

    public static boolean checkSudokuRow(int r) {
        boolean isIn[] = new boolean[10];
        for (int i = 0; i < 9; i++) {
            if(isIn[sudoku[r][i]]) {
                return false;
            }
            isIn[sudoku[r][i]] = true;
        }
        return true;
    }

    public static boolean checkSudokuCol(int c) {
        boolean isIn[] = new boolean[10];
        for (int i = 0; i < 9; i++) {
            if(isIn[sudoku[i][c]]) {
                return false;
            }
            isIn[sudoku[i][c]] = true;
        }
        return true;
    }
    public static boolean checkSudokuMini(int x,int y) {
        boolean isIn[] = new boolean[10];
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if(isIn[sudoku[x*3+i][y*3+j]]) {
                    return false;
                }
                isIn[sudoku[x*3+i][y*3+j]] = true;
            }
        }
        return true;
    }

}
