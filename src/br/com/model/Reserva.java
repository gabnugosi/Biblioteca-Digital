package br.com.model;

import java.sql.Date;

public class Reserva {
		private int id;
		private Date dtHoraReserva;
		private int prazoReserva;
		private String situacaoReserva;
		private int idObra;
		private int idUser;
		
		
		public Reserva() {}

		public Reserva(int id, Date dtHoraReserva, int prazoReserva, String situacaoReserva, int idObra, int idUser) {
			super();
			this.id = id;
			this.dtHoraReserva = dtHoraReserva;
			this.prazoReserva = prazoReserva;
			this.situacaoReserva = situacaoReserva;
			this.idObra = idObra;
			this.idUser = idUser;
		}
		
		public int getId() {
			return id;
		}
		public void setId(int id) {
			this.id = id;
		}
		public Date getDtHoraReserva() {
			return dtHoraReserva;
		}
		public void setDtHoraReserva(Date dtHoraReserva) {
			this.dtHoraReserva = dtHoraReserva;
		}
		public int getPrazoReserva() {
			return prazoReserva;
		}
		public void setPrazoReserva(int prazoReserva) {
			this.prazoReserva = prazoReserva;
		}
		public String getSituacaoReserva() {
			return situacaoReserva;
		}
		public void setSituacaoReserva(String situacaoReserva) {
			this.situacaoReserva = situacaoReserva;
		}
		public int getIdObra() {
			return idObra;
		}
		public void setIdObra(int idObra) {
			this.idObra = idObra;
		}
		public int getIdUser() {
			return idUser;
		}
		public void setIdUser(int idUser) {
			this.idUser = idUser;
		}
		
		
}
