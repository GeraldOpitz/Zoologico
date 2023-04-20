import javax.swing.*;
import java.awt.event.*;
import java.awt.*;

public class Bienvenida extends JFrame implements ActionListener{
  private JButton botonAcceder;
  private JLabel label1;

  public Bienvenida(){
   JPanel panel = new JPanel(new BorderLayout());
   //titulo de la ventana
   setTitle("Bienvenida");
   //icono que se muestra en la parte superior del programa
   setIconImage(new ImageIcon(getClass().getResource("images/icono.png")).getImage());

   //imagen de bienvenida al programa
   ImageIcon imagen = new ImageIcon(new ImageIcon("images/bienvenido.png").getImage().getScaledInstance(700, 300, Image.SCALE_DEFAULT));
   label1 = new JLabel(imagen);
   label1.setHorizontalAlignment(SwingConstants.CENTER);
   panel.add(label1, BorderLayout.CENTER);
   
   //botón de acceso a la siguiente ventana
   botonAcceder = new JButton("Ingresar");
   botonAcceder.setFont(new Font("Arial", Font.PLAIN, 40));
   botonAcceder.addActionListener(this);
   panel.add(botonAcceder, BorderLayout.SOUTH);
   add(panel);
  }

  //metodo para pasar a la siguiente pantalla
  public void actionPerformed(ActionEvent e){
   if(e.getSource() == botonAcceder){
     
   }
  }
  //definicion de la clase main
  public static void main(String args[]){
    Bienvenida ventanabienvenida = new Bienvenida();
    ventanabienvenida.setSize(800, 600);
    ventanabienvenida.setDefaultCloseOperation(EXIT_ON_CLOSE);
    ventanabienvenida.setLocationRelativeTo(null);
    ventanabienvenida.setVisible(true);
  }
}