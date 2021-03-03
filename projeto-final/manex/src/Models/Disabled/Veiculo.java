package Models.Disabled;

import java.util.Vector;

public class Veiculo 
{
    public int id;
    private String placa;
    private String modelo;
    private String cor;
    private double capacidadeTotal;
    private double capacidadeRestante;

    public Veiculo()
    {
        
    }
    
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

    public void setPlaca(String placa) {
        this.placa = placa;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public void setCor(String cor) {
        this.cor = cor;
    }

    public void setCapacidadeTotal(double capacidadeTotal) {
        this.capacidadeTotal = capacidadeTotal;
    }

    public void setCapacidadeRestante(double capacidadeRestante) {
        this.capacidadeRestante = capacidadeRestante;
    }

    
    
}
