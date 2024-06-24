import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		
		for (int i = 0; i < N; i++) {
			int step = 2 * i + 1;
			for (int j = 0; j < N - i - 1; j++) {
				System.out.print(" ");
			}
			for (int j = 0; j < step; j++) {
				System.out.print("*");
			}
			System.out.println();
		}
		
		int cnt = 1;
		for (int i = N - 2; i >= 0; i--) {
			int step = 2 * i + 1;
			for (int j = 0; j < cnt; j++) {
				System.out.print(" ");
			}
			for (int j = 0; j < step; j++) {
				System.out.print("*");
			}
			System.out.println();
			cnt++;
		}
	}
}