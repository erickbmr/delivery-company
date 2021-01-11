
import java.util.Vector;

public class FakeBanco 
{
    private static Vector<Deposito> depositos = new Vector<>();
    private static Vector<Item> itens = new Vector<>();
    private static Vector<Plataforma> plataformas = new Vector<>();
    private static Vector<Veiculo> veiculos = new Vector<>();
    private static Vector<Funcionario> funcionarios = new Vector<>();
    private static Vector<Destinatario> destinatarios = new Vector<>();
    private static Vector<RequisicaoServico> servicos = new Vector<>();
    
    
    public static void carregarInfo()
    {
        funcionarios.add(new Funcionario("Motorista", "11111111111", "555555555"));
        funcionarios.add(new Funcionario("Motorista2", "22222222222", "555555556"));
        veiculos.add(new Veiculo("5345345534", "CBA1D55", "Preto", 80));
        veiculos.add(new Veiculo("5345345534", "ABC1D45", "Prata", 50));
        depositos.add(new Deposito("Brasil", "Centro", "36400000", "MG", 20, 3000, 1212));
        plataformas.add(new Plataforma("Americanas", "02391962000144", "E-commerce", "55567676"));
        destinatarios.add(new Destinatario("Erick", "80735747059", "Sete", "36400000",
            "Alto", "MG", "12345678", 10));
        //itens.add(new Item(1, "Kindle 10g", true, 5, 279.9));
        //itens.add(new Item(2, "Mi band 4", true, 3, 189.9));
    }
    
    //select from where
    public static Plataforma recuperaPlataforma(String documento)
    {
        for(Plataforma p : plataformas)
        {
            if(p.getDocumento().equals(documento))
                return p;
        }
        
        return null;
    }
    
    public static Destinatario recuperaDestinatario(String documento)
    {
        for(Destinatario d : destinatarios)
        {
            if(d.getDocumento().equals(documento))
                return d;
        }
        
        return null;
    }
    
    public static Funcionario recuperaFuncionario(String documento)
    {
        for(Funcionario f: funcionarios)
        {
            if(f.getDocumento().equals(documento))
                return f;
        }
        
        return null;
    }
    
    public static Veiculo recuperaVeiculo(String placa)
    {
        for(Veiculo v: veiculos)
        {
            if(v.getPlaca().equals(placa))
                return v;
        }
        
        return null;
    }
    
    public static Item recuperaItem(int codigo)
    {
        for(Item i: itens)
        {
            if(i.getCodigo() == codigo)
                return i;
        }
        
        return null;
    }
    
    public static Deposito recuperaDesposito(int codigo)
    {
        for(Deposito d: depositos)
        {
            if(d.getCodigo() == codigo)
                return d;
        }
        
        return null;
    }
    
    public static RequisicaoServico recuperaRequisicaoServico(int codigo)
    {
        for(RequisicaoServico r: servicos)
        {
            if(r.getCodigo() == codigo)
                return r;
        }
        
        return null;
    }
    
    //select*
    public static void listarDepositos()
    {
        for(Deposito d: depositos)
        {
            System.out.println("Cod. Deposito: " + d.getCodigo());
            System.out.println("Rua " + d.getRua() + "n." + d.getNumero() 
                    + "\nBairro " + d.getBairro() + " | CEP " + d.getCep());
            System.out.println(d.getEstado() + "\n");
        }
    }
    
    //insert
    public static void insereItem(Item novoItem)
    {
        itens.add(novoItem);
    }
    
    public static void insereRequisicaoServico(RequisicaoServico novaRequisicao)
    {
        servicos.add(novaRequisicao);
    }
    
    public static void insereDestinatario(Destinatario novoDestinatario)
    {
        destinatarios.add(novoDestinatario);
    }
    
    public static void inserePlataforma(Plataforma novaPlataforma)
    {
        plataformas.add(novaPlataforma);
    }
    
    public static void insereDeposito(Deposito novoDeposito)
    {
        depositos.add(novoDeposito);
    }
    
    public static void insereFuncionario(Funcionario novoFuncionario)
    {
        funcionarios.add(novoFuncionario);
    }
    
    public static void insereVeiculo(Veiculo novoVeiculo)
    {
        veiculos.add(novoVeiculo);
    }
    
}
