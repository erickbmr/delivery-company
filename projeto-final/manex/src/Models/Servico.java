package Models;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class Servico 
{
    public int id;
    private int destinatarioId;
    private int plataformaId;
    private int funcionarioId;
    private int prazoEmDias;
    private double valorTotal;
    private Date dataLimite;
    private String dataLimiteString;
    private Date dataCadastro;
    private String dataCadastroString;
    private Date dataAgendada;
    private String dataAgendadaString;
    private int status;
    private String pattern;
    private SimpleDateFormat dateFormat;
    
    public Servico()
    {
        this.dataCadastro = new Date();
        this.dataAgendada = null;
        this.pattern = "yyyy-MM-dd";
        this.dateFormat = new SimpleDateFormat(this.pattern);
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
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

    public String getDataLimiteString() {
        return dataLimiteString;
    }

    public String getDataCadastroString() {
        return dataCadastroString;
    }

    public String getDataAgendadaString() {
        return dataAgendadaString;
    }
    
    
    
    public Date getDataAgendada() {
        return dataAgendada;
    }

    public int getDestinatarioId() {
        return destinatarioId;
    }

    public void setValorTotal(double valorTotal) {
        this.valorTotal = valorTotal;
    }

    public void setDataLimite(Date dataLimite) {
        this.dataLimite = dataLimite;
        this.dataLimiteString = this.dateFormat.format(dataLimite);
    }

    public void setDataCadastro(Date dataCadastro) {
        this.dataCadastro = dataCadastro;
        this.dataCadastroString = this.dateFormat.format(dataCadastro);
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

    public String getValorTotalString()
    {
        return "R$ " + this.valorTotal;
    }
    
    public void setDataLimiteString(String dataLimiteString) {
        this.dataLimiteString = dataLimiteString;
    }

    public void setDataCadastroString(String dataCadastroString) {
        this.dataCadastroString = dataCadastroString;
    }

    public void setDataAgendadaString(String dataAgendadaString) {
        this.dataAgendadaString = dataAgendadaString;
    }
    
    
    
    public void setDataAgendada(Date dataAgendada) {
        this.dataAgendada = dataAgendada;
        this.dataAgendadaString = this.dateFormat.format(dataAgendada);
    }
    
    public void setPrazoEmDias(int prazoEmDias) {
        this.prazoEmDias = prazoEmDias;
        this.setDataLimite();
    }

    private boolean setDataLimite()
    {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(this.dataCadastro);
        //2 dias para descontar sábado e domingo
        calendar.add(Calendar.DATE, this.prazoEmDias + 2);

        this.dataLimite = calendar.getTime();

        this.dataLimiteString = this.dateFormat.format(this.dataLimite);
        return true;
    }
    
    public boolean ehValido()
    {
        Date hoje = Calendar.getInstance().getTime();
        return this.valorTotal > 0 && this.prazoEmDias > 0 && 
                this.dataLimite.after(hoje) &&
                this.destinatarioId > 0 && this.plataformaId > 0 &&
                this.funcionarioId > 0;
    }
}
