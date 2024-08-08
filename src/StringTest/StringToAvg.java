package StringTest;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class StringToAvg {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st;
        float scoerSum = 0.0f;
        float sum = 0.0f;
        for(int i = 0; i < 20; i++){
            st = new StringTokenizer(br.readLine());
            String subject = st.nextToken();
            float score = Float.valueOf(st.nextToken());
            String grade = st.nextToken();

            if(!"P".equals(grade)){
                float gradeScore = gradeToFloat(grade);
                scoerSum += score;
                sum += score * gradeScore;
            }
        }
        System.out.println(Math.round((sum / scoerSum) * 1000000) / 1000000.0f);
    }

    static float gradeToFloat(String grade){
        switch (grade){
            case "A+": return 4.5f;
            case "A0": return 4.0f;
            case "B+": return 3.5f;
            case "B0": return 3.0f;
            case "C+": return 2.5f;
            case "C0": return 2.0f;
            case "D+": return 1.5f;
            case "D0": return 1.0f;
            default: return 0.0f;
        }
    }
}
