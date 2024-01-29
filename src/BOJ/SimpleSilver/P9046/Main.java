package BOJ.SimpleSilver.P9046;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws Exception{
        System.setIn(new FileInputStream("D:\\IntelliJ\\algo\\src\\Test\\input.txt"));
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(bf.readLine());

        for (int i = 0; i < N; i++) {

            char[] str = bf.readLine().toCharArray();
            int[] yom = new int[26];
            int max = 0;
            int maxIdx = -1;
            boolean flag = true;

            for(char cur : str){

                int curIdx = cur - 97;

                if(cur == ' '){
                    continue;
                }
                if(max < ++yom[curIdx]){
                    max = yom[curIdx];
                    maxIdx = curIdx;
                    flag = false;
                }else if(max == yom[curIdx]){
                    flag = true;
                }
            }
            System.out.println(!flag?(char)(maxIdx+97):"?");
        }
    }
}
