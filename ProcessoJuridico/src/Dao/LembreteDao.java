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
            String query = "insert into lembrete"
                    + " (data, hora, local, assunto, descricao, id_processo, id_pessoa, id_funcionario)"
                    + " values (?, ?, ?, ?, ?, ?, ?, ?)";
            PreparedStatement preparedStmt = conn.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
            preparedStmt.setDate(1, novo.getData());
            preparedStmt.setTime(2, novo.getHora());
            preparedStmt.setString(3, novo.getLocal());
            preparedStmt.setString(4, novo.getAssunto());
            preparedStmt.setString(5, novo.getDescricao());
            preparedStmt.setInt(6, novo.getProcesso().getId());
            preparedStmt.setInt(7, novo.getCliente().getId());
            preparedStmt.setInt(8, novo.getFuncionario().getId());
            preparedStmt.execute();
            final ResultSet rs = preparedStmt.getGeneratedKeys();
            if (rs.next()) {
                System.out.println("Operação realizada com sucesso!");
                conn.close();
                return rs.getInt(1);
            }
            conn.close();
        } catch (Exception e) {
            System.err.println(e.getMessage());
            e.printStackTrace();
        }
        return -1;
    }

    public int deletar(Lembrete antigo) {
        try {
            Connection conn = ConnectFactory.getConnection();
            String query = "delete from lembrete where id = ?";
            PreparedStatement preparedStmt = conn.prepareStatement(query);
            preparedStmt.setInt(1, antigo.getId());
            preparedStmt.execute();
            System.out.println("Operação realizada com sucesso!");
            conn.close();
            return antigo.getId();
        } catch (Exception e) {
            System.err.println(e.getMessage());
            e.printStackTrace();
        }
        return -1;
    }

    public int atualizar(Lembrete atual) {
        try {
            Connection conn = ConnectFactory.getConnection();
            String query = "update lembrete set data = ?, hora = ?, local = ?, assunto = ?,"
                    + " descricao = ?, id_processo = ?, id_pessoa = ?, id_funcionario = ?"
                    + " where id = ?";
            PreparedStatement preparedStmt = conn.prepareStatement(query);
            preparedStmt.setDate(1, atual.getData());
            preparedStmt.setTime(2, atual.getHora());
            preparedStmt.setString(3, atual.getLocal());
            preparedStmt.setString(4, atual.getAssunto());
            preparedStmt.setString(5, atual.getDescricao());
            preparedStmt.setInt(6, atual.getProcesso().getId());
            preparedStmt.setInt(7, atual.getCliente().getId());
            preparedStmt.setInt(8, atual.getFuncionario().getId());
            preparedStmt.setInt(9, atual.getId());

            preparedStmt.executeUpdate();
            System.out.println("Operação realizada com sucesso!");
            conn.close();
            return atual.getId();
        } catch (Exception e) {
            System.err.println(e.getMessage());
            e.printStackTrace();
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
                lem.setId(rs.getInt("id"));
                lem.setData(rs.getDate("data"));
                lem.setHora(rs.getTime("hora"));
                lem.setLocal(rs.getString("local"));
                lem.setAssunto(rs.getString("assunto"));
                lem.setDescricao(rs.getString("descricao"));
                lem.setCliente(ClienteDao.getObj(rs.getInt("id_pessoa")));
                lem.setProcesso(ProcessoDao.getObj(rs.getInt("id_processo")));
                lem.setFuncionario(FuncionarioDao.getObj(rs.getInt("id_funcionario")));
                lembretes.add(lem);
            }
            st.close();
            System.out.println("Operação realizada com sucesso!");
            conn.close();
            return lembretes;
        } catch (Exception e) {
            System.err.println(e.getMessage());
            e.printStackTrace();
        }
        return null;
    }

    public ArrayList<Lembrete> lembrar() {
        try {
            Connection conn = ConnectFactory.getConnection();
            String query = "SELECT * FROM lembrete"
                            +" WHERE data <= '" 
                            + new java.text.SimpleDateFormat("yyyy-MM-dd").format(new java.util.Date())+"'";
            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery(query);
            ArrayList<Lembrete> lembretes = new ArrayList<>();
            while (rs.next()) {
                Lembrete lem = new Lembrete();
                lem.setId(rs.getInt("id"));
                lem.setData(rs.getDate("data"));
                lem.setHora(rs.getTime("hora"));
                lem.setLocal(rs.getString("local"));
                lem.setAssunto(rs.getString("assunto"));
                lem.setDescricao(rs.getString("descricao"));
                lem.setCliente(ClienteDao.getObj(rs.getInt("id_pessoa")));
                lem.setProcesso(ProcessoDao.getObj(rs.getInt("id_processo")));
                lem.setFuncionario(FuncionarioDao.getObj(rs.getInt("id_funcionario")));
                lembretes.add(lem);
            }
            st.close();
            System.out.println("Operação realizada com sucesso!");
            conn.close();
            return lembretes;
        } catch (Exception e) {
            System.err.println(e.getMessage());
            e.printStackTrace();
        }
        return null;
    }
    
    public static Lembrete getObj(int id) {
	try {
            Connection conn = ConnectFactory.getConnection();
            String query = "SELECT * FROM lembrete WHERE id = " + id;
            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery(query);
            if (rs.next()) {
                Lembrete lem = new Lembrete();
                lem.setId(rs.getInt("id"));
                lem.setData(rs.getDate("data"));
                lem.setHora(rs.getTime("hora"));
                lem.setLocal(rs.getString("local"));
                lem.setAssunto(rs.getString("assunto"));
                lem.setDescricao(rs.getString("descricao"));
                lem.setCliente(ClienteDao.getObj(rs.getInt("id_pessoa")));
                lem.setProcesso(ProcessoDao.getObj(rs.getInt("id_processo")));
                lem.setFuncionario(FuncionarioDao.getObj(rs.getInt("id_funcionario")));
           		st.close();              
                conn.close();
           		return lem;
            }
        } catch (Exception e) {
            System.err.println(e.getMessage());
            e.printStackTrace();
        }
        return null;
    }
}
