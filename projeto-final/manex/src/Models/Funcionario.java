package Models;

public class Funcionario 
{
    public int id;
    private String nome;
    private String cnh;
    private String telefone;
    private boolean disponivel;
    private int veiculoId;

    public Funcionario()
    {
        
    }
    
    public String getNome() {
        return this.nome;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCnh() {
        return this.cnh;
    }

    public String getTelefone() {
        return this.telefone;
    }

    public int getVeiculoId()
    {
        return this.veiculoId;
    }

    public boolean isDisponivel() {
        return this.disponivel;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public void setDisponivel(boolean disponivel) {
        this.disponivel = disponivel;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setCnh(String cnh) {
        this.cnh = cnh;
    }
    
    
    
}
