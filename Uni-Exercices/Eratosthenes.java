/*
 * Implementation of Eratosthenes algorithm.
 */

import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;


public class Eratosthenes {

	public static ArrayBag<Integer> sieveClassic(int x) {
		// False -> In the sieve
		// True -> Eliminated from the sieve
		boolean [] boolArray = new boolean [x+1];
		ArrayBag<Integer> bag = new ArrayBag<Integer>();
		int lead = 2;
		while (lead*lead < x) {
			for (int j = lead*lead; j <= x; j++) {
				if (j%lead == 0) {
					boolArray[j] = true;
				}
			}
			lead++;
			while (boolArray[lead] != false) {
				lead++;
			}
		}
		for (int i = 2; i < boolArray.length; i++) {
			if (boolArray[i] == false) {
				bag.add(i);
			}
		}
		return bag;
	}
	
	public static ArrayBag<Integer> sieveModern(int n) {
		ArrayBag<Integer> bag = new ArrayBag<Integer>();
		for (int i = 2; i <= n; i++) {
			bag.add(i);
		}
		int lead = bag.at(0);
		int i = 0;
		while (lead*lead <= n) {
			int d = lead;
			bag = bag.filter(x -> x == d || (x % d != 0));
			lead = bag.at(i++);
		}
		return bag;
	}
	
	public static void testeEratosthenes() {
		int x = StdIn.readInt();
		ArrayBag<Integer> aB = sieveClassic(x);
		int len = aB.size();
		StdOut.println(len);
		while(!StdIn.isEmpty()){
			int i = StdIn.readInt();
			if (i <= len){
				int primo = aB.get(i-1);
				StdOut.println(primo);
			} else {
				StdOut.println(-1);
			}
		}
	}
	
	public static void testeEratosthenesModern() {
		int x = StdIn.readInt();
		ArrayBag<Integer> aB = sieveModern(x);
		int len = aB.size();
		StdOut.println(len);
		while(!StdIn.isEmpty()){
			int i = StdIn.readInt();
			if (i <= len){
				int primo = aB.get(i-1);
				StdOut.println(primo);
			} else {
				StdOut.println(-1);
			}
		}
	}
	
	public static void main(String[] args) {
		char choice = 'B';
	    if (args.length > 0)
	      choice = args[0].charAt(0);
	    if (choice == 'A')
	    {
	    	testeEratosthenes();
	    }
	    else if (choice == 'B')
	    {
	    	testeEratosthenesModern();
	    }
	}
}
