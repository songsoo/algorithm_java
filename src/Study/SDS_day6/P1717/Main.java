package Study.SDS_day6.P1717;
// Union-Find
// DisJoint Set을 표현할 때 사용
// A-B-C-D, E-F-G H-I 와 같은 형식일 때
// 경로 상의 vertex를 구할 수 있다 (A->D가 가능한가? A-B-D가 가능한가? 등)
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    static int[] parent, depth;

    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        parent = new int[N + 1];
        depth = new int[N + 1];

        for (int i = 1; i <= N; i++) {
            parent[i] = i;
            depth[i] = 1;
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int command = Integer.parseInt(st.nextToken());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            if (command == 0) {
                union(a, b);
            } else if (command == 1) {
                sb.append((find(a) == find(b) ? "YES" : "NO") + "\n");
            } else {
                continue;
            }
        }
        System.out.println(sb);
        br.close();
    }


    public static int find(int x) {
        // 재귀를 돌면서 자신의 부모를 찾아 return
        if (x == parent[x]) {
            return parent[x] = x;
        }
        return parent[x] = find(parent[x]);
    }

    public static void union(int x, int y) {
        x = find(x);
        y = find(y);
        // 가장 높은 단을 비교했을 때, 같으면 cycle이 생기니까 X, 다르면?
        if (x != y) {
            // depth가 x가 더 작으면 바꾸기
            // 1-2-3 , 4-5 일 때 union (5,3)은 4와 1을 비교하니까 depth가 더 높은 1로 합치는거로 다시 바꿈
            if (depth[x] < depth[y]) {
                int tmp = x;
                x = y;
                y = tmp;
            }
            // depth가 같다면 자신의 밑으로 들어옴 (depth가 다르면 그냥 다른 자식의 형제가 되는 꼴이라 늘리지 않음)
            parent[y] = x;
            if (depth[x] == depth[y]) depth[x]++;
        }
    }

}