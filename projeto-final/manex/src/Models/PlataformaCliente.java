package Models;

public class PlataformaCliente 
{
    public int id;
    private String nome;
    private String documento;
    private int categoriaId;
    private String telefone;
    private String rua;
    private String bairro;
    private int numero;
    private String cidade;
    private String estado;

    public PlataformaCliente()
    { 
    
    }

    public String getRua() {
        return rua;
    }

    public void setRua(String rua) {
        this.rua = rua;
    }

    public String getBairro() {
        return bairro;
    }

    public void setBairro(String bairro) {
        this.bairro = bairro;
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
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
    
    public boolean ehValido()
    {
        return this.documento.length() == 14 && this.telefone.length() >= 8 &&
                this.telefone.length() <= 11 && this.categoriaId > 0;
    }
}
