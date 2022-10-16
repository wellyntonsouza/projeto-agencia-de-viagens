package model;

public class Pedido {
	private int idPedido;
	private int idClienteFisico;
	private int idViagem;
	private String cpfPassageiro;
	private String nomePassageiro;
	private String rgPassageiro;
	private int quantidade;
	
	
	//constructors
	public Pedido() {
		
	}
	
	public Pedido(int idPedido, int idClienteFisico, int idViagem, String cpfPassageiro, String nomePassageiro, String rgPassageiro, int quantidade) {
		super();
		this.idPedido = idPedido;
		this.idClienteFisico = idClienteFisico;
		this.idViagem = idViagem;
		this.cpfPassageiro = cpfPassageiro;
		this.nomePassageiro = nomePassageiro;
		this.rgPassageiro = rgPassageiro;
		this.quantidade = quantidade;
	}
	
	//getters and setters

	public int getIdPedido() {
		return idPedido;
	}

	public void setIdPedido(int idPedido) {
		this.idPedido = idPedido;
	}

	public int getQuantidade() {
		return quantidade;
	}

	public void setQuantidade(int quantidade) {
		this.quantidade = quantidade;
	}

	public String getNomePassageiro() {
		return nomePassageiro;
	}

	public void setNomePassageiro(String nomePassageiro) {
		this.nomePassageiro = nomePassageiro;
	}

	public String getCpfPassageiro() {
		return cpfPassageiro;
	}

	public void setCpfPassageiro(String cpfPassageiro) {
		this.cpfPassageiro = cpfPassageiro;
	}

	public String getRgPassageiro() {
		return rgPassageiro;
	}

	public void setRgPassageiro(String rgPassageiro) {
		this.rgPassageiro = rgPassageiro;
	}

	public int getIdClienteFisico() {
		return idClienteFisico;
	}

	public void setIdClienteFisico(int idClienteFisico) {
		this.idClienteFisico = idClienteFisico;
	}

	public int getIdViagem() {
		return idViagem;
	}

	public void setIdViagem(int idViagem) {
		this.idViagem = idViagem;
	}
	
	
}
