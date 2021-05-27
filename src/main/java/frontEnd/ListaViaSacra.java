/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package frontEnd;


import static frontEnd.Inicio.getConnection;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;


/**
 *
 * @author gonca
 */
public class ListaViaSacra extends javax.swing.JFrame {
    /**
     * Creates new form ListaMissa
     */
    ListaMissaDetalhe detalhe = new ListaMissaDetalhe();
    public ListaViaSacra() {
        initComponents();
        setExtendedState(JFrame.MAXIMIZED_BOTH);  
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
        jScrollPane3 = new javax.swing.JScrollPane();
        tblListaMissas = new javax.swing.JTable();
        jButton1 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowActivated(java.awt.event.WindowEvent evt) {
                formWindowActivated(evt);
            }
            public void windowOpened(java.awt.event.WindowEvent evt) {
                formWindowOpened(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 36)); // NOI18N
        jLabel1.setText("Lista Missas");

        tblListaMissas.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        tblListaMissas.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblListaMissasMouseClicked(evt);
            }
        });
        jScrollPane3.setViewportView(tblListaMissas);

        jButton1.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jButton1.setText("Registar Missa");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(570, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addGap(383, 383, 383)
                .addComponent(jButton1)
                .addGap(35, 35, 35))
            .addGroup(layout.createSequentialGroup()
                .addGap(32, 32, 32)
                .addComponent(jScrollPane3)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(11, 11, 11)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton1)
                    .addComponent(jLabel1))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 683, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void formWindowActivated(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowActivated
     
      
    }//GEN-LAST:event_formWindowActivated

    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened
        try {
            getDB();
        } catch (Exception ex) {
            Logger.getLogger(ListaViaSacra.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_formWindowOpened

    private void tblListaMissasMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblListaMissasMouseClicked
        
        int index = tblListaMissas.getSelectedRow();
        TableModel model = tblListaMissas.getModel();
        
        String id = model.getValueAt(index, 0).toString();
        String titulo = model.getValueAt(index, 1).toString();
        String descricao = model.getValueAt(index, 2).toString();
        String orador = model.getValueAt(index, 3).toString();
        String horaInicio = model.getValueAt(index, 4).toString();
        String horaFim = model.getValueAt(index, 5).toString();
        
        detalhe.setVisible(true);
        detalhe.pack();
        detalhe.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        
        detalhe.jLabel_dia.setText(id);
        detalhe.jLabel_titulo.setText(titulo);
        detalhe.jLabel_descricao.setText(descricao);
        detalhe.jLabel_orador.setText(orador);
        detalhe.jLabel_horainicio.setText(horaInicio);
        detalhe.jLabel_horafim.setText(horaFim);
    }//GEN-LAST:event_tblListaMissasMouseClicked

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        RegistarMissa missa = new RegistarMissa();
        missa.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_jButton1ActionPerformed

    public void getDB() throws Exception {
        Connection conn = getConnection();
      DefaultTableModel model = new DefaultTableModel();
        //Cria as colunas da tabela
        model.addColumn("id");
        model.addColumn("Titulo");
        model.addColumn("Descrição");
        model.addColumn("Orador");
        model.addColumn("Hora de Inicio");
        model.addColumn("Hora de Fim");
        
       
      try{
          String query = "SELECT idMissa,titulo,descricao,Orador_nome, Orador_cargo,horaInicio, horaFim FROM missa";
          Statement st = conn.createStatement();
          ResultSet rs = st.executeQuery(query);
         
          while(rs.next()){
              model.addRow(new Object[] {
                  rs.getString("idMissa"),
                  rs.getString("titulo"),
                  rs.getString("descricao"),
                  rs.getString("Orador_cargo")+ " " + rs.getString("orador_nome"),
                  rs.getString("horaInicio"),
                  rs.getString("horaFim")
              });
          }
          rs.close();
          st.close();
          conn.close();
          tblListaMissas.setModel(model);
      }catch(Exception e){System.out.println(e);}

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
            java.util.logging.Logger.getLogger(ListaViaSacra.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ListaViaSacra.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ListaViaSacra.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ListaViaSacra.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ListaViaSacra().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTable tblListaMissas;
    // End of variables declaration//GEN-END:variables
}
