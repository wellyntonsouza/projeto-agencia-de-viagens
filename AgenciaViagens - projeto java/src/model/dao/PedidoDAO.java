package model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import model.Pedido;
import model.factory.ConnectionMySQL;

public class PedidoDAO {

	public void save(Pedido pedido) {
		// CRIAÇÃO DA QUERY
		String sql = "INSERT INTO PEDIDO (IDPEDIDO, IDCLIENTEFISICO, IDVIAGEM, CPFPASSAGEIRO, NOMEPASSAGEIRO, RGPASSAGEIRO, QUANTIDADE)"
				+ " VALUES(?,?,?,?,?,?,?)";

		// FAZER CONEXÃO
		Connection conn = null;
		PreparedStatement pstm = null;

		try {
			// cria conexao com o banco
			conn = ConnectionMySQL.createConnectionToMySQL();

			// cria um preparedStatement, classe usada para executar a query
			pstm = conn.prepareStatement(sql);

			// adiciona o valor do primeiro paramentro da sql
			pstm.setInt(1, pedido.getIdPedido());
			// adiciona o valor do segundo parametro da sql
			pstm.setInt(2, pedido.getIdClienteFisico());
			pstm.setInt(3, pedido.getIdViagem());
			pstm.setString(4, pedido.getCpfPassageiro());
			pstm.setString(5, pedido.getNomePassageiro());
			pstm.setString(6, pedido.getRgPassageiro());
			pstm.setInt(7, pedido.getQuantidade());

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
	public List<Pedido> getPedido() {
		// QUERY
		String sql = "SELECT * FROM PEDIDO";

		// Lista
		List<Pedido> pedidos = new ArrayList<Pedido>();

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
				Pedido pedido = new Pedido();

				pedido.setIdPedido(rset.getInt("IDPEDIDO"));
				pedido.setIdClienteFisico(rset.getInt("IDCLIENTEFISICO"));
				pedido.setIdViagem(rset.getInt("IDVIAGEM"));
				pedido.setCpfPassageiro(rset.getString("CPFPASSAGEIRO"));
				pedido.setNomePassageiro(rset.getString("NOMEPASSAGEIRO"));
				pedido.setRgPassageiro(rset.getString("RGPASSAGEIRO"));
				pedido.setQuantidade(rset.getInt("QUANTIDADE"));

				pedidos.add(pedido);
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

		return pedidos;

	}

	// DELETE
	public void removeById(int idPedido) {
		String sql = "DELETE FROM PEDIDO WHERE IDPEDIDO = ?";
		Connection conn = null;
		PreparedStatement pstm = null;

		try {
			conn = ConnectionMySQL.createConnectionToMySQL();
			pstm = conn.prepareStatement(sql);
			pstm.setInt(1, idPedido);
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
	public void update(Pedido pedido) {
		String sql = "UPDATE PEDIDO SET IDCLIENTEFISICO = ?, IDVIAGEM = ?, CPFPASSAGEIRO = ?, NOMEPASSAGEIRO = ?, RGPASSAGEIRO = ?, QUANTIDADE = ? "
				+ " WHERE IDPEDIDO = ?";

		Connection conn = null;
		PreparedStatement pstm = null;

		try {
			// cria conexao com banco
			conn = ConnectionMySQL.createConnectionToMySQL();
			// cria pstm, classe usada p executar a query
			pstm = conn.prepareStatement(sql);

			// adicionar valores para atualizar
			pstm.setInt(1, pedido.getIdClienteFisico());
			pstm.setInt(2, pedido.getIdViagem());
			pstm.setString(3, pedido.getCpfPassageiro());
			pstm.setString(4, pedido.getNomePassageiro());
			pstm.setString(5, pedido.getRgPassageiro());
			pstm.setInt(6, pedido.getQuantidade());

			pstm.setInt(7, pedido.getIdPedido());

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
