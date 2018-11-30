
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.*;
import javax.swing.DefaultComboBoxModel;
import javax.swing.table.DefaultTableModel;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author YOGA
 */
public class Frame extends javax.swing.JFrame {
    private int id = 0; //variabel untuk code transaksi
    private String code; //variabel untuk code transaksi
    private DefaultComboBoxModel cbModel; //untuk model Jcombobox
    private DefaultTableModel tbModel; //untuk model Jtable
    private ArrayList<Item> cart = new ArrayList<>(); //variabel untuk menyimpan item transaksi
    
    public Frame() {
        TrxComboModel comboModel = new TrxComboModel();
        //untuk set combo items
        this.cbModel = new DefaultComboBoxModel<>(comboModel.getNama().toArray());
        
        TrxTableModel tableModel = new TrxTableModel();
        //untuk set table kolom nama
        this.tbModel = new DefaultTableModel(tableModel.getColumnName(), 0);
        
        initComponents();
        codeText.setEnabled(false);
        txtJml.setEnabled(false);
    }
    
    private Object[] addItem(String nama, int jumlah) {
        float harga = 0;
        TrxComboModel items = new TrxComboModel();
        for(int i = 0; i < items.getNama().size(); i++) {
            if(nama.equalsIgnoreCase(items.getNama().get(i))) {
                harga = items.getHarga().get(i);
            }
        }
        Object[] obj = {
            nama, harga, jumlah
        };
        return obj;
    }
    
    //update fungsi jumlah
    private void updateJumlah(String nama, int add) {
        ArrayList<String> item = new ArrayList<>();
        for(int i = 0; i < tbModel.getRowCount(); i++) {
            item.add(tbModel.getValueAt(i, 0).toString());
        }
        for(int i = 0; i < item.size(); i++) {
            if(item.get(i).equals(nama)) {
                int jumlah = new Integer (tbModel.getValueAt(i, 2).toString());
                tbModel.setValueAt(jumlah, i, 2);
            }
        }
    }
    
    //untuk mengecek item kembar yang telah dipilih
    private boolean isDuplicate(String nama) {
        boolean result = false;
        ArrayList<String> item = new ArrayList<>();
        for(int i = 0; i < tbModel.getRowCount(); i++) {
            item.add(tbModel.getValueAt(i, 0).toString());
        }
        for(String i : item) {
            if(i.equals(nama)) {
                result = true;
            }
        }
        return result;
    }
    
    //untuk mengecek jika tabel kosong
    private boolean isEmpty() {
        return this.tblListItems.getModel().getRowCount()<=0;
    }
    
    //untuk mematikan tombol remove dan save jika tabel kosong
    private void cartCheck() {
        if(isEmpty()) {
            this.btnSave.setEnabled(false);
            this.btnRmv.setEnabled(false);
        }else{
            this.btnSave.setEnabled(true);
            this.btnRmv.setEnabled(true);
        }
    }
    //mengatur fungsi code untuk mendapatkan tanggal saat ini dan id
    private String setCode() {
        this.incId();
        String dt = new SimpleDateFormat("yyMMdd").format(new Date());
        this.code = String.format(dt+"%02d", this.id);
        return code;
    }
    
    //penambahan id
    private void incId() {
        this.id += 1;
    }
    
    //pengurangan id
    private void decId() {
        this.id -= 1;
    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        comboItems = new javax.swing.JComboBox<>();
        btnNew = new javax.swing.JButton();
        btnAdd = new javax.swing.JButton();
        btnRmv = new javax.swing.JButton();
        codeText = new javax.swing.JTextField();
        txtJml = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblListItems = new javax.swing.JTable();
        btnSave = new javax.swing.JButton();
        btnCncl = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setText("Code");

        jLabel2.setText("Items");

        comboItems.setModel(this.cbModel);
        comboItems.setEnabled(false);
        comboItems.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                comboItemsActionPerformed(evt);
            }
        });

        btnNew.setText("New");
        btnNew.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNewActionPerformed(evt);
            }
        });

        btnAdd.setText("Add");
        btnAdd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddActionPerformed(evt);
            }
        });

        btnRmv.setText("Remove");

        codeText.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                codeTextActionPerformed(evt);
            }
        });

        txtJml.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtJmlActionPerformed(evt);
            }
        });

        tblListItems.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Nama", "Harga", "Jumlah"
            }
        ));
        jScrollPane1.setViewportView(tblListItems);

        btnSave.setText("Save");
        btnSave.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSaveActionPerformed(evt);
            }
        });

        btnCncl.setText("Cancel");
        btnCncl.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCnclActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addGap(18, 18, 18)
                        .addComponent(codeText))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(btnSave, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btnCncl)
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(comboItems, javax.swing.GroupLayout.PREFERRED_SIZE, 241, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtJml, javax.swing.GroupLayout.DEFAULT_SIZE, 65, Short.MAX_VALUE))
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(btnNew, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnAdd, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnRmv, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(codeText, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnNew, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(comboItems, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnAdd)
                    .addComponent(txtJml, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(btnRmv))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 259, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnSave)
                    .addComponent(btnCncl))
                .addContainerGap(47, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnNewActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNewActionPerformed
        this.txtJml.setText("1");
        this.btnNew.setEnabled(false);
        this.btnCncl.setEnabled(true);
        this.btnAdd.setEnabled(true);
        this.txtJml.setEnabled(true);
        this.comboItems.setEnabled(true);
        this.codeText.setText(this.setCode());
    }//GEN-LAST:event_btnNewActionPerformed

    private void codeTextActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_codeTextActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_codeTextActionPerformed

    private void comboItemsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_comboItemsActionPerformed
        // TODO add your handling code here:
        
    }//GEN-LAST:event_comboItemsActionPerformed

    private void txtJmlActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtJmlActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtJmlActionPerformed

    private void btnAddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddActionPerformed
        //untuk mendapatkan selected item pada comboItems
        String nama = this.comboItems.getSelectedItem().toString();
        //untuk mendapatkan txtJml sebagai tipe data integer
        int jumlah = new Integer(this.txtJml.getText());
        //untuk mengecek jika ada item yang kembar
        if(isDuplicate(nama)) {
            updateJumlah(nama, jumlah);
        }else{
            tbModel.addRow(addItem(nama, jumlah));
        }
        this.cartCheck();
    }//GEN-LAST:event_btnAddActionPerformed

    private void btnSaveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSaveActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnSaveActionPerformed

    private void btnCnclActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCnclActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnCnclActionPerformed

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
            java.util.logging.Logger.getLogger(Frame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Frame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Frame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Frame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        
        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Frame().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAdd;
    private javax.swing.JButton btnCncl;
    private javax.swing.JButton btnNew;
    private javax.swing.JButton btnRmv;
    private javax.swing.JButton btnSave;
    private javax.swing.JTextField codeText;
    private javax.swing.JComboBox<String> comboItems;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tblListItems;
    private javax.swing.JTextField txtJml;
    // End of variables declaration//GEN-END:variables
}
