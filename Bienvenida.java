import javax.swing.*;
import java.awt.event.*;
import java.awt.*;

public class Bienvenida extends JFrame implements ActionListener{
  private JTextField textfield1;
  private JLabel label1, label2, label3, label4;
  private JButton boton1;

  public Bienvenida(){
   //icono que se muestra en la parte superior del programa
   setLayout(null);
   setTitle("Sistema de inventario de zoologico");
   setIconImage(new ImageIcon(getClass().getResource("images/icono.png")).getImage());

   //imagen de bienvenida al programa
   ImageIcon imagen = new ImageIcon(new ImageIcon("images/bienvenido.png").getImage().getScaledInstance(550, 300, Image.SCALE_DEFAULT));
   label1 = new JLabel(imagen);
   label1.setBounds(20,50,550,300);
   add(label1);
   
   //botón de acceso a la siguiente parte del programa
   boton1 = new JButton("Ingresar");
   boton1.setBounds(140,450,300,50);
   boton1.addActionListener(this);
   add(boton1);
  }

  //metodo para pasar a la siguiente pantalla
  public void actionPerformed(ActionEvent e){
   if(e.getSource() == boton1){
     
   }
  }
  //definicion de la clase main
  public static void main(String args[]){
    Bienvenida ventanabienvenida = new Bienvenida();
    ventanabienvenida.setBounds(0,0,600,600);
    ventanabienvenida.setVisible(true);
    ventanabienvenida.setLocationRelativeTo(null);
  }
}