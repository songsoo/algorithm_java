package BOJ.Implement.Bronze.P2577;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main2 {
    public static void main(String[] args) throws Exception{
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int a = Integer.parseInt(bf.readLine());
        int b = Integer.parseInt(bf.readLine());
        int c = Integer.parseInt(bf.readLine());

        int res = a*b*c;
        int[] cnt = new int[10];
        while(res>0){
            cnt[res%10]++;
            res = res/10;
        }
        for (int i = 0; i < 10; i++) {
            System.out.println(cnt[i]);
        }

    }
}
