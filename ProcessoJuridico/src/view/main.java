package view;

import Model.Advogado;
import Model.Lembrete;
import Model.PessoaFisica;
import java.sql.Date;
import java.sql.Time;

public class main {
    
    public static void main (String args[]) {
        
        PessoaFisica pf = new PessoaFisica();
        pf.setNome("Ricardo");
        pf.setEndereco("Rua X");
        pf.setCidade("Campo Grande");
        pf.setEstado("MS");
        pf.setComplemento("Casa da Frente");
        pf.setCep("XXXXXXXX");       
        pf.setRg("XXXXXXXXX");
        pf.setCpf("XXXXXXXXXXX");
        pf.setDataNascimento("1992-01-01");
        pf.setEstadoCivil("solteiro");
        pf.setEmail("mail@mail.com");
        pf.setTelefoneCelular("00000000000");
        pf.setTelefoneResidencial("0000000000");
        pf.setDocumentoPessoal("ricardo.jpg");
        pf.setUsuario("ricardo");
        pf.setSenha("ricardo.1");
        
        //inserir no banco de dados
        pf.inserir();
        
        Advogado ad = new Advogado();
        ad.setNome("Fatima");
        ad.setEndereco("Rua J");
        ad.setCidade("Campo Grande");
        ad.setEstado("MS");
        ad.setComplemento("");
        ad.setCep("XXXXXXXX");       
        ad.setRg("XXXXXXXXX");
        ad.setCpf("XXXXXXXXXXX");
        ad.setDataNascimento("1977-11-06");
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
        ad.inserir();
        
        Lembrete lem = new Lembrete();
        lem.setFuncionario(ad);
        lem.setCliente(pf);
        lem.setData("2016-11-22");
        lem.setHora("12:00");
        lem.setLocal("");
        lem.setAssunto("Atualizar Processo");
        lem.setDescricao("");
        lem.setProcesso(proc);
        
        //inserir no banco de dados
        lem.inserir();
        
        //atualizar
        lem.setHora("13:00");
        lem.atualizar();
        
        //deletar
        lem.deletar();
                
    }
    
}
