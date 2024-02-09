package BOJ.NumberTheory.Bronze.P2562;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws Exception{
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int max = 0;
        int index = 0;
        for (int i = 0; i < 9; i++) {

            int cur = Integer.parseInt(bf.readLine());
            if(max<cur){
                max = cur;
                index = i;
            }
        }
        System.out.println(max+"\n"+(index+1));
    }
}
