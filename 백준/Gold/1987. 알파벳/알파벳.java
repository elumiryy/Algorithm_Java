import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {
	static int R, C, max;
	static int[] dx = {-1, 1, 0, 0};
	static int[] dy = {0, 0, -1, 1};
	static int[][] map;
	static boolean[] visited = new boolean[26];
	
	static void dfs(int x, int y, int cnt) {
		if (visited[map[x][y]]) {
			max = Math.max(max, cnt);
			return;
		}
		
		visited[map[x][y]] = true;
		
		for (int d = 0; d < 4; d++) {
			int nx = x + dx[d];
			int ny = y + dy[d];
			if (nx < 0 || ny < 0 || nx >= R || ny >= C)
				continue;
			dfs(nx, ny, cnt + 1);
		}
		
		visited[map[x][y]] = false;
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		map = new int[R][C];
		for (int i = 0; i < R; i++) {
			char[] temp = br.readLine().toCharArray();
			for (int j = 0; j < C; j++) {
				map[i][j] = temp[j] - 'A';
			}
		}
		
		dfs(0, 0, 0);
		
		if (max == 0)
			max = 1;
		
		bw.write(String.valueOf(max));
		bw.flush();
	}
}