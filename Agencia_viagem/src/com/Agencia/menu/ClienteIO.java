package com.Agencia.menu;

import java.sql.Connection;
import java.util.Scanner;

import com.Agencia.dao.ClienteDAO;
import com.Agencia.database.DataBaseConnection;
import com.Agencia.model.Cliente;

public class ClienteIO {

	static Connection connection = DataBaseConnection.createConnection();
	static ClienteDAO clienteDAO = new ClienteDAO(connection);

	public static  int SubMenuCliente(Scanner scanner) {
		int option = Integer.MAX_VALUE;
		do {
			System.out.println("MENU CLIENTE \n" + "1 - Cadastrar\n" + "2 - Listar \n " +"3 - Editar \n"
					+ "4 - Deletar \n " + "0 - Sair");

			option = scanner.nextInt();
			switch (option) {

			case 1:
				scanner.nextLine();
				Cliente cliente = new Cliente();
				System.out.println("Nome Completo :");
				cliente.setNomeCliente(scanner.nextLine());

				System.out.println("CPF :");
				cliente.setCpfCliente(scanner.nextLine().trim());

				System.out.println("Telefone 1:");
				cliente.setTelCliente(scanner.nextLine().trim());

				clienteDAO.createCliente(cliente);
				break;

			case 2:
				clienteDAO.readAllClients();
				break;
			case 3:
				scanner.nextLine();
				Cliente clienteAtualizado = new Cliente();
				System.out.println("Digite o ID do cliente para ser atualizado");
				clienteAtualizado.setIdCliente(scanner.nextInt());
				scanner.nextLine();
				System.out.println("Nome Completo :");
				clienteAtualizado.setNomeCliente(scanner.nextLine());

				System.out.println("CPF :");
				clienteAtualizado.setCpfCliente(scanner.nextLine().trim());

				System.out.println("Telefone 1:");
				clienteAtualizado.setTelCliente(scanner.nextLine().trim());

				clienteDAO.updateCliente(clienteAtualizado);
				break;
			case 4:
				System.out.println("Digite o ID do Cliente que deseja deletar");
				int idCliente = scanner.nextInt();
				clienteDAO.deleteCliente(idCliente);
				break;
			default:
				System.out.println("Digite uma opção valida");
			}
		} while (option != 0);
   
		
		return option;
	}

}
