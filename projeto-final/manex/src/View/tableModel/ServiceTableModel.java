
package View.tableModel;

import Controller.DestinatarioController;
import Controller.PlataformaController;
import Controller.ServicoController;
import Models.Servico;
import java.util.ArrayList;
import javax.swing.table.AbstractTableModel;


public class ServiceTableModel extends AbstractTableModel
{
    private ArrayList<Servico> servicos;
    
    public ServiceTableModel()
    {
        loadAllServices();
    }
    
    private void loadAllServices()
    {
        this.servicos = ServicoController.getAll();
    }
    
    @Override
    public int getRowCount() 
    {
        return this.servicos.size();
    }

    @Override
    public int getColumnCount() 
    {
        return 5;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) 
    {
        switch(columnIndex)
        {
            case 0:
            {
                return this.servicos.get(rowIndex).id;
            }
            case 1:
            {
                int clientId = this.servicos.get(rowIndex).getPlataformaId();
                String clientName = PlataformaController.get(clientId).getNome();
                return clientName;
            }
                
            case 2:
            {
                int receiverId = this.servicos.get(rowIndex).getDestinatarioId();
                String receiverName = DestinatarioController.get(receiverId).getNome();
                return receiverName;
            }
                
            case 3:
            {
                int statusId = this.servicos.get(rowIndex).getStatus();
                return Helpers.Status.getStatus(statusId);
            }
            
            case 4:
            {
                return this.servicos.get(rowIndex).getValorTotalString();
            }
            
            default:
                return null;
        }
        
    }

    @Override
    public Class<?> getColumnClass(int columnIndex) 
    {
        switch(columnIndex)
        {
            case 0: return Integer.class;
            
            case 1: return String.class;

            case 2: return String.class;

            case 3: return String.class;

            case 4: return String.class;
            
            default: return null;
        }
    }

    @Override
    public String getColumnName(int column) 
    {
        switch(column)
        {
            case 0: return "Código";
            case 1: return "Plataforma";
            case 2: return "Destinatário";
            case 3: return "Status";
            case 4: return "Valor";
            default: return null;
        }
    }

}
