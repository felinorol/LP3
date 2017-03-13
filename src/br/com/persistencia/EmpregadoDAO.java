package br.com.persistencia;
import java.sql.Connection; import
java.sql.PreparedStatement;
import java.sql.ResultSet;
import
java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import br.com.modelo.Empregado;
public class EmpregadoDAO {

	public static int grava(Empregado empregado) {
		Connection con = GerenteConexao.getConexao();
		PreparedStatement pst = null;
		int ret = 0;
		try {
			String sql = "INSERT INTO EMPREGADO(CODIGO, NOME, IDADE) VALUES(?,?,?)";
			pst = con.prepareStatement(sql);
			pst.setInt(1, empregado.getCodigo());
			pst.setString(2, empregado.getNome());
			pst.setInt(3, empregado.getIdade());
			ret = pst.executeUpdate();
			System.out.println("Dados inseridos com sucesso!!!");
		} catch (SQLException sqle) {
			System.out.println("Não foi possível inserir os dados!!");
		}
		return ret;
	}

	public static int altera(Empregado empregado) {
		Connection con = GerenteConexao.getConexao();
		PreparedStatement pst = null;
		int ret = 0;
		try {
			String sql = "UPDATE EMPREGADO SET NOME = ?, IDADE = ? WHERE CODIGO = ?";
			pst = con.prepareStatement(sql);
			pst.setString(1, empregado.getNome());
			pst.setInt(2, empregado.getIdade());
			pst.setInt(3, empregado.getCodigo());
			ret = pst.executeUpdate();
			System.out.println("Dados atualizados com sucesso!!!");
		} catch (SQLException sqle) {
			System.out.println("Não foi possível atualizar os dados!!");
			sqle.printStackTrace();
		}
		return ret;
	}

	public static int exclui(int codigo) {
		Connection con = GerenteConexao.getConexao();
		PreparedStatement pst = null;
		int ret = 0; try {
			String sql = "DELETE FROM EMPREGADO WHERE CODIGO = ?";
			pst = con.prepareStatement(sql);
			pst.setInt(1, codigo);
			ret = pst.executeUpdate();
			System.out.println("Dados excluído com sucesso!!!");
		} catch (SQLException sqle) {
			System.out.println("Não foi possível excluir os dados!!");
			sqle.printStackTrace();
		}
		return ret;
	}
	public static Empregado le(int codigo) {
		Connection con = GerenteConexao.getConexao();
		PreparedStatement pst = null;
		ResultSet rs = null;
		Empregado empregado = null;
		try {
			String sql = "SELECT * FROM EMPREGADO WHERE CODIGO = ?";
			pst = con.prepareStatement(sql);
			pst.setInt(1, codigo);
			rs = pst.executeQuery();
			if (rs.next()){
				empregado = new Empregado();
				empregado.setCodigo(rs.getInt("codigo"));
				empregado.setNome(rs.getString("nome"));
				empregado.setIdade(rs.getInt("idade"));
			}

			System.out.println("Dados excluído com sucesso!!!");
		} catch (SQLException sqle) {
			System.out.println("Não foi possível excluir os dados!!");
			sqle.printStackTrace();

		}
		return empregado;
	}
	public static List<Empregado> leTodos() {
		List <Empregado> empregados = new ArrayList();
		Connection con = GerenteConexao.getConexao();
		Statement st = null;
		ResultSet rs = null;
		Empregado empregado = null;
		try {
			st = con.createStatement();
			rs = st.executeQuery("SELECT * FROM EMPREGADO;"); 

			while (rs.next()){
				empregado = new Empregado();
				empregado.setCodigo(rs.getInt("codigo"));
				empregado.setNome(rs.getString("nome"));
				empregado.setIdade(rs.getInt("idade"));

				empregados.add(empregado);
			}

			System.out.println("Dados lidos com sucesso!!!");
		} catch (SQLException sqle) {
			System.out.println("Não foi possível ler os dados!!");
			sqle.printStackTrace();
		}
		return empregados;
	}
} 
