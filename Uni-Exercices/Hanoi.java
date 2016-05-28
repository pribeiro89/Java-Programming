/* 
 * Implementation of Hanoi Algorithm.
 * A Processing animation of this algorithm was done as well, it can be found on the Processing folder.
 */

import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

public class Hanoi {
	static ArrayBag<Stack<Integer>> myBag = new ArrayBag<Stack<Integer>>(3);
	private static int n;
	private static ArrayBag<int[]> sol = new ArrayBag<int[]>();
	
	public Hanoi (int n) {
		this.n = n;
		sol = solution();
	}
		
	private static Bag<int[]> solve(int n, int x, int y, int z){
			Bag<int[]> result = new Bag<>();
			solveNow(n, x, y, z, result);
			return result;
	}
	
	private static void solveNow(int n, int x, int y, int z, Bag<int[]> r){
		if (n > 0) {
			solveNow(n-1, x, z, y, r);
			r.add(new int[]{x, y});
			solveNow(n-1, z, y, x, r);
		}
	}
	
	public ArrayBag<int[]> solution(){
		ArrayBag<int[]> res = new ArrayBag<int[]>();
		Bag<int[]> r = solve(n, 0, 1, 2);
		for(int[] a : r){
			res.add(a);
		}
		return res;
	}
	
	
	//  Compute the 3 stacks after M movements
	public ArrayBag<Stack<Integer>> play(int m) {
		ArrayBag<Stack<Integer>> aBag = new ArrayBag<Stack<Integer>>();
		for (int i = 0; i < 3; i++)
			aBag.add(new Stack<Integer>());
		
		for (int i = n; i > 0; i--)
      aBag.get(0).push(i);

		for (int j = 0; j < m; j++) {
			int de = sol.get(j)[0];
			int para = sol.get(j)[1];
			aBag.get(para).push(aBag.get(de).pop());
		}
		
		for (Stack<Integer> s : aBag) {
			String space = "";
			if (!s.isEmpty()) {
				for (Integer i : s){
					StdOut.print(space + i);
					space = " ";
				}
			}
			else
				StdOut.print("*");
			StdOut.print("\n");
		}
		return aBag;	
	}
	
	/*
	 * Accepts the value of N
	 * In a cicle, until the end of data, accepts a value M, to represent the argument m of the function
	 */
	public static void testHanoi(){
		int n = StdIn.readInt();
		Hanoi h = new Hanoi(n);
		int steps = (int) (Math.pow(2, n) - 1);

		while (!StdIn.isEmpty()){
			int m = StdIn.readInt();
			if (m > steps)
				h.play(steps);
			else if (m <= steps)
				h.play(m);
		}
	}

	public static void main(String[] args) {
		testHanoi();
	}
}
