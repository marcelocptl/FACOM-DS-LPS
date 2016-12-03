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
            String query = "insert into tipoprocesso (descricao) values (?)";
            PreparedStatement preparedStmt = conn.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
            preparedStmt.setString(1, novo.getDescricao());
            preparedStmt.execute();
            final ResultSet rs = preparedStmt.getGeneratedKeys();
            if (rs.next()) {
                system.out.println("Operação realizada com sucesso!");
                conn.close();
                return rs.getInt(1);
            }
        } catch (Exception e) {
            system.err.println(e.getMessage());
            e.printStackTrace();
        }
        return -1;
    }
    
    public static TipoProcesso getObj(int id){
	try {
            Connection conn = ConnectFactory.getConnection();
            String query = "SELECT * FROM Tipoprocesso WHERE id = " + id;
            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery(query);
            if (rs.next()) {
                TipoProcesso tp = new TipoProcesso();
                tp.setId(rs.getInt("id"));
                tp.setDescricao(rs.getString("descricao"));
           	st.close();
                system.out.println("Operação realizada com sucesso!");
                conn.close();
           	return tp;
            }
            st.close();
            conn.close();
        } catch (Exception e) {
            system.err.println(e.getMessage());
            e.printStackTrace();
        }
        return null;
    }
}
