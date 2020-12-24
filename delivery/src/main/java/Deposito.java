import java.util.Vector;


public class Deposito 
{
    private String rua;
    private String bairro;
    private String cep;
    private String estado;
    private int numero;
    private double capacidadeTotal;
    private double capacidadeRestante;
    private Vector<Item> itens;
    
    public Deposito()
    { 
       this.itens = new Vector<>();
       this.capacidadeRestante = this.capacidadeTotal;
    }

    public Deposito(String rua, String bairro, String cep, String estado, int numero, double capacidadeTotal) {
        this.rua = rua;
        this.bairro = bairro;
        this.cep = cep;
        this.estado = estado;
        this.numero = numero;
        this.capacidadeTotal = capacidadeTotal;
        this.capacidadeRestante = capacidadeTotal;
        this.itens = new Vector<>();
    }

    public double getCapacidadeRestante() {
        return this.capacidadeRestante;
    }

    public String getRua() {
        return this.rua;
    }

    public String getBairro() {
        return this.bairro;
    }

    public String getCep() {
        return this.cep;
    }

    public String getEstado() {
        return this.estado;
    }

    public int getNumero() {
        return this.numero;
    }

    public double getCapacidadeTotal() {
        return this.capacidadeTotal;
    }

    public void setCapacidadeTotal(double capacidadeTotal) {
        this.capacidadeTotal = capacidadeTotal;
    }
    
    //comportamentos especificos
}
