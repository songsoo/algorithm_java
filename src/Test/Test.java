package Test;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;

public class Test {

    public static void main(String[] args) throws Exception{
        // TODO Auto-generated method stub
        System.setIn(new FileInputStream("C:\\Users\\SSAFY\\IdeaProjects\\algorithm_java\\src\\Test\\Input.txt"));
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        ArrayList<node> nodes = new ArrayList();
        while(true) {
            String str = bf.readLine();
            if(str.equals("-1")) {
                break;
            }
            nodes.add(new node(str));
        }

        Collections.sort(nodes);

        for(node a : nodes) {
            System.out.println(a.url);
        }
    }

}
class node implements Comparable<node>{
    String url;
    int num;
    node(String url){
        this.url = url;
        this.num = (int)(Math.random()*10000);
    }
    @Override
    public int compareTo(node o) {
        // TODO Auto-generated method stub
        return this.num - o.num;
    }
}