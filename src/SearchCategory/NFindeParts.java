package SearchCategory;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class NFindeParts {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = Integer.valueOf(sc.nextLine());
        int[] parts = Arrays.stream(sc.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int m = Integer.valueOf(sc.nextLine());
        int[] finds = Arrays.stream(sc.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();

        List<Integer> partsList = Arrays.stream(parts).boxed().collect(Collectors.toList());
        Collections.sort(partsList);
        parts =  partsList.stream().mapToInt(Integer::intValue).toArray();

        for(int i = 0; i < m; i++){
            if(bSearch(parts,finds[i])){
                System.out.println("yes");
            }else{
                System.out.println("no");
            }
        }
    }

    public static boolean bSearch(int[] arr, int idx){
        int start = 0;
        int end = arr.length;

        while(start <= end){
            int mid = (start + end) / 2;

            if(idx == arr[mid]){
                return true;
            }
            if(idx > arr[mid]){
                start = mid + 1;
            }else{
                end = mid -1;
            }
        }
        return false;
    }
}
