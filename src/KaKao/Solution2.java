package KaKao;

import java.util.ArrayList;
import java.util.List;

public class Solution2 {
    static long divInt = (long)(Math.pow(10,9) + 7);
    public static int solution(List<Integer> cost, int x) {
        // Write your code here
        int answer = 0;
        for(int i = cost.size() - 1; i >=0; i--){
            if(cost.get(i) == x){
                answer += (int)(Math.pow(2,i) % divInt);
                break;
            }else if(cost.get(i) < x){
                answer += (int)(Math.pow(2,i) % divInt);
                x = x - cost.get(i);
            }

        }

        return answer;
    }

    public static void main(String[] args) {
//        List<Integer> list = new ArrayList<>();
//        list.add(10);
//        list.add(20);
//        list.add(14);
//        list.add(40);
//        list.add(50);
//        System.out.println(solution(list,70));
        System.out.println((int)(123123123 % divInt));
    }
}
