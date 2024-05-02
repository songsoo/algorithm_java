package Test;

import java.io.FileInputStream;
import java.util.Scanner;

public class P16639 {
    static int N;
    static char[] arr;
    public static void main(String[] args) throws Exception{
        System.setIn(new FileInputStream("C:\\Users\\송수현\\IdeaProjects\\algorithm_java\\src\\Test\\input.txt"));
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        sc.nextLine();
        arr = sc.nextLine().toCharArray();
        System.out.println(dfs(arr[0]-48, 0, false));
    }
    public static long dfs(long sum, int index, boolean reverse){
        if(index >= N-1){
            return sum;
        }
        int next = arr[index+2]-48;
        // 바로 계산해서 다음 수식으로 넘어가기
        // 다음 숫자가 N보다 작다면
        if(!reverse){
            long curMax = Integer.MIN_VALUE;
            curMax = Math.max(curMax, dfs(operate(sum, next, arr[index+1]),index+2, reverse));
            if(index+4<N){
                if(arr[index+1]=='-'){
                    curMax = Math.max(curMax, operate(sum, dfs(next, index+2, !reverse), arr[index+1]));
                }else{
                    curMax = Math.max(curMax, operate(sum, dfs(next, index+2, reverse), arr[index+1]));
                }
            }
            // 현재꺼는 놔두고 다음 수식으로 넘어가기
            return curMax;
        }else{
            long curMin = Integer.MAX_VALUE;
            curMin = Math.min(curMin, dfs(operate(sum, next, arr[index+1]),index+2, reverse));
            if(index+4<N){
                if(arr[index+1]=='-'){
                    curMin = Math.min(curMin, operate(sum, dfs(next, index+2, !reverse), arr[index+1]));
                }else{
                    curMin = Math.min(curMin, operate(sum, dfs(next, index+2, reverse), arr[index+1]));
                }
            }
            // 현재꺼는 놔두고 다음 수식으로 넘어가기
            return curMin;
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
