import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.HashSet;
import java.util.Set;

public class Main {
	static Set<Integer> set = new HashSet<>();
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		for (int i = 0; i < 10; i++) {
			int num = Integer.parseInt(br.readLine());
			if (num != 0) {
				set.add(num % 42);
			}
		}
		bw.write(String.valueOf(set.size()));
		bw.flush();
	}
}