package BOJ.Sorting.binarySearch.Gold.P17143;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static int N;
    static long[] arr;
    static long min;
    static long[] answer;
    public static void main(String[] args) throws IOException {

        System.setIn(new FileInputStream("C:\\Users\\SSAFY\\IdeaProjects\\algorithm_java\\src\\Test\\P17143\\input.txt"));
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(bf.readLine());
        arr = new long[N];
        answer = new long[3];
        StringTokenizer st = new StringTokenizer(bf.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Long.parseLong(st.nextToken());
        }
        Arrays.sort(arr);
        min = Long.MAX_VALUE;
        for (int i = 0; i < N; i++) {
            twoPointer(i);
        }
        Arrays.sort(answer);
        System.out.println(answer[0]+" "+answer[1]+" "+answer[2]);
    }
    public static void twoPointer(int x){
        int one = x;
        int two = 0;
        int three = N-1;
        while(two<three){
            if(two==one){
                two++;
                continue;
            }
            if(three==one){
                three--;
                continue;
            }
            if(Math.abs(arr[two]+arr[three]+arr[one])<min){
                min = Math.abs(arr[two]+arr[three]+arr[one]);
                answer[0] = arr[one];
                answer[1] = arr[two];
                answer[2] = arr[three];
            }
            if((arr[two]+arr[three]+arr[one])<min){
                two++;
            }else if((arr[two]+arr[three]+arr[one])==0){
                Arrays.sort(answer);
                System.out.println(answer[0]+" "+answer[1]+" "+answer[2]);
                System.exit(0);
            }else{
                three--;
            }
        }
    }
}
