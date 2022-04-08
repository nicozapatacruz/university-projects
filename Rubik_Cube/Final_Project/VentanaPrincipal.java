import javax.swing.*;
import java.awt.event.*;
import java.awt.*;
import java.applet.*;

public class VentanaPrincipal extends JFrame implements ActionListener
{
   public JButton Facil;
   public JButton Medio;
   public JButton Dificil;
   public JButton Libre;
   
   public VentanaPrincipal(){
       super("Cubo De Rubik");
       setSize(1000,700);
       setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
       setLayout (null);
       setLocationRelativeTo(null);
       setResizable(false);
       getContentPane().setBackground(Color.white);
       ImageIcon logo = new ImageIcon(getClass().getResource("Descargas/Cubo.png"));
       JLabel Logo = new JLabel("Hola"); 
       Logo.setBounds(310,0,350,300);
       Logo.setIcon(logo);  
       Icon icono = new ImageIcon(logo.getImage().getScaledInstance(Logo.getWidth(), Logo.getHeight(), Image.SCALE_DEFAULT));
       Logo.setIcon(icono);
       this.repaint();
       add(Logo);
       JLabel Bienvenido = new JLabel("BIENVENIDO");
       Bienvenido.setBounds(320,250,400,150);
       Bienvenido.setFont(new java.awt.Font("cooper black",0,50));
       add(Bienvenido);
       JLabel CuboJugar = new JLabel("SELECCIONE CUBO A JUGAR:");
       CuboJugar.setBounds(320,330,500,120);
       CuboJugar.setFont(new java.awt.Font("Eras Demi ITC",0,24));
       add(CuboJugar);
       Facil = new JButton("FACIL");
       Facil.addActionListener(this);
       Facil.setBounds(40,450,200,200);
       Facil.setBackground(Color.cyan);
       Facil.setFont(new java.awt.Font("Eras Demi ITC",0,36));
       add(Facil);
       Medio = new JButton("MEDIO");
       Medio.addActionListener(this);
       Medio.setBounds(280,450,200,200);
       Medio.setBackground(Color.green);
       Medio.setFont(new java.awt.Font("Eras Demi ITC",0,36));
       add(Medio);
       Dificil = new JButton("DIFICIL");
       Dificil.addActionListener(this);
       Dificil.setBounds(520,450,200,200);
       Dificil.setBackground(Color.red);
       Dificil.setFont(new java.awt.Font("Eras Demi ITC",0,36));
       add(Dificil);
       Libre = new JButton("LIBRE");
       Libre.addActionListener(this);
       Libre.setBounds(760,450,200,200);
       Libre.setBackground(Color.orange);
       Libre.setFont(new java.awt.Font("Eras Demi ITC",0,36));
       add(Libre);
       JLabel Derechos = new JLabel("Imagen tomada de: http://www.clker.com/clipart-rubiks-cube-3d.html");
       Derechos.setBounds(10,645,400,30);
       Derechos.setFont(new java.awt.Font("Arial",0,10));
       add(Derechos);
       setVisible(true);
   }
   
   //Captura El Evento Cuando Se Hace Clic En Un Boton.
   public void actionPerformed(ActionEvent e)
   {
    if(e.getSource()==Facil){
       new VentanaFacil(); 
    }
    if(e.getSource()==Medio){
       new VentanaMedio();
    }
    if(e.getSource()==Dificil){
       new VentanaDificil(); 
    }
    if(e.getSource()==Libre){
       new VentanaLibre(); 
    }
   }
   
   public static void main(String[]args)
   {
     VentanaPrincipal v = new VentanaPrincipal();
     v.setVisible(true);
   } 
   
   
}
