package SWEA.D5.P5644;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.*;

public class Solution {
    static int M, A;
    static Queue<Integer> move1,move2;
    static ArrayList<AP> APs;
    static int[] moveX={0,-1,0,1,0}, moveY={0,0,1,0,-1};
    static int[][] check;
    public static void main(String[] args) throws Exception{
        System.setIn(new FileInputStream("E:\\SSAFY9\\intelliJ_workspace\\algorithm_java\\src\\SWEA\\D5\\P5644\\input.txt"));
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int T  =Integer.parseInt(bf.readLine());
        for (int test_case = 1; test_case <= T; test_case++) {
            move1 = new LinkedList<>();
            move2 = new LinkedList<>();
            StringTokenizer st = new StringTokenizer(bf.readLine());

            M = Integer.parseInt(st.nextToken());
            A = Integer.parseInt(st.nextToken());
            check = new int[A][M+1];

            st = new StringTokenizer(bf.readLine());
            StringTokenizer st2 = new StringTokenizer(bf.readLine());

            for (int i = 0; i < M; i++) {
                move1.add(Integer.parseInt(st.nextToken()));
                move2.add(Integer.parseInt(st2.nextToken()));
            }

            APs = new ArrayList<>();

            for (int i = 0; i < A; i++) {
                st = new StringTokenizer(bf.readLine());
                int x = Integer.parseInt(st.nextToken());
                int y = Integer.parseInt(st.nextToken());
                int coverage = Integer.parseInt(st.nextToken());
                int value = Integer.parseInt(st.nextToken());
                APs.add(new AP(y-1,x-1,coverage,value));
            }
            Collections.sort(APs);

            int x = 0;
            int y = 0;
            int index = 0;
            check(x,y,index++);
            while(!move1.isEmpty()){

                int moveIndex = move1.poll();
                x = x+moveX[moveIndex];
                y = y+moveY[moveIndex];
                if(index==11){
                    System.out.println(x+" "+y);
                }
                check(x,y,index++);
            }

            x = 9;
            y = 9;
            index = 0;
            check(x,y,index++);
            while(!move2.isEmpty()){
                int moveIndex = move2.poll();
                x = x+moveX[moveIndex];
                y = y+moveY[moveIndex];
                if(index==11){
                    System.out.println(x+" "+y);
                }
                check(x,y,index++);
            }

            int total = 0;
            for (int i = 0; i < M; i++) {
                for (int j = 0; j < A; j++) {
                    if(check[j][M]>0){
                        total += APs.get(j).value;
                    }
                }
            }

            for (int i = 0; i < M; i++) {
                System.out.println(i+" "+check[0][i]+" "+check[1][i]+" "+check[2][i]);
            }


            System.out.println(total);

        }
    }
    public static void check(int x, int y, int index){

        for (int i = 0; i < A; i++) {
            if(check[i][index]!=0){
                continue;
            }
            if(APs.get(i).isIn(x,y)){
                check[i][index]++;
                break;
            }
        }
    }
}
class AP implements Comparable<AP> {
    int x;
    int y;
    int coverage;
    int value;

    public AP(int x, int y, int coverage, int value) {
        this.x = x;
        this.y = y;
        this.coverage = coverage;
        this.value = value;
    }

    public boolean isIn(int x, int y){
        if(Math.abs(this.x-x)+Math.abs(this.y-y)<=coverage){
            return true;
        }
        return false;
    }

    @Override
    public int compareTo(AP o) {
        return o.value-this.value;
    }
}