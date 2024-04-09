package BOJ.TwoPointer.P3273;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws Exception{

        System.setIn(new FileInputStream("D:\\IntelliJ\\algo\\src\\Test\\input.txt"));
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(bf.readLine());

        StringTokenizer st = new StringTokenizer(bf.readLine());
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(arr);
        int x = Integer.parseInt(bf.readLine());

        int p = 0;
        int q = n-1;
        int cnt = 0;

        while(p<q){
            if(arr[p]+arr[q]>x){
                q--;
            }else if(arr[p]+arr[q]==x){
                int pVal = arr[p];
                int pCnt = 1;
                while(arr[++p]==pVal){
                    pCnt++;
                }
                int qVal = arr[q];
                int qCnt = 1;
                while(arr[--q]==qVal){
                    q--;
                    qCnt++;
                }
                cnt += (pCnt * qCnt);
            }else{
                p++;
            }
        }
        System.out.println(cnt);
    }
}
