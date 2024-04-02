package BOJ.Implement.Silver.P13413;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws Exception{
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(bf.readLine());
        StringBuilder sb = new StringBuilder();
        for (int test_case = 0; test_case < T; test_case++) {
            int N = Integer.parseInt(bf.readLine());
            char[] original = bf.readLine().toCharArray();
            char[] target = bf.readLine().toCharArray();
            int toBeW = 0;
            int toBeB = 0;
            for (int i = 0; i < N; i++) {
                if(original[i] != target[i]){
                    if(target[i]=='W'){
                        toBeW++;
                    }else{
                        toBeB++;
                    }
                }
            }
            sb.append(Math.max(toBeB, toBeW)).append("\n");
        }
        System.out.println(sb.toString());
    }
}
