package br.com.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.conexao.Conexao;
import br.com.exception.DAOException;
import br.com.model.Reserva;

public class ReservaDAO {
	private String query;
	PreparedStatement pstm; 
	
	public void inserir (Reserva reserva) throws DAOException {
		Connection connection = Conexao.getConnection();
		query = "insert into reserva (dt_hora_reserva, prazo_reserva, situacao_reserva, id_usu,  id_obra) values (?, ?, ?, ?, ?)";
		
		try {
			pstm = connection.prepareStatement(query);
			pstm.setDate(1, reserva.getDtHoraReserva());
			pstm.setInt(2, reserva.getPrazoReserva());
			pstm.setString(3, reserva.getSituacaoReserva());
			pstm.setInt(4, reserva.getIdUser());
			pstm.setInt(5, reserva.getIdObra());
			
			pstm.execute();
			
			
			//método para gerar alert de inserção bem sucedida
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			// método para alert de erro
			e.printStackTrace();
		}finally {
			Conexao.closeConnection(connection);
		}
	}
	/*
	 * alterarSituacaoReserva método que faz update situacao_reserva
	 * */
	public void alterarSituacaoReserva(Reserva reserva) throws DAOException {
		Connection connection = Conexao.getConnection();
		query= "update reserva set situacao_reserva = ? where id_reserva = ? "; 
		
		try {
			pstm = connection.prepareStatement(query);
			pstm.setString(1, reserva.getSituacaoReserva());
			pstm.setInt(2, reserva.getId());
			
			pstm.execute();
			
			//método para gerar alert de inserção bem sucedida
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			// método para alert de erro
			e.printStackTrace();
		}finally {
			Conexao.closeConnection(connection);
		}
	}
	
	public void deteteReserva(Reserva reserva) throws DAOException{
		Connection connection = Conexao.getConnection();
		query= "delete from reserva where id_reserva = ? "; 
		
		try {
			pstm = connection.prepareStatement(query);
			pstm.setString(1, reserva.getSituacaoReserva());			
			
			pstm.execute();
			
			//método para gerar alert de inserção bem sucedida
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			// método para alert de erro
			e.printStackTrace();
		}finally {
			Conexao.closeConnection(connection);
		}
	}
	
	public List<Reserva> listarReserva() throws DAOException{
		List<Reserva> reservas = new ArrayList<>();
		ResultSet rs; 
		
		Connection connection = Conexao.getConnection();		
		query= "select * from reserva";
		
		try {
			pstm = connection.prepareStatement(query);
			rs = pstm.executeQuery();
			
			while(rs.next()) {
				Reserva reserva = new Reserva();
				reserva.setIdObra(rs.getInt(1));//tb é possível usar o nome do campo da tabela, ou seja, uma string "id_reserva" por exemplo
				reserva.setDtHoraReserva(rs.getDate(2));
				reserva.setPrazoReserva(rs.getInt(3));
				reserva.setIdUser(rs.getInt(4));
				
				reservas.add(reserva);
				}
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			Conexao.closeConnection(connection);
		}
				
		return reservas;
	}
}
