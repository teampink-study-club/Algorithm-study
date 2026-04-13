import java.io.*;
import java.util.*;

public class Main {
    static int[][] map;
    static int n, m;
    static int maxSafe = 0;

    static int[] dr = {-1, 1, 0, 0};
    static int[] dc = {0, 0, -1, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        map = new int[n][m];
        for(int i=0; i<n; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<m; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        
        buildWall(0, 0);

        System.out.println(maxSafe);
    }

    static void buildWall(int start, int wallCount) {
        if (wallCount == 3) {
            spreadVirus();
            return;
        }

        for(int idx = start; idx < n * m; idx++) {
            int r = idx / m;
            int c = idx % m;

            if(map[r][c] == 0) {
                map[r][c] = 1;
                buildWall(idx + 1, wallCount + 1);
                map[r][c] = 0;
            }
        }
    }

    // 바이러스 확산
    static void spreadVirus() {
        int[][] copy = new int[n][m];

        for(int i=0; i<n ;i++) {
            copy[i] = map[i].clone();
        }

        Queue<int[]> queue = new ArrayDeque<>();

        for(int i=0; i<n; i++) {
            for(int j=0; j<m; j++) {
                if(copy[i][j] == 2) {
                    queue.offer(new int[]{i, j});
                }
            }
        }

        while(!queue.isEmpty()) {
            int[] cur = queue.poll();
            int r = cur[0];
            int c = cur[1];

            for(int d=0; d<4; d++) {
                int nr = r + dr[d];
                int nc = c + dc[d];

                if(nr<0 || nr>=n || nc<0 || nc>=m) continue;
                if(copy[nr][nc] != 0) continue;

                copy[nr][nc] = 2;
                queue.offer(new int[]{nr, nc});
            }
        }

        countSafeArea(copy);
    }

    // 안전 영역 세기
    static void countSafeArea(int[][] copy) {
        int safe = 0;

        for(int i=0; i<n; i++) {
            for(int j=0; j<m; j++) {
                if(copy[i][j] == 0) {
                    safe++;
                }
            }
        }

        maxSafe = Math.max(maxSafe, safe);
    }
}
