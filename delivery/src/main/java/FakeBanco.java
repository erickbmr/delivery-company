
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
        depositos.add(new Deposito("Brasil", "Centro", "36400000", "MG", 20, 3000));
        plataformas.add(new Plataforma("Americanas", "1", "E-commerce", "55567676"));
        //itens.add(new Item(1, "Kindle 10g", true, 5, 279.9));
        //itens.add(new Item(2, "Mi band 4", true, 3, 189.9));
    }
    
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
    
    
    
}
