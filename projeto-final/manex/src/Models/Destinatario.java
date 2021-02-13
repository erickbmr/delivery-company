package Models;

public class Destinatario
{
    public int id;
    private String nome;
    private String documento;
    private String rua;
    private String cep;
    private String bairro;
    private String estado;
    private String telefone;
    private int numero;

    public Destinatario() 
    {
        
    }

    public void setDocumento(String documento) {
        this.documento = documento;
    }
    
    public String getNome() {
        return this.nome;
    }

    public String getDocumento() {
        return this.documento;
    }

    public String getRua() {
        return this.rua;
    }

    public String getCep() {
        return this.cep;
    }

    public String getBairro() {
        return this.bairro;
    }

    public String getEstado() {
        return this.estado;
    }

    public String getTelefone() {
        return this.telefone;
    }

    public int getNumero() {
        return this.numero;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setRua(String rua) {
        this.rua = rua;
    }

    public void setCep(String cep) {
        this.cep = cep;
    }

    public void setBairro(String bairro) {
        this.bairro = bairro;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }
}
