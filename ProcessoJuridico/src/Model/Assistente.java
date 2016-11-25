package Model;

import Dao.FuncionarioDao;

public class Assistente extends Funcionario {

    public Assistente() {
    }
    
    public int inserir(){
        setCodigo(new FuncionarioDao().inserir(this));
        return getCodigo();
    }
    
    public String atualizarLimitadoProcesso() {
        return null;
    }

}
