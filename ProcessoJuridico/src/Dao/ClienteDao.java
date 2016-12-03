package Dao;

import Model.PessoaFisica;
import Model.PessoaJuridica;
import Model.Cliente;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import util.ConnectFactory;

/**
 * @author brucce
 */
public class ClienteDao {

    public int inserir(PessoaFisica novo) {
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
            preparedStmt.setString(12, "P.FISICO");
            preparedStmt.execute();
            final ResultSet rs = preparedStmt.getGeneratedKeys();
            if (rs.next()) {
                int lastId = rs.getInt(1);
                query = "insert into pessoafisica (id, rg, cpf, dataNasc, estadoCivil) values (?, ?, ?, ?, ?)";
                preparedStmt = conn.prepareStatement(query);
                preparedStmt.setInt(1, lastId);
                preparedStmt.setString(2, novo.getRg());
                preparedStmt.setString(3, novo.getCpf());
                preparedStmt.setDate(4, novo.getDataNascimento());
                preparedStmt.setString(5, novo.getEstadoCivil());
                preparedStmt.execute();
                return lastId;
            }
            conn.close();
        } catch (Exception e) {
            //System.err.println("Ocorreu uma exceção!");
            system.err.println(e.getMessage());
            e.printStackTrace();
        }
        return -1;
    }
    
    public int inserir(PessoaJuridica novo) {
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
            preparedStmt.setString(12, "P.JURIDICO");
            preparedStmt.execute();
            final ResultSet rs = preparedStmt.getGeneratedKeys();
            if (rs.next()) {
                int lastId = rs.getInt(1);
                query = "insert into pessoafisica (id, cnpj, inscricaoEstadual, inscricaoMunicipal, site, nomeFantasia) values (?, ?, ?, ?, ?, ?)";
                preparedStmt = conn.prepareStatement(query);
                preparedStmt.setInt(1, lastId);
                preparedStmt.setString(2, novo.getCnpj());
                preparedStmt.setInt(3, novo.getInscricaoEstadual());
                preparedStmt.setInt(4, novo.getInscricaoMunicipal());
                preparedStmt.setString(5, novo.getSite());
                preparedStmt.setString(6, novo.getNomeFantasia());
                preparedStmt.execute();
                return lastId;
            }
            conn.close();
        } catch (Exception e) {
            //System.err.println("Ocorreu uma exceção!");
            system.err.println(e.getMessage());
            e.printStackTrace();
        }
        return -1;
    }
    
    public static Cliente getObj(int id){
	try {
            Connection conn = ConnectFactory.getConnection();
            String query = "SELECT * FROM pessoa WHERE id = " + id;
            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery(query);
            if (rs.next()) {
                Cliente c = new Cliente();
                c.setId(rs.getInt("id"));
                c.setNome(rs.getString("nome"));
                c.setEndereco(rs.getString("endereco"));
                c.setCidade(rs.getString("cidade"));
                c.setEstado(rs.getString("estado"));
                c.setCep(rs.getString("cep"));
                c.setComplemento(rs.getString("complemento"));
                c.setTelefoneCelular(rs.getString("telcelular"));
                c.setTelefoneResidencial(rs.getString("telresid"));
                c.setEmail(rs.getString("email"));amor vc comrpou um 
                c.setUsuario(rs.getString("usuario"));
                c.setSenha(rs.getString("senha"));
           	st.close();
           	conn.close();
           	return c;
            }
            st.close();
            conn.close();
        } catch (Exception xceção!");
            //System.err.println(e) {
            //System.err.println("Ocorreu uma exceção!");
            system.err.println(e.getMessage());
            e.printStackTrace();
        }
	return null;
    }
}
