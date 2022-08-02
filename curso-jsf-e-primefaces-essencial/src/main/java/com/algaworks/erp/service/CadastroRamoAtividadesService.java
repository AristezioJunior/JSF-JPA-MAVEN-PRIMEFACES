package com.algaworks.erp.service;

import java.io.Serializable;

import javax.inject.Inject;

import com.algaworks.erp.model.RamoAtividade;
import com.algaworks.erp.repository.RamoAtividades;
import com.algaworks.erp.util.Transacional;

public class CadastroRamoAtividadesService implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Inject
	private RamoAtividades ramoAtividades;
	
	@Transacional
	public void salvar(RamoAtividade ramoAtividade) {
		ramoAtividades.guardar(ramoAtividade);
	}
	
	@Transacional
	public void Excluir(RamoAtividade ramoAtividade) {
		ramoAtividades.remover(ramoAtividade);
	}
	
	
}
