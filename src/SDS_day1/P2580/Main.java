package SDS_day1.P2580;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {

    static int arr[][];
    static int total;
    static int[][] visitedRow, visitedCol, visitedSBox;
    static ArrayList<int[]> zeros;
    public static void main(String[] args) throws Exception {

        System.setIn(new FileInputStream("src/SDS_day1/P2580/Input.txt"));
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        arr = new int[9][];
        zeros = new ArrayList<>();
        visitedRow = new int[9][];
        visitedCol = new int[9][];
        visitedSBox = new int[9][];

        total = 0;

        for (int i = 0; i < 9; i++) {
            arr[i] = new int[9];
            visitedSBox[i] = new int[10];
            visitedRow[i] = new int[10];
            visitedCol[i] = new int[10];
        }
        for (int i = 0; i < 9; i++) {
            StringTokenizer st = new StringTokenizer(bf.readLine());
            for (int j = 0; j < 9; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
                if(arr[i][j]==0){
                    int[] tmp = {i,j};
                    zeros.add(tmp);
                    total++;
                }else{
                    check(i,j,arr[i][j]);
                }
            }
        }

        goNext(0);

    }

    public static void check(int x, int y, int value){
        visitedRow[x][value] +=1;
        visitedCol[y][value] +=1;
        visitedSBox[(x/3)+(y/3)*3][value] += 1;
    }

    public static void unCheck(int x, int y, int value){
        visitedRow[x][value] -=1;
        visitedCol[y][value] -=1;
        visitedSBox[(x/3)+(y/3)*3][value] -= 1;
    }

    public static boolean isAvailalbe(int x, int y, int value){
        if(visitedRow[x][value]>0 || visitedCol[y][value]>0 || visitedSBox[(x/3)+(y/3)*3][value]>0){
            return false;
        }
        return true;
    }


    public static void goNext(int index){
        if(index==total){
            for(int i=0;i<9;i++){
                for (int j = 0; j < 9; j++) {
                    System.out.print(arr[i][j]+ " ");
                }
                System.out.println();
            }
            System.exit(0);
        }
        int x = zeros.get(index)[0];
        int y = zeros.get(index)[1];
        //for문으로 1~9까지
        for (int i = 1; i <= 9; i++) {
            if(isAvailalbe(x,y,i)){
                check(x,y,i);
                arr[x][y] = i;
                goNext(index+1);
                unCheck(x,y,i);
                arr[x][y] = 0;
            }

        }
        //들어갈 수 있는지 확인
        //들어갈 수 있으면 넣고 다음 depth

    }

}
