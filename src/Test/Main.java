package Test;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.Scanner;
import java.util.Stack;

public class Main {
    public static void main(String[] args) throws FileNotFoundException {
        System.setIn(new FileInputStream("C:\\Users\\송수현\\IdeaProjects\\algorithm_java\\src\\Test\\input.txt"));

        Scanner sc = new Scanner(System.in);
        N = Integer.parseInt(sc.nextLine());
        exp = sc.nextLine().toCharArray();
        op = N/2;

        if(N==1) System.out.println(exp[0]);
        else{
            solve(0, "");
            System.out.println(ans);
        }
    }

    static int N, op, ans = Integer.MIN_VALUE;
    static char[] exp;

    public static void solve(int n, String str){
        if(n>=op){
            char c = str.charAt(str.length()-1);
            if(c!=')') str += exp[N-1];

            int val = calc(str.toCharArray());
            if(ans < val) ans = val;

            return;
        }

        //선택 안한 경우
        StringBuilder tmp1 = new StringBuilder(str);
        tmp1.append(exp[2*n]).append(exp[2*n+1]);
        solve(n+1, tmp1.toString());

        //선택한 경우
        StringBuilder tmp2 = new StringBuilder(str);
        tmp2.append('(');
        tmp2.append(exp[2*n]).append(exp[2*n+1]).append(exp[2*n+2]);
        tmp2.append(')');
        if(n+1<op) tmp2.append(exp[2*n+3]);
        solve(n+2, tmp2.toString());
    }

    public static int calc(char[] str){
        System.out.println(Arrays.toString(str));
        Stack<Character> op = new Stack<>();
        Stack<Integer> num = new Stack<>();

        loop : for(int i=0;i<str.length;i++){
            System.out.println(str[i]);
            System.out.println(num.toString());
            System.out.println(op.toString());
            // 숫자면 집어넣고
            if('0'<= str[i] && str[i]<='9'){
                num.push(str[i]-'0');
            }
            else {
                // 괄호열기면 집어넣고
                if(str[i]=='(') op.push(str[i]);
                // 괄호 닫기면 다 계산해서 다시 집어넣고
                else if(str[i]==')'){
                    while(op.peek()!='('){
                        int n1 = num.pop();
                        int n2 = num.pop();
                        num.push(calc(n2, n1, op.pop()));
                    }
                    op.pop();
                }
                // 계산자면
                else {
                    boolean in = false;

                    while (!in) {
                        // 들어가있는 op나 괄호가 없으면 현재 위치의 op를 넣고 끝냄
                        if(op.size()==0){
                            op.push(str[i]);
                            continue loop;
                        }
                        // 이미 들어가있는게 있다면 제일 위에있는거 확인해서
                        char c = op.peek();
                        // 이전이 (괄호 열기이거나) (+나 -면서 현재가 *라면)
                        if (c == '(' || (c != '*' && str[i] == '*')){
                            // 일단 집어넣고 반복 끝내기
                            op.push(str[i]);
                            in = true;
                        }
                        // 들어가있는게 있으면서 이전이 (괄호 열기도 아니고) (+나 -면서 현재가 *도 아니라면)
                        // 꺼내서 계산을 해버림
                        // 괄호와 *가 더 우선적이기때문에
                        // 괄호 닫기가 나왔거나 -> 괄호 내부 계산해야 됨
                        // *다음 *가 나왔거나 -> 그냥 계산하면 됨
                        // *면서 +나-가 나왔거나 -> *를 먼저해야할텐데..
                        // +나 -면서 다음도 +나 -라면 -> 그냥 계산하면 됨
                        else {
                            int n1 = num.pop();
                            int n2 = num.pop();
                            num.push(calc(n2, n1, op.pop()));
                        }
                    }
                }
            }
        }

        while(op.size()>0){
            int n1 = num.pop();
            int n2 = num.pop();
            num.push(calc(n2, n1, op.pop()));
        }

        return num.pop();
    }

    public static int calc(int n1, int n2, char op){
        switch(op){
            case '+':
                return n1+n2;
            case '-':
                return n1-n2;
            case '*':
                return n1*n2;
            default: return 0;
        }
    }

}