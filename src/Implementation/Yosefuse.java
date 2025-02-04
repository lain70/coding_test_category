package Implementation;

import java.io.*;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Yosefuse {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.valueOf(st.nextToken()), k = Integer.valueOf(st.nextToken());
        Queue<Integer> queue = new LinkedList<>();
        for(int i = 1; i <= n; i++){
            queue.offer(i);
        }

        StringBuffer sb = new StringBuffer("<");
        int idx = 1;
        while(queue.size() != 1) {
            // K - 1번째까지는 처음에 있던 값을 맨 뒤로 보낸다.
            for (int i = 0; i < k - 1; i++) {
                queue.offer(queue.poll());
            }
            // K번째 값은 poll한 후 출력한다.
            sb.append(queue.poll() + ", ");
        }
        sb.append(queue.poll() + ">");

        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        bw.write(sb.toString());
        bw.flush();
        bw.close();
    }
}