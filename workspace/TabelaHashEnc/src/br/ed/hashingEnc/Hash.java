package br.ed.hashingEnc;

public class Hash<T>{
	protected int chave;
	protected NoSimpEnc<T> elemento;
	protected int total;

	public Hash( int pChave, NoSimpEnc<T> pNo) {
		this.chave = pChave;
		this.elemento = pNo;
	}

	public NoSimpEnc<T> getElemento() {
		return elemento;
	}
}
