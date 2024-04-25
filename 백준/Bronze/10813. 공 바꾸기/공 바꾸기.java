import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {
	static int N, M; // 바구니 수, 공 넣는 횟수
	static int[] basket;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuffer sb = new StringBuffer();
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		basket = new int[N + 1];
		for(int i = 1; i <= N; i++) {
			basket[i] = i;
		}
		
		for (int m = 1; m <= M; m++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int temp = basket[a];
			basket[a] = basket[b];
			basket[b] = temp;
		}
		
		for (int i = 1; i <= N; i++) {
			sb.append(basket[i]).append(" ");
		}
		
		bw.write(String.valueOf(sb));
		bw.flush();
	}
}