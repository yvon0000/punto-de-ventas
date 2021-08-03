/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ventanas;

import clases.Conexion;
import java.awt.Color;
import java.awt.Image;
import java.awt.Toolkit;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.WindowConstants;
import static ventanas.GestionarUsuarios.user_update;
import static ventanas.Login.user;
/**
 *
 * @author Jhony The Beste
 */
public class RestorarPassword extends javax.swing.JFrame {

    
    public RestorarPassword() {
      String user="",user_update="";
        initComponents();
          
    user = Login.user;
    user_update=GestionarUsuarios.user_update;
     setResizable(false);
        setSize(400,300);
         setTitle("Cambiar password para "+user_update);
          setLocationRelativeTo(null);
         setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
         
         ImageIcon wallpaper = new ImageIcon("src/mages/wallpaperPrincipal.jpg");
        Icon icono =new ImageIcon(wallpaper.getImage().getScaledInstance(wall.getWidth(),
                wall.getHeight(),Image.SCALE_DEFAULT));
     wall.setIcon(icono);
       wall.repaint();
    }
           @Override
public Image getIconImage(){
    Image retValue = Toolkit.getDefaultToolkit().getImage(ClassLoader.getSystemResource("mages/icon.png"));
    return retValue;
}

    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        titulo = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        txt_password = new javax.swing.JPasswordField();
        txt_password_confirmacion = new javax.swing.JPasswordField();
        password = new javax.swing.JButton();
        wall = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        titulo.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        titulo.setForeground(new java.awt.Color(255, 255, 255));
        titulo.setText("Restorar Password");
        getContentPane().add(titulo, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 10, 250, 30));

        jLabel7.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setText("Nuevo Password");
        getContentPane().add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 40, 160, 30));

        jLabel8.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(255, 255, 255));
        jLabel8.setText("Confirmar Password");
        getContentPane().add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 130, 170, 30));

        txt_password.setBackground(new java.awt.Color(153, 153, 255));
        txt_password.setForeground(new java.awt.Color(255, 255, 255));
        txt_password.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txt_password.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        getContentPane().add(txt_password, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 80, 220, 40));

        txt_password_confirmacion.setBackground(new java.awt.Color(153, 153, 255));
        txt_password_confirmacion.setForeground(new java.awt.Color(255, 255, 255));
        txt_password_confirmacion.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txt_password_confirmacion.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        txt_password_confirmacion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_password_confirmacionActionPerformed(evt);
            }
        });
        getContentPane().add(txt_password_confirmacion, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 170, 220, 40));

        password.setBackground(new java.awt.Color(153, 153, 255));
        password.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        password.setForeground(new java.awt.Color(255, 255, 255));
        password.setText("Actualizar Password");
        password.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                passwordActionPerformed(evt);
            }
        });
        getContentPane().add(password, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 230, 220, 40));
        getContentPane().add(wall, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 500, 380));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txt_password_confirmacionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_password_confirmacionActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_password_confirmacionActionPerformed

    private void passwordActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_passwordActionPerformed
    
String password ,confirmacion_password;
password=txt_password.getText().trim();
confirmacion_password=txt_password_confirmacion.getText();

if(!password.equals("")&& !confirmacion_password.equals("")){
    
    if(password.equals(confirmacion_password)){
  try{
      
      Connection cn= Conexion.conectar();
               PreparedStatement pst = cn.prepareStatement(
             "update usuarios set password =?  where username = '" + user_update + "'");
      pst.setString(1, password);
 pst.executeUpdate();
 cn.close();
    txt_password.setBackground(Color.green);
    txt_password_confirmacion.setBackground(Color.green);
 
          JOptionPane.showMessageDialog(null, "modificacion exitoxa");
          this.dispose();

 
  }catch(Exception e){
      System.out.println("error en" +e);
  }
        
    }else{
         txt_password_confirmacion.setBackground(Color.red);    
         JOptionPane.showMessageDialog(null, "las contraseñas no coinciden");
    }
    
    
}else{
    txt_password.setBackground(Color.red);
    txt_password_confirmacion.setBackground(Color.red);
    
    JOptionPane.showMessageDialog(null, "no se admiten password vacia");
}


        // TODO add your handling code here:
    }//GEN-LAST:event_passwordActionPerformed


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
            java.util.logging.Logger.getLogger(RestorarPassword.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(RestorarPassword.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(RestorarPassword.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(RestorarPassword.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new RestorarPassword().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JButton password;
    private javax.swing.JLabel titulo;
    private javax.swing.JPasswordField txt_password;
    private javax.swing.JPasswordField txt_password_confirmacion;
    private javax.swing.JLabel wall;
    // End of variables declaration//GEN-END:variables
}
