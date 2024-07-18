import java.io.*;
import java.util.StringTokenizer;

public class Main {
    static int[][] map;
    static int max = 0;
    static int x, y;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;
        for (int i = 0; i < 9; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 9; j++) {
                int n = Integer.parseInt(st.nextToken());
                if (max < n) {
                    max = n;
                    x = i;
                    y = j;
                }
            }
        }

        sb.append(max).append("\n").append(x + 1).append(" ").append(y + 1);
        bw.write(String.valueOf(sb));
        bw.flush();
    }
}
