package DynamicProgram;

import java.io.*;
import java.util.StringTokenizer;

//백준 14501
public class Counselor {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.valueOf(br.readLine());
        int[] days = new int[n+1];
        int[] costs = new int[n+1];
        int[] earn = new int[n+1];
        StringTokenizer st;
        for(int i = 1; i <= n; i++){
            st = new StringTokenizer(br.readLine());
            days[i] = Integer.valueOf(st.nextToken());
            costs[i] = Integer.valueOf(st.nextToken());
        }

        for(int i = 1; i <= n; i++){
            earn[i] = earn[i - 1];
            for(int j = i; j > 0; j--){
                if (i == j + days[j] - 1) {
                    earn[i] = Math.max(earn[i], costs[j] + earn[j - 1]);
                }
            }
        }

        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        bw.write(String.valueOf(earn[n]));
        bw.flush();
        bw.close();
    }
}
