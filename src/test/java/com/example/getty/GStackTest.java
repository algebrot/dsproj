package com.example.getty;

import junit.framework.TestCase;

public class GStackTest extends TestCase {
	private GStack gstack;

	protected void setUp() {
		gstack = new GStack();
	}

	public void testPush() {
		gstack = new GStack(2);
		gstack.push(11);
		assertEquals(11, gstack.peek());
		gstack.push(22);
		assertEquals(22, gstack.peek());
		assertEquals(2, gstack.load());
	}

	public void testPop() {
		gstack = new GStack(1);
		gstack.push(3);
		assertEquals(3, gstack.pop());
		assertEquals(0, gstack.load());
	}
	
	public void testPeek() {
		gstack = new GStack(3);
		gstack.push(4);
		gstack.push(5);
		gstack.push(6);
		assertEquals(3, gstack.load());
		assertEquals(6, gstack.peek());
	}

	public void testPopUntil() {
		gstack = new GStack(5);
		gstack.push(2);
		gstack.push("cat");
		gstack.push(5);
		gstack.popUntil("cat");
		assertEquals(gstack.peek(),"cat");
	}

	public void testMakeEmpty() {
		gstack = new GStack(1);
		gstack.push(2);
		assertEquals(1, gstack.load());
		gstack.makeEmpty();
		assertEquals(0, gstack.load());
	}

}
