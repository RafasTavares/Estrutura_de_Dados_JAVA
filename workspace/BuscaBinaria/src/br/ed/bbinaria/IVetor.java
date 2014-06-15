package br.ed.bbinaria;

import java.util.Iterator;

public interface IVetor<T> {
	
	public void Adicionar(T elemento);
	
	public void Adicionar(int posicao, T elemento);
	
	public void AdicionarInicio(T elemento);
	
	public void Remover(int posicao);
	
	public void Remover(T elemento);
	
	public void RemoverInicio();
	
	public void RemoverFim();
	
	public int Tamanho();
	
	public void Limpar();
	
	public int contem(T elemento);
	
	public Iterator<T> iterator();
	
	public int indexOf(T elemento);
	
	public int lastIndexOf(T elemento);
	
}
