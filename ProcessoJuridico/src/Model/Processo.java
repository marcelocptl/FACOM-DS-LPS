package Model;

import Dao.ProcessoDao;
import java.sql.Date;
import java.util.ArrayList;

/**
 *
 * @author brucce
 */
public class Processo {
    
    private int id;
    private String numero;
    private String numeroAux;
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
    private Funcionario funcionario;
    private Assistente assistente;

    public Processo() {
    }

    public Processo(int id, String numero, String numeroAux, String reclamada, String descricao, String situacao, String observacao, String cidade, String fase, Date dataInicial, Date dataFinal, String documentos, Cliente cliente, Advogado advogado, TipoProcesso tipoProcesso, Funcionario funcionario, Assistente assistente) {
        this.id = id;
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
        this.funcionario = funcionario;
        this.assistente = assistente;
    }

    public int inserir(){
        setId(new ProcessoDao().inserir(this));
        return getId();
    }
    public int deletar(){
        return new ProcessoDao().deletar(this);
    }
    public int atualizar(){
        return new ProcessoDao().atualizar(this);
    }

    public ArrayList<Processo> listar(){
        return new ProcessoDao().listar();
    }
    
    public ArrayList<Processo> filtrar(String string){
        return new ProcessoDao().filtrar(string);
    }
    
    public ArrayList<Processo> relatorioProcessos(String situacao) {
        return new ProcessoDao().relatorioProcessos(situacao);
    }
    
    public ArrayList<Processo> relatorioConcluido(boolean pago){
        return new ProcessoDao().relatorioConcluido(pago);
    }
    
    public ArrayList<Processo> listarPorPessoa(Cliente c){
        return new ProcessoDao().listarPorPessoa(c);
    }
    
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public String getNumeroAux() {
        return numeroAux;
    }

    public void setNumeroAux(String numeroAux) {
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
}
