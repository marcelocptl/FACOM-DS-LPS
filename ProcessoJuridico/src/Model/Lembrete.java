package Model;

import java.sql.Date;
import java.sql.Time;
import java.util.ArrayList;

/**
 *
 * @author brucce
 */
public class Lembrete {

    private Date data;
    private Time hora;
    private String local;
    private String assunto;
    private String descricao;
    private Cliente cliente;
    private Processo processo;
    private Funcionario funcionario;

    public Lembrete() {
    }

    public Lembrete(Date data, Time hora, String local, String assunto, String descricao, Cliente cliente, Processo processo, Funcionario funcionario) {
        this.data = data;
        this.hora = hora;
        this.local = local;
        this.assunto = assunto;
        this.descricao = descricao;
        this.cliente = cliente;
        this.processo = processo;
        this.funcionario = funcionario;
    }

    public Date getData() {
        return data;
    }

    public void setData(Date data) {
        this.data = data;
    }

    public Time getHora() {
        return hora;
    }

    public void setHora(Time hora) {
        this.hora = hora;
    }

    public String getLocal() {
        return local;
    }

    public void setLocal(String local) {
        this.local = local;
    }

    public String getAssunto() {
        return assunto;
    }

    public void setAssunto(String assunto) {
        this.assunto = assunto;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public Processo getProcesso() {
        return processo;
    }

    public void setProcesso(Processo processo) {
        this.processo = processo;
    }

    public Funcionario getFuncionario() {
        return funcionario;
    }

    public void setFuncionario(Funcionario funcionario) {
        this.funcionario = funcionario;
    }
    
    public ArrayList<Lembrete> lembrar() {
        return null;
    }
}
