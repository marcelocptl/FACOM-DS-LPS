package Model;

import Dao.FuncionarioDao;
import java.sql.Date;

public class Advogado extends Funcionario {

    private int numRegistroOAB;

    private String situacaoRegistroOAB;

    public Advogado() {
    }

    public Advogado(int numRegistroOAB, String situacaoRegistroOAB, String rg, String cpf, Date dataNascimento, String estadoCivil, int ramal, int id, String nome, String endereco, String cidade, String estado, String cep, String complemento, String telefoneCelular, String telefoneResidencial, String email, String usuario, String senha) {
        super(rg, cpf, dataNascimento, estadoCivil, ramal, id, nome, endereco, cidade, estado, cep, complemento, telefoneCelular, telefoneResidencial, email, usuario, senha);
        this.numRegistroOAB = numRegistroOAB;
        this.situacaoRegistroOAB = situacaoRegistroOAB;
    }
    
    public int inserir(){
        setId(new FuncionarioDao().inserir(this));
        return getId();
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
