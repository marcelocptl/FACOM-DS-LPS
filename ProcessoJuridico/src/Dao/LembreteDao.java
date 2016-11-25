package Dao;

import java.util.ArrayList;
import Model.Lembrete;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import util.ConnectFactory;

/**
 *
 * @author brucce
 */
public class LembreteDao {

    public int inserir(Lembrete novo) {
        try {
            Connection conn = ConnectFactory.getConnection();
            String query = "insert into Lembrete (data, hora, local, assunto, descricao, id_processo, id_pessoa, id_funcionario) values (?, ?, ?, ?, ?, ?, ?, ?)";
            PreparedStatement preparedStmt = conn.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
            preparedStmt.setDate(1, novo.getData());
            preparedStmt.setTime(2, novo.getHora());
            preparedStmt.setString(3, novo.getLocal());
            preparedStmt.setString(4, novo.getAssunto());
            preparedStmt.setString(5, novo.getDescricao());
            preparedStmt.setInt(6, novo.getProcesso().getCodigo());
            preparedStmt.setInt(7, novo.getCliente().getCodigo());
            preparedStmt.setInt(8, novo.getFuncionario().getCodigo());
            preparedStmt.execute();
            final ResultSet rs = preparedStmt.getGeneratedKeys();
            if (rs.next()) {
                return rs.getInt(1);
            }
        } catch (Exception e) {
            System.err.println("Ocorreu uma exceção!");
            System.err.println(e.getMessage());
        }
        return -1;
    }

    public int deletar(Lembrete antigo) {
        try {
            Connection conn = ConnectFactory.getConnection();
            String query = "delete Lembrete where id = ?";
            PreparedStatement preparedStmt = conn.prepareStatement(query);
            preparedStmt.setInt(1, antigo.getCodigo());
            preparedStmt.execute();
            conn.close();
            return antigo.getCodigo();
        } catch (Exception e) {
            System.err.println("Ocorreu uma exceção!");
            System.err.println(e.getMessage());
        }
        return -1;
    }

    public int atualizar(Lembrete atual) {
        try {
            Connection conn = ConnectFactory.getConnection();
            String query = "update Lembrete set data = ?, hora = ?, local = ?, assunto = ?, descricao = ?, id_processo = ?, id_pessoa = ?, id_funcionario = ? where id = ?";
            PreparedStatement preparedStmt = conn.prepareStatement(query);
            preparedStmt.setDate(1, atual.getData());
            preparedStmt.setTime(2, atual.getHora());
            preparedStmt.setString(3, atual.getLocal());
            preparedStmt.setString(4, atual.getAssunto());
            preparedStmt.setString(5, atual.getDescricao());
            preparedStmt.setInt(6, atual.getProcesso().getCodigo());
            preparedStmt.setInt(7, atual.getCliente().getCodigo());
            preparedStmt.setInt(8, atual.getFuncionario().getCodigo());
            preparedStmt.setInt(9, atual.getCodigo());

            preparedStmt.executeUpdate();
            conn.close();
            return atual.getCodigo();
        } catch (Exception e) {
            System.err.println("Ocorreu uma exceção!");
            System.err.println(e.getMessage());
        }
        return -1;
    }

    public ArrayList<Lembrete> listar() {
        try {
            Connection conn = ConnectFactory.getConnection();
            String query = "SELECT * FROM lembrete";
            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery(query);
            ArrayList<Lembrete> lembretes = new ArrayList<>();
            while (rs.next()) {
                Lembrete lem = new Lembrete();
                lem.setCodigo(rs.getInt("id"));
                lem.setData(rs.getDate("data"));
                lem.setHora(rs.getTime("hora"));
                lem.setLocal(rs.getString("local"));
                lem.setAssunto(rs.getString("assunto"));
                lem.setDescricao(rs.getString("descricao"));
                lem.setCliente(ClienteDao.getCodigo(rs.getInt("id_pessoa")));
                lem.setProcesso(ProcessoDao.getCodigo(rs.getInt("id_processo")));
                lem.setFuncionario(FuncionarioDao.getCodigo(rs.getInt("id_funcionario")));
                lembretes.add(lem);
            }
            st.close();
            conn.close();
            return lembretes;
        } catch (Exception e) {
            System.err.println("Ocorreu uma exceção!");
            System.err.println(e.getMessage());
        }
        return null;
    }

    public ArrayList<Lembrete> lembrar() {
        try {
            Connection conn = ConnectFactory.getConnection();
            String query = "SELECT * FROM lembrete";
            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery(query);
            ArrayList<Lembrete> lembretes = new ArrayList<>();
            while (rs.next()) {
                Lembrete lem = new Lembrete();
                lem.setCodigo(rs.getInt("id"));
                lem.setData(rs.getDate("data"));
                lem.setHora(rs.getTime("hora"));
                lem.setLocal(rs.getString("local"));
                lem.setAssunto(rs.getString("assunto"));
                lem.setDescricao(rs.getString("descricao"));
                lem.setCliente(ClienteDao.getCodigo(rs.getInt("id_pessoa")));
                lem.setProcesso(ProcessoDao.getCodigo(rs.getInt("id_processo")));
                lem.setFuncionario(FuncionarioDao.getCodigo(rs.getInt("id_funcionario")));
                lembretes.add(lem);
            }
            st.close();
            conn.close();
            return lembretes;
        } catch (Exception e) {
            System.err.println("Ocorreu uma exceção!");
            System.err.println(e.getMessage());
        }
        return null;
    }
}
