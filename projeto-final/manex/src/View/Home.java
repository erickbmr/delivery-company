/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View;

import Controller.PlataformaController;
import Controller.ServicoController;
import Helpers.Log;
import Models.PlataformaCliente;
import Models.Servico;
import java.util.ArrayList;
import javax.swing.JOptionPane;


public class Home extends javax.swing.JPanel {

    private static int idPlataforma;
    private static PlataformaCliente plataforma;
    private static String cnpj;

    
    public Home() {
        initComponents();
        myInitComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        cadastroBtn = new javax.swing.JButton();
        listaBtn = new javax.swing.JButton();
        mudaStatusBtn = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        totalPedidosLbl = new javax.swing.JLabel();
        valorTotalLbl = new javax.swing.JLabel();
        totalPostadosLbl = new javax.swing.JLabel();
        totalAlocacaoLbl = new javax.swing.JLabel();
        totalRotaLbl = new javax.swing.JLabel();
        totalEntregueLbl = new javax.swing.JLabel();
        totalOcorrenciaLbl = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();

        setBackground(new java.awt.Color(255, 255, 255));
        setPreferredSize(new java.awt.Dimension(735, 445));

        jPanel1.setBackground(new java.awt.Color(102, 0, 102));

        cadastroBtn.setBackground(new java.awt.Color(102, 0, 102));
        cadastroBtn.setIcon(new javax.swing.ImageIcon("D:\\Facul\\4º Período\\poo2\\delivery-company\\delivery-company\\projeto-final\\docs\\assets\\plus.png")); // NOI18N
        cadastroBtn.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        cadastroBtn.setContentAreaFilled(false);
        cadastroBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cadastroBtnActionPerformed(evt);
            }
        });

        listaBtn.setBackground(new java.awt.Color(102, 0, 102));
        listaBtn.setIcon(new javax.swing.ImageIcon("D:\\Facul\\4º Período\\poo2\\delivery-company\\delivery-company\\projeto-final\\docs\\assets\\list.png")); // NOI18N
        listaBtn.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        listaBtn.setContentAreaFilled(false);
        listaBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                listaBtnActionPerformed(evt);
            }
        });

        mudaStatusBtn.setBackground(new java.awt.Color(102, 0, 102));
        mudaStatusBtn.setIcon(new javax.swing.ImageIcon("D:\\Facul\\4º Período\\poo2\\delivery-company\\delivery-company\\projeto-final\\docs\\assets\\play.png")); // NOI18N
        mudaStatusBtn.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        mudaStatusBtn.setContentAreaFilled(false);
        mudaStatusBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mudaStatusBtnActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(cadastroBtn, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(listaBtn, javax.swing.GroupLayout.DEFAULT_SIZE, 113, Short.MAX_VALUE)
            .addComponent(mudaStatusBtn, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(124, 124, 124)
                .addComponent(mudaStatusBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 59, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(cadastroBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 59, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(listaBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 59, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jLabel1.setText("______________________________________________________________________________________________________");

        jLabel2.setFont(new java.awt.Font("Consolas", 0, 36)); // NOI18N
        jLabel2.setText("Manager Express");

        jLabel3.setFont(new java.awt.Font("Consolas", 0, 18)); // NOI18N
        jLabel3.setText("Número total de pedidos:");

        jLabel4.setFont(new java.awt.Font("Consolas", 0, 18)); // NOI18N
        jLabel4.setText("Valor total recebido:");

        jLabel5.setFont(new java.awt.Font("Consolas", 0, 18)); // NOI18N
        jLabel5.setText("Número de pedidos recentemente postados:");

        jLabel6.setFont(new java.awt.Font("Consolas", 0, 18)); // NOI18N
        jLabel6.setText("Número de pedidos em alocação:");

        jLabel7.setFont(new java.awt.Font("Consolas", 0, 18)); // NOI18N
        jLabel7.setText("Número de pedidos em rota de entrega:");

        jLabel8.setFont(new java.awt.Font("Consolas", 0, 18)); // NOI18N
        jLabel8.setText("Número de pedidos entregues:");

        jLabel9.setFont(new java.awt.Font("Consolas", 0, 18)); // NOI18N
        jLabel9.setText("Número de ocorrências:");

        totalPedidosLbl.setFont(new java.awt.Font("Consolas", 0, 18)); // NOI18N
        totalPedidosLbl.setText("0");

        valorTotalLbl.setFont(new java.awt.Font("Consolas", 0, 18)); // NOI18N
        valorTotalLbl.setText("R$00,00");

        totalPostadosLbl.setFont(new java.awt.Font("Consolas", 0, 18)); // NOI18N
        totalPostadosLbl.setText("0");

        totalAlocacaoLbl.setFont(new java.awt.Font("Consolas", 0, 18)); // NOI18N
        totalAlocacaoLbl.setText("0");

        totalRotaLbl.setFont(new java.awt.Font("Consolas", 0, 18)); // NOI18N
        totalRotaLbl.setText("0");

        totalEntregueLbl.setFont(new java.awt.Font("Consolas", 0, 18)); // NOI18N
        totalEntregueLbl.setText("0");

        totalOcorrenciaLbl.setFont(new java.awt.Font("Consolas", 0, 18)); // NOI18N
        totalOcorrenciaLbl.setText("0");

        jLabel10.setText("______________________________________________________________________________________________________");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(jLabel2)
                                .addGap(153, 153, 153))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 624, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addContainerGap())))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 624, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addGroup(layout.createSequentialGroup()
                                    .addComponent(jLabel4)
                                    .addGap(18, 18, 18)
                                    .addComponent(valorTotalLbl, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addGroup(layout.createSequentialGroup()
                                    .addComponent(jLabel3)
                                    .addGap(18, 18, 18)
                                    .addComponent(totalPedidosLbl, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(5, 5, 5)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jLabel8)
                                        .addGap(18, 18, 18)
                                        .addComponent(totalEntregueLbl, javax.swing.GroupLayout.PREFERRED_SIZE, 63, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jLabel9)
                                        .addGap(18, 18, 18)
                                        .addComponent(totalOcorrenciaLbl, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(layout.createSequentialGroup()
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                            .addGroup(layout.createSequentialGroup()
                                                .addComponent(jLabel6)
                                                .addGap(18, 18, 18)
                                                .addComponent(totalAlocacaoLbl, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                            .addComponent(jLabel7))
                                        .addGap(18, 18, 18)
                                        .addComponent(totalRotaLbl, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jLabel5)
                                        .addGap(18, 18, 18)
                                        .addComponent(totalPostadosLbl, javax.swing.GroupLayout.PREFERRED_SIZE, 58, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                        .addContainerGap())))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(34, 34, 34)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(totalPedidosLbl))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(valorTotalLbl))
                .addGap(26, 26, 26)
                .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(totalPostadosLbl))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(totalAlocacaoLbl))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(totalRotaLbl))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(totalEntregueLbl))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel9)
                    .addComponent(totalOcorrenciaLbl))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    public void myInitComponents()
    {
        try
        {
            ArrayList<Servico> listaServicos = ServicoController.getAll();
            double valorTotal = 0;
            int postados = 0, alocacao = 0, emRota = 0, entregues = 0, problema = 0;
            for(Servico s : listaServicos)
            {
                valorTotal += s.getValorTotal();
                switch(s.getStatus())
                {
                    case 1: 
                        postados++;
                    break;
                    case 2: 
                        alocacao++;
                    break;
                    case 3: 
                        emRota++;
                    break;
                    case 4: 
                        entregues++;
                    break;
                    case 5: 
                        problema++;
                    break;
                    default: 
                        problema++;
                    break;
                }
            }
            
            valorTotalLbl.setText("R$" + valorTotal);
            totalAlocacaoLbl.setText(alocacao + "");
            totalEntregueLbl.setText(entregues + "");
            totalOcorrenciaLbl.setText(problema + "");
            totalPedidosLbl.setText(listaServicos.size() + "");
            totalPostadosLbl.setText(postados + "");
            totalRotaLbl.setText(emRota + "");
        }
        catch(Exception ex)
        {
            new Log(null, Helpers.Mensagem.ErroCadastroServico(), ex.getMessage()).print();
        }
    }
    
    private void listaBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_listaBtnActionPerformed
        //TODO
    }//GEN-LAST:event_listaBtnActionPerformed

    private void cadastroBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cadastroBtnActionPerformed
        cnpj = JOptionPane.showInputDialog("Insira o CNPJ da Plataforma");
        //busca se existe o CNPJ
        plataforma = PlataformaController.get(cnpj);
        
        if(plataforma != null)
        {
            idPlataforma = plataforma.id;
            JOptionPane.showMessageDialog(this, Helpers.Mensagem.PlataformaEncontrada() +
                    "\nRazão Social: " + plataforma.getNome());
            FrameApp.changePanel(new ReceiverRegister(), "registroDestinatario");
        }
        else
        {
            JOptionPane.showMessageDialog(this, Helpers.Mensagem.PlataformaNaoEncontrada());
            FrameApp.changePanel(new ClientRegister(), "registroPlataforma");
        }
    }//GEN-LAST:event_cadastroBtnActionPerformed

    private void mudaStatusBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mudaStatusBtnActionPerformed
        FrameApp.changePanel(new ServiceList(), "servicos");
    }//GEN-LAST:event_mudaStatusBtnActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton cadastroBtn;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JButton listaBtn;
    private javax.swing.JButton mudaStatusBtn;
    private javax.swing.JLabel totalAlocacaoLbl;
    private javax.swing.JLabel totalEntregueLbl;
    private javax.swing.JLabel totalOcorrenciaLbl;
    private javax.swing.JLabel totalPedidosLbl;
    private javax.swing.JLabel totalPostadosLbl;
    private javax.swing.JLabel totalRotaLbl;
    private javax.swing.JLabel valorTotalLbl;
    // End of variables declaration//GEN-END:variables
}
