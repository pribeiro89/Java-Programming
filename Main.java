import java.util.*;

public class Main {
	public static void main(String [] args) {
		Scanner sc = new Scanner (System.in);
		PirateSolver solver = new PirateSolver(sc.next());
		sc.close();
		System.out.println(solver.solution());
		}
}
