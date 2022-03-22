package Etc;

public class MaskingPhoneNum {
    public String solution(String phone_number) {
    	StringBuilder answer = new StringBuilder();
    	for(int i =0; i < phone_number.length() - 4; i++) {
    		answer.append("*");
    	}
    	answer.append(phone_number.substring(phone_number.length() - 4, phone_number.length()));
        return answer.toString();
    }
    
    public static void main(String[] args) {
    	String phone_number = "01033334444";
    	StringBuilder answer = new StringBuilder();
    	for(int i =0; i < phone_number.length() - 4; i++) {
    		answer.append("*");
    	}
    	answer.append(phone_number.substring(phone_number.length() - 4, phone_number.length()));
    	
		System.out.println(answer.toString());
	}
}
