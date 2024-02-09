package BOJ.BruteForce.SequentialSearch.Silver.P2503;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main3 {

    static int N, result;
    static int[][] questions;
    static int[] strikes, balls;

    public static void main(String[] args) throws Exception{
        System.setIn(new FileInputStream("D:\\IntelliJ\\algorithm_java\\src\\BOJ\\S3\\P2503\\input.txt"));
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());

        N = Integer.parseInt(st.nextToken());
        result = 0;
        questions = new int[N][3];
        strikes = new int[N];
        balls = new int[N];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(bf.readLine());
            int value = Integer.parseInt(st.nextToken());
            questions[i][0] = value/100;
            questions[i][1] = value/10%10;
            questions[i][2] = value%10;
            strikes[i] = Integer.parseInt(st.nextToken());
            balls[i] = Integer.parseInt(st.nextToken());
        }

        // 123 ~ 987을 돌면서
        for (int i = 123; i <= 987; i++) {
            // 겹치는 숫자가 있거나 0이 들어가면 continue;
            if(hasZero(i)||isOverlapping(i)){
                continue;
            }
            // 각각의 질문지를 확인하고 strike와 ball이 맞는지 확인한다.
            // 개수가 맞다면 result를 증가시킨다.
            if(checkBall(i) && checkStrike(i)){
                result++;
            }

        }

        System.out.println(result);

    }
    public static boolean hasZero(int i){
        int arr[] = {i/100,i/10%10,i%10};
        for (int j = 0; j < 3; j++) {
            if(arr[j]==0){
                return true;
            }
        }
        return false;
    }

    public static boolean isOverlapping(int i){
        int arr[] = {i/100,i/10%10,i%10};
        for (int j = 0; j < 3-1; j++) {
            for (int k = j+1; k < 3; k++) {
                if(arr[j]==arr[k]){
                    return true;
                }
            }
        }
        return false;
    }


    public static boolean checkStrike(int i){
        int arr[] = {i/100,i/10%10,i%10};
        // 각각의 question과 비교해서
        for (int j = 0; j < N; j++) {
            int count=0;
            // 각 배열 위치와 같은 정답의 수를 count한다.
            for (int k = 0; k < 3; k++) {
                if(questions[j][k] == arr[k]){
                    count++;
                }
            }
            // 하나라도 다르면 return false;
            if(strikes[j]!=count){
                return false;
            }

        }
        // 모두 같으면 return true;
        return true;
    }

    public static boolean checkBall(int i){
        int arr[] = {i/100,i/10%10,i%10};
        // 각각의 question과 비교해서
        for (int j = 0; j < N; j++) {
            int count=0;
            // 질문하는 녀석의 숫자 하나와 정답으로 들어온 녀석 모두와 비교하여 하나라도 같으면 count 증가
            for (int k = 0; k < 3; k++) {
                for (int l = 0; l < 3; l++) {
                    // Strike는 배제한다.
                    if(k==l){
                        continue;
                    }
                    if (questions[j][k] == arr[l]) {
                        count++;
                        break;
                    }
                }
            }
            // 하나라도 다르면 return false;
            if(balls[j]!=count){
                return false;
            }

        }
        // 모두 같으면 return true;
        return true;
    }

}
