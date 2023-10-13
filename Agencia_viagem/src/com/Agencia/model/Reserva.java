package com.Agencia.model;

public class Reserva {
	
	private int IdReserva;
	
	private Cliente cliente;
	
	private Destino destino;

	public int getIdReserva() {
		return IdReserva;
	}

	public void setIdReserva(int idReserva) {
		IdReserva = idReserva;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public Destino getDestino() {
		return destino;
	}

	public void setDestino(Destino destino) {
		this.destino = destino;
	}
	
	

}
