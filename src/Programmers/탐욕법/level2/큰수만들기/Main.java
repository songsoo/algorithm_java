package Programmers.탐욕법.level2.큰수만들기;
public class Main {
    public static void main(String[] args) {
        String num = "7231072";
        int num2 = 2;
        String a = solution(num,num2);;
        System.out.println(a);

    }

    public static String solution(String number, int k) {
        String answer = "";
        int N = number.length();
        k = N-k;
        int start = 0;
        for (int i = 0; i < k; i++) {
            int j;
            int max = 0;
            for (j = start; j <= N-(k-i); j++) {
                if(number.charAt(j)-'0'>max){
                    start = j+1;
                    max = number.charAt(j)-'0';
                }
            }
            answer+=max;
        }
        int count =0 ;
        for (int i = 0; i < k; i++) {
            if(answer.charAt(i)=='0'){
                count++;
            }else{
                break;
            }
        }
        answer = answer.substring(count);
        return answer;
    }
}
