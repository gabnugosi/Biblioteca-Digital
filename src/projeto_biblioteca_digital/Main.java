package projeto_biblioteca_digital;

import java.sql.*;

public class Main {

	public static void main(String[] args) {
		String connectionUrl = "jdbc:sqlserver://localhost:1433;" + "databaseName=BDIGITAL_201902";
		
		try {
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver").newInstance();

			Connection connection = DriverManager.getConnection(connectionUrl, "sa", "123456");
			/*Configura��o da conex�o para a base de dados na ETEC*/
			//Connection connection = DriverManager.getConnection(connectionUrl, "bdigital", "bd1g1t@l");

			System.out.println("Conex�o obtida com sucesso!!");

		} catch (SQLException ex) {
			System.out.println("SQLException: " + ex.getMessage());
			System.out.println("SQLState" + ex.getSQLState());
			System.out.println("VendorError: " + ex.getErrorCode());
		} catch (Exception e) {
			System.out.println("N�o foi poss�vel conectar ao banco: " + e);
		}

	}

}
