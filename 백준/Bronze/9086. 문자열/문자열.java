import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for (int t = 0; t < T; t++) {
			char[] arr = br.readLine().toCharArray();
			System.out.print(arr[0]);
			System.out.println(arr[arr.length - 1]);
		}
	}
}