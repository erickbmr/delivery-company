
package View;

import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Container;
import java.util.HashMap;
import javax.swing.ImageIcon;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

public class FrameApp extends javax.swing.JFrame {

    private static JPanel mainChangePanel;
    private static JScrollPane scrollPanel;
    private static CardLayout manager;
    private static HashMap<String, JPanel> panelsTable;
    private static String CNPJ;
    private static String CPF;
    
    
    public FrameApp() {
        initComponents();
        myInitComponents();
    }

    public static void setCNPJ(String cnpj)
    {
        CNPJ = cnpj;
    }
    
    public static String getCNPJ()
    {
        return CNPJ;
    }
    
    public static void setCPF(String cpf)
    {
        CPF = cpf;
    }
    
    public static String getCPF()
    {
        return CPF;
    }
    
    public void myInitComponents()
    {
        panelsTable = new HashMap<>();
        
        String path = "D:\\Facul\\4º Período\\poo2\\delivery-company\\delivery-company\\projeto-final\\docs\\assets\\truck.png";
        this.setIconImage(new ImageIcon(path).getImage());
        
        this.setLayout(new BorderLayout());
        this.scrollPanel = new JScrollPane();
        this.manager = new CardLayout();
        this.mainChangePanel = new JPanel(this.manager);
        this.add(this.scrollPanel, BorderLayout.CENTER);
        this.scrollPanel.setViewportView(this.mainChangePanel);
        
        //primeiro painel
        changePanel(new Home(), "home");
    }
    
    public static void changePanel(JPanel panel, String panelName)
    {
        if(panelsTable.containsKey(panelName))
        {
            manager.show(mainChangePanel, panelName);
            mainChangePanel.setPreferredSize(panelsTable.get(panelName).getPreferredSize());
        }
        else
        {
            panelsTable.put(panelName, panel);
            mainChangePanel.add(panel, panelName);
            manager.show(mainChangePanel, panelName);
            mainChangePanel.setPreferredSize(panel.getPreferredSize());
        }
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Manager Express");
        setIconImages(null);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 757, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 463, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(FrameApp.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FrameApp.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FrameApp.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FrameApp.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FrameApp().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables
}
