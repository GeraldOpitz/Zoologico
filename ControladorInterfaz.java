import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.event.*;
import java.util.ArrayList;
import javax.swing.BoxLayout;
import javax.swing.ButtonGroup;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class ControladorInterfaz implements ActionListener {
    private InterfazPrincipal vista;

    public static ArrayList<Animal> listaAnimales = new ArrayList<>();
    public static ArrayList<Animal> listaAnimalesTerrestres = new ArrayList<>();
    public static ArrayList<Animal> listaAnimalesMarinos = new ArrayList<>();
    public static ArrayList<Animal> listaAnimalesAereos = new ArrayList<>();

    public ControladorInterfaz(InterfazPrincipal vista) {
        this.vista = vista;
        ControladorInterfaz.listaAnimales = new ArrayList<>();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == vista.botonAgregarAnimal) {
            // Creación del JDialog
            JDialog dialogoAgregar = new JDialog(vista,"agregar animal",null);
            dialogoAgregar.setSize(400, 300);
            dialogoAgregar.setLocationRelativeTo(null);

            // Datos de animales
            // Animales terrestres
            String[] animalesTerrestres = {
                    "León", "Tigre", "Jirafa", "Elefante", "Rinoceronte", "Cocodrilo", "Hipopótamo",
                    "Oso polar", "Panda", "Leopardo", "Lobo", "Zorro", "Mapache", "Jaguar", "Puma", "Canguro",
                    "Camello", "Mono", "Orangután", "Gorila", "Chimpancé", "Cebra", "Antílope", "Búfalo", "Alce",
                    "Ciervo",
                    "Avestruz"
            };

            // Animales marinos
            String[] animalesMarinos = {
                    "Delfin", "Foca", "Orca", "Ballena", "Pulpo"
            };

            // Animales aéreos
            String[] animalesAereos = {
                    "Flamenco", "Cisne", "Loro", "Búho", "Guacamaya", "Pato", "Pavo real"
            };

            // Radiobuttons para seleccionar el tipo de animal
            JRadioButton radioTerrestre = new JRadioButton("Terrestre");
            JRadioButton radioMarino = new JRadioButton("Marino");
            JRadioButton radioAereo = new JRadioButton("Aéreo");
            radioTerrestre.setSelected(true);

            // Grupo de botones
            ButtonGroup grupoTipo = new ButtonGroup();
            grupoTipo.add(radioTerrestre);
            grupoTipo.add(radioMarino);
            grupoTipo.add(radioAereo);

            // Creación del combobox para especie
            JLabel labelEspecie = new JLabel("Especie");
            DefaultComboBoxModel<String> modeloComboBox = new DefaultComboBoxModel<>(animalesTerrestres);
            JComboBox<String> comboBoxAnimales = new JComboBox<>(modeloComboBox);

            // Clases anonimas las opciones del combobox cambien dependiendo del tipo
            // Tipo terrestre
            radioTerrestre.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    modeloComboBox.removeAllElements();
                    for (String opcion : animalesTerrestres) {
                        modeloComboBox.addElement(opcion);
                    }
                }
            });

            // Tipo marino
            radioMarino.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    modeloComboBox.removeAllElements();
                    for (String opcion : animalesMarinos) {
                        modeloComboBox.addElement(opcion);
                    }
                }
            });

            // Tipo aéreo
            radioAereo.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    modeloComboBox.removeAllElements();
                    for (String opcion : animalesAereos) {
                        modeloComboBox.addElement(opcion);
                    }
                }
            });

            // Campo nombre
            JLabel labelNombre = new JLabel("Nombre");
            JTextField textFieldNombre = new JTextField(10);

            // Campo edad
            JLabel labelEdad = new JLabel("Edad en años");
            JTextField textFieldEdad = new JTextField(3);

            // Campo sexo
            JLabel labelSexo = new JLabel("Sexo");
            String[] sexo = { "Macho", "Hembra" };
            JComboBox<String> comboBoxSexo = new JComboBox<>(sexo);

            // Campo salud
            JLabel labelSalud = new JLabel("Estado de salud");
            JTextArea textAreaSalud = new JTextArea(3, 20);
            textAreaSalud.setLineWrap(true);
            textAreaSalud.setWrapStyleWord(true);
            JScrollPane scrollPane = new JScrollPane(textAreaSalud);

            // Paneles para los datos
            JPanel panelTipo = new JPanel(new FlowLayout(FlowLayout.LEFT));
            panelTipo.add(radioTerrestre);
            panelTipo.add(radioMarino);
            panelTipo.add(radioAereo);

            JPanel panelEspecie = new JPanel(new FlowLayout(FlowLayout.LEFT));
            panelEspecie.add(labelEspecie);
            panelEspecie.add(comboBoxAnimales);

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

            // Panel contenedor de los paneles de los datos
            JPanel panelContenedor = new JPanel();
            panelContenedor.setLayout(new BoxLayout(panelContenedor, BoxLayout.Y_AXIS));
            panelContenedor.add(panelTipo);
            panelContenedor.add(panelEspecie);
            panelContenedor.add(panelNombre);
            panelContenedor.add(panelEdad);
            panelContenedor.add(panelSexo);
            panelContenedor.add(panelSalud);

            // Panel para boton agregar
            JPanel panelBoton = new JPanel(new FlowLayout(FlowLayout.RIGHT));
            JButton botonAgregar = new JButton("Agregar");
            panelBoton.add(botonAgregar);

            // Boton para agregar datos a la tabla
            botonAgregar.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    // Condicional para agregar el tipo de animal en base a lo que este seleccionado
                    // en los radiobuttons
                    String tipoAnimal = "";
                    if (radioTerrestre.isSelected()) {
                        tipoAnimal = "Terrestre";
                    } else if (radioMarino.isSelected()) {
                        tipoAnimal = "Marino";
                    } else if (radioAereo.isSelected()) {
                        tipoAnimal = "Aéreo";
                    }
                    String especie = (String) comboBoxAnimales.getSelectedItem();
                    String nombre = textFieldNombre.getText();
                    // Comprobaciones de que la edad sea un numero entero positivo
                    int edadAnios;
                    try {
                        edadAnios = Integer.parseInt(textFieldEdad.getText());
                        if (edadAnios < 0) {
                            JOptionPane.showMessageDialog(null, "La edad debe ser un número positivo", "Error",
                                    JOptionPane.ERROR_MESSAGE);
                            return;
                        }
                    } catch (NumberFormatException ex) {
                        JOptionPane.showMessageDialog(null, "La edad debe ser un número entero", "Error",
                                JOptionPane.ERROR_MESSAGE);
                        return;
                    }
                    String sexo = (String) comboBoxSexo.getSelectedItem();
                    String salud = textAreaSalud.getText();

                    // Creación de objetos de tipos de animales
                    AnimalTerrestre animalTerrestre = new AnimalTerrestre(tipoAnimal, especie, nombre, edadAnios, sexo,
                            salud);
                    AnimalMarino animalMarino = new AnimalMarino(tipoAnimal, especie, nombre, edadAnios, sexo, salud);
                    AnimalAereo animalAereo = new AnimalAereo(tipoAnimal, especie, nombre, edadAnios, sexo, salud);

                    // Agregar animales a su lista correspondiente
                    listaAnimalesTerrestres.add(animalTerrestre);
                    listaAnimalesMarinos.add(animalMarino);
                    listaAnimalesAereos.add(animalAereo);

                    // Agregación de los objetos a la listaAnimales
                    if (tipoAnimal.equals("Terrestre")) {
                        ControladorInterfaz.listaAnimales.add(animalTerrestre);
                    } else if (tipoAnimal.equals("Marino")) {
                        ControladorInterfaz.listaAnimales.add(animalMarino);
                    } else if (tipoAnimal.equals("Aéreo")) {
                        ControladorInterfaz.listaAnimales.add(animalAereo);
                    }

                    vista.actualizarTabla(listaAnimales);
                    dialogoAgregar.dispose();
                }
            });

            // Contenedor principal
            JPanel panelPrincipal = new JPanel(new BorderLayout());
            panelPrincipal.add(panelContenedor, BorderLayout.CENTER);
            panelPrincipal.add(panelBoton, BorderLayout.SOUTH);

            dialogoAgregar.add(panelPrincipal);
            dialogoAgregar.setVisible(true);

            vista.actualizarTabla(listaAnimales);
        } else if (e.getSource() == vista.botonBorrarAnimal) {
            JOptionPane.showMessageDialog(vista, "En construccion");
        }
    }
    
}
