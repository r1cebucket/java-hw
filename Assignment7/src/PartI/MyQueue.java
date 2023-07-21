package PartI;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.Queue;

import java.util.NoSuchElementException;

public class MyQueue<E> implements Queue<E> {
	private ArrayList<E> ar;

	public MyQueue() {
		ar = new ArrayList<E>();
	}

	public MyQueue(int cap) {
		ar = new ArrayList<E>(cap);
	}

	public int size() {
		return ar.size();
	}

	public boolean isEmpty() {
		return ar.isEmpty();
	}

	public boolean offer(E e) {
		return ar.add(e);
	}

	public E remove() {
		if (this.isEmpty()) {
			throw new NoSuchElementException();
		}
		return ar.remove(0);
	}

	public E poll() {
		if (this.isEmpty()) {
			return null;
		}
		return ar.remove(0);
	}

	public E element() {
		if (this.isEmpty()) {
			throw new NoSuchElementException();
		}
		return ar.get(0);
	}

	public E peek() {
		if (this.isEmpty()) {
			return null;
		}
		return ar.get(0);
	}

	@Override
	public boolean contains(Object o) {
		return ar.contains(o);
	}

	@Override
	public Iterator<E> iterator() {
		return ar.iterator();
	}

	@Override
	public Object[] toArray() {
		return ar.toArray();
	}

	@Override
	public <T> T[] toArray(T[] a) {
		return ar.toArray(a);
	}

	@Override
	public boolean remove(Object o) {
		return ar.remove(o);
	}

	@Override
	public boolean containsAll(Collection<?> c) {
		return ar.containsAll(c);
	}

	@Override
	public boolean addAll(Collection<? extends E> c) {
		return ar.addAll(c);
	}

	@Override
	public boolean removeAll(Collection<?> c) {
		return ar.removeAll(c);
	}

	@Override
	public boolean retainAll(Collection<?> c) {
		return ar.retainAll(c);
	}

	@Override
	public void clear() {
		ar.clear();
	}

	@Override
	public boolean add(E e) {
		return offer(e);
	}

}
