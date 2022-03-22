package DynamicProgram;

public class MakeBottom {
	public static void main(String[] args) {
		int target = 3;
		int[] save = new int[8];
		save[0] = 1;
		save[1] = 3;
		
		for(int i = 2; i < target; i++) {
			save[i] = save[i - 1] + (save[i-2]*2); 
		}
		
		System.out.println(save[target - 1]);
	}
}
