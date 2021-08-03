
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
import static ventanas.Login.user;


public class InformacionUsuarios extends javax.swing.JFrame {

    String user,user_update="";
    int ID;
    
    public InformacionUsuarios() {
        initComponents();
           
         setResizable(false);
        setSize(700,500);
        user=Login.user;
        user_update=GestionarUsuarios.user_update;
         setTitle("REGISTRAR VENDEDOR "+user_update+"sesion  de "+user);
        
        setLocationRelativeTo(null);
         setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
         
         ImageIcon wallpaper = new ImageIcon("src/mages/wallpaperPrincipal.jpg");
        Icon icono =new ImageIcon(wallpaper.getImage().getScaledInstance(wall.getWidth(),
                wall.getHeight(),Image.SCALE_DEFAULT));
     wall.setIcon(icono);
       wall.repaint();
       
       titulo.setText("Informacion del Usuario "+user_update);
       
       try{
           Connection cn= Conexion.conectar();
               PreparedStatement pst = cn.prepareStatement(
               "select *from usuarios where username= '" +user_update+ "'");
               ResultSet rs=pst.executeQuery();
               if(rs.next()){
                   ID=rs.getInt("id_usuario");
                   txt_nombre.setText(rs.getString("nombre_usuario"));
                     txt_email.setText(rs.getString("email"));
                       txt_telefono.setText(rs.getString("telefon"));
                         txt_user.setText(rs.getString("username"));
                           txt_registro.setText(rs.getString("registro_por"));
                           
                   cmb_permiso.setSelectedItem(rs.getString("tipo_nivel"))     ;   
                   cmb_estatus.setSelectedItem(rs.getString("tipo_nivel"));   
                   
               }
               cn.close();
               
       }catch(Exception e){
           System.err.println("error en "+e);
            JOptionPane.showMessageDialog(null, "error en acceder ,contactar con tu Aministrador");
       }
         
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
        jj = new javax.swing.JLabel();
        txt_nombre1 = new javax.swing.JLabel();
        combo = new javax.swing.JLabel();
        txt_nombre3 = new javax.swing.JLabel();
        txt_nombre4 = new javax.swing.JLabel();
        txt_nombre5 = new javax.swing.JLabel();
        txt_nombre6 = new javax.swing.JLabel();
        txt_email = new javax.swing.JTextField();
        txt_telefono = new javax.swing.JTextField();
        txt_user = new javax.swing.JTextField();
        txt_registro = new javax.swing.JTextField();
        txt_nombre = new javax.swing.JTextField();
        cmb_permiso = new javax.swing.JComboBox<>();
        cmb_estatus = new javax.swing.JComboBox<>();
        password = new javax.swing.JButton();
        btn_actualizar = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        wall = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        titulo.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        titulo.setForeground(new java.awt.Color(255, 255, 255));
        titulo.setText("Informacion del Usuarios");
        getContentPane().add(titulo, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 20, 460, 30));

        jj.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        jj.setForeground(new java.awt.Color(255, 255, 255));
        jj.setText("Email:");
        getContentPane().add(jj, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 140, 70, 40));

        txt_nombre1.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        txt_nombre1.setForeground(new java.awt.Color(255, 255, 255));
        txt_nombre1.setText("Telefono:");
        getContentPane().add(txt_nombre1, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 210, 70, 40));

        combo.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        combo.setForeground(new java.awt.Color(255, 255, 255));
        combo.setText("Permiso de:");
        getContentPane().add(combo, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 280, 100, 40));

        txt_nombre3.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        txt_nombre3.setForeground(new java.awt.Color(255, 255, 255));
        txt_nombre3.setText("Username");
        getContentPane().add(txt_nombre3, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 70, 90, 40));

        txt_nombre4.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        txt_nombre4.setForeground(new java.awt.Color(255, 255, 255));
        txt_nombre4.setText("Estatus");
        getContentPane().add(txt_nombre4, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 140, 70, 40));

        txt_nombre5.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        txt_nombre5.setForeground(new java.awt.Color(255, 255, 255));
        txt_nombre5.setText("registro por:");
        getContentPane().add(txt_nombre5, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 210, 110, 40));

        txt_nombre6.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        txt_nombre6.setForeground(new java.awt.Color(255, 255, 255));
        txt_nombre6.setText("Nombre:");
        getContentPane().add(txt_nombre6, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 70, 70, 40));

        txt_email.setBackground(new java.awt.Color(153, 153, 255));
        txt_email.setFont(new java.awt.Font("Arial", 1, 16)); // NOI18N
        txt_email.setForeground(new java.awt.Color(255, 255, 255));
        txt_email.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        getContentPane().add(txt_email, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 180, 240, 30));

        txt_telefono.setBackground(new java.awt.Color(153, 153, 255));
        txt_telefono.setFont(new java.awt.Font("Arial", 1, 16)); // NOI18N
        txt_telefono.setForeground(new java.awt.Color(255, 255, 255));
        txt_telefono.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        getContentPane().add(txt_telefono, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 250, 240, 30));

        txt_user.setBackground(new java.awt.Color(153, 153, 255));
        txt_user.setFont(new java.awt.Font("Arial", 1, 16)); // NOI18N
        txt_user.setForeground(new java.awt.Color(255, 255, 255));
        txt_user.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txt_user.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_userActionPerformed(evt);
            }
        });
        getContentPane().add(txt_user, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 110, 200, 30));

        txt_registro.setBackground(new java.awt.Color(153, 153, 255));
        txt_registro.setFont(new java.awt.Font("Arial", 1, 16)); // NOI18N
        txt_registro.setForeground(new java.awt.Color(255, 255, 255));
        txt_registro.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txt_registro.setEnabled(false);
        txt_registro.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_registroActionPerformed(evt);
            }
        });
        getContentPane().add(txt_registro, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 250, 220, 30));

        txt_nombre.setBackground(new java.awt.Color(153, 153, 255));
        txt_nombre.setFont(new java.awt.Font("Arial", 1, 16)); // NOI18N
        txt_nombre.setForeground(new java.awt.Color(255, 255, 255));
        txt_nombre.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txt_nombre.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_nombreActionPerformed(evt);
            }
        });
        getContentPane().add(txt_nombre, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 110, 240, 30));

        cmb_permiso.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Administrador", "Capturista", "Tecnico" }));
        cmb_permiso.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmb_permisoActionPerformed(evt);
            }
        });
        getContentPane().add(cmb_permiso, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 320, 110, -1));

        cmb_estatus.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Activo", "Inactivo" }));
        cmb_estatus.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmb_estatusActionPerformed(evt);
            }
        });
        getContentPane().add(cmb_estatus, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 190, 100, -1));

        password.setBackground(new java.awt.Color(153, 153, 255));
        password.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        password.setForeground(new java.awt.Color(255, 255, 255));
        password.setText("Actualizar Password");
        password.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                passwordActionPerformed(evt);
            }
        });
        getContentPane().add(password, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 370, 220, 40));

        btn_actualizar.setBackground(new java.awt.Color(153, 153, 255));
        btn_actualizar.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        btn_actualizar.setForeground(new java.awt.Color(255, 255, 255));
        btn_actualizar.setText("Actualizar Usuario");
        btn_actualizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_actualizarActionPerformed(evt);
            }
        });
        getContentPane().add(btn_actualizar, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 310, 220, 40));

        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("Creado por yvon voyelle");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 434, 190, 30));

        wall.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                wallMouseClicked(evt);
            }
        });
        getContentPane().add(wall, new org.netbeans.lib.awtextra.AbsoluteConstraints(-40, 0, 740, 500));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void wallMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_wallMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_wallMouseClicked

    private void btn_actualizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_actualizarActionPerformed
       
       int permiso_cmb,estatus_cmb,validacion=0;
       String nombre,email,telefono,username,pass,permiso_string="",estatus_string="";
       
       nombre=txt_nombre.getText().trim();
       email=txt_email.getText().trim();
       telefono=txt_telefono.getText().trim();
       username=txt_user.getText().trim();
       pass=password.getText().trim();
       permiso_cmb=cmb_estatus.getSelectedIndex()+1;
       estatus_cmb=cmb_estatus.getSelectedIndex()+1;
       
       if(nombre.equals("")){
           txt_nombre.setBackground(Color.red);
           validacion++;
       }
        if(email.equals("")){
           txt_email.setBackground(Color.red);
           validacion++;
       }
        if(telefono.equals("")){
           txt_telefono.setBackground(Color.red);
           validacion++;
       }
       if(username.equals("")){
           txt_user.setBackground(Color.red);
           validacion++;
       } 
        if(validacion==0){
            if(permiso_cmb==1){
                permiso_string="Administrador"; 
            }else if(permiso_cmb==2){
                permiso_string="Capturista";     
            }else if(permiso_cmb==3){
                permiso_string="Tecnico"; 
                    
                    }
           if(estatus_cmb==1){
               estatus_string="Activo";
               
           }else if(estatus_cmb==2){
               estatus_string="Inactivo"; 
               
           }
            
               try{
                    Connection cn= Conexion.conectar();
               PreparedStatement pst = cn.prepareStatement(
              "select username  from usuarios where username= '" +username +"'and not id_usuario = '"+ID+"'");
               ResultSet rs=pst.executeQuery();
               
               if(rs.next()){
                   txt_user.setBackground(Color.red);
                   cn.close();
                   JOptionPane.showMessageDialog(null,"este nombre no es disponibre");
                   
               }else{
                   try{
                      Connection cn2= Conexion.conectar();
               PreparedStatement pst2 = cn2.prepareStatement(
                       "update usuarios set nombre_usuario=?,email=?,telefon=?,username=?,tipo_nivel=?,estatus=? "
                               + "where id_usuario= '"+ID+"'");
               
               pst2.setString(1, nombre);
                  pst2.setString(2, email);
                     pst2.setString(3, telefono);
                        pst2.setString(4, username);
                           pst2.setString(5,permiso_string );
                              pst2.setString(6,estatus_string);
                              pst2.executeUpdate();
                              cn2.close();
                              JOptionPane.showMessageDialog(null, "la modificacion fue exitosa"); 
                   }catch(Exception e){
                      
                     JOptionPane.showMessageDialog(null, "error en "+e);   
                   }
                    
               }
               
                   
               }catch(Exception e){
                   System.out.println("error en la base de datos "+e);   
               }
               
               
            
        }else{
            JOptionPane.showMessageDialog(null, "debe llenar todos los campos");
        
        
        }
    }//GEN-LAST:event_btn_actualizarActionPerformed

    private void txt_userActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_userActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_userActionPerformed

    private void txt_registroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_registroActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_registroActionPerformed

    private void cmb_estatusActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmb_estatusActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cmb_estatusActionPerformed

    private void cmb_permisoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmb_permisoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cmb_permisoActionPerformed

    private void txt_nombreActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_nombreActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_nombreActionPerformed

    private void passwordActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_passwordActionPerformed
      RestorarPassword restorar= new RestorarPassword();
      restorar.setVisible(true);
    }//GEN-LAST:event_passwordActionPerformed

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
            java.util.logging.Logger.getLogger(InformacionUsuarios.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(InformacionUsuarios.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(InformacionUsuarios.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(InformacionUsuarios.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new InformacionUsuarios().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_actualizar;
    private javax.swing.JComboBox<String> cmb_estatus;
    private javax.swing.JComboBox<String> cmb_permiso;
    private javax.swing.JLabel combo;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jj;
    private javax.swing.JButton password;
    private javax.swing.JLabel titulo;
    private javax.swing.JTextField txt_email;
    private javax.swing.JTextField txt_nombre;
    private javax.swing.JLabel txt_nombre1;
    private javax.swing.JLabel txt_nombre3;
    private javax.swing.JLabel txt_nombre4;
    private javax.swing.JLabel txt_nombre5;
    private javax.swing.JLabel txt_nombre6;
    private javax.swing.JTextField txt_registro;
    private javax.swing.JTextField txt_telefono;
    private javax.swing.JTextField txt_user;
    private javax.swing.JLabel wall;
    // End of variables declaration//GEN-END:variables
}
