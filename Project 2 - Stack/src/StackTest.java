import org.junit.*;

import static org.junit.Assert.assertEquals;

public class StackTest {
	@Test
	public void testPush(){
		Stack stack = new Stack(2);
		stack.push(2);

		assertEquals(2, stack.peek());

		stack.push(5);
		assertEquals(5, stack.peek());

		stack.push(3);
		assertEquals(3, stack.peek());
	}

	@Test
	public void testPopAfterPush() {
		Stack stack = new Stack(2);
		stack.push(10);
		int result = stack.pop();

		assertEquals("pop after push", 10, result);
	}

	@Test(expected = NullPointerException.class)
	public void testEmptyPeek(){
		Stack stack = new Stack(2);
		stack.peek();

	}

	@Test(expected = NullPointerException.class)
	public void testEmptyPop(){
		Stack stack = new Stack(2);
		stack.pop();

	}

	@Test(expected = NullPointerException.class)
	public void testEmptyPop2(){
		Stack stack = new Stack(2);

		stack.push(1);
		assertEquals(1, stack.peek());

		stack.push(2);
		assertEquals(2, stack.peek());

		stack.pop();
		stack.pop();
		stack.pop();

	}

	@Test(expected = NullPointerException.class)
	public void someMorePushPopTesting(){
		Stack stack = new Stack(4);
		stack.push(1);
		assertEquals(1, stack.peek());
		stack.push(2);
		assertEquals(2, stack.peek());
		stack.push(3);
		assertEquals(3, stack.peek());
		stack.push(4);
		assertEquals(4, stack.peek());
		stack.push(5);
		assertEquals(5, stack.peek());
		stack.push(6);
		assertEquals(6, stack.peek());
		stack.push(7);
		assertEquals(7, stack.peek());
		assertEquals(7, stack.pop());
		assertEquals(6, stack.pop());
		assertEquals(5, stack.pop());
		assertEquals(4, stack.pop());
		assertEquals(3, stack.pop());
	}
}
