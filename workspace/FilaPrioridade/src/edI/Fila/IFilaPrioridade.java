package edI.Fila;

import java.io.FileNotFoundException;

public interface IFilaPrioridade<T> {
	public void Enfileirar(T objeto, int prioridade) throws PilhaCheiaException;
	public T Remover() throws FilaVaziaException;
	public String toString();
	public boolean estaVazia();
}
