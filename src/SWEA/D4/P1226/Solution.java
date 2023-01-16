package SWEA.D4.P1226;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {
    static int[][] arr;
    static boolean[][] visited;
    static int[] moveX={1,0,-1,0}, moveY={0,1,0,-1};
    public static void main(String[] args) throws Exception{
        System.setIn(new FileInputStream("src/SWEA/D2/P1226/input.txt"));
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        for (int i = 0; i < 10; i++) {
            arr = new int[16][];
            visited = new boolean[16][];
            bf.readLine();
            // 세로 줄 따라가면서
            for (int j = 0; j < 16; j++) {
                arr[j] = new int[16];
                visited[j] = new boolean[16];
                String line = bf.readLine();
                //
                for (int l = 0; l < line.length(); l++) {
                    arr[j][l] = Character.getNumericValue(line.charAt(l));
                }
                }
            System.out.println("#"+(i+1)+" "+ (dfs(1,1)?"1":"0"));
            }

        }



    public static boolean dfs(int x, int y) {
        if (arr[x][y] == 3) {
            return true;
        }

        visited[x][y] = true;

        for (int i = 0; i < 4; i++) {
            int nextX = x + moveX[i];
            int nextY = y + moveY[i];

            if (!(nextX < 0 || nextX >= 16 || nextY < 0 || nextY >= 16)) {
                if (!visited[nextX][nextY]) {
                    if (arr[nextX][nextY] == 0 || arr[nextX][nextY] == 3) {
                        if (dfs(nextX, nextY)) {
                            return true;
                        }
                    }
                }

            }

        }
        visited[x][y] = false;

        return false;
    }
}

