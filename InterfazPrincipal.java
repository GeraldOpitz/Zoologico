/*
 * Autor: Gerald Opitz
 * Fecha de creación: 18 de abril 2023
 */

//importación de dependencias
import javax.swing.*;
import java.awt.event.*;
import javax.swing.table.DefaultTableModel;
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.util.ArrayList;
import java.util.List;

public class InterfazPrincipal extends JFrame implements ActionListener {
  private JButton botonAgregarAnimal;
  private JButton botonBorrarAnimal;
  private static JTable tablaAnimales;
  public static List<Animal> listaAnimales = new ArrayList<>();

  public InterfazPrincipal() {

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
    botonAgregarAnimal.addActionListener(this);
    botonBorrarAnimal = new JButton("Borrar animal");
    botonBorrarAnimal.addActionListener(this);

    // Agregar los botones al panel principal
    panelPrincipal.add(botonAgregarAnimal);
    panelPrincipal.add(botonBorrarAnimal);

    // Tabla para los datos
    DefaultTableModel modeloTabla = new DefaultTableModel();
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

  } 

  // Actualizar datos de la tabla
  public static void actualizarTabla() {
    DefaultTableModel modeloTabla = (DefaultTableModel) tablaAnimales.getModel();
    modeloTabla.setRowCount(0);
    // Agregar datos de los animales a la tabla
    for (Animal animal : listaAnimales) {
      modeloTabla.addRow(new Object[] { animal.getEspecie(), animal.getNombre(), animal.getEdadAnios(),
          animal.getSexo(), animal.getSalud() });
    }
  }

  public void actionPerformed(ActionEvent e) {
    if (e.getSource() == botonAgregarAnimal) {
      // Acción para agregar un animal
      JDialog dialogoAgregar = new JDialog(this, "Agregar animal", true);
      dialogoAgregar.setSize(400, 300);
      dialogoAgregar.setLocationRelativeTo(null);

      // Datos de animales
      JLabel labelEspecie = new JLabel("Especie");
      String[] animales = { 
        "León", "Tigre", "Jirafa", "Elefante", "Rinoceronte", "Cocodrilo", "Hipopótamo", 
        "Oso polar", "Panda", "Leopardo", "Lobo", "Zorro", "Mapache", "Jaguar", "Puma", "Canguro", 
        "Camello", "Mono", "Orangután", "Gorila", "Chimpancé", "Cebra", "Antílope", "Búfalo", "Alce", "Ciervo", 
        "Avestruz", "Pavo real", "Flamenco", "Pingüino"
      };
      JComboBox<String> comboBoxEspecie = new JComboBox<>(animales);

      JLabel labelNombre = new JLabel("Nombre");
      JTextField textFieldNombre = new JTextField(10);

      JLabel labelEdad = new JLabel("Edad en años");
      JTextField textFieldEdad = new JTextField(3);

      JLabel labelSexo = new JLabel("Sexo");
      String[] sexo = { "Macho", "Hembra" };
      JComboBox<String> comboBoxSexo = new JComboBox<>(sexo);

      JLabel labelSalud = new JLabel("Estado de salud");
      JTextArea textAreaSalud = new JTextArea(3, 20);
      textAreaSalud.setLineWrap(true);
      textAreaSalud.setWrapStyleWord(true);
      JScrollPane scrollPane = new JScrollPane(textAreaSalud);

      // Paneles para los datos
      JPanel panelEspecie = new JPanel(new FlowLayout(FlowLayout.LEFT));
      panelEspecie.add(labelEspecie);
      panelEspecie.add(comboBoxEspecie);

      JPanel panelNombre = new JPanel(new FlowLayout(FlowLayout.LEFT));
      panelNombre.add(labelNombre);
      panelNombre.add(textFieldNombre);

      JPanel panelEdad = new JPanel(new FlowLayout(FlowLayout.LEFT));
      panelEdad.add(labelEdad);
      panelEdad.add(textFieldEdad);

      JPanel panelSexo = new JPanel(new FlowLayout(FlowLayout.LEFT));
      panelSexo.add(labelSexo);
      panelSexo.add(comboBoxSexo);

      JPanel panelSalud = new JPanel(new FlowLayout(FlowLayout.LEFT));
      panelSalud.add(labelSalud);
      panelSalud.add(scrollPane);

      JPanel panelContenedor = new JPanel();
      panelContenedor.setLayout(new BoxLayout(panelContenedor, BoxLayout.Y_AXIS));
      panelContenedor.add(panelEspecie);
      panelContenedor.add(panelNombre);
      panelContenedor.add(panelEdad);
      panelContenedor.add(panelSexo);
      panelContenedor.add(panelSalud);

      // Panel para boton agregar
      JPanel panelBoton = new JPanel(new FlowLayout(FlowLayout.RIGHT));
      JButton botonAgregar = new JButton("Agregar");
      panelBoton.add(botonAgregar);

      // Boton para agregar datos a la tabla y cerrar dialog
      botonAgregar.addActionListener(new ActionListener() {
        public void actionPerformed(ActionEvent e) {
          String especie = (String) comboBoxEspecie.getSelectedItem();
          String nombre = textFieldNombre.getText();
          int edadAnios;
          try {
              edadAnios = Integer.parseInt(textFieldEdad.getText());
              if (edadAnios < 0) {
                  JOptionPane.showMessageDialog(null, "La edad debe ser un número positivo", "Error", JOptionPane.ERROR_MESSAGE);
                  return;
              }
          } catch (NumberFormatException ex) {
              JOptionPane.showMessageDialog(null, "La edad debe ser un número entero", "Error", JOptionPane.ERROR_MESSAGE);
              return;
          }
          String sexo = (String) comboBoxSexo.getSelectedItem();
          String salud = textAreaSalud.getText();
          Animal animal = new Animal(especie, nombre, edadAnios, sexo, salud);

          // Agregar objeto animal a la lista de animales
          InterfazPrincipal.listaAnimales.add(animal);

          // Actualizar la tabla
          InterfazPrincipal.actualizarTabla();

          dialogoAgregar.dispose();
        }
      });

      // Contenedor principal
      JPanel panelPrincipal = new JPanel(new BorderLayout());
      panelPrincipal.add(panelContenedor, BorderLayout.CENTER);
      panelPrincipal.add(panelBoton, BorderLayout.SOUTH);

      dialogoAgregar.add(panelPrincipal);
      dialogoAgregar.setVisible(true);

    } else if (e.getSource() == botonBorrarAnimal) {
      // Acción para borrar un animal
      JOptionPane.showMessageDialog(this, "En construccion");
    }
  }

  public static void main(String[] args) {
    InterfazPrincipal interfaz = new InterfazPrincipal();
    interfaz.pack();
    interfaz.setDefaultCloseOperation(EXIT_ON_CLOSE);
    interfaz.setLocationRelativeTo(null);
    interfaz.setVisible(true);
  }
}
