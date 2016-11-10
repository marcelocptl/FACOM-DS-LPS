package Model;

import java.util.List;

/**
 * @author brucce
 */
public class Cliente extends Pessoa{

    private String documentoPessoal;
    private java.util.List<Lembrete> lembretes;

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
