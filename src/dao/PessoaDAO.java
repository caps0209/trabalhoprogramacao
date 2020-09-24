package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.db.ConexaoHSQLDB;
import com.pessoa.Pessoa;

public class PessoaDAO extends ConexaoHSQLDB {

	final String SQL_INSERT_PESSOA = "INSERT INTO PESSOA (NOME, EMAIL)" + " VALUES ( ?, ?)";
	final String SQL_SELECT_PESSOAS = "SELECT * FROM PESSOA";
	final String SQL_SELECT_PESSOAS_ID = "SELECT * FROM PESSOA WHERE ID = ?";

	//Este trabalho foi feito usando o banco, portanto
	//deve ser alterado as informações dele em SRC/com.db/ConexaoHSQLDB
	
	public int inserir(Pessoa pessoa) {

		int quantidade = 0;

		// inserir dados

		try (Connection connection = this.conectar();
				PreparedStatement pst = connection.prepareStatement(SQL_INSERT_PESSOA);) {
			pst.setString(1, pessoa.getNome());
			pst.setString(2, pessoa.getEmail());
			quantidade = pst.executeUpdate();
			System.out.println("Qtde inserido: " + quantidade);

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return quantidade;
	}

	public List<Pessoa> listAll() {

		List<Pessoa> listaPessoa = new ArrayList<Pessoa>();
		
		try (Connection connection = this.conectar();
				PreparedStatement pst = connection.prepareStatement(SQL_SELECT_PESSOAS);) {

			ResultSet rs = pst.executeQuery();

			while (rs.next()) {
				Pessoa pessoa = new Pessoa();

				pessoa.setId(rs.getInt("ID"));
				pessoa.setNome(rs.getString("NOME"));
				pessoa.setEmail(rs.getString("EMAIL"));
				listaPessoa.add(pessoa);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return listaPessoa;
	}

	public Pessoa findByID(int id) {
		Pessoa pessoa = null;
		try (Connection connection = this.conectar();
				PreparedStatement pst = connection.prepareStatement(SQL_SELECT_PESSOAS_ID);) {

			pst.setInt(1, id);
			ResultSet rs = pst.executeQuery();
			
			while (rs.next()) {
				pessoa = new Pessoa();

				pessoa.setId(rs.getInt("ID"));
				pessoa.setNome(rs.getString("NOME"));
				pessoa.setEmail(rs.getString("EMAIL"));
				
				
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return pessoa;
	}

}
