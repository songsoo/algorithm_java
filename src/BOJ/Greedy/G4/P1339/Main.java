package BOJ.Greedy.G4.P1339;

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

        // 단어를 읽으면서 알파벳의 위치에 따라 숫자 자리수만큼 알파벳 배열에 더한다.
        for (int i = 0; i < num; i++) {
            word = bf.readLine();
            for (int j = 0; j < word.length(); j++) {
                int loc = word.length()-j-1;
                alphabets[word.charAt(j)-'A'].count+=Math.pow(10,loc);
            }
        }

        // 각 알파벳이 나온 숫자들을 내림차순으로 정렬하고
        Arrays.sort(alphabets, Collections.reverseOrder());

        // 가장 많은 비중을 차지하는 알파벳부터 9를 부여하여 더한다.
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