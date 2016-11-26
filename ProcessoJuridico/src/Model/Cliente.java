package Model;

import java.util.List;

/**
 * @author brucce
 */
public class Cliente extends Pessoa{

    private String documentoPessoal;

    public Cliente() {
    }
    
    public Cliente(int id, String nome, String endereco, String cidade, String estado, String cep, String complemento, String telefoneCelular, String telefoneResidencial, String email, String usuario, String senha) {
        super(id, nome, endereco, cidade, estado, cep, complemento, telefoneCelular, telefoneResidencial, email, usuario, senha);
    }
    
    public String getDocumentoPessoal() {
        return documentoPessoal;
    }

    public void setDocumentoPessoal(String documentoPessoal) {
        this.documentoPessoal = documentoPessoal;
    }
   
}
