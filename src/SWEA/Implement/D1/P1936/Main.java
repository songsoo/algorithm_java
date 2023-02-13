package SWEA.Implement.D1.P1936;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        int A, B;
        char win;

        Scanner sc = new Scanner(System.in);

        A = sc.nextInt();
        B = sc.nextInt();

        if(A-B==1 || A-B==-2){
            win = 'A';
        }else{
            win = 'B';
        }

        System.out.println(win);

    }
}
