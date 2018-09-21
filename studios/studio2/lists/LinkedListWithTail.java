package studio2.lists;

import timing.Ticker;

/**
 * Your assignment is to modify this class so it uses a tail reference
 * 
 * @author roncytron and WhoAreYou
 *
 * @param <T>
 */
public class LinkedListWithTail<T> implements List<T> {

	private ListNode<T> head;
	private Ticker ticker;
	private ListNode<T> tail;
	private int length;

	public LinkedListWithTail(Ticker ticker) {
		this.head = null;   // nothing in our list yet
		this.tail = null;
		this.ticker = ticker;
		this.length = 0;
	}

	/**
	 * Modify this method for studio 2 so that it uses an instance
	 * variable for the tail reference, and modify code in this class
	 * so that the tail reference
	 * that always points to the end of the list.
	 * 
	 * Use that tail reference to add to the end of the list, instead
	 *   of looping to find the end.
	 */
	@Override
	public void addLast(T thing) {
		length++;
		if (head == null) {
			ListNode<T> p = new ListNode<T>();
			p.value = thing;
			head = p;
			tail = p;
			ticker.tick(4);  // for the 3 statements above
		}
		else {
			ListNode<T> q = new ListNode<T>();
			q.value = thing;
			// search for the end of the list -- modify this
			// code to use (and maintain) the tail pointer!
			//			ListNode<T> p = head;


			ListNode<T> p = tail;

			//			while (p.next != null) {
			//				p = p.next;
			//				ticker.tick(2);
			//			}

			p.next = q;
			tail = q;
			ticker.tick(5);  // for the 4 statements not part of the "while" loop
		}
		ticker.tick(1); // for outermost "if" test
	}

	/**
	 * Modify this method so that getting the size of this list
	 * takes Theta(1) (constant) time.
	 */
	@Override
	public int getSize() {
//		ticker.tick();
//		return length;
//		int ans = 0;
//		ticker.tick(2); // init ans; initialization stmt in for() loop
//		for (ListNode<T> p = this.head; p != null; p = p.next) {
//			ans = ans + 1;
//			ticker.tick(3); // for 3 statements per loop iter
//		}
//		ticker.tick(); // for last test in for loop
//		return ans;
		ticker.tick();
		return length;

	}

	/**
	 * 
	 * @param n which time, 0 is the first item
	 * @return
	 */
	@Override
	public T getItemAt(int n) {
		ListNode<T> p = head;
		for (int i=0; i < n; ++i) {
			p = p.next;
			ticker.tick();
		}
		return p.value;
	}

	public String toString() {
		String ans = "[ ";
		for (ListNode<T> p = head; p != null; p = p.next) {
			ans = ans + p.value + " ";
		}
		ans = ans + "]";
		return ans;
	}

}
