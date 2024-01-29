package BOJ.PriorityQueue.P7662;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception{

        System.setIn(new FileInputStream("D:\\IntelliJ\\algo\\src\\Test\\input.txt"));
        BufferedReader bf= new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(bf.readLine());
        StringBuilder sb = new StringBuilder();
        for (int test_case = 0; test_case < T; test_case++) {
            PriorityQueue<Number> pq1 = new PriorityQueue<>();
            PriorityQueue<Number> pq2 = new PriorityQueue<>((o1, o2)->{
                return o1.num.compareTo(o2.num);
            });

            int K = Integer.parseInt(bf.readLine());

            for (int i = 0; i < K; i++) {
                StringTokenizer st = new StringTokenizer(bf.readLine());
                char op = st.nextToken().charAt(0);
                if(op=='I'){
                    long num = Long.parseLong(st.nextToken());
                    Number newNum = new Number(num);
                    pq1.add(newNum);
                    pq2.add(newNum);
                }else{
                    int order = Integer.parseInt(st.nextToken());
                    if(order==1){
                        while(!pq1.isEmpty()){
                            Number cur = pq1.poll();
                            if(!cur.deleted){
                                cur.deleted = true;
                                break;
                            }
                        }
                    }else{
                        while(!pq2.isEmpty()){
                            Number cur = pq2.poll();
                            if(!cur.deleted){
                                cur.deleted = true;
                                break;
                            }
                        }
                    }
                }

            }

            long max=Integer.MAX_VALUE, min=Integer.MIN_VALUE;
            boolean wrong = true;
            while(!pq1.isEmpty()){
                Number cur = pq1.poll();
                if(!cur.deleted){
                    max = cur.num;
                    wrong = false;
                    break;
                }
            }
            while(!pq2.isEmpty()){
                Number cur = pq2.poll();
                if(!cur.deleted){
                    min = cur.num;
                    wrong = false;
                    break;
                }
            }
            if(wrong){
                sb.append("EMPTY\n");
            }else{
                sb.append(max+" "+min+"\n");
            }
        }
        System.out.println(sb.toString());
    }
}
class Number implements Comparable<Number> {
    Long num;
    boolean deleted=false;

    Number(long num){
        this.num = num;
    }

    @Override
    public int compareTo(Number o) {
        return o.num.compareTo(num);
    }
}