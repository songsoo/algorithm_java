package BOJ.CumulativeSum.Gold.P2632;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class Main {

    static ArrayList<Integer> leftPizza, rightPizza;
    public static void main(String[] args) throws Exception{
        System.setIn(new FileInputStream("D:\\IntelliJ_Repository\\src\\Test\\input.txt"));
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        int size = Integer.parseInt(bf.readLine());
        int result = 0;
        leftPizza = new ArrayList<>();
        rightPizza = new ArrayList<>();

        StringTokenizer st = new StringTokenizer(bf.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        int sum = 0;
        for (int i = 0; i < n; i++) {
            int pieceSize = Integer.parseInt(bf.readLine());
            leftPizza.add(pieceSize);
            sum += pieceSize;
            if(pieceSize==size){
                result++;
            }
        }

        for (int i = 0; i < n; i++) {
            int cur = leftPizza.get(i);
            int j = i+1;
            int limit = i-1<0?n-1:i-1;
            while(true){
                if(j==n){
                    j = 0;
                }
                if(j==limit){
                    break;
                }
                cur += leftPizza.get(j);
                if(cur==size){
                    result++;
                    break;
                }else if(cur < size){
                    leftPizza.add(cur);
                }else{
                    break;
                }
                j++;
            }
        }

        if(n>1 && sum < size){
            leftPizza.add(sum);
        }else if(sum == size){
            result++;
        }


        sum = 0;
        for (int i = 0; i < m; i++) {
            int pieceSize = Integer.parseInt(bf.readLine());
            rightPizza.add(pieceSize);
            if(pieceSize==size){
                result++;
            }
            sum += pieceSize;
        }

        for (int i = 0; i < m; i++) {
            int cur = rightPizza.get(i);
            int j = i+1;
            int limit = i-1<0?m-1:i-1;
            while(true){
                if(j==m){
                    j = 0;
                }
                if(j==limit){
                    break;
                }
                cur += rightPizza.get(j);
                if(cur==size){
                    result++;
                    break;
                }else if(cur < size){
                    rightPizza.add(cur);
                }else{
                    break;
                }
                j++;
            }
        }

        if(m>1 && sum < size){
            rightPizza.add(sum);
        }else if(sum == size){
            result++;
        }

        Collections.sort(leftPizza);
        Collections.sort(rightPizza);

        int p = 0;
        int q = rightPizza.size()-1;

        while(p<leftPizza.size() && q>=0){

            int left = leftPizza.get(p);
            int right = rightPizza.get(q);
            if(left+right == size){
                int sameCntLeft = 1;
                int sameCntRight = 1;
                while(++p<leftPizza.size() && leftPizza.get(p)==left){
                    sameCntLeft++;
                }
                while(--q>=0 && rightPizza.get(q)==right){
                    sameCntRight++;
                }
                 result += sameCntLeft * sameCntRight;

            }else if(left+right > size){
                q--;
            }else{
                p++;
            }

        }

        System.out.println(result);

    }
}
