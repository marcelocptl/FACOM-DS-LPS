package Model;

import Dao.ClienteDao;

/**
 *
 * @author brucce
 */
public class PessoaJuridica extends Pessoa {

    private String cnpj;
    private int inscricaoEstadual;
    private int inscricaoMunicipal;
    private String site;
    private String nomeFantasia;

    public PessoaJuridica() {
    }

    public PessoaJuridica(String cnpj, int inscricaoEstadual, int inscricaoMunicipal, String site, String nomeFantasia, int codigo, String nome, String endereco, String cidade, String estado, String cep, String complemento, String telefoneCelular, String telefoneResidencial, String email, String usuario, String senha) {
        super(codigo, nome, endereco, cidade, estado, cep, complemento, telefoneCelular, telefoneResidencial, email, usuario, senha);
        this.cnpj = cnpj;
        this.inscricaoEstadual = inscricaoEstadual;
        this.inscricaoMunicipal = inscricaoMunicipal;
        this.site = site;
        this.nomeFantasia = nomeFantasia;
    }
    
    public int inserir() {
        return new ClienteDao().inserir(this);
    }
    
    public String getCnpj() {
        return cnpj;
    }

    public void setCnpj(String cnpj) {
        this.cnpj = cnpj;
    }

    public int getInscricaoEstadual() {
        return inscricaoEstadual;
    }

    public void setInscricaoEstadual(int inscricaoEstadual) {
        this.inscricaoEstadual = inscricaoEstadual;
    }

    public int getInscricaoMunicipal() {
        return inscricaoMunicipal;
    }

    public void setInscricaoMunicipal(int inscricaoMunicipal) {
        this.inscricaoMunicipal = inscricaoMunicipal;
    }

    public String getSite() {
        return site;
    }

    public void setSite(String site) {
        this.site = site;
    }

    public String getNomeFantasia() {
        return nomeFantasia;
    }

    public void setNomeFantasia(String nomeFantasia) {
        this.nomeFantasia = nomeFantasia;
    }
    
}
