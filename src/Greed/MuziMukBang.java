package Greed;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

public class MuziMukBang {
	public int solution(int[] food_times, long k) {
        int answer = 0;
        
        if(food_times.length > k) {
        	return (int)k;
        }else if(food_times.length == k) {
        	return 1;
        }
        
        // 전체 음식을 먹는 시간보다 k가 크거나 같다면 -1
        long summary = 0;
        for (int i = 0; i < food_times.length; i++) {
            summary += food_times[i];
        }
        if (summary <= k) return -1;
        
        int i = 0;
        while(i <= k) {
        	if(food_times[answer] == 0) {
        		answer++;
        		continue;
        	}
        	
        	food_times[answer]--;       
        	
        	if(answer == food_times.length - 1) {
        		answer = 0;
        	}else {
        		answer++;
        	}
        	i++;
        	
        }
        return answer;
    }
	
	class FoodsTime implements Comparable<FoodsTime> {
		int time;
		int idx;
		
		public FoodsTime(int time, int idx) {
			this.time = time;
			this.idx = idx;
		}

		public int getTime() {
			return time;
		}

		public int getIdx() {
			return idx;
		}
		
		@Override
		public int compareTo(FoodsTime ft) {
			return Integer.compare(this.time, ft.time);
		}
	}
	
	public int solution2(int[] food_times, long k) {
        int answer = 0;
        
        if(food_times.length > k) {
        	return (int)k + 1;
        }else if(food_times.length == k) {
        	return 1;
        }
        
        // 전체 음식을 먹는 시간보다 k가 크거나 같다면 -1
        long summary = 0;
        for (int i = 0; i < food_times.length; i++) {
            summary += food_times[i];
        }
        if (summary <= k) return -1;
        
        PriorityQueue<FoodsTime> pq = new PriorityQueue<FoodsTime>();
        
        for(int i = 0; i < food_times.length; i++) {
        	pq.offer(new FoodsTime(food_times[i], i+1));
        }
        
        int eatTime = 0;
        int preTime = 0;
        int length = food_times.length;
        while(eatTime + ((pq.peek().getTime() - preTime) * length) <= k) {
        	int now = pq.poll().getTime();
        	eatTime += (now - preTime) * length;
        	length--;
        	preTime = now;
        }
        
        List<FoodsTime> list = new ArrayList<>();
        while(!pq.isEmpty()) {
        	list.add(pq.poll());
        }
        
        Collections.sort(list, new Comparator<FoodsTime>() {
        	@Override
        	public int compare(FoodsTime o1, FoodsTime o2) {
        		return Integer.compare(o1.getIdx(), o2.getIdx());
        	}
		});
        
        answer = list.get((int)(k - eatTime) % food_times.length).getIdx();

        return answer;
    }
	
	public static void main(String[] args) {
		int[] food_times = {3, 1, 2};
		int k = 5;
		
		int[] food_times2 = {4,2,3,6,7,1,5,8};
		int k2 = 16;//3
		
		int[] food_times3 = {4,2,3,6,7,1,5,8};
		int k3 = 5;//5
		
		MuziMukBang mmb = new MuziMukBang();
		
		System.out.println(mmb.solution2(food_times, k));

		System.out.println(mmb.solution2(food_times2, k2));
		
		System.out.println(mmb.solution2(food_times3, k3));
		
	}
}
