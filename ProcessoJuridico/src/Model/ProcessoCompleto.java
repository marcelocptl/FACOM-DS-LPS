package Model;

import java.sql.Date;
import java.util.ArrayList;

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

    public ProcessoCompleto(String posicaoCliente, String adverso, String posicaoAdverso, String advogadoAdverso, String localidadeFaseAtual, String forumFaseAtual, String vara, int numero, int numeroAux, String reclamada, String descricao, String situacao, String observacao, String cidade, String fase, Date dataInicial, Date dataFinal, String documentos, Cliente cliente, Advogado advogado, TipoProcesso tipoProcesso, Funcionario funcionario, Assistente assistente) {
        super(numero, numeroAux, reclamada, descricao, situacao, observacao, cidade, fase, dataInicial, dataFinal, documentos, cliente, advogado, tipoProcesso, funcionario, assistente);
        this.posicaoCliente = posicaoCliente;
        this.adverso = adverso;
        this.posicaoAdverso = posicaoAdverso;
        this.advogadoAdverso = advogadoAdverso;
        this.localidadeFaseAtual = localidadeFaseAtual;
        this.forumFaseAtual = forumFaseAtual;
        this.vara = vara;
    }
    
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
