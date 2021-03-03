package Helpers;

public class Log 
{
    public Object objeto;
    public String mensagem;
    public String exception;
    
    public Log(Object objeto, String mensagem, String exception)
    {
        this.objeto = objeto;
        this.mensagem = mensagem;
        this.exception = exception;
    }
    
    public void print()
    {
        if(this.objeto != null)
            System.err.println("{Obj: " + this.objeto.toString());
        else
            System.err.println("{Obj: null");
        System.err.println("Mensagem: " + this.mensagem);
        System.err.println("Exception: " + this.exception + "}");
    }
}
