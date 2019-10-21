package br.com.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.conexao.Conexao;
import br.com.exception.DAOException;
import br.com.model.Obra;
import br.com.DAO.*;


//https://www.devmedia.com.br/implementando-o-data-access-object-no-java-ee/33339
public class ObraDAO {
	//public static List<Obra> listaObra = null;
	
	public void inserir (Obra obra) throws DAOException {
		Connection connection = Conexao.getConnection();
		PreparedStatement pstm; 
		String query = "insert into obra (nome, edicao, tombo, ano) values (?, ?, ?, ?)";
		
		try {
			pstm = connection.prepareStatement(query);
			pstm.setString(1, obra.getNome());
			pstm.setInt(2, obra.getEdicao());
			pstm.setString(3, obra.getTombo());
			pstm.setString(4, obra.getAno());
			pstm.execute();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	//listar verificar de acordo com o reservaDAO
	public ObraDAO() {
		/*
		private List<Obra> obras= new ArrayList<>();
        private Connection conn= null;
        private PreparedStatement pstmt= null;
        private ResultSet rs= null;
        
        try {
            conn= createConnection();
            pstmt= conn.prepareStatement(Queries.SELECT_ALL);
            rs= pstmt.executeQuery();
 
            while(rs.next()){
            	obras.add(
                    new Caterer(rs.getLong("id"), rs.getString("name"))
                );
            }
 
        } catch (Exception e) {
            throw new RuntimeException(e);
 
        } finally {
            try {
                if(rs!=null) rs.close();
                if(pstmt!=null) pstmt.close();
                if(conn!=null) conn.close();
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        }
        return obras;    */
	        
	}
}
	
	

/* http://www.codepianist.com/java/jdbc-listar-registros-banco-de-dados-com-java/
 * 
 * public class CatererDao extends Dao{
 
    //
 
    private static final String SERVER= "localhost";
    private static final String DB= "jdbc_test";
    
    private static interface Queries{
        String SELECT_ALL= "select * from caterers";
    }
 
 
    //
 
    public List<Caterer> list(){
        List<Caterer> res= new ArrayList();
        Connection conn= null;
        PreparedStatement pstmt= null;
        ResultSet rs= null;
        try {
            conn= createConnection();
            pstmt= conn.prepareStatement(Queries.SELECT_ALL);
            rs= pstmt.executeQuery();
 
            while(rs.next()){
                res.add(
                    new Caterer(rs.getLong("id"), rs.getString("name"))
                );
            }
 
        } catch (Exception e) {
            throw new RuntimeException(e);
 
        } finally {
            try {
                if(rs!=null) rs.close();
                if(pstmt!=null) pstmt.close();
                if(conn!=null) conn.close();
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        }
        return res;
 
    }
 
 
    //
 
    private Connection createConnection(){
        return getConnectionFactory().createConnection(SERVER, DB);
 
    }
 
 
}
 * */
 