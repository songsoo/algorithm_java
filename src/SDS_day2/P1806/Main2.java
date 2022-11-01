package SDS_day2.P1806;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main2 {

    static int N,S;
    static int[] array;

    public static void main(String[] args) throws Exception{

        System.setIn(new FileInputStream("src/SDS_day2/P1806/input.txt"));
        BufferedReader bf= new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());

        N = Integer.parseInt(st.nextToken());
        S = Integer.parseInt(st.nextToken());
        array = new int[N];
        st = new StringTokenizer(bf.readLine());

        for (int i = 0; i < N; i++) {
            array[i] = Integer.parseInt(st.nextToken());
        }

        int left=0, right=0, sum=array[0], minLength=Integer.MAX_VALUE;

        while(true){
            if(sum >= S){
                if(minLength > right-left+1){
                    minLength = right-left+1;
                }
                sum-=array[left++];
            }else{
                right++;
                if(right>=N){
                    break;
                }
                sum += array[right];
            }
            if(left>right){
                right=left;
            }
        }
        if(minLength==Integer.MAX_VALUE){
            minLength=0;
        }
        System.out.println(minLength);

    }


}
