package Test;

import java.util.Scanner;

public class Main2 {
    public static void main(String[] args) throws Exception{
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        for (int i = 1; i < 10; i++) {
            System.out.println(n +" * "+i +" = "+n*i);
        }
    }
}
