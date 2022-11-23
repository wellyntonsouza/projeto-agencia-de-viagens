package model.factory;

import java.sql.Connection;
import java.sql.DriverManager;

public class ConnectionMySQL {

		//nome do usuário do mysql
		private static final String USERNAME = "root";
		//senha do mysql
		private static final String PASSWORD = "Wsods1999!";
		//dados de CAMINHO, PORTA e NOME do DB que sera conectado
		private static final String DATABASE_URL = "jdbc:mysql://localhost:3306/AgenciaViagensDB";

		/**
		Cria uma conexao com DBA MySQL usando o nome de usuario e senha
		@param username
		@param senha
		@return uma conexao com o bd
		@throws Exeption
	 */
		public static Connection createConnectionToMySQL() throws Exception{
			
			//carrega classe pelo JVM
			Class.forName("com.mysql.cj.jdbc.Driver"); 
			//cria conexao com o banco
			Connection connection = DriverManager.getConnection(DATABASE_URL, USERNAME, PASSWORD);
			return connection;
		}
		
		public static void main(String[] args) throws Exception{
			//recupera uma conexao com o DB
			Connection con = createConnectionToMySQL();
			
			//Testa se a conexão é nula
			if (con != null) {
				System.out.println("Conexão obtida com sucesso! || "+con);
				con.close();
			}
		}
	}
