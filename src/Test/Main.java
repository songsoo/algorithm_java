package Test;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashSet;

public class Main {
    public static void main(String[] args) throws Exception{
        System.setIn(new FileInputStream("D:\\IntelliJ\\algo\\src\\Test\\input.txt"));
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(bf.readLine());
        char[] chars = bf.readLine().toCharArray();

        int p = 0;
        int q = 0;

        int[] alphaArr = new int[26];
        int alphaNum = 0;
        int max = 0;

        while(q<chars.length){
            // 없으면 추가하고
            // 알파벳 개수 확인하고 주어진 것보다 크면 작아질 때까지 이전 포인터 옮김
            int pIndex = chars[p]-'a';
            int qIndex = chars[q]-'a';

            if(alphaArr[qIndex]++==0) {
                alphaNum++;
            }
            while(alphaNum>N && p<q){
                alphaArr[pIndex]--;
                if(alphaArr[pIndex]==0){
                    alphaNum--;
                }
                p++;
                pIndex = chars[p]-'a';
            }
            max = Math.max(max, q-p+1);
            q++;
        }

        System.out.println(max);


    }
}
