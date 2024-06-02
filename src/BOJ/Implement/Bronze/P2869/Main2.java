package BOJ.Implement.Bronze.P2869;

import java.util.Scanner;
import java.util.StringTokenizer;

public class Main2 {
    public static void main(String[] args) throws Exception{
        Scanner sc = new Scanner(System.in);
        StringTokenizer st = new StringTokenizer(sc.nextLine());
        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());
        int v = Integer.parseInt(st.nextToken());
        System.out.println((int)Math.ceil((double)(v-a)/(double)(a-b))+1);
    }
}
