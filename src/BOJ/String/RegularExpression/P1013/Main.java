package BOJ.String.RegularExpression.P1013;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws Exception{
        StringBuilder sb = new StringBuilder();
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(bf.readLine());
        for (int i = 0; i < T; i++) {
            sb.append(bf.readLine().matches("(100+1+|01)+")?"YES\n":"NO"+"\n");
        }
        System.out.println(sb.toString());
    }

}
