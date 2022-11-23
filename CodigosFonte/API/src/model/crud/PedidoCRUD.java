package model.crud;

import java.util.Scanner;

import model.Pedido;
import model.dao.PedidoDAO;


public class PedidoCRUD {

	public static void main(String[] args) {
		PedidoDAO pedidoDAO = new PedidoDAO();
		Scanner sc = new Scanner(System.in);

		// setar as variaveis de navegaçao
		int opcao = 0;

		// Menu
		do {
			System.out.println("========= CRUD Cliente Jurídico =========");
			System.out.println("1- Cadastro de Cliente Jurídico");
			System.out.println("2- Listar Clientes Jurídicos");
			System.out.println("3- Delete registro de Cliente Jurídico");
			System.out.println("4- Atualização de dados de Cliente Jurídico");
			System.out.println("0- Sair");

			opcao = sc.nextInt();

			// navegaçao do crud
			switch (opcao) {
			case 1:
				Pedido pedido1 = new Pedido();
				System.out.println("****Cadastrar Pedido****");
				System.out.println("Digite ID do Pedido: ");
				pedido1.setIdPedido(sc.nextInt());
				System.out.println("Digite ID de quem requereu:");
				pedido1.setIdClienteFisico(sc.nextInt());
				System.out.println("Digite ID da viagem envolvida:");
				pedido1.setIdViagem(sc.nextInt());
				System.out.println("Digite o CPF do passageiro:");
				pedido1.setCpfPassageiro(sc.next());
				System.out.println("Digite o Nome do passageiro:");
				pedido1.setNomePassageiro(sc.next());
				System.out.println("Digite o RG do passageiro:");
				pedido1.setRgPassageiro(sc.next());
				System.out.println("Digite a quantidade de viagens:");
				pedido1.setQuantidade(sc.nextInt());

				pedidoDAO.save(pedido1);
				System.out.println("***\nCadastrado***\n");
				break;

			case 2:
				for (Pedido pedido : pedidoDAO.getPedido()) {
					System.out.println("ID do Pedido: " + pedido.getIdPedido() + " | ID do Cliente: " + pedido.getIdClienteFisico() + " | ID da Viagem: "
							+ pedido.getIdViagem() +" | CPF do Passageiro: "+ pedido.getCpfPassageiro() + " | Nome do Passageiro: " +pedido.getNomePassageiro() 
							+ " | RG do Passageiro: " + pedido.getRgPassageiro());
				}
				System.out.println("\n*Consulta Finalizada*\n");
				break;

			case 3:
				System.out.println("Informe o ID do Pedido: ");
				int id = sc.nextInt();
				System.out.println();
				pedidoDAO.removeById(id);
				
				break;

			case 4:
				System.out.println("**** Atualizando Dados de Pedido ****");
				System.out.println("Informe o ID do pedido:");
				int idPedido = sc.nextInt();
				System.out.println("Digite o ID do Cliente:");
				int idClienteFisico = sc.nextInt();
				System.out.println("Digite o ID da Viagem:");
				int idViagem = sc.nextInt();
				System.out.println("Digite o CPF do passageiro:");
				String cpfPassageiro = sc.next();
				System.out.println("Digite o Nome do passageiro:");
				String nomePassageiro = sc.next();
				System.out.println("Digite o RG do passageiro:");
				String rgPassageiro = sc.next();
				System.out.println("Digite a quantidade de viagens:");
				int quantidade = sc.nextInt();
				
				Pedido pedido = new Pedido(idPedido,idClienteFisico,idViagem,cpfPassageiro,nomePassageiro,rgPassageiro, quantidade);
				pedidoDAO.update(pedido);
				break;
				

			default:
				System.out.println(opcao != 0 ? "\n Opcao invalida, tente novamente.\n" : "");
				break;
			}

		} while (opcao != 0);

		sc.close();
		System.out.println("***Finalizado***");

	}

}
