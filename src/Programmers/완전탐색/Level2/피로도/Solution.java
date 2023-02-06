package Programmers.완전탐색.Level2.피로도;

public class Solution {

    public static void main(String[] args) {

    }

    static boolean[] visited;
    static int n, max;
    public int solution(int k, int[][] dungeons) {
        int answer = -1;
        max = 0;
        n = dungeons.length;
        visited = new boolean[dungeons.length];

        goNext(k,n, dungeons,0);

        return max;
    }

    // k: 피로도 , n: 최대 개수 cur: 현재 위치
    public static void goNext(int k ,int n, int[][] dungeons,int index){
        for (int i = 0; i < n; i++) {
            if(!visited[i] && k - dungeons[i][0]>=0){
                visited[i] = true;
                goNext(k-dungeons[i][1],n, dungeons, index+1);
                visited[i] = false;
            }
        }
        max = Math.max(max, index);

    }
}
