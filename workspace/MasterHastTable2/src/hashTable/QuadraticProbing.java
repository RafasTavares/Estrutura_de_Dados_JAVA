package hashTable;

import java.util.Iterator;
import java.util.LinkedList;

public class QuadraticProbing<K,V> implements HashTable<K, V> {

	private HashTableNode<K,V>[] qProb ;
	private boolean[] tombstone ;
	private int slotNumber , slotnumberfunction ;
	private int elemenetsNumber ;
	private final int initial_size = 10;
	private final double maxLoadFactor = 0.75;
	private final int increment_factor = 2;
	private int collisions;


	public QuadraticProbing()
	{
		@SuppressWarnings("unchecked")
		HashTableNode<K,V>[] list = (HashTableNode<K, V>[])new HashTableNode[initial_size];
		qProb = list ;
		
		tombstone = new boolean[initial_size];

		slotnumberfunction = slotNumber = initial_size ;
		elemenetsNumber = 0;
		collisions = 0;
	}


	private boolean maxLoadFactorExceeded()
	{
		if((double)elemenetsNumber/(double)slotNumber < maxLoadFactor)
			return false;
		return true;
	}

	private void rehashing(HashTableNode<K,V>[] a)
	{
		Iterator<K> itr = keys().iterator();
		K key ;
		while(itr.hasNext())
		{
			key = itr.next();
			int position = rehashFunction(key);
			for(int i=1;i<slotnumberfunction;i++)
			{
				int v = ( position + (i*i) ) % slotnumberfunction ;
				if(a[v]==null)
				{
					a[v] = new HashTableNode<K,V>(key,get(key));
					break;
				}
				++collisions;
			}
		}
	}

	private int Qfunction(int x,int i)
	{
		return (x+(i*i)) % slotNumber ;
	}

	@Override
	public void put(K key, V value) {
		if(maxLoadFactorExceeded())
		{
			int newSize = (slotNumber*increment_factor);
			@SuppressWarnings("unchecked")
			HashTableNode<K,V>[] newlist = (HashTableNode<K, V>[])new HashTableNode[newSize];
			slotnumberfunction = newSize;
			rehashing(newlist);

			qProb = newlist;
			tombstone = new boolean[newSize];
			slotNumber = newSize ;
			put(key, value);
		} else {
			int position = hashFunction(key);
			if(contains(key))
			{
				for (int i=1;i<slotNumber;i++) {
					int v = Qfunction(position,i);
					if(qProb[v]!=null)
						if(qProb[v].getKey().equals(key))
						{
							qProb[v].setValue(value);
							return ;
						}
					++collisions;
				}
			} else {
				for (int i=1;i<slotNumber;i++) {
					int v = Qfunction(position,i);
					if(qProb[v]==null)
					{
						qProb[v] = new HashTableNode<K,V>(key,value);
						tombstone[v] = false;
						++elemenetsNumber;
						return ;
					}
					++collisions;
				}
			}
		}
	}

	@Override
	public V get(K key) {
		if(!contains(key)) return null;

		int position = hashFunction(key);

		for(int i = 1 ; i<slotNumber;i++)
		{
			int v = Qfunction(position,i);
			if(qProb[v]!=null)
			{
				if(qProb[v].getKey().equals(key))
					return qProb[v].getValue();
			}
		}
		return null;
	}

	@Override
	public void delete(K key) {
		if(!contains(key)) return ;

		int position = hashFunction(key);

		for(int i = 1 ; i<slotNumber;i++)
		{
			int v = Qfunction(position,i);
			if(qProb[v]!=null)
			{
				if(qProb[v].getKey().equals(key))
				{
					qProb[v]=null;
					tombstone[v]=true;
					--elemenetsNumber;
					return ;
				}
			}
		}

	}

	@Override
	public boolean contains(K key) {
		int position = hashFunction(key);

		for(int i = 1 ; i<slotNumber;i++)
		{
			int v = Qfunction(position,i);
			if(qProb[v]==null)
			{
				if(!tombstone[v])
					return false;

			} else {
				if(qProb[v].getKey().equals(key))
					return true;
			}
		}

		return false;
	}

	@Override
	public boolean isEmpty() {
		return elemenetsNumber==0?true:false;
	}

	@Override
	public int size() {
		return elemenetsNumber;
	}

	@Override
	public Iterable<K> keys() {
		LinkedList<K> allKeys = new LinkedList<K>();

		for(HashTableNode<K,V> x:qProb)
		{
			if(x!=null)
				allKeys.add(x.getKey());
		}

		return allKeys;
	}

	
	private int hashFunction(K key) {
		return key.hashCode()%slotNumber;
	}
	
	private int rehashFunction(K key) {
		return key.hashCode()%slotnumberfunction;
	}


	@Override
	public int collisonsNumber() {
		return collisions;
	}


	@Override
	public int getMemoryInfo() {
		return slotNumber;
	}

}
