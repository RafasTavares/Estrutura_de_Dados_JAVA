package edI.Fila;

import java.util.Arrays;

import listaDupla.NoDupEnc;
import vetor_2014.Vetor;

public class FilaPrioridade<T> implements IFilaPrioridade<T> {
	private ItemFila<T>[] elementos;
	private int contElementos;
	private int inicio;
	private int fim;

	public FilaPrioridade() {
		elementos = new ItemFila[10];
	}

	@Override
	public void Enfileirar(T objeto, int prioridade) throws PilhaCheiaException {
		ItemFila<T> item = new ItemFila<T>(objeto, prioridade);
		if (contElementos < elementos.length
				&& elementos[contElementos] == null) {
			elementos[contElementos] = item;
		} else {
			throw new PilhaCheiaException();
		}
		for (int i = 0; i <= contElementos; i++) {
			ItemFila<T> aux = elementos[i];
			for (int j = i - 1; j >= 0; j--) {
				if (elementos[j].getPrioridade() > aux.getPrioridade()) {
					elementos[j + 1] = elementos[j];
					elementos[j] = aux;
				}
			}
		}
		contElementos++;
	}

	@Override
	public T Remover() throws FilaVaziaException {
		if (contElementos == 0) {
			throw new FilaVaziaException();
		}
		for (int i = 0; i < contElementos - 1; i++) {
			this.elementos[i] = this.elementos[i + 1];
		}
		this.elementos[contElementos - 1] = null;
		contElementos--;

		return null;
	}

	@Override
	public boolean estaVazia() {
		return contElementos == 0;
	}

	@Override
	public String toString() {
		if (contElementos == 0) {
			return "[]";
		}
		String retorno = "[";
		for (int i = 0; i <= contElementos - 1; i++) {
			if (contElementos < elementos.length) {
				if (elementos[i + 1] != null) {
					retorno = retorno + elementos[i].getElemento() + ", ";
				} else
					retorno = retorno + elementos[i].getElemento() + "]";
			}
		}
		return retorno;
	}

	public int Tamanho() {
		return contElementos;
	}

}
