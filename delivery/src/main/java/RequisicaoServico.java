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
        this.itens = new Vector<>();
    }

    public RequisicaoServico(Destinatario destinatario, Plataforma plataforma, 
            Funcionario funcionario, Date dataLimite, Date dataAgendada) 
    {
        this.destinatario = destinatario;
        this.plataforma = plataforma;
        this.funcionario = funcionario;
        this.dataLimite = dataLimite;
        this.dataRequisicao = new Date();
        this.dataAgendada = dataAgendada;
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
    
    //comportamentos especificos
    
    public void addItem(Item item)
    {
        this.itens.add(item);
    }

}
