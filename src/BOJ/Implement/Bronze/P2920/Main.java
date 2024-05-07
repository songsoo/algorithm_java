package BOJ.Implement.Bronze.P2920;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int a = sc.nextInt();
        int b = sc.nextInt();
        boolean asc = a<b;
        boolean flag = true;
        for (int i = 2; i < 8; i++) {
            a = b;
            b = sc.nextInt();
            if(asc && a>b){
                flag = false;
                break;
            }else if(!asc && a<b){
                flag = false;
                break;
            }
        }
        if(flag){
            System.out.println(asc?"ascending":"descending");
        }else{
            System.out.println("mixed");
        }
    }
}
