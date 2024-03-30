package BOJ.BruteForce.BackTracking.Gold.P7490;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

public class Main {
    static int N, cnt;
    static char[] ops;
    static ArrayList<String> arr;
    public static void main(String[] args) throws Exception{
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        StringBuilder sb = new StringBuilder();
        for (int test_case = 0; test_case < T; test_case++) {
            N = sc.nextInt();
            arr = new ArrayList<>();
            ops = new char[N+1];
            cnt = 0;
            goNext(N, 0, 0, 0);
            Collections.sort(arr);
            for(String cur : arr){
                sb.append(cur).append("\n");
            }
            sb.append("\n");
        }
        System.out.println(sb.toString());
    }
    public static void goNext(int index, int sum, int stackedNum, int stackedCnt){

        int cur = ((int)Math.pow(10, stackedCnt)*index) + stackedNum;

        if(index==1){

            if(stackedCnt!=0){
                sum += cur;
            }else{
                sum += 1;
            }

            if(sum==0){
                StringBuilder sb = new StringBuilder();
                for (int i = 1; i < N; i++) {
                    sb.append(i+""+ops[i+1]);
                }
                sb.append(N);
                arr.add(sb.toString());
            }
            return;
        }

        // 뒤에서부터 체크한다.
        // +나 -가 나오면 공백으로 체크한 것을 모두 더함
        // ops는 각 숫자 앞에 나올 op를 의미한다.

        // 덧셈
        ops[index] = '+';
        goNext(index-1, sum + cur, 0, 0);
        ops[index] = '-';
        goNext(index-1, sum - cur, 0, 0);
        ops[index] = ' ';
        goNext(index-1, sum, cur, stackedCnt+1);

    }
}
