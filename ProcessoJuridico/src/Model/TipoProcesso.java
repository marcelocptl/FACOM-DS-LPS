package Model;

import Dao.TipoProcessoDao;

/**
 *
 * @author brucce
 */
public class TipoProcesso {
    private int id;
    private String descricao;

    public TipoProcesso() {
    }

    public TipoProcesso(int id, String descricao) {
        this.id = id;
        this.descricao = descricao;
    }
    
    public int inserir(){
        setId(new TipoProcessoDao().inserir(this));
        return getId();
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }
}
