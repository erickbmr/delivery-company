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
    
    public Funcionario(String nome, String cnh, String telefone)
    {
        this.nome = nome;
        this.cnh = cnh;
        this.telefone = telefone;
        this.disponivel = false;
        this.veiculoId = 0;
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
    
    public boolean ehValido()
    {
        return this.cnh.length() == 11 && this.nome.length() > 0 &&
                this.nome.length() < 150 && this.telefone.length() >= 8 &&
                this.telefone.length() <= 11;
    }
    
}
