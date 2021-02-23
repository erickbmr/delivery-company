package Models;

public class PlataformaCliente 
{
    public int id;
    private String nome;
    private String documento;
    private int categoriaId;
    private String telefone;

    public PlataformaCliente()
    { 
    
    }
   
    public String getNome() {
        return this.nome;
    }

    public int getCategoriaId() {
        return categoriaId;
    }

    public void setCategoriaId(int categoriaId) {
        this.categoriaId = categoriaId;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDocumento() {
        return this.documento;
    }

    public void setDocumento(String documento) {
        this.documento = documento;
    }

    public String getTelefone() {
        return this.telefone;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setCategoria(int categoria) {
        this.categoriaId = categoria;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }
}
