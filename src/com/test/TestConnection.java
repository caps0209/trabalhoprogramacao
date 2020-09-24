package com.test;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.db.ConexaoHSQLDB;

public class TestConnection {
	public static void main (String[] args) {
		ConexaoHSQLDB conn = new ConexaoHSQLDB();
		
		Connection connection = conn.conectar();
		
		//inserir dados
	   final String SQL_INSERT_PESSOA = "INSERT INTO PESSOA (NOME, EMAIL)"
	   		+ " VALUES ( ?, ?)";
		
	   PreparedStatement pst;
	   try {
		pst = connection.prepareStatement(SQL_INSERT_PESSOA);
		pst.setString(1, "aaa");
		pst.setString(2, "aaa@bbbbb.com");
		int quantidade = pst.executeUpdate();
		System.out.println("Qtde inserido: " + quantidade);
	} catch (SQLException e) {
		e.printStackTrace();
	}   
	   
	  //Listar todos 
	   final String SQL_SELECT_PESSOAS = "SELECT * FROM PESSOA";
	   try {
		pst = connection.prepareStatement(SQL_SELECT_PESSOAS);
		ResultSet rs = pst.executeQuery();
		
		while(rs.next()) {
			int id = rs.getInt("ID");
			String nome = rs.getString("NOME");
			String email = rs.getString("EMAIL");
			System.out.println(id+ " "+nome + " "+ email );
		}
		
	} catch (SQLException e) {
		e.printStackTrace();
	}
	   
	   try {
		connection.close();
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	}
}
