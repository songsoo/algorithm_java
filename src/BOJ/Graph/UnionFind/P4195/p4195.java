package BOJ.Graph.UnionFind.P4195;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;

public class p4195 {
    static int T,F;
    static HashMap<String,friend> map;
    public static void main(String[] args) throws IOException {
        System.setIn(new FileInputStream("C:\\Users\\SSAFY\\IdeaProjects\\algorithm_java\\src\\Test\\Input.txt"));
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        T = Integer.parseInt(bf.readLine());
        StringBuilder sb = new StringBuilder();
        for (int test_case = 0; test_case < T; test_case++) {

            F = Integer.parseInt(bf.readLine());
            map = new HashMap<>();

            for (int i = 0; i < F; i++) {

                StringTokenizer st = new StringTokenizer(bf.readLine());
                String h1 = st.nextToken().trim();
                String h2 = st.nextToken().trim();

                if(!map.containsKey(h1)){
                    map.put(h1,new friend(h1,map.size()));
                }
                if(!map.containsKey(h2)){
                    map.put(h2,new friend(h2,map.size()));
                }

                union(map.get(h1), map.get(h2));

                sb.append(find(map.get(h1)).size+"\n");
            }
        }
        System.out.println(sb.toString());
    }
    public static friend find(friend a){
        if(a.index == a.parent.index){
            return a;
        }return a.parent = find(a.parent);
    }
    public static void union(friend a, friend b){
        a = find(a);
        b = find(b);

        if(a.index != b.index){
            if(a.size>=b.size){
                b.parent = a;
                a.size+=b.size;
            }else{
                a.parent = b;
                b.size += a.size;
            }
        }
    }
}
class friend{
    String name;
    int index;
    friend parent;
    int size;
    friend(String name, int index){
        this.name = name;
        this.index = index;
        this.parent = this;
        this.size = 1;
    }
}
