import java.util.*;

public class PirateSolver {
	private List<Character> pirateList;
	private int noEnemies;
	
	public PirateSolver(String s) {
		pirateList = new ArrayList<Character>();
		int len = s.length();
		noEnemies = 0;
	
		for(int i=0; i<len; i++){
			int n = Character.getNumericValue(s.charAt(i));
			for(int j=0; j<n; j++){
				if(i%2==0){
					pirateList.add('E');
					noEnemies++;
				}
				else
					pirateList.add('F');
			}
		}
	}
	public List<Character> getCrew(){
		return pirateList;
	}
	
	public boolean throwOverBoardWithStep (int n){
		List<Character> pirateTest;
		pirateTest = new ArrayList<Character>();
		pirateTest.addAll(pirateList);
		int count = n-1;
		int noEne = noEnemies;
		while(noEne > 0){
			while(count < pirateTest.size()){
				if(pirateTest.get(count) == 'F')
					return true;
				pirateTest.remove(count);
				noEne--;
				if(noEne == 0)
					return false;
				count += n-1;
			}
			count -= pirateTest.size();
		}
		return false;
	}
	
	public int solution(){
		int step = 1;
		while (throwOverBoardWithStep(step)){
			step++;
		}
		return step;
	}
}
