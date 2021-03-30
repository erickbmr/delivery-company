/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View;

import Controller.ItemController;
import Controller.ServicoController;
import Models.Item;
import Models.Servico;
import View.tableModel.ServiceTableModel;
import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 *
 * @author Erick
 */
public class ServiceList extends javax.swing.JPanel {

    private ServiceTableModel tableData;
    
    public ServiceList() {
        initComponents();
        myInitComponents();
    }

    private void myInitComponents()
    {
        this.tableData = new ServiceTableModel();
        servicosTable.setModel(tableData);
    }
    
    public void deleteService()
    {
        try
        {
            int selectedRowIndex = this.servicosTable.getSelectedRow();
            if(selectedRowIndex < 0)
            {
                JOptionPane.showMessageDialog(this, "É necessário selecionar um serviço para alterar o status.");
            }
            else
            {
                int serviceId = (int)this.servicosTable.getValueAt(selectedRowIndex, 0);
                if(serviceId > 0)
                {
                    if(ItemController.excluirPorServico(serviceId))
                    {
                        if(ServicoController.excluir(serviceId))
                        {
                            JOptionPane.showMessageDialog(this, Helpers.Mensagem.SucessoRemoverServico());
                            myInitComponents();
                        }
                        else
                        {
                            JOptionPane.showMessageDialog(this, Helpers.Mensagem.ErroRemoverServico());
                        }
                    }
                    else
                    {
                        JOptionPane.showMessageDialog(this, Helpers.Mensagem.ErroRemoverItem());
                    }
                }
            }
        }
        catch(Exception ex)
        {
            new Helpers.Log(null, "View/Status: " + Helpers.Mensagem.ErroEditarServico(), ex.getMessage()).print();
        }
    }
    
    public void changeServiceStatus()
    {
        Servico servico = new Servico();
        try
        {
            int selectedRowIndex = this.servicosTable.getSelectedRow();
            int statusBoxIndex = this.statusBox.getSelectedIndex();
            if(selectedRowIndex < 0)
            {
                JOptionPane.showMessageDialog(this, "É necessário selecionar um serviço para alterar o status.");
            }
            if(statusBoxIndex == 0)
            {
                JOptionPane.showMessageDialog(this, "É necessário selecionar um status para alterar o serviço.");
            }
            else
            {
                int serviceId = (int)this.servicosTable.getValueAt(selectedRowIndex, 0);
                servico = ServicoController.get(serviceId);

                if(servico != null)
                {
                    int statusServiceId = servico.getStatus();
                    if(statusServiceId == statusBoxIndex)
                    {
                        JOptionPane.showMessageDialog(this, "O status atual é o mesmo que foi escolhido.");
                    }
                    else
                    {
                        servico.setStatus(statusBoxIndex);
                        ServicoController.changeStatus(serviceId, statusBoxIndex);
                        myInitComponents();
                    }
                }
            }
        }
        catch(Exception ex)
        {
            new Helpers.Log(servico, "View/Status: " + Helpers.Mensagem.ErroEditarServico(), ex.getMessage()).print();
        }
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        servicosTable = new javax.swing.JTable();
        deleteServicoBtn = new javax.swing.JButton();
        voltarBtn = new javax.swing.JButton();
        statusBox = new javax.swing.JComboBox<>();
        mudaStatusBtn = new javax.swing.JButton();

        setBackground(new java.awt.Color(102, 0, 102));
        setPreferredSize(new java.awt.Dimension(735, 445));

        jLabel1.setFont(new java.awt.Font("Consolas", 0, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Lista de serviços");

        servicosTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "Código", "Plataforma", "Destinatario", "Status", "Valor"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        servicosTable.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        jScrollPane1.setViewportView(servicosTable);
        if (servicosTable.getColumnModel().getColumnCount() > 0) {
            servicosTable.getColumnModel().getColumn(0).setPreferredWidth(100);
        }

        deleteServicoBtn.setFont(new java.awt.Font("Consolas", 0, 11)); // NOI18N
        deleteServicoBtn.setText("Excluir serviço");
        deleteServicoBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                deleteServicoBtnActionPerformed(evt);
            }
        });

        voltarBtn.setFont(new java.awt.Font("Consolas", 0, 11)); // NOI18N
        voltarBtn.setText("Voltar");
        voltarBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                voltarBtnActionPerformed(evt);
            }
        });

        statusBox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Selecione um status", "1 - Postado recentemente", "2 - Em alocação", "3 - Em rota de entrega", "4 - Entregue", "5 - Problema" }));
        statusBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                statusBoxActionPerformed(evt);
            }
        });

        mudaStatusBtn.setText("Mudar Status");
        mudaStatusBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mudaStatusBtnActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 715, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jLabel1))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(voltarBtn)
                        .addGap(130, 130, 130)
                        .addComponent(statusBox, javax.swing.GroupLayout.PREFERRED_SIZE, 186, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(mudaStatusBtn)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(deleteServicoBtn)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 346, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(53, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(voltarBtn)
                    .addComponent(deleteServicoBtn)
                    .addComponent(statusBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(mudaStatusBtn))
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents

    private void voltarBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_voltarBtnActionPerformed
        FrameApp.changePanel(new Home(), "home");
    }//GEN-LAST:event_voltarBtnActionPerformed

    private void statusBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_statusBoxActionPerformed
        // se começa com um id, depois Helpers.Status
    }//GEN-LAST:event_statusBoxActionPerformed

    private void deleteServicoBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_deleteServicoBtnActionPerformed
        deleteService();
    }//GEN-LAST:event_deleteServicoBtnActionPerformed

    private void mudaStatusBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mudaStatusBtnActionPerformed
         changeServiceStatus();
    }//GEN-LAST:event_mudaStatusBtnActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton deleteServicoBtn;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JButton mudaStatusBtn;
    private javax.swing.JTable servicosTable;
    private javax.swing.JComboBox<String> statusBox;
    private javax.swing.JButton voltarBtn;
    // End of variables declaration//GEN-END:variables
}
