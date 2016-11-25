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
            String query = "insert into Pessoa (nome, endereco, cidade, estado, cep, complemento, telefoneCelular, telefoneResidencial, email, usuario, senha, flag) values (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
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
                query = "insert into PessoaFisica (id, rg, cpf, dataNascimento, estadoCivil) values (?, ?, ?, ?, ?)";
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
            System.err.println("Ocorreu uma exceção!");
            System.err.println(e.getMessage());
        }
        return -1;
    }

    public int deletar(PessoaFisica antigo) {
        try {
            Connection conn = ConnectFactory.getConnection();
            String query = "delete PessoaFisica users where id = ?";
            PreparedStatement preparedStmt = conn.prepareStatement(query);
            preparedStmt.setInt(1, antigo.getCodigo());
            preparedStmt.execute();
            conn.close();
            return 1;
        } catch (Exception e) {
            System.err.println("Ocorreu uma exceção!");
            System.err.println(e.getMessage());
        }
        return -1;
    }

    public int atualizar(PessoaFisica atual) {
        try {
            Connection conn = ConnectFactory.getConnection();
            String query = "update Pessoa set nome = ?, endereco = ?, cidade = ?, estado = ?, cep = ?, complemento = ?, telefoneCelular = ?, telefoneResidencial = ?, email = ?, usuario = ?, senha = ? where id = ?";
            PreparedStatement preparedStmt = conn.prepareStatement(query);
            preparedStmt.setString(1, atual.getNome());
            preparedStmt.setString(2, atual.getEndereco());
            preparedStmt.setString(3, atual.getCidade());
            preparedStmt.setString(4, atual.getEstado());
            preparedStmt.setString(5, atual.getCep());
            preparedStmt.setString(6, atual.getComplemento());
            preparedStmt.setString(7, atual.getTelefoneCelular());
            preparedStmt.setString(8, atual.getTelefoneResidencial());
            preparedStmt.setString(9, atual.getEmail());
            preparedStmt.setString(10, atual.getUsuario());
            preparedStmt.setString(11, atual.getSenha());
            preparedStmt.setInt(12, atual.getCodigo());
            preparedStmt.executeUpdate();

            query = "update PessoaFisica set rg = ?, cpf = ?, dataNascimento = ?, estadoCivil = ? where id = ?";
            preparedStmt = conn.prepareStatement(query);
            preparedStmt.setString(1, atual.getRg());
            preparedStmt.setString(2, atual.getCpf());
            preparedStmt.setDate(3, atual.getDataNascimento());
            preparedStmt.setString(4, atual.getEstadoCivil());
            preparedStmt.setInt(5, atual.getCodigo());
            preparedStmt.executeUpdate();
            conn.close();
            return 1;
        } catch (Exception e) {
            System.err.println("Ocorreu uma exceção!");
            System.err.println(e.getMessage());
        }
        return -1;
    }

    public ArrayList<PessoaFisica> listarPessoaFisica() {
        return null;
    }

    public int inserir(PessoaJuridica novo) {
        try {
            Connection conn = ConnectFactory.getConnection();
            String query = "insert into Pessoa (nome, endereco, cidade, estado, cep, complemento, telefoneCelular, telefoneResidencial, email, usuario, senha, flag) values (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
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
                query = "insert into PessoaJuridica (id, cnpj, inscricaoEstadual, inscricaoMunicipal, site, nomeFantasia) values (?, ?, ?, ?, ?, ?)";
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
            System.err.println("Ocorreu uma exceção!");
            System.err.println(e.getMessage());
        }
        return -1;
    }

    public int deletar(PessoaJuridica antigo) {
        try {
            Connection conn = ConnectFactory.getConnection();
            String query = "delete from PessoaJuridica where id = ?";
            PreparedStatement preparedStmt = conn.prepareStatement(query);
            preparedStmt.setInt(1, antigo.getCodigo());
            preparedStmt.execute();
            return 1;
        } catch (Exception e) {
            System.err.println("Ocorreu uma exceção!");
            System.err.println(e.getMessage());
        }
        return -1;
    }

    public int atualizar(PessoaJuridica atual) {
        try {
            Connection conn = ConnectFactory.getConnection();
            String query = "update Pessoa set nome = ?, endereco = ?, cidade = ?, estado = ?, cep = ?, complemento = ?, telefoneCelular = ?, telefoneResidencial = ?, email = ?, usuario = ?, senha = ? where id = ?";
            PreparedStatement preparedStmt = conn.prepareStatement(query);
            preparedStmt.setString(1, atual.getNome());
            preparedStmt.setString(2, atual.getEndereco());
            preparedStmt.setString(3, atual.getCidade());
            preparedStmt.setString(4, atual.getEstado());
            preparedStmt.setString(5, atual.getCep());
            preparedStmt.setString(6, atual.getComplemento());
            preparedStmt.setString(7, atual.getTelefoneCelular());
            preparedStmt.setString(8, atual.getTelefoneResidencial());
            preparedStmt.setString(9, atual.getEmail());
            preparedStmt.setString(10, atual.getUsuario());
            preparedStmt.setString(11, atual.getSenha());
            preparedStmt.setInt(12, atual.getCodigo());
            preparedStmt.executeUpdate();

            query = "update PessoaJuridica set cnpj = ?, inscricaoEstadual = ?, inscricaoMunicipal = ?, site = ?, nomeFantasia = ? where id = ?";
            preparedStmt = conn.prepareStatement(query);
            preparedStmt.setString(1, atual.getCnpj());
            preparedStmt.setInt(2, atual.getInscricaoEstadual());
            preparedStmt.setInt(3, atual.getInscricaoMunicipal());
            preparedStmt.setString(4, atual.getSite());
            preparedStmt.setString(5, atual.getNomeFantasia());
            preparedStmt.setInt(6, atual.getCodigo());
            preparedStmt.executeUpdate();
            conn.close();
            return 1;
        } catch (Exception e) {
            System.err.println("Ocorreu uma exceção!");
            System.err.println(e.getMessage());
        }
        return -1;
    }
    
    public static Cliente getCodigo(int id){
        try {
            Connection conn = ConnectFactory.getConnection();
            String query = "update Pessoa set nome = ?, endereco = ?, cidade = ?, estado = ?, cep = ?, complemento = ?, telefoneCelular = ?, telefoneResidencial = ?, email = ?, usuario = ?, senha = ? where id = ?";
            PreparedStatement preparedStmt = conn.prepareStatement(query);
            
            preparedStmt.executeUpdate();

            query = "update PessoaJuridica set cnpj = ?, inscricaoEstadual = ?, inscricaoMunicipal = ?, site = ?, nomeFantasia = ? where id = ?";
            
            preparedStmt.executeUpdate();
            conn.close();
        } catch (Exception e) {
            System.err.println("Ocorreu uma exceção!");
            System.err.println(e.getMessage());
        }
        return null;
    }

    public ArrayList<PessoaJuridica> listarPessoaJuridica() {
        return null;
    }

    public ArrayList<ProcessoDao> listarProcessos() {
        return null;
    }
}
