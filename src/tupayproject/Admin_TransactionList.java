/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tupayproject;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.sql.*;

/**
 * @author zen
 */
public class Admin_TransactionList extends javax.swing.JFrame {
	Connection connection;

	/**
	 * Creates new form Admin_History_TransactionList
	 */
	public Admin_TransactionList() {
		initComponents();
		setLocationRelativeTo(null);
		setResizable(false);

		try {
			connection = DBConnection.connectDB("8001"); // Anda dapat menggantinya menjadi 3306 (Port default) jika Anda tidak ingin menggunakan Docker sebagai tempat database.

			// Menjalankan query untuk mengambil data pada database.
			Statement query = connection.createStatement();
			ResultSet dataResult = query.executeQuery("select * from transaction_list");

			// Membuat Jenis-jenis kolom untuk menampilkan data-data yang ada pada database.
			String[] columnHeaders = {
					"Transaction ID",
					"Name",
					"Student ID",
					"Faculty",
					"Department",
					"Generation",
					"Semester",
					"Course Credit",
					"Fixed Bill",
					"Variable Bill",
					"Total Bill"
			};

			// Menggabungkan kolom-kolom yang telah dibuat kedalam DefaultTableModel.
			DefaultTableModel transactionModel = new DefaultTableModel(columnHeaders, 0) {
				@Override
				public boolean isCellEditable(int row, int column) {
					return false;
				}
			};

			while (dataResult.next()) {
				// Variabel untuk menampung data yang telah diambil dari database.
				int TransactionId = dataResult.getInt(1);
				String StudentName = dataResult.getString(2);
				String StudentId = dataResult.getString(3);
				String StudentFaculty = dataResult.getString(4);
				String StudentDepartment = dataResult.getString(5);
				String StudentGeneration = dataResult.getString(6);
				int StudentSemester = dataResult.getInt(7);
				int StudentCredit = dataResult.getInt(8);
				double FixedBill = dataResult.getDouble(9);
				double VariableBill = dataResult.getDouble(10);
				double TotalBill = dataResult.getDouble(11);

				// Data yang akan dimasukkan pada baris tabel.
				String[] data = {
						String.valueOf(TransactionId),
						StudentName,
						StudentId,
						StudentFaculty,
						StudentDepartment,
						StudentGeneration,
						String.valueOf(StudentSemester),
						String.valueOf(StudentCredit),
						String.valueOf(FixedBill),
						String.valueOf(VariableBill),
						String.valueOf(TotalBill)
				};
				transactionModel.addRow(data); // Menambahkan baris baru menggunakan variabel data yang telah dibuat.
			}
			tbl_TransactionList.setModel(transactionModel);
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(this, "An error occured during getting connection to database", "Connection failed.", JOptionPane.ERROR_MESSAGE);

			// Kembali ke halaman awal jika terjadi kesalahan.
			dispose();
			new Home().setVisible(true);
			e.printStackTrace();
		}
	}

	/**
	 * This method is called from within the constructor to initialize the form.
	 * WARNING: Do NOT modify this code. The content of this method is always
	 * regenerated by the Form Editor.
	 */
	@SuppressWarnings("unchecked")
	// <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
	private void initComponents() {

		jPanel1 = new javax.swing.JPanel();
		jPanel2 = new javax.swing.JPanel();
		jLabel1 = new javax.swing.JLabel();
		jLabel2 = new javax.swing.JLabel();
		jSeparator1 = new javax.swing.JSeparator();
		jLabel3 = new javax.swing.JLabel();
		jScrollPane1 = new javax.swing.JScrollPane();
		tbl_TransactionList = new javax.swing.JTable();
		btn_edit = new javax.swing.JButton();
		btn_delete = new javax.swing.JButton();

		setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

		jLabel1.setFont(new java.awt.Font("Dialog", 1, 24)); // NOI18N
		jLabel1.setText("TUITION PAYMENT FORM");

		jLabel2.setFont(new java.awt.Font("Dialog", 1, 24)); // NOI18N
		jLabel2.setText("UNIVERSITAS TEKNOLOGI YOGYAKARTA");

		javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
		jPanel2.setLayout(jPanel2Layout);
		jPanel2Layout.setHorizontalGroup(
				jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
						.addGroup(jPanel2Layout.createSequentialGroup()
								.addGap(360, 360, 360)
								.addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
										.addComponent(jLabel2)
										.addComponent(jLabel1))
								.addGap(360, 360, 360))
						.addGroup(jPanel2Layout.createSequentialGroup()
								.addContainerGap()
								.addComponent(jSeparator1))
		);
		jPanel2Layout.setVerticalGroup(
				jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
						.addGroup(jPanel2Layout.createSequentialGroup()
								.addGap(18, 18, 18)
								.addComponent(jLabel1)
								.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
								.addComponent(jLabel2)
								.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
								.addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
								.addContainerGap())
		);

		jLabel3.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
		jLabel3.setText("Transaction List");

		tbl_TransactionList.setModel(new javax.swing.table.DefaultTableModel(
				new Object[][]{
						{null, null, null, null},
						{null, null, null, null},
						{null, null, null, null},
						{null, null, null, null}
				},
				new String[]{
						"Title 1", "Title 2", "Title 3", "Title 4"
				}
		));
		jScrollPane1.setViewportView(tbl_TransactionList);

		btn_edit.setBackground(new java.awt.Color(58, 120, 58));
		btn_edit.setForeground(new java.awt.Color(255, 255, 255));
		btn_edit.setText("Edit Data");
		btn_edit.addMouseListener(new java.awt.event.MouseAdapter() {
			public void mouseClicked(java.awt.event.MouseEvent evt) {
				btn_editMouseClicked(evt);
			}
		});

		btn_delete.setBackground(new java.awt.Color(127, 35, 35));
		btn_delete.setForeground(new java.awt.Color(255, 255, 255));
		btn_delete.setText("Delete Data");
		btn_delete.addMouseListener(new java.awt.event.MouseAdapter() {
			public void mouseClicked(java.awt.event.MouseEvent evt) {
				btn_deleteMouseClicked(evt);
			}
		});

		javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
		jPanel1.setLayout(jPanel1Layout);
		jPanel1Layout.setHorizontalGroup(
				jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
						.addGroup(jPanel1Layout.createSequentialGroup()
								.addContainerGap()
								.addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
								.addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
						.addGroup(jPanel1Layout.createSequentialGroup()
								.addGap(52, 52, 52)
								.addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
										.addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
												.addGroup(jPanel1Layout.createSequentialGroup()
														.addComponent(btn_edit, javax.swing.GroupLayout.PREFERRED_SIZE, 182, javax.swing.GroupLayout.PREFERRED_SIZE)
														.addGap(32, 32, 32)
														.addComponent(btn_delete, javax.swing.GroupLayout.PREFERRED_SIZE, 165, javax.swing.GroupLayout.PREFERRED_SIZE))
												.addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 1163, javax.swing.GroupLayout.PREFERRED_SIZE))
										.addComponent(jLabel3))
								.addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
		);
		jPanel1Layout.setVerticalGroup(
				jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
						.addGroup(jPanel1Layout.createSequentialGroup()
								.addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
								.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
								.addComponent(jLabel3)
								.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 21, Short.MAX_VALUE)
								.addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE)
								.addGap(18, 18, 18)
								.addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
										.addComponent(btn_delete, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
										.addComponent(btn_edit, javax.swing.GroupLayout.DEFAULT_SIZE, 43, Short.MAX_VALUE))
								.addGap(29, 29, 29))
		);

		javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
		getContentPane().setLayout(layout);
		layout.setHorizontalGroup(
				layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
						.addGroup(layout.createSequentialGroup()
								.addContainerGap()
								.addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
								.addContainerGap())
		);
		layout.setVerticalGroup(
				layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
						.addGroup(layout.createSequentialGroup()
								.addContainerGap()
								.addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
								.addContainerGap(12, Short.MAX_VALUE))
		);

		pack();
	}// </editor-fold>//GEN-END:initComponents

	private void btn_editMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_editMouseClicked
		Object dataObject;
		if (tbl_TransactionList.getSelectedRow() != -1) {
			dataObject = tbl_TransactionList.getValueAt(tbl_TransactionList.getSelectedRow(), 0);
			this.setVisible(false);
			new Admin_Edit_Data(Integer.parseInt(dataObject.toString())).setVisible(true);
		} else {
			JOptionPane.showMessageDialog(null, "Please select a data to continue.", "Select a data", JOptionPane.INFORMATION_MESSAGE);
		}
	}//GEN-LAST:event_btn_editMouseClicked

	private void btn_deleteMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_deleteMouseClicked
		// Menampilkan konfirmasi dialog untuk menghapus data
		int choice = JOptionPane.showConfirmDialog(null, "Are you sure you want to delete this data? you cannot undo this changes.", "Delete data", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);

		// Jika dipilih "Yes" maka kueri SQL akan dieksekusi
		if (choice == JOptionPane.YES_OPTION) {
			try {
				Object selectedData = tbl_TransactionList.getValueAt(tbl_TransactionList.getSelectedRow(), 0);

				// Kueri untuk menghapus data yang dipilih
				PreparedStatement deleteStatement = connection.prepareStatement("delete from transaction_list where transaction_id = ?");
				deleteStatement.setInt(1, Integer.parseInt(selectedData.toString()));

				// Jalankan kueri SQL
				deleteStatement.executeUpdate();

				JOptionPane.showMessageDialog(null, "Data has been succesfully deleted.", "Data deleted", JOptionPane.INFORMATION_MESSAGE);
				dispose();
				new Admin_TransactionList().setVisible(true);
			} catch (SQLException e) {
				JOptionPane.showMessageDialog(null, "Error occured during deleting data. Please try again.", "Error", JOptionPane.ERROR_MESSAGE);
				e.printStackTrace();
			}
		}
	}//GEN-LAST:event_btn_deleteMouseClicked

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
//            java.util.logging.Logger.getLogger(Admin_TransactionList.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (InstantiationException ex) {
//            java.util.logging.Logger.getLogger(Admin_TransactionList.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (IllegalAccessException ex) {
//            java.util.logging.Logger.getLogger(Admin_TransactionList.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
//            java.util.logging.Logger.getLogger(Admin_TransactionList.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        }
//        //</editor-fold>
//        //</editor-fold>
//
//        /* Create and display the form */
//        java.awt.EventQueue.invokeLater(new Runnable() {
//            public void run() {
//                new Admin_TransactionList().setVisible(true);
//            }
//        });
//    }

	// Variables declaration - do not modify//GEN-BEGIN:variables
	private javax.swing.JButton btn_delete;
	private javax.swing.JButton btn_edit;
	private javax.swing.JLabel jLabel1;
	private javax.swing.JLabel jLabel2;
	private javax.swing.JLabel jLabel3;
	private javax.swing.JPanel jPanel1;
	private javax.swing.JPanel jPanel2;
	private javax.swing.JScrollPane jScrollPane1;
	private javax.swing.JSeparator jSeparator1;
	private javax.swing.JTable tbl_TransactionList;
	// End of variables declaration//GEN-END:variables
}
