package listSimples;

public class NoSimpEnc<T> {
	private T elemento;
	private NoSimpEnc<T> proximo;

	public NoSimpEnc(T objeto) {
		this.elemento = objeto;
		this.proximo = null;
	}
	public NoSimpEnc(ListSimpEnc<T> lista) {
		this.elemento = (T) lista;
		this.proximo = null;
	}

	public NoSimpEnc(T objeto, NoSimpEnc<T> proximo) {
		this.elemento = objeto;
		this.proximo = proximo;
	}

	public NoSimpEnc() {
		// TODO Auto-generated constructor stub
	}

	public T getElemento() {
		return elemento;
	}

	public void setElemento(T elemento) {
		this.elemento = elemento;
	}

	public NoSimpEnc<T> getProximo() {
		return proximo;
	}

	public void setProximo(NoSimpEnc<T> proximo) {
		this.proximo = proximo;
	}

}
