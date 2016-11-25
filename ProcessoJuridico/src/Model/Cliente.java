package Model;

import java.util.List;

/**
 * @author brucce
 */
public class Cliente extends Pessoa{

    private String documentoPessoal;
    private java.util.List<Lembrete> lembretes;

    public Cliente() {
    }
    
    public Cliente(int codigo, String nome, String endereco, String cidade, String estado, String cep, String complemento, String telefoneCelular, String telefoneResidencial, String email, String usuario, String senha) {
        super(codigo, nome, endereco, cidade, estado, cep, complemento, telefoneCelular, telefoneResidencial, email, usuario, senha);
    }
    
    public String getDocumentoPessoal() {
        return documentoPessoal;
    }

    public void setDocumentoPessoal(String documentoPessoal) {
        this.documentoPessoal = documentoPessoal;
    }

    public List<Lembrete> getLembretes() {
        return lembretes;
    }

    public void setLembretes(List<Lembrete> lembretes) {
        this.lembretes = lembretes;
    }

    public List<Processo> listarProcessos() {
        return null;
    }    
}
