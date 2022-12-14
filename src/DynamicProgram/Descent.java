package DynamicProgram;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

//백준 2096
public class Descent {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        int[][] map = new int[n][3];

        for(int i =0; i< n; i++){
            map[i] = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        }

        int[][] min = new int[n][3];
        int[][] max = new int[n][3];
        for(int i = 0 ; i <3; i++){
            min[0][i] = max[0][i] = map[0][i];
        }
        for(int i = 1; i < n; i++){
            for(int j = 0; j < 3; j++){
                max[i][j] = calMax(max[i-1], map[i], j);
                min[i][j] = calMin(min[i-1], map[i], j);
            }
        }

        int resultMax = Math.max(Math.max(max[n-1][0], max[n-1][1]), max[n-1][2]);
        int resultMin = Math.min(Math.min(min[n-1][0], min[n-1][1]), min[n-1][2]);

        System.out.println(resultMax + " " + resultMin);
    }

    public static int calMin(int[] preVal, int[] nowVal, int num){
        if(num == 0){   // 현재 1번째 숫자인 경우 이전 1,2와 각각의 합 중에 작은 것을 기록
            return Math.min((preVal[0] + nowVal[0]), (preVal[1] + nowVal[0]));
        }else if(num == 1){   // 현재 2번째 숫자인 경우 이전 1,2,3와 각각의 합 중에 작은 것을 기록
            return Math.min(Math.min((preVal[0] + nowVal[1]), (preVal[1] + nowVal[1])), (preVal[2] + nowVal[1]));
        }else{   // 현재 3번째 숫자인 경우 이전 2,3와 각각의 합 중에 작은 것을 기록
            return Math.min((preVal[1] + nowVal[2]), (preVal[2] + nowVal[2]));
        }
    }

    public static int calMax(int[] preVal, int[] nowVal, int num){
        if(num == 0){   // 현재 1번째 숫자인 경우 이전 1,2와 각각의 합 중에 큰 것을 기록
            return Math.max((preVal[0] + nowVal[0]), (preVal[1] + nowVal[0]));
        }else if(num == 1){   // 현재 2번째 숫자인 경우 이전 1,2,3와 각각의 합 중에 큰 것을 기록
            return Math.max(Math.max((preVal[0] + nowVal[1]), (preVal[1] + nowVal[1])), (preVal[2] + nowVal[1]));
        }else{   // 현재 3번째 숫자인 경우 이전 2,3와 각각의 합 중에 큰 것을 기록
            return Math.max((preVal[1] + nowVal[2]), (preVal[2] + nowVal[2]));
        }
    }
}
