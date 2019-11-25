package br.com.caellum.jdbc.dao;

import java.sql.SQLException;

public class DAOException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	public DAOException(SQLException e) {
		super(e);
	}

	public DAOException(String string) {
		super(string);
	}

}