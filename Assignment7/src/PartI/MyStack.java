package PartI;

import java.util.ArrayList;

public class MyStack<E> {
	private ArrayList<E> ar;

	public MyStack() {
		ar = new ArrayList<E>();
	}

	public boolean empty() {
		return ar.isEmpty();
	}

	public E peek() {
		if (this.empty()) {
			return null;
		}
		return ar.get(ar.size() - 1);
	}

	public E pop() {
		if (this.empty()) {
			return null;
		}
		return ar.remove(ar.size() - 1);
	}

	public E push(E item) {
		ar.add(item);
		return item;
	}

	public int search(Object o) {
		return ar.indexOf(o) + 1;
	}
}
