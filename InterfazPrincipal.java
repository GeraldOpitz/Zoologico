import javax.swing.*;
import java.awt.event.*;

public class InterfazPrincipal extends JFrame implements ActionListener {
  private JButton botonAgregarAnimal;
  private JButton botonBorrarAnimal;

  public InterfazPrincipal() {
   //icono que se muestra en la parte superior del programa
   setIconImage(new ImageIcon(getClass().getResource("images/icono.png")).getImage());

   //titulo de la ventana
   setTitle("Sistema de inventario de zoologico");

   //paneles
   JPanel panelPrincipal = new JPanel();
   JPanel panelBienvenida = new JPanel();
   panelPrincipal.add(panelBienvenida);
   JLabel etiquetaBienvenida = new JLabel("Inventario de Animales");
   panelBienvenida.add(etiquetaBienvenida);
   panelPrincipal.add(panelBienvenida);

   // Creación de los botones
   botonAgregarAnimal = new JButton("Agregar animal");
   botonAgregarAnimal.addActionListener(this);
   botonBorrarAnimal = new JButton("Borrar animal");
   botonBorrarAnimal.addActionListener(this);

   // Agregar los botones al panel principal
   panelPrincipal.add(botonAgregarAnimal);
   panelPrincipal.add(botonBorrarAnimal);

   // Agregar el panel principal a la ventana
   getContentPane().add(panelPrincipal);

  }

  public void actionPerformed(ActionEvent e) {
    if (e.getSource() == botonAgregarAnimal) {
      // Acción para agregar un animal
         JOptionPane.showMessageDialog(this, "Funcion Agregar animal en construccion.");
     } else if (e.getSource() == botonBorrarAnimal) {
            // Acción para borrar un animal
            JOptionPane.showMessageDialog(this, "Funcion Borrar animal en construccion.");
       }
    }

  public static void main(String[] args) {
    InterfazPrincipal interfaz = new InterfazPrincipal();
    interfaz.setSize(800, 600);
    interfaz.setDefaultCloseOperation(EXIT_ON_CLOSE);
    interfaz.setLocationRelativeTo(null);
    interfaz.setVisible(true);
  }
}

