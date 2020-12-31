public class Item 
{
    private String descricao;
    private boolean ehFragil;
    private double volume;
    private double valor;
    private int codigo;
    
    public Item(){ }

    public Item(int cod, String descricao, boolean ehFragil, double volume, double valor) {
        this.descricao = descricao;
        this.ehFragil = ehFragil;
        this.volume = volume;
        this.valor = valor;
        this.codigo = cod;
    }

    public int getCodigo() {
        return codigo;
    }

    public String getDescricao() {
        return this.descricao;
    }

    public boolean ehFragil() {
        return this.ehFragil;
    }

    public double getVolume() {
        return this.volume;
    }

    public double getValor() {
        return this.valor;
    }
    
    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }
       
    //comportamentos especificos
}
