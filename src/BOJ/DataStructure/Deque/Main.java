package BOJ.DataStructure.Deque;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int N;
    static Deque<Integer> queue;
    public static void main(String[] args) throws Exception{
        System.setIn(new FileInputStream("C:\\Users\\송수현\\IdeaProjects\\algorithm_java\\src\\Test\\input.txt"));
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(bf.readLine());
        queue = new LinkedList<>();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(bf.readLine());
            String op = st.nextToken();

            if(op.equals("push")){
                int num = Integer.parseInt(st.nextToken());
                queue.add(num);
            }else if(op.equals("pop")){
                if(queue.isEmpty()){
                    sb.append("-1"+"\n");
                }else{
                    sb.append(queue.pop()+"\n");
                }
            }else if(op.equals("size")){
                sb.append(queue.size()+"\n");
            }else if(op.equals("empty")){
                sb.append(queue.isEmpty()?"1":"0").append("\n");
            }else if(op.equals("front")){
                if(queue.isEmpty()){
                    sb.append("-1\n");
                }else{
                    sb.append(queue.getFirst()+"\n");
                }
            }else if(op.equals("back")){
                if(queue.isEmpty()){
                    sb.append("-1\n");
                }else{
                    sb.append(queue.getLast()+"\n");
                }
            }
        }
        System.out.println(sb.toString());
    }


}
