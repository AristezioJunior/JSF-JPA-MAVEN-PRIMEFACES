package com.algaworks.ecommerce.relacionamentos;

import org.junit.Test;

import com.algaworks.ecommerce.EntityManagerTest;
import com.algaworks.ecommerce.model.Pedido;

import junit.framework.Assert;

public class RemovendoEntidadesReferenciadasTest extends EntityManagerTest {

	@Test
	public void removendoEntidadeRelacionada() {
		
		Pedido pedido = entityManager.find(Pedido.class, 1);
		
		Assert.assertFalse(pedido.getItens().isEmpty());
		
		entityManager.getTransaction().begin();
		pedido.getItens().forEach(i -> entityManager.remove(i));
		entityManager.remove(pedido);
		entityManager.getTransaction().commit();
		
		entityManager.clear();
		
		Pedido pedidoVerificacao = entityManager.find(Pedido.class, 1);
		Assert.assertNull(pedidoVerificacao);
		
	}
	
	
}
