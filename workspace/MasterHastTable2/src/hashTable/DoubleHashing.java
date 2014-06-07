package hashTable;

import java.util.Iterator;
import java.util.LinkedList;

public class DoubleHashing<K,V> implements HashTable<K, V> {

	private HashTableNode<K,V>[] doubleHashing ;
	private boolean[] tombstone ;
	private int slotNumber , slotnumberfunction ;
	private int elemenetsNumber ;
	private final int initial_size = 16;
	private final double maxLoadFactor = 0.75;
	private final int increment_factor = 2;
	private int collisions;


	public DoubleHashing()
	{
		// initializing the parameters :))
		@SuppressWarnings("unchecked")
		HashTableNode<K,V>[] list = (HashTableNode<K, V>[])new HashTableNode[initial_size];
		doubleHashing = list ;
		tombstone = new boolean[initial_size];
		slotNumber = slotnumberfunction = initial_size ;
		elemenetsNumber = 0;
		collisions = 0;
	}

	private int doubleFunction(int position)
	{
		return (((position/slotNumber)%(slotNumber/2)) * 2 )+ 1 ;
	}

	private boolean maxLoadFactorExceeded()
	{
		if((double)elemenetsNumber/(double)slotNumber<maxLoadFactor)
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
			if(a[position]==null)
			{
				a[position] = new HashTableNode<K,V>(key,get(key));

			} else {
				int v = doubleFunction(position);
				int index = position ;
				for (int i=0;i<slotNumber;i++) {
					index = ( index + v ) % slotNumber;
					if(a[index]==null)
					{
						a[index] = new HashTableNode<K,V>(key,get(key));
						break;
					} 
					++collisions;
				}
			}

		}
	}

	@Override
	public void put(K key, V value) {
		if(maxLoadFactorExceeded())
		{
			int newSize = slotNumber*increment_factor ;

			@SuppressWarnings("unchecked")
			HashTableNode<K,V>[] list = (HashTableNode<K, V>[])new HashTableNode[newSize];
			slotnumberfunction = newSize ;
			rehashing(list);

			doubleHashing = list ;
			slotNumber = newSize ;
			tombstone = new boolean[newSize];
			put(key,value);

		} else {
			int position = hashFunction(key);

			if(contains(key))
			{
				
				if(doubleHashing[position]!=null)
				{
					if(doubleHashing[position].getKey().equals(key))
					{
						doubleHashing[position].setValue(value);
						return;
					}
				}

				int v = doubleFunction(position);
				int index = position ;
				for (int i=0;i<slotNumber;i++) {
					index = ( index + v ) % slotNumber;
					if(doubleHashing[index]!=null)
					{
						if(doubleHashing[index].getKey().equals(key))
						{
							doubleHashing[index].setValue(value);
							return ;
						}
						++collisions;
					}
				}
			} else {
				if(doubleHashing[position]==null)
				{
					doubleHashing[position] = new HashTableNode<K,V>(key,value);
					tombstone[position]=false;
					++elemenetsNumber ;
					return ;
				}
				++collisions;
				int v = doubleFunction(position);
				int index = position ;
				for (int i=0;i<slotNumber;i++) {
					index = ( index + v ) % slotNumber;
					if(doubleHashing[index]==null)
					{
						doubleHashing[index] = new HashTableNode<K,V>(key,value);
						tombstone[index]=false;
						++elemenetsNumber ;
						return ;
					}
					++collisions;
				}
			}
		}
	}

	@Override
	public V get(K key) {
		int position = hashFunction(key);

		if(doubleHashing[position]==null)
		{
			if(!tombstone[position])
				return null;
		} else {
			if(doubleHashing[position].getKey().equals(key))
				return doubleHashing[position].getValue();
		}

		int v = doubleFunction(position);
		int index = position ;
		for (int i=0;i<slotNumber;i++) {
			index = ( index + v ) % slotNumber;
			if(doubleHashing[index]==null)
			{
				if(!tombstone[index])
					return null;

			} else {
				if(doubleHashing[index].getKey().equals(key))
					return doubleHashing[index].getValue();
			}
		}

		return null;
	}

	@Override
	public void delete(K key) {

		if(!contains(key)) return ;

		int position = hashFunction(key);
		if(doubleHashing[position]!=null)
		{
			if(doubleHashing[position].getKey().equals(key))
			{
				doubleHashing[position] = null;
				tombstone[position] = true;
				--elemenetsNumber;
				return ;
			}
		} 
		int v = doubleFunction(position);
		int index = position ;
		for (int i=0;i<slotNumber;i++) {
			index = ( index + v ) % slotNumber;
			if(doubleHashing[index]==null)
			{
				if(doubleHashing[index].getKey().equals(key))
				{
					doubleHashing[index] = null;
					tombstone[index] = true;
					--elemenetsNumber;
					return ;
				}
			}
		}
		
	}

	@Override
	public boolean contains(K key) {
		int position = hashFunction(key);
		if(doubleHashing[position]==null)
		{
			if(!tombstone[position])
				return false;
		} else {
			if(doubleHashing[position].getKey().equals(key))
				return true;
		}
		int v = doubleFunction(position);
		int index = position ;
		for (int i=0;i<slotNumber;i++) {
			index = ( index + v ) % slotNumber;
			if(doubleHashing[index]==null)
			{
				if(!tombstone[index])
					return false;

			} else {
				if(doubleHashing[index].getKey().equals(key))
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

		for(int i=0;i<slotNumber;i++)
		{
			if(doubleHashing[i]!=null)
				allKeys.add(doubleHashing[i].getKey());
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
