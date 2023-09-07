package Test;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Deque;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class P2346 {
    public static void main(String[] args) throws Exception {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int a = Integer.parseInt(bf.readLine());
        StringTokenizer st = new StringTokenizer(bf.readLine());
        Deque<item> b = new LinkedList<>();

        for (int i = 1; i <= a; i++) {
            b.add(new item(Integer.parseInt(st.nextToken()), i));
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 1; i < a; i++) {
            System.out.println(b.toString());
            item cur = b.removeFirst();
            int num = cur.num;

            if(num<0){
                b.addFirst(b.removeLast());
            }

            sb.append(cur.order);
            int j = 0;
            if(num>=0){
                num = (num-1) % b.size();
                System.out.println("go in"+j+" "+num);
                while(j<num){
                    System.out.println("loop"+j+" "+ num);
                    b.addLast(b.removeFirst());
                    j++;
                }
            }else if(num<0){
                num = (num) % b.size();
                while(j>num+1){
                    b.addFirst(b.removeLast());
                    j--;
                }
            }

        }
        sb.append(b.remove().order);
        System.out.println(sb.toString());
    }
}
class item {
    int num;
    int order;

    item(int num, int order) {
        this.num = num;
        this.order = order;
    }

    @Override
    public String toString() {
        return "["+num+","+order+"]";
    }
}
