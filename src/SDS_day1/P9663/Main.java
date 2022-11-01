package SDS_day1.P9663;

import java.util.Scanner;

public class Main {

    static int N, count, result;
    static boolean visit[][];
    static int pick[][];
    static int arr[];

    public static void main(String[] args) throws Exception{

        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();

        pick = new int[N+1][];
        arr = new int[N];
        for (int i = 0; i < N+1; i++) {
            pick[i] = new int[N+1];
        }

        count = 0;
        result = 0;

        goNext(0);

        System.out.println(count);

    }

    public static void goNext(int depth){
        if(depth == N){
            count++;
        }
        //체크인
        else {
            for (int i = 0; i < N; i++) {
                //checkIn(i,depth);
                if (isPossible(i,depth)) {
                    arr[depth] = i;
                    goNext(depth+1);
                }
                //checkOut(i,depth);
            }
            //체크아웃
        }
    }
    public static boolean isPossible(int x,int depth){
        for(int i=0;i<depth;i++){
            if(arr[i]==x){
                return false;
            }
            if(Math.abs(arr[i]-x)==Math.abs(i-depth)){
                return false;
            }
        }
        return true;
    }
    /*
    public static void checkIn(int x, int y){
        for (int i = 0; i < N*N; i++) {
            //본인이면 스킵
            if(i==x){
            }
            //세로, 가로 확인
            else if(i/N==y || i%N == x){
                pick[x][y]+=1;
            }
            // 대각선 확인
            else if(Math.abs((i/N) - (y)) == Math.abs((i%N)-(x))){
                pick[i/N][i%N]+=1;
            }
        }
    }

    public static void checkOut(int x, int y){
        for (int i = 0; i < N*N; i++) {
            //본인이면 스킵
            if(i==x){
            }
            //세로, 가로 확인
            else if(i/N==y || i%N == x){
                pick[x][y]-=1;
            }
            // 대각선 확인
            else if(Math.abs((i/N) - (y)) == Math.abs((i%N)-(x))){
                pick[i/N][i%N]-=1;
            }
        }
    }
    */


}
