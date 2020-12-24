import java.util.Vector;

public class Veiculo 
{
    private String documento;
    private String placa;
    private String cor;
    private double capacidadeTotal;
    private double capacidadeRestante;
    private Vector<Item> itens;

    
    public Veiculo()
    {
        this.capacidadeRestante = this.capacidadeTotal;
        this.itens = new Vector<>();
    }

    public Veiculo(String documento, String placa, String cor, double capacidade) {
        this.documento = documento;
        this.placa = placa;
        this.cor = cor;
        this.capacidadeTotal = capacidade;
        this.capacidadeRestante = capacidade;
    }

    public double getCapacidadeTotal() {
        return this.capacidadeTotal;
    }

    public double getCapacidadeRestante() {
        return this.capacidadeRestante;
    }

    public String getDocumento() {
        return this.documento;
    }

    public String getPlaca() {
        return this.placa;
    }

    public String getCor() {
        return this.cor;
    }
    
    public void setCor(String cor) {
        this.cor = cor;
    }
    
    //comportamentos especificos
    
    //metodo para atualização da capacidade restante
}
