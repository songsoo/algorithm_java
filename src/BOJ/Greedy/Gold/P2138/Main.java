package BOJ.Greedy.Gold.P2138;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    static char[] prev, tmp, next;
    static final int max = 1000000000;
    public static void main(String[] args) throws Exception{
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(bf.readLine());
        prev = (bf.readLine()+" ").toCharArray();
        tmp = Arrays.copyOf(prev,prev.length);
        next = (bf.readLine()+" ").toCharArray();
        int cnt1 = 0;
        for (int i = 1; i < N; i++) {
            if(prev[i-1]!=next[i-1]){
                cnt1++;
                prev[i-1] = prev[i-1]=='0'?'1':'0';
                prev[i] = prev[i]=='0'?'1':'0';
                prev[i+1] = prev[i+1]=='0'?'1':'0';
            }
            if(prev[i-1]!=next[i-1]){
                cnt1 = max;
                break;
            }
        }
        if(prev[N-1]!=next[N-1] || prev[N-2]!=next[N-2]){
            cnt1 = max;
        }

        int cnt2 = 1;
        tmp[0] = tmp[0]=='0'?'1':'0';
        tmp[1] = tmp[1]=='0'?'1':'0';
        for (int i = 1; i < N; i++) {
            if(tmp[i-1]!=next[i-1]){
                cnt2++;
                tmp[i-1] = tmp[i-1]=='0'?'1':'0';
                tmp[i] = tmp[i]=='0'?'1':'0';
                tmp[i+1] = tmp[i+1]=='0'?'1':'0';
            }
            if(tmp[i-1]!=next[i-1]){
                cnt2 = max;
                break;
            }
        }
        if(tmp[N-1]!=next[N-1] || tmp[N-2]!=next[N-2]){
            cnt2 = max;
        }

        int min = Math.min(cnt1,cnt2);
        System.out.println(min==max?-1:min);
    }

}
