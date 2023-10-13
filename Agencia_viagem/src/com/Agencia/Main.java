package com.Agencia;

import java.util.Scanner;

import com.Agencia.dao.ClienteDAO;
import com.Agencia.dao.DestinoDAO;
import com.Agencia.database.DataBaseConnection;
import com.Agencia.menu.MenuIO;
import com.Agencia.model.Cliente;

public class Main {

	public static void main(String[] args) {

		

		Scanner scanner = new Scanner(System.in);
		
		
		

		var option = 0;

		do {

		
			option = MenuIO.menu(scanner);

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

				//clienteDAO.createCliente(cliente);

				break;
			case 2:
				//clienteDAO.readAllClients();

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
				
				//clienteDAO.updateCliente(clienteAtualizado);
				break;
			case 4:
				System.out.println("Digite o ID do Cliente que deseja deletar");
				int idCliente =scanner.nextInt();
				//clienteDAO.deleteCliente(idCliente);
				break;
			default:
				break;
			}

		} while (option != 5);
	
		
		
		
		 
	}
 
	
	
}
