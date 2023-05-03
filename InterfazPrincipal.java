/*
 * Autor: Gerald Opitz
 * Fecha de creación: 18 de abril 2023
 */

//importación de dependencias
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.util.ArrayList;

public class InterfazPrincipal extends JFrame {
  private ControladorInterfaz controlador;
  
  JButton botonAgregarAnimal;
  JButton botonBorrarAnimal;
  private static JTable tablaAnimales;

  public InterfazPrincipal() {
    controlador = new ControladorInterfaz(this);

    // Titulo de la ventana
    setTitle("Sistema de inventario de zoologico");

    // Icono que se muestra en la parte superior del programa
    setIconImage(new ImageIcon(getClass().getResource("images/icono.png")).getImage());

    // Paneles
    JPanel panelPrincipal = new JPanel();
    JPanel panelBienvenida = new JPanel();
    JPanel panelTabla = new JPanel();
    panelPrincipal.add(panelBienvenida);
    JLabel etiquetaBienvenida = new JLabel("Inventario de Animales");
    panelBienvenida.add(etiquetaBienvenida);

    // Creación de los botones
    botonAgregarAnimal = new JButton("Agregar animal");

    botonBorrarAnimal = new JButton("Borrar animal");

    // Agregar los botones al panel principal
    panelPrincipal.add(botonAgregarAnimal);
    panelPrincipal.add(botonBorrarAnimal);

    // Tabla para los datos
    DefaultTableModel modeloTabla = new DefaultTableModel();
    modeloTabla.addColumn("Tipo de animal");
    modeloTabla.addColumn("Especie");
    modeloTabla.addColumn("Nombre");
    modeloTabla.addColumn("Edad en años");
    modeloTabla.addColumn("Sexo");
    modeloTabla.addColumn("Salud");
    tablaAnimales = new JTable(modeloTabla);
    tablaAnimales.setPreferredScrollableViewportSize(new Dimension(600, 400));
    tablaAnimales.getTableHeader().setReorderingAllowed(false);
    JScrollPane scrollTablaAnimales = new JScrollPane(tablaAnimales);
    panelTabla.add(scrollTablaAnimales);

    // Agregar el panel principal a la ventana
    getContentPane().add(panelPrincipal, BorderLayout.NORTH);
    getContentPane().add(panelTabla, BorderLayout.CENTER);

    botonAgregarAnimal.addActionListener(controlador); 
    botonBorrarAnimal.addActionListener(controlador);
  }

  // Actualizar datos de la tabla
  public void actualizarTabla(ArrayList<Animal> listaAnimales) {
    DefaultTableModel modeloTabla = (DefaultTableModel) tablaAnimales.getModel();
    modeloTabla.setRowCount(0);
    // Agregar datos de los animales a la tabla
    for (Animal animal : ControladorInterfaz.listaAnimales) {
      modeloTabla.addRow(
          new Object[] { animal.getTipoAnimal(), animal.getEspecie(), animal.getNombre(), animal.getEdadAnios(),
              animal.getSexo(), animal.getSalud() });
    }
  }
  public static void main(String args[]) {
    InterfazPrincipal ventanaPrincipal = new InterfazPrincipal();
    ventanaPrincipal.pack();
    ventanaPrincipal.setDefaultCloseOperation(EXIT_ON_CLOSE);
    ventanaPrincipal.setLocationRelativeTo(null);
    ventanaPrincipal.setVisible(true);
  }
}
