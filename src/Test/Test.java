package Test;


import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Test {

    static int[] parent;
    static int[][] graph;

    public static void main(String[] args) {
        // vertex와 간선 개수 구하기
        Arrays.sort(graph, (o1, o2) -> o1[2] - o2[2]);
        // parent 자기 자신으로 초기화
        kruskal();
    }

    public static void union(int x, int y) {
        x = find(x);
        y = find(y);
        if(x < y) parent[y] = x;
        else parent[x] = y;
    }

    public static int find(int x) {
        if(parent[x] == x) return x;
        else return parent[x] = find(parent[x]);
    }

    public static int kruskal(){
        int cost = 0;
        for(int i = 0 ; i < graph.length ; i++){
            if(find(graph[i][0])!=find(graph[i][1])){
                cost += graph[i][2];
                union(graph[i][0], graph[i][1]);
            }
        }
        return cost;
    }
}