package view;

import Model.Advogado;
import Model.Lembrete;
import Model.PessoaFisica;
import Model.Processo;
import Model.TipoProcesso;
import java.sql.Connection;
import java.sql.Date;
import java.sql.SQLException;
import java.sql.Time;
import util.ConnectFactory;

public class main {

    public static void main(String args[]) throws SQLException {
        Connection connect = ConnectFactory.getConnection();
        System.out.println(connect.isClosed());

        PessoaFisica pf = new PessoaFisica();
        pf.setNome("Ricardo");
        pf.setEndereco("Rua X");
        pf.setCidade("Campo Grande");
        pf.setEstado("MS");
        pf.setComplemento("Casa da Frente");
        pf.setCep("XXXXXXXX");
        pf.setRg("XXXXXXXXX");
        pf.setCpf("XXXXXXXXXXX");
        pf.setDataNascimento(Date.valueOf("1992-01-01"));
        pf.setEstadoCivil("solteiro");
        pf.setEmail("mail@mail.com");
        pf.setTelefoneCelular("00000000000");
        pf.setTelefoneResidencial("0000000000");
        //pf.setDocumentoPessoal("ricardo.jpg");
        pf.setUsuario("ricardo");
        pf.setSenha("ricardo.1");

        //inserir no banco de dados
        if (pf.inserir() == -1) {
            System.out.println("Cliente não pode ser criado.");
        } else {
            System.out.println("Cliente criado com sucesso");
        }

        Advogado ad = new Advogado();
        ad.setNome("Fatima");
        ad.setEndereco("Rua J");
        ad.setCidade("Campo Grande");
        ad.setEstado("MS");
        ad.setComplemento("");
        ad.setCep("XXXXXXXX");
        ad.setRg("XXXXXXXXX");
        ad.setCpf("XXXXXXXXXXX");
        ad.setDataNascimento(Date.valueOf("1977-11-06"));
        ad.setEstadoCivil("casada");
        ad.setNumRegistroOAB(3436);
        ad.setRamal(1005);
        ad.setSituacaoRegistroOAB("ativo");
        ad.setEmail("mail@mail.com");
        ad.setTelefoneCelular("00000000000");
        ad.setTelefoneResidencial("0000000000");
        ad.setUsuario("fatima");
        ad.setSenha("fatima123");

        //inserir no banco de dados
        if (ad.inserir() == -1) {
            System.out.println("Advogado não pode ser criado.");
        } else {
            System.out.println("Advogado criado com sucesso");
        }

        TipoProcesso tipo_proc = new TipoProcesso();
        tipo_proc.setDescricao("Tipo do processo");
        if (tipo_proc.inserir() == -1) {
            System.out.println("Tipo do Processo não pode ser criado.");
        } else {
            System.out.println("Tipo do Processo criado com sucesso");
        }
        Processo proc = new Processo();
        proc.setNumero(2016112200);
        proc.setNumeroAux(2016112201);
        proc.setReclamada("Empresa False LTDA");
        proc.setDescricao("ocorreu....");
        proc.setCidade("minha cidade");
        proc.setDataInicial(Date.valueOf("2016-11-22"));
        proc.setCliente(pf);
        proc.setAdvogado(ad);
        proc.setTipoProcesso(tipo_proc);

        if (proc.inserir() == -1) {
            System.out.println("Processo não pode ser criado.");
        } else {
            System.out.println("Processo criado com sucesso");
        }

        Lembrete lem = new Lembrete();
        lem.setFuncionario(ad);
        lem.setCliente(pf);
        lem.setData(Date.valueOf("2016-11-22"));
        lem.setHora(Time.valueOf("12:00:00"));
        lem.setLocal("");
        lem.setAssunto("Atualizar Processo");
        lem.setDescricao("");
        lem.setProcesso(proc);
        lem.setCliente(pf);
        lem.setFuncionario(ad);

        //inserir no banco de dados
        if (lem.inserir() == -1) {
            System.out.println("Lembrete não pode ser criado.");
        } else {
            System.out.println("Lembrete criado com sucesso");
        }
        //atualizar
        lem.setHora(Time.valueOf("13:00:00"));
        if (lem.atualizar() == -1) {
            System.out.println("Lembrete não pode ser atualizado.");
        } else {
            System.out.println("Lembrete criado com atualizado");
        }
        //deletar
        if (lem.deletar() == -1) {
            System.out.println("Lembrete não pode ser deletado.");
        } else {
            System.out.println("Lembrete criado com deletado");
        }
        
        System.out.println("lembretes: " + lem.listar().size());
    }

}
