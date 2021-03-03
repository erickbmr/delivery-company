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

    public Destinatario(String nome, String documento, String rua, String cep, 
            String bairro, String estado, String telefone, int numero) 
    {
        this.nome = nome;
        this.documento = documento;
        this.rua = rua;
        this.cep = cep;
        this.bairro = bairro;
        this.estado = estado;
        this.telefone = telefone;
        this.numero = numero;
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
    
    public boolean ehValido()
    {
        return this.nome.length() > 0 && this.nome.length() < 150 &&
                this.documento.length() == 11 &&
                this.rua.length() > 0 && this.rua.length() < 100 &&
                this.bairro.length() > 0 && this.bairro.length() < 50 &&
                this.cep.length() == 8 &&
                this.estado.length() > 0 && this.numero > 0;
    }
}
