package br.com.teste;

import br.com.modelo.Empregado;
import br.com.persistencia.EmpregadoDAO;

public class TestaEmpregadoDAO {
	public static void main(String args[]){
		Empregado empregado = new Empregado();

		empregado.setCodigo(3);
		empregado.setNome("Luiz");
		empregado.setIdade(45);
		EmpregadoDAO.grava(empregado);

	}
}
