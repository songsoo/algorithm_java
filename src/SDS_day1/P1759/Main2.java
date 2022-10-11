package SDS_day1.P1759;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class Main2 {


    // 최소 한 개의 모음, 최소 두 개의 자음
    // 알파벳이 증가하는 순서로 배열 (abc:o bac:x)
    // L개의 암호 글자 수 C가지의 문자 종류

    static int L,C;
    static ArrayList<Character> vowel, alphabets;
    static ArrayList<String> result;
    static boolean[] visited;

    public static void main(String[] args) throws Exception{

        System.setIn(new FileInputStream("src/SDS_day1/P1759/input.txt"));
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());

        L = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(bf.readLine());

        vowel = new ArrayList<>();
        vowel.add('a');
        vowel.add('e');
        vowel.add('i');
        vowel.add('u');
        vowel.add('o');

        alphabets= new ArrayList<>();
        visited = new boolean[C];
        result = new ArrayList<>();

        for (int i = 0; i < C; i++) {
            Character newChar = st.nextToken().charAt(0);
            alphabets.add(newChar);
        }

        Collections.sort(alphabets);

        for (int i = 0; i < C; i++) {
            dfs(i,1);
        }

        for (int i = 0; i < result.size(); i++) {
            System.out.println(result.get(i));
        }

    }

    public static void dfs(int idx, int num){

        // 체크인
        // 목적지인가?
        // 들어갈 수 있는가?
        // 들어가기
        // 체크아웃

        visited[idx] = true;
        if(num==L){
            // 여기서 모음, 자음 개수 확인 후 맞으면 결과값 추가
            int vowelCount=0,consoCount=0;
            String a = "";
            for(int i=0;i<C;i++){
                if(visited[i]==true){
                    if(vowel.contains(alphabets.get(i))){
                        vowelCount++;
                    }else{
                        consoCount++;
                    }
                    a = a + (alphabets.get(i).toString());
                }
            }
            if(vowelCount >= 1 && consoCount >= 2){
                result.add(a);
            }
        }else{
            for (int i = idx+1; i < C; i++) {
                dfs(i,num+1);
            }

        }
        visited[idx] = false;

    }


}
