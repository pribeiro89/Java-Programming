import static org.junit.Assert.*;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import org.junit.Test;
import java.util.*; 

public class PiratesUnitTests {

	@Test
	public void testConstructor() {
		PirateSolver p = new PirateSolver("1234");
		List<Character> sa = new ArrayList<Character>(); // line 4
		Collections.addAll(sa, 'E','F','F','E','E','E','F','F','F','F'); // line 5
		assertEquals(p.getCrew(), sa);
		PirateSolver q = new PirateSolver("14115123");
		assertEquals(q.getCrew().size(), 18);
	}
	@Test
	public void testThrowOverBoardWithStep() {
		PirateSolver p = new PirateSolver("3151");
		assertTrue(p.throwOverBoardWithStep(1));
		assertFalse(p.throwOverBoardWithStep(3));
	}
	
	@Test
	public void testThrowOverBoardWithStep01() {
		PirateSolver p = new PirateSolver("1234");
		assertTrue(p.throwOverBoardWithStep(6));
		assertFalse(p.throwOverBoardWithStep(206));
	}
	
	
	@Test
	public void testSolution() {
		PirateSolver p = new PirateSolver("1234");
		assertEquals(p.solution(),206);
	}
}
