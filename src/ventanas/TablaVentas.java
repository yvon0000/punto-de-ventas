/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ventanas;

import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Chunk;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Font;
import com.itextpdf.text.FontFactory;
import com.itextpdf.text.Image;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import java.awt.HeadlessException;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.WindowConstants;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Jhony The Beste
 */
public class TablaVentas extends javax.swing.JFrame {
String user;
    /**
     * Creates new form TablaVentas
     */
    public TablaVentas() {
        initComponents();
         user = Login.user;
        setTitle("DETALLE DE VENTAS " + user);
        
        setLocationRelativeTo(null);
        setResizable(false);
        setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);

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
        tabla = new javax.swing.JTable();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        id = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(51, 51, 0));

        tabla.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane1.setViewportView(tabla);

        jButton1.setBackground(new java.awt.Color(153, 153, 153));
        jButton1.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jButton1.setForeground(new java.awt.Color(255, 255, 255));
        jButton1.setText("Buscar");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setBackground(new java.awt.Color(51, 51, 0));
        jButton2.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jButton2.setForeground(new java.awt.Color(255, 255, 255));
        jButton2.setText("imprimir");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jButton3.setBackground(new java.awt.Color(204, 0, 0));
        jButton3.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jButton3.setForeground(new java.awt.Color(255, 255, 255));
        jButton3.setText("Eliminar");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        jButton4.setText("jButton4");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(76, 76, 76)
                        .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 173, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(51, 51, 51)
                        .addComponent(jButton4)
                        .addGap(18, 18, 18)
                        .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 161, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 140, Short.MAX_VALUE)
                        .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 136, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 808, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(38, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 329, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(32, 32, 32)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(jButton4))))
        );

        id.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        id.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                idActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Ingrese el nombre a Eliminar");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(22, 22, 22)
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 272, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(109, 109, 109)
                        .addComponent(id, javax.swing.GroupLayout.PREFERRED_SIZE, 278, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(21, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(id, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
     
     DefaultTableModel modelo = new DefaultTableModel();
        tabla.setModel(modelo);
     
      
       double sumaTotal=0;
       double suma=0;
        try{
            Connection con = conexion.getConexion();

            PreparedStatement pst= (PreparedStatement)con.prepareStatement(
                      "select id , id_venta ,id_producto ,nombre ,precio ,cantidad ,nombre_vendedor from detalle_venta_producto");
    ResultSet rs=pst.executeQuery();
    
 tabla.setModel(modelo); 
 modelo.addColumn("id");
        modelo.addColumn("id_venta");
        modelo.addColumn("id_producto");
         modelo.addColumn("nombre");
         modelo.addColumn("precio");
         modelo.addColumn("cantidad");
         modelo.addColumn("nombre vendedor");
         
    
     
  
 while(rs.next()){
     
     suma=rs.getDouble("precio");
     sumaTotal=sumaTotal+suma;
             Object[] filla =new Object[7];
             for (int i = 0; i < 7; i++) {
                 filla[i]=rs.getObject(i +1);
                 
             }
             modelo.addRow(filla);
             
             
            
         }
  JOptionPane.showMessageDialog(null," TOTAL VENTAS ES : "+sumaTotal);  
        }catch(Exception e){
            JOptionPane.showMessageDialog(null," error"+e);
        } 
     
     
         
        
        
        
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed

   Document documento= new Document();
String ruta=System.getProperty("user.home");
        try {
            PdfWriter.getInstance(documento, new FileOutputStream(ruta+ "/Desktop/Reporte cuenta_rut.pdf"));
        
            Image banco= Image.getInstance("src/img/banco.png");
            banco.scaleToFit(400,1000);
            banco.setAlignment(Chunk.ALIGN_CENTER);
            
            Paragraph parrafo = new Paragraph();
            parrafo.setAlignment(Paragraph.ALIGN_CENTER);
            parrafo.add("pruducto creada por yvon voyelle\n\n");
            parrafo.setFont(FontFactory.getFont("Tahoma",18,Font.BOLD,BaseColor.DARK_GRAY));
            parrafo.add("Informacion de registrado \n \n");
            
            
          documento.open();
          documento.add(banco);
          documento.add(parrafo);
          
          
          PdfPTable tabla= new PdfPTable(7);
          tabla.addCell("id");
          tabla.addCell("id_venta");
          tabla.addCell("id_producto");
          tabla.addCell("nombre");
          tabla.addCell("precio");
          tabla.addCell("cantidad");
          tabla.addCell("nombre_vendedor");
       
          
          try{
                Connection con = conexion.getConexion();
         
                PreparedStatement pst= (PreparedStatement)con.prepareStatement("SELECT *FROM Detalle_venta_producto");
             ResultSet rs=pst.executeQuery();
             
             if(rs.next()){
                do{
                 tabla.addCell(rs.getString(1));
                 tabla.addCell(rs.getString(2));
                 tabla.addCell(rs.getString(3));
                 tabla.addCell(rs.getString(4));
                 tabla.addCell(rs.getString(5));
                 tabla.addCell(rs.getString(6));
                  tabla.addCell(rs.getString(7));
                
                    
                } while(rs.next());
                documento.add(tabla);
             }
          }
          catch(DocumentException | SQLException e){
              
          }
           documento.close();
           JOptionPane.showMessageDialog(null, "Reporte creada");
        }
catch(DocumentException | HeadlessException | FileNotFoundException e){
    
}       catch (Exception e) {
    JOptionPane.showMessageDialog(null,"error en image"+ e);
            Logger.getLogger(detalle_venta_producto.class.getName()).log(Level.SEVERE, null, e);
        } 
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
       
        
           try {
            Connection con = conexion.getConexion();
            PreparedStatement ps;
            ps = con.prepareStatement("DELETE FROM detalle_venta_producto WHERE nombre=?");
            ps.setString(1,id.getText());

            int resultado = ps.executeUpdate();

            if (resultado > 0) {
                JOptionPane.showMessageDialog(null, "Producto eliminado");
                
            } else {
                JOptionPane.showMessageDialog(null, "Error al eliminar producto");
            }

        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, ex.toString());
        }
        
    }//GEN-LAST:event_jButton3ActionPerformed

    private void idActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_idActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_idActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed


      
        

        // TODO add your handling code here:
    }//GEN-LAST:event_jButton4ActionPerformed

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
            java.util.logging.Logger.getLogger(TablaVentas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(TablaVentas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(TablaVentas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(TablaVentas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new TablaVentas().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField id;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tabla;
    // End of variables declaration//GEN-END:variables
}