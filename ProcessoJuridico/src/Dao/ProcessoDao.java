package Dao;

import Model.Advogado;
import Model.Lembrete;
import java.util.ArrayList;
import Model.Processo;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import util.ConnectFactory;

/**
 *
 * @author brucce
 */
public class ProcessoDao {

    public int inserir(Processo novo) {
        try {
            Connection conn = ConnectFactory.getConnection();
            String query = "insert into Processo (numero, numeroaux, reclamada, descricao, situacao, observacao, cidade, fase, datainicial, datafinal, documento, id_tipoprocesso, id_pessoa, id_advogado, id_assistente) values (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
            PreparedStatement preparedStmt = conn.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
            preparedStmt.setInt(1, novo.getNumero());
            preparedStmt.setInt(2, novo.getNumeroAux());
            preparedStmt.setString(3, novo.getReclamada());
            preparedStmt.setString(4, novo.getDescricao());
            preparedStmt.setString(5, novo.getSituacao());
            preparedStmt.setString(6, novo.getObservacao());
            preparedStmt.setString(7, novo.getCidade());
            preparedStmt.setString(8, novo.getFase());
            preparedStmt.setDate(9, novo.getDataInicial());
            preparedStmt.setDate(10, novo.getDataFinal());
            preparedStmt.setString(11, novo.getDocumentos());
            preparedStmt.setInt(12, novo.getTipoProcesso().getCodigo());
            preparedStmt.setInt(13, novo.getCliente().getCodigo());
            preparedStmt.setInt(14, novo.getAdvogado().getCodigo());
            preparedStmt.setInt(15, novo.getAssistente().getCodigo());
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

    public int deletar(Processo antigo) {
        try {
            Connection conn = ConnectFactory.getConnection();
            String query = "delete Processo where id = ?";
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

    public int atualizar(Processo atual) {
        try {
            Connection conn = ConnectFactory.getConnection();
            String query = "update Processo set numero = ?, numeroaux = ?, reclamada = ?, descricao = ?, situacao = ?, observacao = ?, cidade = ?, fase = ?, datainicial = ?, datafinal = ?, documento = ?, id_tipoprocesso = ?, id_pessoa = ?, id_advogado = ?, id_assistente = ? where id = ?";
            PreparedStatement preparedStmt = conn.prepareStatement(query);
            preparedStmt.setInt(1, atual.getNumero());
            preparedStmt.setInt(2, atual.getNumeroAux());
            preparedStmt.setString(3, atual.getReclamada());
            preparedStmt.setString(4, atual.getDescricao());
            preparedStmt.setString(5, atual.getSituacao());
            preparedStmt.setString(6, atual.getObservacao());
            preparedStmt.setString(7, atual.getCidade());
            preparedStmt.setString(8, atual.getFase());
            preparedStmt.setDate(9, atual.getDataInicial());
            preparedStmt.setDate(10, atual.getDataFinal());
            preparedStmt.setString(11, atual.getDocumentos());
            preparedStmt.setInt(12, atual.getTipoProcesso().getCodigo());
            preparedStmt.setInt(13, atual.getCliente().getCodigo());
            preparedStmt.setInt(14, atual.getAdvogado().getCodigo());
            preparedStmt.setInt(15, atual.getAssistente().getCodigo());
            preparedStmt.setInt(16, atual.getCodigo());

            preparedStmt.executeUpdate();
            conn.close();
            return atual.getCodigo();
        } catch (Exception e) {
            System.err.println("Ocorrtamoeu uma exceção!");
            System.err.println(e.getMessage());
        }
        return -1;
    }

    public static Processo getCodigo(int id) {
        return null;
    }

    public ArrayList<Processo> listar() {
        try {
            Connection conn = ConnectFactory.getConnection();
            String query = "SELECT * FROM Processo";
            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery(query);
            ArrayList<Processo> processos = new ArrayList<>();
            while (rs.next()) {
                Processo proc = new Processo();
                proc.setCodigo(rs.getInt("id"));
                proc.setNumero(rs.getInt("numero"));
                proc.setNumeroAux(rs.getInt("numeroaux"));
                proc.setReclamada(rs.getString("reclamada"));
                proc.setDescricao(rs.getString("descricao"));
                proc.setSituacao(rs.getString("situacao"));
                proc.setTipoProcesso(TipoProcessoDao.getCodigo(rs.getInt("id_tipoprocesso")));
                proc.setCliente(ClienteDao.getCodigo(rs.getInt("id_pessoa")));
                proc.setAdvogado((Advogado) FuncionarioDao.getCodigo(rs.getInt("id_advogado")));
                proc.setFuncionario(FuncionarioDao.getCodigo(rs.getInt("id_funcionario")));
                processos.add(proc);
            }
            st.close();
            conn.close();
            return processos;
        } catch (Exception e) {
            System.err.println("Ocorreu uma exceção!");
            System.err.println(e.getMessage());
        }
        return null;
    }

    public ArrayList<Processo> filtrar(String string) {
        try {
            Connection conn = ConnectFactory.getConnection();
            String query = "SELECT * FROM Processo";
            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery(query);
            ArrayList<Processo> processos = new ArrayList<>();
            while (rs.next()) {
                Processo proc = new Processo();
                proc.setCodigo(rs.getInt("id"));
                proc.setNumero(rs.getInt("numero"));
                proc.setNumeroAux(rs.getInt("numeroaux"));
                proc.setReclamada(rs.getString("reclamada"));
                proc.setDescricao(rs.getString("descricao"));
                proc.setSituacao(rs.getString("situacao"));
                proc.setTipoProcesso(TipoProcessoDao.getCodigo(rs.getInt("id_tipoprocesso")));
                proc.setCliente(ClienteDao.getCodigo(rs.getInt("id_pessoa")));
                proc.setAdvogado((Advogado) FuncionarioDao.getCodigo(rs.getInt("id_advogado")));
                proc.setFuncionario(FuncionarioDao.getCodigo(rs.getInt("id_funcionario")));
                processos.add(proc);
            }
            st.close();
            conn.close();
            return processos;
        } catch (Exception e) {
            System.err.println("Ocorreu uma exceção!");
            System.err.println(e.getMessage());
        }
        return null;
    }

    public ArrayList<Processo> relatorioProcessos(String situacao) {
        try {
            Connection conn = ConnectFactory.getConnection();
            String query = "SELECT * FROM Processo";
            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery(query);
            ArrayList<Processo> processos = new ArrayList<>();
            while (rs.next()) {
                Processo proc = new Processo();
                proc.setCodigo(rs.getInt("id"));
                proc.setNumero(rs.getInt("numero"));
                proc.setNumeroAux(rs.getInt("numeroaux"));
                proc.setReclamada(rs.getString("reclamada"));
                proc.setDescricao(rs.getString("descricao"));
                proc.setSituacao(rs.getString("situacao"));
                proc.setTipoProcesso(TipoProcessoDao.getCodigo(rs.getInt("id_tipoprocesso")));
                proc.setCliente(ClienteDao.getCodigo(rs.getInt("id_pessoa")));
                proc.setAdvogado((Advogado) FuncionarioDao.getCodigo(rs.getInt("id_advogado")));
                proc.setFuncionario(FuncionarioDao.getCodigo(rs.getInt("id_funcionario")));
                processos.add(proc);
            }
            st.close();
            conn.close();
            return processos;
        } catch (Exception e) {
            System.err.println("Ocorreu uma exceção!");
            System.err.println(e.getMessage());
        }
        return null;
    }

    public ArrayList<Processo> relatorioConcluido(boolean pago) {
        try {
            Connection conn = ConnectFactory.getConnection();
            String query = "SELECT * FROM Processo";
            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery(query);
            ArrayList<Processo> processos = new ArrayList<>();
            while (rs.next()) {
                Processo proc = new Processo();
                proc.setCodigo(rs.getInt("id"));
                proc.setNumero(rs.getInt("numero"));
                proc.setNumeroAux(rs.getInt("numeroaux"));
                proc.setReclamada(rs.getString("reclamada"));
                proc.setDescricao(rs.getString("descricao"));
                proc.setSituacao(rs.getString("situacao"));
                proc.setTipoProcesso(TipoProcessoDao.getCodigo(rs.getInt("id_tipoprocesso")));
                proc.setCliente(ClienteDao.getCodigo(rs.getInt("id_pessoa")));
                proc.setAdvogado((Advogado) FuncionarioDao.getCodigo(rs.getInt("id_advogado")));
                proc.setFuncionario(FuncionarioDao.getCodigo(rs.getInt("id_funcionario")));
                processos.add(proc);
            }
            st.close();
            conn.close();
            return processos;
        } catch (Exception e) {
            System.err.println("Ocorreu uma exceção!");
            System.err.println(e.getMessage());
        }
        return null;
    }

    public ArrayList<Processo> listarPorPessoa(String string) {
        try {
            Connection conn = ConnectFactory.getConnection();
            String query = "SELECT * FROM Processo";
            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery(query);
            ArrayList<Processo> processos = new ArrayList<>();
            while (rs.next()) {
                Processo proc = new Processo();
                proc.setCodigo(rs.getInt("id"));
                proc.setNumero(rs.getInt("numero"));
                proc.setNumeroAux(rs.getInt("numeroaux"));
                proc.setReclamada(rs.getString("reclamada"));
                proc.setDescricao(rs.getString("descricao"));
                proc.setSituacao(rs.getString("situacao"));
                proc.setTipoProcesso(TipoProcessoDao.getCodigo(rs.getInt("id_tipoprocesso")));
                proc.setCliente(ClienteDao.getCodigo(rs.getInt("id_pessoa")));
                proc.setAdvogado((Advogado) FuncionarioDao.getCodigo(rs.getInt("id_advogado")));
                proc.setFuncionario(FuncionarioDao.getCodigo(rs.getInt("id_funcionario")));
                processos.add(proc);
            }
            st.close();
            conn.close();
            return processos;
        } catch (Exception e) {
            System.err.println("Ocorreu uma exceção!");
            System.err.println(e.getMessage());
        }
        return null;
    }
}
