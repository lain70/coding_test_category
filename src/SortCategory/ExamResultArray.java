package SortCategory;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class ExamResultArray {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.valueOf(br.readLine());
        Object[][] arr = new Object[n][4];
        StringTokenizer st;
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            arr[i][0] = st.nextToken();
            for (int j = 1; j < 4; j++) {
                arr[i][j] = Integer.valueOf(st.nextToken());
            }
        }
        Arrays.sort(arr, (a,b) ->{
          if(((int)a[1] == (int)b[1]) && ((int)a[2] == (int)b[2]) && ((int)a[3] == (int)b[3])){
              return a[0].toString().compareTo(b[0].toString());
          }else if(((int)a[1] == (int)b[1]) && ((int)a[2] == (int)b[2])){
              return (int) b[3] - (int) a[3];
          }else if(((int)a[1] == (int)b[1])){
              return (int) a[2] - (int) b[2];
          }else {
              return (int) b[1] - (int) a[1];
          }
        });

        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        for (Object[] ar : arr) {
            bw.write(ar[0].toString());
            bw.newLine();
        }
        bw.flush();
        bw.close();
    }
}
/*
국어 점수가 감소하는 순서로
국어 점수가 같으면 영어 점수가 증가하는 순서로
국어 점수와 영어 점수가 같으면 수학 점수가 감소하는 순서로
모든 점수가 같으면 이름이 사전 순으로 증가하는 순서로 (단, 아스키 코드에서 대문자는 소문자보다 작으므로 사전순으로 앞에 온다.)
12
Junkyu 50 60 100
Sangkeun 80 60 50
Sunyoung 80 70 100
Soong 50 60 90
Haebin 50 60 100
Kangsoo 60 80 100
Donghyuk 80 60 100
Sei 70 70 70
Wonseob 70 70 90
Sanghyun 70 70 80
nsj 80 80 80
Taewhan 50 60 90
 */