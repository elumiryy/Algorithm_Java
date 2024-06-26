import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		char[] a = st.nextToken().toCharArray();
		char[] b = st.nextToken().toCharArray();
		
		char[] aa = new char[3];
		char[] bb = new char[3];
		
		for (int i = 0; i < 3; i++) {
			aa[i] = a[2 - i];
			bb[i] = b[2 - i];
		}
		
		int aaa = Integer.parseInt(String.valueOf(aa));
		int bbb = Integer.parseInt(String.valueOf(bb));
		
		System.out.println(Math.max(aaa, bbb));
	}
}