package BOJ.BruteForce.DFS.S2.P1541;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.StringTokenizer;

public class Main {
    static ArrayList<Integer> nums;
    static ArrayList<Character> ops;
    static int result = Integer.MAX_VALUE, count;
    public static void main(String[] args) throws IOException {
        System.setIn(new FileInputStream("C:\\Users\\SSAFY\\IdeaProjects\\algorithm_java\\src\\BOJ\\BruteForce\\DFS\\S2\\P1541\\input.txt"));
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        String str= bf.readLine();
        String[] subStr = str.split("-");
        int result = 0;
        for (int i = 0; i < subStr.length; i++) {
            int sum = 0;
            StringTokenizer st = new StringTokenizer(subStr[i],"+");
            while(st.hasMoreTokens()){
                sum += Integer.parseInt(st.nextToken());
            }
            if(i==0){
                result += sum;
            }else{
                result -= sum;
            }
        }
        System.out.println(result);
    }

}
