package br.com.teste;
import java.sql.Connection; import
java.sql.PreparedStatement; import
java.sql.SQLException; import
br.com.persistencia.GerenteConexao;
public class TestaEmpregado {
	public static void main(String a[]){

		Connection con = GerenteConexao.getConexao();

		PreparedStatement pst = null;
		try{
			String sql = "INSERT INTO EMPREGADO(CODIGO, NOME, IDADE) VALUES(1,'Maria',25)";
			pst = con.prepareStatement(sql);
			pst.executeUpdate();
			System.out.println("Dados inseridos com sucesso!!!");
		}catch(SQLException sqle){
			System.out.println("Não foi possível inserir os dados!!");

		}
	} 
}