package SDS.SDS_day3.P1991;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

// 트리의 시작점이 불분명하고 알파벳 순서로 노드가 나오는 것이 확실하지 않다고 가정했을 때
public class Main {
    static int N;
    static Node[] tree;
    public static void main(String[] args) throws Exception{
        System.setIn(new FileInputStream("src/SDS.SDS_day3/P1991/input.txt"));
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());

        N = Integer.parseInt(st.nextToken());
        tree = new Node[N];
        for (int i = 0; i < N; i++) {
            tree[i] = new Node((char)('A'+i));
        }
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(bf.readLine());
            int a = st.nextToken().charAt(0)-'A';
            int b = st.nextToken().charAt(0)-'A';
            int c = st.nextToken().charAt(0)-'A';
            if(b!=-19){
                tree[a].setLeft(tree[b]);
            }
            if(c!=-19) {
                tree[a].setRight(tree[c]);
            }
        }

        preOrder(tree[0]);

    }

    public static void preOrder(Node node){

        System.out.print(node.chr);
        if(node.left!=null){
            preOrder(node.left);
        }
        if(node.right!=null){
            preOrder(node.right);
        }
    }

}
class Node{
    char chr;
    Node left;
    Node right;
    Node(char newChr){
        this.chr = newChr;
        left = null;
        right = null;
    }

    public void setLeft(Node newLeft){
        this.left = newLeft;
    }
    public void setRight(Node newRight){
        this.right = newRight;
    }

}