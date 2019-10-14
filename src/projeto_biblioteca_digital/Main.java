package projeto_biblioteca_digital;

import java.sql.*;

public class Main {

	public static void main(String[] args) {
		String connectionUrl = "jdbc:sqlserver://localhost:1433;" + "databaseName=BDIGITAL_201902";
		
		try {
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver").newInstance();

			Connection connection = DriverManager.getConnection(connectionUrl, "sa", "123456");
			/*Configuração da conexão para a base de dados na ETEC*/
			//Connection connection = DriverManager.getConnection(connectionUrl, "bdigital", "bd1g1t@l");

			System.out.println("Conexão obtida com sucesso!!");

		} catch (SQLException ex) {
			System.out.println("SQLException: " + ex.getMessage());
			System.out.println("SQLState" + ex.getSQLState());
			System.out.println("VendorError: " + ex.getErrorCode());
		} catch (Exception e) {
			System.out.println("Não foi possível conectar ao banco: " + e);
		}

	}

}
