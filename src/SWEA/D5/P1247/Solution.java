package SWEA.D5.P1247;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {

    static int T, size, max;
    static home[] arr;
    static home start, end;
    static boolean[] visited;
    static int[][] distance;
    public static void main(String[] args) throws Exception{
        System.setIn(new FileInputStream("src/SWEA/D5/P1247/input.txt"));
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());

        T = Integer.parseInt(st.nextToken());


        for (int i = 0; i < T; i++) {
            st = new StringTokenizer(bf.readLine());
            size = Integer.parseInt(st.nextToken());
            size++;
            arr = new home[size];
            visited = new boolean[size];

            st = new StringTokenizer(bf.readLine());
            max = Integer.MAX_VALUE;
            start = new home(Integer.parseInt(st.nextToken()),Integer.parseInt(st.nextToken()));
            end = new home(Integer.parseInt(st.nextToken()),Integer.parseInt(st.nextToken()));
            arr[0] = start;
            for (int j = 1; j < size; j++) {
                arr[j] = new home(Integer.parseInt(st.nextToken()),Integer.parseInt(st.nextToken()));
            }

            distance = new int[size][size];
            for (int j = 0; j < size; j++) {
                for (int k = 0; k < size; k++) {
                    distance[j][k] = getDist(arr[j],arr[k]);
                }
            }

            goNext(0,0,1);
            System.out.println("#"+(i+1)+" "+max);
        }

    }

    public static void goNext(int cur,int sum, int index){
        //인덱스 확인 후 리턴 (index는 1로 시작)
        //끝날 때 end와 비교 후 추가

        if(index==size){
            sum+=getDist(arr[cur],end);
            max = Math.min(sum,max);
        }

        visited[cur] = true;

        //for 남은 것들 중
        for (int i = 0; i < size; i++) {
            if(!visited[i]){
                int newSum = sum+distance[cur][i];
                //int newSum = sum+getDist(arr[cur],arr[i]);
                goNext(i,newSum,index+1);
            }
        }
        visited[cur] = false;

    }

    public static int getDist(home h1, home h2){
        return Math.abs(h1.x-h2.x)+Math.abs(h1.y-h2.y);
    }

}

class home{
    int x;
    int y;
    home(int x, int y){
        this.x = x;
        this.y = y;
    }
    public String toString(){
        return x + " " + y;
    }
}
