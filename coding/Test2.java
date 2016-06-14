
import static org.junit.Assert.*;
import java.util.*;

public class Test2 {

	// part1
	@org.junit.Test
	public void losslesstest() {
		AttributeSet t1 = new AttributeSet();
		AttributeSet t2 = new AttributeSet();
		Set<FunctionalDependency> fds = new HashSet<FunctionalDependency>();
		
		t1.add(new Attribute("c"));
		t1.add(new Attribute("s"));
		t1.add(new Attribute("j"));
		t1.add(new Attribute("d"));
		t1.add(new Attribute("q"));
		t1.add(new Attribute("v"));
		
		t2.add(new Attribute("s"));
		t2.add(new Attribute("d"));
		t2.add(new Attribute("p"));
		
		
		AttributeSet left1 = new AttributeSet();
		left1.add(new Attribute("j"));
		left1.add(new Attribute("p"));
		
		fds.add(new FunctionalDependency(left1,new Attribute("c")));
		
		AttributeSet left2 = new AttributeSet();
		left2.add(new Attribute("s"));
		left2.add(new Attribute("d"));
		
		// tables
		// csjdqv
		// sdp
		// fds
		// jp -> c
		assertFalse(FDChecker.checkLossless(t1, t2, fds));
		
		fds.add(new FunctionalDependency(left2,new Attribute("p")));

		// tables
		// csjdqv
		// sdp
		// fds
		// jp -> c
		// sd->p
		assertTrue(FDChecker.checkLossless(t1, t2, fds));
//		assertFalse(FDChecker.checkDepPres(t1, t2, fds));
	}
	
	
	@org.junit.Test
	public void losslesstest2() {
		AttributeSet t1 = new AttributeSet();
		AttributeSet t2 = new AttributeSet();
		Set<FunctionalDependency> fds = new HashSet<FunctionalDependency>();
		
		t1.add(new Attribute("s"));
		t1.add(new Attribute("n"));
		t1.add(new Attribute("l"));
		t1.add(new Attribute("r"));
		t1.add(new Attribute("h"));
		
		t2.add(new Attribute("r"));
		t2.add(new Attribute("w"));
		
		
		AttributeSet left1 = new AttributeSet();
		left1.add(new Attribute("r"));
		
		fds.add(new FunctionalDependency(left1,new Attribute("w")));
		
		// tables
		// snlrh
		// rw
		// fds
		// r->w
		assertTrue(FDChecker.checkLossless(t1, t2, fds));

	}

	
	@org.junit.Test
	public void depPresFDtest() {
		AttributeSet t1 = new AttributeSet();
		AttributeSet t2 = new AttributeSet();
		Set<FunctionalDependency> fds = new HashSet<FunctionalDependency>();
		
		t1.add(new Attribute("c"));
		t1.add(new Attribute("s"));
		t1.add(new Attribute("j"));
		t1.add(new Attribute("d"));
		t1.add(new Attribute("q"));
		t1.add(new Attribute("v"));
		
		t2.add(new Attribute("s"));
		t2.add(new Attribute("d"));
		t2.add(new Attribute("p"));
		
		
		AttributeSet left1 = new AttributeSet();
		left1.add(new Attribute("j"));
		left1.add(new Attribute("p"));
		
		fds.add(new FunctionalDependency(left1,new Attribute("c")));
		
		AttributeSet left2 = new AttributeSet();
		left2.add(new Attribute("s"));
		left2.add(new Attribute("d"));
		
		// tables
		// csjdqv
		// sdp
		// fds
		// jp -> c
		assertFalse(FDChecker.checkDepPres(t1, t2, fds));
		
		fds.add(new FunctionalDependency(left2,new Attribute("p")));

		// tables
		// csjdqv
		// sdp
		// fds
		// jp -> c
		// sd->p
		assertFalse(FDChecker.checkDepPres(t1, t2, fds));
	}
	
	@org.junit.Test
	public void depPresFDtest2() {
		AttributeSet t1 = new AttributeSet();
		AttributeSet t2 = new AttributeSet();
		Set<FunctionalDependency> fds = new HashSet<FunctionalDependency>();
		
		t1.add(new Attribute("c"));
		t1.add(new Attribute("s"));
		t1.add(new Attribute("j"));
		t1.add(new Attribute("d"));
		t1.add(new Attribute("q"));
		t1.add(new Attribute("v"));
		
		t2.add(new Attribute("s"));
		t2.add(new Attribute("d"));
		t2.add(new Attribute("p"));
		
		
		AttributeSet left2 = new AttributeSet();
		left2.add(new Attribute("s"));
		left2.add(new Attribute("d"));
		

		fds.add(new FunctionalDependency(left2,new Attribute("p")));

		// tables
		// csjdqv
		// sdp
		// fds
		// sd->p
		assertTrue(FDChecker.checkDepPres(t1, t2, fds));
	}
	
	@org.junit.Test
	public void depPresFDtest3() {
		AttributeSet t1 = new AttributeSet();
		AttributeSet t2 = new AttributeSet();
		Set<FunctionalDependency> fds = new HashSet<FunctionalDependency>();
		
		t1.add(new Attribute("a"));
		t1.add(new Attribute("b"));
		
		t2.add(new Attribute("b"));
		t2.add(new Attribute("c"));
		
		
		AttributeSet left1 = new AttributeSet();
		left1.add(new Attribute("a"));
		fds.add(new FunctionalDependency(left1,new Attribute("b")));
		
		AttributeSet left2 = new AttributeSet();
		left2.add(new Attribute("b"));
		fds.add(new FunctionalDependency(left2,new Attribute("c")));
		
		// tables
		// ab
		// bc
		// fds
		// a->b b->c 
		assertTrue(FDChecker.checkLossless(t1, t2, fds));
		
		AttributeSet left3 = new AttributeSet();
		left3.add(new Attribute("c"));
		fds.add(new FunctionalDependency(left3,new Attribute("a")));
		

		// tables
		// ab
		// bc
		// fds
		// a->b b->c c->a
		assertTrue(FDChecker.checkDepPres(t1, t2, fds));
		
	}
	
	//part2
	@org.junit.Test
	public void depPresFDtest1() {
		AttributeSet t1 = new AttributeSet();
		AttributeSet t2 = new AttributeSet();
		Set<FunctionalDependency> fds = new HashSet<FunctionalDependency>();
		
		t1.add(new Attribute("a"));
		t1.add(new Attribute("b"));
		t1.add(new Attribute("c"));
		t2.add(new Attribute("a"));		
		t2.add(new Attribute("d"));
		t2.add(new Attribute("e"));		
		
		AttributeSet l1 = new AttributeSet();
		AttributeSet l2 = new AttributeSet();
		AttributeSet l3 = new AttributeSet();
		AttributeSet l4 = new AttributeSet();
		AttributeSet l5 = new AttributeSet();
		l1.add(new Attribute("a"));
		l2.add(new Attribute("a"));
		l3.add(new Attribute("c"));
		l3.add(new Attribute("d"));
		l4.add(new Attribute("b"));
		l5.add(new Attribute("e"));
		
		fds.add(new FunctionalDependency(l1,new Attribute("b")));
		fds.add(new FunctionalDependency(l1,new Attribute("c")));
		fds.add(new FunctionalDependency(l3,new Attribute("e")));
		fds.add(new FunctionalDependency(l4,new Attribute("d")));
		fds.add(new FunctionalDependency(l5,new Attribute("a")));

		// tables
		// a b c
		// a d e
		// fds
		// a -> bc,cd -> e,b -> d,e -> a  
		assertFalse(FDChecker.checkDepPres(t1, t2, fds));
	}

	@org.junit.Test
	public void depPresFDtest6() {
		AttributeSet t1 = new AttributeSet();
		AttributeSet t2 = new AttributeSet();
		Set<FunctionalDependency> fds = new HashSet<FunctionalDependency>();
		
		t1.add(new Attribute("a"));
		t1.add(new Attribute("b"));
		t2.add(new Attribute("b"));
		t2.add(new Attribute("c"));
		
		AttributeSet l1 = new AttributeSet();
		AttributeSet l2 = new AttributeSet();
		l1.add(new Attribute("a"));
		l2.add(new Attribute("b"));
		
		fds.add(new FunctionalDependency(l1,new Attribute("b")));
		fds.add(new FunctionalDependency(l2,new Attribute("c")));
		// tables
		// a b
		// b c
		// fds
		// a -> b,b -> c
		assertTrue(FDChecker.checkDepPres(t1, t2, fds));
	}	
	
	@org.junit.Test
	public void depPresFDtest7() {
		AttributeSet t1 = new AttributeSet();
		AttributeSet t2 = new AttributeSet();
		Set<FunctionalDependency> fds = new HashSet<FunctionalDependency>();
		
		t1.add(new Attribute("a"));
		t1.add(new Attribute("c"));
		t1.add(new Attribute("d"));
		t2.add(new Attribute("b"));
		t2.add(new Attribute("c"));
		
		AttributeSet l1 = new AttributeSet();
		AttributeSet l2 = new AttributeSet();
		AttributeSet l3 = new AttributeSet();
		l1.add(new Attribute("a"));
		l2.add(new Attribute("b"));
		l3.add(new Attribute("c"));
		
		fds.add(new FunctionalDependency(l1,new Attribute("b")));
		fds.add(new FunctionalDependency(l2,new Attribute("c")));
		fds.add(new FunctionalDependency(l3,new Attribute("d")));
		// tables
		// a c d
		// b c
		// fds
		// a -> b,b -> c,c -> d
		assertFalse(FDChecker.checkDepPres(t1, t2, fds));
	}
	
	@org.junit.Test
	public void depPresFDtest4() {
		AttributeSet t1 = new AttributeSet();
		AttributeSet t2 = new AttributeSet();
		Set<FunctionalDependency> fds = new HashSet<FunctionalDependency>();
		
		t1.add(new Attribute("b"));
		t1.add(new Attribute("c"));
		t1.add(new Attribute("d"));
		t2.add(new Attribute("a"));		
		t2.add(new Attribute("c"));
		t2.add(new Attribute("e"));
		
		AttributeSet l1 = new AttributeSet();
		AttributeSet l2 = new AttributeSet();
		AttributeSet l3 = new AttributeSet();
		AttributeSet l4 = new AttributeSet();
		l1.add(new Attribute("a"));
		l1.add(new Attribute("b"));
		l2.add(new Attribute("c"));
		l3.add(new Attribute("b"));
		l4.add(new Attribute("e"));
		
		fds.add(new FunctionalDependency(l1,new Attribute("c")));
		fds.add(new FunctionalDependency(l2,new Attribute("e")));
		fds.add(new FunctionalDependency(l3,new Attribute("d")));
		fds.add(new FunctionalDependency(l4,new Attribute("a")));		
		
		// tables
		// b c d
		// a c e
		// fds
		// ab -> c,c -> e,b -> d,e -> a
		assertFalse(FDChecker.checkDepPres(t1, t2, fds));
	}
	
	//part3
	@org.junit.Test
	public void depPresBasictest() {
		AttributeSet t1 = new AttributeSet();
		AttributeSet t2 = new AttributeSet();
		AttributeSet t3 = new AttributeSet();
		AttributeSet t4 = new AttributeSet();
		AttributeSet t5 = new AttributeSet();
		AttributeSet t6 = new AttributeSet();
		AttributeSet t7 = new AttributeSet();
		AttributeSet t8 = new AttributeSet();
		Set<FunctionalDependency> fds = new HashSet<FunctionalDependency>();
		
		t1.add(new Attribute("a"));
		t1.add(new Attribute("b"));
		t1.add(new Attribute("c"));
		t2.add(new Attribute("d"));
		t2.add(new Attribute("e"));
		t3.add(new Attribute("a"));
		t4.add(new Attribute("b"));
		t5.add(new Attribute("c"));
		t6.add(new Attribute("d"));
		t7.add(new Attribute("e"));
		t8.add(new Attribute("f"));
		
		fds.add(new FunctionalDependency(t3,new Attribute("e")));
		// tables
		// abc
		// de
		// fds
		// a -> e
		assertFalse(FDChecker.checkDepPres(t1, t2, fds));
		t3.add(new Attribute("c"));
		fds.add(new FunctionalDependency(t3,new Attribute("b")));
		fds.add(new FunctionalDependency(t3,new Attribute("c")));
		t3.add(new Attribute("e"));
		fds.add(new FunctionalDependency(t3,new Attribute("b")));
		t1.add(new Attribute("e"));
		// tables
		// abce
		// de
		// fds
		// a -> e, ac-> b, ac -> c, ace -> b
		assertTrue(FDChecker.checkDepPres(t1, t2, fds));
		fds.add(new FunctionalDependency(t3,new Attribute("d")));
		
		// tables
		// abce
		// de
		// fds
		// a -> e, ac-> b, ac -> c, ace -> b, ace -> d
		assertFalse(FDChecker.checkDepPres(t1, t2, fds));
		t1.add(new Attribute("d"));
		assertTrue(FDChecker.checkDepPres(t1, t2, fds));
		t2.add(new Attribute("f"));
		fds.add(new FunctionalDependency(t8,new Attribute("d")));
		fds.add(new FunctionalDependency(t8,new Attribute("b")));
		assertFalse(FDChecker.checkDepPres(t1, t2, fds));

	}

	@org.junit.Test
	public void losslessBasictest() {
		AttributeSet t1 = new AttributeSet();
		AttributeSet t2 = new AttributeSet();
		AttributeSet t3 = new AttributeSet();
		AttributeSet t4 = new AttributeSet();
		AttributeSet t5 = new AttributeSet();
		AttributeSet t6 = new AttributeSet();
		AttributeSet t7 = new AttributeSet();
		AttributeSet t8 = new AttributeSet();
		Set<FunctionalDependency> fds = new HashSet<FunctionalDependency>();
		
		t1.add(new Attribute("a"));
		t2.add(new Attribute("b"));
		
		t3.add(new Attribute("a"));
		t4.add(new Attribute("b"));
		t5.add(new Attribute("c"));
		t6.add(new Attribute("d"));
		t7.add(new Attribute("e"));
		t8.add(new Attribute("a"));
		t8.add(new Attribute("f"));
		fds.add(new FunctionalDependency(t1,new Attribute("b")));
		// tables
		// a
		// b
		// fds
		assertFalse(FDChecker.checkLossless(t1, t2, fds));
		
		t1.add(new Attribute("b"));
		// tables
		// a b
		// b
		// fds
		assertTrue(FDChecker.checkLossless(t1, t2, fds));
		
		t1.remove(new Attribute("b")); 
		
		// tables
		// a
		// b
		// fds
		assertFalse(FDChecker.checkLossless(t1, t2, fds));
		
		t1.add(new Attribute("c"));
		t1.add(new Attribute("f"));
		t2.add(new Attribute("d"));
		t2.add(new Attribute("e"));
		t2.add(new Attribute("g"));
		t2.add(new Attribute("h"));
		// tables
		// acf
		// bdegh
		// fds: a->b
		assertFalse(FDChecker.checkLossless(t1, t2, fds));
		
		t1.add(new Attribute("e"));
		fds.add(new FunctionalDependency(t7,new Attribute("a")));
		fds.add(new FunctionalDependency(t7,new Attribute("f")));
		// tables
		// acef
		// bdegh
		// fds: a->b, e->a, e->f
		assertFalse(FDChecker.checkLossless(t1, t2, fds));
		
		fds.add(new FunctionalDependency(t8,new Attribute("c")));
		// tables
		// acef
		// bdegh
		// fds: a->b, e->a, e->f, af ->c
		assertTrue(FDChecker.checkLossless(t1, t2, fds));
		
		t1.add(new Attribute("b"));
		assertTrue(FDChecker.checkLossless(t1, t2, fds));
		
		t1.add(new Attribute("l"));
		assertFalse(FDChecker.checkLossless(t1, t2, fds));
		t8.add(new Attribute("e"));
		fds.add(new FunctionalDependency(t8,new Attribute("l")));
		assertTrue(FDChecker.checkLossless(t1, t2, fds));
		t1.add(new Attribute("m"));
		assertFalse(FDChecker.checkLossless(t1, t2, fds));
		
		t4.add(new Attribute("a"));
		t6.add(new Attribute("b"));
		fds.add(new FunctionalDependency(t4,new Attribute("g")));
		assertFalse(FDChecker.checkLossless(t1, t2, fds));
		fds.add(new FunctionalDependency(t6,new Attribute("h")));
		assertFalse(FDChecker.checkLossless(t1, t2, fds));
		t1.add(new Attribute("d"));
		assertTrue(FDChecker.checkLossless(t1, t2, fds));
		t1.remove(new Attribute("d"));
		assertFalse(FDChecker.checkLossless(t1, t2, fds));
		fds.add(new FunctionalDependency(t5,new Attribute("d")));
		assertTrue(FDChecker.checkLossless(t1, t2, fds));
	
		assertTrue(FDChecker.checkLossless(t1, t2, fds));
	}
/*	
	@org.junit.Test
	public void depPresFDtest() {
		AttributeSet t1 = new AttributeSet();
		AttributeSet t2 = new AttributeSet();
		Set<FunctionalDependency> fds = new HashSet<FunctionalDependency>();
		
		t1.add(new Attribute("a"));
		t1.add(new Attribute("b"));
		t2.add(new Attribute("b"));
		
		fds.add(new FunctionalDependency(t1,new Attribute("b")));

		// tables
		// a b
		// b
		// fds
		// ab -> b
		assertTrue(FDChecker.checkDepPres(t1, t2, fds));
		
		
		fds.add(new FunctionalDependency(t2, new Attribute("a")));
		// tables
		// a b
		// b
		// fds
		// ab -> b
		// b -> a
		assertTrue(FDChecker.checkDepPres(t1, t2, fds));
	}

	@org.junit.Test
	public void losslesstest() {
		AttributeSet t1 = new AttributeSet();
		AttributeSet t2 = new AttributeSet();
		Set<FunctionalDependency> fds = new HashSet<FunctionalDependency>();
		
		t1.add(new Attribute("a"));
		t1.add(new Attribute("b"));
		t2.add(new Attribute("b"));
		t2.add(new Attribute("c"));
		t2.add(new Attribute("d"));
		
		AttributeSet temp = new AttributeSet();
		temp.add(new Attribute("b"));
		fds.add(new FunctionalDependency(temp,new Attribute("c")));
		// tables
		// a b
		// b c d
		// fds
		// b -> c
		assertFalse(FDChecker.checkLossless(t1, t2, fds));
		
		fds.add(new FunctionalDependency(temp, new Attribute("d")));
		// tables
		// a b
		// b c d
		// fds
		// b -> c
		// b -> d
		System.out.println("decide: "+FDChecker.checkLossless(t1, t2, fds));
		assertEquals(true, FDChecker.checkLossless(t1, t2, fds));
	}*/
	
	// part 4
	@org.junit.Test
	public void depPresBasictest2() {
		AttributeSet t1 = new AttributeSet();
		AttributeSet t2 = new AttributeSet();
		Set<FunctionalDependency> fds = new HashSet<FunctionalDependency>();
		
		t1.add(new Attribute("a"));
		t2.add(new Attribute("b"));
		
		fds.add(new FunctionalDependency(t1,new Attribute("a")));

		// tables
		// a
		// b
		// fds
		// a -> a
		assertTrue(FDChecker.checkDepPres(t1, t2, fds));
		
		
		fds.add(new FunctionalDependency(t1, new Attribute("b")));
		// tables
		// a
		// b
		// fds
		// a -> a
		// a -> b
		assertFalse(FDChecker.checkDepPres(t1, t2, fds));
	}

	@org.junit.Test
	public void losslessBasictest2() {
		AttributeSet t1 = new AttributeSet();
		AttributeSet t2 = new AttributeSet();
		Set<FunctionalDependency> fds = new HashSet<FunctionalDependency>();
		
		t1.add(new Attribute("a"));
		t2.add(new Attribute("b"));
		
		// tables
		// a
		// b
		// fds
		assertFalse(FDChecker.checkLossless(t1, t2, fds));
		
		t1.add(new Attribute("b"));
		// tables
		// a b
		// b
		// fds
		assertTrue(FDChecker.checkLossless(t1, t2, fds));
	}
	
	@org.junit.Test
	public void depPresFDtest8() {
		AttributeSet t1 = new AttributeSet();
		AttributeSet t2 = new AttributeSet();
		//AttributeSet t3 = new AttributeSet();
		Set<FunctionalDependency> fds = new HashSet<FunctionalDependency>();
		
		t1.add(new Attribute("a"));
		t1.add(new Attribute("b"));
		t2.add(new Attribute("b"));
		//t3.add(new Attribute("a"));
		fds.add(new FunctionalDependency(t1,new Attribute("b")));

		// tables
		// a b
		// b
		// fds
		// ab -> b
		assertTrue(FDChecker.checkDepPres(t1, t2, fds));
		//assertFalse(FDChecker.checkLossless(t3, t2, fds));
		
		fds.add(new FunctionalDependency(t2, new Attribute("a")));
		// tables
		// a b
		// b
		// fds
		// ab -> b
		// b -> a
		assertTrue(FDChecker.checkDepPres(t1, t2, fds));
	}

	@org.junit.Test
	public void losslesstest3() {
		AttributeSet t1 = new AttributeSet();
		AttributeSet t2 = new AttributeSet();
		Set<FunctionalDependency> fds = new HashSet<FunctionalDependency>();
		
		t1.add(new Attribute("a"));
		t1.add(new Attribute("b"));
		t2.add(new Attribute("b"));
		t2.add(new Attribute("c"));
		t2.add(new Attribute("d"));
		
		AttributeSet temp = new AttributeSet();
		temp.add(new Attribute("b"));
		fds.add(new FunctionalDependency(temp,new Attribute("c")));
		// tables
		// a b
		// b c d
		// fds
		// b -> c
		assertFalse(FDChecker.checkLossless(t1, t2, fds));
		
		fds.add(new FunctionalDependency(temp, new Attribute("d")));
		// tables
		// a b
		// b c d
		// fds
		// b -> c
		// b -> d
		assertTrue(FDChecker.checkLossless(t1, t2, fds));
		
		
	}
	@org.junit.Test
	public void djh_test() {
		AttributeSet t1 = new AttributeSet();
		AttributeSet t2 = new AttributeSet();
		AttributeSet t3 = new AttributeSet();
		Set<FunctionalDependency> fds = new HashSet<FunctionalDependency>();
		
		t1.add(new Attribute("a"));
		t1.add(new Attribute("b"));
		t1.add(new Attribute("c"));
		t2.add(new Attribute("a"));
		t2.add(new Attribute("d"));
		t2.add(new Attribute("e"));
		t3.add(new Attribute("c"));
		t3.add(new Attribute("d"));
		t3.add(new Attribute("e"));
		
		AttributeSet temp1 = new AttributeSet();
		temp1.add(new Attribute("a"));
		fds.add(new FunctionalDependency(temp1,new Attribute("b")));
		fds.add(new FunctionalDependency(temp1,new Attribute("c")));
		// tables
		// a b c
		// a d e
		// fds
		// a -> c
		// a -> b
		// cd -> e
		// b -> d
		// e -> a
		AttributeSet temp2 = new AttributeSet();
		temp2.add(new Attribute("c"));
		temp2.add(new Attribute("d"));
		fds.add(new FunctionalDependency(temp2, new Attribute("e")));
		AttributeSet temp3 = new AttributeSet();
		temp3.add(new Attribute("b"));
		fds.add(new FunctionalDependency(temp3,new Attribute("d")));
		AttributeSet temp4 = new AttributeSet();
		temp4.add(new Attribute("e"));
		fds.add(new FunctionalDependency(temp4,new Attribute("a")));

		assertTrue(FDChecker.checkLossless(t1, t2, fds));
		assertFalse(FDChecker.checkLossless(t1, t3, fds));
		assertFalse(FDChecker.checkDepPres(t1, t2, fds));
	}
	@org.junit.Test
	public void djh_testppt() {
		AttributeSet t1 = new AttributeSet();
		AttributeSet t2 = new AttributeSet();

		Set<FunctionalDependency> fds = new HashSet<FunctionalDependency>();
		
		t1.add(new Attribute("c"));
		t1.add(new Attribute("s"));
		t1.add(new Attribute("d"));
		t1.add(new Attribute("j"));
		t1.add(new Attribute("q"));
		t1.add(new Attribute("v"));
		t2.add(new Attribute("d"));
		t2.add(new Attribute("s"));
		t2.add(new Attribute("p"));
		
		AttributeSet temp1 = new AttributeSet();
		temp1.add(new Attribute("j"));
		temp1.add(new Attribute("p"));
		fds.add(new FunctionalDependency(temp1,new Attribute("c")));
		AttributeSet temp2 = new AttributeSet();
		temp2.add(new Attribute("s"));
		temp2.add(new Attribute("d"));
		fds.add(new FunctionalDependency(temp2, new Attribute("p")));
		assertTrue(FDChecker.checkLossless(t1, t2, fds));
		assertFalse(FDChecker.checkDepPres(t1, t2, fds));
	}
	
}
