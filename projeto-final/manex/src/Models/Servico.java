package Models;

import java.util.Calendar;
import java.util.Date;
import java.util.Vector;

public class Servico 
{
    public int id;
    private int destinatarioId;
    private int plataformaId;
    private int funcionarioId;
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
    
    public Date getDataLimite() {
        return dataLimite;
    }

    public Date getDataCadastro() {
        return dataCadastro;
    }

    public Date getDataAgendada() {
        return dataAgendada;
    }

    public int getDestinatarioId() {
        return destinatarioId;
    }

    public void setDestinatarioId(int destinatarioId) {
        this.destinatarioId = destinatarioId;
    }

    public int getPlataformaId() {
        return plataformaId;
    }

    public void setPlataformaId(int plataformaId) {
        this.plataformaId = plataformaId;
    }

    public int getFuncionarioId() {
        return funcionarioId;
    }

    public void setFuncionarioId(int funcionarioId) {
        this.funcionarioId = funcionarioId;
    }
    
    public double getValorTotal() {
        return valorTotal;
    }
    
    public void setDataAgendada(Date dataAgendada) {
        this.dataAgendada = dataAgendada;
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
