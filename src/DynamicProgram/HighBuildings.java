package DynamicProgram;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class HighBuildings {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] buildings = new int[n];

        for(int i = 0; i < buildings.length; i++){
            Stack<Integer> stack = new Stack<>();
            stack.push(buildings[i]);
            int j = 0;
            while (!stack.isEmpty()){
            }

        }
    }
}
