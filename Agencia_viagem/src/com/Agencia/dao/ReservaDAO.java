package com.Agencia.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.Agencia.model.Cliente;
import com.Agencia.model.Destino;
import com.Agencia.model.Reserva;

public class ReservaDAO {
	
	private static String sql;

	private final Connection connection;

	public ReservaDAO(Connection connection) {
		this.connection = connection;
	}
	
	//Create
	public void createReserva(Reserva reserva) {
		sql = "INSERT INTO reserva (IdReserva, IdCliente, IdDestino ) VALUE (?,?,?)";
		try (PreparedStatement stmt = connection.prepareStatement(sql)) {

			stmt.setInt(1, reserva.getIdReserva());
			stmt.setInt(2, reserva.getCliente().getIdCliente());
			stmt.setInt(2, reserva.getDestino().getIdDestino());
			
		
			

			stmt.executeUpdate();
			System.out.println("Destino criado com sucesso !!!: " + reserva.getIdReserva());
		} catch (SQLException e) {
			System.out.println("[LOG] Não foi Fazer"+e.getMessage());
		}
	}
  
	
	//READ
	public void readAllReserva() {
		sql = "SELECT * FROM reserva as a " + "INNER JOIN cliente as p" + "ON a.idCliente = p.idCliente "
	   + "INNER JOIN Veterinario as v " + "ON a.idDestino = v.idDestino"; 
	
			try(PreparedStatement stmt = connection.prepareStatement(sql)) {
			   ResultSet r = stmt.executeQuery();
			   while(r.next()) {
				 Reserva reserva = new Reserva();
				 reserva.setIdReserva(r.getInt("idReserva"));
				 
				 //Cliente
				 Cliente cliente = new Cliente();
				 cliente.setIdCliente(r.getInt("IdCliente"));
				 cliente.setNomeCliente(r.getString("nomeCliente"));
				 
				 //Destino
				 Destino destino = new Destino();
				 destino.setIdDestino(r.getInt("IdDestino"));
				 destino.setNomeDestino(r.getString("nomeDestino"));
				 
				 System.out.println("ID Reserva : " + reserva.getIdReserva() +  "\n ID do Cliente : " 
				 + cliente.getIdCliente() +"\n Nome do cliente" + cliente.getNomeCliente() + "Nome do destino: " + destino.getNomeDestino());
				   
			   }
			   
			} catch (SQLException e) {
			} 
		}
		
	
	//UPDATE
	public void updateReserva(Reserva reserva) {
		sql = "UPDATE reserva SET idDestino = ?,  WHERE id reserva";
		try(PreparedStatement stmt = connection.prepareStatement(sql)) {
			stmt.setInt(1, reserva.getCliente().getIdCliente());
			stmt.setInt(2, reserva.getIdReserva());
			stmt.setInt(3, reserva.getDestino().getIdDestino());
		
			
			
			stmt.execute();
			System.out.println("Reserva Atualizado com sucesso !!!: ");
		} catch (SQLException e) {
		} 
	}

   //DELETE
	public void deleteReserva (int id) {
		sql = "DELETE FROM  reserva WHERE idReserva = ?";
		try (PreparedStatement stmt = connection.prepareStatement(sql)){
			stmt.setInt(1, id);
			
			
			stmt.execute();
			System.out.println("Reserva deletado com sucesso!!!");
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
	}
}
