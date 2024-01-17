/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package inventoryproject;
import inventoryproject.C.ProcessTransactions;
import javax.swing.JOptionPane;
import java.io.IOException;
import javax.swing.table.DefaultTableModel;
import inventoryproject.C.Transactions;
import inventoryproject.C.OrderedProducts;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.Window;
import java.util.Arrays;
import javax.swing.table.TableCellRenderer;
/**
 *
 * @author NEC
 */
public class Transaction extends javax.swing.JFrame {
    /**
     * Creates new form Transaction
     */
    
    ProcessTransactions processTransaction = new ProcessTransactions();
    
    public Transaction() {
        initComponents();
        centerWindow(this); //puts the window in the center
        setResizable(false);//disable user to resize window
        try{
            processTransaction.readTransactionList();   //read transaction records in the file
            setTable(); //set the table
        }catch(IOException e){
            JOptionPane.showMessageDialog(rootPane, "Trouble processing transactions", "ALert", JOptionPane.ERROR_MESSAGE);
            dispose();  //go back to main menu frame
            MainMenuAdmin admin = new MainMenuAdmin();
            admin.setVisible(true);
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
        jScrollPane1 = new javax.swing.JScrollPane();
        transactionTable = new javax.swing.JTable();
        transactionSeeBtn = new javax.swing.JButton();
        transactionLbl = new javax.swing.JLabel();
        transactionDeleteBtn1 = new javax.swing.JButton();
        transactionLogo = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        transactionLogo1 = new javax.swing.JLabel();
        transactionLbl1 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        transactionTable1 = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField();
        changetextfield = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        totaltextfield = new javax.swing.JTextField();
        cashtextfield = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Momentum - Transaction");
        getContentPane().setLayout(new java.awt.CardLayout());

        jPanel1.setBackground(new java.awt.Color(223, 223, 223));
        jPanel1.setPreferredSize(new java.awt.Dimension(1098, 651));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        transactionTable.setFont(new java.awt.Font("Poppins", 0, 14)); // NOI18N
        transactionTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "                                                                                                      Date"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        transactionTable.setToolTipText("");
        jScrollPane1.setViewportView(transactionTable);

        jPanel1.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(354, 150, 710, 460));

        transactionSeeBtn.setFont(new java.awt.Font("Poppins", 0, 12)); // NOI18N
        transactionSeeBtn.setText("See");
        transactionSeeBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                transactionSeeBtnActionPerformed(evt);
            }
        });
        jPanel1.add(transactionSeeBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 300, 157, 45));

        transactionLbl.setFont(new java.awt.Font("Poppins", 1, 24)); // NOI18N
        transactionLbl.setForeground(new java.awt.Color(255, 255, 255));
        transactionLbl.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        transactionLbl.setText("Transactions");
        jPanel1.add(transactionLbl, new org.netbeans.lib.awtextra.AbsoluteConstraints(580, 100, 260, 31));

        transactionDeleteBtn1.setFont(new java.awt.Font("Poppins", 0, 12)); // NOI18N
        transactionDeleteBtn1.setText("Delete");
        transactionDeleteBtn1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                transactionDeleteBtn1ActionPerformed(evt);
            }
        });
        jPanel1.add(transactionDeleteBtn1, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 220, 157, 45));

        transactionLogo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/inventoryproject/logo.png"))); // NOI18N
        jPanel1.add(transactionLogo, new org.netbeans.lib.awtextra.AbsoluteConstraints(670, 20, -1, 78));

        jLabel6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/inventoryproject/back button.png"))); // NOI18N
        jLabel6.setText("jLabel6");
        jLabel6.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel6MouseClicked(evt);
            }
        });
        jPanel1.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(46, 56, 37, -1));

        jLabel8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/inventoryproject/redCar.png"))); // NOI18N
        jPanel1.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        jLabel7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/inventoryproject/tires bg.png"))); // NOI18N
        jPanel1.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        getContentPane().add(jPanel1, "card2");

        jPanel2.setBackground(new java.awt.Color(223, 223, 223));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        transactionLogo1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/inventoryproject/logo.png"))); // NOI18N
        jPanel2.add(transactionLogo1, new org.netbeans.lib.awtextra.AbsoluteConstraints(504, 41, -1, 78));

        transactionLbl1.setFont(new java.awt.Font("Poppins", 1, 24)); // NOI18N
        transactionLbl1.setForeground(new java.awt.Color(255, 255, 255));
        transactionLbl1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        transactionLbl1.setText("Transactions");
        jPanel2.add(transactionLbl1, new org.netbeans.lib.awtextra.AbsoluteConstraints(417, 125, 260, 31));

        transactionTable1.setFont(new java.awt.Font("Poppins", 0, 14)); // NOI18N
        transactionTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Brand Name", "Type", "Name", "Quantity", "Price", "Total Price"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, true, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane2.setViewportView(transactionTable1);

        jPanel2.add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(134, 203, 824, 345));

        jLabel1.setFont(new java.awt.Font("Poppins", 1, 14)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Date:");
        jPanel2.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(134, 162, -1, 35));

        jTextField1.setEditable(false);
        jTextField1.setFont(new java.awt.Font("Poppins", 0, 14)); // NOI18N
        jTextField1.setFocusable(false);
        jPanel2.add(jTextField1, new org.netbeans.lib.awtextra.AbsoluteConstraints(182, 162, 191, 30));

        changetextfield.setEditable(false);
        changetextfield.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        changetextfield.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        changetextfield.setText("0");
        jPanel2.add(changetextfield, new org.netbeans.lib.awtextra.AbsoluteConstraints(793, 578, 165, 35));

        jLabel2.setFont(new java.awt.Font("Poppins", 1, 14)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Change:");
        jPanel2.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(725, 578, -1, 35));

        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/inventoryproject/back button.png"))); // NOI18N
        jLabel3.setText("jLabel3");
        jLabel3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel3MouseClicked(evt);
            }
        });
        jPanel2.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(32, 41, 37, -1));

        jLabel4.setFont(new java.awt.Font("Poppins", 1, 14)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("Total:");
        jPanel2.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(134, 578, -1, 35));

        totaltextfield.setEditable(false);
        totaltextfield.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        totaltextfield.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        totaltextfield.setText("0");
        totaltextfield.setFocusable(false);
        jPanel2.add(totaltextfield, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 578, 165, 35));

        cashtextfield.setEditable(false);
        cashtextfield.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        cashtextfield.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        cashtextfield.setText("0");
        cashtextfield.setFocusable(false);
        jPanel2.add(cashtextfield, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 578, 165, 35));

        jLabel5.setFont(new java.awt.Font("Poppins", 1, 14)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("Cash:");
        jPanel2.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(422, 578, -1, 35));

        jLabel9.setIcon(new javax.swing.ImageIcon(getClass().getResource("/inventoryproject/tires bg.png"))); // NOI18N
        jPanel2.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        getContentPane().add(jPanel2, "card3");

        pack();
    }// </editor-fold>//GEN-END:initComponents

    //set the table 
    private void setTable(){
        DefaultTableModel model = (DefaultTableModel) transactionTable.getModel();  //get table model and set row to zero
        model.setRowCount(0);
        String[] string = new String[1];
        for(Transactions c: processTransaction.listOfTransactions){     //iterate and set the transaction records to the table
            string[0] = "                                                                     " + c.getDateAndTime();
            model.addRow(string);
        }
    }
    
    //see transaction details
    private void transactionSeeBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_transactionSeeBtnActionPerformed
        int[] index = transactionTable.getSelectedRows();   //get the row index of the seleected item
        switch (index.length) { //determine actions based on the selected items
            case 1 -> {
                DefaultTableModel model = (DefaultTableModel) transactionTable1.getModel(); //get table model
                jTextField1.setText(processTransaction.listOfTransactions.get(index[0]).getDateAndTime());  //set the date in time in the textfield
                for(OrderedProducts c: processTransaction.listOfTransactions.get(index[0]).getListOfProduct()){ //iterate and add the product ordered record to the table
                    String[] string = {c.getBrandName(), c.getType(), c.getName(), c.getAmount(), c.getPrice(), c.getTotalPrice()};
                    model.addRow(string);
                }   
                totaltextfield.setText(processTransaction.listOfTransactions.get(index[0]).getTotal()); //set cash transaction to their respective positions
                cashtextfield.setText(processTransaction.listOfTransactions.get(index[0]).getCash());
                changetextfield.setText(processTransaction.listOfTransactions.get(index[0]).getChange());
                jPanel1.setVisible(false);  //go to the transaction viewing panel
                jPanel2.setVisible(true);
            }
            case 0 -> JOptionPane.showMessageDialog(null, "Please select an Item!", "", JOptionPane.ERROR_MESSAGE); //no selected item
            default -> JOptionPane.showMessageDialog(null, "Select only one!", "", JOptionPane.ERROR_MESSAGE);  //more than one selected item
        }
    }//GEN-LAST:event_transactionSeeBtnActionPerformed

    //reverse the array for proper deletion
    public void reverseArray(int[] array){
        for(int i = 0; i < array.length / 2; i++){
            int temp = array[i];
            array[i] = array[array.length - i - 1];
            array[array.length - i - 1] = temp;
        }
    }
    
    private void transactionDeleteBtn1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_transactionDeleteBtn1ActionPerformed
        int[] index = transactionTable.getSelectedRows();   //get the selected row indexes
        if(index.length > 0){   //if the user has selected an item
            Arrays.sort(index, 0, index.length);    //sort the index for proper deletion
            reverseArray(index);    //reverse the array
            if(JOptionPane.showConfirmDialog(rootPane, "Continue?", "Confirmation", JOptionPane.OK_CANCEL_OPTION) == 0){
                for(int c: index)   //iterate while deleting transaction records
                    processTransaction.deleteTransactions(c);
                setTable(); //update tables
                JOptionPane.showMessageDialog(null, "Deleted Successfully!", "", JOptionPane.INFORMATION_MESSAGE);
            }
            else
                JOptionPane.showMessageDialog(null, "Operation cancelled!", "", JOptionPane.INFORMATION_MESSAGE);
        }
        else
            JOptionPane.showMessageDialog(rootPane, "Please select an item!", "Error", JOptionPane.ERROR_MESSAGE);
    }//GEN-LAST:event_transactionDeleteBtn1ActionPerformed

    //go to the main transaction panel
    private void jLabel3MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel3MouseClicked
        jTextField1.setText("");
        cashtextfield.setText("");
        changetextfield.setText("");
        DefaultTableModel model = (DefaultTableModel) transactionTable1.getModel();
        model.setRowCount(0);
        jPanel2.setVisible(false);
        jPanel1.setVisible(true);
    }//GEN-LAST:event_jLabel3MouseClicked

    //exit transaction records
    private void jLabel6MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel6MouseClicked
        try{
            processTransaction.exit();  //save the transaction,..., if ever there are changes
        }catch(IOException e){
            JOptionPane.showMessageDialog(rootPane, "An error has occured in saving file!", "Error", JOptionPane.ERROR_MESSAGE);
        }
        dispose();  //go to the main menu admin frame
        MainMenuAdmin admin = new MainMenuAdmin();
        admin.setVisible(true);
    }//GEN-LAST:event_jLabel6MouseClicked
    //for centering the the window
    private void centerWindow(Window w)
    {
    Toolkit tk = Toolkit.getDefaultToolkit();
    Dimension d = tk.getScreenSize();
    setLocation((d.width-w.getWidth())/2,
    (d.height-w.getHeight())/2);
    }

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
            java.util.logging.Logger.getLogger(Transaction.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Transaction.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Transaction.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Transaction.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Transaction().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField cashtextfield;
    private javax.swing.JTextField changetextfield;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField totaltextfield;
    private javax.swing.JButton transactionDeleteBtn1;
    private javax.swing.JLabel transactionLbl;
    private javax.swing.JLabel transactionLbl1;
    private javax.swing.JLabel transactionLogo;
    private javax.swing.JLabel transactionLogo1;
    private javax.swing.JButton transactionSeeBtn;
    private javax.swing.JTable transactionTable;
    private javax.swing.JTable transactionTable1;
    // End of variables declaration//GEN-END:variables
}