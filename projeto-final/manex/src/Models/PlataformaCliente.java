package Models;

public class PlataformaCliente 
{
    public int id;
    private String nome;
    private String documento;
    private String categoria;
    private String telefone;

    public PlataformaCliente()
    { 
    
    }
   
    public String getNome() {
        return this.nome;
    }

    public void setId(int id) {
        this.id = id;
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
}
