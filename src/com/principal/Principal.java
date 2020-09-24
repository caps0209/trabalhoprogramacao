package com.principal;

import view.ControllerPessoa;

public class Principal {

	//Este trabalho foi feito usando o banco, portanto
	//deve ser alterado as informações dele em SRC/com.db/ConexaoHSQLDB
	
	public static void main(String[] args) {
		new ControllerPessoa().execute();
	}
}
