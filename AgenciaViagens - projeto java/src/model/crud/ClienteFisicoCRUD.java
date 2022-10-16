package model.crud;

import java.util.Scanner;

import model.ClienteFisico;
import model.dao.ClienteFisicoDAO;

public class ClienteFisicoCRUD {
	public static void main(String[] args) {
		// criar uma instancia do DAO para utilizar os metodos
		ClienteFisicoDAO cfDAO = new ClienteFisicoDAO();
		Scanner sc = new Scanner(System.in);

		// setar as variaveis de navegaçao
		int opcao = 0;

		// Menu
		do {
			System.out.println("========= CRUD Cliente Físico =========");
			System.out.println("1- Cadastro de Cliente Físico");
			System.out.println("2- Listar Clientes Físicos");
			System.out.println("3- Delete registro de Cliente Físico");
			System.out.println("4- Atualização de dados de Cliente Físico");
			System.out.println("0- Sair");

			opcao = sc.nextInt();

			// navegaçao do crud
			switch (opcao) {
			case 1:
				ClienteFisico cf = new ClienteFisico();
				System.out.println("****Cadastrar Cliente Físico****");
				System.out.println("Digite ID");
				cf.setIdClienteFisico(sc.nextInt());
				System.out.println("Digite o CPF:");
				cf.setCpf(sc.next());
				System.out.println("Digite o RG:");
				cf.setRg(sc.next());
				System.out.println("Digite o nome:");
				cf.setNome(sc.next());
				System.out.println("Digite o email:");
				cf.setEmail(sc.next());
				System.out.println("Digite a rua:");
				cf.setRua(sc.next());
				cf.setRua(sc.next());
				System.out.println("Digite o número da casa:");
				cf.setNumero(sc.next());
				System.out.println("Digite a cidade:");
				cf.setCidade(sc.next());
				System.out.println("Digite o estado:");
				cf.setEstado(sc.next());
				System.out.println("Digite o complemento:");
				cf.setComplemento(sc.next());
				System.out.println("Digite o cep:");
				cf.setCep(sc.next());
				System.out.println("Digite o telefone:");
				cf.setTelefone(sc.next());

				cfDAO.save(cf);
				System.out.println("***Cadastrado***\n");
				break;

			case 2:
				for (ClienteFisico cf2 : cfDAO.getClienteFisico()) {
					System.out.println("ID: " + cf2.getIdClienteFisico() + " | Nome: " + cf2.getNome() + " | CPF: "
							+ cf2.getCpf() + " | RG: " + cf2.getRg() + " | EMAIL: " + cf2.getEmail() + " | Telefone: "
							+ cf2.getTelefone() + " | Endereço: " + cf2.getRua() + ", " + cf2.getNumero() + ", "
							+ cf2.getCidade() + ", " + cf2.getEstado() + ", " + cf2.getComplemento() + ", "
							+ cf2.getCep());
				}
				System.out.println("\n*Consulta Finalizada*\n");
				break;

			case 3:
				System.out.println("Informe o ID do cliente: ");
				int id = sc.nextInt();
				System.out.println();
				cfDAO.removeById(id);
				
				break;

			case 4:
				System.out.println("**** Atualizando Cadastro de Cliente Físico ****");
				System.out.println("Informe o ID do cliente:");
				int idClienteFisico = sc.nextInt();
				System.out.println("Digite o novo CPF do cliente:");
				String cpf = sc.next();
				System.out.println("Digite o novo RG do cliente:");
				String rg = sc.next();
				System.out.println("Digite o novo nome: ");
				String nome = sc.next();
				System.out.println("Digite o novo email:");
				String email = sc.next();
				System.out.println("Digite a nova rua: ");
				String rua = sc.next();
				System.out.println("Digite o novo número da casa: ");
				String numero = sc.next();
				System.out.println("Digite a nova cidade: ");
				String cidade = sc.next();
				System.out.println("Digite o novo Estado: ");
				String estado = sc.next();
				System.out.println("Digite o novo complemento: ");
				String complemento = sc.next();
				System.out.println("Digite o novo CEP: ");
				String cep = sc.next();
				System.out.println("Digite o novo telefone");
				String telefone = sc.next();
				
				ClienteFisico cf1 = new ClienteFisico(idClienteFisico,cpf,rg,nome,email,rua,numero,cidade,estado,complemento,cep,telefone);
				cfDAO.update(cf1);
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
