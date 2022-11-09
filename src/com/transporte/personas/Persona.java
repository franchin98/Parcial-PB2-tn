package com.transporte.personas;

public abstract class Persona {
	private String nombre;
	
	public Persona(String nombre) {
		this.nombre = nombre;
	}

	protected String getNombre() {
		return nombre;
	}

	protected void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	
}
