package model.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import model.Viagem;
import model.factory.ConnectionMySQL;

public class ViagemDAO {
	
	public void save(Viagem viagem) {
		// CRIAÇÃO DA QUERY
		String sql = "INSERT INTO VIAGEM (IDVIAGEM, IDCLIENTEJURIDICO, PARTIDA, DESTINO, VALOR, DATA)"
				+ " VALUES(?,?,?,?,?,?)";

		// FAZER CONEXÃO
		Connection conn = null;
		PreparedStatement pstm = null;

		try {
			// cria conexao com o banco
			conn = ConnectionMySQL.createConnectionToMySQL();

			// cria um preparedStatement, classe usada para executar a query
			pstm = conn.prepareStatement(sql);

			// adiciona o valor do primeiro paramentro da sql
			pstm.setInt(1, viagem.getIdViagem());
			// adiciona o valor do segundo parametro da sql
			pstm.setInt(2, viagem.getIdClienteJuridico());
			pstm.setString(3, viagem.getPartida());
			pstm.setString(4, viagem.getDestino());
			pstm.setBigDecimal(5, viagem.getValor());
			pstm.setDate(6, (Date) viagem.getData());
	
			// execução
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

			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

	// READ
	public List<Viagem> getPedido() {
		// QUERY
		String sql = "SELECT * FROM VIAGEM";

		// Lista
		List<Viagem> viagens = new ArrayList<Viagem>();

		Connection conn = null;
		PreparedStatement pstm = null;

		// Recuperação dados do banco
		ResultSet rset = null;

		try {
			// executa a conexao com o banco
			conn = ConnectionMySQL.createConnectionToMySQL();

			// executa a query
			pstm = conn.prepareStatement(sql);

			// captura o que foi executado no pstm
			rset = pstm.executeQuery();

			while (rset.next()) {
				Viagem viagem = new Viagem();

				viagem.setIdViagem(rset.getInt("IDVIAGEM"));
				viagem.setIdClienteJuridico(rset.getInt("IDCLIENTEJURIDICO"));
				viagem.setPartida(rset.getString("PARTIDA"));
				viagem.setDestino(rset.getString("DESTINO"));
				viagem.setValor(rset.getBigDecimal("VALOR"));
				viagem.setData(rset.getDate("DATA"));
				
				viagens.add(viagem);
			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (rset != null) {
					rset.close();
				}
				if (pstm != null) {
					pstm.close();
				}
				if (conn != null) {
					conn.close();
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}

		return viagens;

	}

	// DELETE
	public void removeById(int idViagem) {
		String sql = "DELETE FROM VIAGEM WHERE IDVIAGEM = ?";
		Connection conn = null;
		PreparedStatement pstm = null;

		try {
			conn = ConnectionMySQL.createConnectionToMySQL();
			pstm = conn.prepareStatement(sql);
			pstm.setInt(1, idViagem);
			pstm.execute();
		} catch (Exception e) {
			// TODO AUTO-GENERATED CATCH BLOCK
			e.printStackTrace();
		} finally {
			try {
				if (pstm != null) {
					pstm.close();
				}
				if (conn != null) {
					conn.close();
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

	// UPDATE
	public void update(Viagem viagem) {
		String sql = "UPDATE VIAGEM SET IDCLIENTEJURIDICO = ?, PARTIDA = ?, DESTINO = ?, VALOR = ?, DATA = ? "+" WHERE IDVIAGEM = ?";

		Connection conn = null;
		PreparedStatement pstm = null;

		try {
			// cria conexao com banco
			conn = ConnectionMySQL.createConnectionToMySQL();
			// cria pstm, classe usada p executar a query
			pstm = conn.prepareStatement(sql);

			// adicionar valores para atualizar
			pstm.setInt(1, viagem.getIdClienteJuridico());
			pstm.setString(2, viagem.getPartida());
			pstm.setString(3, viagem.getDestino());
			pstm.setBigDecimal(4, viagem.getValor());
			pstm.setDate(5, (Date) viagem.getData());

			pstm.setInt(6, viagem.getIdViagem());

			// execução sql p/atualização
			pstm.execute();

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			// fecha as conexoes
			try {
				if (pstm != null) {
					pstm.close();
				}
				if (conn != null) {
					conn.close();
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

}
