package com.transporte.vehiculos;

import com.transporte.personas.Chofer;
import com.transporte.personas.Persona;

public abstract class Vehiculo{
	
	private Integer kilometros;
	private Chofer choferDelVehiculo;

	public Vehiculo(Chofer choferDelVehiculo) {
		this.choferDelVehiculo = choferDelVehiculo;
		this.kilometros = 0;
	}

	protected Integer getKilometros() {
		return kilometros;
	}

	protected void setKilometros(Integer kilometros) {
		this.kilometros = kilometros;
	}

	protected Chofer getChoferDelVehiculo() {
		return choferDelVehiculo;
	}
	
	protected void setChoferDelVehiculo(Chofer choferDelVehiculo) {
		this.choferDelVehiculo = choferDelVehiculo;
	}

	public abstract Boolean cambiarChoferDelVehiculo(Chofer choferDelVehiculo);
	
	public abstract Boolean agregarPasajero(Persona nuevoPasajero);

}
