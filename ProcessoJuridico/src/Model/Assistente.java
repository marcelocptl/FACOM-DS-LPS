package Model;

import java.sql.Date;

public class Assistente extends Funcionario {

    public Assistente() {
    }

    public Assistente(int rg, int cpf, Date dataNascimento, String estadoCivil, int ramal, int codigo, String nome, String endereco, String cidade, String estado, String cep, String complemento, String telefoneCelular, String telefoneResidencial, String email, String usuario, String senha) {
        super(rg, cpf, dataNascimento, estadoCivil, ramal, codigo, nome, endereco, cidade, estado, cep, complemento, telefoneCelular, telefoneResidencial, email, usuario, senha);
    }
    
    public String atualizarLimitadoProcesso() {
        return null;
    }

}
