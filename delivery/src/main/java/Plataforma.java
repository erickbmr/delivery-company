
public class Plataforma 
{
    private String nome;
    private String documento;
    private String categoria;
    private String telefone;

    public Plataforma(){ }
    
    public Plataforma(String nome, String documento, String categoria, String telefone) 
    {
        this.nome = nome;
        this.documento = documento;
        this.categoria = categoria;
        this.telefone = telefone;
    }

    public String getNome() {
        return this.nome;
    }

    public String getDocumento() {
        return this.documento;
    }

    public String getCategoria() {
        return this.categoria;
    }

    public String getTelefone() {
        return this.telefone;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }
    
    //comportamentos especificos
    
}
