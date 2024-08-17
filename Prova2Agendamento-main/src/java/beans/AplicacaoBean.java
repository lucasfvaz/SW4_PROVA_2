/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package beans;

import dao.AgendamentoDao;
import dao.EquipeDao;
import model.Equipe;
import dao.TipoServicoDao;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.LinkedList;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.inject.Produces;
import javax.faces.model.SelectItem;
import javax.inject.Named;
import model.TipoDeServico;


@Named("aplicacao")
@ApplicationScoped
public class AplicacaoBean {
    private EquipeDao equipeDao;
    private TipoServicoDao tiposervicoDao;
    private AgendamentoDao agendamentoDao;
    private List<SelectItem> itensEquipes;
    private List<SelectItem> itensTiposdeServicos;
    
    private String arquivo = "C:/Users/ertel/Documents/dados3_agendamento.dat";

    public AplicacaoBean() {
    }

    @PostConstruct
    public void iniciar() {
        try {
            FileInputStream fis = new FileInputStream(arquivo);
            ObjectInputStream ois = new ObjectInputStream( fis );
            // ler na mesma ordem em que foram escritos no arquivo.
            equipeDao = (EquipeDao) ois.readObject();
            tiposervicoDao = (TipoServicoDao) ois.readObject();
            agendamentoDao = (AgendamentoDao) ois.readObject();
            ois.close();
            fis.close();
        } catch (IOException | ClassNotFoundException ex) {// não foi possível ler os dados, criar com os valores padrão 
            System.out.println("Erro lendo arquivos, reiniciando dados...");
            equipeDao = new EquipeDao();
            tiposervicoDao = new TipoServicoDao();
            TipoDeServico tps1 = new TipoDeServico(1,"Limpeza de terrenos urbanos");
            tiposervicoDao.inserir(tps1);
            TipoDeServico tps2 = new TipoDeServico(2,"Remoção de entulhos de obras");
            tiposervicoDao.inserir(tps2);
            TipoDeServico tps3 = new TipoDeServico(3,"Faxina geral (empresas ou residências)");
            tiposervicoDao.inserir(tps3);
            TipoDeServico tps4 = new TipoDeServico(4,"Jardinagem");
            tiposervicoDao.inserir(tps4);
            TipoDeServico tps5 = new TipoDeServico(5,"Limpeza de fachadas de vidro");
            tiposervicoDao.inserir(tps5);
            Equipe e1 = new Equipe(1, "Equipe A1","Jackie chan",240.00,tps1);
            equipeDao.inserir(e1);
            Equipe e2 = new Equipe(2, "Equipe A2","Sylvester Stallone",250.00,tps2);
            equipeDao.inserir(e2);
            Equipe e3 = new Equipe(3, "Equipe A3","Bruce Lee",300.00,tps3);
            equipeDao.inserir(e3);
            Equipe e4 = new Equipe(4, "Equipe A4","Michael Jackson",400.00,tps4);
            equipeDao.inserir(e4);
            Equipe e5 = new Equipe(5, "Equipe A5","Lula",450.00,tps5);
            equipeDao.inserir(e5);
            Equipe e6 = new Equipe(6, "Equipe A6","Alexandre De Moraes",500.00,tps5);
            equipeDao.inserir(e6);
            
            agendamentoDao = new AgendamentoDao();
        }
    }

    public List<SelectItem> getItensEquipes()  {
        if(itensEquipes == null){
            itensEquipes = new LinkedList<>();
            itensEquipes.add(new SelectItem(null, "Selecione uma equipe"));
            
            equipeDao.listar().forEach(eq -> {
                itensEquipes.add(new SelectItem(eq,eq.getNomedaequipe()));
            });
        }
        
        return itensEquipes;
    }
   

    public List<SelectItem> getItensTiposdeServicos() {
        if(itensTiposdeServicos == null){
            itensTiposdeServicos = new LinkedList<>();
            itensTiposdeServicos.add(new SelectItem(null,"Selecione um tipo de serviço" ));
            
            tiposervicoDao.listar().forEach(tps -> {
                itensTiposdeServicos.add(new SelectItem(tps, tps.getDescricaodoservico()));
            });
        }
        return itensTiposdeServicos;
    }

    @Produces
    public TipoServicoDao getTiposervicoDao() {
        return tiposervicoDao;
    }
    
    @Produces
    public EquipeDao getEquipeDao() {
        return equipeDao;
    }
    
    @Produces
    public AgendamentoDao getAgendamentoDao() {
        return agendamentoDao;
    }
    
   @PreDestroy
    public void gravarArquivo() {
        try {
            FileOutputStream fos = new FileOutputStream(arquivo);
            ObjectOutputStream oos = new ObjectOutputStream( fos );
            oos.writeObject( equipeDao );
            oos.writeObject( tiposervicoDao );
            oos.writeObject( agendamentoDao );
            oos.flush();
            oos.close();
            fos.close();
        } catch(Throwable t) {
            t.printStackTrace();
        }
    }
}
