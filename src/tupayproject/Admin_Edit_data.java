/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tupayproject;

/**
 *
 * @author zen
 */
public class Admin_Edit_data extends javax.swing.JFrame {
    
    StringBuilder sb;
    
    /**
     * Creates new form Form_SPP_Mahasiswa
     */
    public Admin_Edit_data() {
        initComponents();
        
        //Membuat text area tidak bisa diedit
        ta_print.setEditable(false);
        
        sb = new StringBuilder();
        
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    
    public double bayarSppTetap(double sppTetap) {
        Object pilihan = cmb_generation.getSelectedItem();
        String pilihanStr = pilihan.toString();
        
        int angkatan = Integer.parseInt(pilihanStr);
        if (cmb_faculty.getSelectedItem().equals("Fakultas Sains dan Teknologi")) {
            if (angkatan == 2021) {
                 sppTetap = 2250000;
            }
            else if (angkatan == 2020) {
                sppTetap = 2150000;
            }
            else if (angkatan == 2019) {
                sppTetap = 2050000;
            }
            else if (angkatan == 2018) {
                sppTetap = 2000000;
            }
            else if (angkatan == 2017) {
                sppTetap = 1950000;
            }
            else if (angkatan == 2016) {
                sppTetap = 1850000;
            }
        }
        
        else if (cmb_faculty.getSelectedItem().equals("Fakultas Bisnis dan Humaniora")) {
            if (angkatan == 2021) {
                 sppTetap = 1750000;
            }
            else if (angkatan == 2020) {
                sppTetap = 1800000;
            }
            else if (angkatan == 2019) {
                sppTetap = 2050000;
            }
            else if (angkatan == 2018) {
                sppTetap = 2000000;
            }
            else if (angkatan == 2017) {
                sppTetap = 1950000;
            }
            else if (angkatan == 2016) {
                sppTetap = 1850000;
            }
            
        }
        
        else if (cmb_faculty.getSelectedItem().equals("Progam Diploma")) {
            if (angkatan == 2021) {
                 sppTetap = 1750000;
            }
            else if (angkatan == 2020) {
                sppTetap = 1800000;
            }
            else if (angkatan == 2019) {
                sppTetap = 2050000;
            }
            else if (angkatan == 2018) {
                sppTetap = 2000000;
            }
            else if (angkatan == 2017) {
                sppTetap = 1950000;
            }
            else if (angkatan == 2016) {
                sppTetap = 1850000;
            }
        }
        
        return sppTetap;
    }
    
    public double bayarSppVar(double sppVariabel) {
        Object pilihan = cmb_generation.getSelectedItem();
        String pilihanStr = pilihan.toString();
        int angkatan = Integer.parseInt(pilihanStr);
        String sks = txt_credits.getText();
        int jumlah_sks = Integer.parseInt(sks);
        
        if (cmb_departement.getSelectedItem().equals("Fakultas Sains dan Teknologi")) {
            if (angkatan == 2021) {
                 sppVariabel = 190000 * jumlah_sks;
            }
            else if (angkatan == 2020) {
                sppVariabel = 180000 * jumlah_sks;
            }
            else if (angkatan == 2019) {
                sppVariabel = 170000 * jumlah_sks;
            }
            else if (angkatan == 2018) {
                sppVariabel = 160000 * jumlah_sks;
            }
            else if (angkatan == 2017) {
                sppVariabel = 150000 * jumlah_sks;
            }
            else if (angkatan == 2016) {
                sppVariabel = 140000 * jumlah_sks;
            }
        }
        
        else if (cmb_departement.getSelectedItem().equals("Fakultas Bisnis dan Humaniora")) {
            if (angkatan == 2021) {
                 sppVariabel = 185000 * jumlah_sks;
            }
            else if (angkatan == 2020) {
                sppVariabel = 175000 * jumlah_sks;
            }
            else if (angkatan == 2019) {
                sppVariabel = 165000 * jumlah_sks;
            }
            else if (angkatan == 2018) {
                sppVariabel = 155000 * jumlah_sks;
            }
            else if (angkatan == 2017) {
                sppVariabel = 145000 * jumlah_sks;
            }
            else if (angkatan == 2016) {
                sppVariabel = 135000 * jumlah_sks;
            }
        }
        
        return sppVariabel;
    }
    
    public double totalSpp(double totalSpp) {
        totalSpp = bayarSppTetap(0) + bayarSppVar(totalSpp);
        return totalSpp;
    }
    
    public void printAll() {
        sb.append("\n\n------- INFO SPP MAHASISWA -------\n");
        sb.append("\nNama Mahasiswa\t : " + txt_name.getText());
        sb.append("\nNIM\t\t : " + txt_StudentNumber.getText());
        sb.append("\nAngkatan\t\t : " + cmb_generation.getSelectedItem());
        sb.append("\nSemester\t\t : " + cmb_semester.getSelectedItem());
        sb.append("\nFakultas\t\t : " + cmb_faculty.getSelectedItem());
        sb.append("\nProgram Studi\t : " + cmb_departement.getSelectedItem());
        sb.append("\nTotal SKS\t\t : " + txt_credits.getText());
        sb.append("\n\n");
        sb.append("\nSPP Tetap\t\t : " + bayarSppTetap(0));
        sb.append("\nSPP Variabel\t\t : " + bayarSppVar(0));
        sb.append("\nSPP Total\t\t : " + totalSpp(0)+"\n\n\n\n") ;
        ta_print.setText(sb.toString());
    }
    
    public void hapus() {
        txt_StudentNumber.setText(null);
        txt_credits.setText(null);
        txt_name.setText(null);
        cmb_departement.setSelectedItem(null);
        cmb_faculty.setSelectedItem(null);
        cmb_generation.setSelectedItem(null);
        cmb_semester.setSelectedItem(null);
        ta_print.setText(null);
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        txt_StudentNumber = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        txt_name = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        cmb_faculty = new javax.swing.JComboBox<>();
        jLabel7 = new javax.swing.JLabel();
        cmb_departement = new javax.swing.JComboBox<>();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        cmb_semester = new javax.swing.JComboBox<>();
        cmb_generation = new javax.swing.JComboBox<>();
        jLabel10 = new javax.swing.JLabel();
        txt_credits = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();
        btn_check = new javax.swing.JButton();
        jLabel12 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        ta_print = new javax.swing.JTextArea();
        btn_reset = new javax.swing.JButton();
        btn_submit_edited = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Dialog", 1, 24)); // NOI18N
        jLabel1.setText("TUITION PAYMENT FORM");

        jLabel2.setFont(new java.awt.Font("Dialog", 1, 24)); // NOI18N
        jLabel2.setText("UNIVERSITAS TEKNOLOGI YOGYAKARTA");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(360, 360, 360)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(jLabel2)
                    .addComponent(jLabel1))
                .addGap(360, 360, 360))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jSeparator1))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        jLabel3.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        jLabel3.setText("Transaction Form");

        jLabel4.setText("Student number");

        txt_StudentNumber.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_StudentNumberActionPerformed(evt);
            }
        });

        jLabel5.setText("Name");

        jLabel6.setText("Faculty");

        cmb_faculty.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Fakultas Bisnis dan Humaniora", "Fakultas Sains dan Teknologi", "Program Diploma" }));

        jLabel7.setText("Departement");

        cmb_departement.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Informatika", "Teknik Elektro", "Manajemen", "Akuntansi", "Pariwisata", "Teknik Komputer" }));

        jLabel8.setText("Generation");

        jLabel9.setText("Current semester");

        cmb_semester.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "1", "2", "3", "4", "5", "6", "7", "8" }));

        cmb_generation.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "2021", "2020", "2019", "2018", "2017", "2016" }));

        jLabel10.setText("Course credits");

        jLabel11.setText("Credits");

        btn_check.setText("Check");
        btn_check.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btn_checkMouseClicked(evt);
            }
        });
        btn_check.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_checkActionPerformed(evt);
            }
        });

        jLabel12.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        jLabel12.setText("Transaction Data");

        ta_print.setColumns(20);
        ta_print.setRows(5);
        jScrollPane1.setViewportView(ta_print);

        btn_reset.setBackground(new java.awt.Color(127, 35, 35));
        btn_reset.setForeground(new java.awt.Color(255, 255, 255));
        btn_reset.setText("Reset");
        btn_reset.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btn_resetMouseClicked(evt);
            }
        });

        btn_submit_edited.setBackground(new java.awt.Color(58, 120, 58));
        btn_submit_edited.setForeground(new java.awt.Color(255, 255, 255));
        btn_submit_edited.setText("Submit Edited Data");
        btn_submit_edited.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btn_submit_editedMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
            .addGroup(layout.createSequentialGroup()
                .addGap(108, 108, 108)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel3)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel4)
                            .addComponent(jLabel5)
                            .addComponent(jLabel6)
                            .addComponent(jLabel7)
                            .addComponent(jLabel8)
                            .addComponent(jLabel9)
                            .addComponent(jLabel10))
                        .addGap(65, 65, 65)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(txt_StudentNumber)
                            .addComponent(txt_name)
                            .addComponent(cmb_faculty, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(cmb_departement, javax.swing.GroupLayout.PREFERRED_SIZE, 305, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(cmb_semester, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(cmb_generation, javax.swing.GroupLayout.PREFERRED_SIZE, 134, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(txt_credits, javax.swing.GroupLayout.PREFERRED_SIZE, 134, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jLabel11))))
                    .addComponent(btn_check, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 132, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btn_reset, javax.swing.GroupLayout.PREFERRED_SIZE, 116, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(22, 22, 22)
                        .addComponent(btn_submit_edited, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jLabel12)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 513, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(62, 62, 62))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(jLabel12))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel4)
                            .addComponent(txt_StudentNumber, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel5)
                            .addComponent(txt_name, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(20, 20, 20)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel6)
                            .addComponent(cmb_faculty, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel7)
                            .addComponent(cmb_departement, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel8)
                            .addComponent(cmb_generation, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel9)
                            .addComponent(cmb_semester, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel10)
                            .addComponent(txt_credits, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel11)))
                    .addComponent(jScrollPane1))
                .addGap(29, 29, 29)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btn_check, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn_reset, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn_submit_edited, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(29, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btn_checkActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_checkActionPerformed
        // ABAIKAN
    }//GEN-LAST:event_btn_checkActionPerformed

    private void txt_StudentNumberActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_StudentNumberActionPerformed
        // ABAIKAN
    }//GEN-LAST:event_txt_StudentNumberActionPerformed

    private void btn_checkMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_checkMouseClicked
        // TODO add your handling code here:
        this.printAll();
    }//GEN-LAST:event_btn_checkMouseClicked

    private void btn_resetMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_resetMouseClicked
        // TODO add your handling code here:
        this.hapus();
    }//GEN-LAST:event_btn_resetMouseClicked

    private void btn_submit_editedMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_submit_editedMouseClicked
        // TODO add your handling code here:
        // INI DIISI SAMA CRUD (INSERT DATA KE TABEL HISTORY TRANSACTION & TRANSACTION LIST)
        
        this.setVisible(false);
        new Admin_TransactionList().setVisible(true);
    }//GEN-LAST:event_btn_submit_editedMouseClicked

    /**
     * @param args the command line arguments
     */
//    public static void main(String args[]) {
//        /* Set the Nimbus look and feel */
//        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
//        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
//         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
//         */
//        try {
//            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
//                if ("Nimbus".equals(info.getName())) {
//                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
//                    break;
//                }
//            }
//        } catch (ClassNotFoundException ex) {
//            java.util.logging.Logger.getLogger(Form_SPP_Mahasiswa.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (InstantiationException ex) {
//            java.util.logging.Logger.getLogger(Form_SPP_Mahasiswa.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (IllegalAccessException ex) {
//            java.util.logging.Logger.getLogger(Form_SPP_Mahasiswa.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
//            java.util.logging.Logger.getLogger(Form_SPP_Mahasiswa.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        }
//        //</editor-fold>
//
//        /* Create and display the form */
//        java.awt.EventQueue.invokeLater(new Runnable() {
//            public void run() {
//                new Form_SPP_Mahasiswa().setVisible(true);
//            }
//        });
//    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_check;
    private javax.swing.JButton btn_reset;
    private javax.swing.JButton btn_submit_edited;
    private javax.swing.JComboBox<String> cmb_departement;
    private javax.swing.JComboBox<String> cmb_faculty;
    private javax.swing.JComboBox<String> cmb_generation;
    private javax.swing.JComboBox<String> cmb_semester;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JTextArea ta_print;
    private javax.swing.JTextField txt_StudentNumber;
    private javax.swing.JTextField txt_credits;
    private javax.swing.JTextField txt_name;
    // End of variables declaration//GEN-END:variables
}
