package SDS_day1.P9663;

import java.util.Scanner;

public class Main {

    static int N, count, result;
    static boolean visit[];
    static int pick[];

    public static void main(String[] args) throws Exception{

        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();

        visit = new boolean[N*N];
        pick = new int[N];
        count = 0;
        result = 0;

        goNext(0);

        System.out.println(result);


    }

    public static void goNext(int x){
        // goAttackable 가능 한 것 모두 체크

        // 1. 다음 녀석 할 수 있는지 확인
        if(count == N) {
            result++;
            count--;
        }




    }

    public static void checkAttackable(int x){


    }

    public static void print(){
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                System.out.print(attackable[i*N+j]);
            }
            System.out.println();
        }
    }



}
