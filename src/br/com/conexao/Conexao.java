package br.com.conexao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import br.com.exception.DAOException;

public class Conexao {
	
	private static final String driver = "jdbc:sqlserver://localhost:1433;";
	private static final String database = "databaseName=BDIGITAL_201902";
	private static final String connectionUrl = driver + database;
	private static final String user = "sa"; 
	private static final String pass = "123456"; 
	private static String mensagem; 
	
	/*
	 * Configuração da conexão para a base de dados na ETEC
	 * user = bdigital
	 * pass = bd1g1t
	 * */
	
	
	public static Connection getConnection() throws DAOException{
	
				try {
					
					mensagem = "Conexão com o banco de dados obtida com sucesso.";
					Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver").newInstance();

					Connection connection = DriverManager.getConnection(connectionUrl, user, pass);
					connection.setAutoCommit(false);
					
					System.out.println(mensagem);								
					return connection;
					
				} catch (SQLException ex) {
					mensagem = "Driver (JDBC) não encontrado";
					
					System.out.println("SQLException: " + ex.getMessage());
					System.out.println("SQLState" + ex.getSQLState());
					System.out.println("VendorError: " + ex.getErrorCode());
					
					throw new DAOException(mensagem, ex);
					
				} catch (Exception e) {
					mensagem = "Não foi possível conectar ao banco: ";
					//System.out.println("Não foi possível conectar ao banco: " + e);
					throw new DAOException(mensagem, e);
				}
			}
			public static void closeConnection(Connection connection) throws DAOException{
				mensagem =  "Conexão com o banco de dados fechada com sucesso.";
				
				try {
					if (connection != null) {
						connection.close();
						System.out.println(mensagem);		
					}
				} catch (Exception e) {
					mensagem = "Houve um erro ao fechar a conexão com o banco de dados.";
					
					throw new DAOException(mensagem, e);
				}
			}
			
			public static void closeConnectionAndStatement(Connection connection, PreparedStatement pstm) throws DAOException {
				
				String mensagem =  "Não foi possível fechar o ResultSet.";
				
				if (null != connection) {
					closeConnection(connection);
				}
				
				try {
					if (null != pstm) {
						pstm.close();
					}
				} catch (Exception e) {
					mensagem = "Houve um erro ao fechar a instrução de banco de dados.";
					
					throw new DAOException(mensagem, e);
				}
			}
			
			public static void closeAll(Connection connection, Statement statement, ResultSet resultset) throws DAOException {
				
				String mensagem =  "Conjunto de resultados do banco de dados fechado com sucesso.";
				
				closeConnectionAndStatement(connection, statement);
				
				try {
					if (null != resultset) {
						resultset.close();
					}
				} catch (Exception e) {
					mensagem = "Houve um erro ao fechar o conjunto de resultados do banco de dados.";
					
					throw new DAOException(mensagem, e);
				}
			}
}
