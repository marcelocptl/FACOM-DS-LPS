package Model;

import Dao.ClienteDao;
import java.sql.Date;
import java.util.ArrayList;

/**
 *
 * @author brucce
 */
public class PessoaFisica extends Cliente {

    private String rg;
    private String cpf;
    private Date dataNascimento;
    private String estadoCivil;

    public PessoaFisica() {
    }

    public PessoaFisica(String rg, String cpf, Date dataNascimento, String estadoCivil, int id, String nome, String endereco, String cidade, String estado, String cep, String complemento, String telefoneCelular, String telefoneResidencial, String email, String usuario, String senha) {
        super(id, nome, endereco, cidade, estado, cep, complemento, telefoneCelular, telefoneResidencial, email, usuario, senha);
        this.rg = rg;
        this.cpf = cpf;
        this.dataNascimento = dataNascimento;
        this.estadoCivil = estadoCivil;
    }
    
    public int inserir() {
        setId(new ClienteDao().inserir(this));
        return getId();
    }
    
    public String getRg() {
        return rg;
    }

    public void setRg(String rg) {
        this.rg = rg;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public Date getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(Date dataNascimento) {
        this.dataNascimento = dataNascimento;
    }

    public String getEstadoCivil() {
        return estadoCivil;
    }

    public void setEstadoCivil(String estadoCivil) {
        this.estadoCivil = estadoCivil;
    }

}
