package BOJ.NumberTheory.PostFix;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.Stack;

public class Main {
    static int N, max;
    static boolean[] covered;
    static StringBuilder str;
    public static void main(String[] args) throws FileNotFoundException {

        System.setIn(new FileInputStream("C:\\Users\\송수현\\IdeaProjects\\algorithm_java\\src\\Test\\input.txt"));

        Scanner sc = new Scanner(System.in);
        N = Integer.parseInt(sc.nextLine());
        max = Integer.MIN_VALUE;
        covered = new boolean[N];
        str = new StringBuilder(sc.nextLine());
        dfs(1, false);
        System.out.println(max);

    }

    public static void dfs(int idx, boolean prevCovered){
        if(idx>=N){
            StringBuilder sb = new StringBuilder();
            if(idx==1){
                sb.append(str.charAt(0));
            }
            for (int i = 1; i < str.length(); i+=2) {
                if(covered[i]){
                    sb.append("(").append(str.substring(i-1,i+2)).append(")");
                    if(str.length()>=i+3){
                        sb.append(str.charAt(i+2));
                        i+=2;
                    }
                }else{
                    sb.append(str.substring(i-1,i+1));
                }
                if(i==str.length()-2 && !covered[i]){
                    sb.append(str.charAt(i+1));
                }
            }
            max = Math.max(max, inToPost(sb.toString()));
            return;
        }
        if(prevCovered || str.charAt(idx)=='*'){
            dfs(idx+2, false);
        }else{
            dfs(idx+2, false);
            covered[idx]= true;
            dfs(idx+2, true);
            covered[idx]= false;
        }

    }

    public static int inToPost(String str){
        StringBuilder sb = new StringBuilder();
        Stack<Character> stk = new Stack();
        Stack<Integer> stk2 = new Stack<>();
        for (int i = 0; i < str.length(); i++) {
            char cur = str.charAt(i);
            // 숫자일 경우엔 그냥 넣는다.
            if(cur>='0' && cur<='9'){
                stk2.add(cur-'0');
            }else if(cur=='('){
                stk.add(cur);
            }else if(cur==')'){
                while(!stk.isEmpty() && stk.peek()!='('){
                    stk2.add(cal(stk2.pop(),stk2.pop(), stk.pop()));
                }
                stk.pop();
            }else if(cur=='+' || cur=='-'){
                while(!stk.isEmpty() && (stk.peek()=='+' || stk.peek()=='-' || stk.peek()=='*')){
                    stk2.add(cal(stk2.pop(),stk2.pop(), stk.pop()));
                }
                stk.add(cur);
            }else if(cur=='*'){
                while(!stk.isEmpty() && (stk.peek()=='*')){
                    stk2.add(cal(stk2.pop(),stk2.pop(), stk.pop()));
                }
                stk.add(cur);
            }
        }
        while(!stk.isEmpty()){
            stk2.add(cal(stk2.pop(),stk2.pop(), stk.pop()));
        }
        return stk2.pop();
    }
    public static int cal(int b, int a, char op){
        if(op=='+'){
            return a+b;
        }else if(op=='-'){
            return a-b;
        }else if(op=='*'){
            return a*b;
        }
        return -1;
    }
}