import javax.swing.*;
//import javax.swing.JInternalFrame;
import java.awt.event.*;
import java.awt.*;
import java.applet.*;

public class VentanaMedio extends JFrame implements ActionListener 
{
   //CARA IZQUIERDA
   public JButton Uno;
   public JButton Dos;
   public JButton Tres;
   public JButton Cuatro;
   public JButton Cinco;
   public JButton Seis;
   public JButton Siete;
   public JButton Ocho;
   public JButton Nueve;
   public JButton[][] IZQ = {{Uno, Dos, Tres}, {Cuatro, Cinco, Seis}, {Siete, Ocho, Nueve}};
   //CARA FRONTAL
   public JButton Once;
   public JButton Doce;
   public JButton Trece;
   public JButton Catorce;
   public JButton Quince;
   public JButton DiezYSeis;
   public JButton DiezYSiete;
   public JButton DiezYOcho;
   public JButton DiezYNueve;
   public JButton[][] FRO = {{Once, Doce, Trece}, {Catorce, Quince, DiezYSeis}, {DiezYSiete, DiezYOcho, DiezYNueve}};
   //CARA DERECHA
   public JButton VentiUno;
   public JButton VentiDos;
   public JButton VentiTres;
   public JButton VentiCuatro;
   public JButton VentiCinco;
   public JButton VentiSeis;
   public JButton VentiSiete;
   public JButton VentiOcho;
   public JButton VentiNueve;
   public JButton[][] DER = {{VentiUno, VentiDos, VentiTres}, {VentiCuatro, VentiCinco, VentiSeis}, {VentiSiete, VentiOcho, VentiNueve}};
   //CARA TRASERA
   public JButton TreintaYUno;
   public JButton TreintaYDos;
   public JButton TreintaYTres;
   public JButton TreintaYCuatro;
   public JButton TreintaYCinco;
   public JButton TreintaYSeis;
   public JButton TreintaYSiete;
   public JButton TreintaYOcho;
   public JButton TreintaYNueve;
   public JButton[][] TRA = {{TreintaYUno, TreintaYDos, TreintaYTres}, {TreintaYCuatro, TreintaYCinco, TreintaYSeis}, {TreintaYSiete, TreintaYOcho, TreintaYNueve}};
   //CARA ARRIBA
   public JButton CuarentaYUno;
   public JButton CuarentaYDos;
   public JButton CuarentaYTres;
   public JButton CuarentaYCuatro;
   public JButton CuarentaYCinco;
   public JButton CuarentaYSeis;
   public JButton CuarentaYSiete;
   public JButton CuarentaYOcho;
   public JButton CuarentaYNueve;
   public JButton[][] ARR = {{CuarentaYUno, CuarentaYDos, CuarentaYTres}, {CuarentaYCuatro, CuarentaYCinco, CuarentaYSeis}, {CuarentaYSiete, CuarentaYOcho, CuarentaYNueve}};
   //CARA ABAJO
   public JButton CincuentaYUno;
   public JButton CincuentaYDos;
   public JButton CincuentaYTres;
   public JButton CincuentaYCuatro;
   public JButton CincuentaYCinco;
   public JButton CincuentaYSeis;
   public JButton CincuentaYSiete;
   public JButton CincuentaYOcho;
   public JButton CincuentaYNueve;
   public JButton[][] ABA = {{CincuentaYUno, CincuentaYDos, CincuentaYTres}, {CincuentaYCuatro, CincuentaYCinco, CincuentaYSeis}, {CincuentaYSiete, CincuentaYOcho, CincuentaYNueve}};
   //BOTONES
   public JButton ArribaUno;
   public JButton ArribaDos;
   public JButton ArribaTres;
   public JButton DerechaUno;
   public JButton DerechaDos;
   public JButton DerechaTres;
   public JButton AbajoUno;
   public JButton AbajoDos;
   public JButton AbajoTres;
   public JButton IzquierdaUno;
   public JButton IzquierdaDos;
   public JButton IzquierdaTres;
   
   public JButton aux1;
   public JButton aux2;
   public JButton aux3;
   public JButton aux4, aux5, aux6;
   
   public VentanaMedio(){
       super("Medio");
       setSize(740,700);
       setLayout (null);
       setLocationRelativeTo(null);
       setResizable(false);
       
       JLabel Facil = new JLabel("MEDIO");
       Facil.setBounds(320,20,150,50);
       Facil.setFont(new java.awt.Font("Eras Demi ITC",0,30));
       add(Facil);
       
      //CARA IZQUIERDA
       JLabel Izquierda = new JLabel("IZQUIERDA");
       Izquierda.setBounds(100,255,100,50);
       Izquierda.setFont(new java.awt.Font("Arial",0,15));
       add(Izquierda);
      for (int i = 0, k = 0; i < 3; i++, k += 45){
         for (int j = 0, n = 0; j < 3; j++, n += 45){
            IZQ[i][j] = new JButton("");
            IZQ[i][j].setBounds(75 + n, 290 + k, 40, 40);
            add(IZQ[i][j]);
          }
        }
       IZQ[0][0].setBackground(Color.blue);
       IZQ[0][1].setBackground(Color.green);
       IZQ[0][2].setBackground(Color.blue);
       IZQ[1][0].setBackground(Color.green);
       IZQ[1][1].setBackground(Color.blue);
       IZQ[1][2].setBackground(Color.green);
       IZQ[2][0].setBackground(Color.blue);
       IZQ[2][1].setBackground(Color.green);
       IZQ[2][2].setBackground(Color.blue);
     
      //CARA FRONTAL
       JLabel Frontal = new JLabel("FRONTAL");
       Frontal.setBounds(255,255,100,50);
       Frontal.setFont(new java.awt.Font("Arial",0,15));
       add(Frontal);
      for (int i = 0, k = 0; i < 3; i++, k += 45){
         for (int j = 0, n = 0; j < 3; j++, n += 45){
            FRO[i][j] = new JButton("");
            FRO[i][j].setBounds(225 + n, 290 + k, 40, 40);
            add(FRO[i][j]);
          }
        }
       FRO[0][0].setBackground(Color.white);
       FRO[0][1].setBackground(Color.yellow);
       FRO[0][2].setBackground(Color.white);
       FRO[1][0].setBackground(Color.yellow);
       FRO[1][1].setBackground(Color.white);
       FRO[1][2].setBackground(Color.yellow);
       FRO[2][0].setBackground(Color.white);
       FRO[2][1].setBackground(Color.yellow);
       FRO[2][2].setBackground(Color.white);
       
      //CARA DERECHA
       JLabel Derecha = new JLabel("DERECHA");
       Derecha.setBounds(405,255,100,50);
       Derecha.setFont(new java.awt.Font("Arial",0,15));
       add(Derecha);
       for (int i = 0, k = 0; i < 3; i++, k += 45){
         for (int j = 0, n = 0; j < 3; j++, n += 45){
            DER[i][j] = new JButton("");
            DER[i][j].setBounds(375 + n, 290 + k, 40, 40);
            add(DER[i][j]);
          }
        }
       DER[0][0].setBackground(Color.green);
       DER[0][1].setBackground(Color.blue);
       DER[0][2].setBackground(Color.green);
       DER[1][0].setBackground(Color.blue);
       DER[1][1].setBackground(Color.green);
       DER[1][2].setBackground(Color.blue);
       DER[2][0].setBackground(Color.green);
       DER[2][1].setBackground(Color.blue);
       DER[2][2].setBackground(Color.green);
       
      //CARA TRASERA
       JLabel Trasera = new JLabel("TRASERA");
       Trasera.setBounds(555,255,100,50);
       Trasera.setFont(new java.awt.Font("Arial",0,15));
       add(Trasera);
       for (int i = 0, k = 0; i < 3; i++, k += 45){
         for (int j = 0, n = 0; j < 3; j++, n += 45){
            TRA[i][j] = new JButton("");
            TRA[i][j].setBounds(525 + n, 290 + k, 40, 40);
            add(TRA[i][j]);
          }
        }
       TRA[0][0].setBackground(Color.yellow);
       TRA[0][1].setBackground(Color.white);
       TRA[0][2].setBackground(Color.yellow);
       TRA[1][0].setBackground(Color.white);
       TRA[1][1].setBackground(Color.yellow);
       TRA[1][2].setBackground(Color.white);
       TRA[2][0].setBackground(Color.yellow);
       TRA[2][1].setBackground(Color.white);
       TRA[2][2].setBackground(Color.yellow);
       
      //CARA ARRIBA
       JLabel Arriba = new JLabel("ARRIBA");
       Arriba.setBounds(262,105,100,50);
       Arriba.setFont(new java.awt.Font("Arial",0,15));
       add(Arriba);
       for (int i = 0, k = 0; i < 3; i++, k += 45){
         for (int j = 0, n = 0; j < 3; j++, n += 45){
            ARR[i][j] = new JButton("");
            ARR[i][j].setBounds(225 + n, 140 + k, 40, 40);
            add(ARR[i][j]);
          }
        }
       ARR[0][0].setBackground(Color.red);
       ARR[0][1].setBackground(Color.orange);
       ARR[0][2].setBackground(Color.red);
       ARR[1][0].setBackground(Color.orange);
       ARR[1][1].setBackground(Color.red);
       ARR[1][2].setBackground(Color.orange);
       ARR[2][0].setBackground(Color.red);
       ARR[2][1].setBackground(Color.orange);
       ARR[2][2].setBackground(Color.red);
       
      //CARA ABAJO
       JLabel Abajo = new JLabel("ABAJO");
       Abajo.setBounds(265,405,100,50);
       Abajo.setFont(new java.awt.Font("Arial",0,15));
       add(Abajo);
         for (int i = 0, k = 0; i < 3; i++, k += 45){
         for (int j = 0, n = 0; j < 3; j++, n += 45){
           ABA[i][j] = new JButton("");
           ABA[i][j].setBounds(225 + n, 440 + k, 40, 40);
           add(ABA[i][j]);
         }
       }
       ABA[0][0].setBackground(Color.orange);
       ABA[0][1].setBackground(Color.red);
       ABA[0][2].setBackground(Color.orange);
       ABA[1][0].setBackground(Color.red);
       ABA[1][1].setBackground(Color.orange);
       ABA[1][2].setBackground(Color.red);
       ABA[2][0].setBackground(Color.orange);
       ABA[2][1].setBackground(Color.red);
       ABA[2][2].setBackground(Color.orange);
       
      //BOTONES
       ImageIcon arriba = new ImageIcon(getClass().getResource("Descargas/Arriba.png"));
       ArribaUno = new JButton("");
       ArribaUno.addActionListener(this);
       ArribaUno.setBounds(225,590,40,40);
       ArribaUno.setIcon(arriba);
       add(ArribaUno);
       
       ArribaDos = new JButton("");
       ArribaDos.addActionListener(this);
       ArribaDos.setBounds(270,590,40,40);
       ArribaDos.setIcon(arriba);
       add(ArribaDos);
       
       ArribaTres = new JButton("");
       ArribaTres.addActionListener(this);
       ArribaTres.setBounds(315,590,40,40);
       ArribaTres.setIcon(arriba);
       add(ArribaTres);
       
       ImageIcon abajo = new ImageIcon(getClass().getResource("Descargas/Abajo.png"));
       AbajoUno = new JButton("");
       AbajoUno.addActionListener(this);
       AbajoUno.setBounds(225,80,40,40);
       AbajoUno.setIcon(abajo);
       add(AbajoUno);
       
       AbajoDos = new JButton("");
       AbajoDos.addActionListener(this);
       AbajoDos.setBounds(270,80,40,40);
       AbajoDos.setIcon(abajo);
       add(AbajoDos);
       
       AbajoTres = new JButton("");
       AbajoTres.addActionListener(this);
       AbajoTres.setBounds(315,80,40,40);
       AbajoTres.setIcon(abajo);
       add(AbajoTres);
       
       ImageIcon izq = new ImageIcon(getClass().getResource("Descargas/Izquierda.png"));
       IzquierdaUno = new JButton("");
       IzquierdaUno.addActionListener(this);
       IzquierdaUno.setBounds(675,290,40,40);
       IzquierdaUno.setIcon(izq);
       add(IzquierdaUno);
       
       IzquierdaDos = new JButton("");
       IzquierdaDos.addActionListener(this);
       IzquierdaDos.setBounds(675,335,40,40);
       IzquierdaDos.setIcon(izq);
       add(IzquierdaDos);
       
       IzquierdaTres = new JButton("");
       IzquierdaTres.addActionListener(this);
       IzquierdaTres.setBounds(675,380,40,40);
       IzquierdaTres.setIcon(izq);
       add(IzquierdaTres);
       
       ImageIcon der = new ImageIcon(getClass().getResource("Descargas/Derecha.png"));
       DerechaUno = new JButton("");
       DerechaUno.addActionListener(this);
       DerechaUno.setBounds(15,290,40,40);
       DerechaUno.setIcon(der);
       add(DerechaUno);
       
       DerechaDos = new JButton("");
       DerechaDos.addActionListener(this);
       DerechaDos.setBounds(15,335,40,40);
       DerechaDos.setIcon(der);
       add(DerechaDos);
       
       DerechaTres = new JButton("");
       DerechaTres.addActionListener(this);
       DerechaTres.setBounds(15,380,40,40);
       DerechaTres.setIcon(der);
       add(DerechaTres);
       
       setVisible(true);
    }

   
   public void ArrUno(){
     //PRIMERA LINEA VA ARRIBA
     aux1=ARR[2][0] ;
     aux2=ARR[1][0] ;
     aux3=ARR[0][0] ;
     ARR[0][0]=FRO[0][0] ;
     ARR[0][0].setBounds(225, 140, 40, 40);
     ARR[1][0]=FRO[1][0] ;
     ARR[1][0].setBounds(225,185, 40, 40);
     ARR[2][0]=FRO[2][0] ;
     ARR[2][0].setBounds(225,230, 40, 40);
     FRO[0][0]=ABA[0][0] ;
     FRO[0][0].setBounds(225, 290, 40, 40);
     FRO[1][0]=ABA[1][0] ;
     FRO[1][0].setBounds(225, 335, 40, 40);
     FRO[2][0]=ABA[2][0] ;
     FRO[2][0].setBounds(225, 380, 40, 40);
     ABA[0][0]=TRA[2][2] ;
     ABA[0][0].setBounds(225, 440, 40, 40);
     ABA[1][0]=TRA[1][2] ;
     ABA[1][0].setBounds(225, 485, 40, 40);
     ABA[2][0]=TRA[0][2] ;
     ABA[2][0].setBounds(225, 530, 40, 40);
     TRA[0][2]=aux1;
     TRA[0][2].setBounds(615, 290, 40, 40);
     TRA[1][2]=aux2;
     TRA[1][2].setBounds(615, 335, 40, 40);
     TRA[2][2]=aux3;
     TRA[2][2].setBounds(615, 380, 40, 40); 
     
     //CARA IZQUIERDA GIRA A LA IZQ
     aux1=IZQ[0][0];
     aux2=IZQ[0][1];
     IZQ[0][0]=IZQ[0][2];
     IZQ[0][0].setBounds(75, 290, 40, 40);
     IZQ[0][2]=IZQ[2][2];
     IZQ[0][2].setBounds(165, 290, 40, 40);
     IZQ[2][2]=IZQ[2][0];
     IZQ[2][2].setBounds(165, 380, 40, 40);
     IZQ[2][0]=aux1;
     IZQ[2][0].setBounds(75, 380, 40, 40);
     IZQ[0][1]=IZQ[1][2];
     IZQ[0][1].setBounds(120, 290, 40, 40);
     IZQ[1][2]=IZQ[2][1];
     IZQ[1][2].setBounds(165, 335, 40, 40);
     IZQ[2][1]=IZQ[1][0];
     IZQ[2][1].setBounds(120, 380, 40, 40);
     IZQ[1][0]=aux2;
     IZQ[1][0].setBounds(75, 335, 40, 40); 
     
     Comparador(IZQ, FRO, DER, TRA, ARR, ABA);
   }
   
   public void ArrDos(){
     //SEGUNDA LINEA VA ARRIBA
     aux1=ARR[2][1] ;
     aux2=ARR[1][1] ;
     aux3=ARR[0][1] ;
     ARR[0][1]=FRO[0][1] ;
     ARR[0][1].setBounds(270, 140, 40, 40);
     ARR[1][1]=FRO[1][1] ;
     ARR[1][1].setBounds(270,185, 40, 40);
     ARR[2][1]=FRO[2][1] ;
     ARR[2][1].setBounds(270,230, 40, 40);
     FRO[0][1]=ABA[0][1] ;
     FRO[0][1].setBounds(270, 290, 40, 40);
     FRO[1][1]=ABA[1][1] ;
     FRO[1][1].setBounds(270, 335, 40, 40);
     FRO[2][1]=ABA[2][1] ;
     FRO[2][1].setBounds(270, 380, 40, 40);
     ABA[0][1]=TRA[2][1] ;
     ABA[0][1].setBounds(270, 440, 40, 40);
     ABA[1][1]=TRA[1][1] ;
     ABA[1][1].setBounds(270, 485, 40, 40);
     ABA[2][1]=TRA[0][1] ;
     ABA[2][1].setBounds(270, 530, 40, 40);
     TRA[0][1]=aux1;
     TRA[0][1].setBounds(570, 290, 40, 40);
     TRA[1][1]=aux2;
     TRA[1][1].setBounds(570, 335, 40, 40);
     TRA[2][1]=aux3;
     TRA[2][1].setBounds(570, 380, 40, 40); 
     
     Comparador(IZQ, FRO, DER, TRA, ARR, ABA);
   }
    
    public void ArrTres(){
     //TERCERA LINEA VA ARRIBA
     aux1=ARR[2][2] ;
     aux2=ARR[1][2] ;
     aux3=ARR[0][2] ;
     ARR[0][2]=FRO[0][2] ;
     ARR[0][2].setBounds(315, 140, 40, 40);
     ARR[1][2]=FRO[1][2] ;
     ARR[1][2].setBounds(315,185, 40, 40);
     ARR[2][2]=FRO[2][2] ;
     ARR[2][2].setBounds(315,230, 40, 40);
     FRO[0][2]=ABA[0][2] ;
     FRO[0][2].setBounds(315, 290, 40, 40);
     FRO[1][2]=ABA[1][2] ;
     FRO[1][2].setBounds(315, 335, 40, 40);
     FRO[2][2]=ABA[2][2] ;
     FRO[2][2].setBounds(315, 380, 40, 40);
     ABA[0][2]=TRA[2][0] ;
     ABA[0][2].setBounds(315, 440, 40, 40);
     ABA[1][2]=TRA[1][0] ;
     ABA[1][2].setBounds(315, 485, 40, 40);
     ABA[2][2]=TRA[0][0] ;
     ABA[2][2].setBounds(315, 530, 40, 40);
     TRA[0][0]=aux1;
     TRA[0][0].setBounds(525, 290, 40, 40);
     TRA[1][0]=aux2;
     TRA[1][0].setBounds(525, 335, 40, 40);
     TRA[2][0]=aux3;
     TRA[2][0].setBounds(525, 380, 40, 40); 
     
     //CARA DERECHA GIRA A LA DER
     aux1=DER[0][0];
     aux2=DER[0][1];
     DER[0][0]=DER[2][0];
     DER[0][0].setBounds(375, 290, 40, 40);
     DER[2][0]=DER[2][2];
     DER[2][0].setBounds(375, 380, 40, 40);
     DER[2][2]=DER[0][2];
     DER[2][2].setBounds(465, 380, 40, 40);
     DER[0][2]=aux1;
     DER[0][2].setBounds(465, 290, 40, 40);
     DER[0][1]=DER[1][0];
     DER[0][1].setBounds(420, 290, 40, 40);
     DER[1][0]=DER[2][1];
     DER[1][0].setBounds(375, 335, 40, 40);
     DER[2][1]=DER[1][2];
     DER[2][1].setBounds(420, 380, 40, 40);
     DER[1][2]=aux2;
     DER[1][2].setBounds(465, 335, 40, 40);
     
     Comparador(IZQ, FRO, DER, TRA, ARR, ABA);
   }
   
   public void AbaUno(){
     //PRIMERA LINEA VA ABAJO
     aux1=ARR[0][0] ;
     aux2=ARR[1][0] ;
     aux3=ARR[2][0] ;
     ARR[0][0]=TRA[2][2] ;
     ARR[0][0].setBounds(225, 140, 40, 40);
     ARR[1][0]=TRA[1][2] ;
     ARR[1][0].setBounds(225, 185, 40, 40);
     ARR[2][0]=TRA[0][2] ;
     ARR[2][0].setBounds(225, 230, 40, 40);
     TRA[0][2]=ABA[2][0] ;
     TRA[0][2].setBounds(615, 290, 40, 40);
     TRA[1][2]=ABA[1][0] ;
     TRA[1][2].setBounds(615, 335, 40, 40);
     TRA[2][2]=ABA[0][0] ;
     TRA[2][2].setBounds(615, 380, 40, 40);
     ABA[0][0]=FRO[0][0] ;
     ABA[0][0].setBounds(225, 440, 40, 40);
     ABA[1][0]=FRO[1][0] ;
     ABA[1][0].setBounds(225, 485, 40, 40);
     ABA[2][0]=FRO[2][0] ;
     ABA[2][0].setBounds(225, 530, 40, 40);
     FRO[0][0]=aux1;
     FRO[0][0].setBounds(225, 290, 40, 40);
     FRO[1][0]=aux2;
     FRO[1][0].setBounds(225, 335, 40, 40);
     FRO[2][0]=aux3;
     FRO[2][0].setBounds(225, 380, 40, 40);
     
     //CARA IZQUIERDA GIRA A LA DER
     aux1=IZQ[0][0];
     aux2=IZQ[0][1];
     IZQ[0][0]=IZQ[2][0];
     IZQ[0][0].setBounds(75, 290, 40, 40);
     IZQ[2][0]=IZQ[2][2];
     IZQ[2][0].setBounds(75, 380, 40, 40);
     IZQ[2][2]=IZQ[0][2];
     IZQ[2][2].setBounds(165, 380, 40, 40);
     IZQ[0][2]=aux1;
     IZQ[0][2].setBounds(165, 290, 40, 40);
     IZQ[0][1]=IZQ[1][0];
     IZQ[0][1].setBounds(120, 290, 40, 40);
     IZQ[1][0]=IZQ[2][1];
     IZQ[1][0].setBounds(75, 335, 40, 40);
     IZQ[2][1]=IZQ[1][2];
     IZQ[2][1].setBounds(120, 380, 40, 40);
     IZQ[1][2]=aux2;
     IZQ[1][2].setBounds(165, 335, 40, 40);
     
     Comparador(IZQ, FRO, DER, TRA, ARR, ABA);
   }
   
   public void AbaDos(){
     //SEGUNDA LINEA VA ABAJO
     aux1=ARR[0][1] ;
     aux2=ARR[1][1] ;
     aux3=ARR[2][1] ;
     ARR[0][1]=TRA[2][1] ;
     ARR[0][1].setBounds(270, 140, 40, 40);
     ARR[1][1]=TRA[1][1] ;
     ARR[1][1].setBounds(270, 185, 40, 40);
     ARR[2][1]=TRA[0][1] ;
     ARR[2][1].setBounds(270, 230, 40, 40);
     TRA[0][1]=ABA[2][1] ;
     TRA[0][1].setBounds(570, 290, 40, 40);
     TRA[1][1]=ABA[1][1] ;
     TRA[1][1].setBounds(570, 335, 40, 40);
     TRA[2][1]=ABA[0][1] ;
     TRA[2][1].setBounds(570, 380, 40, 40);
     ABA[0][1]=FRO[0][1] ;
     ABA[0][1].setBounds(270, 440, 40, 40);
     ABA[1][1]=FRO[1][1] ;
     ABA[1][1].setBounds(270, 485, 40, 40);
     ABA[2][1]=FRO[2][1] ;
     ABA[2][1].setBounds(270, 530, 40, 40);
     FRO[0][1]=aux1;
     FRO[0][1].setBounds(270, 290, 40, 40);
     FRO[1][1]=aux2;
     FRO[1][1].setBounds(270, 335, 40, 40);
     FRO[2][1]=aux3;
     FRO[2][1].setBounds(270, 380, 40, 40);
     
     Comparador(IZQ, FRO, DER, TRA, ARR, ABA);
   }
   
   public void AbaTres(){
     //TERCERA LINEA VA ABAJO
     aux1=ARR[0][2] ;
     aux2=ARR[1][2] ;
     aux3=ARR[2][2] ;
     ARR[0][2]=TRA[2][0] ;
     ARR[0][2].setBounds(315, 140, 40, 40);
     ARR[1][2]=TRA[1][0] ;
     ARR[1][2].setBounds(315, 185, 40, 40);
     ARR[2][2]=TRA[0][0] ;
     ARR[2][2].setBounds(315, 230, 40, 40);
     TRA[0][0]=ABA[2][2] ;
     TRA[0][0].setBounds(525, 290, 40, 40);
     TRA[1][0]=ABA[1][2] ;
     TRA[1][0].setBounds(525, 335, 40, 40);
     TRA[2][0]=ABA[0][2] ;
     TRA[2][0].setBounds(525, 380, 40, 40);
     ABA[0][2]=FRO[0][2] ;
     ABA[0][2].setBounds(315, 440, 40, 40);
     ABA[1][2]=FRO[1][2] ;
     ABA[1][2].setBounds(315, 485, 40, 40);
     ABA[2][2]=FRO[2][2] ;
     ABA[2][2].setBounds(315, 530, 40, 40);
     FRO[0][2]=aux1;
     FRO[0][2].setBounds(315, 290, 40, 40);
     FRO[1][2]=aux2;
     FRO[1][2].setBounds(315, 335, 40, 40);
     FRO[2][2]=aux3;
     FRO[2][2].setBounds(315, 380, 40, 40);
     
     //CARA DERECHA GIRA A LA IZQ
     aux1=DER[0][0];
     aux2=DER[0][1];
     DER[0][0]=DER[0][2];
     DER[0][0].setBounds(375, 290, 40, 40);
     DER[0][2]=DER[2][2];
     DER[0][2].setBounds(465, 290, 40, 40);
     DER[2][2]=DER[2][0];
     DER[2][2].setBounds(465, 380, 40, 40);
     DER[2][0]=aux1;
     DER[2][0].setBounds(375, 380, 40, 40);
     DER[0][1]=DER[1][2];
     DER[0][1].setBounds(420, 290, 40, 40);
     DER[1][2]=DER[2][1];
     DER[1][2].setBounds(465, 335, 40, 40);
     DER[2][1]=DER[1][0];
     DER[2][1].setBounds(420, 380, 40, 40);
     DER[1][0]=aux2;
     DER[1][0].setBounds(375, 335, 40, 40); 
     
     Comparador(IZQ, FRO, DER, TRA, ARR, ABA);
   }
    
   public void IzqUno(){
     //PRIMERA LINEA VA A LA IZQUIERDA
     aux1=IZQ[0][0] ;
     aux2=IZQ[0][1] ;
     aux3=IZQ[0][2] ;
     IZQ[0][0]=FRO[0][0] ;
     IZQ[0][0].setBounds(75, 290, 40, 40);
     IZQ[0][1]=FRO[0][1] ;
     IZQ[0][1].setBounds(120,290, 40, 40);
     IZQ[0][2]=FRO[0][2] ;
     IZQ[0][2].setBounds(165,290, 40, 40);
     FRO[0][0]=DER[0][0] ;
     FRO[0][0].setBounds(225, 290, 40, 40);
     FRO[0][1]=DER[0][1] ;
     FRO[0][1].setBounds(270, 290, 40, 40);
     FRO[0][2]=DER[0][2] ;
     FRO[0][2].setBounds(315, 290, 40, 40);
     DER[0][0]=TRA[0][0] ;
     DER[0][0].setBounds(375, 290, 40, 40);
     DER[0][1]=TRA[0][1] ;
     DER[0][1].setBounds(420, 290, 40, 40);
     DER[0][2]=TRA[0][2] ;
     DER[0][2].setBounds(465, 290, 40, 40);
     TRA[0][0]=aux1;
     TRA[0][0].setBounds(525, 290, 40, 40);
     TRA[0][1]=aux2;
     TRA[0][1].setBounds(570, 290, 40, 40);
     TRA[0][2]=aux3;
     TRA[0][2].setBounds(615, 290, 40, 40);
     
     //CARA ARRIBA GIRA A LA DER
     aux1=ARR[0][0];
     aux2=ARR[0][1];
     ARR[0][0]=ARR[2][0];
     ARR[0][0].setBounds(225, 140, 40, 40);
     ARR[2][0]=ARR[2][2];
     ARR[2][0].setBounds(225, 230, 40, 40);
     ARR[2][2]=ARR[0][2];
     ARR[2][2].setBounds(315, 230, 40, 40);
     ARR[0][2]=aux1;
     ARR[0][2].setBounds(315, 140, 40, 40);
     ARR[0][1]=ARR[1][0];
     ARR[0][1].setBounds(270, 140, 40, 40);
     ARR[1][0]=ARR[2][1];
     ARR[1][0].setBounds(225, 185, 40, 40);
     ARR[2][1]=ARR[1][2];
     ARR[2][1].setBounds(270, 230, 40, 40);
     ARR[1][2]=aux2;
     ARR[1][2].setBounds(315, 185, 40, 40);
     
     Comparador(IZQ, FRO, DER, TRA, ARR, ABA);
   }
   
   public void IzqDos(){
     //SEGUNDA LINEA VA A LA IZQUIERDA
     aux1=IZQ[1][0] ;
     aux2=IZQ[1][1] ;
     aux3=IZQ[1][2] ;
     IZQ[1][0]=FRO[1][0] ;
     IZQ[1][0].setBounds(75, 335, 40, 40);
     IZQ[1][1]=FRO[1][1] ;
     IZQ[1][1].setBounds(120,335, 40, 40);
     IZQ[1][2]=FRO[1][2] ;
     IZQ[1][2].setBounds(165,335, 40, 40);
     FRO[1][0]=DER[1][0] ;
     FRO[1][0].setBounds(225, 335, 40, 40);
     FRO[1][1]=DER[1][1] ;
     FRO[1][1].setBounds(270, 335, 40, 40);
     FRO[1][2]=DER[1][2] ;
     FRO[1][2].setBounds(315, 335, 40, 40);
     DER[1][0]=TRA[1][0] ;
     DER[1][0].setBounds(375, 335, 40, 40);
     DER[1][1]=TRA[1][1] ;
     DER[1][1].setBounds(420, 335, 40, 40);
     DER[1][2]=TRA[1][2] ;
     DER[1][2].setBounds(465, 335, 40, 40);
     TRA[1][0]=aux1;
     TRA[1][0].setBounds(525, 335, 40, 40);
     TRA[1][1]=aux2;
     TRA[1][1].setBounds(570, 335, 40, 40);
     TRA[1][2]=aux3;
     TRA[1][2].setBounds(615, 335, 40, 40);
     
     Comparador(IZQ, FRO, DER, TRA, ARR, ABA);
   }
   
   public void IzqTres(){
     //TERCERA LINEA VA A LA IZQUIERDA
     aux1=IZQ[2][0] ;
     aux2=IZQ[2][1] ;
     aux3=IZQ[2][2] ;
     IZQ[2][0]=FRO[2][0] ;
     IZQ[2][0].setBounds(75, 380, 40, 40);
     IZQ[2][1]=FRO[2][1] ;
     IZQ[2][1].setBounds(120,380, 40, 40);
     IZQ[2][2]=FRO[2][2] ;
     IZQ[2][2].setBounds(165,380, 40, 40);
     FRO[2][0]=DER[2][0] ;
     FRO[2][0].setBounds(225, 380, 40, 40);
     FRO[2][1]=DER[2][1] ;
     FRO[2][1].setBounds(270, 380, 40, 40);
     FRO[2][2]=DER[2][2] ;
     FRO[2][2].setBounds(315, 380, 40, 40);
     DER[2][0]=TRA[2][0] ;
     DER[2][0].setBounds(375, 380, 40, 40);
     DER[2][1]=TRA[2][1] ;
     DER[2][1].setBounds(420, 380, 40, 40);
     DER[2][2]=TRA[2][2] ;
     DER[2][2].setBounds(465, 380, 40, 40);
     TRA[2][0]=aux1;
     TRA[2][0].setBounds(525, 380, 40, 40);
     TRA[2][1]=aux2;
     TRA[2][1].setBounds(570, 380, 40, 40);
     TRA[2][2]=aux3;
     TRA[2][2].setBounds(615, 380, 40, 40);
     
     //CARA ABAJO GIRA A LA IZQ
     aux1=ABA[0][0];
     aux2=ABA[0][1];
     ABA[0][0]=ABA[0][2];
     ABA[0][0].setBounds(225, 440, 40, 40);
     ABA[0][2]=ABA[2][2];
     ABA[0][2].setBounds(315, 440, 40, 40);
     ABA[2][2]=ABA[2][0];
     ABA[2][2].setBounds(315, 530, 40, 40);
     ABA[2][0]=aux1;
     ABA[2][0].setBounds(225, 530, 40, 40);
     ABA[0][1]=ABA[1][2];
     ABA[0][1].setBounds(270, 440, 40, 40);
     ABA[1][2]=ABA[2][1];
     ABA[1][2].setBounds(315, 485, 40, 40);
     ABA[2][1]=ABA[1][0];
     ABA[2][1].setBounds(270, 530, 40, 40);
     ABA[1][0]=aux2;
     ABA[1][0].setBounds(225, 485, 40, 40); 
     
     Comparador(IZQ, FRO, DER, TRA, ARR, ABA);
    } 
   
   public void DerUno(){
     //PRIMERA LINEA VA A LA DERECHA
     aux1=IZQ[0][0] ;
     aux2=IZQ[0][1] ;
     aux3=IZQ[0][2] ;
     IZQ[0][0]=TRA[0][0] ;
     IZQ[0][0].setBounds(75, 290, 40, 40);
     IZQ[0][1]=TRA[0][1] ;
     IZQ[0][1].setBounds(120,290, 40, 40);
     IZQ[0][2]=TRA[0][2] ;
     IZQ[0][2].setBounds(165,290, 40, 40);
     TRA[0][0]=DER[0][0] ;
     TRA[0][0].setBounds(525, 290, 40, 40);
     TRA[0][1]=DER[0][1] ;
     TRA[0][1].setBounds(570, 290, 40, 40);
     TRA[0][2]=DER[0][2] ;
     TRA[0][2].setBounds(615, 290, 40, 40);
     DER[0][0]=FRO[0][0] ;
     DER[0][0].setBounds(375, 290, 40, 40);
     DER[0][1]=FRO[0][1] ;
     DER[0][1].setBounds(420, 290, 40, 40);
     DER[0][2]=FRO[0][2] ;
     DER[0][2].setBounds(465, 290, 40, 40);
     FRO[0][0]=aux1;
     FRO[0][0].setBounds(225, 290, 40, 40);
     FRO[0][1]=aux2;
     FRO[0][1].setBounds(270, 290, 40, 40);
     FRO[0][2]=aux3;
     FRO[0][2].setBounds(315, 290, 40, 40);
       
     //CARA ARRIBA GIRA A LA IZQ
     aux1=ARR[0][0];
     aux2=ARR[0][1];
     ARR[0][0]=ARR[0][2];
     ARR[0][0].setBounds(225, 140, 40, 40);
     ARR[0][2]=ARR[2][2];
     ARR[0][2].setBounds(315, 140, 40, 40);
     ARR[2][2]=ARR[2][0];
     ARR[2][2].setBounds(315, 230, 40, 40);
     ARR[2][0]=aux1;
     ARR[2][0].setBounds(225, 230, 40, 40);
     ARR[0][1]=ARR[1][2];
     ARR[0][1].setBounds(270, 140, 40, 40);
     ARR[1][2]=ARR[2][1];
     ARR[1][2].setBounds(315, 185, 40, 40);
     ARR[2][1]=ARR[1][0];
     ARR[2][1].setBounds(270, 230, 40, 40);
     ARR[1][0]=aux2;
     ARR[1][0].setBounds(225, 185, 40, 40);
     
     Comparador(IZQ, FRO, DER, TRA, ARR, ABA);
   }
   
   public void DerDos(){
     //SEGUNDA LINEA VA A LA DERECHA
     aux1=IZQ[1][0] ;
     aux2=IZQ[1][1] ;
     aux3=IZQ[1][2] ;
     IZQ[1][0]=TRA[1][0] ;
     IZQ[1][0].setBounds(75, 335, 40, 40);
     IZQ[1][1]=TRA[1][1] ;
     IZQ[1][1].setBounds(120,335, 40, 40);
     IZQ[1][2]=TRA[1][2] ;
     IZQ[1][2].setBounds(165,335, 40, 40);
     TRA[1][0]=DER[1][0] ;
     TRA[1][0].setBounds(525, 335, 40, 40);
     TRA[1][1]=DER[1][1] ;
     TRA[1][1].setBounds(570, 335, 40, 40);
     TRA[1][2]=DER[1][2] ;
     TRA[1][2].setBounds(615, 335, 40, 40);
     DER[1][0]=FRO[1][0] ;
     DER[1][0].setBounds(375, 335, 40, 40);
     DER[1][1]=FRO[1][1] ;
     DER[1][1].setBounds(420, 335, 40, 40);
     DER[1][2]=FRO[1][2] ;
     DER[1][2].setBounds(465, 335, 40, 40);
     FRO[1][0]=aux1;
     FRO[1][0].setBounds(225, 335, 40, 40);
     FRO[1][1]=aux2;
     FRO[1][1].setBounds(270, 335, 40, 40);
     FRO[1][2]=aux3;
     FRO[1][2].setBounds(315, 335, 40, 40);
     
     Comparador(IZQ, FRO, DER, TRA, ARR, ABA);
   }
   
   public void DerTres(){
     //TERCERA LINEA VA A LA DERECHA
     aux1=IZQ[2][0] ;
     aux2=IZQ[2][1] ;
     aux3=IZQ[2][2] ;
     IZQ[2][0]=TRA[2][0] ;
     IZQ[2][0].setBounds(75, 380, 40, 40);
     IZQ[2][1]=TRA[2][1] ;
     IZQ[2][1].setBounds(120,380, 40, 40);
     IZQ[2][2]=TRA[2][2] ;
     IZQ[2][2].setBounds(165,380, 40, 40);
     TRA[2][0]=DER[2][0] ;
     TRA[2][0].setBounds(525, 380, 40, 40);
     TRA[2][1]=DER[2][1] ;
     TRA[2][1].setBounds(570, 380, 40, 40);
     TRA[2][2]=DER[2][2] ;
     TRA[2][2].setBounds(615, 380, 40, 40);
     DER[2][0]=FRO[2][0] ;
     DER[2][0].setBounds(375, 380, 40, 40);
     DER[2][1]=FRO[2][1] ;
     DER[2][1].setBounds(420, 380, 40, 40);
     DER[2][2]=FRO[2][2] ;
     DER[2][2].setBounds(465, 380, 40, 40);
     FRO[2][0]=aux1;
     FRO[2][0].setBounds(225, 380, 40, 40);
     FRO[2][1]=aux2;
     FRO[2][1].setBounds(270, 380, 40, 40);
     FRO[2][2]=aux3;
     FRO[2][2].setBounds(315, 380, 40, 40);
       
     //CARA ABAJO GIRA A LA DER
     aux1=ABA[0][0];
     aux2=ABA[0][1];
     ABA[0][0]=ABA[2][0];
     ABA[0][0].setBounds(225, 440, 40, 40);
     ABA[2][0]=ABA[2][2];
     ABA[2][0].setBounds(225, 530, 40, 40);
     ABA[2][2]=ABA[0][2];
     ABA[2][2].setBounds(315, 530, 40, 40);
     ABA[0][2]=aux1;
     ABA[0][2].setBounds(315, 440, 40, 40);
     ABA[0][1]=ABA[1][0];
     ABA[0][1].setBounds(270, 440, 40, 40);
     ABA[1][0]=ABA[2][1];
     ABA[1][0].setBounds(225, 485, 40, 40);
     ABA[2][1]=ABA[1][2];
     ABA[2][1].setBounds(270, 530, 40, 40);
     ABA[1][2]=aux2;
     ABA[1][2].setBounds(315, 485, 40, 40);
     
     Comparador(IZQ, FRO, DER, TRA, ARR, ABA);
   }
   
   
   
   public void actionPerformed(ActionEvent e)
   {
     if(e.getSource()==ArribaUno){
        ArrUno();
     }
     if(e.getSource()==ArribaDos){
       ArrDos();
     }
     if(e.getSource()==ArribaTres){
       ArrTres();
     }
     if(e.getSource()==AbajoUno){
       AbaUno();
     }
     if(e.getSource()==AbajoDos){
       AbaDos();
     }
     if(e.getSource()==AbajoTres){
       AbaTres();
     }
     if(e.getSource()== IzquierdaUno){
       IzqUno();
     }
     if(e.getSource()==IzquierdaDos){
       IzqDos();
     }
     if(e.getSource()==IzquierdaTres){
       IzqTres();
     }
     if(e.getSource()==DerechaUno){
       DerUno(); 
     }
     if(e.getSource()==DerechaDos){
       DerDos();
     }
     if(e.getSource()==DerechaTres){
       DerTres();
     }
   }
   
   public void Comparador(JButton[][] IZQ, JButton[][] FRO, JButton[][] DER, JButton[][] TRA, JButton[][] ARR, JButton[][] ABA){
    boolean cumple1 = false;
    boolean cumple2 = false;
    boolean cumple3 = false;
    boolean cumple4 = false;
    boolean cumple5 = false;
    boolean cumple6 = false;
    boolean cumple7 = false;
    boolean cumple8 = false;
    boolean gano = false;
    //for(int i=0; i<3; i++){
    //  for (int j=0; j<3; j++){
        if(
        (IZQ[0][0].getBackground() == IZQ[0][1].getBackground())&&
        (FRO[0][0].getBackground() == FRO[0][1].getBackground())&&
        (DER[0][0].getBackground() == DER[0][1].getBackground())&&
        (TRA[0][0].getBackground() == TRA[0][1].getBackground())&&
        (ARR[0][0].getBackground() == ARR[0][1].getBackground())&&
        (ABA[0][0].getBackground() == ABA[0][1].getBackground())
        ){ 
          cumple1 =  true;
        }
        if(
        (IZQ[0][0].getBackground() == IZQ[0][2].getBackground())&&
        (FRO[0][0].getBackground() == FRO[0][2].getBackground())&&
        (DER[0][0].getBackground() == DER[0][2].getBackground())&&
        (TRA[0][0].getBackground() == TRA[0][2].getBackground())&&
        (ARR[0][0].getBackground() == ARR[0][2].getBackground())&&
        (ABA[0][0].getBackground() == ABA[0][2].getBackground())
        ){ 
          cumple2 =  true;
        }
        if(
        (IZQ[0][0].getBackground() == IZQ[1][0].getBackground())&&
        (FRO[0][0].getBackground() == FRO[1][0].getBackground())&&
        (DER[0][0].getBackground() == DER[1][0].getBackground())&&
        (TRA[0][0].getBackground() == TRA[1][0].getBackground())&&
        (ARR[0][0].getBackground() == ARR[1][0].getBackground())&&
        (ABA[0][0].getBackground() == ABA[1][0].getBackground())
        ){ 
          cumple3 =  true;
        }
        if(
        (IZQ[0][0].getBackground() == IZQ[1][1].getBackground())&&
        (FRO[0][0].getBackground() == FRO[1][1].getBackground())&&
        (DER[0][0].getBackground() == DER[1][1].getBackground())&&
        (TRA[0][0].getBackground() == TRA[1][1].getBackground())&&
        (ARR[0][0].getBackground() == ARR[1][1].getBackground())&&
        (ABA[0][0].getBackground() == ABA[1][1].getBackground())
        ){ 
          cumple4 =  true;
        }
        if(
        (IZQ[0][0].getBackground() == IZQ[1][2].getBackground())&&
        (FRO[0][0].getBackground() == FRO[1][2].getBackground())&&
        (DER[0][0].getBackground() == DER[1][2].getBackground())&&
        (TRA[0][0].getBackground() == TRA[1][2].getBackground())&&
        (ARR[0][0].getBackground() == ARR[1][2].getBackground())&&
        (ABA[0][0].getBackground() == ABA[1][2].getBackground())
        ){ 
          cumple5 =  true;
        }
        if(
        (IZQ[0][0].getBackground() == IZQ[2][0].getBackground())&&
        (FRO[0][0].getBackground() == FRO[2][0].getBackground())&&
        (DER[0][0].getBackground() == DER[2][0].getBackground())&&
        (TRA[0][0].getBackground() == TRA[2][0].getBackground())&&
        (ARR[0][0].getBackground() == ARR[2][0].getBackground())&&
        (ABA[0][0].getBackground() == ABA[2][0].getBackground())
        ){ 
          cumple6 =  true;
        }
        if(
        (IZQ[0][0].getBackground() == IZQ[2][1].getBackground())&&
        (FRO[0][0].getBackground() == FRO[2][1].getBackground())&&
        (DER[0][0].getBackground() == DER[2][1].getBackground())&&
        (TRA[0][0].getBackground() == TRA[2][1].getBackground())&&
        (ARR[0][0].getBackground() == ARR[2][1].getBackground())&&
        (ABA[0][0].getBackground() == ABA[2][1].getBackground())
        ){ 
          cumple7 =  true;
        }
        if(
        (IZQ[0][0].getBackground() == IZQ[2][2].getBackground())&&
        (FRO[0][0].getBackground() == FRO[2][2].getBackground())&&
        (DER[0][0].getBackground() == DER[2][2].getBackground())&&
        (TRA[0][0].getBackground() == TRA[2][2].getBackground())&&
        (ARR[0][0].getBackground() == ARR[2][2].getBackground())&&
         (ABA[0][0].getBackground() == ABA[2][2].getBackground())
        
        ){ 
          cumple8 =  true;
        }
    // }
    //}
    if(cumple1==true && cumple2==true && cumple3==true && cumple4==true && cumple5==true && cumple6==true && cumple7==true && cumple8==true){
       gano = true;
    }
    if (gano==true){
       JFrame mensaje = new JFrame("JOptionPane showMessageDialog example");
       JOptionPane.showMessageDialog(mensaje, "¡¡HAS GANADO!!");
       dispose();
    }
    }
   
  
    public static void main(String[]args)
   {
     VentanaPrincipal v = new VentanaPrincipal();
     v.setVisible(true);
   } 
}