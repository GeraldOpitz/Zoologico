public class Animal {
  //Definición de variables
  private String especie;
  private String nombre;
  private int edad;
  private String sexo;
  private String salud;

  //Asignación
  public Animal(String especie, String nombre, int edad, String sexo, String salud) {
    this.especie = especie;
    this.nombre = nombre;
    this.edad = edad;
    this.sexo = sexo;
    this.salud = salud;
    }

  //Getters
  public String getEspecie() {
    return especie;
  }

  public String getNombre() {
    return nombre;
  }

  public int getEdad() {
    return edad;
  }

  public String getSexo() {
    return sexo;
  }

  public String getSalud() {
    return salud;
  }
}
