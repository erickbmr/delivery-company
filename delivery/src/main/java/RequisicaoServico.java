import java.util.Calendar;
import java.util.Date;
import java.util.Vector;

public class RequisicaoServico 
{
    private Destinatario destinatario;
    private Plataforma plataforma;
    private Funcionario funcionario;
    private Date dataLimite;
    private Date dataRequisicao;
    private Date dataAgendada;
    private Vector<Item> itens;
    
    public RequisicaoServico()
    { 
        this.dataRequisicao = new Date();
        this.dataAgendada = null;
        this.funcionario = null;
        this.itens = new Vector<>();
        this.dataLimite = null;
    }

    public RequisicaoServico(Destinatario destinatario, Plataforma plataforma) 
    {
        this.destinatario = destinatario;
        this.plataforma = plataforma;
        
        this.funcionario = null;
        this.dataLimite = null;
        this.dataRequisicao = new Date();
        this.dataAgendada = null;
        this.itens = new Vector<>();
    }

    public Destinatario getDestinatario() {
        return this.destinatario;
    }

    public Plataforma getPlataforma() {
        return this.plataforma;
    }

    public Funcionario getFuncionario() {
        return this.funcionario;
    }

    public Date getDataLimite() {
        return this.dataLimite;
    }

    public Date getDataRequisicao() {
        return this.dataRequisicao;
    }

    public Date getDataAgendada() {
        return this.dataAgendada;
    }

    public void setFuncionario(Funcionario funcionario) {
        this.funcionario = funcionario;
    }

    public void setDataAgendada(Date dataAgendada) {
        this.dataAgendada = dataAgendada;
    }
    
    public void setDataLimite(int dias)
    {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(this.dataRequisicao);
        //2 dias para descontar sábado e domingo
        calendar.add(Calendar.DATE, dias + 2);
        
        this.dataLimite = calendar.getTime();
    }
    
    //comportamentos especificos
    
    public void addItem(Item item)
    {
        this.itens.add(item);
    }

}
