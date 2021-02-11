package Models;

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
    
   
}
