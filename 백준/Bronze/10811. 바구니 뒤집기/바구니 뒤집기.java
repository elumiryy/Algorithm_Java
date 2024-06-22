import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	static int[] basket, temp;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		basket = new int[N + 1];
		for (int i = 1; i <= N; i++) {
			basket[i] = i;
		}
		
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			temp = new int[N + 1];
			int cnt = a;
			for (int j = b; j >= a; j--) {
				temp[j] = basket[cnt++];
			}
			for (int j = a; j <= b; j++) {
				basket[j] = temp[j];
			}
		}
		
		for (int i = 1; i <= N; i++) {
			System.out.print(basket[i] + " ");
		}
	}
}