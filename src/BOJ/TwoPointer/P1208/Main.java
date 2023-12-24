package BOJ.TwoPointer.P1208;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int N,S;
    static long result;
    static int[] arr;
    static ArrayList<Integer> larr, rarr;

    public static void main(String[] args) throws Exception{

        System.setIn(new FileInputStream("D:\\IntelliJ\\algo\\src\\Test\\input.txt"));

        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());

        N = Integer.parseInt(st.nextToken());
        S = Integer.parseInt(st.nextToken());
        larr = new ArrayList<>();
        rarr = new ArrayList<>();
        arr = new int[N];
        result = 0;
        st = new StringTokenizer(bf.readLine());

        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(arr);
        getSubArr(0,N/2, 0, larr);
        getSubArr(N/2,N, 0, rarr);
        Collections.sort(larr);
        Collections.sort(rarr);

        getYop();
        if(S==0){
            result--;
        }
        System.out.println(result);
    }

    public static void getSubArr(int index, int size, int sum, ArrayList arrlist){
        if(index==size){
            arrlist.add(sum);
            return;
        }
        getSubArr(index+1, size, sum+arr[index], arrlist);
        getSubArr(index+1, size, sum, arrlist);
    }
    public static void getYop(){

        int p = 0;
        int q = rarr.size()-1;

        while(true){

            if(p>=larr.size() || q<0){
                break;
            }

            int left = larr.get(p);
            int right = rarr.get(q);
            int sum = left + right;

            if(sum < S){
                p++;
            }else if(sum > S){
                q--;
            }else{
                long lcount = 1;
                long rcount = 1;
                while(++p<larr.size() && left==larr.get(p)){
                    lcount++;
                }
                while(--q>=0 &&right==rarr.get(q)){
                    rcount++;
                }
                result += lcount * rcount;
            }
        }
    }
}
