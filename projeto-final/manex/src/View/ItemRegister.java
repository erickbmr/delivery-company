/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View;

import Controller.DestinatarioController;
import Controller.ItemController;
import Controller.PlataformaController;
import Controller.ServicoController;
import Models.Item;
import Models.Servico;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import javax.swing.DefaultListModel;
import javax.swing.JOptionPane;

public class ItemRegister extends javax.swing.JPanel {

    private static Item itemCriado;
    private DefaultListModel<Item> itens;
    private static double valorServico;
    private int idServico;
    
    public ItemRegister() {
        initComponents();
        myInitComponents();
    }

    private void myInitComponents()
    {
        valorServico = 0;
        itemCriado = new Item();
        this.itens = new DefaultListModel<Item>();
        
        listaItens.setModel(this.itens);
        
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        descricaoTxt = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        larguraTxt = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        alturaTxt = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        profundidadeTxt = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        valorTxt = new javax.swing.JTextField();
        ehFragil = new javax.swing.JCheckBox();
        jLabel7 = new javax.swing.JLabel();
        pesoTxt = new javax.swing.JTextField();
        calculaBtn = new javax.swing.JButton();
        jLabel8 = new javax.swing.JLabel();
        volumeLbl = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        freteLbl = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        impostoLbl = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        taxaLbl = new javax.swing.JLabel();
        jLabel20 = new javax.swing.JLabel();
        totalLbl = new javax.swing.JLabel();
        limpaBtn = new javax.swing.JButton();
        addItemBtn = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        listaItens = new javax.swing.JList<>();
        jLabel9 = new javax.swing.JLabel();
        valorTotalServicoLbl = new javax.swing.JLabel();
        finalizaBtn = new javax.swing.JButton();
        cancelarBtn = new javax.swing.JButton();
        deleteItemBtn = new javax.swing.JButton();

        setBackground(new java.awt.Color(102, 0, 102));
        setPreferredSize(new java.awt.Dimension(735, 445));

        jLabel1.setFont(new java.awt.Font("Consolas", 0, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Itens");

        jPanel1.setBackground(new java.awt.Color(153, 153, 153));
        jPanel1.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        jLabel2.setFont(new java.awt.Font("Consolas", 1, 11)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Descrição");

        jLabel3.setFont(new java.awt.Font("Consolas", 1, 11)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Largura(cm)");

        larguraTxt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                larguraTxtActionPerformed(evt);
            }
        });

        jLabel4.setFont(new java.awt.Font("Consolas", 1, 11)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("Altura(cm)");

        jLabel5.setFont(new java.awt.Font("Consolas", 1, 11)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("Profundidade(cm)");

        profundidadeTxt.setToolTipText("");
        profundidadeTxt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                profundidadeTxtActionPerformed(evt);
            }
        });

        jLabel6.setFont(new java.awt.Font("Consolas", 1, 11)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setText("Valor do item");

        ehFragil.setBackground(new java.awt.Color(153, 153, 153));
        ehFragil.setFont(new java.awt.Font("Consolas", 1, 11)); // NOI18N
        ehFragil.setForeground(new java.awt.Color(255, 255, 255));
        ehFragil.setText("Frágil");
        ehFragil.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ehFragilActionPerformed(evt);
            }
        });

        jLabel7.setFont(new java.awt.Font("Consolas", 1, 11)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setText("Peso(g)");

        calculaBtn.setFont(new java.awt.Font("Consolas", 0, 12)); // NOI18N
        calculaBtn.setText("Calcular");
        calculaBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                calculaBtnActionPerformed(evt);
            }
        });

        jLabel8.setFont(new java.awt.Font("Consolas", 1, 14)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(255, 255, 255));
        jLabel8.setText("Volume(cm³):");

        volumeLbl.setFont(new java.awt.Font("Consolas", 1, 14)); // NOI18N
        volumeLbl.setForeground(new java.awt.Color(255, 255, 255));
        volumeLbl.setText("0");

        jLabel12.setFont(new java.awt.Font("Consolas", 1, 14)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(255, 255, 255));
        jLabel12.setText("Preço do frete:");

        freteLbl.setFont(new java.awt.Font("Consolas", 1, 14)); // NOI18N
        freteLbl.setForeground(new java.awt.Color(255, 255, 255));
        freteLbl.setText("R$0,00");

        jLabel14.setFont(new java.awt.Font("Consolas", 1, 14)); // NOI18N
        jLabel14.setForeground(new java.awt.Color(255, 255, 255));
        jLabel14.setText("Impostos:");

        impostoLbl.setFont(new java.awt.Font("Consolas", 1, 14)); // NOI18N
        impostoLbl.setForeground(new java.awt.Color(255, 255, 255));
        impostoLbl.setText("R$0,00");

        jLabel16.setFont(new java.awt.Font("Consolas", 1, 14)); // NOI18N
        jLabel16.setForeground(new java.awt.Color(255, 255, 255));
        jLabel16.setText("Taxas:");

        taxaLbl.setFont(new java.awt.Font("Consolas", 1, 14)); // NOI18N
        taxaLbl.setForeground(new java.awt.Color(255, 255, 255));
        taxaLbl.setText("R$0,00");

        jLabel20.setFont(new java.awt.Font("Consolas", 1, 14)); // NOI18N
        jLabel20.setForeground(new java.awt.Color(255, 255, 255));
        jLabel20.setText("Valor total:");

        totalLbl.setFont(new java.awt.Font("Consolas", 1, 14)); // NOI18N
        totalLbl.setForeground(new java.awt.Color(255, 255, 255));
        totalLbl.setText("R$0,00");

        limpaBtn.setFont(new java.awt.Font("Consolas", 0, 12)); // NOI18N
        limpaBtn.setText("Limpar");
        limpaBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                limpaBtnActionPerformed(evt);
            }
        });

        addItemBtn.setFont(new java.awt.Font("Consolas", 0, 12)); // NOI18N
        addItemBtn.setText("Adicionar item");
        addItemBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addItemBtnActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(descricaoTxt, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel2)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel7)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(pesoTxt))
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel4)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(alturaTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel3)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(larguraTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jLabel5)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(profundidadeTxt))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addGap(0, 11, Short.MAX_VALUE)
                                .addComponent(ehFragil)
                                .addGap(18, 18, 18)
                                .addComponent(jLabel6)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(valorTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel8)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(volumeLbl, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(245, 245, 245))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel16)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(taxaLbl, javax.swing.GroupLayout.PREFERRED_SIZE, 139, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel14)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(impostoLbl, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGap(69, 69, 69)))
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(calculaBtn, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(limpaBtn, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(addItemBtn, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                            .addComponent(jLabel20)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(totalLbl, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                            .addComponent(jLabel12)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(freteLbl, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(descricaoTxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(alturaTxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3)
                    .addComponent(jLabel5)
                    .addComponent(profundidadeTxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(larguraTxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(valorTxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel7)
                    .addComponent(pesoTxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(ehFragil))
                .addGap(18, 18, 18)
                .addComponent(calculaBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(28, 28, 28)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(volumeLbl))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel14)
                            .addComponent(impostoLbl)
                            .addComponent(addItemBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel16)
                            .addComponent(taxaLbl))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel12)
                            .addComponent(freteLbl)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(55, 55, 55)
                        .addComponent(limpaBtn)))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel20)
                    .addComponent(totalLbl)))
        );

        listaItens.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        jScrollPane1.setViewportView(listaItens);

        jLabel9.setFont(new java.awt.Font("Consolas", 0, 18)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(255, 255, 255));
        jLabel9.setText("Valor total:");

        valorTotalServicoLbl.setFont(new java.awt.Font("Consolas", 0, 18)); // NOI18N
        valorTotalServicoLbl.setForeground(new java.awt.Color(255, 255, 255));
        valorTotalServicoLbl.setText("R$0,00");

        finalizaBtn.setText("Finalizar");
        finalizaBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                finalizaBtnActionPerformed(evt);
            }
        });

        cancelarBtn.setText("Cancelar");
        cancelarBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cancelarBtnActionPerformed(evt);
            }
        });

        deleteItemBtn.setText("Remover");
        deleteItemBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                deleteItemBtnActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(8, 8, 8)
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 269, Short.MAX_VALUE)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel9)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(valorTotalServicoLbl)
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addGap(0, 0, Short.MAX_VALUE)
                                .addComponent(deleteItemBtn))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(cancelarBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(finalizaBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 77, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 261, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(deleteItemBtn)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(valorTotalServicoLbl)
                            .addComponent(jLabel9))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(cancelarBtn)
                            .addComponent(finalizaBtn))
                        .addGap(34, 34, 34))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addContainerGap())))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void ehFragilActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ehFragilActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_ehFragilActionPerformed

    private void profundidadeTxtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_profundidadeTxtActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_profundidadeTxtActionPerformed

    private void larguraTxtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_larguraTxtActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_larguraTxtActionPerformed

    private void calculaBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_calculaBtnActionPerformed
        
        String descricao = descricaoTxt.getText();
        String altura = alturaTxt.getText();
        String largura = larguraTxt.getText();
        String profundidade = profundidadeTxt.getText();
        String peso = pesoTxt.getText();
        boolean fragil = ehFragil.isEnabled();
        String valor = valorTxt.getText();
        
        if(!descricao.isBlank())
            itemCriado.setDescricao(descricao);
        else
            JOptionPane.showMessageDialog(this, "A descrição não pode ser nula.");
        
        if(!altura.isBlank() && !largura.isBlank() && !profundidade.isBlank() && !peso.isBlank() && !valor.isBlank())
        {
            if(altura.matches("[0-9]+") && largura.matches("[0-9]+") 
                    && profundidade.matches("[0-9]+") && peso.matches("[0-9]+") && valor.matches("[0-9]+"))
            {
                double valorAltura = Double.parseDouble(altura);
                double valorLargura = Double.parseDouble(largura);
                double valorProfundidade = Double.parseDouble(profundidade);
                double valorPeso = Double.parseDouble(peso);
                double valorItem = Double.parseDouble(valor);
                
                double volume = (valorAltura * valorLargura * valorProfundidade);
                volumeLbl.setText("" + Math.round(volume * 100.0)/100.0);
                
                double valorCalculo = volume + (valorPeso / 2);
                if(fragil)
                    valorCalculo += 3;
                valorCalculo += valorItem * 0.01;
                
                double impostos = (valorCalculo/100) * 0.03;
                impostoLbl.setText("R$ " + Math.round(impostos * 100.0)/100.0);
                
                double taxas = 6.5 + (valorCalculo/100) * 0.01;
                taxaLbl.setText("R$ " + Math.round(taxas));
                
                double precoFrete = (taxas + impostos + (valorCalculo / 100))/10;
                freteLbl.setText("R$ " + Math.round(precoFrete * 100.0)/100.0);
                
                double total = (impostos + taxas + precoFrete);
                totalLbl.setText("R$ " + Math.round(total * 100.0)/100.0);
                
                valorServico += total;
                
                itemCriado.setValorFrete(Math.round(total * 100.0) / 100.0);
                itemCriado.setValorItem(valorItem);
                itemCriado.setVolume(volume);
                itemCriado.setEhFragil(fragil);
                itemCriado.setDepositoId(1);
            }
            else
                JOptionPane.showMessageDialog(this, "Os campos para cálculo do valor devem ser numéricos.");
        }
        else
        {
            JOptionPane.showMessageDialog(this, "Complete todos os campos para cálculo do valor.");
        }
    }//GEN-LAST:event_calculaBtnActionPerformed

    private void addItemBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addItemBtnActionPerformed
        if(itemCriado == null)
        {
            JOptionPane.showMessageDialog(this, "Faça o cálculo primeiro.");
            return;

        }
        this.itens.addElement(itemCriado);
        valorTotalServicoLbl.setText("R$ " + Math.round(valorServico * 100.0) / 100.0);
        cleanInfo();
    }//GEN-LAST:event_addItemBtnActionPerformed

    private void cleanInfo()
    {
        descricaoTxt.setText("");
        alturaTxt.setText("");
        larguraTxt.setText("");
        profundidadeTxt.setText("");
        pesoTxt.setText("");
        valorTxt.setText("");
        
        volumeLbl.setText("0");
        totalLbl.setText("R$ 0.00");
        impostoLbl.setText("R$ 0.00");
        freteLbl.setText("R$ 0.00");
        taxaLbl.setText("R$ 0.00");
        
        
        itemCriado = new Item();
    }
    
    private void limpaBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_limpaBtnActionPerformed
        cleanInfo();
    }//GEN-LAST:event_limpaBtnActionPerformed

    private void deleteItemBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_deleteItemBtnActionPerformed
        int index = listaItens.getSelectedIndex();
        if(index >= 0 )
        {
            listaItens.remove(index);
            Item removido = itens.remove(index);
            this.itens.remove(index);
            if(removido != null)
               valorTotalServicoLbl.setText("R$ " + ((Math.round(valorServico * 100.0) / 100.0) - removido.getValorFrete()));
        }
        else
        {
            JOptionPane.showMessageDialog(this, "É necessário selecionar um item para remover.");
        }
        
    }//GEN-LAST:event_deleteItemBtnActionPerformed

    private void cancelarBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cancelarBtnActionPerformed
        FrameApp.changePanel(new Home(), "home");
    }//GEN-LAST:event_cancelarBtnActionPerformed

    private void finalizaBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_finalizaBtnActionPerformed
        String CNPJ = FrameApp.getCNPJ();
        String CPF = FrameApp.getCPF();

        JOptionPane.showMessageDialog(this, "Cliente: " + PlataformaController.get(CNPJ).getNome() + 
                "\nDestinatário: " + DestinatarioController.get(CPF).getNome() + 
                "\nValor total: R$" + Math.round(valorServico * 100.0)/100.0);
        
        
        Servico novo = new Servico();
        novo.setValorTotal(Math.round(valorServico * 100.0)/100.0);
        novo.setPrazoEmDias(14); //alterar depois
        novo.setPlataformaId(PlataformaController.get(CNPJ).id);
        novo.setDestinatarioId(DestinatarioController.get(CPF).id);
        novo.setFuncionarioId(2);//alterar depois
        novo.setStatus(1);//alterar depois
        novo.setDataCadastro(Calendar.getInstance().getTime());//alterar depois
        
        if(novo.getPlataformaId() > 0 && novo.getDestinatarioId() > 0)
        {
            if(ServicoController.cadastrar(novo))
            {
                ArrayList servicos = ServicoController.getAll();
                int totalServicos = servicos.size();
                Servico ultimoInserido = (Servico)servicos.get(totalServicos - 1);
                idServico = ultimoInserido.id;
                cadastraItens();
                JOptionPane.showMessageDialog(this, Helpers.Mensagem.SucessoCadastroServico());
                FrameApp.setCNPJ("");
                FrameApp.setCPF("");
                FrameApp.changePanel(new Home(), idServico + "");
            }
            else
            {
                JOptionPane.showMessageDialog(this, Helpers.Mensagem.ErroCadastroServico());
                FrameApp.setCNPJ("");
                FrameApp.setCPF("");
                FrameApp.changePanel(null, "home");
            }
 
        }
        else
            JOptionPane.showMessageDialog(this, "É necessário uma plataforma e um destinatário para cadastrar o serviço.");
    }//GEN-LAST:event_finalizaBtnActionPerformed

    public void cadastraItens()
    {
        for(int i = 0; i < this.itens.size(); i++)
        {
            Item item = this.itens.elementAt(i);
            item.setServicoId(idServico);
            if(!ItemController.cadastrar(item))
                JOptionPane.showMessageDialog(this, Helpers.Mensagem.ErroCadastroItem() + "\nDescrição: " + item.getDescricao());
        }
    }
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton addItemBtn;
    private javax.swing.JTextField alturaTxt;
    private javax.swing.JButton calculaBtn;
    private javax.swing.JButton cancelarBtn;
    private javax.swing.JButton deleteItemBtn;
    private javax.swing.JTextField descricaoTxt;
    private javax.swing.JCheckBox ehFragil;
    private javax.swing.JButton finalizaBtn;
    private javax.swing.JLabel freteLbl;
    private javax.swing.JLabel impostoLbl;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField larguraTxt;
    private javax.swing.JButton limpaBtn;
    private javax.swing.JList<Item> listaItens;
    private javax.swing.JTextField pesoTxt;
    private javax.swing.JTextField profundidadeTxt;
    private javax.swing.JLabel taxaLbl;
    private javax.swing.JLabel totalLbl;
    private javax.swing.JLabel valorTotalServicoLbl;
    private javax.swing.JTextField valorTxt;
    private javax.swing.JLabel volumeLbl;
    // End of variables declaration//GEN-END:variables
}
