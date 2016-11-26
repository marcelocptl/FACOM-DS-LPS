package Dao;

import Model.Advogado;
import java.util.ArrayList;
import Model.Processo;
import Model.Cliente;
import Model.ProcessoCompleto;
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
            String query = "insert into processo (numero, numeroaux, reclamada, descricao, situacao, observacao, cidade, fase, datainicial, datafinal, documento, id_tipoprocesso, id_pessoa, id_advogado";
            query += novo.getAssistente() == null ? "" : ", id_assistente";
            query += ") values (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?";
            query += novo.getAssistente() == null ? "" : ", ?";
            query += ")";
            PreparedStatement preparedStmt = conn.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
            preparedStmt.setString(1, novo.getNumero());
            preparedStmt.setString(2, novo.getNumeroAux());
            preparedStmt.setString(3, novo.getReclamada());
            preparedStmt.setString(4, novo.getDescricao());
            preparedStmt.setString(5, novo.getSituacao());
            preparedStmt.setString(6, novo.getObservacao());
            preparedStmt.setString(7, novo.getCidade());
            preparedStmt.setString(8, novo.getFase());
            preparedStmt.setDate(9, novo.getDataInicial());
            preparedStmt.setDate(10, novo.getDataFinal());
            preparedStmt.setString(11, novo.getDocumentos());
            preparedStmt.setInt(12, novo.getTipoProcesso().getId());
            preparedStmt.setInt(13, novo.getCliente().getId());
            preparedStmt.setInt(14, novo.getAdvogado().getId());
            if(novo.getAssistente() != null){
                preparedStmt.setInt(15, novo.getAssistente().getId());
            }
            preparedStmt.execute();
            final ResultSet rs = preparedStmt.getGeneratedKeys();
            if (rs.next()) {
                return rs.getInt(1);
            }
        } catch (Exception e) {
            //System.err.println("Ocorreu uma exceção!");
            //System.err.println(e.getMessage());
            //e.printStackTrace();
        }
        return -1;
    }

    public int deletar(Processo antigo) {
        try {
            Connection conn = ConnectFactory.getConnection();
            String query = "delete processo where id = ?";
            PreparedStatement preparedStmt = conn.prepareStatement(query);
            preparedStmt.setInt(1, antigo.getId());
            preparedStmt.execute();
            conn.close();
            return antigo.getId();
        } catch (Exception e) {
            //System.err.println("Ocorreu uma exceção!");
            //System.err.println(e.getMessage());
        }
        return -1;
    }

    public int atualizar(Processo atual) {
        try {
            Connection conn = ConnectFactory.getConnection();
            String query = "update processo set numero = ?, numeroaux = ?, reclamada = ?, descricao = ?, situacao = ?, observacao = ?, cidade = ?, fase = ?, datainicial = ?, datafinal = ?, documento = ?, id_tipoprocesso = ?, id_pessoa = ?, id_advogado = ?, id_assistente = ? where id = ?";
            PreparedStatement preparedStmt = conn.prepareStatement(query);
            preparedStmt.setString(1, atual.getNumero());
            preparedStmt.setString(2, atual.getNumeroAux());
            preparedStmt.setString(3, atual.getReclamada());
            preparedStmt.setString(4, atual.getDescricao());
            preparedStmt.setString(5, atual.getSituacao());
            preparedStmt.setString(6, atual.getObservacao());
            preparedStmt.setString(7, atual.getCidade());
            preparedStmt.setString(8, atual.getFase());
            preparedStmt.setDate(9, atual.getDataInicial());
            preparedStmt.setDate(10, atual.getDataFinal());
            preparedStmt.setString(11, atual.getDocumentos());
            preparedStmt.setInt(12, atual.getTipoProcesso().getId());
            preparedStmt.setInt(13, atual.getCliente().getId());
            preparedStmt.setInt(14, atual.getAdvogado().getId());
            preparedStmt.setInt(15, atual.getAssistente().getId());
            preparedStmt.setInt(16, atual.getId());

            preparedStmt.executeUpdate();
            conn.close();
            return atual.getId();
        } catch (Exception e) {
            //System.err.println("Ocorrtamoeu uma exceção!");
            //System.err.println(e.getMessage());
        }
        return -1;
    }

    public static Processo getObj(int id) {
	try {
            Connection conn = ConnectFactory.getConnection();
            String query = "SELECT * FROM processo WHERE id = " + id;
            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery(query);
            if (rs.next()) {
                Processo proc = new Processo();
                proc.setId(rs.getInt("id"));
                proc.setNumero(rs.getString("numero"));
                proc.setNumeroAux(rs.getString("numeroaux"));
                proc.setReclamada(rs.getString("reclamada"));
                proc.setDescricao(rs.getString("descricao"));
                proc.setSituacao(rs.getString("situacao"));
                proc.setTipoProcesso(TipoProcessoDao.getObj(rs.getInt("id_tipoprocesso")));
                proc.setCliente(ClienteDao.getObj(rs.getInt("id_pessoa")));
                proc.setAdvogado((Advogado) FuncionarioDao.getObj(rs.getInt("id_advogado")));
                proc.setFuncionario(FuncionarioDao.getObj(rs.getInt("id_funcionario")));
           	st.close();
           	conn.close();
           	return proc;
            }
        } catch (Exception e) {
            //System.err.println("Ocorreu uma exceção!");
            //System.err.println(e.getMessage());
        }
        return null;
    }

    public ArrayList<Processo> listar() {
        try {
            Connection conn = ConnectFactory.getConnection();
            String query = "SELECT * FROM processo";
            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery(query);
            ArrayList<Processo> processos = new ArrayList<>();
            while (rs.next()) {
                Processo proc = new Processo();
                proc.setId(rs.getInt("id"));
                proc.setNumero(rs.getString("numero"));
                proc.setNumeroAux(rs.getString("numeroaux"));
                proc.setReclamada(rs.getString("reclamada"));
                proc.setDescricao(rs.getString("descricao"));
                proc.setSituacao(rs.getString("situacao"));
                proc.setTipoProcesso(TipoProcessoDao.getObj(rs.getInt("id_tipoprocesso")));
                proc.setCliente(ClienteDao.getObj(rs.getInt("id_pessoa")));
                proc.setAdvogado((Advogado) FuncionarioDao.getObj(rs.getInt("id_advogado")));
                proc.setFuncionario(FuncionarioDao.getObj(rs.getInt("id_funcionario")));
                processos.add(proc);
            }
            st.close();
            conn.close();
            return processos;
        } catch (Exception e) {
            //System.err.println("Ocorreu uma exceção!");
            //System.err.println(e.getMessage());
        }
        return null;
    }

    public ArrayList<Processo> filtrar(String string) {
        try {
            Connection conn = ConnectFactory.getConnection();
            String query = "SELECT processo.* FROM processo INNER JOIN pessoa ON pessoa.id = processo.id_pessoa WHERE numero LIKE '" + string +"' OR numeroaux LIKE '" + string +"' OR reclamada LIKE '%" + string +"%' OR pessoa.nome LIKE '%" + string +"%' ";
            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery(query);
            ArrayList<Processo> processos = new ArrayList<>();
            while (rs.next()) {
                Processo proc = new Processo();
                proc.setId(rs.getInt("id"));
                proc.setNumero(rs.getString("numero"));
                proc.setNumeroAux(rs.getString("numeroaux"));
                proc.setReclamada(rs.getString("reclamada"));
                proc.setDescricao(rs.getString("descricao"));
                proc.setSituacao(rs.getString("situacao"));
                proc.setTipoProcesso(TipoProcessoDao.getObj(rs.getInt("id_tipoprocesso")));
                proc.setCliente(ClienteDao.getObj(rs.getInt("id_pessoa")));
                proc.setAdvogado((Advogado) FuncionarioDao.getObj(rs.getInt("id_advogado")));
                proc.setFuncionario(FuncionarioDao.getObj(rs.getInt("id_funcionario")));
                processos.add(proc);
            }
            st.close();
            conn.close();
            return processos;
        } catch (Exception e) {
            //System.err.println("Ocorreu uma exceção!");
            //System.err.println(e.getMessage());
        }
        return null;
    }

    public ArrayList<Processo> relatorioProcessos(String situacao) {
        try {
            Connection conn = ConnectFactory.getConnection();
            String query = "SELECT * FROM processo ORDER BY id_tipoprocesso";
            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery(query);
            ArrayList<Processo> processos = new ArrayList<>();
            while (rs.next()) {
                Processo proc = new Processo();
                proc.setId(rs.getInt("id"));
                proc.setNumero(rs.getString("numero"));
                proc.setNumeroAux(rs.getString("numeroaux"));
                proc.setReclamada(rs.getString("reclamada"));
                proc.setDescricao(rs.getString("descricao"));
                proc.setSituacao(rs.getString("situacao"));
                proc.setTipoProcesso(TipoProcessoDao.getObj(rs.getInt("id_tipoprocesso")));
                proc.setCliente(ClienteDao.getObj(rs.getInt("id_pessoa")));
                proc.setAdvogado((Advogado) FuncionarioDao.getObj(rs.getInt("id_advogado")));
                proc.setFuncionario(FuncionarioDao.getObj(rs.getInt("id_funcionario")));
                processos.add(proc);
            }
            st.close();
            conn.close();
            return processos;
        } catch (Exception e) {
            //System.err.println("Ocorreu uma exceção!");
            //System.err.println(e.getMessage());
        }
        return null;
    }

    public ArrayList<Processo> relatorioConcluido(boolean pago) {
        try {
            Connection conn = ConnectFactory.getConnection();
            String query = "SELECT processo.* FROM processo INNER JOIN Honorario ON processo.id = honorario.id_processo WHERE datapagamento IS ";
	    query += pago ? "NOT NULL" : "NULL";
            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery(query);
            ArrayList<Processo> processos = new ArrayList<>();
            while (rs.next()) {
                Processo proc = new Processo();
                proc.setId(rs.getInt("id"));
                proc.setNumero(rs.getString("numero"));
                proc.setNumeroAux(rs.getString("numeroaux"));
                proc.setReclamada(rs.getString("reclamada"));
                proc.setDescricao(rs.getString("descricao"));
                proc.setSituacao(rs.getString("situacao"));
                proc.setTipoProcesso(TipoProcessoDao.getObj(rs.getInt("id_tipoprocesso")));
                proc.setCliente(ClienteDao.getObj(rs.getInt("id_pessoa")));
                proc.setAdvogado((Advogado) FuncionarioDao.getObj(rs.getInt("id_advogado")));
                proc.setFuncionario(FuncionarioDao.getObj(rs.getInt("id_funcionario")));
                processos.add(proc);
            }
            st.close();
            conn.close();
            return processos;
        } catch (Exception e) {
            //System.err.println("Ocorreu uma exceção!");
            //System.err.println(e.getMessage());
        }
        return null;
    }

    public ArrayList<Processo> listarPorPessoa(Cliente c) {
        try {
            Connection conn = ConnectFactory.getConnection();
            String query = "SELECT * FROM processo WHERE id_pessoa = " + c.getId();
            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery(query);
            ArrayList<Processo> processos = new ArrayList<>();
            while (rs.next()) {
                Processo proc = new Processo();
                proc.setId(rs.getInt("id"));
                proc.setNumero(rs.getString("numero"));
                proc.setNumeroAux(rs.getString("numeroaux"));
                proc.setReclamada(rs.getString("reclamada"));
                proc.setDescricao(rs.getString("descricao"));
                proc.setSituacao(rs.getString("situacao"));
                proc.setTipoProcesso(TipoProcessoDao.getObj(rs.getInt("id_tipoprocesso")));
                proc.setCliente(ClienteDao.getObj(rs.getInt("id_pessoa")));
                proc.setAdvogado((Advogado) FuncionarioDao.getObj(rs.getInt("id_advogado")));
                proc.setFuncionario(FuncionarioDao.getObj(rs.getInt("id_funcionario")));
                processos.add(proc);
            }
            st.close();
            conn.close();
            return processos;
        } catch (Exception e) {
            //System.err.println("Ocorreu uma exceção!");
            //System.err.println(e.getMessage());
        }
        return null;
    }

    public int inserir(ProcessoCompleto novo) {
        try {
	    int id = inserir((Processo)novo);
            Connection conn = ConnectFactory.getConnection();
            String query = "insert into processocompleto (id, posicaoclientecomp, adversocomp, posicaoadversocomp, advogadoadversocomp, localidadefaseatualcomp, forumfaseatualcomp, varacomp) values (?, ?, ?, ?, ?, ?, ?, ?)";
            PreparedStatement preparedStmt = conn.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
            preparedStmt.setInt(1, id);
            preparedStmt.setString(2, novo.getPosicaoCliente());
            preparedStmt.setString(3, novo.getAdverso());
            preparedStmt.setString(4, novo.getPosicaoAdverso());
            preparedStmt.setString(5, novo.getAdvogadoAdverso());
            preparedStmt.setString(6, novo.getLocalidadeFaseAtual());
            preparedStmt.setString(7, novo.getForumFaseAtual());
            preparedStmt.setString(8, novo.getVara());
            return id;
        } catch (Exception e) {
            //System.err.println("Ocorreu uma exceção!");
            //System.err.println(e.getMessage());
            //e.printStackTrace();
        }
        return -1;
    }
}
