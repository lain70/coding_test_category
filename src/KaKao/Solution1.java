package KaKao;

import java.util.ArrayList;
import java.util.List;

public class Solution1 {
    public static int solution(List<Integer> box) {
        // Write your code here
        int result = 0;
        long sum = 0;
        for(int b : box){
            sum += b;
        }

        long leftSum = 0;
        long nowSum = 0;
        long now = 0;
        for(int i = 0; i <box.size(); i++ ){
            leftSum += box.get(i);
            sum -= box.get(i);

            if((i == box.size() - 1) || leftSum / (i+1) > sum / (box.size() - (i+1))){
                nowSum = leftSum;
                now = i+1;
                break;
            }
        }

        result = (int)(nowSum / now);

        if(nowSum % now != 0){
            result++;
        }

        return result;
    }
    public static void main(String[] args) {
        List<Integer> box = new ArrayList<>();
        box.add(5);
        box.add(15);
        box.add(19);

        System.out.println(solution(box));
    }
}
