package BOJ.Greedy.G5.P1339;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int num,max;
    static alphabet[] alphabets;
    public static void main(String[] args) throws Exception{
        System.setIn(new FileInputStream("E:\\SSAFY9\\intelliJ_workspace\\algorithm_java\\src\\BOJ\\G5\\P1339\\input.txt"));
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        num = Integer.parseInt(bf.readLine());
        alphabets = new alphabet[26];
        String word;
        int result = 0;
        for (int i = 0; i < alphabets.length; i++) {
            alphabets[i] = new alphabet(i);
        }

        for (int i = 0; i < num; i++) {
            word = bf.readLine();
            for (int j = 0; j < word.length(); j++) {
                int loc = word.length()-j-1;
                alphabets[word.charAt(j)-'A'].count+=Math.pow(10,loc);
            }
        }

        Arrays.sort(alphabets, Collections.reverseOrder());

        for (int i = 0; i < 9; i++) {
            result += alphabets[i].count*(9-i);
        }
        System.out.println(result);

    }
}
class alphabet implements Comparable<alphabet>{
    int alpha;
    int count;
    alphabet(int alpha){
        this.alpha = alpha;
        count=0;
    }

    @Override
    public int compareTo(alphabet o) {
        return this.count-o.count;
    }
}