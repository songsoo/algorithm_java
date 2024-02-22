package BOJ.Implement.Bronze.P1330;


import java.util.Scanner;

public class Main2 {
    public static void main(String[] args) throws Exception{
        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt();
        int b = sc.nextInt();

        if(a>b){
            System.out.println(">");
        }else if(a<b){
            System.out.println("<");
        }else{
            System.out.println("==");
        }
    }
}
