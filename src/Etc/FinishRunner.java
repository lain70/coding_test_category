package Etc;

import java.util.Arrays;

public class FinishRunner {
    public String solution(String[] participant, String[] completion) {
        String answer = "";
        Arrays.sort(participant);
        Arrays.sort(completion);
        
        for(int i = 0; i<participant.length-1; i++) {
        	if(!participant[i].equals(completion[i])) {
        		answer = participant[i];
        		break;
        	}
        	
        	if(i == participant.length-2) {
        		answer = participant[i+1];
        		break;
        	}
        }
        
        return answer;
    }
}
