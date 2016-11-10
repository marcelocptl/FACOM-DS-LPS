package Model;

import java.sql.Date;
import java.util.ArrayList;

/**
 *
 * @author brucce
 */
public class Processo {

    private int numero;
    private int numeroAux;
    private String reclamada;
    private String descricao;
    private String situacao;
    private String observacao;
    private String cidade;
    private String fase;
    private Date dataInicial;
    private Date dataFinal;
    private String documentos;
    private Cliente cliente;
    private Advogado advogado;
    private TipoProcesso tipoProcesso;
    private java.util.ArrayList<Honorario> honorarios;
    private Funcionario funcionario;
    private Assistente assistente;
    private java.util.ArrayList<Lembrete> lembretes;

    public Processo() {
    }

    public Processo(int numero, int numeroAux, String reclamada, String descricao, String situacao, String observacao, String cidade, String fase, Date dataInicial, Date dataFinal, String documentos, Cliente cliente, Advogado advogado, TipoProcesso tipoProcesso, ArrayList<Honorario> honorarios, Funcionario funcionario, Assistente assistente, ArrayList<Lembrete> lembretes) {
        this.numero = numero;
        this.numeroAux = numeroAux;
        this.reclamada = reclamada;
        this.descricao = descricao;
        this.situacao = situacao;
        this.observacao = observacao;
        this.cidade = cidade;
        this.fase = fase;
        this.dataInicial = dataInicial;
        this.dataFinal = dataFinal;
        this.documentos = documentos;
        this.cliente = cliente;
        this.advogado = advogado;
        this.tipoProcesso = tipoProcesso;
        this.honorarios = honorarios;
        this.funcionario = funcionario;
        this.assistente = assistente;
        this.lembretes = lembretes;
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public int getNumeroAux() {
        return numeroAux;
    }

    public void setNumeroAux(int numeroAux) {
        this.numeroAux = numeroAux;
    }

    public String getReclamada() {
        return reclamada;
    }

    public void setReclamada(String reclamada) {
        this.reclamada = reclamada;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getSituacao() {
        return situacao;
    }

    public void setSituacao(String situacao) {
        this.situacao = situacao;
    }

    public String getObservacao() {
        return observacao;
    }

    public void setObservacao(String observacao) {
        this.observacao = observacao;
    }

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public String getFase() {
        return fase;
    }

    public void setFase(String fase) {
        this.fase = fase;
    }

    public Date getDataInicial() {
        return dataInicial;
    }

    public void setDataInicial(Date dataInicial) {
        this.dataInicial = dataInicial;
    }

    public Date getDataFinal() {
        return dataFinal;
    }

    public void setDataFinal(Date dataFinal) {
        this.dataFinal = dataFinal;
    }

    public String getDocumentos() {
        return documentos;
    }

    public void setDocumentos(String documentos) {
        this.documentos = documentos;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public Advogado getAdvogado() {
        return advogado;
    }

    public void setAdvogado(Advogado advogado) {
        this.advogado = advogado;
    }

    public TipoProcesso getTipoProcesso() {
        return tipoProcesso;
    }

    public void setTipoProcesso(TipoProcesso tipoProcesso) {
        this.tipoProcesso = tipoProcesso;
    }

    public ArrayList<Honorario> getHonorarios() {
        return honorarios;
    }

    public void setHonorarios(ArrayList<Honorario> honorarios) {
        this.honorarios = honorarios;
    }

    public Funcionario getFuncionario() {
        return funcionario;
    }

    public void setFuncionario(Funcionario funcionario) {
        this.funcionario = funcionario;
    }

    public Assistente getAssistente() {
        return assistente;
    }

    public void setAssistente(Assistente assistente) {
        this.assistente = assistente;
    }

    public ArrayList<Lembrete> getLembretes() {
        return lembretes;
    }

    public void setLembretes(ArrayList<Lembrete> lembretes) {
        this.lembretes = lembretes;
    }

    public ArrayList<Processo> filtrar(String string){
        return null;
    }
    
    public ArrayList<Processo> relatorioProcesso(String situacao){
        return null;
    }
    
    public ArrayList<Processo> relatorioConcluido(boolean pago){
        return null;
    }
    
    public ArrayList<Processo> listarPorPessoa(String string){
        return null;
    }
}
