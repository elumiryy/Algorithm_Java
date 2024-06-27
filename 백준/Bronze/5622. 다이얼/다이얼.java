import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	static String[] tel = { "ABC", "DEF", "GHI", "JKL", "MNO", " PQRS", "TUV", "WXYZ" };
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		char[] arr = br.readLine().toCharArray();
		
		int time = 0; // 3초 더하기
		for (int i = 0; i < arr.length; i++) {
			for (int j = 0; j < tel.length; j++) {
				if (tel[j].contains(String.valueOf(arr[i]))) {
					time += (3 + j);
					break;
				}
			}
		}
		
		System.out.println(time);
	}
}