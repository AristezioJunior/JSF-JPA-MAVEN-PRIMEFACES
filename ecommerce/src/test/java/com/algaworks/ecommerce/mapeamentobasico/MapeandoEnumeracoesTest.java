package com.algaworks.ecommerce.mapeamentobasico;

import org.junit.Test;

import com.algaworks.ecommerce.EntityManagerTest;
import com.algaworks.ecommerce.model.Cliente;
import com.algaworks.ecommerce.model.SexoCliente;

import junit.framework.Assert;

public class MapeandoEnumeracoesTest extends EntityManagerTest {

	@Test
	public void testarEnum() {
		
		Cliente cliente = new Cliente();
		//cliente.setId(4); Comentado porque estamos usando o IDENTITY
		cliente.setNome("Henrique Campos Marinho");
		cliente.setSexo(SexoCliente.MASCULINO);
		
		entityManager.getTransaction().begin();
		entityManager.persist(cliente);
		entityManager.getTransaction().commit();
		
		entityManager.clear();
		
		Cliente clienteVerificacao = entityManager.find(Cliente.class, 4);
		Assert.assertNotNull(clienteVerificacao);
		
	}
	
}
