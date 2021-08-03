package ventanas;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.text.DecimalFormat;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JOptionPane;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.WindowConstants;

public class Calculadora extends JFrame implements ActionListener {
  
    
    String registro;
    private final String dataBase="bancoEstado";
    private final String user="root";
    private final String password="0000";
    private final String url="jdbc:mysql://localhost:3306/"+dataBase+"?autoRecconect=true&useSSL=false";
    private Connection con=null;

    private JMenu menu;
    private JMenuBar menuBar;

    private JTextField text1;
    private JButton boton1, boton0, boton2, boton3, boton4, boton5, boton6, boton7, boton8,
            boton9, boton10, boton11, boton12, boton13, boton14, boton15, boton16;
    private JRadioButton radioBoton;
    public float valor1;
    public float valor2;
    public String resultado;

    public Calculadora() {
        setLayout(null);
        menuBar = new JMenuBar();
        setJMenuBar(menuBar);

        menu = new JMenu("Calculadora");
        menuBar.add(menu);

        text1 = new JTextField();
        text1.setBounds(10, 100, 340, 50);
        add(text1);

        boton1 = new JButton("1");
        boton1.setBounds(10, 160, 70, 50);
        add(boton1);

        boton1.addActionListener(this);

        boton2 = new JButton("2");
        boton2.setBounds(100, 160, 70, 50);
        add(boton2);
        boton2.addActionListener(this);

        boton3 = new JButton("3");
        boton3.setBounds(190, 160, 70, 50);
        add(boton3);
        boton3.addActionListener(this);

        boton4 = new JButton("+");
        boton4.setBounds(280, 160, 70, 50);
        add(boton4);
        boton4.addActionListener(this);

        boton0 = new JButton("c");
        boton0.setBounds(10, 450, 70, 50);
        add(boton0);
        boton0.addActionListener(this);

        boton5 = new JButton("4");
        boton5.setBounds(10, 230, 70, 50);
        add(boton5);
        boton5.addActionListener(this);
        boton6 = new JButton("5");
        boton6.setBounds(100, 230, 70, 50);
        add(boton6);
        boton6.addActionListener(this);
        boton7 = new JButton("6");
        boton7.setBounds(190, 230, 70, 50);
        add(boton7);
        boton7.addActionListener(this);
        boton8 = new JButton("-");
        boton8.setBounds(280, 230, 70, 50);
        add(boton8);
        boton8.addActionListener(this);
        boton9 = new JButton("7");
        boton9.setBounds(10, 300, 70, 50);
        add(boton9);
        boton9.addActionListener(this);
        boton10 = new JButton("8");
        boton10.setBounds(100, 300, 70, 50);
        add(boton10);
        boton10.addActionListener(this);
        boton11 = new JButton("9");
        boton11.setBounds(190, 300, 70, 50);
        add(boton11);
        boton11.addActionListener(this);
        boton12 = new JButton("x");
        boton12.setBounds(280, 300, 70, 50);
        add(boton12);
        boton12.addActionListener(this);
        boton13 = new JButton("0");
        boton13.setBounds(10, 370,70, 50);
        add(boton13);
        boton13.addActionListener(this);

        boton14 = new JButton(".");
        boton14.setBounds(100, 370,70, 50);
        add(boton14);
        boton14.addActionListener(this);

        boton15 = new JButton("=");
        boton15.setBounds(180, 370,70, 50);
        add(boton15);
        boton15.addActionListener(this);

        boton16 = new JButton("/");
        boton16.setBounds(280, 370,70, 50);
        add(boton16);
        boton16.addActionListener(this);
        
        
    }
    
    

    public String sincero(float resultado) {
        String retorno = "";
        retorno = Float.toString(resultado);
        if (resultado % 1 == 0) {
            retorno = retorno.substring(0, retorno.length() - 2);

            

            
        }
        return retorno;

    }

    @Override
    public void actionPerformed(ActionEvent e) {

        if (e.getSource() == boton1) {
            this.text1.setText(this.text1.getText() + "1");
        } else if (e.getSource() == boton2) {
            this.text1.setText(this.text1.getText() + "2");
        } else if (e.getSource() == boton3) {
            this.text1.setText(this.text1.getText() + "3");
        } else if (e.getSource() == boton5) {
            this.text1.setText(this.text1.getText() + "4");
        } else if (e.getSource() == boton6) {
            this.text1.setText(this.text1.getText() + "5");
        } else if (e.getSource() == boton7) {
            this.text1.setText(this.text1.getText() + "6");
        } else if (e.getSource() == boton9) {
            this.text1.setText(this.text1.getText() + "7");
        } else if (e.getSource() == boton10) {
            this.text1.setText(this.text1.getText() + "8");
        } else if (e.getSource() == boton13) {
            this.text1.setText(this.text1.getText() + "0");
        } else if (e.getSource() == boton11) {
            this.text1.setText(this.text1.getText() + "9");
        } else if (e.getSource() == boton0) {
            this.text1.setText("");
        } else if (e.getSource() == boton14) {
            if (!(this.text1.getText().contains("."))) {
                this.text1.setText(this.text1.getText() + ".");

            }

        } else if (e.getSource() == boton4) {
            this.valor1 = Float.parseFloat(this.text1.getText());
            this.resultado = "+";
            this.text1.setText("");
        } else if (e.getSource() == boton15) {
            
            this.valor2 = Float.parseFloat(this.text1.getText());
            
            switch (this.resultado) {
                
                case "+":
                    this.text1.setText(sincero(this.valor1 + this.valor2));
                    break;
                case "-":
                    this.text1.setText(sincero(this.valor1 - this.valor2));
                    break;
                case "*":
                    this.text1.setText(sincero(this.valor1 * this.valor2));
                    break;
                case "/":
                    this.text1.setText(sincero((this.valor1 / this.valor2)));

            }
        } else if (e.getSource() == boton8) {
            this.valor1 = Float.parseFloat(this.text1.getText());
            this.resultado = "-";
            this.text1.setText("");
        } else if (e.getSource() == boton15) {
            this.valor2 = Float.parseFloat(this.text1.getText());

        } else if (e.getSource() == boton12) {
            this.valor1 = Float.parseFloat(this.text1.getText());
            this.resultado = "*";
            this.text1.setText("");
        } else if (e.getSource() == boton15) {
            this.valor2 = Float.parseFloat(this.text1.getText());

        } else if (e.getSource() == boton16) {
            this.valor1 = Float.parseFloat(this.text1.getText());
            this.resultado = "/";
            this.text1.setText("");
        } else if (e.getSource() == boton15) {
            this.valor2 = Float.parseFloat(this.text1.getText());
        }

    }
    
     public  Connection getConexion(){
      
     try{
        Class.forName("com.mysql.jdbc.Driver");
        con=(Connection) DriverManager.getConnection(url,user,password);
  
     }   
      catch(Exception e){
          JOptionPane.showMessageDialog(null, "error "+e);
      }  
    return con; 
     }

    public static void main(String[] args) {
        Calculadora tarea = new Calculadora();
        tarea.setBounds(0, 0, 600, 500);
        tarea.setVisible(true);
        tarea.setResizable(true);

        tarea.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    }

}
