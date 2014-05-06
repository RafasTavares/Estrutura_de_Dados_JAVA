package pilhaEnc;

public class Pilha<T> implements IPilha {

	ListSimpEnc<T> lista;
	private int tam = 0;

	public Pilha() {
		lista = new ListSimpEnc<T>();

	}

	@Override
	public void empilhe(Object objeto) {
		lista.InserirInicio((T) objeto);
		tam++;
	}

	@Override
	public Object desempilhe() throws PilhaVaziaException {
		Object elemento = getTopo();
		try {
			lista.RemoverInicio();
			tam--;
		}catch (Exception e) {
			// TODO: handle exception
		}
		finally {
			return elemento;
		}
	}

	@Override
	public Object getTopo() throws PilhaVaziaException {
		return lista.getInicio();
	}

	@Override
	public int size() {
		return tam;
	}

	@Override
	public boolean estaVazia() {
		return tam == 0;
	}

	@Override
	public boolean contem(Object objeto) {
		return lista.contem((T) objeto);

	}

	public Object[] toArray() {
		// TODO Auto-generated method stub
		return null;
	}

}
