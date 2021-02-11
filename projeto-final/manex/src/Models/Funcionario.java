package Models;

public class Funcionario 
{
    public int id;
    private String nome;
    private String cnh;
    private String telefone;
    private boolean disponivel;

    public Funcionario()
    {
        
    }
    
    public String getNome() {
        return this.nome;
    }

    public String getCnh() {
        return this.cnh;
    }

    public String getTelefone() {
        return this.telefone;
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
    
    
}
