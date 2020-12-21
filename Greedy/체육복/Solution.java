import java.util.ArrayList;
import java.util.List;

public class Solution {

	public int solution(int n, int[] lost, int[] reserve) {
	
		int answer = 0;
		int diff = 0;
		int getClothes = 0;
		int check = 0;
		int notLost = n - lost.length; // 잃어버리지 않음

		List<Integer> newLost = new ArrayList<Integer>();
		for (int k : lost) {
			newLost.add(k);
		}

		List<Integer> newReserve = new ArrayList<Integer>();
		for (int k : reserve) {
			newReserve.add(k);
		}

		for (int i = 0; i < lost.length; i++) {
			for (int j = 0; j < reserve.length; j++) {
				if (lost[i] == reserve[j]) {
					check++; // lost와 reserve에 겹치는 학생 수(= 잃어버렸는데 여벌은 있고 다른 애들 못빌려줌)
					newLost.set(i, 0);
					newReserve.set(j, 0);
				}
			}
		}
		
	    //value가 0인 애들 지우기
		boolean avail = false;
		while (!avail) {
            if (newLost.remove((Integer)0) == false && newReserve.remove((Integer)0) == false)
                avail = true;
		}
		
		for (int i = 0; i < newLost.size(); i++) {
			for (int j = 0; j < newReserve.size(); j++) {
				diff = Math.abs(newLost.get(i) - newReserve.get(j));
				if (diff == 1) {
					getClothes++;
					newReserve.set(j, -100);
					break;
				} else
					continue;
			}
		}

		if (check == 0) {
			answer = getClothes + notLost;
		} else
			answer = getClothes + check + notLost;
		
		return answer;
	}
}
