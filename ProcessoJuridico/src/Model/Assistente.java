package Model;

import Dao.FuncionarioDao;
import java.sql.Date;

public class Assistente extends Funcionario {

    public Assistente() {
    }

    public Assistente(String rg, String cpf, Date dataNascimento, String estadoCivil, int ramal, int id, String nome, String endereco, String cidade, String estado, String cep, String complemento, String telefoneCelular, String telefoneResidencial, String email, String usuario, String senha) {
        super(rg, cpf, dataNascimento, estadoCivil, ramal, id, nome, endereco, cidade, estado, cep, complemento, telefoneCelular, telefoneResidencial, email, usuario, senha);
    }        
    
    public int inserir(){
        setId(new FuncionarioDao().inserir(this));
        return getId();
    }

}
