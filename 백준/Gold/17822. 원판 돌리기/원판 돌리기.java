import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static int N, M, T; // 원판 수, 원판에 적힌 수 개수, 회전 수
	static int[] dx = {-1, 1, 0, 0};
	static int[] dy = {0, 0, -1, 1};
	static int[][] map, temp; // 원판 정보
	static class Info {
		int x, y;
		public Info(int x, int y) {
			super();
			this.x = x;
			this.y = y;
		}
	}
	
	static void rotate(int n, int d, int k) {
		int[] temp = new int[M + 1];
		if (d == 0) { // 시계
			for (int i = 1; i <= M; i++) {
				int idx = i + k;
				if (idx > M)
					idx %= M;
				temp[idx] = map[n][i];
			}
		}
		else { // d == 1 : 반시계
			for (int i = 1; i <= M; i++) {
				int idx = i - k;
				if (idx < 1)
					idx += M;
				temp[idx] = map[n][i];
			}
		}
		map[n] = temp.clone();
	}
	
	static boolean isExist() {
		boolean result = false; // 인접하면서 같은 수가 있는지 여부
		for (int i = 1; i <= N; i++) {
			temp[i] = map[i].clone();
		}
		
		for (int i = 1; i <= N; i++) {
			for (int j = 1; j <= M; j++) {
				if (temp[i][j] == -1) // 이미 지워진 수
					continue;

				Queue<Info> q = new LinkedList<>();
				q.add(new Info(i, j));
				while (!q.isEmpty()) {
					Info cur = q.poll();
					for (int d = 0; d < 4; d++) {
						int nx = cur.x + dx[d];
						int ny = cur.y + dy[d];
						
						// 다른 원판과의 인접 확인 시 인덱스 범위 체크
						if (nx < 1 || nx > N)
							continue;
						
						// 같은 원판의 양 옆 수 인덱스 범위 조정
						if (ny < 1)
							ny += M;
						if (ny > M)
							ny %= M;
						
						// 인접 원판의 값이 같은지, 방문했는지 검사
						if (map[cur.x][cur.y] != map[nx][ny] || temp[nx][ny] == -1)
							continue;
						
						// 인접하면서 수가 같을 경우 수 지우기
						temp[cur.x][cur.y] = -1; // 수 지우기
						temp[nx][ny] = -1; // 수 지우기
						q.add(new Info(nx, ny));
						result = true;
					}
				}
			}
		}
		
		for (int i = 1; i <= N; i++) {
			map[i] = temp[i].clone();
		}
		
		return result;
	}
	
	static void avg() {		
		int cnt = 0;
		int sum = 0;
		for (int i = 1; i <= N; i++) {
			for (int j = 1; j <= M; j++) {
				if (map[i][j] != -1) {
					cnt++;
					sum += map[i][j];
				}
			}
		}
		double avgValue = (double) sum / cnt;
		
		for (int i = 1; i <= N; i++) {
			for (int j = 1; j <= M; j++) {
				if (map[i][j] != -1) {
					if (avgValue > map[i][j]) {
						map[i][j]++;
						continue;
					}
					else if (avgValue < map[i][j])
						map[i][j]--;
				}
			}
		}
	}
	
	static int sum() {
		int result = 0;
		for (int i = 1; i <= N; i++) {
			for (int j = 1; j <= M; j++) {
				if (map[i][j] != -1)
					result += map[i][j];
			}
		}
		return result;
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		T = Integer.parseInt(st.nextToken());
		map = new int[N + 1][M + 1];
		temp = new int[N + 1][M + 1];
		for (int i = 1; i <= N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 1; j <= M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		for (int t = 0; t < T; t++) {
			st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken()); // 회전 원판(x의 배수)
			int d = Integer.parseInt(st.nextToken()); // 회전 방향(0 : 시계, 1 : 반시계)
			int k = Integer.parseInt(st.nextToken()); // k칸 회전
			
			for (int i = 1; i <= N; i++) {
				if (i % x != 0) // x의 배수인 원판만 회전
					continue;
				rotate(i, d, k);
			}
			
			if (!isExist()) {
				avg();
			}
		}
		
		bw.write(String.valueOf(sum()));
		bw.flush();
	}
}