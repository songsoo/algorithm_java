package BOJ.BinarySearch.P2866;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashSet;
import java.util.StringTokenizer;

public class Main2 {
    static char arr[][];
    static int R,C;
    public static void main(String[] args) throws Exception{
        System.setIn(new FileInputStream("D:\\IntelliJ\\algo\\src\\Test\\input.txt"));
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());

        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());

        arr = new char[R][C];

        for (int i = 0; i < R; i++) {
            String str = bf.readLine();
            for (int j = 0; j < C; j++) {
                arr[i][j] = str.charAt(j);
            }
        }



        int start = 0, end=R-1;
        while(start<=end){
            int mid = (start+end)/2;
            if(isPossible(mid)){
                start = mid+1;
            }else{
                end = mid-1;
            }
        }
        System.out.println(start);
    }

    public static boolean isPossible(int index){

        HashSet<String> hash = new HashSet<>();
        for (int i = 0; i < C; i++) {
            String cur = "";
            for (int j = index+1; j < R; j++) {
                cur = cur+arr[j][i];
            }
            if(hash.contains(cur)){
                return false;
            }else{
                hash.add(cur);
            }
        }
        return true;

    }

}
