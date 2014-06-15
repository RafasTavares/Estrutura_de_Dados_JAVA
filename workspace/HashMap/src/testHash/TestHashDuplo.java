package testHash;

import static org.junit.Assert.*;
import hash.HashDuplo;

import org.junit.Before;
import org.junit.Test;

public class TestHashDuplo {

	private HashDuplo<Integer> hash;

	@Before
	public void Iniciar() {
		hash = new HashDuplo<Integer>(10);
	}

	@Test
	public void Adicionar() {
		 hash.add(1);
		 hash.add(2);
		 hash.add(3);
		 hash.add(4);
		 hash.add(5);
		 hash.add(6);
		 hash.add(7);
		 hash.add(8);
		 hash.add(9);
		 hash.add(10);
		 hash.add(11);
		 hash.add(12);
		 hash.add(13);
		 hash.add(14);
		 hash.add(15);
		 hash.add(16);
		 hash.add(17);
		 hash.add(18);
		 hash.add(19);
		 hash.add(20);
		 hash.add(21);
		 hash.add(22);
		 hash.add(23);
		 
		 
		System.out.println("Adiconar: " + hash.ToString());
	}

	@Test
	public void Contem() {
		hash.add(45);
		hash.add(16);
		hash.add(17);
		hash.add(32);
		hash.add(48);
		assertEquals(true, hash.contains(16));
		assertEquals(false, hash.contains(23));
		assertEquals(true, hash.contains(45));
		System.out.println("Contem: " + hash.ToString());

	}

	@Test
	public void ContemErro() {
		hash.add(32);
		hash.add(38);
		hash.add(44);
		// assertEquals(false, hash.contains(50));
		// assertEquals(true, hash.contains(38));
		assertEquals(true, hash.contains(32));
		// assertEquals(true, hash.contains(44));
		System.out.println("Contem erro: " + hash.ToString());
	}

	@Test
	public void Remove() {
		hash.add(32);
		hash.add(38);
		assertEquals(true, hash.contains(32));
		hash.remove(32);
		assertEquals(false, hash.contains(32));
		System.out.println("Remove: " + hash.ToString());
	}

	@Test
	public void RemoveColisao() {
		hash.add(32);
		hash.add(38);
		hash.remove(38);
		hash.add(44);
		assertEquals(false, hash.contains(38));
		assertEquals(true, hash.contains(32));
		System.out.println("ToString: " + hash.ToString());

	}

	@Test
	public void ToStringAdc() {
		hash.add(1);
		hash.add(2);
		hash.add(3);
		hash.add(5);
		System.out.println("ToString: " + hash.ToString());
	}

	@Test
	public void ToStringRemove() {
		hash.add(1);
		hash.add(2);
		hash.add(3);
		hash.add(5);
		hash.remove(3);
		hash.remove(2);
		System.out.println("ToString: " + hash.ToString());
	}
	
	@Test
	public void TestRetrive(){
		hash.add(11);
		hash.add(21);
		hash.add(13);
		hash.remove(21);
		System.out.println(hash.Retrive(21));
	}
	@Test
	public void TestRetrive1(){
		hash.add(11);
		hash.add(21);
		hash.add(13);
		hash.remove(21);
		System.out.println(hash.Retrive(21));
		System.out.println(hash.Retrive(13));
	}
	@Test
	public void TestRetrive2(){
		hash.add(11);
		hash.add(21);
		hash.add(13);
		hash.remove(21);
		hash.remove(13);
		System.out.println(hash.Retrive(21));
		System.out.println(hash.Retrive(13));		
		System.out.println(hash.Retrive(11));
		System.out.println(hash.ToString());
	}
	@Test
	public void TestRetrive3(){
		hash.add(11);
		hash.add(21);
		hash.add(13);
		hash.remove(21);
		hash.remove(11);
		hash.remove(13);
		System.out.println(hash.Retrive(21));
		System.out.println(hash.Retrive(11));
		System.out.println(hash.Retrive(13));
		
	}

	@Test
	public void TestRetrive4(){
		hash.add(11);
		hash.add(21);
		hash.add(13);
		hash.remove(21);
		hash.remove(11);
		hash.remove(13);
		System.out.println(hash.Retrive(21));
		System.out.println(hash.Retrive(11));
		System.out.println(hash.Retrive(14));
		System.out.println(hash.Retrive(23));
		System.out.println(hash.Retrive(999));
		System.out.println(hash.Retrive(34));
		System.out.println(hash.Retrive(123));
		System.out.println(hash.Retrive(3));
	}
	@Test
	public void TestRetrive5(){
		hash.add(11);
		hash.add(21);
		hash.add(13);
		hash.add(19);
		hash.add(35);
		hash.add(24);
		System.out.println(hash.Retrive(21));
		System.out.println(hash.Retrive(11));
		System.out.println(hash.Retrive(13));
		System.out.println(hash.Retrive(24));
		System.out.println(hash.Retrive(35));
		System.out.println(hash.Retrive(19));
		System.out.println(hash.remove(11));
		System.out.println(hash.Retrive(11));
	}
	
	@Test
	public void TesteValues(){
		hash.add(11);
		hash.add(21);
		hash.add(13);

		System.out.println(hash.values().toString());
	}
	
	@Test
	public void AddTestLouco(){
		hash.add(11);
		hash.add(11);
		hash.add(11);
		hash.add(11);
		hash.add(21);
		hash.add(13);
		hash.add(19);
		hash.add(35);
		hash.add(24);
		System.out.println(hash.ToString());
		hash.remove(11);
		System.out.println(hash.ToString());

	}
}
