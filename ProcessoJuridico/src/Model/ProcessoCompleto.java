package Model;

/**
 *
 * @author brucce
 */
public class ProcessoCompleto extends Processo {

    private String posicaoCliente;
    private String adverso;
    private String posicaoAdverso;
    private String advogadoAdverso;
    private String localidadeFaseAtual;
    private String forumFaseAtual;
    private String vara;
    
    public String getPosicaoCliente() {
        return posicaoCliente;
    }

    public void setPosicaoCliente(String posicaoCliente) {
        this.posicaoCliente = posicaoCliente;
    }

    public String getAdverso() {
        return adverso;
    }

    public void setAdverso(String adverso) {
        this.adverso = adverso;
    }

    public String getPosicaoAdverso() {
        return posicaoAdverso;
    }

    public void setPosicaoAdverso(String posicaoAdverso) {
        this.posicaoAdverso = posicaoAdverso;
    }

    public String getAdvogadoAdverso() {
        return advogadoAdverso;
    }

    public void setAdvogadoAdverso(String advogadoAdverso) {
        this.advogadoAdverso = advogadoAdverso;
    }

    public String getLocalidadeFaseAtual() {
        return localidadeFaseAtual;
    }

    public void setLocalidadeFaseAtual(String localidadeFaseAtual) {
        this.localidadeFaseAtual = localidadeFaseAtual;
    }

    public String getForumFaseAtual() {
        return forumFaseAtual;
    }

    public void setForumFaseAtual(String forumFaseAtual) {
        this.forumFaseAtual = forumFaseAtual;
    }

    public String getVara() {
        return vara;
    }

    public void setVara(String vara) {
        this.vara = vara;
    }
    
}
