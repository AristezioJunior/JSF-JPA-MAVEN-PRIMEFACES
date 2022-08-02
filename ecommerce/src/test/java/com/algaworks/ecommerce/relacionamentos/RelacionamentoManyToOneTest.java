package com.algaworks.ecommerce.relacionamentos;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import org.junit.Test;

import com.algaworks.ecommerce.EntityManagerTest;
import com.algaworks.ecommerce.model.Cliente;
import com.algaworks.ecommerce.model.EnderecoEntregaPedido;
import com.algaworks.ecommerce.model.ItemPedido;
import com.algaworks.ecommerce.model.Pedido;
import com.algaworks.ecommerce.model.Produto;
import com.algaworks.ecommerce.model.StatusPedido;

import junit.framework.Assert;

public class RelacionamentoManyToOneTest extends EntityManagerTest{
	
	@Test
	public void verificarRelacionamento() {
		Cliente cliente = entityManager.find(Cliente.class, 1);
		
		EnderecoEntregaPedido endereco = new EnderecoEntregaPedido();
		endereco.setCep("000000-00");
		endereco.setLogradouro("Rua Gago Coutinho");
		endereco.setNumero("111");
		endereco.setComplemento("Casa");
		endereco.setBairro("Maraponga");
		endereco.setCidade("Fortaleza");
		endereco.setEstado("CE");
		
		Pedido pedido = new Pedido();
		//pedido.setId(1);  Comentado porque estamos usando o IDENTITY
		pedido.setDataCriacao(LocalDateTime.now());
		pedido.setStatus(StatusPedido.AGUARDANDO);
		pedido.setTotal(new BigDecimal(1000));
		pedido.setEnderecoEntrega(endereco);
		pedido.setCliente(cliente);
		
		entityManager.getTransaction().begin();
		entityManager.persist(pedido);
		entityManager.getTransaction().commit();
		
		entityManager.clear();
		
		Pedido pedidoVerificacao = entityManager.find(Pedido.class, pedido.getId());
		Assert.assertNotNull(pedidoVerificacao);
		
	}
	
	
	 @Test
	    public void verificarRelacionamentoItemPedido() {
	        Cliente cliente = entityManager.find(Cliente.class, 1);
	        Produto produto = entityManager.find(Produto.class, 1);

	        Pedido pedido = new Pedido();
	        pedido.setStatus(StatusPedido.AGUARDANDO);
	        pedido.setDataCriacao(LocalDateTime.now());
	        pedido.setTotal(BigDecimal.TEN);
	        pedido.setCliente(cliente);

	        ItemPedido itemPedido = new ItemPedido();
	        itemPedido.setPrecoProduto(produto.getPreco());
	        itemPedido.setQuantidade(1);
	        itemPedido.setPedido(pedido);
	        itemPedido.setProduto(produto);

	        entityManager.getTransaction().begin();
	        entityManager.persist(pedido);
	        entityManager.persist(itemPedido);
	        entityManager.getTransaction().commit();

	        entityManager.clear();

	        ItemPedido itemPedidoVerificacao = entityManager.find(ItemPedido.class, itemPedido.getPedidoId());
	        Assert.assertNotNull(itemPedidoVerificacao.getPedido());
	        Assert.assertNotNull(itemPedidoVerificacao.getProduto());
	    }
	
	
}
