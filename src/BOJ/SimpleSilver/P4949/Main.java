package BOJ.SimpleSilver.P4949;


import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.nio.Buffer;
import java.util.Arrays;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception{
        System.setIn(new FileInputStream("D:\\IntelliJ\\algo\\src\\Test\\input.txt"));
        BufferedReader bf= new BufferedReader(new InputStreamReader(System.in));

        while(true){
            char[] str = bf.readLine().toCharArray();
            Stack<Character> stk = new Stack<>();

            if(str[0]=='.'){
                break;
            }
            for (int i = 0; i < str.length; i++) {


                if(check(str[i])){
                    if(stk.empty() || !isMatch(stk.peek(), str[i])){
                        stk.add(str[i]);
                    }else{
                        stk.pop();
                    }
                }
            }
            System.out.println(stk.empty()?"yes":"no");
        }
    }
    public static boolean check(char chr){
        return (chr == '(' || chr==')' || chr=='[' || chr==']');
    }

    public static boolean isMatch(char chr1, char chr2){
        return chr2-chr1==1 || chr2-chr1==2;
    }
}
