
package ventanas;
import clases.Conexion;
import java.awt.Color;
import java.awt.Image;
import java.awt.Toolkit;
import java.sql.Connection;
import java.sql.DriverManager;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import java.sql.*;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.WindowConstants;
import javax.swing.table.DefaultTableModel;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
public class GestionarUsuarios extends javax.swing.JFrame {
String user;
public static String user_update;
DefaultTableModel modelo=new DefaultTableModel();
    
    public GestionarUsuarios() {
        initComponents();
        user=Login.user;
         setResizable(false);
        setSize(700,500);
        setTitle("Usuarios Registrado - session de "+user);
        setLocationRelativeTo(null);
         setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        
          ImageIcon wallpaper = new ImageIcon("src/mages/wallpaperPrincipal.jpg");
        Icon icono =new ImageIcon(wallpaper.getImage().getScaledInstance(wall.getWidth(),
                wall.getHeight(),Image.SCALE_DEFAULT));
       wall.setIcon(icono);
       wall.repaint();
       
        
       
       try{
    Connection cn=Conexion.conectar();
    PreparedStatement pst = cn.prepareStatement(
       "select id_usuario,nombre_usuario,username,tipo_nivel,estatus from usuarios");
    ResultSet rs=pst.executeQuery();
    
 tabla.setModel(modelo);
 modelo.addColumn("");
        modelo.addColumn("nombre");
        modelo.addColumn("username");
        modelo.addColumn("permiso");
         modelo.addColumn("estatus");
    
         while(rs.next()){
             Object[] filla =new Object[5];
             for (int i = 0; i < 5; i++) {
                 filla[i]=rs.getObject(i +1);
                 
             }
             modelo.addRow(filla);
             
         }
    
 }catch(Exception e){
    
}
       tabla.addMouseListener(new MouseAdapter(){
        @Override
        public void mouseClicked(MouseEvent e){
            int fila_point=tabla.rowAtPoint(e.getPoint());
            int columa_point=2;
            if(fila_point>-1){
                user_update=(String)modelo.getValueAt(fila_point, columa_point);
                InformacionUsuarios informacion=new InformacionUsuarios();
                informacion.setVisible(true);
                
            }
           
       }
           
    });
       
    }
  @Override
public Image getIconImage(){
    Image retValue = Toolkit.getDefaultToolkit().getImage(ClassLoader.getSystemResource("mages/icon.png"));
    return retValue;
}







   
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tabla = new javax.swing.JTable();
        jLabel2 = new javax.swing.JLabel();
        wall = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Usuario Registrado");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 30, -1, -1));

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
        tabla.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tablaMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tabla);

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 130, 680, 300));

        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("creado por yvon voyelle");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 434, 250, 30));

        wall.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        wall.setForeground(new java.awt.Color(255, 255, 255));
        wall.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                wallMouseClicked(evt);
            }
        });
        getContentPane().add(wall, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 700, 490));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void tablaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tablaMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_tablaMouseClicked

    private void wallMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_wallMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_wallMouseClicked

    
    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new GestionarUsuarios().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tabla;
    private javax.swing.JLabel wall;
    // End of variables declaration//GEN-END:variables
}
