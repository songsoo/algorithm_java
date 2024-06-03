package BOJ.Implement.Silver.P10773;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception{
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(bf.readLine());
        Stack<Integer> stk = new Stack<>();
        for (int i = 0; i < N; i++) {
            int cur = Integer.parseInt(bf.readLine());
            if(cur == 0){
                stk.pop();
            }else{
                stk.add(cur);
            }

        }
        int sum = 0;
        while(!stk.isEmpty()){
            sum += stk.pop();
        }
        System.out.println(sum);
    }
}