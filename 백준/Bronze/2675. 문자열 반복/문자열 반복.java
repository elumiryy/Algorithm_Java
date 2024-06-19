import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int T = Integer.parseInt(br.readLine());
		for (int t = 0; t < T; t++) {
			st = new StringTokenizer(br.readLine());
			int r = Integer.parseInt(st.nextToken());
			char[] arr = st.nextToken().toCharArray();
			
			for (int i = 0; i < arr.length; i++) {
				for (int j = 0; j < r; j++) {
					System.out.print(arr[i]);
				}
			}
			System.out.println();
		}
	}
}