package hash;

public class Hash<T> {
	private int chave;
	private boolean deletado = false;
	private T elemento;

	public Hash(int chave, T elemento) {
		this.chave = chave;
		this.elemento = elemento;
		this.deletado = false;

	}

	public Hash(int chave, T elemento, boolean deletado) {
		this.chave = chave;
		this.elemento = elemento;
		this.deletado = deletado;

	}

	public T getElemento() {
		return this.elemento;
	}

	public boolean getDeletado() {
		return this.deletado;
	}

	public void setDeletado(boolean deletado) {
		this.deletado = deletado;
	}
	
}
