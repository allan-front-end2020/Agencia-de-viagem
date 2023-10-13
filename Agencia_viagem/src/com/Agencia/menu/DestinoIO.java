package com.Agencia.menu;

import java.sql.Connection;
import java.util.Scanner;

import com.Agencia.dao.DestinoDAO;
import com.Agencia.database.DataBaseConnection;
import com.Agencia.model.Cliente;
import com.Agencia.model.Destino;

public class DestinoIO {

	static Connection connection = DataBaseConnection.createConnection();
	static DestinoDAO destinoDAO = new DestinoDAO(connection);

	public static  int SubMenuDestino(Scanner scanner) {
		int option = Integer.MAX_VALUE;
		do {
			System.out.println("MENU DESTINO \n" + "1 - Cadastrar\n" + "2 - Listar \n " +"3 - Editar \n"
					+ "4 - Deletar \n " + "0 - Sair");

			option = scanner.nextInt();
			switch (option) {

			case 1:
				scanner.nextLine();
				Destino destino = new Destino();
				System.out.println("Nome do Destino :");
				destino.setNomeDestino(scanner.nextLine().trim());

				System.out.println("Preço da diaria :");
				destino.setPreçoDia(scanner.nextInt());


				destinoDAO.createDestino(destino);
				break;

			case 2:
				destinoDAO.readAlldestino();
				break;
			case 3:
				scanner.nextLine();
				Destino destinoAtualizado = new Destino();
				System.out.println("Digite o ID do destino para ser atualizado");
				destinoAtualizado.setIdDestino(scanner.nextInt());
				scanner.nextLine();
				System.out.println("Nome do Destino:");
				destinoAtualizado.setNomeDestino(scanner.nextLine());

				System.out.println("Preço diaria:");
				destinoAtualizado.setPreçoDia(scanner.nextInt());

				destinoDAO.updateDestino(destinoAtualizado);
				break;
			case 4:
				System.out.println("Digite o ID do Destino que deseja deletar");
				int idDestino = scanner.nextInt();
				destinoDAO.deleteDestino(idDestino);
				break;
			default:
				System.out.println("Digite uma opção valida");
			}
		} while (option != 0);
   
		
		return option;
	}
}
