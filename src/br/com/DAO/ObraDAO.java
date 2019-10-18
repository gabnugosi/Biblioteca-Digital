package br.com.DAO;

import br.com.model.Obra;

//https://www.devmedia.com.br/implementando-o-data-access-object-no-java-ee/33339
public class ObraDAO {
	public static List<Obra> listaObra = null;
	
	public ObraDAO() {
		
		List<Obra> res= new ArrayList();
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
 