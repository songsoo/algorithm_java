package SDS.SDS_day3.P2504;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception{

        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());

        String str = st.nextToken()+" ";

        Stack<Character> strStk = new Stack<Character>();
        Stack<Integer> intStk = new Stack<Integer>();
        int sum = 0;
        int mulp = 0;
        for (int i = 0; i < str.length(); i++) {
            char cur = str.charAt(i);



            if(cur==')' || cur==']'){

            }else{
                strStk.push(cur);
            }

        }

    }

    public static boolean checkSame(char a, char b){
        if(a>b){
            char tmp = a;
            a = b;
            b = tmp;
        }
        if(a=='('&&b==')'){
            return true;
        }
        if(a=='['&&b==']'){
            return true;
        }
        return false;
    }
}
