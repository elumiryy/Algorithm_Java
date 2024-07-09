import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    static int[] alpha;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int cnt = 0;
        l1: for (int i = 0; i < N; i++) {
            alpha = new int[26];
            char[] arr = br.readLine().toCharArray();
            for (int j = 0; j < arr.length; j++) {
                int idx = (int) arr[j] - 97;
                // 한 번도 나온 적이 없는 알파벳이라면
                if (alpha[idx] == 0) {
                    alpha[idx] = 1;
                    char c = arr[j];
                    while ((j + 1) < arr.length && c == arr[j + 1]) {
                        j++;
                    }
                    continue;
                }
                // 이미 나온 적이 있는 알파벳이라면
                continue l1;
            }
            cnt++;
        }

        System.out.println(cnt);
    }
}
