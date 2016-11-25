package Dao;

import Model.TipoProcesso;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import util.ConnectFactory;

/**
 *
 * @author brucce
 */
public class TipoProcessoDao {

    public int inserir(TipoProcesso novo) {
        try {
            Connection conn = ConnectFactory.getConnection();
            String query = "insert into Tipoprocesso (descricaoa) values (?)";
            PreparedStatement preparedStmt = conn.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
            preparedStmt.setString(1, novo.getDescricao());
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

    public int deletar(TipoProcesso antigo) {
        return -1;
    }

    public int atualizar(TipoProcesso atual) {
        return -1;
    }
    
    public static TipoProcesso getCodigo(int id){
        return null;
    }

    public ArrayList<TipoProcesso> listar() {
        return null;
    }
}
