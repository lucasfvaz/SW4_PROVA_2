package beans;

import dao.AgendamentoDao;
import dao.EquipeDao;
import dao.TipoServicoDao;
import java.io.Serializable;
import java.util.Calendar;
import java.util.Date;
import java.util.LinkedList;
import javax.annotation.PostConstruct;
import javax.enterprise.context.SessionScoped;
import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.model.SelectItem;
import javax.faces.validator.ValidatorException;
import javax.inject.Inject;
import javax.inject.Named;
import model.Equipe;
import model.TipoDeServico;

@Named(value = "buscaBean")
@SessionScoped
public class BuscaBean implements Serializable {
    private TipoDeServico tipodeservicoselecionado;
    private Equipe equipeSelecionada;
    private  String responsavel;
    private Double valorservico;
    private Double totalServico;
    private String periodo;
    private LinkedList<SelectItem> selectEquipes;
    private Date data;
    private String contratante;
    private String telefonecontato;
    private String email;
    private String enderecodoservico;
    private Date now = new Date();
    
    @Inject
    EquipeDao equipeDao;
    
    @Inject 
    TipoServicoDao tiposervicoDao;
    
    @Inject 
    AgendamentoDao agendamentoDao;
    
    @PostConstruct
    public void iniciar() {
        selectEquipes = new LinkedList<SelectItem>();
        selectEquipes.add(new SelectItem(null,"Selecione o tipo de serviço primeiro"));
        responsavel = "selecione uma equipe";
        valorservico = 0.0;
        totalServico = 0.0;
        periodo = "";
    }
     
    public TipoDeServico getTipodeservicoselecionado() {
        return tipodeservicoselecionado;
    }

    public void setTipodeservicoselecionado(TipoDeServico tipodeservicoselecionado) {
        this.tipodeservicoselecionado = tipodeservicoselecionado;
        selectEquipes.clear();
        responsavel = "selecione uma equipe";
        valorservico = 0.0;
        totalServico = 0.0;
        periodo = "";
        if(tipodeservicoselecionado == null){
             selectEquipes.add(new SelectItem(null,"Selecione o tipo de serviço primeiro"));
        }else{
            selectEquipes.add(new SelectItem(null,"Equipe..."));
            for (Equipe eq : equipeDao.filtarPorTipoDeServico(tipodeservicoselecionado) ) {
                selectEquipes.add( new SelectItem(eq, eq.getNomedaequipe()));
            }
        }
    }

    public LinkedList<SelectItem> getSelectEquipes() {
        return selectEquipes;
    }

    
    
    
    
    public Equipe getEquipeSelecionada() {
        return equipeSelecionada;
    }
   
    public void setEquipeSelecionada(Equipe equipeSelecionada) {
        this.equipeSelecionada = equipeSelecionada;
        responsavel = "";
        if (equipeSelecionada == null) {
            responsavel = "selecione uma equipe para listar responsavel";
            valorservico = 0.0;
            totalServico = 0.0;
            periodo = "";
        } else {
            responsavel = equipeSelecionada.getResponsavel();
            valorservico = equipeSelecionada.getValorservicoperiodo();
            if(periodo.equals("")){
            totalServico = 0.0;
            }else{
            validaperido(periodo);

            }
        }
        
    }
    
    
    public String getResponsavel() {
        return responsavel;
    }

    public void setResponsavel(String responsavel) {
        this.responsavel = responsavel;
    }

    public Double getValorservico() {
        return valorservico;
    }

    public void setValorservico(Double valorservico) {
        this.valorservico = valorservico;
    }

    public Double getTotalServico() {
        return totalServico;
    }

    public void setTotalServico(Double totalServico) {
        this.totalServico = totalServico;
    }

    public String getPeriodo() {
        return periodo;
    }
    
    public Date getNow() {
      return new Date();
    }
    public void setNow(Date now) {
    this.now = now;
    }
    public void validateData(FacesContext context, UIComponent component, Object value) throws ValidatorException {
        if (value == null) {
         return;
       }      
     Date dataSelecionada = (Date) value;
     Calendar cal = Calendar.getInstance();
     cal.setTime(new Date());
    cal.add(Calendar.DATE, -2); 
    Date dataAtual = cal.getTime();
    if (dataSelecionada.before(dataAtual)) {
        throw new ValidatorException(new FacesMessage(FacesMessage.SEVERITY_ERROR, "Data Inválida", "A data selecionada é anterior à data atual. "));
    }
    cal.setTime(new Date());
    cal.add(Calendar.DATE, -1);
    dataAtual = cal.getTime();
    if (dataSelecionada.before(dataAtual) &&  ("manha".equals(periodo) || "diainteiro".equals(periodo) )) {
        throw new ValidatorException(new FacesMessage(FacesMessage.SEVERITY_ERROR, "Data Inválida", "A data selecionada é anterior à data atual. "));
    }
   }
    
    
    
    public void setPeriodo(String periodo) {
        this.periodo = periodo;
        if(periodo.equals("")){
            totalServico = 0.0;
            
        }else{
            validaperido(periodo);

        }
    } 
    public String limparContexto(){
        FacesContext.getCurrentInstance().getExternalContext().invalidateSession();
        
        return null;
    }
    
    public void validaperido(String periodo){
        switch(periodo) {
            case "manha":
              totalServico = valorservico;
              break;
            case "tarde":
             totalServico = valorservico;
             break;
             case "diainteiro":
             totalServico = (valorservico * 2);
             break;
         }
    }

    public Date getData() {
        return data;
    }

    public void setData(Date data) {
        this.data = data;
    }

    public String getContratante() {
        return contratante;
    }

    public void setContratante(String contratante) {
        this.contratante = contratante;
    }

    public String getTelefonecontato() {
        return telefonecontato;
    }

    public void setTelefonecontato(String telefonecontato) {
        this.telefonecontato = telefonecontato;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getEnderecodoservico() {
        return enderecodoservico;
    }

    public void setEnderecodoservico(String enderecodoservico) {
        this.enderecodoservico = enderecodoservico;
    }
     
    
}
