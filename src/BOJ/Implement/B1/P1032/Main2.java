package BOJ.Implement.B1.P1032;

import java.util.Scanner;

public class Main2 {
    public static void main(String[] args) throws Exception{
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        char[] str = sc.next().toCharArray();
        boolean[] wrong = new boolean[str.length];

        for (int i = 1; i < N; i++) {
            char[] cur = sc.next().toCharArray();
            for (int j = 0; j < str.length; j++) {
                if(!wrong[j] && str[j]!=cur[j]){
                    wrong[j] = true;
                }
            }
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < str.length; i++) {
            sb.append(wrong[i]?"?":str[i]);
        }
        System.out.println(sb.toString());
    }
}
