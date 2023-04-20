import javax.swing.*;
import java.awt.event.*;
import javax.swing.table.DefaultTableModel;
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Component;

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
   String[] columnas = {"Especie", "Nombre", "Edad", "Sexo", "Estado de salud"};
   String[][] datos = {};
   JTable tablaAnimales = new JTable(new DefaultTableModel(datos, columnas));
   tablaAnimales.setPreferredScrollableViewportSize(new Dimension(600, 400));
   tablaAnimales.getTableHeader().setReorderingAllowed(false);
   JScrollPane scrollTabla = new JScrollPane(tablaAnimales);
   panelTabla.add(scrollTabla);

   // Agregar el panel principal a la ventana
   getContentPane().add(panelPrincipal);
   getContentPane().add(panelTabla, BorderLayout.SOUTH);
  }

  public void actionPerformed(ActionEvent e) {
    if (e.getSource() == botonAgregarAnimal) {
        // Acción para agregar un animal
	JDialog dialogoAgregar = new JDialog(this, "Agregar animal", true);
	dialogoAgregar.setSize(400, 300);
	dialogoAgregar.setLocationRelativeTo(null);

	JLabel labelEspecie = new JLabel("Especie");
	String[] opciones = {"Elefante", "Jirafa", "Tigre", "Oso polar", "Cebra", "Pinguino", "Leon", "Cocodrilo", "Hiena", "Rinoceronte"};
	JComboBox<String> comboBoxEspecie = new JComboBox<>(opciones);

	JLabel labelNombre = new JLabel("Nombre");
	JTextField textFieldNombre = new JTextField(20);

	// Paneles para el JComboBox y JTextField
	JPanel panelEspecie = new JPanel(new FlowLayout(FlowLayout.LEFT));
	panelEspecie.add(labelEspecie);
	panelEspecie.add(comboBoxEspecie);
	panelEspecie.setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));

	JPanel panelNombre = new JPanel(new FlowLayout(FlowLayout.LEFT));
	panelNombre.add(labelNombre);
	panelNombre.add(textFieldNombre);
	panelNombre.setBorder(BorderFactory.createEmptyBorder(0, 5, 5, 5));

	
	JPanel panelContenedor = new JPanel();
	panelContenedor.setLayout(new BoxLayout(panelContenedor, BoxLayout.Y_AXIS));
	panelContenedor.add(panelEspecie);
	panelContenedor.add(panelNombre);

	// Panel para boton agregar
	JPanel panelBoton = new JPanel(new FlowLayout(FlowLayout.RIGHT));
	JButton botonAgregar = new JButton("Agregar");
	panelBoton.add(botonAgregar);
	//Boton para agregar y cerrar dialog
	botonAgregar.addActionListener(new ActionListener() {
    	public void actionPerformed(ActionEvent e) {
        dialogoAgregar.dispose();
    	}
     });


	// Contenedor princiapal
	JPanel panelPrincipal = new JPanel(new BorderLayout());
	panelPrincipal.add(panelContenedor, BorderLayout.CENTER);
	panelPrincipal.add(panelBoton, BorderLayout.SOUTH);

	dialogoAgregar.add(panelPrincipal);
	dialogoAgregar.setVisible(true);

    } else if (e.getSource() == botonBorrarAnimal) {
        // Acción para borrar un animal
        JOptionPane.showMessageDialog(this, "Funcion borrar animal en construccion.");
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
