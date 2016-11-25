package Model;

import Dao.FuncionarioDao;

public class Advogado extends Funcionario {

    private int numRegistroOAB;

    private String situacaoRegistroOAB;

    public Advogado() {
    }
    
    public int inserir(){
        return new FuncionarioDao().inserir(this);
    }
   
    public int getNumRegistroOAB() {
        return numRegistroOAB;
    }

    public void setNumRegistroOAB(int numRegistroOAB) {
        this.numRegistroOAB = numRegistroOAB;
    }

    public String getSituacaoRegistroOAB() {
        return situacaoRegistroOAB;
    }

    public void setSituacaoRegistroOAB(String situacaoRegistroOAB) {
        this.situacaoRegistroOAB = situacaoRegistroOAB;
    }

    

}
