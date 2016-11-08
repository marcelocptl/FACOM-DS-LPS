package Model;

import java.sql.Date;
import java.util.ArrayList;

/**
 *
 * @author brucce
 */
public class Honorario {

    private int codigo;
    private Double valor;
    private Date dataVencimento;
    private Date dataPagamento;

    public Honorario() {
    }

    public Honorario(int codigo, Double valor, Date dataVencimento, Date dataPagamento) {
        this.codigo = codigo;
        this.valor = valor;
        this.dataVencimento = dataVencimento;
        this.dataPagamento = dataPagamento;
    }
    
    public Honorario(Double valor, Date dataVencimento, Date dataPagamento) {
        this.valor = valor;
        this.dataVencimento = dataVencimento;
        this.dataPagamento = dataPagamento;
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public Double getValor() {
        return valor;
    }

    public void setValor(Double valor) {
        this.valor = valor;
    }

    public Date getDataVencimento() {
        return dataVencimento;
    }

    public void setDataVencimento(Date dataVencimento) {
        this.dataVencimento = dataVencimento;
    }

    public Date getDataPagamento() {
        return dataPagamento;
    }

    public void setDataPagamento(Date dataPagamento) {
        this.dataPagamento = dataPagamento;
    }
    
    public ArrayList<Honorario> listar(boolean pago){
        return null;
    }
}
