package BOJ.Implement.Bronze.P8958;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws Exception{
        Scanner sc = new Scanner(System.in);
        int N = Integer.parseInt(sc.nextLine());
        for (int i = 0; i < N; i++) {
            char[] str = sc.nextLine().toCharArray();
            int cnt = 0;
            int result = 0;
            for (int j = 0; j < str.length; j++) {
                if(str[j]=='O'){
                    result += ++cnt;
                }else{
                    cnt = 0;
                }
            }
            System.out.println(result);
        }
    }
}
