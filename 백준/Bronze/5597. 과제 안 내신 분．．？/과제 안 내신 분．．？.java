import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	static int[] check = new int[31];
	static int[] result = new int[2];
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		for (int i = 0; i < 28; i++) {
			int num = Integer.parseInt(br.readLine());
			check[num] = 1;
		}
		
		int cnt = 0;
		for (int i = 1; i <= 30; i++) {
			if (check[i] == 0) {
				result[cnt++] = i;
				if (cnt == 2)
					break;
			}
		}
		
		Arrays.sort(result);
		
		System.out.println(result[0]);
		System.out.println(result[1]);
	}
}