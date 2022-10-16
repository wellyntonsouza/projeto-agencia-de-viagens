package model;

import java.util.ArrayList;
import java.util.List;

public class ClienteFisico extends Cliente {
	private int idClienteFisico;
	private String cpf;
	private String rg;
	private String email;

	private List<ClienteFisico> clientesFisicos = new ArrayList<ClienteFisico>();

	// construtores
	public ClienteFisico() {
	}

	public ClienteFisico(String nome, String rua, String numero, String cidade, String estado, String cep,
			String complemento, String telefone, int idClienteFisico, String cpf, String rg, String email) {
		super(nome, rua, numero, cidade, estado, cep, complemento, telefone);
	}
	
	public ClienteFisico(int idClienteFisico, String cpf, String rg, String nome, String email, String rua, String numero, String cidade, String estado, String cep,
			String complemento, String telefone ) {
		
	}
	// getters and setters
	public int getIdClienteFisico() {
		return idClienteFisico;
	}

	public void setIdClienteFisico(int idClienteFisico) {
		this.idClienteFisico = idClienteFisico;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public String getRg() {
		return rg;
	}

	public void setRg(String rg) {
		this.rg = rg;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

}
