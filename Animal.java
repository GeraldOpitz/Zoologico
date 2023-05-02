/*
 * Autor: Gerald Opitz
 * Fecha de creación: 18 de abril 2023
 */

public abstract class Animal {
  // Definición de variables
  protected String tipoAnimal;
  protected String especie;
  protected String nombre;
  protected int edadAnios;
  protected String sexo;
  protected String salud;

  // Constructor del objeto
  public Animal(String tipoAnimal, String especie, String nombre, int edadAnios, String sexo, String salud) {
    this.tipoAnimal = tipoAnimal;
    this.especie = especie;
    this.nombre = nombre;
    this.edadAnios = edadAnios;
    this.sexo = sexo;
    this.salud = salud;
  }

  // Getters
  public String getTipoAnimal() {
    return tipoAnimal;
  }
  
  public String getEspecie() {
    return especie;
  }

  public String getNombre() {
    return nombre;
  }

  public int getEdadAnios() {
    return edadAnios;
  }

  public String getSexo() {
    return sexo;
  }

  public String getSalud() {
    return salud;
  }
}
