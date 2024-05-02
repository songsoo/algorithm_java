package Test;

import java.io.FileInputStream;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {
    static int N;
    static char[] arr;
    static long max;
    static boolean[] arr2;
    public static void main(String[] args) throws Exception{
        System.setIn(new FileInputStream("D:\\IntelliJ_Repository\\src\\Test\\input.txt"));
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        sc.nextLine();
        max = Integer.MIN_VALUE;
        arr = sc.nextLine().toCharArray();
        arr2 = new boolean[N];
        dfs(0, 1);
        System.out.println(max);
    }
    public static void dfs(int index, int nonCoverCnt){
        if(index>=N-1){
            Queue<Long> num = new LinkedList<>();
            Queue<Character> op = new LinkedList<>();
            int i = 0;
            System.out.println(Arrays.toString(arr2));
            while(i<N){
                // 숫자밖에 안남으면
                if(i==N-1){
                    num.add((long)arr[i]-48);
                    break;
                }
                // 괄호 있으면 괄호 계산해서 넣기
                if(arr2[i+1]){
                    num.add(operate(arr[i]-48,arr[i+2]-48,arr[i+1]));
                    if(i+3<N){
                        op.add(arr[i+3]);
                    }
                    i+=4;
                }
                // 괄호가 없다면
                else{
                    num.add(((long)arr[i]-48));
                    op.add(arr[i+1]);
                    i+=2;
                }
            }
            long sum = num.poll();
            while(!num.isEmpty()){
                long numC = num.poll();
                char opC = op.poll();
                System.out.print(sum +" "+ opC +" "+ numC+" ,");
                sum = operate(sum, numC, opC);
            }
            // 여기서 다 꺼내서 계산
            max = Math.max(sum, max);
            System.out.println(sum);
            return;
        }
        if(index==N-3){
            arr2[index+1] = true;
            dfs(index+2, 0);
            arr2[index+1] = false;
            return;
        }
        // 저번에 괄호 넣었음
        if(nonCoverCnt==0){
            arr2[index+1] = false;
            dfs(index+2, 1);
        }
        // 저저번에 괄호 넣었음
        else if(nonCoverCnt==1){
            // 괄호 안넣기
            arr2[index+1] = false;
            dfs(index+2, 2);
            // 괄호 넣기
            if(index+2 < N){
                arr2[index+1] = true;
                dfs(index+2, 0);
                arr2[index+1] = false;
            }
        }else if(nonCoverCnt==2){
            if(index+2 < N){
                arr2[index+1] = true;
                dfs(index+2, 0);
                arr2[index+1] = false;
            }
        }
    }
    public static long operate(long a, long b, char op){
        if(op=='-'){
            return a-b;
        }else if(op=='+'){
            return a+b;
        }else if(op=='*'){
            return a*b;
        }else{
            return 1000000000;
        }
    }
}
