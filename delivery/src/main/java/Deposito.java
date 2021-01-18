import java.util.Vector;


public class Deposito 
{
    private String rua;
    private String bairro;
    private String cep;
    private String estado;
    private int numero;
    private int codigo;
    private double capacidadeTotal;
    private double capacidadeRestante;
    private Vector<Item> itens;
    
    public Deposito()
    { 
       this.itens = new Vector<>();
       this.capacidadeRestante = this.capacidadeTotal;
    }

    public Deposito(String rua, String bairro, String cep, String estado, 
                        int numero, double capacidadeTotal, int codigo) 
    {
        this.rua = rua;
        this.bairro = bairro;
        this.cep = cep;
        this.estado = estado;
        this.numero = numero;
        this.capacidadeTotal = capacidadeTotal;
        this.capacidadeRestante = capacidadeTotal;
        this.itens = new Vector<>();
        this.codigo = codigo;
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
    
    public int getCodigo(){
        return this.codigo;
    }

    public void setCapacidadeTotal(double capacidadeTotal) {
        this.capacidadeTotal = capacidadeTotal;
    }
    
    public void setItens(Vector<Item> itens)
    {
        this.itens = itens;
    }
    
    //comportamentos especificos
    public boolean addItem(Item item)
    {
        double volumeItem = item.getVolume();
        
        if(this.capacidadeRestante > volumeItem)
        {
            this.itens.add(item);
            this.capacidadeRestante -= volumeItem;
            return true;
        }
        else
            return false;
    }
    
    public Item retiraItem(int codigo)
    {
        if(this.capacidadeRestante != this.capacidadeTotal)
        {
            int index = 0;
        
            for(Item i: this.itens)
            {
                if(i.getCodigo() == codigo)
                    return this.itens.remove(index);

                index++;
            }
        }
        else
        {
            System.err.println("Depósito vazio!");
        }
        
        return null;
    }
}
