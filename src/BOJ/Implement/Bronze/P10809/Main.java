package BOJ.Implement.Bronze.P10809;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws Exception{
        Scanner sc = new Scanner(System.in);
        char[] str = sc.nextLine().toCharArray();
        int[] alpha = new int[26];
        Arrays.fill(alpha,-1);
        for (int i = 0; i < str.length; i++) {
            int cur = str[i]-'a';
            if(alpha[cur]==-1){
                alpha[cur] = i;
            }
        }
        for (int i = 0; i < 26; i++) {
            System.out.print(alpha[i]+" ");
        }
    }
}
