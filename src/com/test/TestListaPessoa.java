package com.test;

import java.util.List;

import com.pessoa.Pessoa;

import dao.PessoaDAO;

public class TestListaPessoa {

	public static void main(String[] args) {
		List<Pessoa> listaPessoas = new PessoaDAO().listAll();
		
		for (Pessoa pessoa : listaPessoas) {
			System.out.println(pessoa);
		}
		
	}
}
