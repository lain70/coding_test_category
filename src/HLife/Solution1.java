package HLife;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class Solution1 {

    public static void main(String[] args) {
        int[] height = new int[]{1,5,3,4,6,4};
        int[] dp = new int[5];
        int[] max = new int[5];

        dp[0] = height[0];
        max[0] = 0;

        Stack<Integer> stack = new Stack<>();

        for(int i = 0 ; i < height.length; i++){
            stack.push(height[i]);
        }
    }

}
