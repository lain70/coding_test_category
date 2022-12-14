package Dfs_Bfs;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

//ÁÖ¾îÁø Ç×°ø±ÇÀ» ¸ðµÎ ÀÌ¿ëÇÏ¿© ¿©Çà°æ·Î¸¦ Â¥·Á°í ÇÕ´Ï´Ù. Ç×»ó "ICN" °øÇ×¿¡¼­ Ãâ¹ßÇÕ´Ï´Ù.
//
//Ç×°ø±Ç Á¤º¸°¡ ´ã±ä 2Â÷¿ø ¹è¿­ tickets°¡ ¸Å°³º¯¼ö·Î ÁÖ¾îÁú ¶§, ¹æ¹®ÇÏ´Â °øÇ× °æ·Î¸¦ ¹è¿­¿¡ ´ã¾Æ return ÇÏµµ·Ï solution ÇÔ¼ö¸¦ ÀÛ¼ºÇØÁÖ¼¼¿ä.
//
//Á¦ÇÑ»çÇ×
//¸ðµç °øÇ×Àº ¾ËÆÄºª ´ë¹®ÀÚ 3±ÛÀÚ·Î ÀÌ·ç¾îÁý´Ï´Ù.
//ÁÖ¾îÁø °øÇ× ¼ö´Â 3°³ ÀÌ»ó 10,000°³ ÀÌÇÏÀÔ´Ï´Ù.
//ticketsÀÇ °¢ Çà [a, b]´Â a °øÇ×¿¡¼­ b °øÇ×À¸·Î °¡´Â Ç×°ø±ÇÀÌ ÀÖ´Ù´Â ÀÇ¹ÌÀÔ´Ï´Ù.
//ÁÖ¾îÁø Ç×°ø±ÇÀº ¸ðµÎ »ç¿ëÇØ¾ß ÇÕ´Ï´Ù.
//¸¸ÀÏ °¡´ÉÇÑ °æ·Î°¡ 2°³ ÀÌ»óÀÏ °æ¿ì ¾ËÆÄºª ¼ø¼­°¡ ¾Õ¼­´Â °æ·Î¸¦ return ÇÕ´Ï´Ù.
//¸ðµç µµ½Ã¸¦ ¹æ¹®ÇÒ ¼ö ¾ø´Â °æ¿ì´Â ÁÖ¾îÁöÁö ¾Ê½À´Ï´Ù.
//ÀÔÃâ·Â ¿¹
//tickets	return
//[["ICN", "JFK"], ["HND", "IAD"], ["JFK", "HND"]]	["ICN", "JFK", "HND", "IAD"]
//[["ICN", "SFO"], ["ICN", "ATL"], ["SFO", "ATL"], ["ATL", "ICN"], ["ATL","SFO"]]	["ICN", "ATL", "ICN", "SFO", "ATL", "SFO"]
//ÀÔÃâ·Â ¿¹ ¼³¸í
//¿¹Á¦ #1
//
//["ICN", "JFK", "HND", "IAD"] ¼øÀ¸·Î ¹æ¹®ÇÒ ¼ö ÀÖ½À´Ï´Ù.
//
//¿¹Á¦ #2
//
//["ICN", "SFO", "ATL", "ICN", "ATL", "SFO"] ¼øÀ¸·Î ¹æ¹®ÇÒ ¼öµµ ÀÖÁö¸¸ ["ICN", "ATL", "ICN", "SFO", "ATL", "SFO"] °¡ ¾ËÆÄºª ¼øÀ¸·Î ¾Õ¼·´Ï´Ù.

//¸ðµç ÄÉÀÌ½º¸¦ µ¹¾Æ¼­ °¡´ÉÇÑ °æ¿ì¿¡ ´ëÇØ Ã£´Â´Ù.
public class AirplaneTravle {
	public static List<String> answer = new ArrayList<>();
	public static boolean[] visited;

	public static void dfs(String[][] tickets, int depth, String now,  String next) {
		if (depth == tickets.length) {
			answer.add(now);
			return;
		}

		for (int i = 0; i < tickets.length; i++) {
			if (!visited[i] && next.equals(tickets[i][0])) {
				visited[i] = true;

				dfs(tickets, depth + 1, now + " " + tickets[i][1], tickets[i][1]);
				visited[i] = false;
			}
		}

	}

	public String[] solution(String[][] tickets) {
		Arrays.sort(tickets, new Comparator<String[]>() {

			@Override
			public int compare(String[] o1, String[] o2) {
				// TODO Auto-generated method stub
				return o1[1].compareToIgnoreCase(o2[1]);
			}
		});

		visited = new boolean[tickets.length];
		Arrays.fill(visited, false);

		dfs(tickets, 0, "ICN", "ICN");
		
		return answer.get(0).split(" ");
	}

	public static void main(String[] args) {
		AirplaneTravle at = new AirplaneTravle();
		String[] ans = at.solution(new String[][]  {{"ICN", "SFO"}, {"ICN", "ATL"}, {"SFO", "ATL"}, {"ATL", "ICN"}, {"ATL","SFO"}});
		for(String a : ans) {
			System.out.println(a);
		}


	}
}
