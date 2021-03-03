package Models;

public class Item 
{
    public int id;
    private String descricao;
    private boolean ehFragil;
    private double volume;
    private double valorItem;
    private double valorFrete;
    private int depositoId;
    private int servicoId;

    public Item()
    {
        
    }
    
    public Item(String descricao, boolean ehFragil, double volume, double valorItem, double valorFrete)
    {
        this.descricao = descricao;
        this.ehFragil = ehFragil;
        this.volume = volume;
        this.valorItem = valorItem;
        this.valorFrete = valorFrete;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setEhFragil(boolean ehFragil) {
        this.ehFragil = ehFragil;
    }

    public int getDepositoId() {
        return depositoId;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public void setVolume(double volume) {
        this.volume = volume;
    }

    public void setValorItem(double valorItem) {
        this.valorItem = valorItem;
    }

    public void setDepositoId(int depositoId) {
        this.depositoId = depositoId;
    }

    public int getServicoId() {
        return servicoId;
    }

    public void setServicoId(int servicoId) {
        this.servicoId = servicoId;
    }

    public boolean isFragil() {
        return ehFragil;
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
    
    public boolean ehValido()
    {
        return this.descricao.length() > 0 && this.descricao.length() < 256 &&
                this.volume > 0 && this.valorItem > 0 && this.valorFrete > 0 &&
                this.depositoId > 0 && this.servicoId > 0;
    }
}
