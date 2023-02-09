package BOJ.G5.P1759;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class Main {
    // L : 고른 알파벳 수, C : 전체 알파벳 수
    // 자음 최소 2개 모음 최소 1개
    static int L,C;
    static boolean[] visited;
    static ArrayList<Character> words;
    public static void main(String[] args) throws Exception{
        System.setIn(new FileInputStream("D:\\IntelliJ\\algorithm_java\\src\\BOJ\\G5\\P1759\\input.txt"));
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st  =new StringTokenizer(bf.readLine());

        L = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        words = new ArrayList();
        visited = new boolean[C];

        st = new StringTokenizer(bf.readLine());
        for (int i = 0; i < C; i++) {
            words.add(st.nextToken().charAt(0));
        }
        Collections.sort(words);
        getPass(0,0,"",-1);

    }

    public static void getPass(int vCount, int cCount,String str,int idx){
        if(vCount+cCount==L){
            if(vCount<1 || cCount<2){
                return;
            }
            System.out.println(str);
        }
        int v=0,c=0;
        for (int i = idx+1; i < C; i++) {
            if(!visited[i]) {
                visited[i]=true;
                if (isVowel(words.get(i))) {
                    getPass(vCount+1, cCount, str + words.get(i), i);
                } else {
                    getPass(vCount, cCount+1, str + words.get(i), i);
                }
                visited[i]=false;
            }
        }

    }

    public static boolean isVowel(char word){
        if(word=='a' || word=='i'||word=='e'||word=='o'||word=='u'){
            return true;
        }
        return false;
    }

}
