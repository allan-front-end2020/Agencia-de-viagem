package com.Agencia.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.Agencia.model.Cliente;

public class ClienteDAO {

	private static String sql;

	private final Connection connection;

	public ClienteDAO(Connection connection) {
		this.connection = connection;
	}

	// CREATE
	public void createCliente(Cliente cliente) {
		sql = "INSERT INTO cliente (nomeCliente, cpfCliente, telCliente ) VALUE (?,?,?)";
		try (PreparedStatement stmt = connection.prepareStatement(sql)) {

			stmt.setString(1, cliente.getNomeCliente());
			stmt.setString(2, cliente.getCpfCliente());
			stmt.setString(3, cliente.getTelCliente());

			stmt.executeUpdate();
			System.out.println("");
			System.out.println("Cliente cadastrado com sucesso !!!: " );
			System.out.println("");
		} catch (SQLException e) {
			System.out.println("[LOG] Não foi possivel criar cliente"+e.getMessage());
		}
	}

	// READ
	public void readAllClients() {
		sql = "SELECT * FROM cliente";
		try (PreparedStatement stmt = connection.prepareStatement(sql)) {
			ResultSet r = stmt.executeQuery();
			while (r.next()) {
				Cliente cliente = new Cliente();
				cliente.setIdCliente(r.getInt("IdCliente"));
				cliente.setNomeCliente(r.getString("nomeCliente"));
				cliente.setCpfCliente(r.getString("cpfCliente"));
				cliente.setTelCliente(r.getString("telCliente"));
				System.out.println("*********************************");
				System.out.println("");
				System.out.println("ID    : " + cliente.getIdCliente());
				System.out.println("Nome: " + cliente.getNomeCliente());
				System.out.println("CPF: " + cliente.getCpfCliente());
				System.out.println("Tel: " + cliente.getTelCliente());
				System.out.println("");
				System.out.println("*********************************");

			}

			

		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}

	}

	
	//UPDATE
	public void updateCliente(Cliente cliente) {
		sql = "UPDATE cliente SET nomeCliente = ?, cpfCliente = ?, telCliente = ? WHERE idCliente = ?";
		try(PreparedStatement stmt = connection.prepareStatement(sql)) {
			stmt.setString(1, cliente.getNomeCliente());
			stmt.setString(2, cliente.getCpfCliente());
			stmt.setString(3, cliente.getTelCliente());
			stmt.setInt(4, cliente.getIdCliente());
			
			
			stmt.execute();
			System.out.println("cliente Atualizado com sucesso !!!: ");
		} catch (SQLException e) {
		} 
	}

	
	//DELETE

	public void deleteCliente (int id) {
		sql = "DELETE FROM  cliente WHERE idCliente = ?";
		try (PreparedStatement stmt = connection.prepareStatement(sql)){
			stmt.setInt(1, id);
			
			
			stmt.execute();
			System.out.println("Cliente deletado com sucesso!!!");
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
	}
	
	
	
	
	
}
