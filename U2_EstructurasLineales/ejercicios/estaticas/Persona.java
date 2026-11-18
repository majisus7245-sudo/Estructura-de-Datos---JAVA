package U2_EstructurasLineales.ejercicios.estaticas;

import java.io.Serializable;

public class Persona implements Serializable{
	private String nombre,estado;
	private int edad;
	public Persona(String nombre, String estado, int edad) {
		this.nombre=nombre;
		this.estado=estado;
		this.edad=edad;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getEstado() {
		return estado;
	}
	public void setEstado(String estado) {
		this.estado = estado;
	}
	public int getEdad() {
		return edad;
	}
	public void setEdad(int edad) {
		this.edad = edad;
	}
	public String toString() {
		return nombre;
	}
}
