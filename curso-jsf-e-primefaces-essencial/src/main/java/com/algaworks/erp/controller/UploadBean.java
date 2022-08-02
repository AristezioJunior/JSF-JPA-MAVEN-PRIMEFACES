package com.algaworks.erp.controller;

import java.io.Serializable;

import javax.faces.bean.ViewScoped;
import javax.inject.Named;

@Named
@ViewScoped
public class UploadBean implements Serializable{


	private static final long serialVersionUID = 1L;
	private String test = new String();
	
	
	public void upload( ) {
		String teste;
		teste = this.test;
		System.out.println(teste);
		
	}
		


	public String getTest() {
		return test;
	}

	public void setTest(String test) {
		this.test = test;
	}
	
	
	
	
}
