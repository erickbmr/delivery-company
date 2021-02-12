package Models;

import java.util.Calendar;
import java.util.Date;
import java.util.Vector;

public class Servico 
{
    public int id;
    private Destinatario destinatario;
    private PlataformaCliente plataforma;
    private Funcionario funcionario;
    private int prazoEmDias;
    private double valorTotal;
    private Date dataLimite;
    private Date dataCadastro;
    private Date dataAgendada;

    public Servico()
    {
        this.dataCadastro = new Date();
        this.dataAgendada = null;
    }

    public int getPrazoEmDias() {
        return prazoEmDias;
    }
    
    public Destinatario getDestinatario() {
        return destinatario;
    }

    public PlataformaCliente getPlataforma() {
        return plataforma;
    }

    public Funcionario getFuncionario() {
        return funcionario;
    }

    public Date getDataLimite() {
        return dataLimite;
    }

    public Date getDataCadastro() {
        return dataCadastro;
    }

    public Date getDataAgendada() {
        return dataAgendada;
    }

    public double getValorTotal() {
        return valorTotal;
    }
    
    public void setDataAgendada(Date dataAgendada) {
        this.dataAgendada = dataAgendada;
    }
    
    public void setFuncionario(Funcionario funcionario) {
        this.funcionario = funcionario;
    }

    public void setPrazoEmDias(int prazoEmDias) {
        this.prazoEmDias = prazoEmDias;
    }

    private boolean setDataLimite(int dias)
    {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(this.dataCadastro);
        
        //2 dias para descontar sábado e domingo
        calendar.add(Calendar.DATE, dias + 2);
        
        this.dataLimite = calendar.getTime();
        return false;
    }
    
}
