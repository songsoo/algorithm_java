package Programmers.DFS.타겟넘버;

public class Main {
    public static void main(String[] args) {

        System.out.println(solution(new int[]{1,1,1,1,1},3));

    }
    static int N;
    public static int solution(int[] numbers, int target) {
        int answer = 0;
        N = numbers.length;
        answer = dfs(0,0,numbers,target);
        return answer;
    }

    public static int dfs(int cnt, int tot, int[] numbers, int target){
        int result = 0;
        if(cnt == N){
            if(tot == target){
                return 1;
            }
            return 0;
        }
        result += dfs(cnt+1,tot+numbers[cnt], numbers, target);
        result += dfs(cnt+1,tot-numbers[cnt], numbers, target);

        return result;
    }
}
