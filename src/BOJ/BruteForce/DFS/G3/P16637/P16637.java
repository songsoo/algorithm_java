package BOJ.BruteForce.DFS.G3.P16637;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Stack;

public class P16637 {
    static int N, n, max;
    static boolean[] visited;
    static char[] chars;
    public static void main(String[] args) throws Exception{
        System.setIn(new FileInputStream("D:\\IntelliJ\\algorithm_java\\src\\Test\\Input.txt"));
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(bf.readLine());
        chars = bf.readLine().toCharArray();
        n = N/2;
        visited = new boolean[n];
        max = Integer.MIN_VALUE;

        calculate(1,chars[0]-'0');
        System.out.println(max);
    }

    public static void calculate(int index, int sum){
        if(index>=N){
            //System.out.println(Arrays.toString(visited) + ":" +sum);
            max = Math.max(max, sum);
            return;
        }

        // 현재를 계산하고 다음으로 넘어감
        if(index+2<=N){
            visited[index/2] = true;
            calculate(index+2, operate(sum,chars[index+1]-'0',chars[index]));
        }
        // 다음과 다다음을 먼저 계산하고 현재랑 계산한 뒤 넘어감
        if(index+4<=N){
            visited[index/2] = false;
            visited[index/2+1] = true;
            calculate(index+4, operate(sum, operate(chars[index+1]-'0', chars[index+3]-'0', chars[index+2]), chars[index]));
        }

    }
    public static int operate(int a, int b, char op){
        if(op=='+'){
            return a + b;
        }else if(op=='-'){
            return a-b;
        }else if(op=='/'){
            return a/b;
        }else if(op=='*'){
            return a*b;
        }
        return -1;
    }
}
