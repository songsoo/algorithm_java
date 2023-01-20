package SDS.SDS_day3.P2504;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception{

        System.setIn(new FileInputStream("E:\\SSAFY9\\intelliJ_workspace\\algorithm_java\\src\\SDS\\SDS_day3\\P2504\\input.txt"));

        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());

        String str = st.nextToken();

        Stack<Character> strStk = new Stack<Character>();
        char cur=' ';
        int sum =0;
        int mulValue = 1;
        int stkCnt = 0;
        for (int i = 0; i < str.length(); i++) {

            char prev = cur;
            cur = str.charAt(i);

            if(cur=='('){
                mulValue *= 2;
                strStk.add(')');
                stkCnt++;
            }else if(cur=='['){
                strStk.add(']');
                mulValue *= 3;
                stkCnt++;
            }else if(cur==')'){
                if(stkCnt>0) {
                    if (!(strStk.pop() == ')')) {
                        sum = -1;
                        break;
                    }
                    if (prev == '(') {
                        sum += mulValue;
                    }
                }else{
                    sum=-1;
                    break;
                }
                stkCnt--;
                mulValue/=2;
            }else if(cur==']'){
                if(stkCnt>0) {
                    if (!(strStk.pop() == ']')) {
                        sum = -1;
                        break;
                    }
                    if (prev == '[') {
                        sum += mulValue;
                    }
                }else{
                    sum=-1;
                    break;
                }
                stkCnt--;
                mulValue/=3;
            }else{
                sum = -1;
                break;
            }

        }

        if(stkCnt!=0){
            sum = -1;
        }

        if(sum==-1){
            System.out.println(0);
        }else{
            System.out.println(sum);
        }

    }

}
