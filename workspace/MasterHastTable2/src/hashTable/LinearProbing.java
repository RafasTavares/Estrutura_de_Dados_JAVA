package hashTable;

import java.util.Iterator;
import java.util.LinkedList;

public class LinearProbing<K,V> implements HashTable<K, V> {
	private HashTableNode<K,V>[] prob ;
	private boolean[] tombstone;
	private int elemenetNumber ;
	private int sloteNumber , slotnumberfunction;
	private final int initial_size = 11;
	private final int step = 2;
	private final double maxLoadFactor = 0.75;
	private final int increment_factor = 2;
	private int collisions;
	
	public LinearProbing() {
		@SuppressWarnings("unchecked")
		HashTableNode<K,V>[] list = (HashTableNode<K, V>[])new HashTableNode[initial_size];
		tombstone = new boolean[initial_size];
		prob = list;
		slotnumberfunction = sloteNumber = initial_size ;
		elemenetNumber = 0;
		collisions = 0;
	}

	private boolean maxLoadFactorExceeded()
	{
		if((double)elemenetNumber/(double)sloteNumber<=maxLoadFactor)
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
			int start_position = rehashFunction(key);
			for(int i=start_position;;)
			{	
				if(a[i]==null){
					a[i] = new HashTableNode<K,V>(key,get(key));
					break;
				}
				++collisions;
				i = (i+step)%slotnumberfunction;
			}
		
		}
	}

	@Override
	public void put(K key, V value) {
		if (maxLoadFactorExceeded()) {
			
			int newSize = (sloteNumber*increment_factor);
			if(newSize%2==0) newSize++;

			@SuppressWarnings("unchecked")
			HashTableNode<K,V>[] newlist = (HashTableNode<K, V>[])new HashTableNode[newSize];
			slotnumberfunction = newSize;
			rehashing(newlist);

			prob = newlist;
			tombstone = new boolean[newSize];;
			sloteNumber = newSize;
			put(key,value);
		}
		else {
			int start_position = hashFunction(key);
			if(contains(key))
			{
				for(int i=start_position;;)
				{
					if(prob[i]!=null)
					{
						if(prob[i].getKey().equals(key))
						{
							prob[i].setValue(value);
							return ;
						}
					}
					++collisions;
					i = (i+step)%sloteNumber;
				}

			} else {
				boolean overlapping = false;
				for(int i=start_position;(i!=start_position|!overlapping);)
				{
					overlapping = true;
					if(prob[i]==null)
					{
						prob[i] = new HashTableNode<K,V>(key,value);
						tombstone[i] = false;
						++elemenetNumber;
						return ;
					}
					++collisions;
					i = (i+step)%sloteNumber;
				}
			}
		}
	}

	@Override
	public V get(K key) {
		if(!contains(key)) return null;

		int start_position = hashFunction(key);
		boolean back = false;
		for (int i=start_position;(i!=start_position|!back); ) {
			back = true;
			if(prob[i]==null)
			{
				if(!tombstone[i])
					return null ;
			} else {
				if(prob[i].getKey().equals(key))
				{
					return prob[i].getValue();
				}
			}

			i=(i+step)%sloteNumber;
		}


		return null;
	}

	@Override
	public void delete(K key) {
		if(contains(key))
		{
			int start_position = hashFunction(key);
			boolean back = false;
			for (int i=start_position;(i!=start_position|!back); ) {
				back = true;
				if(prob[i]==null)
				{
					if(!tombstone[i])
						return ;
				} else {
					if(prob[i].getKey().equals(key))
					{
						tombstone[i] = true;
						prob[i]=null;
						--elemenetNumber;
						return ;
					}
				}

				i=(i+step)%sloteNumber;
			}
		}
	}

	@Override
	public boolean contains(K key) {
		int start_position = hashFunction(key);
		boolean back = false; // back again to the same position after full iteration
		for(int i=start_position;(i!=start_position|!back);)
		{
			back = true;
			if(prob[i]==null)
				return false;
			else if(prob[i].getKey().equals(key))
				return true;
			i=(i+step)%sloteNumber;
		}
		return false;
	}

	@Override
	public boolean isEmpty() {
		return elemenetNumber==0?true:false;
	}

	@Override
	public int size() {
		return elemenetNumber;
	}

	@Override
	public Iterable<K> keys() {
		LinkedList<K> allKeys = new LinkedList<K>();

		for(HashTableNode<K,V> x:prob)
		{
			if(x!=null)
				allKeys.add(x.getKey());
		}
		
		return allKeys;
	}

	private int hashFunction(K key) {
		return key.hashCode()%sloteNumber;
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
		return sloteNumber;
	}

}
