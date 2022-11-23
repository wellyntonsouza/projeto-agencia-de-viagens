package model.crud;

import java.util.Scanner;

import model.ClienteJuridico;
import model.dao.ClienteJuridicoDAO;

public class ClienteJuridicoCRUD {

	public static void main(String[] args) {
		ClienteJuridicoDAO cjDAO = new ClienteJuridicoDAO();
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
				ClienteJuridico cj = new ClienteJuridico();
				System.out.println("****Cadastrar Cliente Jurídico****");
				System.out.println("Digite ID: ");
				cj.setIdClienteJuridico(sc.nextInt());
				System.out.println("Digite CNPJ:");
				cj.setCnpj(sc.next());
				System.out.println("Digite o nome:");
				cj.setNome(sc.next());
				System.out.println("Digite a rua:");
				cj.setRua(sc.next());
				cj.setRua(sc.next());
				System.out.println("Digite o número da casa:");
				cj.setNumero(sc.next());
				System.out.println("Digite a cidade:");
				cj.setCidade(sc.next());
				System.out.println("Digite o estado:");
				cj.setEstado(sc.next());
				System.out.println("Digite o complemento:");
				cj.setComplemento(sc.next());
				System.out.println("Digite o cep:");
				cj.setCep(sc.next());
				System.out.println("Digite o telefone:");
				cj.setTelefone(sc.next());

				cjDAO.save(cj);
				System.out.println("***\nCadastrado***\n");
				break;

			case 2:
				for (ClienteJuridico cj1 : cjDAO.getClienteJuridico()) {
					System.out.println("ID: " + cj1.getIdClienteJuridico() + " | Nome: " + cj1.getNome() + " | CNPJ: "
							+ cj1.getCnpj() +" | Telefone: "+ cj1.getTelefone() + " | Endereço: " + cj1.getRua() + ", " + cj1.getNumero() + ", "
							+ cj1.getCidade() + ", " + cj1.getEstado() + ", " + cj1.getComplemento() + ", "
							+ cj1.getCep());
				}
				System.out.println("\n*Consulta Finalizada*\n");
				break;

			case 3:
				System.out.println("Informe o ID do cliente: ");
				int id = sc.nextInt();
				System.out.println();
				cjDAO.removeById(id);
				
				break;

			case 4:
				System.out.println("**** Atualizando Cadastro de Cliente Físico ****");
				System.out.println("Informe o ID do cliente:");
				int idClienteJuridico = sc.nextInt();
				System.out.println("Digite o novo CNPJ do cliente:");
				String cnpj = sc.next();
				System.out.println("Digite o novo nome: ");
				String nome = sc.next();
				System.out.println("Digite a nova rua da sede da empresa: ");
				String rua = sc.next();
				System.out.println("Digite o novo número: ");
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
				
				ClienteJuridico cf = new ClienteJuridico(idClienteJuridico,cnpj, nome, rua, numero, cidade, estado, complemento, cep, telefone);
				cjDAO.update(cf);
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
