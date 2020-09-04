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

	// TODO: should I include this test?
	public void testPushAntiOverflow() {
		gstack = new GStack(4);
		gstack.push(7);
		gstack.push(8);
		assertEquals(2, gstack.load());
		assertEquals(8, gstack.peek());
		gstack.push(9);
		gstack.push(10);
		gstack.push(11);
		assertEquals(5, gstack.load());
		assertEquals(11, gstack.peek());
	}

	// TODO: should I include this test?
	public void testPopAntiUnderflow() {
		gstack = new GStack(2);
		gstack.push(9);
		gstack.push(-2);
		gstack.pop();
		assertEquals(1, gstack.load());
		assertEquals(9, gstack.peek());
		assertEquals(9, gstack.pop());
		gstack.pop();
		assertEquals(0, gstack.load());
		assertEquals(null, gstack.peek());
	}
}
