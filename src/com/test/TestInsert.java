package com.test;

import com.pessoa.Pessoa;

import dao.PessoaDAO;

public class TestInsert {

	public static void main(String[] args) {
		PessoaDAO pessoaDAO = new PessoaDAO();
		
		Pessoa pessoa = new Pessoa("João", "joao@gmail.com");
		int quantidade = pessoaDAO.inserir(pessoa);
		System.out.println(quantidade);
	}
	
}
