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
            preparedStmt.setString(12, "FUNCIONARIO");
            preparedStmt.execute();
            final ResultSet rs = preparedStmt.getGeneratedKeys();
            if (rs.next()) {
                int lastId = rs.getInt(1);
                query = "insert into Funcionario (id, rg, cpf, dataNascimento, estadoCivil, ramal, flag) values (?, ?, ?, ?, ?, ?, ?)";
                preparedStmt = conn.prepareStatement(query);
                preparedStmt.setInt(1, lastId);
                preparedStmt.setString(2, novo.getRg());
                preparedStmt.setString(3, novo.getCpf());
                preparedStmt.setDate(4, novo.getDataNascimento());
                preparedStmt.setString(5, novo.getEstadoCivil());
                preparedStmt.setInt(6, novo.getRamal());
                preparedStmt.setString(7, "ADVOGADO");
                query = "insert into Advogado (id, numRegistroOAB, situacaoRegistroOAB) values (?, ?, ?)";
                preparedStmt = conn.prepareStatement(query);
                preparedStmt.setInt(1, lastId);
                preparedStmt.setInt(2, novo.getNumRegistroOAB());
                preparedStmt.setString(3, novo.getSituacaoRegistroOAB());
                return lastId;
            }
            conn.close();
        } catch (Exception e) {
            System.err.println("Ocorreu uma exceção!");
            System.err.println(e.getMessage());
        }
        return -1;
    }

    public int deletar(Advogado antigo) {
        return -1;
    }

    public int atualizar(Advogado atual) {
        return -1;
    }

    public ArrayList<Advogado> listarAdvogado() {
        return null;
    }

    public int inserir(Assistente novo) {
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
            preparedStmt.setString(12, "FUNCIONARIO");
            preparedStmt.execute();
            final ResultSet rs = preparedStmt.getGeneratedKeys();
            if (rs.next()) {
                int lastId = rs.getInt(1);
                query = "insert into Funcionario (id, rg, cpf, dataNascimento, estadoCivil, ramal, flag) values (?, ?, ?, ?, ?, ?, ?)";
                preparedStmt = conn.prepareStatement(query);
                preparedStmt.setInt(1, lastId);
                preparedStmt.setString(2, novo.getRg());
                preparedStmt.setString(3, novo.getCpf());
                preparedStmt.setDate(4, novo.getDataNascimento());
                preparedStmt.setString(5, novo.getEstadoCivil());
                preparedStmt.setInt(6, novo.getRamal());
                preparedStmt.setString(7, "ASSISTENTE");
                return lastId;
            }
            conn.close();
        } catch (Exception e) {
            System.err.println("Ocorreu uma exceção!");
            System.err.println(e.getMessage());
        }
        return -1;
    }

    public int deletar(Assistente antigo) {
        return -1;
    }

    public int atualizar(Assistente atual) {
        return -1;
    }
    
    public static Funcionario getCodigo(int id){
        return null;
    }

    public ArrayList<Assistente> listarAssistente() {
        return null;
    }

    public int atualizarLimitadoProcesso() {
        return -1;
    }

}
