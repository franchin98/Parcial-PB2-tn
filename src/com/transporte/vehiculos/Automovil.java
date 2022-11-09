package com.transporte.vehiculos;

import java.util.LinkedList;

import com.transporte.personas.Chofer;
import com.transporte.personas.Persona;

public class Automovil extends Vehiculo {

	private LinkedList<Persona> pasajerosABordo;

	public Automovil(Chofer choferDelVehiculo) {
		super(choferDelVehiculo);
		setPasajerosABordo(new LinkedList<Persona>());
	}

	@Override
	public Boolean cambiarChoferDelVehiculo(Chofer choferDelVehiculo) {
		return null;
	}

	private void setPasajerosABordo(LinkedList<Persona> pasajerosABordo) {
		this.pasajerosABordo = pasajerosABordo;
	}

	public LinkedList<Persona> getPasajerosABordo() {
		return pasajerosABordo;
	}

	public Boolean agregarPasajero(Persona pasajero) {
		if (getPasajerosABordo().size() < 3) {
			pasajerosABordo.addLast(pasajero);
			return true;
		}
		return false;
	}

}
