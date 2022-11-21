package SDS.SDS_day1.P1062;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main2 {


    static int N,K,result;
    static ArrayList<String> words;
    static boolean[] alphabets;


    public static void main(String[] args) throws Exception{

        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());

        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        result = 0;

        alphabets = new boolean[26];

        words = new ArrayList<>();

        for(int i=0;i<N;i++){
            st = new StringTokenizer(bf.readLine());
            String word = st.nextToken();
            words.add(word);
        }

        dfs(0,0);

        System.out.println(result);

    }

    public static void dfs(int idx,int count){
        count++;
        alphabets[idx] = true;
        if(count == K){
            int curMaxWords = checkMaxWords();
            if(result<curMaxWords){
                result = curMaxWords;
            }
        }else{
            for(int i=idx+1;i<26;i++){
                if(!alphabets[i]){
                    dfs(i,count);
                }
            }
        }
        alphabets[idx] = false;

    }


    public static int checkMaxWords(){
        int maxNum = 0;
        for(String word : words){
            maxNum++;
            for(int i=0;i<word.length();i++){
                if(!alphabets[word.charAt(i)-'a']){
                    maxNum--;
                    break;
                }
                if(word.charAt(i)<'a' || word.charAt(i)>'z'){
                    maxNum--;
                    break;
                }
            }
        }
        return maxNum;
    }

}
