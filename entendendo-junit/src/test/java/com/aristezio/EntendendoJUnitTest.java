package com.aristezio;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;



public class EntendendoJUnitTest {

	@BeforeClass
	public static void iniciarTestes() {
		System.out.println(">>>>>>>>>>>Public static void iniciarTestes<<<<<<<<<<<");
	}
	
	@AfterClass
	public static void encerrarTestes() {
		System.out.println(">>>>>>>>>>>Public static void encerrarTestes<<<<<<<<<<<");
	}
	@Before
	public void iniciarTeste() {
		System.out.println(">>>>>>>>>>>Public  void iniciarTeste<<<<<<<<<<<");	
	}
	
	@After
	public void encerrarTeste() {
		System.out.println(">>>>>>>>>>>Public void encerrarTeste<<<<<<<<<<<");
	}
	
	
	@Test
	public void testantoAlgo() {
		System.out.println(">>>>>>>>>>>Public void testandoAlgo<<<<<<<<<<<");
	}
	
	@Test
	public void testantoAlgo2() {
		System.out.println(">>>>>>>>>>>Public void testandoAlgo2<<<<<<<<<<<");
	}
	
	@Test
	public void entendendoAssert(){
		String nome = String.format("%s", "Aristezio");
		
		Assert.assertEquals("Aristezio", nome);
	}
	
	@Test
	public void entendendoAssertDois(){
		String str = String.format("%s", "");
		
		Assert.assertTrue(str.isEmpty());
	}
	
	
}
