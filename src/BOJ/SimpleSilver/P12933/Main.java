package BOJ.SimpleSilver.P12933;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class Main {
    static char[] label = {'q','u','a','c','k'};
    static char[] str;
    static boolean[] visited;
    static int N, ducks, sounds;
    public static void main(String[] args) throws Exception{
        System.setIn(new FileInputStream("D:\\IntelliJ\\algo\\src\\Test\\input.txt"));
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        str = bf.readLine().toCharArray();
        N = str.length;
        visited = new boolean[N];
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < N; i++) {
            if(str[i]=='q'){
                queue.add(i);
            }
        }
        ducks = 0;
        sounds = 0;
        if(N%5==0){
            while(!queue.isEmpty()){
                int cur = queue.poll();
                if(findDuck(0,cur,0)){
                    ducks++;
                }
            }
            if(sounds * 5 == N){
                System.out.println(ducks);
            }else{
                System.out.println(-1);
            }

        }else{
            System.out.println(-1);
        }
    }
    public static boolean findDuck(int index, int start, int count){
        if(index==5){
            findDuck(0, start, count+1);
            sounds++;
            return true;
        }

        while(start<N){
           if(str[start]==label[index] && !visited[start]){
               if(findDuck(index+1, start+1, count)){
                   visited[start] = true;
                   return true;
               }
           }
           start++;
        }
        return false;
    }
}
