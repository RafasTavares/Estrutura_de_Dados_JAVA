package vetor_2014;

import java.util.Iterator;

public class Vetor<T> implements IVetor<T> {
	private final short tamVetor = 3;
	private T[] elementos;
	private int tam = 0;
	private int tamInicial = 10;
	private int tamAumentar = 10;

	public Vetor() {
		elementos = ((T[]) new Object[tamVetor]);
	}

	public Vetor(int tamInicial) {
		this.elementos = ((T[]) new Object[tamVetor]);
		this.tamInicial = tamInicial;
	}

	public void AumentarTamanho() {
		if (tam == elementos.length) {
			T[] temp = (T[]) new Object[elementos.length + tamAumentar];
			System.arraycopy(elementos, 0, temp, 0, elementos.length);
			elementos = temp;
		}
	}

	@Override
	public void Adicionar(T elemento) {
		this.Adicionar(tam, elemento);
	}

	@Override
	public void Adicionar(int posicao, T elemento) {
		if (posicao <=  tam) {
			AumentarTamanho();
			if (elementos[posicao] != null) {
				for (int i = tam - 1; i >= posicao; i--) {
					elementos[i + 1] = elementos[i];
				}
			}
		}
		elementos[posicao] = elemento;
		tam++;
	}

	@Override
	public void AdicionarInicio(T elemento) {
		this.Adicionar(0, elemento);
	}

	@Override
	public void Remover(int posicao) throws ArrayIndexOutOfBoundsException {
		if (tam == 0) {
			throw new IndexOutOfBoundsException("O vetor ja esta vazio");
		}
		if (posicao > tam - 1) {
			throw new IndexOutOfBoundsException("Posicao nao existe");
		}
		for (int i = posicao; i < tam - 1; i++) {
			elementos[i] = elementos[i + 1];
		}
		elementos[tam - 1] = null;
		tam--;
	}

	@Override
	public void Remover(T elemento) {
		Remover(indexOf(elemento));
	}

	@Override
	public void RemoverInicio() {
		this.Remover(0);
	}

	@Override
	public void RemoverFim() {
		if (tam == 0) {
			return;
		}
		this.elementos[this.tam - 1] = null;
		this.tam--;
	}

	@Override
	public int Tamanho() {
		return tam;
	}

	@Override
	public void Limpar() {
		for (int i = 0; i < elementos.length; i++) {
			elementos[i] = null;
		}
		tamInicial = 0;
	}

	@Override
	public boolean contem(T elemento) {
		for (int i = 0; i < elementos.length; i++) {
			if (elementos[i].equals(elemento))
				return true;
		}
		return false;
	}

	public int indexOf(T elemento) {
		for (int i = 0; i < tam; i++) {
			if (elementos[i].equals(elemento)) {
				return i;
			}
		}
		return -1;
	}

	public String toString() {
		if (this.tam == 0) {
			return "[]";
		}

		StringBuilder builder = new StringBuilder();
		builder.append("[");

		for (int i = 0; i < this.tam - 1; i++) {
			builder.append(this.elementos[i]);
			builder.append(", ");
		}

		builder.append(this.elementos[this.tam - 1]);
		builder.append("]");

		return builder.toString();
	}

	@Override
	public Iterator<T> iterator() {
		// TODO Auto-generated method stub
		return null;
	}

}
