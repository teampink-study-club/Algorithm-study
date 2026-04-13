import java.io.*;
import java.util.*;

public class Main {
    static ArrayList<Integer>[] graph;
    static boolean[] visited;
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int v = Integer.parseInt(st.nextToken());

        graph = new ArrayList[n+1];
        for(int i=1; i<=n; i++) {
            graph[i] = new ArrayList<>();
        }

        // 양방향 그래프
        for(int i=0; i<m; i++) {
            st = new StringTokenizer(br. readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            graph[a].add(b);
            graph[b].add(a);
        }

        // 작은 번호부터 방문해야 하기 때문에 정렬
        for(int i=1; i<=n; i++) {
            Collections.sort(graph[i]);
        }

        // DFS
        visited = new boolean[n + 1];
        dfs(v);
        sb.append('\n');

        // BFS
        visited = new boolean[n + 1];
        bfs(v);

        System.out.println(sb);
    }

    static void dfs(int now) {
        visited[now] = true;
        sb.append(now).append(' ');

        for(int next : graph[now]) {
            if(!visited[next]) {
                dfs(next);
            }
        }
    }

    static void bfs(int start) {
        Queue<Integer> q = new LinkedList<>();
        q.offer(start);
        visited[start] = true;

        while(!q.isEmpty()) {
            int now = q.poll();
            sb.append(now).append(' ');

            for(int next : graph[now]) {
                if(!visited[next]) {
                    visited[next] = true;
                    q.offer(next);
                }
            }
        }
    }
}
