package model;

public class ClienteJuridico extends Cliente{
		private int idClienteJuridico;
		private String cnpj;
		
		//Construtores
		public ClienteJuridico() {
			
		}
		
		public ClienteJuridico(String nome, String rua, String numero, String cidade, String estado, String cep, String complemento,
				String telefone, int idClienteJuridico, String cnpj) {
			super(nome, rua, numero, cidade, estado, cep, complemento, telefone);
		}
		
		public ClienteJuridico(int idClienteJuridico, String cnpj,String nome, String rua, String numero, String cidade, String estado, String cep, String complemento,
				String telefone) {
			
		}

		//getters and setters		
		public int getIdClienteJuridico() {
			return idClienteJuridico;
		}

		public void setIdClienteJuridico(int idClienteJuridico) {
			this.idClienteJuridico = idClienteJuridico;
		}

		public String getCnpj() {
			return cnpj;
		}

		public void setCnpj(String cnpj) {
			this.cnpj = cnpj;
		}
}
