/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View;

/**
 *
 * @author erick_w45c3
 */
public class Remover extends javax.swing.JFrame {

    /**
     * Creates new form Remover
     */
    public Remover() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        background = new javax.swing.JPanel();
        sideMenu = new javax.swing.JPanel();
        cadastroBtn = new javax.swing.JButton();
        listaBtn = new javax.swing.JButton();
        edicaoBtn = new javax.swing.JButton();
        configBtn = new javax.swing.JButton();
        homeBtn = new javax.swing.JButton();
        JTabbedPanel1 = new javax.swing.JTabbedPane();
        plataformaRemove = new javax.swing.JPanel();
        destinatarioRemove = new javax.swing.JPanel();
        itemRemove = new javax.swing.JPanel();
        servicoRemove = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        sideMenu.setBackground(new java.awt.Color(102, 0, 102));

        cadastroBtn.setBackground(new java.awt.Color(102, 0, 102));
        cadastroBtn.setIcon(new javax.swing.ImageIcon("E:\\Usuário\\Documentos\\poo2\\delivery-company\\delivery-company\\projeto-final\\docs\\assets\\plus.png")); // NOI18N
        cadastroBtn.setBorderPainted(false);

        listaBtn.setBackground(new java.awt.Color(102, 0, 102));
        listaBtn.setIcon(new javax.swing.ImageIcon("E:\\Usuário\\Documentos\\poo2\\delivery-company\\delivery-company\\projeto-final\\docs\\assets\\list.png")); // NOI18N
        listaBtn.setBorderPainted(false);

        edicaoBtn.setBackground(new java.awt.Color(102, 0, 102));
        edicaoBtn.setIcon(new javax.swing.ImageIcon("E:\\Usuário\\Documentos\\poo2\\delivery-company\\delivery-company\\projeto-final\\docs\\assets\\pencil.png")); // NOI18N
        edicaoBtn.setBorderPainted(false);

        configBtn.setBackground(new java.awt.Color(102, 0, 102));
        configBtn.setIcon(new javax.swing.ImageIcon("E:\\Usuário\\Documentos\\poo2\\delivery-company\\delivery-company\\projeto-final\\docs\\assets\\settings.png")); // NOI18N
        configBtn.setBorderPainted(false);

        homeBtn.setBackground(new java.awt.Color(102, 0, 102));
        homeBtn.setIcon(new javax.swing.ImageIcon("E:\\Usuário\\Documentos\\poo2\\delivery-company\\delivery-company\\projeto-final\\docs\\assets\\home.png")); // NOI18N
        homeBtn.setBorderPainted(false);

        javax.swing.GroupLayout sideMenuLayout = new javax.swing.GroupLayout(sideMenu);
        sideMenu.setLayout(sideMenuLayout);
        sideMenuLayout.setHorizontalGroup(
            sideMenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(cadastroBtn, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(listaBtn, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(edicaoBtn, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(configBtn, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(homeBtn, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        sideMenuLayout.setVerticalGroup(
            sideMenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(sideMenuLayout.createSequentialGroup()
                .addGap(86, 86, 86)
                .addComponent(homeBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 59, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(cadastroBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 59, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(edicaoBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 59, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(listaBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 59, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(configBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 59, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        JTabbedPanel1.setBackground(new java.awt.Color(102, 0, 102));
        JTabbedPanel1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        JTabbedPanel1.setOpaque(true);

        plataformaRemove.setBackground(new java.awt.Color(255, 255, 255));

        javax.swing.GroupLayout plataformaRemoveLayout = new javax.swing.GroupLayout(plataformaRemove);
        plataformaRemove.setLayout(plataformaRemoveLayout);
        plataformaRemoveLayout.setHorizontalGroup(
            plataformaRemoveLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 718, Short.MAX_VALUE)
        );
        plataformaRemoveLayout.setVerticalGroup(
            plataformaRemoveLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 385, Short.MAX_VALUE)
        );

        JTabbedPanel1.addTab("Plataforma", plataformaRemove);

        destinatarioRemove.setBackground(new java.awt.Color(255, 255, 255));

        javax.swing.GroupLayout destinatarioRemoveLayout = new javax.swing.GroupLayout(destinatarioRemove);
        destinatarioRemove.setLayout(destinatarioRemoveLayout);
        destinatarioRemoveLayout.setHorizontalGroup(
            destinatarioRemoveLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 718, Short.MAX_VALUE)
        );
        destinatarioRemoveLayout.setVerticalGroup(
            destinatarioRemoveLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 385, Short.MAX_VALUE)
        );

        JTabbedPanel1.addTab("Destinatário", destinatarioRemove);

        itemRemove.setBackground(new java.awt.Color(255, 255, 255));

        javax.swing.GroupLayout itemRemoveLayout = new javax.swing.GroupLayout(itemRemove);
        itemRemove.setLayout(itemRemoveLayout);
        itemRemoveLayout.setHorizontalGroup(
            itemRemoveLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 718, Short.MAX_VALUE)
        );
        itemRemoveLayout.setVerticalGroup(
            itemRemoveLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 385, Short.MAX_VALUE)
        );

        JTabbedPanel1.addTab("Item", itemRemove);

        servicoRemove.setBackground(new java.awt.Color(255, 255, 255));

        javax.swing.GroupLayout servicoRemoveLayout = new javax.swing.GroupLayout(servicoRemove);
        servicoRemove.setLayout(servicoRemoveLayout);
        servicoRemoveLayout.setHorizontalGroup(
            servicoRemoveLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 718, Short.MAX_VALUE)
        );
        servicoRemoveLayout.setVerticalGroup(
            servicoRemoveLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 385, Short.MAX_VALUE)
        );

        JTabbedPanel1.addTab("Requisição de serviço", servicoRemove);

        javax.swing.GroupLayout backgroundLayout = new javax.swing.GroupLayout(background);
        background.setLayout(backgroundLayout);
        backgroundLayout.setHorizontalGroup(
            backgroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(backgroundLayout.createSequentialGroup()
                .addComponent(sideMenu, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(JTabbedPanel1))
        );
        backgroundLayout.setVerticalGroup(
            backgroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(sideMenu, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(JTabbedPanel1)
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(background, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(background, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
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
            java.util.logging.Logger.getLogger(Remover.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Remover.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Remover.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Remover.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Remover().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTabbedPane JTabbedPanel1;
    private javax.swing.JPanel background;
    private javax.swing.JButton cadastroBtn;
    private javax.swing.JButton configBtn;
    private javax.swing.JPanel destinatarioRemove;
    private javax.swing.JButton edicaoBtn;
    private javax.swing.JButton homeBtn;
    private javax.swing.JPanel itemRemove;
    private javax.swing.JButton listaBtn;
    private javax.swing.JPanel plataformaRemove;
    private javax.swing.JPanel servicoRemove;
    private javax.swing.JPanel sideMenu;
    // End of variables declaration//GEN-END:variables
}
