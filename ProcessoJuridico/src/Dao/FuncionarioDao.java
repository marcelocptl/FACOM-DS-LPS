package Dao;

import Model.Advogado;
import Model.Assistente;
import Model.Funcionario;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import util.ConnectFactory;

public class FuncionarioDao {

    public int inserir(Advogado novo) {
        try {
            Connection conn = ConnectFactory.getConnection();
            String query = "insert into pessoa (nome, endereco, cidade, estado, cep, complemento, telcelular, telresid, email, usuario, senha, flag) values (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
            PreparedStatement preparedStmt = conn.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
            preparedStmt.setString(1, novo.getNome());
            preparedStmt.setString(2, novo.getEndereco());
            preparedStmt.setString(3, novo.getCidade());
            preparedStmt.setString(4, novo.getEstado());
            preparedStmt.setString(5, novo.getCep());
            preparedStmt.setString(6, novo.getComplemento());
            preparedStmt.setString(7, novo.getTelefoneCelular());
            preparedStmt.setString(8, novo.getTelefoneResidencial());
            preparedStmt.setString(9, novo.getEmail());
            preparedStmt.setString(10, novo.getUsuario());
            preparedStmt.setString(11, novo.getSenha());
            preparedStmt.setString(12, "FUNCIONARI");
            preparedStmt.execute();
            final ResultSet rs = preparedStmt.getGeneratedKeys();
            if (rs.next()) {
                int lastId = rs.getInt(1);
                query = "insert into funcionario (id, rg, cpf, dataNascimento, estadoCivil, ramal, flag, numRegistroOAB, situacaoRegistroOAB) values (?, ?, ?, ?, ?, ?, ?, ?, ?)";
                preparedStmt = conn.prepareStatement(query);
                preparedStmt.setInt(1, lastId);
                preparedStmt.setString(2, novo.getRg());
                preparedStmt.setString(3, novo.getCpf());
                preparedStmt.setDate(4, novo.getDataNascimento());
                preparedStmt.setString(5, novo.getEstadoCivil());
                preparedStmt.setInt(6, novo.getRamal());
                preparedStmt.setString(7, "ADVOGADO");
                preparedStmt.setInt(8, novo.getNumRegistroOAB());
                preparedStmt.setString(9, novo.getSituacaoRegistroOAB());
                preparedStmt.execute();
                return lastId;
            }
            conn.close();
        } catch (Exception e) {
            //System.err.println("Ocorreu uma exceção!");
            System.err.println(e.getMessage());
        }
        return -1;
    }

    public int inserir(Assistente novo) {
        try {
            Connection conn = ConnectFactory.getConnection();
            String query = "insert into pessoa (nome, endereco, cidade, estado, cep, complemento, telcelular, telresid, email, usuario, senha, flag) values (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
            PreparedStatement preparedStmt = conn.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
            preparedStmt.setString(1, novo.getNome());
            preparedStmt.setString(2, novo.getEndereco());
            preparedStmt.setString(3, novo.getCidade());
            preparedStmt.setString(4, novo.getEstado());
            preparedStmt.setString(5, novo.getCep());
            preparedStmt.setString(6, novo.getComplemento());
            preparedStmt.setString(7, novo.getTelefoneCelular());
            preparedStmt.setString(8, novo.getTelefoneResidencial());
            preparedStmt.setString(9, novo.getEmail());
            preparedStmt.setString(10, novo.getUsuario());
            preparedStmt.setString(11, novo.getSenha());
            preparedStmt.setString(12, "FUNCIONARIO");
            preparedStmt.execute();
            final ResultSet rs = preparedStmt.getGeneratedKeys();
            if (rs.next()) {
                int lastId = rs.getInt(1);
                query = "insert into funcionario (id, rg, cpf, dataNascimento, estadoCivil, ramal, flag) values (?, ?, ?, ?, ?, ?, ?)";
                preparedStmt = conn.prepareStatement(query);
                preparedStmt.setInt(1, lastId);
                preparedStmt.setString(2, novo.getRg());
                preparedStmt.setString(3, novo.getCpf());
                preparedStmt.setDate(4, novo.getDataNascimento());
                preparedStmt.setString(5, novo.getEstadoCivil());
                preparedStmt.setInt(6, novo.getRamal());
                preparedStmt.setString(7, "ASSISTENTE");
            preparedStmt.execute();
                return lastId;
            }
            conn.close();
        } catch (Exception e) {
            //System.err.println("Ocorreu uma exceção!");
            System.err.println(e.getMessage());
        }
        return -1;
    }

    public static Funcionario getObj(int id) {
            Connection conn = ConnectFactory.getConnection();
            String query = "SELECT * FROM pessoa WHERE id = " + id;
            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery(query);
	    query = "SELECT * FROM funcionario WHERE id = " + id;
	    st = conn.createStatement();
            ResultSet rs2 = st.executeQuery(query);
            if (rs.next() && rs2.next()) {
                Funcionario f = new Funcionario();
                f.setId(rs.getInt("id"));
                f.setNome(rs.getString("nome"));
                f.setEndereco(rs.getString("endereco"));
                f.setCidade(rs.getString("cidade"));
                f.setEstado(rs.getString("estado"));
                f.setCep(rs.getString("cep"));
                f.setComplemento(rs.getString("complemento"));
                f.setTelefoneCelular(rs.getString("telcelular"));
                f.setTelefoneResidencial(rs.getString("telresid"));
                f.setEmail(rs.getString("email"));
                f.setUsuario(rs.getString("usuario"));
                f.setSenha(rs.getString("senha"));

                f.setRg(rs.getString("rg"));
                f.setCpf(rs.getString("cpf"));
                f.setDataNascimento(rs.getDate("datanascimento"));
                f.setEstadoCivil(rs.getString("estadocivil"));
                f.setRamal(rs.getInt("ramal"));
           	st.close();
           	conn.close();
           	return f;
            }
            st.close();
            conn.close();
        } catch (Exception e) {
            //System.err.println("Ocorreu uma exceção!");
            //System.err.println(e.getMessage());
        }
        return null;
    }

}
