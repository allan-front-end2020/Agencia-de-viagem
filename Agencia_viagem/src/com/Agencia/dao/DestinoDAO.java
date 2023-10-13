package com.Agencia.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.Agencia.model.Destino;

public class DestinoDAO {

	private static String sql;

	private final Connection connection;

	public DestinoDAO(Connection connection) {
		this.connection = connection;

	}

	// create
	public void createDestino(Destino destino) {

		sql = "INSERT INTO destino (nomeDestino, precoDia ) VALUE (?,?)";
		try (PreparedStatement stmt = connection.prepareStatement(sql)) {

			stmt.setString(1, destino.getNomeDestino());
			stmt.setInt(2, destino.getPreçoDia());

			stmt.executeUpdate();
			System.out
					.println("Destino cadatrado com sucesso !!!: " + destino.getNomeDestino() + destino.getPreçoDia());
		} catch (SQLException e) {
			System.out.println("[LOG] Não foi possivel cadastrar destino" + e.getMessage());
		}

	}

	// READ
	public void readAlldestino() {
		
		sql = "SELECT * FROM destino";
		try (PreparedStatement stmt = connection.prepareStatement(sql)) {
			ResultSet r = stmt.executeQuery();
			while (r.next()) {
				
				Destino destino =new  Destino();
				destino.setIdDestino(r.getInt("IdDestino"));
				destino.setNomeDestino(r.getString("nomeDestino"));
				destino.setPreçoDia(r.getInt("PrecoDia"));

				System.out.println("ID    : " + destino.getIdDestino());
				System.out.println("Nome: " + destino.getNomeDestino());
				System.out.println("Preo da diaria: " + destino.getPreçoDia());

				System.out.println("");
				System.out.println("*********************************");

			}

		} catch (Exception e) {
            System.out.println("Não foi possivel Lista os destinos");
		}

	}
	
	//UPDATE
	public void updateDestino(Destino destino) {
		sql = "UPDATE destino SET nomeDestino = ?, PrecoDia = ? WHERE idDestino = ?";
		try(PreparedStatement stmt = connection.prepareStatement(sql)) {
			stmt.setString(1, destino.getNomeDestino());
			stmt.setInt(2, destino.getPreçoDia());
			stmt.setInt(3, destino.getIdDestino());
	
			stmt.execute();
			System.out.println("Destino Atualizado com sucesso !!!: ");
		} catch (SQLException e) {
			System.out.println("Falha a atualizar destino !!!: ");
		} 
	}

	//DELETE
	public void deleteDestino (int id) {
		sql = "DELETE FROM  destino WHERE idDestino = ?";
		try (PreparedStatement stmt = connection.prepareStatement(sql)){
			stmt.setInt(1, id);
			
			
			stmt.executeUpdate();
			System.out.println("Destino2"
					+ " deletado com sucesso!!!");
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
	}
	
	
}

