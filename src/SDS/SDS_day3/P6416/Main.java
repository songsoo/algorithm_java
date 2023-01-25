package SDS.SDS_day3.P6416;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {

    static ArrayList<Boolean> ans;
    static ArrayList<Node> nodes;

    public static void main(String[] args) throws Exception {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        boolean isFinished = false;

        ans = new ArrayList<>();

        while (true) {
            st = new StringTokenizer(bf.readLine());

            if(nodes==null){
                nodes = new ArrayList<>();
            }

            while (st.countTokens() >= 2) {
                int par = Integer.parseInt(st.nextToken());
                int child = Integer.parseInt(st.nextToken());

                //-1 -1을 만나면 취소
                if (par < 0 && child < 0) {
                    isFinished = true;
                    break;
                } else if (par == 0 && child == 0) {
                    // 구하기 시작, 트리 초기화
                    // 노드 하나의 가장 부모를 찾고
                    // 모든 하위 노드를 돌면서 visited가 한 번 더 갔다거나
                    // visited 중에 false가 있다면 tree가 아니다
                    nodes = null;
                    ans.add(isTree());
                } else {
                    // 트리에 추가
                    Node newNode = new Node(par);
                    //if(){

                    //}
                }


            }

            if (isFinished) {
                break;
            }

        }

    }

    public static boolean isTree() {
        return true;

    }

    public static boolean isNodeInList(int srcNum){
        for (Node node : nodes) {
            if(node.num==srcNum){
                return true;
            }
        }
        return false;
    }


}

class Node {
    int num;
    ArrayList<Node> childs;
    Node(){
        childs = new ArrayList<>();
    }
    Node(int me) {
        this();
        this.num = me;
    }
    public void addChild(Node node){
        childs.add(node);
    }
}