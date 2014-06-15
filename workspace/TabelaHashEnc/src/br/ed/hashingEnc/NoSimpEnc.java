package br.ed.hashingEnc;

public class NoSimpEnc<T> {
	private T element;
	private NoSimpEnc<T> next;

	public NoSimpEnc(T pElement) {
		this.element = pElement;
	}

	public NoSimpEnc(T pElement, NoSimpEnc<T> pNext) {
		this.element = pElement;
		this.next = pNext;
	}

	public T getElement() {
		return element;
	}

	public void setElement(T element) {
		this.element = element;
	}

	public NoSimpEnc<T> getNext() {
		return next;
	}

	public void setNext(NoSimpEnc<T> next) {
		this.next = next;
	}
}
