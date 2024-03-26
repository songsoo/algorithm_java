package BOJ.Implement.Silver.P19948;

import java.io.FileInputStream;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws Exception {

        System.setIn(new FileInputStream("C:\\Users\\송수현\\IdeaProjects\\algorithm_java\\src\\Test\\input.txt"));
        Scanner sc = new Scanner(System.in);
        StringTokenizer st1 = new StringTokenizer(sc.nextLine());
        // 26번은 스페이스바 카운트

        int[] alphas = new int[26];
        int[] nums = new int[26];
        boolean flag = true;
        StringBuilder sb = new StringBuilder();

        int spaceCnt = sc.nextInt();
        sc.nextLine();
        StringTokenizer st2 = new StringTokenizer(sc.nextLine());
        for (int i = 0; i < 26; i++) {
            nums[i] = Integer.parseInt(st2.nextToken());
        }
        // 5개라면 countTokens는 5, 띄어쓰기는 4
        if(spaceCnt < st1.countTokens()-1){
            flag = false;
        }else{
            char prevTitle = '%';
            loop:
            while(st1.hasMoreElements()){
                char[] word = st1.nextToken().toUpperCase().toCharArray();
                // 제목추가
                if(prevTitle != word[0]){
                    alphas[word[0]-65]++;
                }
                sb.append(word[0]);

                char prevCont = '%';
                for(char alpha : word){
                    if(prevCont == alpha){
                        continue;
                    }
                    int idx = alpha - 65;
                    if(nums[idx]<++alphas[idx]){
                        flag = false;
                        break loop;
                    }
                    prevCont = alpha;
                }

            }
        }

        System.out.println(flag==true?sb.toString():-1);

    }
}
