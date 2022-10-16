package model.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import model.ClienteFisico;
import model.factory.ConnectionMySQL;

public class ClienteFisicoDAO {
	public void save(ClienteFisico clienteFisico) {
	//CRIAÇÃO DA QUERY
	String sql = "INSERT INTO ClienteFisico (IDCLIENTEFISICO, CPF, RG, NOME, EMAIL, RUA, NUMERO, CIDADE, ESTADO, COMPLEMENTO, CEP, TELEFONE)" + " VALUES(?,?,?,?,?,?,?,?,?,?,?,?)";

	//FAZER CONEXÃO
	Connection conn = null;
	PreparedStatement pstm = null;
	
	try {
		//cria conexao com o banco
		conn = ConnectionMySQL.createConnectionToMySQL();
		
		//cria  um preparedStatement, classe usada para executar a query
		pstm = conn.prepareStatement(sql);
		
		//adiciona o valor do primeiro paramentro da sql
		pstm.setInt(1, clienteFisico.getIdClienteFisico());
		//adiciona o valor do segundo parametro da sql
		pstm.setString(2, clienteFisico.getCpf());
		pstm.setString(3, clienteFisico.getRg());
		pstm.setString(4, clienteFisico.getNome());
		pstm.setString(5, clienteFisico.getEmail());
		pstm.setString(6, clienteFisico.getRua());
		pstm.setString(7, clienteFisico.getNumero());
		pstm.setString(8, clienteFisico.getCidade());
		pstm.setString(9, clienteFisico.getEstado());
		pstm.setString(10, clienteFisico.getComplemento());
		pstm.setString(11, clienteFisico.getCep());
		pstm.setString(12, clienteFisico.getTelefone());
		
		//execução
		pstm.execute();
	} catch (Exception e) {
		e.printStackTrace();
	} finally {
		try {
			if (pstm != null) {
				pstm.close();
			}
			if (conn != null) {
				conn.close();
			}
		
	} catch (Exception e){ 
			e.printStackTrace();		
			}
	}
}
	
	//READ
	public List<ClienteFisico> getClienteFisico(){
		//QUERY
		String sql = "SELECT * FROM ClienteFisico";
		
		//Lista
		List<ClienteFisico> clientesFisicos = new ArrayList<ClienteFisico>();
		
		Connection conn= null;
		PreparedStatement pstm = null;
		
		//Recuperação dados do banco
		ResultSet rset = null;
		
		try {
			//executa a conexao com o banco
			conn = ConnectionMySQL.createConnectionToMySQL();
			
			//executa a query
			pstm = conn.prepareStatement(sql);
			
			//captura o que foi executado no pstm
			rset = pstm.executeQuery(); 
			
			while(rset.next()) {
				ClienteFisico clienteFisico = new ClienteFisico();
				
				clienteFisico.setIdClienteFisico(rset.getInt("IDCLIENTEFISICO"));
				clienteFisico.setCpf(rset.getString("CPF"));
				clienteFisico.setRg(rset.getString("RG"));
				clienteFisico.setNome(rset.getString("NOME"));
				clienteFisico.setEmail(rset.getString("EMAIL"));
				clienteFisico.setRua(rset.getString("RUA"));
				clienteFisico.setNumero(rset.getString("NUMERO"));
				clienteFisico.setCidade(rset.getString("CIDADE"));
				clienteFisico.setEstado(rset.getString("ESTADO"));
				clienteFisico.setComplemento(rset.getString("COMPLEMENTO"));
				clienteFisico.setCep(rset.getString("CEP"));
				clienteFisico.setTelefone(rset.getString("TELEFONE"));
				
				clientesFisicos.add(clienteFisico);
			}
			
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			try {
				if(rset != null) {
					rset.close();
				}
				if(pstm != null) {
					pstm.close();
				}
				if(conn != null) {
					conn.close();
				}
			}catch(Exception e) {
				e.printStackTrace();
			}
		}
		
		return clientesFisicos;
		
	}
	
	//DELETE
	public void removeById(int idClienteFisico) {
		String sql  = "DELETE FROM CLIENTEFISICO WHERE IDCLIENTEFISICO = ?";
		Connection conn = null;
		PreparedStatement pstm = null;
		
		try {
			conn = ConnectionMySQL.createConnectionToMySQL();
			pstm = conn.prepareStatement(sql);
			pstm.setInt(1, idClienteFisico);
			pstm.execute();
		} catch (Exception e) {
			//TODO AUTO-GENERATED CATCH BLOCK
			e.printStackTrace();
		} finally {
			try {
				if(pstm != null) {
					pstm.close();
				}
				if(conn != null) {
					conn.close();
				}
			} catch(Exception e) {
				e.printStackTrace();
			}
		}
	}
	
	//UPDATE
	public void update(ClienteFisico clienteFisico) {
		String sql = "UPDATE CLIENTEFISICO SET CPF = ?, RG = ?, NOME = ?, EMAIL = ?, RUA = ?, NUMERO = ?, CIDADE = ?, ESTADO = ?, COMPLEMENTO = ?, CEP = ?, TELEFONE = ? "+" WHERE IDCLIENTEFISICO = ?";
		
		Connection conn = null;
		PreparedStatement pstm = null;
		
		try {
			//cria conexao com banco
			conn  = ConnectionMySQL.createConnectionToMySQL();
			//cria pstm, classe usada p executar a query
			pstm = conn.prepareStatement(sql);
			
			//adicionar valores para atualizar
			pstm.setString(1, clienteFisico.getCpf());
			pstm.setString(2, clienteFisico.getRg());
			pstm.setString(3, clienteFisico.getNome());
			pstm.setString(4, clienteFisico.getEmail());
			pstm.setString(5, clienteFisico.getRua());
			pstm.setString(6, clienteFisico.getNumero());
			pstm.setString(7, clienteFisico.getCidade());
			pstm.setString(8, clienteFisico.getEstado());
			pstm.setString(9, clienteFisico.getComplemento());
			pstm.setString(10, clienteFisico.getCep());
			pstm.setString(11, clienteFisico.getTelefone());
			
			pstm.setInt(12, clienteFisico.getIdClienteFisico());
			
			//execução sql p/atualização
			pstm.execute();
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally{
			//fecha as conexoes
			try {
				if(pstm != null) {
					pstm.close();
				}
				if(conn != null) {
					conn.close();
				}
			}catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
}