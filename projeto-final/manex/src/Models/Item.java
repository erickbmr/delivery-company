package Models;

public class Item 
{
    public int id;
    private String descricao;
    private boolean ehFragil;
    private double volume;
    private double valorItem;
    private double valorFrete;

    public Item(String descricao, boolean ehFragil, double volume, double valorItem, double valorFrete)
    {
        this.descricao = descricao;
        this.ehFragil = ehFragil;
        this.volume = volume;
        this.valorItem = valorItem;
        this.valorFrete = valorFrete;
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

    public double getValorItem() {
        return this.valorItem;
    }

    public double getValorFrete() {
        return this.valorFrete;
    }

    public void setValorFrete(double valorFrete) {
        this.valorFrete = valorFrete;
    }
    
    
}
