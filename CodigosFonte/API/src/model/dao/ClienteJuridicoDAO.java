package model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import model.ClienteJuridico;
import model.factory.ConnectionMySQL;

public class ClienteJuridicoDAO {

	public void save(ClienteJuridico clienteJuridico) {
		// CRIAÇÃO DA QUERY
		String sql = "INSERT INTO ClienteJuridico (IDCLIENTEJURIDICO, CNPJ, NOME, RUA, NUMERO, CIDADE, ESTADO, COMPLEMENTO, CEP, TELEFONE)"
				+ " VALUES(?,?,?,?,?,?,?,?,?,?)";

		// FAZER CONEXÃO
		Connection conn = null;
		PreparedStatement pstm = null;

		try {
			// cria conexao com o banco
			conn = ConnectionMySQL.createConnectionToMySQL();

			// cria um preparedStatement, classe usada para executar a query
			pstm = conn.prepareStatement(sql);

			// adiciona o valor do primeiro paramentro da sql
			pstm.setInt(1, clienteJuridico.getIdClienteJuridico());
			// adiciona o valor do segundo parametro da sql
			pstm.setString(2, clienteJuridico.getCnpj());
			pstm.setString(3, clienteJuridico.getNome());
			pstm.setString(4, clienteJuridico.getRua());
			pstm.setString(5, clienteJuridico.getNumero());
			pstm.setString(6, clienteJuridico.getCidade());
			pstm.setString(7, clienteJuridico.getEstado());
			pstm.setString(8, clienteJuridico.getComplemento());
			pstm.setString(9, clienteJuridico.getCep());
			pstm.setString(10, clienteJuridico.getTelefone());

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
	public List<ClienteJuridico> getClienteJuridico() {
		// QUERY
		String sql = "SELECT * FROM ClienteJuridico";

		// Lista
		List<ClienteJuridico> clientesJuridicos = new ArrayList<ClienteJuridico>();

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
				ClienteJuridico cj = new ClienteJuridico();

				cj.setIdClienteJuridico(rset.getInt("IDCLIENTEJURIDICO"));
				cj.setCnpj(rset.getString("CNPJ"));
				cj.setNome(rset.getString("NOME"));
				cj.setRua(rset.getString("RUA"));
				cj.setNumero(rset.getString("NUMERO"));
				cj.setCidade(rset.getString("CIDADE"));
				cj.setEstado(rset.getString("ESTADO"));
				cj.setComplemento(rset.getString("COMPLEMENTO"));
				cj.setCep(rset.getString("CEP"));
				cj.setTelefone(rset.getString("TELEFONE"));

				clientesJuridicos.add(cj);
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

		return clientesJuridicos;

	}

	// DELETE
	public void removeById(int idClienteJuridico) {
		String sql = "DELETE FROM CLIENTEJURIDICO WHERE IDCLIENTEJURIDICO = ?";
		Connection conn = null;
		PreparedStatement pstm = null;

		try {
			conn = ConnectionMySQL.createConnectionToMySQL();
			pstm = conn.prepareStatement(sql);
			pstm.setInt(1, idClienteJuridico);
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
	public void update(ClienteJuridico clienteJuridico) {
		String sql = "UPDATE CLIENTEJURIDICO SET CNPJ = ?, NOME = ?, RUA = ?, NUMERO = ?, CIDADE = ?, ESTADO = ?, COMPLEMENTO = ?, CEP = ?, TELEFONE = ? "
				+ " WHERE IDCLIENTEJURIDICO = ?";

		Connection conn = null;
		PreparedStatement pstm = null;

		try {
			// cria conexao com banco
			conn = ConnectionMySQL.createConnectionToMySQL();
			// cria pstm, classe usada p executar a query
			pstm = conn.prepareStatement(sql);

			// adicionar valores para atualizar
			pstm.setString(1, clienteJuridico.getCnpj());
			pstm.setString(2, clienteJuridico.getNome());
			pstm.setString(3, clienteJuridico.getRua());
			pstm.setString(4, clienteJuridico.getNumero());
			pstm.setString(5, clienteJuridico.getCidade());
			pstm.setString(6, clienteJuridico.getEstado());
			pstm.setString(7, clienteJuridico.getComplemento());
			pstm.setString(8, clienteJuridico.getCep());
			pstm.setString(9, clienteJuridico.getTelefone());

			pstm.setInt(10, clienteJuridico.getIdClienteJuridico());

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
