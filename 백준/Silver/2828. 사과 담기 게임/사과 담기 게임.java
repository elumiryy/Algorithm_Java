import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {
	static int N, M, start, end, dis;
	static int[] apple;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		apple = new int[Integer.parseInt(br.readLine())];
		for (int i = 0; i < apple.length; i++) {
			apple[i] = Integer.parseInt(br.readLine());
		}
		
		start = 1;
		end = M;
		for (int i = 0; i < apple.length; i++) {
			// 사과가 바구니 안에 떨어지면
			if (start <= apple[i] && apple[i] <= end) {
				continue;
			}
			
			// 사과가 바구니 왼쪽으로 떨어지면
			if (apple[i] < start) {
				// 바구니 왼쪽 이동
				start--;
				end--;
			} else { // 사과가 바구니 오른쪽으로 떨어지면
				// 바구니 오른쪽 이동
				start++;
				end++;
			}
			
			dis++; // 이동 거리 증가
			i--; // 다시 체크하기 위해 i 감소
			
			// 사과가 바구니 오른쪽으로 떨어지면
		}
		
		bw.write(String.valueOf(dis));
		bw.flush();
	}
}