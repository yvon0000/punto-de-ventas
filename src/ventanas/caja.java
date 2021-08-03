package ventanas;

import clases.Conexion;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import static javax.swing.WindowConstants.DISPOSE_ON_CLOSE;
import javax.swing.table.DefaultTableModel;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import net.sf.jasperreports.engine.util.JRLoader;
import net.sf.jasperreports.view.JasperViewer;

import com.itextpdf.text.BadElementException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import java.sql.*;
import javax.swing.table.DefaultTableModel;

import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Document;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import java.awt.HeadlessException;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.util.logging.Level;
import java.util.logging.Logger;

import com.itextpdf.text.Chunk;
import com.itextpdf.text.Image;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.FontFactory;
import com.itextpdf.text.BaseColor;
import static com.itextpdf.text.Chunk.NEWLINE;
import com.itextpdf.text.Element;
import com.itextpdf.text.Font;
import com.itextpdf.text.Phrase;
import static com.itextpdf.text.pdf.PdfName.ID;
import com.itextpdf.text.pdf.PdfPCell;
import static com.sun.org.apache.xalan.internal.lib.ExsltDatetime.date;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.io.IOException;

import java.awt.HeadlessException;
import java.awt.event.KeyEvent;
import java.awt.print.PageFormat;
import java.awt.print.Printable;
import static java.awt.print.Printable.NO_SUCH_PAGE;
import static java.awt.print.Printable.PAGE_EXISTS;
import java.awt.print.PrinterException;
import java.awt.print.PrinterJob;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.sql.Connection;
import java.util.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Time;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.WindowConstants;
import static javax.swing.WindowConstants.DISPOSE_ON_CLOSE;
import javax.swing.table.DefaultTableModel;



import java.awt.print.PrinterJob;
import java.time.LocalDate;
import java.time.LocalTime;
import javax.swing.JOptionPane;
import static ventanas.Login.user;


public class caja extends javax.swing.JFrame implements Printable  {
    DefaultTableModel modelo;//
String user,nombre_usuario="";
    public static int sesion_usuario;
     int monto=0;
    double vuelto=0;
    double iva_2=0;
    
    public caja() {
        user=Login.user;
        sesion_usuario=1;
        
        
        initComponents();
        txtId.setVisible(false);
        txtPrecio.setVisible(false);
        txtNombre.setVisible(false);
        

           //setSize(1439,1095);
         
         setResizable(false);
               

        setTitle("Sistema de ventas");
       setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);
        
        
    }
     void iniciarTable(){
        String[] titulos = {"Codigo","Nombres","Apellidos","Telefono","Puesto"}; // Los titulos en el encabezado de la tabla
        modelo = new DefaultTableModel(null,titulos); // Se crea el objeto Tabla con sus titulos respectivos
        tabla_P.setModel(modelo); //Seteamos la tabla empleados para que contenga el modelo de tabla que hemos creado
    }

    int fila = 0;
    double total = 0.00;

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tabla_P = new javax.swing.JTable();
        txtEliminar = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        txtPrecio = new javax.swing.JTextField();
        txtNombre = new javax.swing.JTextField();
        txtId = new javax.swing.JTextField();
        txtCodigo = new javax.swing.JTextField();
        txtCantidad = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        txtTotal = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        sencillo = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jButton4 = new javax.swing.JButton();
        jButton5 = new javax.swing.JButton();
        jSeparator1 = new javax.swing.JSeparator();
        turno = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jButton8 = new javax.swing.JButton();
        jButton9 = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        area = new javax.swing.JTextArea();
        jButton6 = new javax.swing.JButton();
        jButton7 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(255, 0, 51));

        jPanel1.setBackground(new java.awt.Color(153, 0, 0));

        tabla_P.setBackground(new java.awt.Color(204, 204, 255));
        tabla_P.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        tabla_P.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        tabla_P.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "CODIGO", "PRODUCTO", "CANTIDAD", "PRECIO"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tabla_P.setAutoscrolls(false);
        jScrollPane1.setViewportView(tabla_P);

        txtEliminar.setBackground(new java.awt.Color(102, 0, 0));
        txtEliminar.setFont(new java.awt.Font("Tahoma", 1, 36)); // NOI18N
        txtEliminar.setForeground(new java.awt.Color(255, 255, 255));
        txtEliminar.setText("Eliminar");
        txtEliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtEliminarActionPerformed(evt);
            }
        });

        jLabel4.setBackground(new java.awt.Color(102, 0, 0));
        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 36)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("Total: $");

        txtNombre.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        txtCodigo.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        txtCodigo.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        txtCodigo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtCodigoActionPerformed(evt);
            }
        });
        txtCodigo.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtCodigoKeyPressed(evt);
            }
        });

        txtCantidad.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        txtCantidad.setText("1");
        txtCantidad.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtCantidadActionPerformed(evt);
            }
        });
        txtCantidad.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtCantidadKeyPressed(evt);
            }
        });

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Cantidad");

        jLabel1.setFont(new java.awt.Font("Arial", 1, 36)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Codigo de producto");

        txtTotal.setEditable(false);
        txtTotal.setBackground(new java.awt.Color(153, 0, 0));
        txtTotal.setFont(new java.awt.Font("Tahoma", 1, 36)); // NOI18N
        txtTotal.setForeground(new java.awt.Color(255, 255, 255));
        txtTotal.setBorder(null);
        txtTotal.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtTotalActionPerformed(evt);
            }
        });

        jButton1.setBackground(new java.awt.Color(102, 0, 0));
        jButton1.setFont(new java.awt.Font("Tahoma", 1, 36)); // NOI18N
        jButton1.setForeground(new java.awt.Color(255, 255, 255));
        jButton1.setText("Calculador");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/mages/images.png"))); // NOI18N
        jButton3.setText("jButton3");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        jButton2.setBackground(new java.awt.Color(102, 0, 0));
        jButton2.setFont(new java.awt.Font("Tahoma", 1, 36)); // NOI18N
        jButton2.setForeground(new java.awt.Color(255, 255, 255));
        jButton2.setText("Efectivo");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        sencillo.setBackground(new java.awt.Color(153, 0, 0));
        sencillo.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        sencillo.setForeground(new java.awt.Color(255, 255, 255));
        sencillo.setBorder(null);
        sencillo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                sencilloActionPerformed(evt);
            }
        });

        jLabel2.setBackground(new java.awt.Color(102, 0, 0));
        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Vuelto");

        jButton4.setText("jButton4");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        jButton5.setText("jButton5");
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });

        turno.setBackground(new java.awt.Color(102, 0, 0));
        turno.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        turno.setForeground(new java.awt.Color(255, 255, 255));
        turno.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                turnoActionPerformed(evt);
            }
        });

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("Vendedor");

        jButton8.setBackground(new java.awt.Color(102, 0, 0));
        jButton8.setFont(new java.awt.Font("Tahoma", 1, 36)); // NOI18N
        jButton8.setForeground(new java.awt.Color(255, 255, 255));
        jButton8.setText("Con Credido");
        jButton8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton8ActionPerformed(evt);
            }
        });

        jButton9.setText("actualizar");
        jButton9.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton9ActionPerformed(evt);
            }
        });

        area.setColumns(20);
        area.setFont(new java.awt.Font("Monospaced", 0, 8)); // NOI18N
        area.setRows(5);
        jScrollPane2.setViewportView(area);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(35, 35, 35)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(txtNombre, javax.swing.GroupLayout.PREFERRED_SIZE, 18, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(txtId, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(txtPrecio, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(turno, javax.swing.GroupLayout.PREFERRED_SIZE, 208, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(8, 8, 8)
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 956, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addGap(865, 865, 865)
                                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 206, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(40, 40, 40)
                                .addComponent(sencillo, javax.swing.GroupLayout.PREFERRED_SIZE, 155, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 264, Short.MAX_VALUE)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 0, javax.swing.GroupLayout.PREFERRED_SIZE))))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(26, 26, 26)
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 352, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(jLabel3)
                                        .addGap(64, 64, 64)
                                        .addComponent(txtCantidad, javax.swing.GroupLayout.PREFERRED_SIZE, 132, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(313, 313, 313))
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(jButton8)
                                        .addGap(64, 64, 64)
                                        .addComponent(jButton2)
                                        .addGap(46, 46, 46)
                                        .addComponent(txtEliminar, javax.swing.GroupLayout.PREFERRED_SIZE, 199, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(18, 18, 18)))
                                .addComponent(jButton1))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(133, 133, 133)
                                .addComponent(txtCodigo, javax.swing.GroupLayout.PREFERRED_SIZE, 297, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(216, 216, 216)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel4)
                                    .addComponent(txtTotal, javax.swing.GroupLayout.PREFERRED_SIZE, 295, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(320, 320, 320)
                        .addComponent(jButton4, javax.swing.GroupLayout.PREFERRED_SIZE, 0, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(122, 122, 122)
                        .addComponent(jButton5, javax.swing.GroupLayout.PREFERRED_SIZE, 0, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(91, 91, 91)
                        .addComponent(jButton9, javax.swing.GroupLayout.PREFERRED_SIZE, 0, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(0, 0, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtId, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtNombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtPrecio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(23, 23, 23)
                                .addComponent(txtCodigo, javax.swing.GroupLayout.PREFERRED_SIZE, 66, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel4)))
                        .addGap(18, 18, 18)
                        .addComponent(txtTotal, javax.swing.GroupLayout.PREFERRED_SIZE, 62, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(17, 17, 17)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel1)
                                .addGap(63, 63, 63)
                                .addComponent(txtCantidad, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jLabel3))))
                .addGap(46, 46, 46)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 248, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 63, Short.MAX_VALUE)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(sencillo, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtEliminar, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 63, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jButton8)))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(108, 108, 108)
                                .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 63, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(turno, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(7, 7, 7)))
                        .addGap(12, 12, 12)
                        .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jButton4)
                            .addComponent(jButton5)
                            .addComponent(jButton9))
                        .addGap(284, 284, 284))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jScrollPane2)
                        .addContainerGap())))
        );

        jButton6.setBackground(new java.awt.Color(102, 0, 0));
        jButton6.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jButton6.setForeground(new java.awt.Color(255, 255, 255));
        jButton6.setText("Imprimir");
        jButton6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton6ActionPerformed(evt);
            }
        });

        jButton7.setBackground(new java.awt.Color(102, 0, 0));
        jButton7.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jButton7.setForeground(new java.awt.Color(255, 255, 255));
        jButton7.setText("boleta");
        jButton7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton7ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jButton7, javax.swing.GroupLayout.PREFERRED_SIZE, 144, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(1083, 1083, 1083)
                                .addComponent(jButton6, javax.swing.GroupLayout.PREFERRED_SIZE, 155, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 726, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jButton7, javax.swing.GroupLayout.PREFERRED_SIZE, 0, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(82, 82, 82)
                .addComponent(jButton6, javax.swing.GroupLayout.PREFERRED_SIZE, 0, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(255, 255, 255))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtCodigoKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtCodigoKeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {

            if (!"".equals(txtCodigo.getText())) {
                try {

                    Connection con = conexion.getConexion();
                 PreparedStatement pst= (PreparedStatement)con.prepareStatement("select* from productos where codigo=?");
                    pst.setString(1, txtCodigo.getText());
                    ResultSet resultado = pst.executeQuery();

                    if (resultado.next()) {
                        txtId.setText(resultado.getString("id"));
                        txtNombre.setText(resultado.getString("nombre"));
                        txtPrecio.setText(resultado.getString("precio"));
                        txtCantidad.requestFocusInWindow();
                    } else {
                        JOptionPane.showMessageDialog(null, "No se encontro producto");
                    }

                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(null, ex.toString());
                }
            }
        }
    }//GEN-LAST:event_txtCodigoKeyPressed

    private void txtCantidadKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtCantidadKeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {

            if (!"".equals(txtCantidad.getText())) {
                try {

                    double precio = Double.parseDouble(txtPrecio.getText());
                    int cantidad = Integer.parseInt(txtCantidad.getText());
                    int existencias = 0;

                    Connection con = conexion.getConexion();
                    PreparedStatement ps = con.prepareStatement("SELECT existencias FROM productos WHERE codigo=? ");
                    ps.setString(1, txtCodigo.getText());
                    ResultSet resultado = ps.executeQuery();

                    if (resultado.next()) {
                        existencias = resultado.getInt("existencias");
                    } else {
                        JOptionPane.showMessageDialog(null, "No se encontro producto");
                        return;
                    }

                    if (existencias >= cantidad) {
                        DefaultTableModel temp = (DefaultTableModel) tabla_P.getModel();
                        temp.addRow(new Object[1]);
                        int columna = 0;
                        tabla_P.setValueAt(txtCodigo.getText(), fila, columna);
                        columna++;
                        tabla_P.setValueAt(txtNombre.getText(), fila, columna);
                        columna++;
                        tabla_P.setValueAt(txtCantidad.getText(), fila, columna);
                        columna++;
                        double importe = precio * cantidad;
                        tabla_P.setValueAt(importe, fila, columna);

                        fila++;
                        limpiarCajas();
                        actualizaPago();
                        txtCodigo.requestFocusInWindow();

                    } else {
                        JOptionPane.showMessageDialog(null, "No hay existencias suficientes");
                    }

                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(null, "error en parte "+ex);
                }
            }
        }
    }//GEN-LAST:event_txtCantidadKeyPressed

    private void txtEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtEliminarActionPerformed

        DefaultTableModel temp = (DefaultTableModel) tabla_P.getModel();
        temp.removeRow(tabla_P.getSelectedRow());
        fila--;
        actualizaPago();
        txtCodigo.requestFocusInWindow();

    }//GEN-LAST:event_txtEliminarActionPerformed

    private void txtCantidadActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtCantidadActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtCantidadActionPerformed

    private void txtTotalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtTotalActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtTotalActionPerformed




    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed

        
   Calculadora tarea = new Calculadora();
        tarea.setBounds(0, 0, 500, 500);
        tarea.setVisible(true);
        tarea.setResizable(true);
       
        
      
    }//GEN-LAST:event_jButton1ActionPerformed

    public void pagar(){
        if (fila == 0) {
            JOptionPane.showMessageDialog(null, "No hay articulos en la venta");
        } else {

            try {

                int idVenta = 0;

                Connection con = conexion.getConexion();
                PreparedStatement ps = con.prepareStatement("INSERT INTO ventas (total, fecha) VALUES (?,NOW())", Statement.RETURN_GENERATED_KEYS);
                ps.setDouble(1, total);

                /*java.util.Date fecha;
                fecha = new Date();
                long milisegundos = fecha.getTime();
                java.sql.Date horasql = new Date(milisegundos);
                Time tiempo = new Time(milisegundos);

                ps.setString(2, "" + horasql + " " + tiempo);*/
                ps.executeUpdate();

                ResultSet resultado = ps.getGeneratedKeys();
                resultado.next();
                idVenta = resultado.getInt(1);

                if (idVenta == 0) {
                    JOptionPane.showMessageDialog(null, "Error al guardar venta");
                    return;
                }
               // pdf();

                agregaProductos(idVenta);
             

                limpiarCajas();
                limpiaTabla();
       
                
                total = 0.000;
                txtTotal.setText("0.000");

               

                txtCodigo.requestFocus();

            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, e.toString());
            }
        }
      
    }
    
  
    
    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
bill();
iva2();
    
pagar();
  

        try {
            area.print();
        } catch (PrinterException ex) {
            Logger.getLogger(caja.class.getName()).log(Level.SEVERE, null, ex);
        }
 dispose();
        caja caj =new caja();

caj.setVisible(true);

            




    }//GEN-LAST:event_jButton3ActionPerformed

    private void txtCodigoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtCodigoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtCodigoActionPerformed
  public void iva1(){
      String efectivo="EFECTIVO";
      double total_sinIva=0;
      double iva_total=0;
       iva_2= (total *0.19);
       iva_total=total-iva_2;
       
       area.setText(area.getText()+"Sub Total :"+iva_total);
          area.setText(area.getText()+"\n");
           area.setText(area.getText()+"IVA :"+iva_2+"\n ");
            area.setText(area.getText()+"\n");
            
     area.setText(area.getText()+"total :"+total+"\n");
     area.setText(area.getText()+"\n");
     area.setText(area.getText()+"Forma de Pago : "+efectivo);
     area.setText(area.getText()+"\n");
     area.setText(area.getText()+"Vuelto :"+vuelto+"\n");
      area.setText(area.getText()+"------------------------------\n");
       area.setText(area.getText()+"Gracias por compra con Nosotros\n");
      area.setText(area.getText()+"*********************************\n");
    }
  
    public void iva2(){
      String efectivo="TARJETA DEBITO";
      double total_sinIva=0;
      double iva_total=0;
       iva_2= (total *0.19);
       iva_total=total-iva_2;
       
       area.setText(area.getText()+"Sub Total :"+iva_total);
          area.setText(area.getText()+"\n");
           area.setText(area.getText()+"IVA :"+iva_2+"\n ");
            area.setText(area.getText()+"\n");
            
     area.setText(area.getText()+"total :"+total+"\n");
     area.setText(area.getText()+"\n");
     area.setText(area.getText()+"Forma de Pago : "+efectivo);
     area.setText(area.getText()+"\n");
     area.setText(area.getText()+"Vuelto :"+vuelto+"\n");
      area.setText(area.getText()+"------------------------------\n");
       area.setText(area.getText()+"Gracias por compra con Nosotros\n");
      area.setText(area.getText()+"*********************************\n");
    }
    
  /*  public void iva3(){
      String efectivo="CREDITO";
      double total_sinIva=0;
      double iva_total=0;
       iva_2= (total *0.19);
       iva_total=total-iva_2;
       
       double total_pagar=0;
       
       
       area.setText(area.getText()+"Sub Total :"+iva_total);
          area.setText(area.getText()+"\n");
           area.setText(area.getText()+"IVA :"+iva_2+"\n ");
            area.setText(area.getText()+"\n");
            
     area.setText(area.getText()+"total :"+total+"\n");
     area.setText(area.getText()+"\n");
     area.setText(area.getText()+"Forma de Pago : "+efectivo);
     area.setText(area.getText()+"\n");
     area.setText(area.getText()+"Saldo es :"+vuelto+"\n");
      area.setText(area.getText()+"------------------------------\n");
       area.setText(area.getText()+"Gracias por compra con Nosotros\n");
      area.setText(area.getText()+"*********************************\n");
    }*/
    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
 
   
   monto=Integer.parseInt(JOptionPane.showInputDialog(null,"INGRESE EL MONTO"));
   
  
if(monto>total){
   
    
    vuelto=monto-total;
    sencillo.setText(String.format("%.2f", vuelto));
   
   
    
    //sencillo.setText("");
    
    
}else{
      JOptionPane.showMessageDialog(null, "no hay vuelto:");
      bill();
iva1();
}
try {
    bill();
     
iva1();
            area.print();
        } catch (PrinterException ex) {
            Logger.getLogger(caja.class.getName()).log(Level.SEVERE, null, ex);
        }

pagar();

 dispose();
        caja caj =new caja();

caj.setVisible(true);
    }//GEN-LAST:event_jButton2ActionPerformed

    private void sencilloActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_sencilloActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_sencilloActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
     
       
    
    /* Document documento= new Document();


     try {
         String ruta=System.getProperty("user.home");
         
             PdfWriter.getInstance(documento, new FileOutputStream(ruta+ "/Desktop/Reporte productos.pdf"));
              documento.open();
           PdfPTable tabla= new PdfPTable(5);
           tabla.addCell("id");
           tabla.addCell("codigo");
           tabla.addCell("nombre");
           tabla.addCell("precio");
           tabla.addCell("cantidad");
           
            try{
              Connection con = conexion.getConexion();
             
              PreparedStatement pst =con.prepareStatement("SELECT *FROM productos");
             ResultSet rs=pst.executeQuery();
             
             if(rs.next()){
                do{
                 tabla.addCell(rs.getString(1));
                 tabla.addCell(rs.getString(2));
                 tabla.addCell(rs.getString(3));
                 tabla.addCell(rs.getString(4));
                 tabla.addCell(rs.getString(5));
                 
                    
                } while(rs.next());
                documento.add(tabla);
             }
          }catch(DocumentException | SQLException e){
               JOptionPane.showMessageDialog(null, "error en "+e); 
              
             
             
     }
           
            
        
     } catch(Exception e){
               JOptionPane.showMessageDialog(null, "error en "+e);  
        
     } */
    }//GEN-LAST:event_jButton4ActionPerformed

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
 java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new imp().setVisible(true);
            }
        });        // TODO add your handling code here:
    }//GEN-LAST:event_jButton5ActionPerformed

    private void jButton6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton6ActionPerformed

        
        
       bill();
       iva2();
      
        try {
            area.print();
        } catch (PrinterException ex) {
            Logger.getLogger(caja.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jButton6ActionPerformed

    private void jButton7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton7ActionPerformed
bill();
iva1();
    }//GEN-LAST:event_jButton7ActionPerformed

    private void turnoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_turnoActionPerformed

     String vendedor= " "+user;
     turno.setText(user);
    }//GEN-LAST:event_turnoActionPerformed

    private void jButton8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton8ActionPerformed
int run;

              int txt_credito=0; 
                    double credito = 0;
        
   run=Integer.parseInt(JOptionPane.showInputDialog(null,"IGRESE RUN DEL CLIENTE....."));
  
          try{
           
               Connection con = conexion.getConexion();
            PreparedStatement pst;
            pst = con.prepareStatement( "select credito from cliente_con_credito where run_usuario = '" + run+ "'");
              ResultSet resultado= pst.executeQuery();
                    if (resultado.next()) {
                        
              
                          credito = resultado.getDouble("credito");
                        
                         monto=Integer.parseInt(JOptionPane.showInputDialog(null,"INGRESE EL MONTO"));
                        if(monto>credito){
                        
                         JOptionPane.showMessageDialog(null, "!!!!!!! EL CLIENTE NO TIENE SUFICIENTE DE CREDITO PARA REALIZAR ESTE COMPRA");   
                           
                        }else{
                            
                            
                        
                            
                            
                         double total_pagar=0;
                                    total_pagar=  credito-monto;
                       
                              area.setText(area.getText()+"Saldo es :"+total_pagar+"\n");
                             JOptionPane.showMessageDialog(null, "La trasacion realizando corecto"+total_pagar);
   
                            
                        
                                  try{
             Connection con3 = conexion.getConexion();
            PreparedStatement pst3;
               int run_=Integer.parseInt(JOptionPane.showInputDialog(null,"CONFIRME EL RUN....."));
            pst3 = con3.prepareStatement( "update cliente_con_credito set credito =? where run_usuario = '" + run_+ "'");
             if(run!=run_){
             JOptionPane.showMessageDialog(null, "EL RUN NO SON COECIDENTE");
                }else{
            monto=Integer.parseInt(JOptionPane.showInputDialog(null,"IGRESE EL MONTO NUEVAMENTE....."));
            
           
                total_pagar=  credito-monto;
            pst3.setDouble(1,total_pagar );
            
            
                      int rest=pst3.executeUpdate();
                       bill(); 
                       
                       
                         try {
            Connection con_3 = conexion.getConexion();
            PreparedStatement ps_0;
            ps_0 = con.prepareStatement("INSERT INTO Deuda (nombre_vendedor, run_cliente, deuda) VALUES (?,?,?)");
            ps_0.setString(1, user);
            ps_0.setDouble(2, run);
            ps_0.setDouble(3, total);
      

            int resul_3 = ps_0.executeUpdate();

            if (resul_3 > 0) {
              
               
             
            } else {
               
            }

        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, ex.toString());
        }
     //iva3();
     
     
     
     
     
        
      String efectivo="CREDITO";
      double total_sinIva=0;
      double iva_total=0;
       iva_2= (total *0.19);
       iva_total=total-iva_2;
       
   
       
       
       area.setText(area.getText()+"Sub Total :"+iva_total);
          area.setText(area.getText()+"\n");
           area.setText(area.getText()+"IVA :"+iva_2+"\n ");
            area.setText(area.getText()+"\n");
            
     area.setText(area.getText()+"total :"+total+"\n");
     area.setText(area.getText()+"\n");
     area.setText(area.getText()+"Forma de Pago : "+efectivo);
     area.setText(area.getText()+"\n");
     area.setText(area.getText()+"Tu saldo es:"+total_pagar+"\n");
      area.setText(area.getText()+"------------------------------\n");
       area.setText(area.getText()+"Gracias por compra con Nosotros\n");
      area.setText(area.getText()+"*********************************\n");
    
     
     
     
     
     
     
     
     
     
     
     
     
     
     
     
     
     
     
     
     
     
     pagar();
     try {
            area.print();
        } catch (PrinterException ex) {
            Logger.getLogger(caja.class.getName()).log(Level.SEVERE, null, ex);
        }
 dispose();
        caja caj =new caja();

caj.setVisible(true);
     
                         
            }
            
                   
                             
                        }catch(Exception e){
                            
                        }
                        
              
                        }
                    
                    }
     
    



                        }catch(Exception e){
                            
                     
                  
                       JOptionPane.showMessageDialog(null, "!!!!!!! EL CLIENTE NO TIENE SUFICIENTE DE CREDITO PARA REALIZAR ESTE COMPRA");   
                        return;
                    }
                 
                    
    
      
          
     
   
     
    

      
    
    
          
          
          
          
          
          
          
          
          
          
          
          
          
          
     
    }//GEN-LAST:event_jButton8ActionPerformed

    private void jButton9ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton9ActionPerformed
            tablaEditarSaldoUsuario editar= new tablaEditarSaldoUsuario() ;
            editar.setVisible(true);


    }//GEN-LAST:event_jButton9ActionPerformed
    
    public void bill(){
        
          DefaultTableModel temp = (DefaultTableModel) tabla_P.getModel();
          
           String rut="26.378.041-8";
    String boleta="BOLETA ELECTRONICA";
    String sii=" -VCTORIA";
    String nom=" YVON VOYELLE";
    String tot= txtTotal.getText();
   
   String dir=" DIRECCION VERGARA 1155, VICTORIA ";
   String fono=" 992861875"+"\n"+ "voyelleyvon1@gmail.com";
   String vendedor= " "+user;
   
       String total=txtTotal.getText();
    
              String iva="0.190";
         String total_pagar=txtTotal.getText();
     area.setText(area.getText()+"------------------------------\n");
    area.setText("RUT :"+rut+"\n:"+boleta+"\nS.I.I"+sii+"\nNombre"+nom+"\"\n"+dir+
             "\nFono :"+fono+"\nVENDEDOR :"+user+"\n");
             area.setText(area.getText()+"\n");
            

    LocalTime  time= LocalTime.now();
 
       area.setText(area.getText()+"------------------------------\n");
LocalDate date=LocalDate.now();
   area.setText(area.getText()+"\n");
      area.setText(area.getText()+"Fecha :"+date+"\n");
   area.setText(area.getText()+"\n");
    area.setText(area.getText()+"Hora :"+time+"\n");
      area.setText(area.getText()+"------------------------------\n");
      area.setText(area.getText()+"desc"+"\t"+"cant"+"\t"+"precio"+"\t");
         area.setText(area.getText()+"\n");
         
          PdfPTable producto= new PdfPTable(3);
         producto.setWidthPercentage(30);
       producto.getDefaultCell().setBorder(0);
          producto.setHorizontalAlignment(Element.ALIGN_LEFT);
          PdfPCell pr2=new PdfPCell(new Phrase("nombre"));
          PdfPCell pr3=new PdfPCell(new Phrase("cantidad"));
          PdfPCell pr4=new PdfPCell(new Phrase("precio"));
         
         pr2.setBorder(0);
           pr3.setBorder(0);
             pr4.setBorder(0);
             
            
             producto.addCell(pr2);
             producto.addCell(pr3);
             producto.addCell(pr4);
             
             for (int i = 0; i < tabla_P.getRowCount(); i++) {
                 String nomb =tabla_P.getValueAt(i, 1).toString();
                 String cant =tabla_P.getValueAt(i, 2).toString();
                 String pre =tabla_P.getValueAt(i, 3).toString();
                 
                    area.setText(area.getText()+"\n");
                       
                  producto.addCell(nomb);
                   producto.addCell(cant);
                    producto.addCell(pre);
                     area.setText(area.getText()+nomb+"\t"+cant+"\t"+pre+"\t");
                     
         }
             area.setText(area.getText()+"\n");
              area.setText(area.getText()+"\n");
  

                   
     
     
     
     
   
     
    

      
    
    }
    
    private void limpiarCajas() {
        txtCodigo.setText("");
        txtId.setText("");
        txtNombre.setText("");
        //txtCantidad.setText("");
        txtPrecio.setText("");
    }

    private void actualizaPago() {
        int monto=0;
    double vuelto=0;
    double iva=0;
    
      
        total = 0.000;

        int numeroFilas = tabla_P.getRowCount();

        for (int a = 0; a < numeroFilas; a++) {
            total = total + Double.parseDouble(String.valueOf(tabla_P.getModel().getValueAt(a, 3)));
        
        }
        txtTotal.setText(String.format("%.2f", total));
        
       
        
      
    }

    private void agregaProductos(int idVenta) {
String user1;
    user1 = user;
        double precio;
        int id, cantidad;
        String codigo, nombre;
        int filasT = tabla_P.getRowCount();

        Connection con = conexion.getConexion();

        for (int b = 0; b < filasT; b++) {
            codigo = (String) tabla_P.getValueAt(b, 0);
            try {
                PreparedStatement ps = con.prepareStatement("SELECT id, nombre, precio FROM productos WHERE codigo=? ");
                ps.setString(1, codigo);
                ResultSet resultado = ps.executeQuery();

                while (resultado.next()) {
                    id = Integer.parseInt(resultado.getString("id"));
                    nombre = resultado.getString("nombre");
                    precio = resultado.getDouble("precio");

                    cantidad = Integer.parseInt(tabla_P.getValueAt(b, 2).toString());

                    PreparedStatement psI = con.prepareStatement("INSERT INTO detalle_venta_producto (id_venta, id_producto, nombre, precio, cantidad,nombre_vendedor) VALUES (?,?,?,?,?,?)");
                    psI.setInt(1, idVenta);
                    psI.setInt(2, id);
                    psI.setString(3, nombre);
                    psI.setDouble(4, precio);
                    psI.setInt(5, cantidad);
                    psI.setString(6, user);
                    psI.executeUpdate();

                    PreparedStatement psU = con.prepareStatement("UPDATE productos SET existencias = (existencias-?) WHERE id=?");
                    psU.setInt(1, cantidad);
                    psU.setInt(2, id);
                    psU.executeUpdate();
                    
                
                }

            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, e.toString());
            }
        }
    }

    private void limpiaTabla() {
        DefaultTableModel temp = (DefaultTableModel) tabla_P.getModel();
        int filas = tabla_P.getRowCount();

        for (int a = 0; filas > a; a++) {
            temp.removeRow(0);
        }

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
            java.util.logging.Logger.getLogger(caja.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(caja.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(caja.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(caja.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(() -> {
            new caja().setVisible(true);
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextArea area;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JButton jButton6;
    private javax.swing.JButton jButton7;
    private javax.swing.JButton jButton8;
    private javax.swing.JButton jButton9;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JTextField sencillo;
    private javax.swing.JTable tabla_P;
    private javax.swing.JTextField turno;
    private javax.swing.JTextField txtCantidad;
    private javax.swing.JTextField txtCodigo;
    private javax.swing.JButton txtEliminar;
    private javax.swing.JTextField txtId;
    private javax.swing.JTextField txtNombre;
    private javax.swing.JTextField txtPrecio;
    private javax.swing.JTextField txtTotal;
    // End of variables declaration//GEN-END:variables


 private void pdf_1(){
try{
    FileOutputStream archivo;
    File file= new File("src/imprimir/ventas.pdf");
    archivo= new FileOutputStream(file);
    Document doc= new Document();
    PdfWriter.getInstance(doc, archivo);
    doc.open();
       Image banco= Image.getInstance("src/img/banco.png");
            banco.scaleToFit(400,1000);
            banco.setAlignment(Chunk.ALIGN_CENTER);
            
              
            Paragraph parrafo = new Paragraph();
            parrafo.setAlignment(Paragraph.ALIGN_CENTER);
            
            parrafo.setFont(FontFactory.getFont("Tahoma",12,Font.BOLD,BaseColor.DARK_GRAY));
           
           
            Font negrita=new Font(Font.FontFamily.TIMES_ROMAN,12,Font.BOLD,BaseColor.BLUE);
             parrafo.add(Chunk.NEWLINE);
            
Date date=new Date();
  parrafo.add("fecha :" + new SimpleDateFormat ("dd-mm-yyyy").format(date)+"\n\n");
             
               
          PdfPTable tabla= new PdfPTable(4);
          
          tabla.setWidthPercentage(100);
          tabla.getDefaultCell().setBorder(0);
          
          
          tabla.addCell(banco);
          
   String rut="26.378.041-8";
    String boleta="BOLETA ELECTRONICA";
    String sii=" -VCTORIA";
    String nom=" YVON VOYELLE";
    String tot= txtTotal.getText();
   
   String dir=" DIRECCION:ARICA 801, VICTORIA ";
   String fono="992861875"+"\n"+ "voyelleyvon1@gmail.com";
   String vendedor= " "+user;
   
    
    tabla.addCell("");
     tabla.addCell("RUT :"+rut+"\n:"+boleta+"\nS.I.I"+sii+"\nNombre"+nom+"\"\n"+dir+
             "\nfono"+fono+"\nVENDEDOR :"+user);
    
      tabla.addCell(parrafo);
      doc.add(tabla);
      
    Paragraph usuarios= new Paragraph();
            usuarios.add(Chunk.NEWLINE); 
                 usuarios.add("Protuctos "+"\n\n");
      doc.add(usuarios);
      //productos
      
       PdfPTable producto= new PdfPTable(4);
         producto.setWidthPercentage(100);
       producto.getDefaultCell().setBorder(0);
          producto.setHorizontalAlignment(Element.ALIGN_LEFT);
          PdfPCell pr1=new PdfPCell(new Phrase("codigo"));
          PdfPCell pr2=new PdfPCell(new Phrase("nombre"));
          PdfPCell pr3=new PdfPCell(new Phrase("cantidad"));
          PdfPCell pr4=new PdfPCell(new Phrase("precio"));
           PdfPCell pro5=new  PdfPCell(new Phrase ("preio :"+tot));
          
          pr1.setBorder(0);
         pr2.setBorder(0);
           pr3.setBorder(0);
             pr4.setBorder(0);
             
             producto.addCell(pr1);
             producto.addCell(pr2);
             producto.addCell(pr3);
             producto.addCell(pr4);
             
             for (int i = 0; i < tabla_P.getRowCount(); i++) {
                 String cod =tabla_P.getValueAt(i, 0).toString();
                 String nomb =tabla_P.getValueAt(i, 1).toString();
                 String cant =tabla_P.getValueAt(i, 2).toString();
                 String pre =tabla_P.getValueAt(i, 3).toString();
                 
                 producto.addCell(cod);
                  producto.addCell(nomb);
                   producto.addCell(cant);
                    producto.addCell(pre);
                         
        
    }
          
                  
          doc.add(producto);
          
          
           PdfPTable tabla2= new PdfPTable(2);
          
          tabla2.setWidthPercentage(100);
          tabla2.getDefaultCell().setBorder(0);
          
          
          tabla.addCell(banco);
          
   
    String total=txtTotal.getText();
    
              String iva="0.190";
               String total_pagar=txtTotal.getText();

    
      Paragraph us= new Paragraph();
            us.add(Chunk.NEWLINE); 
                 us.add(" "+"\n\n");
      doc.add(us);
    
     tabla2.addCell("Neto :"+total+"\nIVA :"+iva+"\nTOTAL A PAGAR :"+total_pagar);
    
      tabla2.addCell(parrafo);
      doc.add(tabla2);
      
   
      
 doc.close();
    archivo.close();
}catch(Exception e){
    JOptionPane.showMessageDialog(null,"ou fe ere nan"+e);

}}


 
 
 
 // Variables declaration - do not modify                     
    private imprimir.inter inter1;
  
    // End of variables declaration     

    
    
    public int print(Graphics graphics, PageFormat pageFormat, int pageIndex) throws PrinterException {
        if (pageIndex == 0) {
            Graphics2D graphics2d = (Graphics2D) graphics;
            graphics2d.translate(pageFormat.getImageableX(), pageFormat.getImageableY());
            printAll(graphics2d);
            return PAGE_EXISTS;
        } else {
            return NO_SUCH_PAGE;
        }
    }
}
