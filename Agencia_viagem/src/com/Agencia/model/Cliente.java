package com.Agencia.model;

public class Cliente {
	
	
     private int idCliente;
     
     private String nomeCliente;
     
     private String cpfCliente;
     
     private String telCliente;
     
     
     
     
	public Cliente() {
		super();
		// TODO Auto-generated constructor stub
	}



	public Cliente(String nomeCliente, String cpfCliente, String telCliente) {
		super();
		this.nomeCliente = nomeCliente;
		this.cpfCliente = cpfCliente;
		this.telCliente = telCliente;
	}



	public int getIdCliente() {
		return idCliente;
	}



	public void setIdCliente(int idCliente) {
		this.idCliente = idCliente;
	}



	public String getNomeCliente() {
		return nomeCliente;
	}



	public void setNomeCliente(String nomeCliente) {
		this.nomeCliente = nomeCliente;
	}



	public String getCpfCliente() {
		return cpfCliente;
	}



	public void setCpfCliente(String cpfCliente) {
		this.cpfCliente = cpfCliente;
	}



	public String getTelCliente() {
		return telCliente;
	}



	public void setTelCliente(String telCliente) {
		this.telCliente = telCliente;
	}
     
     
     
     


        
     

}
