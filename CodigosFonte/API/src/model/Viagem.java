package model;

import java.math.BigDecimal;
import java.util.Date;

public class Viagem {
	private int idViagem;
	private int idClienteJuridico;
	private String partida;
	private String destino;
	private BigDecimal valor;
	private Date data;
	
	
	//constructors
	public Viagem() {
		
	}
		
	public Viagem(int idViagem, int idClienteJuridico, String partida, String destino, BigDecimal valor, Date data) {
		super();
		this.idViagem = idViagem;
		this.idClienteJuridico = idClienteJuridico;
		this.partida = partida;
		this.destino = destino;
		this.valor = valor;
		this.data = data;
	}
	
	
	//getters and setters
	public int getIdViagem() {
		return idViagem;
	}
	
	public void setIdViagem(int idViagem) {
		this.idViagem = idViagem;
	}
	
	public String getPartida() {
		return partida;
	}
	
	public void setPartida(String partida) {
		this.partida = partida;
	}
	
	public String getDestino() {
		return destino;
	}
	
	public void setDestino(String destino) {
		this.destino = destino;
	}
	
	public BigDecimal getValor() {
		return valor;
	}
	
	public void setValor(BigDecimal valor) {
		this.valor = valor;
	}
	
	public Date getData() {
		return data;
	}
	
	public void setData(Date data) {
		this.data = data;
	}

	public int getIdClienteJuridico() {
		return idClienteJuridico;
	}

	public void setIdClienteJuridico(int idClienteJuridico) {
		this.idClienteJuridico = idClienteJuridico;
	}
	
}
