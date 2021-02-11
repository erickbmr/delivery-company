package Models;

import java.util.Vector;

public class Veiculo 
{
    public int id;
    private String placa;
    private String modelo;
    private String cor;
    private double capacidadeTotal;
    private double capacidadeRestante;

    public Veiculo(String placa, String modelo, String cor, double capacidadeTotal)
    {
        this.placa = placa;
        this.modelo = modelo;
        this.cor = cor;
        this.capacidadeTotal = capacidadeTotal;
        this.capacidadeRestante = this.capacidadeTotal;
    }

    public String getPlaca() {
        return this.placa;
    }

    public String getModelo() {
        return this.modelo;
    }

    public String getCor() {
        return this.cor;
    }

    public double getCapacidadeTotal() {
        return this.capacidadeTotal;
    }

    public double getCapacidadeRestante() {
        return this.capacidadeRestante;
    }

    
    
}
