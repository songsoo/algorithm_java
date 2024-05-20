package BOJ.Implement.Bronze.P10809;

import java.util.Arrays;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception{

        Scanner sc = new Scanner(System.in);
        StringTokenizer st=  new StringTokenizer(sc.nextLine());
        int N = Integer.parseInt(st.nextToken());
        int X = Integer.parseInt(st.nextToken());

        StringBuilder sb = new StringBuilder();
        st = new StringTokenizer(sc.nextLine());
        for (int i = 0; i < N; i++) {
            int cur = Integer.parseInt(st.nextToken());
            if(cur < X){
                sb.append(cur+" ");
            }

        }
        System.out.println(sb.toString());
    }
}
