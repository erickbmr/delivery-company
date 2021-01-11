public class Funcionario 
{
    private String nome;
    private String documento;
    private String telefone;
    private boolean disponivel;
    
    public Funcionario(){ }
    
    public Funcionario(String nome, String documento, String telefone)
    {
        this.nome = nome;
        this.documento = documento;
        this.telefone = telefone;
    }
    
    public String getNome(){ return this.nome; }    
    
    public String getDocumento(){ return this.documento; }
    
    public String getTelefone() { return this.telefone; }    
   
    public boolean estaDisponivel(){ return this.disponivel; }
    
    public void setNome(String nome)
    {
        this.nome = nome;
    }
    
    public void setTelefone(String telefone)
    {
        this.telefone = telefone;
    }
    
    public void setDisponibilidade(boolean disponivel)
    {
        this.disponivel = disponivel;
    }
    
    //comportamentos especificos
    
}
