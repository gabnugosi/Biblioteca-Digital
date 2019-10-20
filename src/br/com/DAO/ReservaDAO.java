package br.com.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import br.com.conexao.Conexao;
import br.com.exception.DAOException;
import br.com.model.Reserva;

public class ReservaDAO {
	public void inserir (Reserva reserva) throws DAOException {
		Connection connection = Conexao.getConnection();
		PreparedStatement pstm; 
		String query = "insert into reserva (dt_hora_reserva, prazo_reserva, situacao_reserva, id_usu,  id_obra) values (?, ?, ?, ?, ?)";
		
		try {
			pstm = connection.prepareStatement(query);
			pstm.setDate(1, reserva.getDtHoraReserva());
			pstm.setInt(2, reserva.getPrazoReserva());
			pstm.setString(3, reserva.getSituacaoReserva());
			pstm.setInt(4, reserva.getIdUser());
			pstm.setInt(5, reserva.getIdObra());
			
			pstm.execute();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
