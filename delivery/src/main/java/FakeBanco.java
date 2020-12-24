
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
        veiculos.add(new Veiculo("5345345534", "ABC1D45", "Prata", 500));
        depositos.add(new Deposito("Brasil", "Centro", "36400000", "MG", 20, 3000));
        plataformas.add(new Plataforma("Americanas", "1", "E-commerce", "55567676"));
        
    }
    
}
