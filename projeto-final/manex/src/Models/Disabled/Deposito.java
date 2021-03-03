package Models.Disabled;

import java.util.Vector;

public class Deposito 
{
    public int id;
    private String rua;
    private String bairro;
    private int numero;
    private String cep;
    private String estado;
    private double capacidadeTotal;
    private double capacidadeRestante;

    public Deposito()
    {
        this.capacidadeRestante = this.capacidadeTotal;
    }

    public Deposito(String rua, String bairro, int numero, String cep, String estado, double capacidadeTotal) 
    {
        this.rua = rua;
        this.bairro = bairro;
        this.numero = numero;
        this.cep = cep;
        this.estado = estado;
        this.capacidadeTotal = capacidadeTotal;
        this.capacidadeRestante = this.capacidadeTotal;

    }

    public void setCapacidadeTotal(double capacidadeTotal) {
        this.capacidadeTotal = capacidadeTotal;
    }

    public void setCapacidadeRestante(double capacidadeRestante) {
        this.capacidadeRestante = capacidadeRestante;
    }
    
    public void setId(int id) {
        this.id = id;
    }
    
    public String getRua() {
        return this.rua;
    }

    public String getBairro() {
        return this.bairro;
    }

    public int getNumero() {
        return this.numero;
    }

    public String getCep() {
        return this.cep;
    }

    public String getEstado() {
        return this.estado;
    }

    public double getCapacidadeTotal() {
        return this.capacidadeTotal;
    }

    public double getCapacidadeRestante() {
        return this.capacidadeRestante;
    }

    public void setRua(String rua) {
        this.rua = rua;
    }

    public void setBairro(String bairro) {
        this.bairro = bairro;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public void setCep(String cep) {
        this.cep = cep;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }
    
    public boolean ehValido()
    {
        if((this.rua.length() > 0 && this.rua.length() <= 100) &&
           (this.bairro.length() > 0 && this.bairro.length() <= 50) &&
           (this.cep.length() == 8) && (this.estado.length() == 2) &&
           (this.numero > 0) && (this.capacidadeTotal > 0))
            return true;
        
        return false;
    }
}
