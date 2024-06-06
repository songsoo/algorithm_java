package BOJ.Implement.Bronze.P30802;

import java.util.Scanner;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int N = Integer.parseInt(sc.nextLine());
        int[] arr = new int[6];

        StringTokenizer st = new StringTokenizer(sc.nextLine());

        int sum = 0;
        for (int i = 0; i < 6; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
            sum += arr[i];
        }
        st = new StringTokenizer(sc.nextLine());
        int T = Integer.parseInt(st.nextToken());
        int P = Integer.parseInt(st.nextToken());

        int TAns = 0;
        int PAns1 = sum/P;
        int PAns2 = sum%P;
        for (int i = 0; i < 6; i++) {
            TAns += (int)Math.ceil((double)arr[i]/T);
        }
        System.out.println(TAns);
        System.out.println(PAns1+" "+PAns2);
    }
}
