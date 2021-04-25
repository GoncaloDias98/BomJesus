/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package frontEnd;

import backEnd.Missa;

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
public class ListaBatizado extends javax.swing.JFrame {
    /**
     * Creates new form ListaMissa
     */
    ListaMissaDetalhe detalhe = new ListaMissaDetalhe();
    public ListaBatizado() {
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

        jLabel1 = new javax.swing.JLabel();
        jScrollPane3 = new javax.swing.JScrollPane();
        tblListaMissas = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowActivated(java.awt.event.WindowEvent evt) {
                formWindowActivated(evt);
            }
            public void windowOpened(java.awt.event.WindowEvent evt) {
                formWindowOpened(evt);
            }
        });

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

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(64, 64, 64)
                        .addComponent(jLabel1))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 453, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 317, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(31, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void formWindowActivated(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowActivated
     
      
    }//GEN-LAST:event_formWindowActivated

    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened
        try {
            getDB();
        } catch (Exception ex) {
            Logger.getLogger(ListaBatizado.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_formWindowOpened

    private void tblListaMissasMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblListaMissasMouseClicked
        
        int index = tblListaMissas.getSelectedRow();
        TableModel model = tblListaMissas.getModel();
        
        String id = model.getValueAt(index, 0).toString();
        String titulo = model.getValueAt(index, 1).toString();
        String descricao = model.getValueAt(index, 2).toString();
      //  String orador = model.getValueAt(index, 3).toString();
        String horaInicio = model.getValueAt(index, 4).toString();
        String horaFim = model.getValueAt(index, 5).toString();
        
        detalhe.setVisible(true);
        detalhe.pack();
        detalhe.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        
        detalhe.jLabel_id.setText(id);
        detalhe.jLabel_titulo.setText(titulo);
        detalhe.jLabel_descricao.setText(descricao);
       // detalhe.jLabel_orador.setText(orador);
        detalhe.jLabel_horainicio.setText(horaInicio);
        detalhe.jLabel_horafim.setText(horaFim);
    }//GEN-LAST:event_tblListaMissasMouseClicked

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
          String query = "SELECT idMissa,titulo,descricao,orador_idOrador,horaInicio, horaFim FROM missa";
          Statement st = conn.createStatement();
          ResultSet rs = st.executeQuery(query);
         
          while(rs.next()){
              model.addRow(new Object[] {
                  rs.getString("idMissa"),
                  rs.getString("titulo"),
                  rs.getString("descricao"),
                  rs.getString("orador_idOrador"),
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
            java.util.logging.Logger.getLogger(ListaBatizado.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ListaBatizado.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ListaBatizado.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ListaBatizado.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ListaBatizado().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTable tblListaMissas;
    // End of variables declaration//GEN-END:variables
}
