package Test;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

//P20159
public class Main {
    static int N, result;
    static int arr[];
    static int gotcha[];
    public static void main(String[] args) throws Exception{


        System.setIn(new FileInputStream("D:\\IntelliJ\\algo\\src\\Test\\input.txt"));
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(bf.readLine());
        N /= 2;
        arr = new int[N];
        gotcha = new int[N];
        int sum1=0, sum2=0;
        StringTokenizer st = new StringTokenizer(bf.readLine());
        for (int i = 0; i < N; i++) {
            sum1 += Integer.parseInt(st.nextToken());
            arr[i] = sum1;
            sum2 += Integer.parseInt(st.nextToken());
            gotcha[i] = sum2;
        }
        result = Math.max(arr[N-1], gotcha[N-1]);
        for (int i = 0; i < N-1; i++) {
            int cur = (arr[i])+getGotcha(i,N-2);
            int cur2 = (arr[i])+getGotcha(i+1,N-1);
            result = Math.max(result, Math.max(cur,cur2));
        }

        System.out.println(result);
    }

    public static int getGotcha(int i, int j){
        if(i==0){
            return gotcha[j];
        }
        else{
            return gotcha[j]-gotcha[i-1];
        }
    }

}
