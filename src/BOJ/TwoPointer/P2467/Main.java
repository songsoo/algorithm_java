package BOJ.TwoPointer.P2467;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int N;
    static int[] arr;
    public static void main(String[] args) throws Exception{
        System.setIn(new FileInputStream("D:\\IntelliJ\\algo\\src\\Test\\input.txt"));

        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(bf.readLine());
        arr = new int[N];

        StringTokenizer st = new StringTokenizer(bf.readLine());

        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        getMin();

    }

    public static void getMin(){
        int S=0, E=N-1;
        int flag1=S, flag2=E;
        int min = Integer.MAX_VALUE;
        while(E>S){
            int num1 = arr[S];
            int num2 = arr[E];
            int sum = Math.abs(num2+num1);
            if(min>sum){
                min = sum;
                flag1 = num1;
                flag2 = num2;
            }
            if(num2+num1>0){
                E--;
            }else if(num2+num1<0){
                S++;
            }else{
                break;
            }

        }
        System.out.println(flag1+" "+flag2);
    }
}
